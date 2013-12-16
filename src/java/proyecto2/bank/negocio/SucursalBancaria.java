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
    
    private int IdSucursalBancaria;
    private String CodigoEntidad;
    private String Nombre;
    private EntidadBancaria entidadBancaria;

    public SucursalBancaria(int IdSucursalBancaria, String CodigoEntidad, String Nombre, EntidadBancaria entidadBancaria) {
        this.IdSucursalBancaria = IdSucursalBancaria;
        this.CodigoEntidad = CodigoEntidad;
        this.Nombre = Nombre;
        this.entidadBancaria = entidadBancaria;
    }

    public SucursalBancaria() {
    }

    public int getIdSucursalBancaria() {
        return IdSucursalBancaria;
    }

    public void setIdSucursalBancaria(int IdSucursalBancaria) {
        this.IdSucursalBancaria = IdSucursalBancaria;
    }

    public String getCodigoEntidad() {
        return CodigoEntidad;
    }

    public void setCodigoEntidad(String CodigoEntidad) {
        this.CodigoEntidad = CodigoEntidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public EntidadBancaria getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(EntidadBancaria entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }
  
    
}
