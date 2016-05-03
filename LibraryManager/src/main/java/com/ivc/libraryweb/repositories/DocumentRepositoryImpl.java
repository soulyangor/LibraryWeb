package com.ivc.libraryweb.repositories;

import com.ivc.libraryweb.entities.Document;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author VitaliyDenisov
 */
@Transactional
@Repository("jpaDocumentRepository")
public class DocumentRepositoryImpl implements DocumentRepository {

  //-------------------Logger---------------------------------------------------
  //-------------------Constants------------------------------------------------
  //-------------------Fields---------------------------------------------------
    @PersistenceContext
    private EntityManager em;

  //-------------------Constructors---------------------------------------------
  //-------------------Getters and setters--------------------------------------
    //-------------------Methods--------------------------------------------------
    public List<Document> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Document find(Document document) {
        return em.find(Document.class,document.getId());
    }

    public Document findWithDetail(Document book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Document create(Document document) {
       em.persist(document);
       return document;
    }

    public Document update(Document book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Document book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
