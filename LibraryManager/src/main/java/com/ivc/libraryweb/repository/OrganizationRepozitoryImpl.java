/*
 Информационно-вычислительный центр космодрома Байконур
 */
package com.ivc.libraryweb.repository;

import com.ivc.libraryweb.entities.Organization;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Администратор
 */
@Service("jpaPostService")
@Transactional
@Repository
public class OrganizationRepozitoryImpl implements OrganizationRepository {

  //-------------------Logger---------------------------------------------------
  //-------------------Constants------------------------------------------------
    //-------------------Fields---------------------------------------------------
    @PersistenceContext
    private EntityManager em;
  //-------------------Constructors---------------------------------------------

  //-------------------Getters and setters--------------------------------------
    //-------------------Methods--------------------------------------------------
    public Organization addOrganization(Organization organization) {
        return new Organization();
    }
}
