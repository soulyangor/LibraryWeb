/*
 Информационно-вычислительный центр космодрома Байконур
 */
package com.ivc.libraryweb.repository;

import com.ivc.libraryweb.model.Page;
import java.util.LinkedList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Администратор
 */
@Service
@Transactional
@Repository
public class PageRepositoryImpl implements PageRepository {
  //-------------------Logger---------------------------------------------------

  //-------------------Constants------------------------------------------------
    //-------------------Fields---------------------------------------------------
    @PersistenceContext
    private EntityManager em;
  //-------------------Constructors---------------------------------------------
    //-------------------Getters and setters--------------------------------------
    //-------------------Methods--------------------------------------------------

    public Page save(@NotNull Page page) {
        em.persist(page);
        return page;
    }

    public Page delete(@NotNull Page page) {
        em.remove(page);
        return page;
    }

    public Page update(@NotNull Page page) {
        return em.merge(page);
    }

    public List<Page> find(@NotNull Page page) {
       // return em.createNamedQuery("Page.findBuDocId", Page.class).setParameter("id", page.getDocument()).getResultList();
        return new LinkedList<Page>();
    }

    public List<Page> findAll() {
       return em.createNamedQuery("Page.findAll", Page.class).getResultList();
     }
}
