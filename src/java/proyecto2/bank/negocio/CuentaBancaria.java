/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.negocio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CuentaBancaria  implements Serializable{

    private int idCuentaBancaria;
    private SucursalBancaria sucursalBancaria;
    private String numeroCuenta;
    private String dc; //El dígito de control de la cuenta bancaria 
    private BigDecimal saldo; //El saldo de la cuenta.Es decir cuanto dinero hay en la cuenta 
    private String cif;
    private List<MovimientoBancario> listaMovimiento = new ArrayList<>();

    public CuentaBancaria() {
    }

    public CuentaBancaria(int idCuentaBancaria, SucursalBancaria sucursalBancaria, String numeroCuenta, String dc, BigDecimal saldo, String cif) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.sucursalBancaria = sucursalBancaria;
        this.numeroCuenta = numeroCuenta;
        this.dc = dc;
        this.saldo = saldo;
        this.cif = cif;
    }
    

    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public SucursalBancaria getSucursalBancaria() {
        return sucursalBancaria;
    }

    public void setSucursalBancaria(SucursalBancaria sucursalBancaria) {
        this.sucursalBancaria = sucursalBancaria;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public List<MovimientoBancario> getListaMovimiento() {
        return listaMovimiento;
    }

    public void setListaMovimiento(List<MovimientoBancario> listaMovimiento) {
        this.listaMovimiento = listaMovimiento;
    }
}
