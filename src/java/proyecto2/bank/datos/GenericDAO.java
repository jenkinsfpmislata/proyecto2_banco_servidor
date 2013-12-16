/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.datos;

import java.util.List;

/**
 *
 * @author alumno
 */
public interface GenericDAO<T, ID> {

    T read(ID id);

    void insert(T tipo);

    void update(T tipo);

    void delete(ID id);

    List<T> findAll();
}
