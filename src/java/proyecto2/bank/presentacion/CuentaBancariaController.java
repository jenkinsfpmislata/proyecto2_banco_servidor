package proyecto2.bank.presentacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proyecto2.bank.datos.BussinessMessage;
import proyecto2.bank.datos.CuentaBancariaDAO;
import proyecto2.bank.negocio.CuentaBancaria;

@Controller
public class CuentaBancariaController {

    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;

    @RequestMapping(value = {"/CuentaBancaria/{idCuentaBancaria}"}, method = RequestMethod.GET, produces = "application/json")
    public void read(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idCuentaBancaria") int idCuentaBancaria) {
        try {
            CuentaBancaria cuentaBancaria = cuentaBancariaDAO.read(idCuentaBancaria);
            noCache(httpServletResponse);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(httpServletResponse.SC_OK);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(cuentaBancaria);
            httpServletResponse.getWriter().println(json);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            noCache(httpServletResponse);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }
    }

    @RequestMapping(value = {"/CuentaBancaria/{idCuentaBancaria}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idCuentaBancaria") int idCuentaBancaria) {
        try {
            cuentaBancariaDAO.delete(idCuentaBancaria);
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            noCache(httpServletResponse);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }

    }

    @RequestMapping(value = {"/CuentaBancaria"}, method = RequestMethod.GET, produces = "application/json")
    public void find(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            List<CuentaBancaria> cuentasBancarias = null;
            int numeroCuentaBancaria =Integer.parseInt( httpServletRequest.getParameter("numeroCuentaBancaria"));
            if (numeroCuentaBancaria != 0) {
                cuentasBancarias = cuentaBancariaDAO.findByNumero(numeroCuentaBancaria);
            } else {
                cuentasBancarias = cuentaBancariaDAO.findAll();
            }
            noCache(httpServletResponse);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(httpServletResponse.SC_OK);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(cuentasBancarias);
            httpServletResponse.getWriter().println(json);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            noCache(httpServletResponse);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }
    }

    @RequestMapping(value = {"/CuentaBancaria"}, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            CuentaBancaria cuentaBancaria = (CuentaBancaria) objectMapper.readValue(json, CuentaBancaria.class);
            cuentaBancariaDAO.insert(cuentaBancaria);
            noCache(httpServletResponse);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            json = objectMapper.writeValueAsString(cuentaBancaria);
            httpServletResponse.getWriter().println(json);

        } catch (ConstraintViolationException cve) {
            List<BussinessMessage> listaBussinessMessages = new ArrayList<>();
            for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
                BussinessMessage bussinessMessage = new BussinessMessage(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
                listaBussinessMessages.add(bussinessMessage);
            }
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            noCache(httpServletResponse);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            json = objectMapper.writeValueAsString(listaBussinessMessages);
            try {
                httpServletResponse.getWriter().println(json);
            } catch (IOException ex) {
            }
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            noCache(httpServletResponse);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }
    }

    @RequestMapping(value = {"/CuentaBancaria/{idCuentaBancaria}"}, method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idCuentaBancaria") int idCuentaBancaria, @RequestBody String json) {
        try {
            CuentaBancaria cuentaBancaria = cuentaBancariaDAO.read(idCuentaBancaria);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            CuentaBancaria cuentaBancariaActualizada = (CuentaBancaria) objectMapper.readValue(json, CuentaBancaria.class);

            cuentaBancaria.setIdCuentaBancaria(cuentaBancariaActualizada.getIdCuentaBancaria());
            cuentaBancaria.setNumeroCuenta(cuentaBancariaActualizada.getNumeroCuenta());
            cuentaBancaria.setDc(cuentaBancariaActualizada.getDc());
            cuentaBancaria.setCif(cuentaBancariaActualizada.getCif());

            cuentaBancariaDAO.update(cuentaBancaria);
            noCache(httpServletResponse);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(httpServletResponse.SC_OK);

            json = objectMapper.writeValueAsString(cuentaBancaria);
            httpServletResponse.getWriter().println(json);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }
    }

    private void noCache(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Cache-Control", "no-cache");
    }
}
