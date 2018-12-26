package ec.edu.espe.arqui;

import ec.edu.espe.arqui.controller.AsignarIfinUsrJpaController;
import ec.edu.espe.arqui.controller.AsignarTransaccionJpaController;
import ec.edu.espe.arqui.controller.InstitucionFinancieraJpaController;
import ec.edu.espe.arqui.controller.TipoCuentaJpaController;
import ec.edu.espe.arqui.controller.TipoTransaccionJpaController;
import ec.edu.espe.arqui.controller.UsuarioJpaController;
import ec.edu.espe.arqui.controller.exceptions.RollbackFailureException;
import ec.edu.espe.arqui.modelo.AsignarIfinUsr;
import ec.edu.espe.arqui.modelo.AsignarTransaccion;
import ec.edu.espe.arqui.modelo.InstitucionFinanciera;
import ec.edu.espe.arqui.modelo.TipoCuenta;
import ec.edu.espe.arqui.modelo.TipoTransaccion;
import ec.edu.espe.arqui.modelo.Usuario;
import ec.edu.espe.arqui.respuesta.RSCliente;
import ec.edu.espe.arqui.respuesta.RSEstadoTransaccion;
import ec.edu.espe.arqui.respuesta.RSModificaEstado;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author guffenix
 */
@Stateless
public class ServicioU implements ServicioULocal {

    @Override
    public RSCliente obtener(String usrIdentificacion) {

        RSCliente rsp = new RSCliente();
        
        UsuarioJpaController ujpa = new UsuarioJpaController();

        Usuario usr = ujpa.getEntityManager().find(Usuario.class, usrIdentificacion);
        
        if (usr != null) {
            rsp.setCodigo(201);
            rsp.setDescripcion("Cliente Encontrado Exitosamente");
            rsp.setError(null);
            rsp.setUsuario(usr);
        }else{
            rsp.setCodigo(null);
            rsp.setDescripcion("El cliente no se encuentra registrado en el sistema.");
            rsp.setError(401);
            rsp.setUsuario(null);
        }

        return rsp;
    }

    @Override
    public RSModificaEstado modificar(String cedula, String cuenta, String estado) {

        RSModificaEstado rme = new RSModificaEstado();

        AsignarIfinUsrJpaController ujpa = new AsignarIfinUsrJpaController();

        TypedQuery<AsignarIfinUsr> consultaOrigen = ujpa.getEntityManager()
                .createQuery("SELECT a FROM AsignarIfinUsr a LEFT JOIN a.usrIdentificacion u WHERE a.ifinusrNumerocuenta = :ifinusrNumerocuenta AND u.usrIdentificacion = :usrIdentificacion", AsignarIfinUsr.class)
                .setParameter("ifinusrNumerocuenta", cuenta)
                .setParameter("usrIdentificacion", cedula);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soap_bce_PU");
        EntityManager em1 = factory.createEntityManager();

        String resultado;
        Integer codigo;
        Integer error;
        try {

            List<AsignarIfinUsr> asigIU = consultaOrigen.getResultList();
//            List<AsignarIfinUsr> asigIU = em1
//                    .createQuery("SELECT a FROM AsignarIfinUsr a WHERE a.ifinusrNumerocuenta = :ifinusrNumerocuenta AND a.ifinusrId = :ifinusrId", AsignarIfinUsr.class)
//                    .setParameter("ifinusrNumerocuenta", cuenta)
//                    .setParameter("ifinusrId", cedula)
//                    .getResultList();

            if (asigIU == null || asigIU.isEmpty()) {
                resultado = "No se puede actualizar, cuenta no identificada";
                codigo = null;
                error = 401;
            } else {
                Usuario user = em1.find(Usuario.class, asigIU.get(0).getUsrIdentificacion().getUsrIdentificacion());
                em1.getTransaction().begin();
                user.setUsrEstado(estado);
                em1.getTransaction().commit();
                resultado = "Actualizado correctamente";
                codigo = 202;
                error = null;
            }

        } catch (Exception ex) {
            em1.getTransaction().rollback();
            resultado = ex.getMessage();
            codigo = null;
            error = 401;
        }

        em1.close();
        factory.close();

        rme.setCodigo(codigo);
        rme.setError(error);
        rme.setDescripcion(resultado);
        return rme;
    }

