/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.negocio;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class MovimientosBancarios extends ArrayList<MovimientoBancario> {

    @Override
    public boolean add(MovimientoBancario movimientoBancario) {
        BigDecimal resultado = movimientoBancario.getSaldoTotal();
        if (movimientoBancario.getTipoMovimientoBancario().equals(TipoMovimientoBancario.DEBE)) {
            resultado = resultado.add(movimientoBancario.getImporte());
            movimientoBancario.getCuentaBancaria().setSaldo(resultado);
            movimientoBancario.setSaldoTotal(resultado);
        }
        if (movimientoBancario.getTipoMovimientoBancario().equals(TipoMovimientoBancario.HABER)) {
            resultado = resultado.subtract(movimientoBancario.getImporte());
            movimientoBancario.getCuentaBancaria().setSaldo(resultado);
            movimientoBancario.setSaldoTotal(resultado);
        }
        return super.add(movimientoBancario); //To change body of generated methods, choose Tools | Templates.
    }
}
