/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivc.libraryweb.repositories;

import com.ivc.libraryweb.entities.BookType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sokolov@ivc.org
 */
@Transactional
@Repository("jpaBookTypeRepository")
public class BookTypeRepositoryImpl implements BookTypeRepository {

    //-------------------Logger---------------------------------------------------
    //-------------------Constants------------------------------------------------
    //-------------------Fields---------------------------------------------------
    @PersistenceContext
    private EntityManager em;

    //-------------------Constructors---------------------------------------------
    //-------------------Getters and setters--------------------------------------
    //-------------------Methods--------------------------------------------------
    public List<BookType> findAll() {
        return em.createNamedQuery("BookType.findAll", BookType.class)
                .getResultList();
    }

    public BookType find(BookType bookType) {
        return em.find(BookType.class, bookType.getId());
    }

    public BookType findWithDetail(BookType bookType) {
        return em.createNamedQuery("BookType.findWithDetail", BookType.class)
                .setParameter("id", bookType.getId()).getSingleResult();
    }

    public BookType create(BookType bookType) {
        em.persist(bookType);
        return bookType;
    }

    public BookType update(BookType bookType) {
        int version = find(bookType).getVersion();
        bookType.setVersion(version);
        return em.merge(bookType);
    }

    public void delete(BookType bookType) {
        em.remove(find(bookType));
    }

}
