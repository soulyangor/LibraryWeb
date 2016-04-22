/*
   Информационно-вычислительный центр космодрома Байконур
*/

package com.ivc.libraryweb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "delivery")
public class Delivery implements Serializable {
  //-------------------Logger---------------------------------------------------
  
  //-------------------Constants------------------------------------------------
public  Delivery(){}
  //-------------------Fields---------------------------------------------------
@JsonProperty
private long id;
@JsonProperty
private Date deliveryDate;
@JsonProperty
private Date surrenderDate;
@JsonProperty
private Book bookId;
@JsonProperty
private long employeId;
  //-------------------Constructors---------------------------------------------

  //-------------------Getters and setters--------------------------------------

  //-------------------Methods--------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="DELIVERY_DATE")
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="SURRENDER_DATE")
    public Date getSurrenderDate() {
        return surrenderDate;
    }

    public void setSurrenderDate(Date surrenderDate) {
        this.surrenderDate = surrenderDate;
    }

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    @Column(name="EMPLOYE_ID")
    public long getEmployeId() {
        return employeId;
    }

    public void setEmployeId(long employeId) {
        this.employeId = employeId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + (int) (this.employeId ^ (this.employeId >>> 32));
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
        final Delivery other = (Delivery) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.employeId != other.employeId) {
            return false;
        }
        return true;
    }
    
    

}