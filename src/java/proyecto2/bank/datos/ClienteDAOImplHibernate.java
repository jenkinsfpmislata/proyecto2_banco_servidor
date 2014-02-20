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
    public Cliente readByLogin(String login, String password) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT cliente FROM Cliente cliente WHERE login = ? and password = ?");
        query.setString(0, login);
        query.setString(1, password);

        List<Cliente> loginList = query.list();
        if (loginList.isEmpty()) {
            return null;
        } else {
            if (loginList.size() == 1) {
                Cliente cliente = loginList.get(0);
                return cliente;
            } else {
                return null;
            }
        }
    }
}
