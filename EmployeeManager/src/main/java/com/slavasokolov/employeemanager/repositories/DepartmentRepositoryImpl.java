/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slavasokolov.employeemanager.repositories;

import com.slavasokolov.employeemanager.entities.Department;
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
@Repository("jpaDepartmentRepository")
public class DepartmentRepositoryImpl implements DepartmentRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Department> findAll() {
        return em.createNamedQuery("Department.findAll").getResultList();
    }

    public Department create(Department department) {
        em.persist(department);
        return department;
    }

    public Department update(Department department) {
        return em.merge(department);
    }

    public void delete(Department department) {
        Department mergedDepartment = em.merge(department);
        em.remove(mergedDepartment);
    }

}