    @Override
    public TipoCuenta obtenerCuenta(Integer id) {

        TipoCuentaJpaController ujpa = new TipoCuentaJpaController();

        TipoCuenta usr = ujpa.getEntityManager().find(TipoCuenta.class, id);

        return usr;
    }

    public TipoCuenta obtenerCuentaPorNumero(Integer id) {

        TipoCuentaJpaController ujpa = new TipoCuentaJpaController();

        TipoCuenta usr = ujpa.getEntityManager().find(TipoCuenta.class, id);

        return usr;
    }

    public TipoTransaccion obtenerTrnsPorNumero(Integer id) {

        TipoTransaccionJpaController ujpa = new TipoTransaccionJpaController();

        TipoTransaccion usr = ujpa.getEntityManager().find(TipoTransaccion.class, id);

        return usr;
    }

//    @Override
//    public RSEstadoTransaccion tramsferencia(String cuentaOrigen, String cuentaDestino, Double monto) {
//
//        RSEstadoTransaccion rst = new RSEstadoTransaccion();
//        TipoCuentaJpaController ujpa = new TipoCuentaJpaController();
//
//        TypedQuery<AsignarIfinUsr> consultaOrigen = ujpa.getEntityManager()
//                .createQuery("SELECT a FROM AsignarIfinUsr a WHERE a.ifinusrNumerocuenta = :ifinusrNumerocuenta", AsignarIfinUsr.class)
//                .setParameter("ifinusrNumerocuenta", cuentaOrigen);
//
//        TypedQuery<AsignarIfinUsr> consultaFin = ujpa.getEntityManager()
//                .createQuery("SELECT a FROM AsignarIfinUsr a WHERE a.ifinusrNumerocuenta = :ifinusrNumerocuenta", AsignarIfinUsr.class)
//                .setParameter("ifinusrNumerocuenta", cuentaDestino);
//
//        List<AsignarIfinUsr> lista1 = consultaOrigen.getResultList();
//        List<AsignarIfinUsr> lista2 = consultaFin.getResultList();
//        if (lista1 == null || lista1.isEmpty() || lista2 == null || lista2.isEmpty()) {
//
//            rst.setCodigo(null);
//            rst.setError(1);
//            rst.setDescripcion("La transacción no se ha podido completar");
//        } else {
//            try {
//                AsignarTransaccionJpaController asijap = new AsignarTransaccionJpaController();
//
//                AsignarTransaccion trans = new AsignarTransaccion();
//                AsignarIfinUsr ctaOrigen = lista1.get(0);
//                AsignarIfinUsr ctaDestino = lista2.get(0);
//                TipoTransaccionJpaController trajpa = new TipoTransaccionJpaController();
//                TipoTransaccion tra = trajpa.findTipoTransaccion(1);
//                trans.setAsitraEstado(1);
//                trans.setAsitraFechauso(new Date());
//                trans.setAsitraIdentificador(ctaDestino.getUsrIdentificacion().getUsrIdentificacion());
//                trans.setAsitraMonto(new BigDecimal(monto));
//                trans.setTraId(tra);
//                trans.setUsrIdentificacion(ctaOrigen.getUsrIdentificacion());
//
//                AsignarTransaccion trans2 = new AsignarTransaccion();
//
//                TipoTransaccion tra2 = trajpa.findTipoTransaccion(2);
//                trans2.setAsitraEstado(2);
//                trans2.setAsitraFechauso(new Date());
//                trans2.setAsitraIdentificador(ctaOrigen.getUsrIdentificacion().getUsrIdentificacion());
//                trans2.setAsitraMonto(new BigDecimal(monto).multiply(new BigDecimal("-1")));
//                trans2.setTraId(tra2);
//                trans2.setUsrIdentificacion(ctaOrigen.getUsrIdentificacion());
//
//                asijap.create(trans);
//                asijap.create(trans2);
//
//                rst.setCodigo(null);
//                rst.setError(1);
//                rst.setDescripcion("La transacción Exitosa");
//            } catch (RollbackFailureException ex) {
//                Logger.getLogger(ServicioU.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (Exception ex) {
//                Logger.getLogger(ServicioU.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        return rst;
//    }
    @Override
    public List<InstitucionFinanciera> obtenerTodo(Integer id) {

        InstitucionFinancieraJpaController ifjpa = new InstitucionFinancieraJpaController();

        List<InstitucionFinanciera> listaEntidades = ifjpa.getEntityManager()
                .createNamedQuery("InstitucionFinanciera.findByInsfinEstado")
                .setParameter("insfinEstado", id)
                .getResultList();

        if (listaEntidades == null || listaEntidades.isEmpty()) {

            listaEntidades = new ArrayList<>();

            return listaEntidades;
        } else {
            return listaEntidades;
        }

    }

