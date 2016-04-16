/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slavasokolov.employeemanager.repositories;

import com.slavasokolov.employeemanager.entities.Employee;
import java.util.List;

/**
 *
 * @author Sokolov@ivc.org
 */
public interface EmployeeRepository {

    List<Employee> findAll();

    Employee create(Employee employee);

    Employee update(Employee employee);

    void delete(Employee employee);
    
}
