/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.datos;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


import proyecto2.bank.negocio.MovimientoBancario;

/**
 *
 * @author alumno
 */


public class MovimientoBancarioDAOImplHibernate extends GenericDAOImplHibernate<MovimientoBancario,Integer> implements MovimientoBancarioDAO{

    @Override
    public List<MovimientoBancario> findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT mb FROM MovimientoBancario mb WHERE idmovimientobancario= ?");
        query.setInteger(0, id);
        List<MovimientoBancario> movimientosBancarios = query.list();
        return movimientosBancarios;
    }

    @Override
    public List<MovimientoBancario> findByConcepto(String concepto) {
            Session session = sessionFactory.getCurrentSession();
        List<MovimientoBancario> movimientosBancarios;

        if (concepto == null || concepto.trim().equals("")) {
            movimientosBancarios = findAll();
        } else {
            Query query = session.createQuery("SELECT mb FROM MovimientoBancario mb WHERE concepto LIKE  ?");
            query.setString(0, "%" + concepto + "%");
            movimientosBancarios = query.list();

        }
        return movimientosBancarios;
    }
    }


    

