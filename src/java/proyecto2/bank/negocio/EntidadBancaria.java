/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.negocio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class EntidadBancaria  implements Serializable{

    private int idEntidadBancaria;
    private String codigoEntidadBancaria;
    private String nombreEntidadBancaria;
    private String cifEntidadBancaria;
    private TipoEntidadBancaria tipoEntidadBancaria;
    private List<SucursalBancaria> sucursalesBancarias = new ArrayList<>();

    public EntidadBancaria() {
    }

    public EntidadBancaria(int idEntidadBancaria, String codigoEntidadBancaria, String nombreEntidadBancaria, String cifEntidadBancaria, TipoEntidadBancaria tipoEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
        this.codigoEntidadBancaria = codigoEntidadBancaria;
        this.nombreEntidadBancaria = nombreEntidadBancaria;
        this.cifEntidadBancaria = cifEntidadBancaria;
        this.tipoEntidadBancaria = tipoEntidadBancaria;
    }

    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }

    public String getCodigoEntidadBancaria() {
        return codigoEntidadBancaria;
    }

    public void setCodigoEntidadBancaria(String codigoEntidadBancaria) {
        this.codigoEntidadBancaria = codigoEntidadBancaria;
    }

    public String getNombreEntidadBancaria() {
        return nombreEntidadBancaria;
    }

    public void setNombreEntidadBancaria(String nombreEntidadBancaria) {
        this.nombreEntidadBancaria = nombreEntidadBancaria;
    }

    public String getCifEntidadBancaria() {
        return cifEntidadBancaria;
    }

    public void setCifEntidadBancaria(String cifEntidadBancaria) {
        this.cifEntidadBancaria = cifEntidadBancaria;
    }

    public TipoEntidadBancaria getTipoEntidadBancaria() {
        return tipoEntidadBancaria;
    }

    public void setTipoEntidadBancaria(TipoEntidadBancaria tipoEntidadBancaria) {
        this.tipoEntidadBancaria = tipoEntidadBancaria;
    }

    public List<SucursalBancaria> getSucursalesBancarias() {
        return sucursalesBancarias;
    }

    public void setSucursalesBancarias(List<SucursalBancaria> sucursalesBancarias) {
        this.sucursalesBancarias = sucursalesBancarias;
    }
    
    
}
