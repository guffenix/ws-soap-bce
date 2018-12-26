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
import java.util.ArrayList;
import java.util.Collection;
import ec.edu.espe.arqui.modelo.AsignarIfinUsr;
import ec.edu.espe.arqui.modelo.Usuario;
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
public class UsuarioJpaController implements Serializable {

    @Resource //inject from your application server
    private UserTransaction utx;
    private final EntityManagerFactory emf;
    public UsuarioJpaController() {
        emf = Persistence.createEntityManagerFactory("soap_bce_PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) throws RollbackFailureException, Exception {
        if (usuario.getAsignarTransaccionCollection() == null) {
            usuario.setAsignarTransaccionCollection(new ArrayList<AsignarTransaccion>());
        }
        if (usuario.getAsignarIfinUsrCollection() == null) {
            usuario.setAsignarIfinUsrCollection(new ArrayList<AsignarIfinUsr>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<AsignarTransaccion> attachedAsignarTransaccionCollection = new ArrayList<AsignarTransaccion>();
            for (AsignarTransaccion asignarTransaccionCollectionAsignarTransaccionToAttach : usuario.getAsignarTransaccionCollection()) {
                asignarTransaccionCollectionAsignarTransaccionToAttach = em.getReference(asignarTransaccionCollectionAsignarTransaccionToAttach.getClass(), asignarTransaccionCollectionAsignarTransaccionToAttach.getAsitraId());
                attachedAsignarTransaccionCollection.add(asignarTransaccionCollectionAsignarTransaccionToAttach);
            }
            usuario.setAsignarTransaccionCollection(attachedAsignarTransaccionCollection);
            Collection<AsignarIfinUsr> attachedAsignarIfinUsrCollection = new ArrayList<AsignarIfinUsr>();
            for (AsignarIfinUsr asignarIfinUsrCollectionAsignarIfinUsrToAttach : usuario.getAsignarIfinUsrCollection()) {
                asignarIfinUsrCollectionAsignarIfinUsrToAttach = em.getReference(asignarIfinUsrCollectionAsignarIfinUsrToAttach.getClass(), asignarIfinUsrCollectionAsignarIfinUsrToAttach.getIfinusrId());
                attachedAsignarIfinUsrCollection.add(asignarIfinUsrCollectionAsignarIfinUsrToAttach);
            }
            usuario.setAsignarIfinUsrCollection(attachedAsignarIfinUsrCollection);
            em.persist(usuario);
            for (AsignarTransaccion asignarTransaccionCollectionAsignarTransaccion : usuario.getAsignarTransaccionCollection()) {
                Usuario oldUsrIdentificacionOfAsignarTransaccionCollectionAsignarTransaccion = asignarTransaccionCollectionAsignarTransaccion.getUsrIdentificacion();
                asignarTransaccionCollectionAsignarTransaccion.setUsrIdentificacion(usuario);
                asignarTransaccionCollectionAsignarTransaccion = em.merge(asignarTransaccionCollectionAsignarTransaccion);
                if (oldUsrIdentificacionOfAsignarTransaccionCollectionAsignarTransaccion != null) {
                    oldUsrIdentificacionOfAsignarTransaccionCollectionAsignarTransaccion.getAsignarTransaccionCollection().remove(asignarTransaccionCollectionAsignarTransaccion);
                    oldUsrIdentificacionOfAsignarTransaccionCollectionAsignarTransaccion = em.merge(oldUsrIdentificacionOfAsignarTransaccionCollectionAsignarTransaccion);
                }
            }
            for (AsignarIfinUsr asignarIfinUsrCollectionAsignarIfinUsr : usuario.getAsignarIfinUsrCollection()) {
                Usuario oldUsrIdentificacionOfAsignarIfinUsrCollectionAsignarIfinUsr = asignarIfinUsrCollectionAsignarIfinUsr.getUsrIdentificacion();
                asignarIfinUsrCollectionAsignarIfinUsr.setUsrIdentificacion(usuario);
                asignarIfinUsrCollectionAsignarIfinUsr = em.merge(asignarIfinUsrCollectionAsignarIfinUsr);
                if (oldUsrIdentificacionOfAsignarIfinUsrCollectionAsignarIfinUsr != null) {
                    oldUsrIdentificacionOfAsignarIfinUsrCollectionAsignarIfinUsr.getAsignarIfinUsrCollection().remove(asignarIfinUsrCollectionAsignarIfinUsr);
                    oldUsrIdentificacionOfAsignarIfinUsrCollectionAsignarIfinUsr = em.merge(oldUsrIdentificacionOfAsignarIfinUsrCollectionAsignarIfinUsr);
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

    public void edit(Usuario usuario) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getUsrIdentificacion());
            Collection<AsignarTransaccion> asignarTransaccionCollectionOld = persistentUsuario.getAsignarTransaccionCollection();
            Collection<AsignarTransaccion> asignarTransaccionCollectionNew = usuario.getAsignarTransaccionCollection();
            Collection<AsignarIfinUsr> asignarIfinUsrCollectionOld = persistentUsuario.getAsignarIfinUsrCollection();
            Collection<AsignarIfinUsr> asignarIfinUsrCollectionNew = usuario.getAsignarIfinUsrCollection();
            Collection<AsignarTransaccion> attachedAsignarTransaccionCollectionNew = new ArrayList<AsignarTransaccion>();
            for (AsignarTransaccion asignarTransaccionCollectionNewAsignarTransaccionToAttach : asignarTransaccionCollectionNew) {
                asignarTransaccionCollectionNewAsignarTransaccionToAttach = em.getReference(asignarTransaccionCollectionNewAsignarTransaccionToAttach.getClass(), asignarTransaccionCollectionNewAsignarTransaccionToAttach.getAsitraId());
                attachedAsignarTransaccionCollectionNew.add(asignarTransaccionCollectionNewAsignarTransaccionToAttach);
            }
            asignarTransaccionCollectionNew = attachedAsignarTransaccionCollectionNew;
            usuario.setAsignarTransaccionCollection(asignarTransaccionCollectionNew);
            Collection<AsignarIfinUsr> attachedAsignarIfinUsrCollectionNew = new ArrayList<AsignarIfinUsr>();
            for (AsignarIfinUsr asignarIfinUsrCollectionNewAsignarIfinUsrToAttach : asignarIfinUsrCollectionNew) {
                asignarIfinUsrCollectionNewAsignarIfinUsrToAttach = em.getReference(asignarIfinUsrCollectionNewAsignarIfinUsrToAttach.getClass(), asignarIfinUsrCollectionNewAsignarIfinUsrToAttach.getIfinusrId());
                attachedAsignarIfinUsrCollectionNew.add(asignarIfinUsrCollectionNewAsignarIfinUsrToAttach);
            }
            asignarIfinUsrCollectionNew = attachedAsignarIfinUsrCollectionNew;
            usuario.setAsignarIfinUsrCollection(asignarIfinUsrCollectionNew);
            usuario = em.merge(usuario);
            for (AsignarTransaccion asignarTransaccionCollectionOldAsignarTransaccion : asignarTransaccionCollectionOld) {
                if (!asignarTransaccionCollectionNew.contains(asignarTransaccionCollectionOldAsignarTransaccion)) {
                    asignarTransaccionCollectionOldAsignarTransaccion.setUsrIdentificacion(null);
                    asignarTransaccionCollectionOldAsignarTransaccion = em.merge(asignarTransaccionCollectionOldAsignarTransaccion);
                }
            }
            for (AsignarTransaccion asignarTransaccionCollectionNewAsignarTransaccion : asignarTransaccionCollectionNew) {
                if (!asignarTransaccionCollectionOld.contains(asignarTransaccionCollectionNewAsignarTransaccion)) {
                    Usuario oldUsrIdentificacionOfAsignarTransaccionCollectionNewAsignarTransaccion = asignarTransaccionCollectionNewAsignarTransaccion.getUsrIdentificacion();
                    asignarTransaccionCollectionNewAsignarTransaccion.setUsrIdentificacion(usuario);
                    asignarTransaccionCollectionNewAsignarTransaccion = em.merge(asignarTransaccionCollectionNewAsignarTransaccion);
                    if (oldUsrIdentificacionOfAsignarTransaccionCollectionNewAsignarTransaccion != null && !oldUsrIdentificacionOfAsignarTransaccionCollectionNewAsignarTransaccion.equals(usuario)) {
                        oldUsrIdentificacionOfAsignarTransaccionCollectionNewAsignarTransaccion.getAsignarTransaccionCollection().remove(asignarTransaccionCollectionNewAsignarTransaccion);
                        oldUsrIdentificacionOfAsignarTransaccionCollectionNewAsignarTransaccion = em.merge(oldUsrIdentificacionOfAsignarTransaccionCollectionNewAsignarTransaccion);
                    }
                }
            }
            for (AsignarIfinUsr asignarIfinUsrCollectionOldAsignarIfinUsr : asignarIfinUsrCollectionOld) {
                if (!asignarIfinUsrCollectionNew.contains(asignarIfinUsrCollectionOldAsignarIfinUsr)) {
                    asignarIfinUsrCollectionOldAsignarIfinUsr.setUsrIdentificacion(null);
                    asignarIfinUsrCollectionOldAsignarIfinUsr = em.merge(asignarIfinUsrCollectionOldAsignarIfinUsr);
                }
            }
            for (AsignarIfinUsr asignarIfinUsrCollectionNewAsignarIfinUsr : asignarIfinUsrCollectionNew) {
                if (!asignarIfinUsrCollectionOld.contains(asignarIfinUsrCollectionNewAsignarIfinUsr)) {
                    Usuario oldUsrIdentificacionOfAsignarIfinUsrCollectionNewAsignarIfinUsr = asignarIfinUsrCollectionNewAsignarIfinUsr.getUsrIdentificacion();
                    asignarIfinUsrCollectionNewAsignarIfinUsr.setUsrIdentificacion(usuario);
                    asignarIfinUsrCollectionNewAsignarIfinUsr = em.merge(asignarIfinUsrCollectionNewAsignarIfinUsr);
                    if (oldUsrIdentificacionOfAsignarIfinUsrCollectionNewAsignarIfinUsr != null && !oldUsrIdentificacionOfAsignarIfinUsrCollectionNewAsignarIfinUsr.equals(usuario)) {
                        oldUsrIdentificacionOfAsignarIfinUsrCollectionNewAsignarIfinUsr.getAsignarIfinUsrCollection().remove(asignarIfinUsrCollectionNewAsignarIfinUsr);
                        oldUsrIdentificacionOfAsignarIfinUsrCollectionNewAsignarIfinUsr = em.merge(oldUsrIdentificacionOfAsignarIfinUsrCollectionNewAsignarIfinUsr);
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
                String id = usuario.getUsrIdentificacion();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getUsrIdentificacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            Collection<AsignarTransaccion> asignarTransaccionCollection = usuario.getAsignarTransaccionCollection();
            for (AsignarTransaccion asignarTransaccionCollectionAsignarTransaccion : asignarTransaccionCollection) {
                asignarTransaccionCollectionAsignarTransaccion.setUsrIdentificacion(null);
                asignarTransaccionCollectionAsignarTransaccion = em.merge(asignarTransaccionCollectionAsignarTransaccion);
            }
            Collection<AsignarIfinUsr> asignarIfinUsrCollection = usuario.getAsignarIfinUsrCollection();
            for (AsignarIfinUsr asignarIfinUsrCollectionAsignarIfinUsr : asignarIfinUsrCollection) {
                asignarIfinUsrCollectionAsignarIfinUsr.setUsrIdentificacion(null);
                asignarIfinUsrCollectionAsignarIfinUsr = em.merge(asignarIfinUsrCollectionAsignarIfinUsr);
            }
            em.remove(usuario);
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

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
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
