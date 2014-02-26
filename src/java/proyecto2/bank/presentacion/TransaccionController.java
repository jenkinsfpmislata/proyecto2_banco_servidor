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

import proyecto2.bank.negocio.MovimientoBancario;
import proyecto2.bank.negocio.TipoMovimientoBancario;

/**
 *
 * @author alumno
 */
@Controller
public class TransaccionController {

    @Autowired
    MovimientoBancarioDAO movimientoBancarioDAO;
    CuentaBancariaDAO cuentaBancariaDAO;

    @RequestMapping(value = {"/Transaccion"}, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void transaccion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            
            // JSON {"user":"Patata","password":1234, "cuentaBancariaTienda":"1542545","cuentaBancariaCliente":"1542545", "importe":152.05}
            String[] transaccion = json.split(",");
            
            String usuario = transaccion[0];
            String password = transaccion[1];

            
            MovimientoBancario movimientoBancario = null;
            movimientoBancario.setTipoMovimientoBancario(TipoMovimientoBancario.HABER);
            movimientoBancario.setImporte(new BigDecimal(transaccion[4]));
            movimientoBancario.setFecha(new Date());
            movimientoBancario.setConcepto("TRANSFERENCIA -- Cuenta origen:"+transaccion[3]);

            
            
            
        } catch (RuntimeException runtimeException) {
        }

    }
}
