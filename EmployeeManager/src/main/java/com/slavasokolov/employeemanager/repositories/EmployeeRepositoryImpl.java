/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slavasokolov.employeemanager.repositories;

import com.slavasokolov.employeemanager.entities.Employee;
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
@Repository("jpaEmployeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Employee> findAll() {
        return em.createNamedQuery("Employee.findAll").getResultList();
    }

    public void delete(Employee employee) {
        Employee delEmployee = em.find(Employee.class, employee.getId());
        em.remove(delEmployee);
    }

    public Employee create(Employee employee) {
        em.persist(employee);
        return employee;
    }

    public Employee update(Employee employee) {
        int version = em.find(Employee.class, employee.getId()).getVersion();
        employee.setVersion(version);
        return em.merge(employee);
    }

    public Employee find(Employee employee) {
        return em.find(Employee.class, employee.getId());
    }
}
