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
import ec.edu.espe.arqui.modelo.InstitucionFinanciera;
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
public class InstitucionFinancieraJpaController implements Serializable {

    @Resource //inject from your application server
    private UserTransaction utx;
    private final EntityManagerFactory emf;
    public InstitucionFinancieraJpaController() {
        emf = Persistence.createEntityManagerFactory("soap_bce_PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InstitucionFinanciera institucionFinanciera) throws RollbackFailureException, Exception {
        if (institucionFinanciera.getAsignarIfinUsrCollection() == null) {
            institucionFinanciera.setAsignarIfinUsrCollection(new ArrayList<AsignarIfinUsr>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<AsignarIfinUsr> attachedAsignarIfinUsrCollection = new ArrayList<AsignarIfinUsr>();
            for (AsignarIfinUsr asignarIfinUsrCollectionAsignarIfinUsrToAttach : institucionFinanciera.getAsignarIfinUsrCollection()) {
                asignarIfinUsrCollectionAsignarIfinUsrToAttach = em.getReference(asignarIfinUsrCollectionAsignarIfinUsrToAttach.getClass(), asignarIfinUsrCollectionAsignarIfinUsrToAttach.getIfinusrId());
                attachedAsignarIfinUsrCollection.add(asignarIfinUsrCollectionAsignarIfinUsrToAttach);
            }
            institucionFinanciera.setAsignarIfinUsrCollection(attachedAsignarIfinUsrCollection);
            em.persist(institucionFinanciera);
            for (AsignarIfinUsr asignarIfinUsrCollectionAsignarIfinUsr : institucionFinanciera.getAsignarIfinUsrCollection()) {
                InstitucionFinanciera oldInsfinIdentificacionOfAsignarIfinUsrCollectionAsignarIfinUsr = asignarIfinUsrCollectionAsignarIfinUsr.getInsfinIdentificacion();
                asignarIfinUsrCollectionAsignarIfinUsr.setInsfinIdentificacion(institucionFinanciera);
                asignarIfinUsrCollectionAsignarIfinUsr = em.merge(asignarIfinUsrCollectionAsignarIfinUsr);
                if (oldInsfinIdentificacionOfAsignarIfinUsrCollectionAsignarIfinUsr != null) {
                    oldInsfinIdentificacionOfAsignarIfinUsrCollectionAsignarIfinUsr.getAsignarIfinUsrCollection().remove(asignarIfinUsrCollectionAsignarIfinUsr);
                    oldInsfinIdentificacionOfAsignarIfinUsrCollectionAsignarIfinUsr = em.merge(oldInsfinIdentificacionOfAsignarIfinUsrCollectionAsignarIfinUsr);
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

    public void edit(InstitucionFinanciera institucionFinanciera) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            InstitucionFinanciera persistentInstitucionFinanciera = em.find(InstitucionFinanciera.class, institucionFinanciera.getInsfinIdentificacion());
            Collection<AsignarIfinUsr> asignarIfinUsrCollectionOld = persistentInstitucionFinanciera.getAsignarIfinUsrCollection();
            Collection<AsignarIfinUsr> asignarIfinUsrCollectionNew = institucionFinanciera.getAsignarIfinUsrCollection();
            Collection<AsignarIfinUsr> attachedAsignarIfinUsrCollectionNew = new ArrayList<AsignarIfinUsr>();
            for (AsignarIfinUsr asignarIfinUsrCollectionNewAsignarIfinUsrToAttach : asignarIfinUsrCollectionNew) {
                asignarIfinUsrCollectionNewAsignarIfinUsrToAttach = em.getReference(asignarIfinUsrCollectionNewAsignarIfinUsrToAttach.getClass(), asignarIfinUsrCollectionNewAsignarIfinUsrToAttach.getIfinusrId());
                attachedAsignarIfinUsrCollectionNew.add(asignarIfinUsrCollectionNewAsignarIfinUsrToAttach);
            }
            asignarIfinUsrCollectionNew = attachedAsignarIfinUsrCollectionNew;
            institucionFinanciera.setAsignarIfinUsrCollection(asignarIfinUsrCollectionNew);
            institucionFinanciera = em.merge(institucionFinanciera);
            for (AsignarIfinUsr asignarIfinUsrCollectionOldAsignarIfinUsr : asignarIfinUsrCollectionOld) {
                if (!asignarIfinUsrCollectionNew.contains(asignarIfinUsrCollectionOldAsignarIfinUsr)) {
                    asignarIfinUsrCollectionOldAsignarIfinUsr.setInsfinIdentificacion(null);
                    asignarIfinUsrCollectionOldAsignarIfinUsr = em.merge(asignarIfinUsrCollectionOldAsignarIfinUsr);
                }
            }
            for (AsignarIfinUsr asignarIfinUsrCollectionNewAsignarIfinUsr : asignarIfinUsrCollectionNew) {
                if (!asignarIfinUsrCollectionOld.contains(asignarIfinUsrCollectionNewAsignarIfinUsr)) {
                    InstitucionFinanciera oldInsfinIdentificacionOfAsignarIfinUsrCollectionNewAsignarIfinUsr = asignarIfinUsrCollectionNewAsignarIfinUsr.getInsfinIdentificacion();
                    asignarIfinUsrCollectionNewAsignarIfinUsr.setInsfinIdentificacion(institucionFinanciera);
                    asignarIfinUsrCollectionNewAsignarIfinUsr = em.merge(asignarIfinUsrCollectionNewAsignarIfinUsr);
                    if (oldInsfinIdentificacionOfAsignarIfinUsrCollectionNewAsignarIfinUsr != null && !oldInsfinIdentificacionOfAsignarIfinUsrCollectionNewAsignarIfinUsr.equals(institucionFinanciera)) {
                        oldInsfinIdentificacionOfAsignarIfinUsrCollectionNewAsignarIfinUsr.getAsignarIfinUsrCollection().remove(asignarIfinUsrCollectionNewAsignarIfinUsr);
                        oldInsfinIdentificacionOfAsignarIfinUsrCollectionNewAsignarIfinUsr = em.merge(oldInsfinIdentificacionOfAsignarIfinUsrCollectionNewAsignarIfinUsr);
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
                Integer id = institucionFinanciera.getInsfinIdentificacion();
                if (findInstitucionFinanciera(id) == null) {
                    throw new NonexistentEntityException("The institucionFinanciera with id " + id + " no longer exists.");
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
            InstitucionFinanciera institucionFinanciera;
            try {
                institucionFinanciera = em.getReference(InstitucionFinanciera.class, id);
                institucionFinanciera.getInsfinIdentificacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The institucionFinanciera with id " + id + " no longer exists.", enfe);
            }
            Collection<AsignarIfinUsr> asignarIfinUsrCollection = institucionFinanciera.getAsignarIfinUsrCollection();
            for (AsignarIfinUsr asignarIfinUsrCollectionAsignarIfinUsr : asignarIfinUsrCollection) {
                asignarIfinUsrCollectionAsignarIfinUsr.setInsfinIdentificacion(null);
                asignarIfinUsrCollectionAsignarIfinUsr = em.merge(asignarIfinUsrCollectionAsignarIfinUsr);
            }
            em.remove(institucionFinanciera);
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

    public List<InstitucionFinanciera> findInstitucionFinancieraEntities() {
        return findInstitucionFinancieraEntities(true, -1, -1);
    }

    public List<InstitucionFinanciera> findInstitucionFinancieraEntities(int maxResults, int firstResult) {
        return findInstitucionFinancieraEntities(false, maxResults, firstResult);
    }

    private List<InstitucionFinanciera> findInstitucionFinancieraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InstitucionFinanciera.class));
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

    public InstitucionFinanciera findInstitucionFinanciera(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InstitucionFinanciera.class, id);
        } finally {
            em.close();
        }
    }

    public int getInstitucionFinancieraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InstitucionFinanciera> rt = cq.from(InstitucionFinanciera.class);
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
