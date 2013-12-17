/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.datos;

import java.util.List;
import proyecto2.bank.negocio.SucursalBancaria;

/**
 *
 * @author alumno
 */
public interface SucursalBancariaDAO extends GenericDAO<SucursalBancaria, Integer> {
    
    List<SucursalBancaria> findByCodigo(String codigoSucursal);
    
    List<SucursalBancaria> findByNombre(String Nombre);
    
}
