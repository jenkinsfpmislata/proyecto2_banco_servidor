/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.presentacion;

import java.math.BigDecimal;

/**
 *
 * @author Administrador
 */
public class Credito {
    
    private String cuentaBancaria;
    private BigDecimal importe;

    public Credito() {
    }

    public Credito(String cuentaBancaria, BigDecimal importe) {
        this.cuentaBancaria = cuentaBancaria;
        this.importe = importe;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }
    
    
    
    
}
