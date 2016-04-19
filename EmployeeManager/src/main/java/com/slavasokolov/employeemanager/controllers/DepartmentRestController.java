/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slavasokolov.employeemanager.controllers;

import static com.slavasokolov.employeemanager.controllers.DepartmentRestController.DEPARTMENTS_PATH;
import com.slavasokolov.employeemanager.entities.Department;
import com.slavasokolov.employeemanager.repositories.DepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sokolov@ivc.org
 */
@RestController
@RequestMapping(path = DEPARTMENTS_PATH,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentRestController {

    public static final String DEPARTMENTS_PATH = "/departments";
    public static final String ITEM_PATH = "/item";

    private DepartmentRepository departmentRepository;

    @Autowired(required = false)
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.create(department);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Department updateDepartment(@RequestBody Department department) {
        return departmentRepository.update(department);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteDepartment(@RequestBody Department department) {
        departmentRepository.delete(department);
    }

}
