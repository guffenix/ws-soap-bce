/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqui.controller;

import ec.edu.espe.arqui.controller.exceptions.NonexistentEntityException;
import ec.edu.espe.arqui.controller.exceptions.RollbackFailureException;
import ec.edu.espe.arqui.modelo.AsignarIfinUsr;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ec.edu.espe.arqui.modelo.TipoCuenta;
import ec.edu.espe.arqui.modelo.InstitucionFinanciera;
import ec.edu.espe.arqui.modelo.Usuario;
import ec.edu.espe.arqui.modelo.AsignarTransaccion;
import java.util.ArrayList;
import java.util.Collection;
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
public class AsignarIfinUsrJpaController implements Serializable {

    @Resource //inject from your application server
    private UserTransaction utx;
    private final EntityManagerFactory emf;
    public AsignarIfinUsrJpaController() {

        emf = Persistence.createEntityManagerFactory("soap_bce_PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AsignarIfinUsr asignarIfinUsr) throws RollbackFailureException, Exception {
        if (asignarIfinUsr.getAsignarTransaccionCollection() == null) {
            asignarIfinUsr.setAsignarTransaccionCollection(new ArrayList<AsignarTransaccion>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            TipoCuenta ctaId = asignarIfinUsr.getCtaId();
            if (ctaId != null) {
                ctaId = em.getReference(ctaId.getClass(), ctaId.getCtaId());
                asignarIfinUsr.setCtaId(ctaId);
            }
            InstitucionFinanciera insfinIdentificacion = asignarIfinUsr.getInsfinIdentificacion();
            if (insfinIdentificacion != null) {
                insfinIdentificacion = em.getReference(insfinIdentificacion.getClass(), insfinIdentificacion.getInsfinIdentificacion());
                asignarIfinUsr.setInsfinIdentificacion(insfinIdentificacion);
            }
            Usuario usrIdentificacion = asignarIfinUsr.getUsrIdentificacion();
            if (usrIdentificacion != null) {
                usrIdentificacion = em.getReference(usrIdentificacion.getClass(), usrIdentificacion.getUsrIdentificacion());
                asignarIfinUsr.setUsrIdentificacion(usrIdentificacion);
            }
            Collection<AsignarTransaccion> attachedAsignarTransaccionCollection = new ArrayList<AsignarTransaccion>();
            for (AsignarTransaccion asignarTransaccionCollectionAsignarTransaccionToAttach : asignarIfinUsr.getAsignarTransaccionCollection()) {
                asignarTransaccionCollectionAsignarTransaccionToAttach = em.getReference(asignarTransaccionCollectionAsignarTransaccionToAttach.getClass(), asignarTransaccionCollectionAsignarTransaccionToAttach.getAsitraId());
                attachedAsignarTransaccionCollection.add(asignarTransaccionCollectionAsignarTransaccionToAttach);
            }
            asignarIfinUsr.setAsignarTransaccionCollection(attachedAsignarTransaccionCollection);
            em.persist(asignarIfinUsr);
            if (ctaId != null) {
                ctaId.getAsignarIfinUsrCollection().add(asignarIfinUsr);
                ctaId = em.merge(ctaId);
            }
            if (insfinIdentificacion != null) {
                insfinIdentificacion.getAsignarIfinUsrCollection().add(asignarIfinUsr);
                insfinIdentificacion = em.merge(insfinIdentificacion);
            }
            if (usrIdentificacion != null) {
                usrIdentificacion.getAsignarIfinUsrCollection().add(asignarIfinUsr);
                usrIdentificacion = em.merge(usrIdentificacion);
            }
            for (AsignarTransaccion asignarTransaccionCollectionAsignarTransaccion : asignarIfinUsr.getAsignarTransaccionCollection()) {
                AsignarIfinUsr oldIfinusrIdOfAsignarTransaccionCollectionAsignarTransaccion = asignarTransaccionCollectionAsignarTransaccion.getIfinusrId();
                asignarTransaccionCollectionAsignarTransaccion.setIfinusrId(asignarIfinUsr);
                asignarTransaccionCollectionAsignarTransaccion = em.merge(asignarTransaccionCollectionAsignarTransaccion);
                if (oldIfinusrIdOfAsignarTransaccionCollectionAsignarTransaccion != null) {
                    oldIfinusrIdOfAsignarTransaccionCollectionAsignarTransaccion.getAsignarTransaccionCollection().remove(asignarTransaccionCollectionAsignarTransaccion);
                    oldIfinusrIdOfAsignarTransaccionCollectionAsignarTransaccion = em.merge(oldIfinusrIdOfAsignarTransaccionCollectionAsignarTransaccion);
                }
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

    public void edit(AsignarIfinUsr asignarIfinUsr) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            AsignarIfinUsr persistentAsignarIfinUsr = em.find(AsignarIfinUsr.class, asignarIfinUsr.getIfinusrId());
            TipoCuenta ctaIdOld = persistentAsignarIfinUsr.getCtaId();
            TipoCuenta ctaIdNew = asignarIfinUsr.getCtaId();
            InstitucionFinanciera insfinIdentificacionOld = persistentAsignarIfinUsr.getInsfinIdentificacion();
            InstitucionFinanciera insfinIdentificacionNew = asignarIfinUsr.getInsfinIdentificacion();
            Usuario usrIdentificacionOld = persistentAsignarIfinUsr.getUsrIdentificacion();
            Usuario usrIdentificacionNew = asignarIfinUsr.getUsrIdentificacion();
            Collection<AsignarTransaccion> asignarTransaccionCollectionOld = persistentAsignarIfinUsr.getAsignarTransaccionCollection();
            Collection<AsignarTransaccion> asignarTransaccionCollectionNew = asignarIfinUsr.getAsignarTransaccionCollection();
            if (ctaIdNew != null) {
                ctaIdNew = em.getReference(ctaIdNew.getClass(), ctaIdNew.getCtaId());
                asignarIfinUsr.setCtaId(ctaIdNew);
            }
            if (insfinIdentificacionNew != null) {
                insfinIdentificacionNew = em.getReference(insfinIdentificacionNew.getClass(), insfinIdentificacionNew.getInsfinIdentificacion());
                asignarIfinUsr.setInsfinIdentificacion(insfinIdentificacionNew);
            }
            if (usrIdentificacionNew != null) {
                usrIdentificacionNew = em.getReference(usrIdentificacionNew.getClass(), usrIdentificacionNew.getUsrIdentificacion());
                asignarIfinUsr.setUsrIdentificacion(usrIdentificacionNew);
            }
            Collection<AsignarTransaccion> attachedAsignarTransaccionCollectionNew = new ArrayList<AsignarTransaccion>();
            for (AsignarTransaccion asignarTransaccionCollectionNewAsignarTransaccionToAttach : asignarTransaccionCollectionNew) {
                asignarTransaccionCollectionNewAsignarTransaccionToAttach = em.getReference(asignarTransaccionCollectionNewAsignarTransaccionToAttach.getClass(), asignarTransaccionCollectionNewAsignarTransaccionToAttach.getAsitraId());
                attachedAsignarTransaccionCollectionNew.add(asignarTransaccionCollectionNewAsignarTransaccionToAttach);
            }
            asignarTransaccionCollectionNew = attachedAsignarTransaccionCollectionNew;
            asignarIfinUsr.setAsignarTransaccionCollection(asignarTransaccionCollectionNew);
            asignarIfinUsr = em.merge(asignarIfinUsr);
            if (ctaIdOld != null && !ctaIdOld.equals(ctaIdNew)) {
                ctaIdOld.getAsignarIfinUsrCollection().remove(asignarIfinUsr);
                ctaIdOld = em.merge(ctaIdOld);
            }
            if (ctaIdNew != null && !ctaIdNew.equals(ctaIdOld)) {
                ctaIdNew.getAsignarIfinUsrCollection().add(asignarIfinUsr);
                ctaIdNew = em.merge(ctaIdNew);
            }
            if (insfinIdentificacionOld != null && !insfinIdentificacionOld.equals(insfinIdentificacionNew)) {
                insfinIdentificacionOld.getAsignarIfinUsrCollection().remove(asignarIfinUsr);
                insfinIdentificacionOld = em.merge(insfinIdentificacionOld);
            }
            if (insfinIdentificacionNew != null && !insfinIdentificacionNew.equals(insfinIdentificacionOld)) {
                insfinIdentificacionNew.getAsignarIfinUsrCollection().add(asignarIfinUsr);
                insfinIdentificacionNew = em.merge(insfinIdentificacionNew);
            }
            if (usrIdentificacionOld != null && !usrIdentificacionOld.equals(usrIdentificacionNew)) {
                usrIdentificacionOld.getAsignarIfinUsrCollection().remove(asignarIfinUsr);
                usrIdentificacionOld = em.merge(usrIdentificacionOld);
            }
            if (usrIdentificacionNew != null && !usrIdentificacionNew.equals(usrIdentificacionOld)) {
                usrIdentificacionNew.getAsignarIfinUsrCollection().add(asignarIfinUsr);
                usrIdentificacionNew = em.merge(usrIdentificacionNew);
            }
            for (AsignarTransaccion asignarTransaccionCollectionOldAsignarTransaccion : asignarTransaccionCollectionOld) {
                if (!asignarTransaccionCollectionNew.contains(asignarTransaccionCollectionOldAsignarTransaccion)) {
                    asignarTransaccionCollectionOldAsignarTransaccion.setIfinusrId(null);
                    asignarTransaccionCollectionOldAsignarTransaccion = em.merge(asignarTransaccionCollectionOldAsignarTransaccion);
                }
            }
            for (AsignarTransaccion asignarTransaccionCollectionNewAsignarTransaccion : asignarTransaccionCollectionNew) {
                if (!asignarTransaccionCollectionOld.contains(asignarTransaccionCollectionNewAsignarTransaccion)) {
                    AsignarIfinUsr oldIfinusrIdOfAsignarTransaccionCollectionNewAsignarTransaccion = asignarTransaccionCollectionNewAsignarTransaccion.getIfinusrId();
                    asignarTransaccionCollectionNewAsignarTransaccion.setIfinusrId(asignarIfinUsr);
                    asignarTransaccionCollectionNewAsignarTransaccion = em.merge(asignarTransaccionCollectionNewAsignarTransaccion);
                    if (oldIfinusrIdOfAsignarTransaccionCollectionNewAsignarTransaccion != null && !oldIfinusrIdOfAsignarTransaccionCollectionNewAsignarTransaccion.equals(asignarIfinUsr)) {
                        oldIfinusrIdOfAsignarTransaccionCollectionNewAsignarTransaccion.getAsignarTransaccionCollection().remove(asignarTransaccionCollectionNewAsignarTransaccion);
                        oldIfinusrIdOfAsignarTransaccionCollectionNewAsignarTransaccion = em.merge(oldIfinusrIdOfAsignarTransaccionCollectionNewAsignarTransaccion);
                    }
                }
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
                Integer id = asignarIfinUsr.getIfinusrId();
                if (findAsignarIfinUsr(id) == null) {
                    throw new NonexistentEntityException("The asignarIfinUsr with id " + id + " no longer exists.");
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
            AsignarIfinUsr asignarIfinUsr;
            try {
                asignarIfinUsr = em.getReference(AsignarIfinUsr.class, id);
                asignarIfinUsr.getIfinusrId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asignarIfinUsr with id " + id + " no longer exists.", enfe);
            }
            TipoCuenta ctaId = asignarIfinUsr.getCtaId();
            if (ctaId != null) {
                ctaId.getAsignarIfinUsrCollection().remove(asignarIfinUsr);
                ctaId = em.merge(ctaId);
            }
            InstitucionFinanciera insfinIdentificacion = asignarIfinUsr.getInsfinIdentificacion();
            if (insfinIdentificacion != null) {
                insfinIdentificacion.getAsignarIfinUsrCollection().remove(asignarIfinUsr);
                insfinIdentificacion = em.merge(insfinIdentificacion);
            }
            Usuario usrIdentificacion = asignarIfinUsr.getUsrIdentificacion();
            if (usrIdentificacion != null) {
                usrIdentificacion.getAsignarIfinUsrCollection().remove(asignarIfinUsr);
                usrIdentificacion = em.merge(usrIdentificacion);
            }
            Collection<AsignarTransaccion> asignarTransaccionCollection = asignarIfinUsr.getAsignarTransaccionCollection();
            for (AsignarTransaccion asignarTransaccionCollectionAsignarTransaccion : asignarTransaccionCollection) {
                asignarTransaccionCollectionAsignarTransaccion.setIfinusrId(null);
                asignarTransaccionCollectionAsignarTransaccion = em.merge(asignarTransaccionCollectionAsignarTransaccion);
            }
            em.remove(asignarIfinUsr);
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

    public List<AsignarIfinUsr> findAsignarIfinUsrEntities() {
        return findAsignarIfinUsrEntities(true, -1, -1);
    }

    public List<AsignarIfinUsr> findAsignarIfinUsrEntities(int maxResults, int firstResult) {
        return findAsignarIfinUsrEntities(false, maxResults, firstResult);
    }

    private List<AsignarIfinUsr> findAsignarIfinUsrEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AsignarIfinUsr.class));
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

    public AsignarIfinUsr findAsignarIfinUsr(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AsignarIfinUsr.class, id);
        } finally {
            em.close();
        }
    }

    public int getAsignarIfinUsrCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AsignarIfinUsr> rt = cq.from(AsignarIfinUsr.class);
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
