/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.negocio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class CuentaBancaria {

    private int idCuentaBancaria;
    private SucursalBancaria sucursalBancaria;
    private int numeroCuenta;
    private int dc; //El dígito de control de la cuenta bancaria 
    private BigDecimal saldo; //El saldo de la cuenta.Es decir cuanto dinero hay en la cuenta 
    private String cif;
    private List<MovimientoBancario> listaMovimiento = new ArrayList<>();

    public CuentaBancaria() {
    }

    public CuentaBancaria(int idCuentaBancaria, SucursalBancaria sucursalBancaria, int numeroCuenta, int dc, BigDecimal saldo, String cif) {
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

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getDc() {
        return dc;
    }

    public void setDc(int dc) {
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
