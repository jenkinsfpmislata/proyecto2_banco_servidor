/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import proyecto2.bank.datos.SucursalBancariaDAO;
import proyecto2.bank.negocio.SucursalBancaria;

@Controller
public class SucursalesBancariasController {
    
    @Autowired
    SucursalBancariaDAO sucursalBancariaDAO;
    
    @RequestMapping(value = {"/SucursalBancaria/{idSucursalBancaria}"}, method = RequestMethod.GET, produces = "application/json")
    public void read(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        try {
            SucursalBancaria sucursalBancaria = sucursalBancariaDAO.read(idSucursalBancaria);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(httpServletResponse.SC_OK);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(sucursalBancaria);
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
    
    @RequestMapping(value = {"/SucursalBancaria/{idSucursalBancaria}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        try {
            sucursalBancariaDAO.delete(idSucursalBancaria);
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }

    }
    
    @RequestMapping(value = {"/SucursalBancaria"}, method = RequestMethod.GET, produces = "application/json")
    public void find(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            List<SucursalBancaria> sucursalesBancarias = null;
            String nombreSucursalBancaria = httpServletRequest.getParameter("nombreSucursalBancaria");
            if (nombreSucursalBancaria != null) {
                sucursalesBancarias = sucursalBancariaDAO.findByNombre(nombreSucursalBancaria);
            } else {
                sucursalesBancarias = sucursalBancariaDAO.findAll();
            }
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(httpServletResponse.SC_OK);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(sucursalesBancarias);
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
    
    @RequestMapping(value = {"/SucursalBancaria"}, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            SucursalBancaria sucursalBancaria = (SucursalBancaria) objectMapper.readValue(json, SucursalBancaria.class);
            sucursalBancariaDAO.insert(sucursalBancaria);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            json = objectMapper.writeValueAsString(sucursalBancaria);
            httpServletResponse.getWriter().println(json);

        } catch (ConstraintViolationException cve) {
            List<BussinessMessage> listaBussinessMessages = new ArrayList<>();
            for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
                BussinessMessage bussinessMessage = new BussinessMessage(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
                listaBussinessMessages.add(bussinessMessage);
            }
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            json = objectMapper.writeValueAsString(listaBussinessMessages);
            try {
                httpServletResponse.getWriter().println(json);
            } catch (IOException ex) {
            }
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }

    }
    
     @RequestMapping(value = {"/SucursalBancaria/{idSucursalBancaria}"}, method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idSucursalBancaria") int idSucursalBancaria, @RequestBody String json) {
        try {
            SucursalBancaria sucursalBancaria = sucursalBancariaDAO.read(idSucursalBancaria);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            SucursalBancaria sucursalBancariaActualizada = (SucursalBancaria) objectMapper.readValue(json, SucursalBancaria.class);

            sucursalBancaria.setCodigoSucursalBancaria(sucursalBancariaActualizada.getCodigoSucursalBancaria());
            sucursalBancaria.setNombreSucursalBancaria(sucursalBancariaActualizada.getNombreSucursalBancaria());
            sucursalBancaria.setIdSucursalBancaria(sucursalBancariaActualizada.getIdSucursalBancaria());
            sucursalBancaria.setEntidadBancaria(sucursalBancariaActualizada.getEntidadBancaria());

            sucursalBancariaDAO.update(sucursalBancaria);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(httpServletResponse.SC_OK);

            json = objectMapper.writeValueAsString(sucursalBancaria);
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
     private void noCache(HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Cache-Control", "no-cache");
    }
    
}
