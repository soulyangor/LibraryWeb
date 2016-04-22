/*
 Информационно-вычислительный центр космодрома Байконур
 */
package com.ivc.libraryweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "document")
public class Document implements Serializable {
    //-------------------Logger---------------------------------------------------

    //-------------------Constants------------------------------------------------
    public static final String ID_PROPERTY = "id";
    public static final String MODIFICATION_PROPERTY = "modification";
    public static final String INCOME_NUMBER_PROPERTY = "incomenumber";
    public static final String OUTCOME_NUMBER_PROPERTY = "outcomenumber";
    public static final String INCOME_DATE_PROPERTY = "incomedate";
    public static final String OUTCOME_DATE_PROPERTY = "outcomedate";
    public static final String BOOK_PROPERTY = "book";

    //-------------------Fields---------------------------------------------------
    @JsonProperty(ID_PROPERTY)
    private Long id;

    @JsonProperty(MODIFICATION_PROPERTY)
    private int modification;

    @JsonIgnore
    private int version;

    @JsonProperty(INCOME_NUMBER_PROPERTY)
    private String incomeNumber;

    @JsonProperty(OUTCOME_NUMBER_PROPERTY)
    private String outcomeNumber;

    @JsonProperty(INCOME_DATE_PROPERTY)
    private Date incomeDate;

    @JsonProperty(OUTCOME_DATE_PROPERTY)
    private Date outcomeDate;

    @JsonProperty(BOOK_PROPERTY)
    private Book book;

    @JsonIgnore
    private Set<Page> pages;
    //-------------------Constructors---------------------------------------------

    public Document(int modification, String incomeNumber, String outcomeNumber,
            Date incomeDate, Date outcomeDate) {
        this.modification = modification;
        this.incomeNumber = incomeNumber;
        this.outcomeNumber = outcomeNumber;
        this.incomeDate = incomeDate;
        this.outcomeDate = outcomeDate;
    }

    public Document() {
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

    @Column(name = "INCOME_NUMBER")
    public String getIncomeNumber() {
        return incomeNumber;
    }

    public void setIncomeNumber(String incomeNumber) {
        this.incomeNumber = incomeNumber;
    }

    @Column(name = "OUTCOME_NUMBER")
    public String getOutcomeNumber() {
        return outcomeNumber;
    }

    public void setOutcomeNumber(String outcomeNumber) {
        this.outcomeNumber = outcomeNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "INCOME_DATE")
    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "OUTCOME_DATE")
    public Date getOutcomeDate() {
        return outcomeDate;
    }

    public void setOutcomeDate(Date outcomeDate) {
        this.outcomeDate = outcomeDate;
    }

    @Column(name = "MODIFICATION")
    public Integer getModification() {
        return modification;
    }

    public void setModification(Integer modification) {
        this.modification = modification;
    }

    @Column(name = "PAGES")
    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Page> getPages() {
        return pages;
    }

    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
//-------------------Methods--------------------------------------------------

    public void addPage(Page page) {
        this.pages.add(page);
    }

    public boolean removePage(Page page) {
        return this.pages.remove(page);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 73 * hash + (this.incomeNumber != null ? this.incomeNumber.hashCode() : 0);
        hash = 73 * hash + (this.pages != null ? this.pages.hashCode() : 0);
        hash = 73 * hash + (int) (this.modification ^ (this.modification >>> 32));
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
        final Document other = (Document) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.incomeNumber == null) ? (other.incomeNumber != null) : !this.incomeNumber.equals(other.incomeNumber)) {
            return false;
        }
        if (this.pages != other.pages && (this.pages == null || !this.pages.equals(other.pages))) {
            return false;
        }
        if (this.modification != other.modification) {
            return false;
        }
        return true;
    }

}
