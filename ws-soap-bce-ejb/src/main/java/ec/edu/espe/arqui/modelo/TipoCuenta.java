/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqui.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "TIPO_CUENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCuenta.findAll", query = "SELECT t FROM TipoCuenta t")
    , @NamedQuery(name = "TipoCuenta.findByCtaId", query = "SELECT t FROM TipoCuenta t WHERE t.ctaId = :ctaId")
    , @NamedQuery(name = "TipoCuenta.findByCtaTipo", query = "SELECT t FROM TipoCuenta t WHERE t.ctaTipo = :ctaTipo")})
public class TipoCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CTA_ID")
    private Integer ctaId;
    @Size(max = 8)
    @Column(name = "CTA_TIPO")
    private String ctaTipo;
    @OneToMany(mappedBy = "ctaId")
    private Collection<AsignarIfinUsr> asignarIfinUsrCollection;

    public TipoCuenta() {
    }

    public TipoCuenta(Integer ctaId) {
        this.ctaId = ctaId;
    }

    public Integer getCtaId() {
        return ctaId;
    }

    public void setCtaId(Integer ctaId) {
        this.ctaId = ctaId;
    }

    public String getCtaTipo() {
        return ctaTipo;
    }

    public void setCtaTipo(String ctaTipo) {
        this.ctaTipo = ctaTipo;
    }

    @XmlTransient
    public Collection<AsignarIfinUsr> getAsignarIfinUsrCollection() {
        return asignarIfinUsrCollection;
    }

    public void setAsignarIfinUsrCollection(Collection<AsignarIfinUsr> asignarIfinUsrCollection) {
        this.asignarIfinUsrCollection = asignarIfinUsrCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctaId != null ? ctaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuenta)) {
            return false;
        }
        TipoCuenta other = (TipoCuenta) object;
        if ((this.ctaId == null && other.ctaId != null) || (this.ctaId != null && !this.ctaId.equals(other.ctaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arqui.modelo.TipoCuenta[ ctaId=" + ctaId + " ]";
    }
    
}
