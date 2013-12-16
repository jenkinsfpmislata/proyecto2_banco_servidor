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
    private String codigoSucursalBancaria;
    private String nombreSucursalBancaria;
    private EntidadBancaria entidadBancaria;

    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }

    public String getCodigoSucursalBancaria() {
        return codigoSucursalBancaria;
    }

    public void setCodigoSucursalBancaria(String codigoSucursalBancaria) {
        this.codigoSucursalBancaria = codigoSucursalBancaria;
    }

    public String getNombreSucursalBancaria() {
        return nombreSucursalBancaria;
    }

    public void setNombreSucursalBancaria(String nombreSucursalBancaria) {
        this.nombreSucursalBancaria = nombreSucursalBancaria;
    }

    public EntidadBancaria getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(EntidadBancaria entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }

    public SucursalBancaria() {
    }

    public SucursalBancaria(int idSucursalBancaria, String codigoSucursalBancaria, String nombreSucursalBancaria, EntidadBancaria entidadBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.codigoSucursalBancaria = codigoSucursalBancaria;
        this.nombreSucursalBancaria = nombreSucursalBancaria;
        this.entidadBancaria = entidadBancaria;
    }

   

   
  
    
}