    @Override
    public RSEstadoTransaccion depositar(String cuentaDestino, Double monto) {

        RSEstadoTransaccion rst = new RSEstadoTransaccion();

        AsignarIfinUsrJpaController aipja = new AsignarIfinUsrJpaController();

        TypedQuery<AsignarIfinUsr> consultaFin = aipja.getEntityManager()
                .createQuery("SELECT a FROM AsignarIfinUsr a WHERE a.ifinusrNumerocuenta = :ifinusrNumerocuenta", AsignarIfinUsr.class)
                .setParameter("ifinusrNumerocuenta", cuentaDestino);

        List<AsignarIfinUsr> obtenUno = consultaFin.getResultList();
        if (obtenUno == null || obtenUno.isEmpty()) {

            rst.setCodigo(null);
            rst.setError(401);
            rst.setDescripcion("Cuenta inexistente, no se puede completar la transacción.");

        } else {
            try {
                AsignarTransaccion asigtrns = new AsignarTransaccion();

                AsignarIfinUsr nuevoAIU = (AsignarIfinUsr)obtenUno.get(0);

                asigtrns.setUsrIdentificacion(nuevoAIU.getUsrIdentificacion());
                asigtrns.setTraId(obtenerTrnsPorNumero(2));
                asigtrns.setIfinusrId(nuevoAIU);
                asigtrns.setAsitraIdentificador("D");
                asigtrns.setAsitraFechauso(new Date());
                asigtrns.setAsitraMonto(new BigDecimal(monto));
                asigtrns.setAsitraEstado(1);

                StringBuilder descripcion = new StringBuilder();
                descripcion.append(guardar(asigtrns));
                BigDecimal _montoActual = nuevoAIU.getIfinusrMonto().add(new BigDecimal(monto));
                nuevoAIU.setIfinusrMonto(_montoActual);

                descripcion.append(" - ");
                descripcion.append(actualizar(nuevoAIU.getIfinusrId(), _montoActual));

                rst.setCodigo(202);
                rst.setError(null);
                rst.setDescripcion(descripcion.toString());

            } catch (Exception ex) {
                Logger.getLogger(ServicioU.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                aipja.closeEmf();
                
            }
        }

        return rst;
    }

    @Override
    public RSEstadoTransaccion retirar(String cuentaOrigen, Double monto) {
        RSEstadoTransaccion rst = new RSEstadoTransaccion();

        AsignarIfinUsrJpaController aipja = new AsignarIfinUsrJpaController();

        TypedQuery<AsignarIfinUsr> consultaFin = aipja.getEntityManager()
                .createQuery("SELECT a FROM AsignarIfinUsr a WHERE a.ifinusrNumerocuenta = :ifinusrNumerocuenta", AsignarIfinUsr.class)
                .setParameter("ifinusrNumerocuenta", cuentaOrigen);

        List<AsignarIfinUsr> obtenUno = consultaFin.getResultList();
        if (obtenUno == null || obtenUno.isEmpty()) {

            rst.setCodigo(null);
            rst.setError(401);
            rst.setDescripcion("Cuenta inexistente, no se puede completar la transacción.");

        } else {
            try {
                AsignarTransaccion asigtrns = new AsignarTransaccion();

                AsignarIfinUsr nuevoAIU = obtenUno.get(0);

                if (nuevoAIU.getIfinusrMonto().compareTo(new BigDecimal(monto)) == 1 || nuevoAIU.getIfinusrMonto().compareTo(new BigDecimal(monto)) == 0) {
                    asigtrns.setUsrIdentificacion(nuevoAIU.getUsrIdentificacion());
                    asigtrns.setTraId(obtenerTrnsPorNumero(3));
                    asigtrns.setIfinusrId(nuevoAIU);
                    asigtrns.setAsitraIdentificador("R");
                    asigtrns.setAsitraFechauso(new Date());
                    asigtrns.setAsitraMonto(new BigDecimal(monto));
                    asigtrns.setAsitraEstado(1);

                    StringBuilder descripcion = new StringBuilder();
                    descripcion.append(guardar(asigtrns));
                    BigDecimal _montoActual = nuevoAIU.getIfinusrMonto().subtract(new BigDecimal(monto));
                    nuevoAIU.setIfinusrMonto(_montoActual);

                    descripcion.append(" - ");
                    descripcion.append(actualizar(nuevoAIU.getIfinusrId(), _montoActual));

                    rst.setCodigo(202);
                    rst.setError(null);
                    rst.setDescripcion(descripcion.toString());
                }else{
                    rst.setCodigo(null);
                    rst.setError(401);
                    rst.setDescripcion("La cuenta no dispone de fondos suficientes.");
                }

            } catch (Exception ex) {
                Logger.getLogger(ServicioU.class.getName()).log(Level.SEVERE, null, ex);
                rst.setCodigo(null);
                rst.setError(401);
                rst.setDescripcion(ex.getMessage());
            }finally{
                aipja.closeEmf();
            }
        }

        return rst;
    }

    @Override
    public RSEstadoTransaccion revertir(String cuentaOrigen, String cuentaDestino, Double monto) {
        RSEstadoTransaccion rst = new RSEstadoTransaccion();

        AsignarIfinUsrJpaController aipja = new AsignarIfinUsrJpaController();

        TypedQuery<AsignarIfinUsr> consultaFin = aipja.getEntityManager()
                .createQuery("SELECT a FROM AsignarIfinUsr a WHERE a.ifinusrNumerocuenta = :ifinusrNumerocuenta", AsignarIfinUsr.class)
                .setParameter("ifinusrNumerocuenta", cuentaDestino);

        List<AsignarIfinUsr> obtenUno = consultaFin.getResultList();
        if (obtenUno == null || obtenUno.isEmpty()) {

            rst.setCodigo(null);
            rst.setError(401);
            rst.setDescripcion("Cuenta inexistente, no se puede completar la transacción.");

        } else {
            try {
                AsignarTransaccion asigtrns = new AsignarTransaccion();

                AsignarIfinUsr nuevoAIU = obtenUno.get(0);

                asigtrns.setUsrIdentificacion(nuevoAIU.getUsrIdentificacion());
                asigtrns.setTraId(obtenerTrnsPorNumero(2));
                asigtrns.setIfinusrId(nuevoAIU);
                asigtrns.setAsitraIdentificador("D");
                asigtrns.setAsitraFechauso(new Date());
                asigtrns.setAsitraMonto(new BigDecimal(monto));
                asigtrns.setAsitraEstado(1);

                StringBuilder descripcion = new StringBuilder();
                descripcion.append(guardar(asigtrns));
                BigDecimal _montoActual = nuevoAIU.getIfinusrMonto().add(new BigDecimal(monto));
                nuevoAIU.setIfinusrMonto(_montoActual);

                descripcion.append(" - ");
                descripcion.append(actualizar(nuevoAIU.getIfinusrId(), _montoActual));

                rst.setCodigo(202);
                rst.setError(null);
                rst.setDescripcion(descripcion.toString());

            } catch (Exception ex) {
                Logger.getLogger(ServicioU.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return rst;
    }

    public String guardar(AsignarTransaccion asigTrns) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soap_bce_PU");
        EntityManager em1 = factory.createEntityManager();

        String resultado;
        try {
            em1.getTransaction().begin();
            em1.persist(asigTrns);
            em1.getTransaction().commit();
            resultado = "Guardado correctamente";
        } catch (Exception ex) {
            em1.getTransaction().rollback();
            resultado = ex.getMessage();
        }

        em1.close();
        factory.close();

        return resultado;
    }

    public String actualizar(Integer id, BigDecimal _montoActual) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soap_bce_PU");
        EntityManager em1 = factory.createEntityManager();

        String resultado;
        try {
            AsignarIfinUsr asigIU = em1.find(AsignarIfinUsr.class, id);
            em1.getTransaction().begin();
            asigIU.setIfinusrMonto(_montoActual);
            em1.getTransaction().commit();
            resultado = "Actualizado correctamente";
        } catch (Exception ex) {
            em1.getTransaction().rollback();
            resultado = ex.getMessage();
        }

        em1.close();
        factory.close();

        return resultado;

    }

}
