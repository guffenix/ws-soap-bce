/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqui.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author guffenix
 */
@Entity
@Table(name = "ASIGNAR_IFIN_USR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignarIfinUsr.findAll", query = "SELECT a FROM AsignarIfinUsr a")
    , @NamedQuery(name = "AsignarIfinUsr.findByIfinusrId", query = "SELECT a FROM AsignarIfinUsr a WHERE a.ifinusrId = :ifinusrId")
    , @NamedQuery(name = "AsignarIfinUsr.findByIfinusrNumerocuenta", query = "SELECT a FROM AsignarIfinUsr a WHERE a.ifinusrNumerocuenta = :ifinusrNumerocuenta")
    , @NamedQuery(name = "AsignarIfinUsr.findByIfinusrMonto", query = "SELECT a FROM AsignarIfinUsr a WHERE a.ifinusrMonto = :ifinusrMonto")
    , @NamedQuery(name = "AsignarIfinUsr.findByIfinusrEstado", query = "SELECT a FROM AsignarIfinUsr a WHERE a.ifinusrEstado = :ifinusrEstado")})
public class AsignarIfinUsr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IFINUSR_ID")
    private Integer ifinusrId;
    @Size(max = 32)
    @Column(name = "IFINUSR_NUMEROCUENTA")
    private String ifinusrNumerocuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IFINUSR_MONTO")
    private BigDecimal ifinusrMonto;
    @Column(name = "IFINUSR_ESTADO")
    private Integer ifinusrEstado;
    @OneToMany(mappedBy = "ifinusrId")
    private Collection<AsignarTransaccion> asignarTransaccionCollection;
    @JoinColumn(name = "INSFIN_IDENTIFICACION", referencedColumnName = "INSFIN_IDENTIFICACION")
    @ManyToOne
    private InstitucionFinanciera insfinIdentificacion;
    @JoinColumn(name = "CTA_ID", referencedColumnName = "CTA_ID")
    @ManyToOne
    private TipoCuenta ctaId;
    @JoinColumn(name = "USR_IDENTIFICACION", referencedColumnName = "USR_IDENTIFICACION")
    @ManyToOne
    private Usuario usrIdentificacion;

    public AsignarIfinUsr() {
    }

    public AsignarIfinUsr(Integer ifinusrId) {
        this.ifinusrId = ifinusrId;
    }

    public Integer getIfinusrId() {
        return ifinusrId;
    }

    public void setIfinusrId(Integer ifinusrId) {
        this.ifinusrId = ifinusrId;
    }

    public String getIfinusrNumerocuenta() {
        return ifinusrNumerocuenta;
    }

    public void setIfinusrNumerocuenta(String ifinusrNumerocuenta) {
        this.ifinusrNumerocuenta = ifinusrNumerocuenta;
    }

    public BigDecimal getIfinusrMonto() {
        return ifinusrMonto;
    }

    public void setIfinusrMonto(BigDecimal ifinusrMonto) {
        this.ifinusrMonto = ifinusrMonto;
    }

    public Integer getIfinusrEstado() {
        return ifinusrEstado;
    }

    public void setIfinusrEstado(Integer ifinusrEstado) {
        this.ifinusrEstado = ifinusrEstado;
    }

    @XmlTransient
    public Collection<AsignarTransaccion> getAsignarTransaccionCollection() {
        return asignarTransaccionCollection;
    }

    public void setAsignarTransaccionCollection(Collection<AsignarTransaccion> asignarTransaccionCollection) {
        this.asignarTransaccionCollection = asignarTransaccionCollection;
    }

    public InstitucionFinanciera getInsfinIdentificacion() {
        return insfinIdentificacion;
    }

    public void setInsfinIdentificacion(InstitucionFinanciera insfinIdentificacion) {
        this.insfinIdentificacion = insfinIdentificacion;
    }

    public TipoCuenta getCtaId() {
        return ctaId;
    }

    public void setCtaId(TipoCuenta ctaId) {
        this.ctaId = ctaId;
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
        hash += (ifinusrId != null ? ifinusrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignarIfinUsr)) {
            return false;
        }
        AsignarIfinUsr other = (AsignarIfinUsr) object;
        if ((this.ifinusrId == null && other.ifinusrId != null) || (this.ifinusrId != null && !this.ifinusrId.equals(other.ifinusrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arqui.modelo.AsignarIfinUsr[ ifinusrId=" + ifinusrId + " ]";
    }
    
}
