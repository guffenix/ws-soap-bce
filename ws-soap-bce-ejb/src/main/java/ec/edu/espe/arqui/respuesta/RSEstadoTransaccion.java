
package ec.edu.espe.arqui.respuesta;

/**
 *
 * @author guffenix
 */
public class RSEstadoTransaccion {
    private Integer codigo;
    private Integer error;
    private String descripcion;

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
    
}
