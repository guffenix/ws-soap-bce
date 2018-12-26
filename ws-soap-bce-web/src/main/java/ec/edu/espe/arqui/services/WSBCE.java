
package ec.edu.espe.arqui.services;

import ec.edu.espe.arqui.ServicioULocal;
import ec.edu.espe.arqui.modelo.InstitucionFinanciera;
import ec.edu.espe.arqui.modelo.Usuario;
import ec.edu.espe.arqui.respuesta.RSCliente;
import ec.edu.espe.arqui.respuesta.RSEstadoTransaccion;
import ec.edu.espe.arqui.respuesta.RSModificaEstado;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author guffenix
 */
@WebService(serviceName = "WSBCE")
public class WSBCE {

    @EJB
    private ServicioULocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "verificaUsuarioExiste")
    public RSCliente obtener( @WebParam (name = "cedula")String usrIdentificacion) {
        return ejbRef.obtener(usrIdentificacion);
    }
    
    @WebMethod(operationName = "actualizarEstadoUsuario")
    public RSModificaEstado modificar(@WebParam(name = "cedula")String cedula, @WebParam(name = "cuenta")String cuenta, @WebParam(name = "estado")String estado) {
        return ejbRef.modificar(cedula, cuenta, estado);
    }
    
    
//    @WebMethod(operationName = "obtentenerEntidades")
//    public List<InstitucionFinanciera> obtenerTodo(@WebParam(name = "estado")Integer id) {
//        return ejbRef.obtenerTodo(id);
//    }
    
    @WebMethod(operationName = "obtentenerEntidadesOk")
    public List<InstitucionFinanciera> obtenerEntidades() {
        return ejbRef.obtenerTodo(2);
    }
    
    @WebMethod(operationName = "depositar")
    public RSEstadoTransaccion depositar(@WebParam(name = "cuentaDestino")String cuentaDestino, @WebParam(name = "monto")Double monto) {
        return ejbRef.depositar(cuentaDestino, monto);
    }
    
    @WebMethod(operationName = "retirar")
    public RSEstadoTransaccion retirar(@WebParam(name = "cuentaOrigen")String cuentaOrigen, @WebParam(name = "monto")Double monto) {
        return ejbRef.retirar(cuentaOrigen, monto);
    }
    
//    @WebMethod(operationName = "revertir")
//    public RSEstadoTransaccion revertir(@WebParam(name = "cuentaOrigen")String cuentaOrigen, @WebParam(name = "cuentaDestino")String cuentaDestino, @WebParam(name = "monto")Double monto) {
//        return ejbRef.revertir(cuentaOrigen, cuentaDestino, monto);
//    }
    
//    @WebMethod(operationName = "transferencia")
//    public RSEstadoTransaccion tramsferencia(@WebParam(name = "cuentaOrigen")String cuentaOrigen, @WebParam(name = "cuentaDestino")String cuentaDestino, @WebParam(name = "monto")Double monto) {
//        return ejbRef.tramsferencia(cuentaOrigen, cuentaDestino, monto);
//    }
        
    
//    @WebMethod(operationName = "obtenerCuenta")
//    public TipoCuenta obtenerCuenta(Integer id) {
//        return ejbRef.obtenerCuenta(id);
//    }
    
}
