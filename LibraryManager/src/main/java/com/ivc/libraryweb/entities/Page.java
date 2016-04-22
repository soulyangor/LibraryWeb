/*
 Информационно-вычислительный центр космодрома Байконур
 */
package com.ivc.libraryweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Version;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "page")
@NamedQueries({
    @NamedQuery(name = "Page.findAll",
            query = "SELECT p FROM Page p"),
    @NamedQuery(name = "Page.findWithDetail",
            query = "SELECT DISTINCT p FROM Page p "
            + "LEFT JOIN FETCH p.document d "
            + "WHERE p.id = :id")
})
public class Page implements Serializable {
    //-------------------Logger---------------------------------------------------

    //-------------------Constants------------------------------------------------
    public static final String ID_PROPERTY = "id";
    public static final String NAME_PROPERTY = "name";
    public static final String DOCUMENT_PROPERTY = "document";

    //-------------------Fields---------------------------------------------------
    @JsonProperty(ID_PROPERTY)
    private Long id;

    @JsonIgnore
    private int version;

    @JsonProperty(NAME_PROPERTY)
    private String name;

    @JsonIgnore
    private byte[] pageData;

    @JsonProperty(DOCUMENT_PROPERTY)
    private Document document;

    //-------------------Constructors---------------------------------------------
    public Page(String name) {
        this.name = name;
    }

    public Page() {
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

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID")
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document DocumentId) {
        this.document = DocumentId;
    }

    @Column(name = "PAGE_DATA")
    public byte[] getPageData() {
        return pageData;
    }

    public void setPageData(byte[] pageData) {
        this.pageData = pageData;
    }

    //-------------------Methods--------------------------------------------------
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 83 * hash + Arrays.hashCode(this.pageData);
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
        if (!Arrays.equals(this.pageData, other.pageData)) {
            return false;
        }
        if (this.document != other.document && (this.document == null || !this.document.equals(other.document))) {
            return false;
        }
        return true;
    }

}
