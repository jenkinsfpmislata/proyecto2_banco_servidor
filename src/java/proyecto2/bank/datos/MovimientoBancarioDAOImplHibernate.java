/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.datos;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import proyecto2.bank.negocio.MovimientoBancario;
import proyecto2.bank.negocio.TipoMovimientoBancario;

/**
 *
 * @author alumno
 */
public class MovimientoBancarioDAOImplHibernate extends GenericDAOImplHibernate<MovimientoBancario, Integer> implements MovimientoBancarioDAO {

    @Override
    public List<MovimientoBancario> findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT mb FROM MovimientoBancario mb WHERE idmovimientobancario =?");
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

    @Override
    public void insert(MovimientoBancario movimientoBancario) {

        BigDecimal saldo = movimientoBancario.getCuentaBancaria().getSaldo();
        BigDecimal importe = movimientoBancario.getImporte();

        BigDecimal newSaldo;

        switch (movimientoBancario.getTipoMovimientoBancario()) {
            case DEBE:
                newSaldo = saldo.subtract(importe);
                break;
            case HABER:
                newSaldo = saldo.add(importe);
                break;
            default:
                throw new RuntimeException("ERROR: Tipo de movimiento " + movimientoBancario.getTipoMovimientoBancario() + " no reconocido");
        }

        movimientoBancario.getCuentaBancaria().setSaldo(newSaldo);
        movimientoBancario.setSaldoTotal(newSaldo);

        super.insert(movimientoBancario);
    }
}
