/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivc.libraryweb.repositories;

import com.ivc.libraryweb.entities.Category;
import com.ivc.libraryweb.entities.Organization;
import java.util.List;

/**
 *
 * @author VitaliyDenisov
 */
public interface OrganizationRepository {
    Organization create(Organization organization);
    void delete(Organization organization);
    Organization update(Organization organization);
    List<Organization> findAll();
    Organization find(Organization organization);
    Organization findWithDetail(Organization organization);
}
