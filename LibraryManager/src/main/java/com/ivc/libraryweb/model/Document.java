/*
   Информационно-вычислительный центр космодрома Байконур
*/

package com.ivc.libraryweb.model;

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

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "document")
public class Document implements Serializable {
  //-------------------Logger---------------------------------------------------
  
  //-------------------Constants------------------------------------------------
  //-------------------Fields---------------------------------------------------
@JsonProperty
private long id;
@JsonProperty
private String incomeNumber;
@JsonProperty
private String outcomeNumber;
@JsonProperty
private Set<Page> pages;
@JsonProperty
private Date incomeDate;
@JsonProperty
private Date outcomeDate;
@JsonProperty
private long modification;
@JsonProperty
private Book bookId;
  //-------------------Constructors---------------------------------------------
public Document(){
}
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
    @Column(name = "INCOME_NUMBER")
    public String getIncomeNumber() {
        return incomeNumber;
    }

    public void setIncomeNumber(String incomeNumber) {
        this.incomeNumber = incomeNumber;
    }
    @Column(name ="OUTCOME_NUMBER")
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

    @Column(name="MODIFICATION")
    public long getModification() {
        return modification;
    }

    public void setModification(long modification) {
        this.modification = modification;
    }
    @Column(name="PAGES")
    @OneToMany(mappedBy = "document",cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Page> getPages() {
        return pages;
    }

    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }

    @ManyToOne
    @JoinColumn(name="BOOK_ID")
    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }
//-------------------Methods--------------------------------------------------
    
    public void addPage(Page page){
        this.pages.add(page);
    }
    
    public boolean removePage(Page page){
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