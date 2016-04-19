/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slavasokolov.employeemanager.services;

import com.slavasokolov.employeemanager.entities.Department;
import com.slavasokolov.employeemanager.entities.Employee;
import com.slavasokolov.employeemanager.entities.Post;
import com.slavasokolov.employeemanager.repositories.DepartmentRepository;
import com.slavasokolov.employeemanager.repositories.EmployeeRepository;
import com.slavasokolov.employeemanager.repositories.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sokolov@ivc.org
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private PostRepository postRepository;
    private DepartmentRepository departmentRepository;

    @Autowired(required = false)
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired(required = false)
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Autowired(required = false)
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee create(Employee employee) {
        Post post = postRepository.find(employee.getPost());
        if (post != null) {
            post.addEmployee(employee);
            postRepository.update(post);
        }
        Department department = departmentRepository.find(employee.getDepartment());
        if (department != null) {
            department.addEmployee(employee);
            departmentRepository.update(department);
        }
        return employeeRepository.create(employee);
    }

    public Employee update(Employee employee) {
        employeeRepository.update(employee);
        changeDepartment(employee);
        changePost(employee);
        return employee;
    }

    public void delete(Employee employee) {
        Post post = postRepository.find(employee.getPost());
        if (post != null) {
            post.removeEmployee(employee);
            postRepository.update(post);
        }
        Department department = departmentRepository.find(employee.getDepartment());
        if (department != null) {
            department.removeEmployee(employee);
            departmentRepository.update(department);
        }
        employeeRepository.delete(employee);
    }

    private void changeDepartment(Employee employee) {
        Department newDep = employee.getDepartment();
        Department oldDep = employeeRepository.find(employee).getDepartment();
        if (newDep == null && oldDep != null) {
            oldDep = departmentRepository.find(oldDep);
            departmentRepository.update(oldDep);
        }
        if (newDep != null && oldDep == null) {
            newDep = departmentRepository.find(newDep);
            newDep.addEmployee(employee);
            departmentRepository.update(newDep);
        }
        if (newDep != null && oldDep != null) {
            if (!newDep.equals(oldDep)) {
                oldDep = departmentRepository.find(oldDep);
                oldDep.removeEmployee(employee);
                newDep = departmentRepository.find(newDep);
                newDep.addEmployee(employee);
                departmentRepository.update(newDep);
                departmentRepository.update(oldDep);
            }
        }
    }

    private void changePost(Employee employee) {
        Post newPost = employee.getPost();
        Post oldPost = employeeRepository.find(employee).getPost();
        if (newPost == null && oldPost != null) {
            oldPost = postRepository.find(oldPost);
            postRepository.update(oldPost);
        }
        if (newPost != null && oldPost == null) {
            newPost = postRepository.find(newPost);
            newPost.addEmployee(employee);
            postRepository.update(newPost);
        }
        if (newPost != null && oldPost != null) {
            if (!newPost.equals(oldPost)) {
                oldPost = postRepository.find(oldPost);
                oldPost.removeEmployee(employee);
                newPost = postRepository.find(newPost);
                newPost.addEmployee(employee);
                postRepository.update(newPost);
                postRepository.update(oldPost);
            }
        }
    }

}
