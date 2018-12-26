
package ec.edu.espe.arqui;


import ec.edu.espe.arqui.modelo.AsignarTransaccion;
import ec.edu.espe.arqui.modelo.InstitucionFinanciera;
import ec.edu.espe.arqui.modelo.TipoCuenta;
import ec.edu.espe.arqui.modelo.Usuario;
import ec.edu.espe.arqui.respuesta.RSCliente;
import ec.edu.espe.arqui.respuesta.RSEstadoTransaccion;
import ec.edu.espe.arqui.respuesta.RSModificaEstado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author guffenix
 */
@Local
public interface ServicioULocal {
    public RSCliente obtener(String usrIdentificacion);
    public RSModificaEstado modificar(String cedula, String cuenta, String estado);
    public TipoCuenta obtenerCuenta(Integer id);
    
    //Obtiene listado de IF que pueden realizar transferencias
    public  List<InstitucionFinanciera>  obtenerTodo(Integer id);
    
    
    //Operaciones
    public RSEstadoTransaccion depositar(String cuentaDestino, Double monto);
    public RSEstadoTransaccion retirar(String cuentaOrigen, Double monto);
    public RSEstadoTransaccion revertir(String cuentaOrigen, String cuentaDestino, Double monto);
//    public RSEstadoTransaccion tramsferencia(String cuentaOrigen, String cuentaDestino, Double monto);
}
