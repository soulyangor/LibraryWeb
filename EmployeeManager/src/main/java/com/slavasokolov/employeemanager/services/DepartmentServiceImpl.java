/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slavasokolov.employeemanager.services;

import com.slavasokolov.employeemanager.entities.Department;
import com.slavasokolov.employeemanager.repositories.DepartmentRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sokolov@ivc.org
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired(required = false)
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department create(Department department) {
        Department rootDepartment = department.getDepartment();
        departmentRepository.create(department);
        if (rootDepartment != null) {
            rootDepartment.addDepartment(department);
            departmentRepository.update(rootDepartment);
        }
        return department;
    }

    public Department update(Department oldDepartment, Department newDepartment) {
        departmentRepository.update(newDepartment);
        if (oldDepartment.getDepartment() == null) {
            Department rootDepartment = newDepartment.getDepartment();
            if (rootDepartment != null) {
                rootDepartment.addDepartment(newDepartment);
                departmentRepository.update(rootDepartment);
            }
        } else {
            Department oldRootDepartment = oldDepartment.getDepartment();
            Department rootDepartment = newDepartment.getDepartment();
            oldRootDepartment.removeDepartment(oldDepartment);
            departmentRepository.update(oldRootDepartment);
            if (rootDepartment != null) {
                rootDepartment.addDepartment(newDepartment);
                departmentRepository.update(rootDepartment);
            }
        }
        return newDepartment;
    }

    public void delete(Department department) {
        for (Department d : getDepartmentTree(department)) {
            departmentRepository.delete(d);
        }
    }

    private List<Department> getDepartmentTree(Department root) {
        List<Department> result = new ArrayList<Department>();
        List<Department> currentList = new ArrayList<Department>();
        List<Department> tmpList = new ArrayList<Department>();
        List<Department> deleteList = new ArrayList<Department>();
        currentList.add(root);
        while (!currentList.isEmpty()) {
            for (Department d : currentList) {
                result.add(d);
                deleteList.add(d);
                for (Department dd : d.getDepartments()) {
                    tmpList.add(dd);
                }
            }
            currentList.removeAll(deleteList);
            currentList.addAll(tmpList);
            deleteList.clear();
        }
        return result;
    }

}
