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
import ec.edu.espe.arqui.modelo.AsignarIfinUsr;
import ec.edu.espe.arqui.modelo.TipoCuenta;
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
public class TipoCuentaJpaController implements Serializable {

    @Resource //inject from your application server
    private UserTransaction utx;
    private final EntityManagerFactory emf;
    public TipoCuentaJpaController() {
        emf = Persistence.createEntityManagerFactory("soap_bce_PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoCuenta tipoCuenta) throws RollbackFailureException, Exception {
        if (tipoCuenta.getAsignarIfinUsrCollection() == null) {
            tipoCuenta.setAsignarIfinUsrCollection(new ArrayList<AsignarIfinUsr>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<AsignarIfinUsr> attachedAsignarIfinUsrCollection = new ArrayList<AsignarIfinUsr>();
            for (AsignarIfinUsr asignarIfinUsrCollectionAsignarIfinUsrToAttach : tipoCuenta.getAsignarIfinUsrCollection()) {
                asignarIfinUsrCollectionAsignarIfinUsrToAttach = em.getReference(asignarIfinUsrCollectionAsignarIfinUsrToAttach.getClass(), asignarIfinUsrCollectionAsignarIfinUsrToAttach.getIfinusrId());
                attachedAsignarIfinUsrCollection.add(asignarIfinUsrCollectionAsignarIfinUsrToAttach);
            }
            tipoCuenta.setAsignarIfinUsrCollection(attachedAsignarIfinUsrCollection);
            em.persist(tipoCuenta);
            for (AsignarIfinUsr asignarIfinUsrCollectionAsignarIfinUsr : tipoCuenta.getAsignarIfinUsrCollection()) {
                TipoCuenta oldCtaIdOfAsignarIfinUsrCollectionAsignarIfinUsr = asignarIfinUsrCollectionAsignarIfinUsr.getCtaId();
                asignarIfinUsrCollectionAsignarIfinUsr.setCtaId(tipoCuenta);
                asignarIfinUsrCollectionAsignarIfinUsr = em.merge(asignarIfinUsrCollectionAsignarIfinUsr);
                if (oldCtaIdOfAsignarIfinUsrCollectionAsignarIfinUsr != null) {
                    oldCtaIdOfAsignarIfinUsrCollectionAsignarIfinUsr.getAsignarIfinUsrCollection().remove(asignarIfinUsrCollectionAsignarIfinUsr);
                    oldCtaIdOfAsignarIfinUsrCollectionAsignarIfinUsr = em.merge(oldCtaIdOfAsignarIfinUsrCollectionAsignarIfinUsr);
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

    public void edit(TipoCuenta tipoCuenta) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            TipoCuenta persistentTipoCuenta = em.find(TipoCuenta.class, tipoCuenta.getCtaId());
            Collection<AsignarIfinUsr> asignarIfinUsrCollectionOld = persistentTipoCuenta.getAsignarIfinUsrCollection();
            Collection<AsignarIfinUsr> asignarIfinUsrCollectionNew = tipoCuenta.getAsignarIfinUsrCollection();
            Collection<AsignarIfinUsr> attachedAsignarIfinUsrCollectionNew = new ArrayList<AsignarIfinUsr>();
            for (AsignarIfinUsr asignarIfinUsrCollectionNewAsignarIfinUsrToAttach : asignarIfinUsrCollectionNew) {
                asignarIfinUsrCollectionNewAsignarIfinUsrToAttach = em.getReference(asignarIfinUsrCollectionNewAsignarIfinUsrToAttach.getClass(), asignarIfinUsrCollectionNewAsignarIfinUsrToAttach.getIfinusrId());
                attachedAsignarIfinUsrCollectionNew.add(asignarIfinUsrCollectionNewAsignarIfinUsrToAttach);
            }
            asignarIfinUsrCollectionNew = attachedAsignarIfinUsrCollectionNew;
            tipoCuenta.setAsignarIfinUsrCollection(asignarIfinUsrCollectionNew);
            tipoCuenta = em.merge(tipoCuenta);
            for (AsignarIfinUsr asignarIfinUsrCollectionOldAsignarIfinUsr : asignarIfinUsrCollectionOld) {
                if (!asignarIfinUsrCollectionNew.contains(asignarIfinUsrCollectionOldAsignarIfinUsr)) {
                    asignarIfinUsrCollectionOldAsignarIfinUsr.setCtaId(null);
                    asignarIfinUsrCollectionOldAsignarIfinUsr = em.merge(asignarIfinUsrCollectionOldAsignarIfinUsr);
                }
            }
            for (AsignarIfinUsr asignarIfinUsrCollectionNewAsignarIfinUsr : asignarIfinUsrCollectionNew) {
                if (!asignarIfinUsrCollectionOld.contains(asignarIfinUsrCollectionNewAsignarIfinUsr)) {
                    TipoCuenta oldCtaIdOfAsignarIfinUsrCollectionNewAsignarIfinUsr = asignarIfinUsrCollectionNewAsignarIfinUsr.getCtaId();
                    asignarIfinUsrCollectionNewAsignarIfinUsr.setCtaId(tipoCuenta);
                    asignarIfinUsrCollectionNewAsignarIfinUsr = em.merge(asignarIfinUsrCollectionNewAsignarIfinUsr);
                    if (oldCtaIdOfAsignarIfinUsrCollectionNewAsignarIfinUsr != null && !oldCtaIdOfAsignarIfinUsrCollectionNewAsignarIfinUsr.equals(tipoCuenta)) {
                        oldCtaIdOfAsignarIfinUsrCollectionNewAsignarIfinUsr.getAsignarIfinUsrCollection().remove(asignarIfinUsrCollectionNewAsignarIfinUsr);
                        oldCtaIdOfAsignarIfinUsrCollectionNewAsignarIfinUsr = em.merge(oldCtaIdOfAsignarIfinUsrCollectionNewAsignarIfinUsr);
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
                Integer id = tipoCuenta.getCtaId();
                if (findTipoCuenta(id) == null) {
                    throw new NonexistentEntityException("The tipoCuenta with id " + id + " no longer exists.");
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
            TipoCuenta tipoCuenta;
            try {
                tipoCuenta = em.getReference(TipoCuenta.class, id);
                tipoCuenta.getCtaId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoCuenta with id " + id + " no longer exists.", enfe);
            }
            Collection<AsignarIfinUsr> asignarIfinUsrCollection = tipoCuenta.getAsignarIfinUsrCollection();
            for (AsignarIfinUsr asignarIfinUsrCollectionAsignarIfinUsr : asignarIfinUsrCollection) {
                asignarIfinUsrCollectionAsignarIfinUsr.setCtaId(null);
                asignarIfinUsrCollectionAsignarIfinUsr = em.merge(asignarIfinUsrCollectionAsignarIfinUsr);
            }
            em.remove(tipoCuenta);
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

    public List<TipoCuenta> findTipoCuentaEntities() {
        return findTipoCuentaEntities(true, -1, -1);
    }

    public List<TipoCuenta> findTipoCuentaEntities(int maxResults, int firstResult) {
        return findTipoCuentaEntities(false, maxResults, firstResult);
    }

    private List<TipoCuenta> findTipoCuentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoCuenta.class));
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

    public TipoCuenta findTipoCuenta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoCuenta.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoCuentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoCuenta> rt = cq.from(TipoCuenta.class);
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
