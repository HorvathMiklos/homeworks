package xyz.codingmentor.jpahomework.repo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import xyz.codingmentor.jpahomework.api.EntityType;
import xyz.codingmentor.jpahomework.api.WriterRepository;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.entities.Writer;
import xyz.codingmentor.jpahomework.api.RepoQualifyer;

/**
 *
 * @author mhorvath
 */
@Stateless
@RepoQualifyer(EntityType.WRITER)
public class WriterRepo implements WriterRepository{
    
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public WriterRepo() {
        factory = Persistence.createEntityManagerFactory("jpahomeworkpersistenceunit");
        entityManager = factory.createEntityManager();
    
    }    
    
    @Override
    public Writer createWriter(Writer writer) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(writer);
        tx.commit();
        return writer;
    }

    @Override
    public Writer findWriter(Long id) throws RepositoryException {
        Writer writer = entityManager.find(Writer.class, id);
        if (null != writer) {
            return writer;
        }
        return null;
    }

    @Override
    public Writer updateWriter(Writer writer) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(writer);
        tx.commit();
        return writer;
    }

    @Override
    public Writer removeWriter(Long id) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Writer writer = entityManager.find(Writer.class, id);
        if (null != writer) {
            entityManager.remove(writer);
        }
        tx.commit();
        return writer;
    }
    
    public void close(){
        entityManager.close();
        factory.close();
    }     
}
