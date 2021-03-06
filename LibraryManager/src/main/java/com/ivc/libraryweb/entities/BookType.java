/*
 �������������-�������������� ����� ���������� ��������
 */
package com.ivc.libraryweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 *
 * @author �������������
 */
@Entity
@Table(name = "bookType")
@NamedQueries({
    @NamedQuery(name = "BookType.findAll",
            query = "SELECT t FROM BookType t"),
    @NamedQuery(name = "BookType.findWithDetail",
            query = "SELECT DISTINCT t FROM BookType t "
            + "LEFT JOIN FETCH t.books b "
            + "WHERE t.id = :id")
})
public class BookType implements Serializable {
    //-------------------Logger---------------------------------------------------

    //-------------------Constants------------------------------------------------
    public static final String ID_PROPERTY = "id";
    public static final String NAME_PROPERTY = "name";

    //-------------------Fields---------------------------------------------------
    @JsonProperty(ID_PROPERTY)
    private Long id;

    @JsonIgnore
    private int version;

    @JsonProperty(NAME_PROPERTY)
    private String name;

    @JsonIgnore
    private Set<Book> books = new HashSet<Book>();

    //-------------------Constructors---------------------------------------------
    public BookType() {
    }

    public BookType(String name) {
        this.name = name;
    }

    //-------------------Getters and setters--------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "bookType", fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE, orphanRemoval = true)
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    //-------------------Methods--------------------------------------------------
    public void addBook(@NotNull Book book) {
        books.add(book);
    }

    public void removeBook(@NotNull Book book) {
        books.remove(book);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
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
        final BookType other = (BookType) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
