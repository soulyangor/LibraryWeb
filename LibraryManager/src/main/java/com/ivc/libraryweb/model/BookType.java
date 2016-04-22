/*
   Информационно-вычислительный центр космодрома Байконур
*/

package com.ivc.libraryweb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "bookType")
public class BookType implements Serializable  {
  //-------------------Logger---------------------------------------------------
  
  //-------------------Constants------------------------------------------------

  //-------------------Fields---------------------------------------------------
@JsonProperty
private long id;
@JsonProperty
private String name;
@JsonProperty
private Set<Book> books;
  //-------------------Constructors---------------------------------------------
public BookType(){}
  //-------------------Getters and setters--------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name="NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
  @Column(name="BOOKS")
  @OneToMany(mappedBy = "bookTypeId",cascade = CascadeType.ALL, orphanRemoval = true)  
  public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

  //-------------------Methods--------------------------------------------------

    public void addBook(@NotNull Book book){
        this.books.add(book);
    }
    
    public boolean removeBook(@NotNull Book book){
        return this.books.remove(book);
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