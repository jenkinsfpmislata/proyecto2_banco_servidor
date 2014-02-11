/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.datos;

import proyecto2.bank.negocio.Cliente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author alumno
 */
public interface ClienteDAO extends GenericDAO<Cliente, Integer> {
    
    public Cliente readByLogin(String login);
    
    
    
    
}
