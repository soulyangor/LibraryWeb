/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slavasokolov.employeemanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author Sokolov@ivc.org
 */
@Entity
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")})
public class Employee implements Serializable {

    public static final String ID_PROPERTY = "id";
    public static final String FIRSTNAME_PROPERTY = "firstname";
    public static final String SECONDNAME_PROPERTY = "secondname";
    public static final String LASTNAME_PROPERTY = "lastname";
    public static final String POST_PROPERTY = "post";
    public static final String DEPARTMENT_PROPERTY = "department";
    //public static final String START_WORK_DATE_PROPERTY = "worksince";

    @JsonProperty(ID_PROPERTY)
    private Long id;

    @JsonIgnore
    private int version;

    @JsonProperty(FIRSTNAME_PROPERTY)
    private String firstName;

    @JsonProperty(SECONDNAME_PROPERTY)
    private String secondName;

    @JsonProperty(LASTNAME_PROPERTY)
    private String lastName;

    /*@JsonProperty(START_WORK_DATE_PROPERTY)
    private Date startWorkDate;*/

    @JsonProperty(DEPARTMENT_PROPERTY)
    private Department department;

    @JsonProperty(POST_PROPERTY)
    private Post post;

    public Employee() {
    }

    public Employee(String firstName, String secondName, String lastName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
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

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "SECOND_NAME")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

   /* @Temporal(TemporalType.DATE)
    @Column(name = "START_WORK_DATE")
    public Date getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }*/

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        return !((this.id == null && other.id != null)
                || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Employee - Id: " + id + ", First name: " + firstName
                + ", Second name: " + secondName
                + ", Last name: " + lastName;
    }

}
