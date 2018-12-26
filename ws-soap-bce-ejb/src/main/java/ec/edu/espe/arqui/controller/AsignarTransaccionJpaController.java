/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqui.controller;

import ec.edu.espe.arqui.controller.exceptions.NonexistentEntityException;
import ec.edu.espe.arqui.controller.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ec.edu.espe.arqui.modelo.Usuario;
import ec.edu.espe.arqui.modelo.TipoTransaccion;
import ec.edu.espe.arqui.modelo.AsignarIfinUsr;
import ec.edu.espe.arqui.modelo.AsignarTransaccion;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

/**
 *
 * @author guffenix
 */
public class AsignarTransaccionJpaController implements Serializable {

    @Resource //inject from your application server
    private UserTransaction utx;
    private final EntityManagerFactory emf;
    public AsignarTransaccionJpaController() {
         emf = Persistence.createEntityManagerFactory("soap_bce_PU");
//        System.out.println("Conexion abierta");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AsignarTransaccion asignarTransaccion) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Usuario usrIdentificacion = asignarTransaccion.getUsrIdentificacion();
            if (usrIdentificacion != null) {
                usrIdentificacion = em.getReference(usrIdentificacion.getClass(), usrIdentificacion.getUsrIdentificacion());
                asignarTransaccion.setUsrIdentificacion(usrIdentificacion);
            }
            TipoTransaccion traId = asignarTransaccion.getTraId();
            if (traId != null) {
                traId = em.getReference(traId.getClass(), traId.getTraId());
                asignarTransaccion.setTraId(traId);
            }
            AsignarIfinUsr ifinusrId = asignarTransaccion.getIfinusrId();
            if (ifinusrId != null) {
                ifinusrId = em.getReference(ifinusrId.getClass(), ifinusrId.getIfinusrId());
                asignarTransaccion.setIfinusrId(ifinusrId);
            }
            em.persist(asignarTransaccion);
            if (usrIdentificacion != null) {
                usrIdentificacion.getAsignarTransaccionCollection().add(asignarTransaccion);
                usrIdentificacion = em.merge(usrIdentificacion);
            }
            if (traId != null) {
                traId.getAsignarTransaccionCollection().add(asignarTransaccion);
                traId = em.merge(traId);
            }
            if (ifinusrId != null) {
                ifinusrId.getAsignarTransaccionCollection().add(asignarTransaccion);
                ifinusrId = em.merge(ifinusrId);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AsignarTransaccion asignarTransaccion) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            AsignarTransaccion persistentAsignarTransaccion = em.find(AsignarTransaccion.class, asignarTransaccion.getAsitraId());
            Usuario usrIdentificacionOld = persistentAsignarTransaccion.getUsrIdentificacion();
            Usuario usrIdentificacionNew = asignarTransaccion.getUsrIdentificacion();
            TipoTransaccion traIdOld = persistentAsignarTransaccion.getTraId();
            TipoTransaccion traIdNew = asignarTransaccion.getTraId();
            AsignarIfinUsr ifinusrIdOld = persistentAsignarTransaccion.getIfinusrId();
            AsignarIfinUsr ifinusrIdNew = asignarTransaccion.getIfinusrId();
            if (usrIdentificacionNew != null) {
                usrIdentificacionNew = em.getReference(usrIdentificacionNew.getClass(), usrIdentificacionNew.getUsrIdentificacion());
                asignarTransaccion.setUsrIdentificacion(usrIdentificacionNew);
            }
            if (traIdNew != null) {
                traIdNew = em.getReference(traIdNew.getClass(), traIdNew.getTraId());
                asignarTransaccion.setTraId(traIdNew);
            }
            if (ifinusrIdNew != null) {
                ifinusrIdNew = em.getReference(ifinusrIdNew.getClass(), ifinusrIdNew.getIfinusrId());
                asignarTransaccion.setIfinusrId(ifinusrIdNew);
            }
            asignarTransaccion = em.merge(asignarTransaccion);
            if (usrIdentificacionOld != null && !usrIdentificacionOld.equals(usrIdentificacionNew)) {
                usrIdentificacionOld.getAsignarTransaccionCollection().remove(asignarTransaccion);
                usrIdentificacionOld = em.merge(usrIdentificacionOld);
            }
            if (usrIdentificacionNew != null && !usrIdentificacionNew.equals(usrIdentificacionOld)) {
                usrIdentificacionNew.getAsignarTransaccionCollection().add(asignarTransaccion);
                usrIdentificacionNew = em.merge(usrIdentificacionNew);
            }
            if (traIdOld != null && !traIdOld.equals(traIdNew)) {
                traIdOld.getAsignarTransaccionCollection().remove(asignarTransaccion);
                traIdOld = em.merge(traIdOld);
            }
            if (traIdNew != null && !traIdNew.equals(traIdOld)) {
                traIdNew.getAsignarTransaccionCollection().add(asignarTransaccion);
                traIdNew = em.merge(traIdNew);
            }
            if (ifinusrIdOld != null && !ifinusrIdOld.equals(ifinusrIdNew)) {
                ifinusrIdOld.getAsignarTransaccionCollection().remove(asignarTransaccion);
                ifinusrIdOld = em.merge(ifinusrIdOld);
            }
            if (ifinusrIdNew != null && !ifinusrIdNew.equals(ifinusrIdOld)) {
                ifinusrIdNew.getAsignarTransaccionCollection().add(asignarTransaccion);
                ifinusrIdNew = em.merge(ifinusrIdNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = asignarTransaccion.getAsitraId();
                if (findAsignarTransaccion(id) == null) {
                    throw new NonexistentEntityException("The asignarTransaccion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            AsignarTransaccion asignarTransaccion;
            try {
                asignarTransaccion = em.getReference(AsignarTransaccion.class, id);
                asignarTransaccion.getAsitraId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asignarTransaccion with id " + id + " no longer exists.", enfe);
            }
            Usuario usrIdentificacion = asignarTransaccion.getUsrIdentificacion();
            if (usrIdentificacion != null) {
                usrIdentificacion.getAsignarTransaccionCollection().remove(asignarTransaccion);
                usrIdentificacion = em.merge(usrIdentificacion);
            }
            TipoTransaccion traId = asignarTransaccion.getTraId();
            if (traId != null) {
                traId.getAsignarTransaccionCollection().remove(asignarTransaccion);
                traId = em.merge(traId);
            }
            AsignarIfinUsr ifinusrId = asignarTransaccion.getIfinusrId();
            if (ifinusrId != null) {
                ifinusrId.getAsignarTransaccionCollection().remove(asignarTransaccion);
                ifinusrId = em.merge(ifinusrId);
            }
            em.remove(asignarTransaccion);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AsignarTransaccion> findAsignarTransaccionEntities() {
        return findAsignarTransaccionEntities(true, -1, -1);
    }

    public List<AsignarTransaccion> findAsignarTransaccionEntities(int maxResults, int firstResult) {
        return findAsignarTransaccionEntities(false, maxResults, firstResult);
    }

    private List<AsignarTransaccion> findAsignarTransaccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AsignarTransaccion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public AsignarTransaccion findAsignarTransaccion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AsignarTransaccion.class, id);
        } finally {
            em.close();
        }
    }

    public int getAsignarTransaccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AsignarTransaccion> rt = cq.from(AsignarTransaccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public void closeEmf(){
        if(emf != null){
            emf.close();
            System.out.println("Se cierra conexión");
        }
    }
    
}
