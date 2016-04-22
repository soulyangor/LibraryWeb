/*
 Информационно-вычислительный центр космодрома Байконур
 */
package com.ivc.libraryweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "book")
@NamedQueries({
    @NamedQuery(name = "Book.findAll",
            query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findWithDetail",
            query = "SELECT DISTINCT b FROM Book b "
            + "LEFT JOIN FETCH b.documents d "
            + "LEFT JOIN FETCH b.deliveries l "
            + "WHERE b.id = :id")
})
public class Book implements Serializable {
    //-------------------Logger---------------------------------------------------

    //-------------------Constants------------------------------------------------
    public static final String ID_PROPERTY = "id";
    public static final String NAME_PROPERTY = "name";
    public static final String INVENTORY_NUMBER_PROPERTY = "inventorynumber";
    public static final String DECIMAL_NUMBER_PROPERTY = "decimalnumber";
    public static final String BOOK_NUMBER_PROPERTY = "booknumber";
    public static final String BOOK_PART_PROPERTY = "bookpart";
    public static final String COPY_NUMBER_PROPERTY = "copynumber";
    public static final String CATEGORY_PROPERTY = "category";
    public static final String ORGANIZATION_PROPERTY = "organization";
    public static final String BOOK_TYPE_PROPERTY = "booktype";
    public static final String LIST_COUNT_PROPERTY = "listcount";

    //-------------------Fields---------------------------------------------------
    @JsonProperty(ID_PROPERTY)
    private Long id;

    @JsonIgnore
    private int version;

    @JsonProperty(NAME_PROPERTY)
    private String name;

    @JsonProperty(INVENTORY_NUMBER_PROPERTY)
    private String inventoryNumber;

    @JsonProperty(DECIMAL_NUMBER_PROPERTY)
    private String declimalNumber;

    @JsonProperty(BOOK_NUMBER_PROPERTY)
    private String bookNumber;

    @JsonProperty(BOOK_PART_PROPERTY)
    private String bookPart;

    @JsonProperty(COPY_NUMBER_PROPERTY)
    private String copyNumber;

    @JsonProperty(LIST_COUNT_PROPERTY)
    private int listCount;

    @JsonProperty(CATEGORY_PROPERTY)
    private Category category;

    @JsonProperty(ORGANIZATION_PROPERTY)
    private Organization organization;

    @JsonProperty(BOOK_TYPE_PROPERTY)
    private BookType bookType;

    @JsonIgnore
    private Set<Document> documents;

    @JsonIgnore
    private Set<Delivery> deliveries;

    //-------------------Constructors---------------------------------------------
    public Book() {
    }

    public Book(String name, String inventoryNumber, String decimalNumber,
            String bookNumber, String bookPart, String copyNumber) {
        this.name = name;
        this.inventoryNumber = inventoryNumber;
        this.declimalNumber = decimalNumber;
        this.bookNumber = bookNumber;
        this.bookPart = bookPart;
        this.copyNumber = copyNumber;
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

    @Column(name = "INVENTORY_NUMBER")
    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    @Column(name = "DECLIMAL_NUMBER")
    public String getDeclimalNumber() {
        return declimalNumber;
    }

    public void setDeclimalNumber(String declimalNumber) {
        this.declimalNumber = declimalNumber;
    }

    @Column(name = "BOOK_NUMBER")
    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    @Column(name = "BOOK_PART")
    public String getBookPart() {
        return bookPart;
    }

    public void setBookPart(String bookPart) {
        this.bookPart = bookPart;
    }

    @Column(name = "COPY_NUMBER")
    public String getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(String copyNumber) {
        this.copyNumber = copyNumber;
    }

    @Column(name = "LIST_COUNT")
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
    @JoinColumn(name = "BOOK_TYPE_ID")
    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    @Column(name = "DOCUMENTS")
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    @Column(name = "DELIVERIES")
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    //-------------------Methods--------------------------------------------------
    public void addDocument(@NotNull Document document) {
        documents.add(document);
    }

    public void removeDocument(@NotNull Document document) {
        documents.remove(document);
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
