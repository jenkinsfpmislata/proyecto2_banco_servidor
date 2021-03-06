/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.datos;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import proyecto2.bank.negocio.EntidadBancaria;
import proyecto2.bank.negocio.SucursalBancaria;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAOImplHibernate extends GenericDAOImplHibernate<EntidadBancaria, Integer> implements EntidadBancariaDAO {

    @Override
    public List<EntidadBancaria> findByCodigo(String codigo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT eb FROM EntidadBancaria eb WHERE codigoEntidad= ?");
        query.setString(0, codigo);
        List<EntidadBancaria> entidadesBancarias = query.list();
        return entidadesBancarias;
    }

    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
        Session session = sessionFactory.getCurrentSession();
        List<EntidadBancaria> entidadesBancarias;

        if (nombre == null || nombre.trim().equals("")) {
            entidadesBancarias = findAll();
        } else {
            Query query = session.createQuery("SELECT eb FROM EntidadBancaria eb WHERE nombre LIKE  ?");
            query.setString(0, "%" + nombre + "%");
            entidadesBancarias = query.list();

        }
        return entidadesBancarias;
    }

    @Override
    public List<SucursalBancaria> findBySucursal(int idEntidadBancaria) {
        Session session = sessionFactory.getCurrentSession();
        List<SucursalBancaria> sucursalesBancarias;

        if (idEntidadBancaria == 0) {
            sucursalesBancarias = null;
        } else {
            Query query = session.createQuery("SELECT sb FROM SucursalBancaria sb WHERE entidadBancaria LIKE  ?");
            query.setInteger(0, idEntidadBancaria);
            sucursalesBancarias = query.list();

        }
        return sucursalesBancarias;
    }
}
