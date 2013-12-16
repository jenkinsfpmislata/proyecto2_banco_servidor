/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class SucursalBancaria {
    
    private int idSucursalBancaria;
    private String codigoEntidad;
    private String nombre;
    private EntidadBancaria entidadBancaria;

    public SucursalBancaria(int IdSucursalBancaria, String CodigoEntidad, String Nombre, EntidadBancaria entidadBancaria) {
        this.idSucursalBancaria = IdSucursalBancaria;
        this.codigoEntidad = CodigoEntidad;
        this.nombre = Nombre;
        this.entidadBancaria = entidadBancaria;
    }

    public SucursalBancaria() {
    }

    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public void setIdSucursalBancaria(int IdSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String CodigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public EntidadBancaria getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(EntidadBancaria entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }
  
    
}
