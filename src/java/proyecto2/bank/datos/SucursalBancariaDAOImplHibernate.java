/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.datos;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import proyecto2.bank.negocio.SucursalBancaria;

/**
 *
 * @author alumno
 */
public class SucursalBancariaDAOImplHibernate extends GenericDAOImplHibernate<SucursalBancaria, Integer> implements SucursalBancariaDAO {

    @Override
    public List<SucursalBancaria> findByCodigo(String codigoSucursal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT sb FROM SucursalBancaria sb where codigoSucursal= ?");
        query.setString(0, codigoSucursal);
        List<SucursalBancaria> listaporCodigo = query.list();

        return listaporCodigo;
    }

    @Override
    public List<SucursalBancaria> findByNombre(String Nombre) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT sb FROM SucursalBancaria sb where nombre like ?");
        query.setString(0, "%" + Nombre + "%");
        List<SucursalBancaria> listaporNombre = query.list();
        if ((Nombre == null) || (Nombre.trim().equals(""))) {
            listaporNombre = findAll();

        }

        return listaporNombre;
    }
}
