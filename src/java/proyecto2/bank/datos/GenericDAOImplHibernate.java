/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.datos;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alumno
 */
public class GenericDAOImplHibernate<T, ID extends Serializable> implements GenericDAO<T, ID> {
    
    protected SessionFactory sessionFactory;
    
    public GenericDAOImplHibernate(){
        this.sessionFactory=HibernateUtil.getSessionFactory();
    }
    

    @Override
    public T read(ID id) {
         Session session=sessionFactory.getCurrentSession();
       T tipo=(T) session.get(getEntityClass(),id);
      
       return tipo;
       
    }

    @Override
    public void insert(T tipo) {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(tipo);
        session.getTransaction().commit();
    }

    @Override
    public void update(T tipo) {
      Session session=sessionFactory.getCurrentSession();
      session.beginTransaction();
      session.update(tipo);
      session.getTransaction().commit();
    }

    @Override
    public void delete(ID id) {
      Session session=sessionFactory.getCurrentSession();
      session.beginTransaction();
      T tipo=(T)session.get(getEntityClass(),id);
      session.delete(tipo);
      session.getTransaction().commit();
    }

    @Override
    public List<T> findAll() {
          Session session=sessionFactory.getCurrentSession();
          Query query = session.createQuery("SELECT t FROM " +getEntityClass().getName()+" t");
          List<T> lista = query.list();
           for (T t : lista) {
            System.out.println(t.toString());
}
         
      return lista;
    }
    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
   }
    
}
