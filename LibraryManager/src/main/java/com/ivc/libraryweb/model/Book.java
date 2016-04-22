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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {
  //-------------------Logger---------------------------------------------------
  
  //-------------------Constants------------------------------------------------

  //-------------------Fields---------------------------------------------------
@JsonProperty
private long id;
@JsonProperty
private String name;
@JsonProperty
private String inventoryNumber;
@JsonProperty
private String declimalNumber;
@JsonProperty
private String bookNumber;
@JsonProperty
private String bookPart;
@JsonProperty
private String copyNumber;
@JsonProperty
private int listCount;
@JsonProperty
private Category category;
@JsonProperty
private Organization organization;
@JsonProperty
private BookType bookTypeId;
@JsonProperty
private Set<Document> documents;
@JsonProperty
private Set<Delivery> delivereis;
  //-------------------Constructors---------------------------------------------
public Book(){}
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
    @Column(name="INVENTORY_NUMBER")
    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }
    @Column(name="DECLIMAL_NUMBER")
    public String getDeclimalNumber() {
        return declimalNumber;
    }

    public void setDeclimalNumber(String declimalNumber) {
        this.declimalNumber = declimalNumber;
    }
    @Column(name="BOOK_NUMBER")
    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }
    @Column(name="BOOK_PART")
    public String getBookPart() {
        return bookPart;
    }
    
    public void setBookPart(String bookPart) {
        this.bookPart = bookPart;
    }
    @Column(name="COPY_NUMBER")
    public String getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(String copyNumber) {
        this.copyNumber = copyNumber;
    }
    @Column(name="LIST_COUNT")
    public int getListCount() {
        return listCount;
    }

    public void setListCount(int listCount) {
        this.listCount = listCount;
    }
    
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_ID")
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    
    @ManyToOne
    @JoinColumn(name="BOOK_TYPE_ID")
    public BookType getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(BookType bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    @Column(name="DOCUMENTS")
    @OneToMany(mappedBy = "bookId",cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    @Column(name="DELIVERYS")
    @OneToMany(mappedBy = "bookId",cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Delivery> getDeliverys() {
        return delivereis;
    }

    public void setDeliverys(Set<Delivery> deliverys) {
        this.delivereis = deliverys;
    }
  //-------------------Methods--------------------------------------------------
    public void addDocument(@NotNull Document document ){
        this.documents.add(document);
    }
    public boolean removeDocument(@NotNull Document document){
        return this.documents.remove(document);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 23 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 23 * hash + (this.inventoryNumber != null ? this.inventoryNumber.hashCode() : 0);
        hash = 23 * hash + (this.declimalNumber != null ? this.declimalNumber.hashCode() : 0);
        hash = 23 * hash + (this.bookNumber != null ? this.bookNumber.hashCode() : 0);
        hash = 23 * hash + (this.bookPart != null ? this.bookPart.hashCode() : 0);
        hash = 23 * hash + (this.copyNumber != null ? this.copyNumber.hashCode() : 0);
        hash = 23 * hash + (this.category != null ? this.category.hashCode() : 0);
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
        final Book other = (Book) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.inventoryNumber == null) ? (other.inventoryNumber != null) : !this.inventoryNumber.equals(other.inventoryNumber)) {
            return false;
        }
        if ((this.declimalNumber == null) ? (other.declimalNumber != null) : !this.declimalNumber.equals(other.declimalNumber)) {
            return false;
        }
        if ((this.bookNumber == null) ? (other.bookNumber != null) : !this.bookNumber.equals(other.bookNumber)) {
            return false;
        }
        if ((this.bookPart == null) ? (other.bookPart != null) : !this.bookPart.equals(other.bookPart)) {
            return false;
        }
        if ((this.copyNumber == null) ? (other.copyNumber != null) : !this.copyNumber.equals(other.copyNumber)) {
            return false;
        }
        if (this.listCount != other.listCount) {
            return false;
        }
        if (this.category != other.category && (this.category == null || !this.category.equals(other.category))) {
            return false;
        }
        return true;
    }

   
    
    
}