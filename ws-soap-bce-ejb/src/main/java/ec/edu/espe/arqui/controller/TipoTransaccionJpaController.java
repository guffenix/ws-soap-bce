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
import ec.edu.espe.arqui.modelo.AsignarTransaccion;
import ec.edu.espe.arqui.modelo.TipoTransaccion;
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
public class TipoTransaccionJpaController implements Serializable {

    @Resource //inject from your application server
    private UserTransaction utx;
    private final EntityManagerFactory emf;
    public TipoTransaccionJpaController() {
        emf = Persistence.createEntityManagerFactory("soap_bce_PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoTransaccion tipoTransaccion) throws RollbackFailureException, Exception {
        if (tipoTransaccion.getAsignarTransaccionCollection() == null) {
            tipoTransaccion.setAsignarTransaccionCollection(new ArrayList<AsignarTransaccion>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<AsignarTransaccion> attachedAsignarTransaccionCollection = new ArrayList<AsignarTransaccion>();
            for (AsignarTransaccion asignarTransaccionCollectionAsignarTransaccionToAttach : tipoTransaccion.getAsignarTransaccionCollection()) {
                asignarTransaccionCollectionAsignarTransaccionToAttach = em.getReference(asignarTransaccionCollectionAsignarTransaccionToAttach.getClass(), asignarTransaccionCollectionAsignarTransaccionToAttach.getAsitraId());
                attachedAsignarTransaccionCollection.add(asignarTransaccionCollectionAsignarTransaccionToAttach);
            }
            tipoTransaccion.setAsignarTransaccionCollection(attachedAsignarTransaccionCollection);
            em.persist(tipoTransaccion);
            for (AsignarTransaccion asignarTransaccionCollectionAsignarTransaccion : tipoTransaccion.getAsignarTransaccionCollection()) {
                TipoTransaccion oldTraIdOfAsignarTransaccionCollectionAsignarTransaccion = asignarTransaccionCollectionAsignarTransaccion.getTraId();
                asignarTransaccionCollectionAsignarTransaccion.setTraId(tipoTransaccion);
                asignarTransaccionCollectionAsignarTransaccion = em.merge(asignarTransaccionCollectionAsignarTransaccion);
                if (oldTraIdOfAsignarTransaccionCollectionAsignarTransaccion != null) {
                    oldTraIdOfAsignarTransaccionCollectionAsignarTransaccion.getAsignarTransaccionCollection().remove(asignarTransaccionCollectionAsignarTransaccion);
                    oldTraIdOfAsignarTransaccionCollectionAsignarTransaccion = em.merge(oldTraIdOfAsignarTransaccionCollectionAsignarTransaccion);
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

    public void edit(TipoTransaccion tipoTransaccion) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            TipoTransaccion persistentTipoTransaccion = em.find(TipoTransaccion.class, tipoTransaccion.getTraId());
            Collection<AsignarTransaccion> asignarTransaccionCollectionOld = persistentTipoTransaccion.getAsignarTransaccionCollection();
            Collection<AsignarTransaccion> asignarTransaccionCollectionNew = tipoTransaccion.getAsignarTransaccionCollection();
            Collection<AsignarTransaccion> attachedAsignarTransaccionCollectionNew = new ArrayList<AsignarTransaccion>();
            for (AsignarTransaccion asignarTransaccionCollectionNewAsignarTransaccionToAttach : asignarTransaccionCollectionNew) {
                asignarTransaccionCollectionNewAsignarTransaccionToAttach = em.getReference(asignarTransaccionCollectionNewAsignarTransaccionToAttach.getClass(), asignarTransaccionCollectionNewAsignarTransaccionToAttach.getAsitraId());
                attachedAsignarTransaccionCollectionNew.add(asignarTransaccionCollectionNewAsignarTransaccionToAttach);
            }
            asignarTransaccionCollectionNew = attachedAsignarTransaccionCollectionNew;
            tipoTransaccion.setAsignarTransaccionCollection(asignarTransaccionCollectionNew);
            tipoTransaccion = em.merge(tipoTransaccion);
            for (AsignarTransaccion asignarTransaccionCollectionOldAsignarTransaccion : asignarTransaccionCollectionOld) {
                if (!asignarTransaccionCollectionNew.contains(asignarTransaccionCollectionOldAsignarTransaccion)) {
                    asignarTransaccionCollectionOldAsignarTransaccion.setTraId(null);
                    asignarTransaccionCollectionOldAsignarTransaccion = em.merge(asignarTransaccionCollectionOldAsignarTransaccion);
                }
            }
            for (AsignarTransaccion asignarTransaccionCollectionNewAsignarTransaccion : asignarTransaccionCollectionNew) {
                if (!asignarTransaccionCollectionOld.contains(asignarTransaccionCollectionNewAsignarTransaccion)) {
                    TipoTransaccion oldTraIdOfAsignarTransaccionCollectionNewAsignarTransaccion = asignarTransaccionCollectionNewAsignarTransaccion.getTraId();
                    asignarTransaccionCollectionNewAsignarTransaccion.setTraId(tipoTransaccion);
                    asignarTransaccionCollectionNewAsignarTransaccion = em.merge(asignarTransaccionCollectionNewAsignarTransaccion);
                    if (oldTraIdOfAsignarTransaccionCollectionNewAsignarTransaccion != null && !oldTraIdOfAsignarTransaccionCollectionNewAsignarTransaccion.equals(tipoTransaccion)) {
                        oldTraIdOfAsignarTransaccionCollectionNewAsignarTransaccion.getAsignarTransaccionCollection().remove(asignarTransaccionCollectionNewAsignarTransaccion);
                        oldTraIdOfAsignarTransaccionCollectionNewAsignarTransaccion = em.merge(oldTraIdOfAsignarTransaccionCollectionNewAsignarTransaccion);
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
                Integer id = tipoTransaccion.getTraId();
                if (findTipoTransaccion(id) == null) {
                    throw new NonexistentEntityException("The tipoTransaccion with id " + id + " no longer exists.");
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
            TipoTransaccion tipoTransaccion;
            try {
                tipoTransaccion = em.getReference(TipoTransaccion.class, id);
                tipoTransaccion.getTraId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoTransaccion with id " + id + " no longer exists.", enfe);
            }
            Collection<AsignarTransaccion> asignarTransaccionCollection = tipoTransaccion.getAsignarTransaccionCollection();
            for (AsignarTransaccion asignarTransaccionCollectionAsignarTransaccion : asignarTransaccionCollection) {
                asignarTransaccionCollectionAsignarTransaccion.setTraId(null);
                asignarTransaccionCollectionAsignarTransaccion = em.merge(asignarTransaccionCollectionAsignarTransaccion);
            }
            em.remove(tipoTransaccion);
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

    public List<TipoTransaccion> findTipoTransaccionEntities() {
        return findTipoTransaccionEntities(true, -1, -1);
    }

    public List<TipoTransaccion> findTipoTransaccionEntities(int maxResults, int firstResult) {
        return findTipoTransaccionEntities(false, maxResults, firstResult);
    }

    private List<TipoTransaccion> findTipoTransaccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoTransaccion.class));
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

    public TipoTransaccion findTipoTransaccion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoTransaccion.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoTransaccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoTransaccion> rt = cq.from(TipoTransaccion.class);
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
