/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slavasokolov.employeemanager.controllers;

import static com.slavasokolov.employeemanager.controllers.EmployeeRestController.EMPLOYEES_PATH;
import com.slavasokolov.employeemanager.entities.Employee;
import com.slavasokolov.employeemanager.services.EmployeeService;
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
@RequestMapping(path = EMPLOYEES_PATH,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeRestController {

    public static final String EMPLOYEES_PATH = "/employees";
    public static final String ITEM_PATH = "/item";

    private EmployeeService employeeService;

    @Autowired(required = false)
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getEmployeeList() {
        return employeeService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee createDepartment(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee updateDepartment(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteDepartment(@RequestBody Employee employee) {
        employeeService.delete(employee);
    }

}
