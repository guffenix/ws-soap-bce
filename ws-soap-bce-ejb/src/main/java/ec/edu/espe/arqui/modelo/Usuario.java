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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author guffenix
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsrIdentificacion", query = "SELECT u FROM Usuario u WHERE u.usrIdentificacion = :usrIdentificacion")
    , @NamedQuery(name = "Usuario.findByUsrNombre", query = "SELECT u FROM Usuario u WHERE u.usrNombre = :usrNombre")
    , @NamedQuery(name = "Usuario.findByUsrApellido", query = "SELECT u FROM Usuario u WHERE u.usrApellido = :usrApellido")
    , @NamedQuery(name = "Usuario.findByUsrTelefono", query = "SELECT u FROM Usuario u WHERE u.usrTelefono = :usrTelefono")
    , @NamedQuery(name = "Usuario.findByUsrEmail", query = "SELECT u FROM Usuario u WHERE u.usrEmail = :usrEmail")
    , @NamedQuery(name = "Usuario.findByUsrLugarnacimiento", query = "SELECT u FROM Usuario u WHERE u.usrLugarnacimiento = :usrLugarnacimiento")
    , @NamedQuery(name = "Usuario.findByUsrFechanacimiento", query = "SELECT u FROM Usuario u WHERE u.usrFechanacimiento = :usrFechanacimiento")
    , @NamedQuery(name = "Usuario.findByUsrNacionalidad", query = "SELECT u FROM Usuario u WHERE u.usrNacionalidad = :usrNacionalidad")
    , @NamedQuery(name = "Usuario.findByUsrGenero", query = "SELECT u FROM Usuario u WHERE u.usrGenero = :usrGenero")
    , @NamedQuery(name = "Usuario.findByUsrEstadocivil", query = "SELECT u FROM Usuario u WHERE u.usrEstadocivil = :usrEstadocivil")
    , @NamedQuery(name = "Usuario.findByUsrEstado", query = "SELECT u FROM Usuario u WHERE u.usrEstado = :usrEstado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USR_IDENTIFICACION")
    private String usrIdentificacion;
    @Size(max = 64)
    @Column(name = "USR_NOMBRE")
    private String usrNombre;
    @Size(max = 64)
    @Column(name = "USR_APELLIDO")
    private String usrApellido;
    @Size(max = 15)
    @Column(name = "USR_TELEFONO")
    private String usrTelefono;
    @Size(max = 128)
    @Column(name = "USR_EMAIL")
    private String usrEmail;
    @Size(max = 256)
    @Column(name = "USR_LUGARNACIMIENTO")
    private String usrLugarnacimiento;
    @Column(name = "USR_FECHANACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date usrFechanacimiento;
    @Size(max = 64)
    @Column(name = "USR_NACIONALIDAD")
    private String usrNacionalidad;
    @Size(max = 8)
    @Column(name = "USR_GENERO")
    private String usrGenero;
    @Size(max = 16)
    @Column(name = "USR_ESTADOCIVIL")
    private String usrEstadocivil;
    @Size(max = 64)
    @Column(name = "USR_ESTADO")
    private String usrEstado;
    @OneToMany(mappedBy = "usrIdentificacion")
    private Collection<AsignarTransaccion> asignarTransaccionCollection;
    @OneToMany(mappedBy = "usrIdentificacion")
    private Collection<AsignarIfinUsr> asignarIfinUsrCollection;

    public Usuario() {
    }

    public Usuario(String usrIdentificacion) {
        this.usrIdentificacion = usrIdentificacion;
    }

    public String getUsrIdentificacion() {
        return usrIdentificacion;
    }

    public void setUsrIdentificacion(String usrIdentificacion) {
        this.usrIdentificacion = usrIdentificacion;
    }

    public String getUsrNombre() {
        return usrNombre;
    }

    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }

    public String getUsrApellido() {
        return usrApellido;
    }

    public void setUsrApellido(String usrApellido) {
        this.usrApellido = usrApellido;
    }

    public String getUsrTelefono() {
        return usrTelefono;
    }

    public void setUsrTelefono(String usrTelefono) {
        this.usrTelefono = usrTelefono;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrLugarnacimiento() {
        return usrLugarnacimiento;
    }

    public void setUsrLugarnacimiento(String usrLugarnacimiento) {
        this.usrLugarnacimiento = usrLugarnacimiento;
    }

    public Date getUsrFechanacimiento() {
        return usrFechanacimiento;
    }

    public void setUsrFechanacimiento(Date usrFechanacimiento) {
        this.usrFechanacimiento = usrFechanacimiento;
    }

    public String getUsrNacionalidad() {
        return usrNacionalidad;
    }

    public void setUsrNacionalidad(String usrNacionalidad) {
        this.usrNacionalidad = usrNacionalidad;
    }

    public String getUsrGenero() {
        return usrGenero;
    }

    public void setUsrGenero(String usrGenero) {
        this.usrGenero = usrGenero;
    }

    public String getUsrEstadocivil() {
        return usrEstadocivil;
    }

    public void setUsrEstadocivil(String usrEstadocivil) {
        this.usrEstadocivil = usrEstadocivil;
    }

    public String getUsrEstado() {
        return usrEstado;
    }

    public void setUsrEstado(String usrEstado) {
        this.usrEstado = usrEstado;
    }

    @XmlTransient
    public Collection<AsignarTransaccion> getAsignarTransaccionCollection() {
        return asignarTransaccionCollection;
    }

    public void setAsignarTransaccionCollection(Collection<AsignarTransaccion> asignarTransaccionCollection) {
        this.asignarTransaccionCollection = asignarTransaccionCollection;
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
        hash += (usrIdentificacion != null ? usrIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usrIdentificacion == null && other.usrIdentificacion != null) || (this.usrIdentificacion != null && !this.usrIdentificacion.equals(other.usrIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arqui.modelo.Usuario[ usrIdentificacion=" + usrIdentificacion + " ]";
    }
    
}
