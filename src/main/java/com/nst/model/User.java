/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author milisava
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId")
    , @NamedQuery(name = "User.findByIme", query = "SELECT u FROM User u WHERE u.ime = :ime")
    , @NamedQuery(name = "User.findByPrezime", query = "SELECT u FROM User u WHERE u.prezime = :prezime")
    , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByUlica", query = "SELECT u FROM User u WHERE u.ulica = :ulica")
    , @NamedQuery(name = "User.findByTelefon", query = "SELECT u FROM User u WHERE u.telefon = :telefon")
    , @NamedQuery(name = "User.findByAktivan", query = "SELECT u FROM User u WHERE u.aktivan = :aktivan")
    , @NamedQuery(name = "User.findByAdmin", query = "SELECT u FROM User u WHERE u.admin = :admin")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ulica")
    private String ulica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "telefon")
    private String telefon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aktivan")
    private boolean aktivan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "admin")
    private boolean admin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Dokument> dokumentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Aktivnost> aktivnostCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Podsistem> podsistemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Proces> procesCollection;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String ime, String prezime, String username, String password, String ulica, String telefon, boolean aktivan, boolean admin) {
        this.userId = userId;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.ulica = ulica;
        this.telefon = telefon;
        this.aktivan = aktivan;
        this.admin = admin;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @XmlTransient
    public Collection<Dokument> getDokumentCollection() {
        return dokumentCollection;
    }

    public void setDokumentCollection(Collection<Dokument> dokumentCollection) {
        this.dokumentCollection = dokumentCollection;
    }

    @XmlTransient
    public Collection<Aktivnost> getAktivnostCollection() {
        return aktivnostCollection;
    }

    public void setAktivnostCollection(Collection<Aktivnost> aktivnostCollection) {
        this.aktivnostCollection = aktivnostCollection;
    }

    @XmlTransient
    public Collection<Podsistem> getPodsistemCollection() {
        return podsistemCollection;
    }

    public void setPodsistemCollection(Collection<Podsistem> podsistemCollection) {
        this.podsistemCollection = podsistemCollection;
    }

    @XmlTransient
    public Collection<Proces> getProcesCollection() {
        return procesCollection;
    }

    public void setProcesCollection(Collection<Proces> procesCollection) {
        this.procesCollection = procesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nst.model.User[ userId=" + userId + " ]";
    }
    
}
