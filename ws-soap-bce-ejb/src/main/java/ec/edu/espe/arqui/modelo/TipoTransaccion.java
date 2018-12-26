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
@Table(name = "TIPO_TRANSACCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTransaccion.findAll", query = "SELECT t FROM TipoTransaccion t")
    , @NamedQuery(name = "TipoTransaccion.findByTraId", query = "SELECT t FROM TipoTransaccion t WHERE t.traId = :traId")
    , @NamedQuery(name = "TipoTransaccion.findByTraTipo", query = "SELECT t FROM TipoTransaccion t WHERE t.traTipo = :traTipo")})
public class TipoTransaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRA_ID")
    private Integer traId;
    @Size(max = 32)
    @Column(name = "TRA_TIPO")
    private String traTipo;
    @OneToMany(mappedBy = "traId")
    private Collection<AsignarTransaccion> asignarTransaccionCollection;

    public TipoTransaccion() {
    }

    public TipoTransaccion(Integer traId) {
        this.traId = traId;
    }

    public Integer getTraId() {
        return traId;
    }

    public void setTraId(Integer traId) {
        this.traId = traId;
    }

    public String getTraTipo() {
        return traTipo;
    }

    public void setTraTipo(String traTipo) {
        this.traTipo = traTipo;
    }

    @XmlTransient
    public Collection<AsignarTransaccion> getAsignarTransaccionCollection() {
        return asignarTransaccionCollection;
    }

    public void setAsignarTransaccionCollection(Collection<AsignarTransaccion> asignarTransaccionCollection) {
        this.asignarTransaccionCollection = asignarTransaccionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traId != null ? traId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTransaccion)) {
            return false;
        }
        TipoTransaccion other = (TipoTransaccion) object;
        if ((this.traId == null && other.traId != null) || (this.traId != null && !this.traId.equals(other.traId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arqui.modelo.TipoTransaccion[ traId=" + traId + " ]";
    }
    
}
