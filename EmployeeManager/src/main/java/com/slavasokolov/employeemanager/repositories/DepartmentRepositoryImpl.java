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
        Department rootDepartment = department.getRootDepartment();
        if (rootDepartment != null) {
            rootDepartment = em.find(Department.class, rootDepartment.getId());
            rootDepartment.addDepartment(department);
            em.merge(rootDepartment);
        }
        em.persist(department);
        return department;
    }

    public Department update(Department department) {
        Department newRoot = department.getRootDepartment();
        Department oldRoot = find(department).getRootDepartment();
        int version = em.find(Department.class, department.getId()).getVersion();
        department.setVersion(version);
        em.merge(department);
        if (newRoot == null && oldRoot == null) {
            return em.merge(department);
        }
        if (newRoot == null && oldRoot != null) {
            oldRoot = find(oldRoot);
            oldRoot.removeDepartment(department);
            em.merge(oldRoot);
        }
        if (newRoot != null && oldRoot == null) {
            newRoot = find(newRoot);
            newRoot.addDepartment(department);
            em.merge(newRoot);
        }
        if (newRoot != null && oldRoot != null) {
            if (!newRoot.equals(oldRoot)) {
                newRoot = find(newRoot);
                newRoot.addDepartment(department);
                oldRoot = find(oldRoot);
                oldRoot.removeDepartment(department);
                em.merge(oldRoot);
                em.merge(newRoot);
            }
        }
        return department;
    }

    public Department find(Department department) {
        return em.createNamedQuery("Department.findWithDetail", Department.class)
                .setParameter("id", department.getId()).getSingleResult();
    }

    public void delete(Department department) {
        Department delDep = em.find(Department.class, department.getId());
        em.remove(delDep);
    }

}
