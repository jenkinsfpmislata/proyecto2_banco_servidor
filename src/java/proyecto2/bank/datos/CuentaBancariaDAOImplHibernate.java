/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.datos;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import proyecto2.bank.negocio.CuentaBancaria;
import proyecto2.bank.negocio.MovimientoBancario;

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

    @Override
    public List<MovimientoBancario> findByMovimiento(int idCuentaBancaria) {
        Session session = sessionFactory.getCurrentSession();
        List<MovimientoBancario> movimientosBancarios;

        if (idCuentaBancaria == 0) {
            movimientosBancarios = null;
        } else {
            Query query = session.createQuery("SELECT mb FROM MovimientoBancario mb WHERE cuentaBancaria LIKE  ?");
            query.setInteger(0, idCuentaBancaria);
            movimientosBancarios = query.list();

        }
        return movimientosBancarios;
    }

    @Override
    public List<CuentaBancaria> findByCliente(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT cb FROM CuentaBancaria cb WHERE idCliente= ?");
        query.setInteger(0, id);
        List<CuentaBancaria> cuentasBancarias = query.list();
        return cuentasBancarias;
    }

    @Override
    public CuentaBancaria findByCodigoCuentaCliente(String codigoCuentaCliente) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT cb FROM CuentaBancaria cb WHERE cuentaBancaria.sucursalBancaria.codigoSucursal=? AND cuentaBancaria.sucursalBancaria.entidadBancaria.codigoEntidadBancaria=? AND cuentaBancaria.dc=? AND cuentaBancaria.numeroCuenta=?");

        query.setString(0, codigoCuentaCliente.substring(0, 4));
        query.setString(1, codigoCuentaCliente.substring(4, 8));
        query.setString(2, codigoCuentaCliente.substring(8, 10));
        query.setString(3, codigoCuentaCliente.substring(10, 20));

        List<CuentaBancaria> cuentasBancarias = query.list();

        if (cuentasBancarias != null) {
            if (cuentasBancarias.size() == 1) {
                CuentaBancaria cuentaBancaria = cuentasBancarias.get(0);
                return cuentaBancaria;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
