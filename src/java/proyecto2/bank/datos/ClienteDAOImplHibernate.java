/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.datos;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import proyecto2.bank.negocio.Cliente;

/**
 *
 * @author alumno
 */
public class ClienteDAOImplHibernate extends GenericDAOImplHibernate<Cliente, Integer> implements ClienteDAO {

    @Override
    public List<Cliente> findbyDni(String dni) {
         if (dni  == null || dni.equals("")) {
            return findAll();
        } else {
               Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("Select cl from Cliente cl  where dni LIKE ?");
            query.setString(0, dni + "%");
            List<Cliente> objectList = query.list();
            session.getTransaction().commit();
            return objectList;
         }
    }
    
}
