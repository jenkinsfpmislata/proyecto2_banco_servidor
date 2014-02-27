/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.presentacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.math.BigDecimal;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proyecto2.bank.datos.CuentaBancariaDAO;
import proyecto2.bank.datos.MovimientoBancarioDAO;
import proyecto2.bank.negocio.CuentaBancaria;
import proyecto2.bank.negocio.MovimientoBancario;
import proyecto2.bank.negocio.TipoMovimientoBancario;

/**
 *
 * @author Administrador
 */
@Controller
public class CreditoController {

    @Autowired
    MovimientoBancarioDAO movimientoBancarioDAO;
    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;

    @RequestMapping(value = {"/Credito"}, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void credito(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {

            Credito credito = (Credito) objectMapper.readValue(json, Credito.class);


            BigDecimal cantidadCredito = credito.getImporte();
            String numeroCuenta = credito.getCuentaBancaria();
            CuentaBancaria cuentaBancaria = cuentaBancariaDAO.findByCodigoCuentaCliente(numeroCuenta);

            if (movimientoBancarioDAO.checkBalance(cuentaBancaria)) {
                System.out.println(cuentaBancaria.getNumeroCuenta() + "sadadasdsadsada");
                MovimientoBancario movimientoBancario = new MovimientoBancario();
                movimientoBancario.setCuentaBancaria(cuentaBancaria);
                movimientoBancario.setConcepto("Credito bancario de " + cantidadCredito);
                movimientoBancario.setFecha(new Date());
                movimientoBancario.setImporte(cantidadCredito);
                movimientoBancario.setTipoMovimientoBancario(TipoMovimientoBancario.HABER);

                movimientoBancarioDAO.insert(movimientoBancario);

                httpServletResponse.setContentType("application/json; charset=UTF-8");
                json = objectMapper.writeValueAsString(movimientoBancario);
                httpServletResponse.getWriter().println(json);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
