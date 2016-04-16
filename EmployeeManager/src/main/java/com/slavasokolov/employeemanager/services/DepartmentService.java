/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slavasokolov.employeemanager.services;

import com.slavasokolov.employeemanager.entities.Department;
import java.util.List;

/**
 *
 * @author Sokolov@ivc.org
 */
public interface DepartmentService {

    List<Department> findAll();

    Department create(Department department);

    Department update(Department oldDepartment, Department newDepartment);

    void delete(Department department);

}
