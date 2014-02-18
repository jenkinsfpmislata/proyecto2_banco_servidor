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
public interface CuentaBancariaDAO extends GenericDAO<CuentaBancaria, Integer> {

    List<CuentaBancaria> findById(int id);
    
    List<CuentaBancaria> findByCliente(int id);

    List<CuentaBancaria> findByNumero(String numeroCuenta);
    
    List<MovimientoBancario> findByMovimiento(int idCuentaBancaria);
}
