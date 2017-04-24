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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "proces")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proces.findAll", query = "SELECT p FROM Proces p")
    , @NamedQuery(name = "Proces.findByIdProcesa", query = "SELECT p FROM Proces p WHERE p.idProcesa = :idProcesa")
    , @NamedQuery(name = "Proces.findByNaziv", query = "SELECT p FROM Proces p WHERE p.naziv = :naziv")
    , @NamedQuery(name = "Proces.findByOznaka", query = "SELECT p FROM Proces p WHERE p.oznaka = :oznaka")
    , @NamedQuery(name = "Proces.findByOpis", query = "SELECT p FROM Proces p WHERE p.opis = :opis")
    , @NamedQuery(name = "Proces.findByNivo", query = "SELECT p FROM Proces p WHERE p.nivo = :nivo")})
public class Proces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_procesa")
    private Integer idProcesa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "oznaka")
    private String oznaka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivo")
    private int nivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcesa")
    private Collection<Aktivnost> aktivnostCollection;
    @JoinColumn(name = "id_podsistema", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Podsistem idPodsistema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNadprocesa")
    private Collection<Proces> procesCollection;
    @JoinColumn(name = "id_nadprocesa", referencedColumnName = "id_procesa")
    @ManyToOne(optional = false)
    private Proces idNadprocesa;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Proces() {
    }

    public Proces(Integer idProcesa) {
        this.idProcesa = idProcesa;
    }

    public Proces(Integer idProcesa, String naziv, String oznaka, String opis, int nivo) {
        this.idProcesa = idProcesa;
        this.naziv = naziv;
        this.oznaka = oznaka;
        this.opis = opis;
        this.nivo = nivo;
    }

    public Integer getIdProcesa() {
        return idProcesa;
    }

    public void setIdProcesa(Integer idProcesa) {
        this.idProcesa = idProcesa;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getNivo() {
        return nivo;
    }

    public void setNivo(int nivo) {
        this.nivo = nivo;
    }

    @XmlTransient
    public Collection<Aktivnost> getAktivnostCollection() {
        return aktivnostCollection;
    }

    public void setAktivnostCollection(Collection<Aktivnost> aktivnostCollection) {
        this.aktivnostCollection = aktivnostCollection;
    }

    public Podsistem getIdPodsistema() {
        return idPodsistema;
    }

    public void setIdPodsistema(Podsistem idPodsistema) {
        this.idPodsistema = idPodsistema;
    }

    @XmlTransient
    public Collection<Proces> getProcesCollection() {
        return procesCollection;
    }

    public void setProcesCollection(Collection<Proces> procesCollection) {
        this.procesCollection = procesCollection;
    }

    public Proces getIdNadprocesa() {
        return idNadprocesa;
    }

    public void setIdNadprocesa(Proces idNadprocesa) {
        this.idNadprocesa = idNadprocesa;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcesa != null ? idProcesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proces)) {
            return false;
        }
        Proces other = (Proces) object;
        if ((this.idProcesa == null && other.idProcesa != null) || (this.idProcesa != null && !this.idProcesa.equals(other.idProcesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nst.model.Proces[ idProcesa=" + idProcesa + " ]";
    }
    
}
