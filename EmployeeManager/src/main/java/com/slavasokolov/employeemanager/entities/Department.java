/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slavasokolov.employeemanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author Sokolov@ivc.org
 */
@Entity
@Table(name = "department")
@NamedQueries({
    @NamedQuery(name = "Department.findAll",
            query = "SELECT d FROM Department d")})
public class Department implements Serializable {

    public static final String ID_PROPERTY = "id";
    public static final String NAME_PROPERTY = "name";
    public static final String DEPARTMENT_PROPERTY = "department";

    @JsonProperty(ID_PROPERTY)
    private Long id;

    @JsonIgnore
    private int version;

    @JsonProperty(NAME_PROPERTY)
    private String name;

    @JsonProperty(DEPARTMENT_PROPERTY)
    private Department department;

    @JsonIgnore
    private Set<Employee> employees = new HashSet<Employee>();

    @JsonIgnore
    private Set<Department> departments = new HashSet<Department>();

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,
            orphanRemoval = true)
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,
            orphanRemoval = true)
    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        return !((this.id == null && other.id != null)
                || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Department - Id: " + id + ", Name: " + name
                + ", Root: " + department + ", depList: " + departments;
    }

    public void addEmployee(Employee employee) {
        employee.setDepartment(this);
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void addDepartment(Department department) {
        department.setDepartment(this);
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

}
