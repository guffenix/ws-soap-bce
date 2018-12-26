/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqui.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author guffenix
 */
@Entity
@Table(name = "INSTITUCION_FINANCIERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitucionFinanciera.findAll", query = "SELECT i FROM InstitucionFinanciera i")
    , @NamedQuery(name = "InstitucionFinanciera.findByInsfinIdentificacion", query = "SELECT i FROM InstitucionFinanciera i WHERE i.insfinIdentificacion = :insfinIdentificacion")
    , @NamedQuery(name = "InstitucionFinanciera.findByInsfinNombre", query = "SELECT i FROM InstitucionFinanciera i WHERE i.insfinNombre = :insfinNombre")
    , @NamedQuery(name = "InstitucionFinanciera.findByInsfinCodigo", query = "SELECT i FROM InstitucionFinanciera i WHERE i.insfinCodigo = :insfinCodigo")
    , @NamedQuery(name = "InstitucionFinanciera.findByInsfinTipo", query = "SELECT i FROM InstitucionFinanciera i WHERE i.insfinTipo = :insfinTipo")
    , @NamedQuery(name = "InstitucionFinanciera.findByInsfinRazonsocial", query = "SELECT i FROM InstitucionFinanciera i WHERE i.insfinRazonsocial = :insfinRazonsocial")
    , @NamedQuery(name = "InstitucionFinanciera.findByInsfinDireccion", query = "SELECT i FROM InstitucionFinanciera i WHERE i.insfinDireccion = :insfinDireccion")
    , @NamedQuery(name = "InstitucionFinanciera.findByInsfinTelefono", query = "SELECT i FROM InstitucionFinanciera i WHERE i.insfinTelefono = :insfinTelefono")
    , @NamedQuery(name = "InstitucionFinanciera.findByInsfinFecharegistro", query = "SELECT i FROM InstitucionFinanciera i WHERE i.insfinFecharegistro = :insfinFecharegistro")
    , @NamedQuery(name = "InstitucionFinanciera.findByInsfinEstado", query = "SELECT i FROM InstitucionFinanciera i WHERE i.insfinEstado = :insfinEstado")})
public class InstitucionFinanciera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "INSFIN_IDENTIFICACION")
    private Integer insfinIdentificacion;
    @Size(max = 64)
    @Column(name = "INSFIN_NOMBRE")
    private String insfinNombre;
    @Size(max = 15)
    @Column(name = "INSFIN_CODIGO")
    private String insfinCodigo;
    @Size(max = 32)
    @Column(name = "INSFIN_TIPO")
    private String insfinTipo;
    @Size(max = 256)
    @Column(name = "INSFIN_RAZONSOCIAL")
    private String insfinRazonsocial;
    @Size(max = 256)
    @Column(name = "INSFIN_DIRECCION")
    private String insfinDireccion;
    @Size(max = 15)
    @Column(name = "INSFIN_TELEFONO")
    private String insfinTelefono;
    @Column(name = "INSFIN_FECHAREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insfinFecharegistro;
    @Column(name = "INSFIN_ESTADO")
    private Integer insfinEstado;
    @OneToMany(mappedBy = "insfinIdentificacion")
    private Collection<AsignarIfinUsr> asignarIfinUsrCollection;

    public InstitucionFinanciera() {
    }

    public InstitucionFinanciera(Integer insfinIdentificacion) {
        this.insfinIdentificacion = insfinIdentificacion;
    }

    public Integer getInsfinIdentificacion() {
        return insfinIdentificacion;
    }

    public void setInsfinIdentificacion(Integer insfinIdentificacion) {
        this.insfinIdentificacion = insfinIdentificacion;
    }

    public String getInsfinNombre() {
        return insfinNombre;
    }

    public void setInsfinNombre(String insfinNombre) {
        this.insfinNombre = insfinNombre;
    }

    public String getInsfinCodigo() {
        return insfinCodigo;
    }

    public void setInsfinCodigo(String insfinCodigo) {
        this.insfinCodigo = insfinCodigo;
    }

    public String getInsfinTipo() {
        return insfinTipo;
    }

    public void setInsfinTipo(String insfinTipo) {
        this.insfinTipo = insfinTipo;
    }

    public String getInsfinRazonsocial() {
        return insfinRazonsocial;
    }

    public void setInsfinRazonsocial(String insfinRazonsocial) {
        this.insfinRazonsocial = insfinRazonsocial;
    }

    public String getInsfinDireccion() {
        return insfinDireccion;
    }

    public void setInsfinDireccion(String insfinDireccion) {
        this.insfinDireccion = insfinDireccion;
    }

    public String getInsfinTelefono() {
        return insfinTelefono;
    }

    public void setInsfinTelefono(String insfinTelefono) {
        this.insfinTelefono = insfinTelefono;
    }

    public Date getInsfinFecharegistro() {
        return insfinFecharegistro;
    }

    public void setInsfinFecharegistro(Date insfinFecharegistro) {
        this.insfinFecharegistro = insfinFecharegistro;
    }

    public Integer getInsfinEstado() {
        return insfinEstado;
    }

    public void setInsfinEstado(Integer insfinEstado) {
        this.insfinEstado = insfinEstado;
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
        hash += (insfinIdentificacion != null ? insfinIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitucionFinanciera)) {
            return false;
        }
        InstitucionFinanciera other = (InstitucionFinanciera) object;
        if ((this.insfinIdentificacion == null && other.insfinIdentificacion != null) || (this.insfinIdentificacion != null && !this.insfinIdentificacion.equals(other.insfinIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arqui.modelo.InstitucionFinanciera[ insfinIdentificacion=" + insfinIdentificacion + " ]";
    }
    
}
