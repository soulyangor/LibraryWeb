/*
 Информационно-вычислительный центр космодрома Байконур
 */
package com.ivc.libraryweb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "page")
@NamedQueries({@NamedQuery(name="Page.findAll",query="SELECT c FROM Page c")})
public class Page implements Serializable {
  //-------------------Logger---------------------------------------------------

    //-------------------Constants------------------------------------------------
    private static final String ID_ATTRIDUTE = "id";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String DOCUMENT_ID_ATTRIBUTE = "documentId";
    //-------------------Fields---------------------------------------------------
    @JsonProperty(ID_ATTRIDUTE)
    private long id;
    @JsonProperty(NAME_ATTRIBUTE)
    private String name;
    private byte[] data; 
    @JsonProperty(DOCUMENT_ID_ATTRIBUTE)
    private Document document;
  //-------------------Constructors---------------------------------------------
    public Page(){}
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

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID")
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document DocumentId) {
        this.document = DocumentId;
    }

    @Column(name="DATA")
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 83 * hash + Arrays.hashCode(this.data);
        hash = 83 * hash + (this.document != null ? this.document.hashCode() : 0);
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
        final Page other = (Page) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (!Arrays.equals(this.data, other.data)) {
            return false;
        }
        if (this.document != other.document && (this.document == null || !this.document.equals(other.document))) {
            return false;
        }
        return true;
    }

    
}
