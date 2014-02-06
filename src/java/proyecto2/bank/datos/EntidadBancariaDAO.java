/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.datos;

import java.util.List;
import proyecto2.bank.negocio.EntidadBancaria;
import proyecto2.bank.negocio.SucursalBancaria;

/**
 *
 * @author alumno
 */
public interface EntidadBancariaDAO extends GenericDAO<EntidadBancaria, Integer> {

    List<EntidadBancaria> findByCodigo(String codigo);

    List<EntidadBancaria> findByNombre(String nombre);
    
    List<SucursalBancaria> findBySucursal(int idEntidadBancaria);
    
}
