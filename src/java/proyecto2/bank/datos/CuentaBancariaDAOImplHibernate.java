/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.datos;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import proyecto2.bank.negocio.CuentaBancaria;

/**
 *
 * @author alumno
 */
public class CuentaBancariaDAOImplHibernate extends GenericDAOImplHibernate<CuentaBancaria, Integer> implements CuentaBancariaDAO {

    @Override
    public List<CuentaBancaria> findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT cb FROM CuentaBancaria cb WHERE idcuentabancaria= ?");
        query.setInteger(0, id);
        List<CuentaBancaria> cuentasBancarias = query.list();
        return cuentasBancarias;
    }

    @Override
    public List<CuentaBancaria> findByNumero(String numeroCuenta) {
        Session session = sessionFactory.getCurrentSession();
        List<CuentaBancaria> cuentasBancarias;

        if (numeroCuenta == null || numeroCuenta.trim().equals("")) {
            cuentasBancarias = findAll();
        } else {
            Query query = session.createQuery("SELECT cb FROM CuentaBancaria cb WHERE numeroCuenta LIKE ?");
            query.setString(0, "%" + numeroCuenta + "%");
            cuentasBancarias = query.list();

        }
        return cuentasBancarias;
    }
}
