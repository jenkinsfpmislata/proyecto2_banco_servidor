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
import proyecto2.bank.datos.MovimientoBancarioDAO;
import proyecto2.bank.negocio.MovimientoBancario;

/**
 *
 * @author alumno
 */
@Controller
public class MovimientoBancarioController {

    @Autowired
    MovimientoBancarioDAO movimientoBancarioDAO;

    @RequestMapping(value = {"/MovimientoBancario/{idMovimientoBancario}"}, method = RequestMethod.GET, produces = "application/json")
    public void read(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idMovimientoBancario") int idMovimientoBancario) {
        try {
            MovimientoBancario movimientoBancario = movimientoBancarioDAO.read(idMovimientoBancario);
            noCache(httpServletResponse);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(httpServletResponse.SC_OK);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(movimientoBancario);
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

    @RequestMapping(value = {"/MovimientoBancario"}, method = RequestMethod.GET, produces = "application/json")
    public void find(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            List<MovimientoBancario> movimientosBancarios = null;
            String concepto = httpServletRequest.getParameter("conceptoMovimiento");
            if (concepto != null) {
                movimientosBancarios = movimientoBancarioDAO.findByConcepto(concepto);
            } else {
                movimientosBancarios = movimientoBancarioDAO.findAll();
            }
            noCache(httpServletResponse);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(httpServletResponse.SC_OK);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(movimientosBancarios);
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

    @RequestMapping(value = {"/MovimientoBancario"}, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            MovimientoBancario movimientoBancario = (MovimientoBancario) objectMapper.readValue(json, MovimientoBancario.class);
            movimientoBancarioDAO.insert(movimientoBancario);
            noCache(httpServletResponse);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            json = objectMapper.writeValueAsString(movimientoBancario);
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

    private void noCache(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Cache-Control", "no-cache");
    }
}
