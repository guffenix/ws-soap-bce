/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqui.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author guffenix
 */
@Entity
@Table(name = "ASIGNAR_TRANSACCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignarTransaccion.findAll", query = "SELECT a FROM AsignarTransaccion a")
    , @NamedQuery(name = "AsignarTransaccion.findByAsitraId", query = "SELECT a FROM AsignarTransaccion a WHERE a.asitraId = :asitraId")
    , @NamedQuery(name = "AsignarTransaccion.findByAsitraIdentificador", query = "SELECT a FROM AsignarTransaccion a WHERE a.asitraIdentificador = :asitraIdentificador")
    , @NamedQuery(name = "AsignarTransaccion.findByAsitraFechauso", query = "SELECT a FROM AsignarTransaccion a WHERE a.asitraFechauso = :asitraFechauso")
    , @NamedQuery(name = "AsignarTransaccion.findByAsitraMonto", query = "SELECT a FROM AsignarTransaccion a WHERE a.asitraMonto = :asitraMonto")
    , @NamedQuery(name = "AsignarTransaccion.findByAsitraEstado", query = "SELECT a FROM AsignarTransaccion a WHERE a.asitraEstado = :asitraEstado")})
public class AsignarTransaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ASITRA_ID")
    private Integer asitraId;
    @Size(max = 128)
    @Column(name = "ASITRA_IDENTIFICADOR")
    private String asitraIdentificador;
    @Column(name = "ASITRA_FECHAUSO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asitraFechauso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ASITRA_MONTO")
    private BigDecimal asitraMonto;
    @Column(name = "ASITRA_ESTADO")
    private Integer asitraEstado;
    @JoinColumn(name = "IFINUSR_ID", referencedColumnName = "IFINUSR_ID")
    @ManyToOne
    private AsignarIfinUsr ifinusrId;
    @JoinColumn(name = "TRA_ID", referencedColumnName = "TRA_ID")
    @ManyToOne
    private TipoTransaccion traId;
    @JoinColumn(name = "USR_IDENTIFICACION", referencedColumnName = "USR_IDENTIFICACION")
    @ManyToOne
    private Usuario usrIdentificacion;

    public AsignarTransaccion() {
    }

    public AsignarTransaccion(Integer asitraId) {
        this.asitraId = asitraId;
    }

    public Integer getAsitraId() {
        return asitraId;
    }

    public void setAsitraId(Integer asitraId) {
        this.asitraId = asitraId;
    }

    public String getAsitraIdentificador() {
        return asitraIdentificador;
    }

    public void setAsitraIdentificador(String asitraIdentificador) {
        this.asitraIdentificador = asitraIdentificador;
    }

    public Date getAsitraFechauso() {
        return asitraFechauso;
    }

    public void setAsitraFechauso(Date asitraFechauso) {
        this.asitraFechauso = asitraFechauso;
    }

    public BigDecimal getAsitraMonto() {
        return asitraMonto;
    }

    public void setAsitraMonto(BigDecimal asitraMonto) {
        this.asitraMonto = asitraMonto;
    }

    public Integer getAsitraEstado() {
        return asitraEstado;
    }

    public void setAsitraEstado(Integer asitraEstado) {
        this.asitraEstado = asitraEstado;
    }

    public AsignarIfinUsr getIfinusrId() {
        return ifinusrId;
    }

    public void setIfinusrId(AsignarIfinUsr ifinusrId) {
        this.ifinusrId = ifinusrId;
    }

    public TipoTransaccion getTraId() {
        return traId;
    }

    public void setTraId(TipoTransaccion traId) {
        this.traId = traId;
    }

    public Usuario getUsrIdentificacion() {
        return usrIdentificacion;
    }

    public void setUsrIdentificacion(Usuario usrIdentificacion) {
        this.usrIdentificacion = usrIdentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asitraId != null ? asitraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignarTransaccion)) {
            return false;
        }
        AsignarTransaccion other = (AsignarTransaccion) object;
        if ((this.asitraId == null && other.asitraId != null) || (this.asitraId != null && !this.asitraId.equals(other.asitraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arqui.modelo.AsignarTransaccion[ asitraId=" + asitraId + " ]";
    }
    
}
