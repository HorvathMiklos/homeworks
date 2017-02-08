package xyz.codingmentor.jpahomework.repo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpahomework.api.EntityType;
import xyz.codingmentor.jpahomework.api.WriterDTO;
import xyz.codingmentor.jpahomework.api.WriterRepository;
import xyz.codingmentor.jpahomework.exceptions.RepositoryException;
import xyz.codingmentor.jpahomework.model.entities.Book;
import xyz.codingmentor.jpahomework.model.entities.Writer;
import xyz.codingmentor.jpahomework.api.RepoQualifyer;

/**
 *
 * @author mhorvath
 */
@Stateless
@RepoQualifyer(EntityType.WRITER)
public class WriterRepo implements WriterRepository{
    /*
    @PersistenceContext(unitName = "jpahomeworkpersistenceunit")
    private EntityManager entityManager;

    public WriterRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }*/
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public WriterRepo() {
        factory = Persistence.createEntityManagerFactory("jpahomeworkpersistenceunit");
        entityManager = factory.createEntityManager();
    
    }
    
    
    
    @Override
    public WriterDTO createWriter(WriterDTO writerDTO) throws RepositoryException {
        Writer writer = new Writer(writerDTO);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(writer);
        tx.commit();
        return buildWriter(writer);
    }

    @Override
    public WriterDTO findWriter(Long id) throws RepositoryException {
        return null;
    }

    @Override
    public WriterDTO updateWriter(WriterDTO writerDTO) throws RepositoryException {
        return null;
    }

    @Override
    public WriterDTO removeWriter(Long id) throws RepositoryException {
        return null;
    }
    
    private WriterDTO buildWriter(Writer writer){
        WriterDTO writerDTO=new WriterDTO();
        writerDTO.setId(writer.getId());
        writerDTO.setName(writer.getName());
        return null;
    }

   
}
