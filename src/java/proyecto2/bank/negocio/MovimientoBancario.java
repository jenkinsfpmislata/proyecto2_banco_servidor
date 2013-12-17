/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.negocio;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class MovimientoBancario {

    private int idMovimientoBancario;           //La PK del movimiento bancario 
    private TipoMovimientoBancario tipoMovimientoBancario;
    private BigDecimal importe;                           //El importe del movimiento (el dinero) 
    private Date fecha;                             //La fecha del movimiento 
    private BigDecimal saldoTotal;  // El saldo en la cuenta tras efectuar el 
    private String concepto;
    private CuentaBancaria cuentaBancaria;

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
}
