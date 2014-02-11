/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.negocio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class MovimientoBancario implements Serializable {
    private int idMovimientoBancario;
    private TipoMovimientoBancario tipoMovimientoBancario;
    private BigDecimal importe;
    private Date fecha;
    private BigDecimal saldoTotal;
    private String concepto;
    private CuentaBancaria cuentaBancaria;

    public MovimientoBancario() {
    }

    public MovimientoBancario(int idMovimientoBancario, TipoMovimientoBancario tipoMovimientoBancario, BigDecimal importe, Date fecha, BigDecimal saldoTotal, String concepto, CuentaBancaria cuentaBancaria) {
        this.idMovimientoBancario = idMovimientoBancario;
        this.tipoMovimientoBancario = tipoMovimientoBancario;
        this.importe = importe;
        this.fecha = fecha;
        this.saldoTotal = saldoTotal;
        this.concepto = concepto;
        this.cuentaBancaria = cuentaBancaria;
        
        
    }

    public int getIdMovimientoBancario() {
        return idMovimientoBancario;
    }

    public void setIdMovimientoBancario(int idMovimientoBancario) {
        this.idMovimientoBancario = idMovimientoBancario;
    }

    public TipoMovimientoBancario getTipoMovimientoBancario() {
        return tipoMovimientoBancario;
    }

    public void setTipoMovimientoBancario(TipoMovimientoBancario tipoMovimientoBancario) {
        this.tipoMovimientoBancario = tipoMovimientoBancario;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(BigDecimal saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
    
    
    
    
}
