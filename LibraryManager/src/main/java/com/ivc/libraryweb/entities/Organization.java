/*
 �?нформационно-вычислительный центр космодрома Байконур
 */
package com.ivc.libraryweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "organization")
public class Organization implements Serializable {
    //-------------------Logger---------------------------------------------------

    //-------------------Constants------------------------------------------------
    public static final String ID_PROPERTY = "id";
    public static final String NAME_PROPERTY = "name";
    public static final String ADDRESS_PROPERTY = "address";

    //-------------------Fields---------------------------------------------------
    @JsonProperty(ID_PROPERTY)
    private Long id;

    @JsonProperty(NAME_PROPERTY)
    private String name;

    @JsonProperty(ADDRESS_PROPERTY)
    private String address;

    @JsonIgnore
    private Set<Book> books;

    //-------------------Constructors---------------------------------------------
    public Organization() {
    }

    public Organization(String name, String address) {
        this.name = name;
        this.address = address;
    }

    //-------------------Getters and setters--------------------------------------
    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "BOOKS")
    @OneToMany(mappedBy = "organization", orphanRemoval = true, cascade = CascadeType.ALL)
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    //-------------------Methods-------------------------------------------------
    public void addBook(Book book) {
        this.books.add(book);
    }

    public boolean removeBook(Book book) {
        return this.books.remove(book);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 17 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 17 * hash + (this.address != null ? this.address.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Organization other = (Organization) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.address == null) ? (other.address != null) : !this.address.equals(other.address)) {
            return false;
        }
        return true;
    }

}
