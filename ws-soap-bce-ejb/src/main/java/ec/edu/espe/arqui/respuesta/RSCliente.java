
package ec.edu.espe.arqui.respuesta;

import ec.edu.espe.arqui.modelo.Usuario;

/**
 *
 * @author guffenix
 */
public class RSCliente {
    private Integer codigo;
    private Integer error;
    private String descripcion;
    private Usuario usuario;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
