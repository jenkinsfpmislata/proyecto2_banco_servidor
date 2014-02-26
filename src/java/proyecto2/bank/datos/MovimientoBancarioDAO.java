/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.datos;

import java.util.List;
import proyecto2.bank.negocio.CuentaBancaria;
import proyecto2.bank.negocio.MovimientoBancario;

/**
 *
 * @author alumno
 */
public interface MovimientoBancarioDAO extends GenericDAO<MovimientoBancario, Integer> {

    List<MovimientoBancario> findById(int id);

    List<MovimientoBancario> findByConcepto(String concepto);
    
    boolean checkBalance(CuentaBancaria cuentaBancaria);
    
}
