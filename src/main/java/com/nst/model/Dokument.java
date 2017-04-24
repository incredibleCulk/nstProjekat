/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author milisava
 */
@Entity
@Table(name = "dokument")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dokument.findAll", query = "SELECT d FROM Dokument d")
    , @NamedQuery(name = "Dokument.findByIdDokumenta", query = "SELECT d FROM Dokument d WHERE d.idDokumenta = :idDokumenta")
    , @NamedQuery(name = "Dokument.findByNapomena", query = "SELECT d FROM Dokument d WHERE d.napomena = :napomena")
    , @NamedQuery(name = "Dokument.findByDatum", query = "SELECT d FROM Dokument d WHERE d.datum = :datum")
    , @NamedQuery(name = "Dokument.findByLokacijaModela", query = "SELECT d FROM Dokument d WHERE d.lokacijaModela = :lokacijaModela")
    , @NamedQuery(name = "Dokument.findByPoslato", query = "SELECT d FROM Dokument d WHERE d.poslato = :poslato")})
public class Dokument implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dokumenta")
    private Integer idDokumenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "napomena")
    private String napomena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "lokacija_modela")
    private String lokacijaModela;
    @Basic(optional = false)
    @NotNull
    @Column(name = "poslato")
    private boolean poslato;
    @JoinColumn(name = "id_tipa_dokumenta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipDokumenta idTipaDokumenta;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Dokument() {
    }

    public Dokument(Integer idDokumenta) {
        this.idDokumenta = idDokumenta;
    }

    public Dokument(Integer idDokumenta, String napomena, Date datum, String lokacijaModela, boolean poslato) {
        this.idDokumenta = idDokumenta;
        this.napomena = napomena;
        this.datum = datum;
        this.lokacijaModela = lokacijaModela;
        this.poslato = poslato;
    }

    public Integer getIdDokumenta() {
        return idDokumenta;
    }

    public void setIdDokumenta(Integer idDokumenta) {
        this.idDokumenta = idDokumenta;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getLokacijaModela() {
        return lokacijaModela;
    }

    public void setLokacijaModela(String lokacijaModela) {
        this.lokacijaModela = lokacijaModela;
    }

    public boolean getPoslato() {
        return poslato;
    }

    public void setPoslato(boolean poslato) {
        this.poslato = poslato;
    }

    public TipDokumenta getIdTipaDokumenta() {
        return idTipaDokumenta;
    }

    public void setIdTipaDokumenta(TipDokumenta idTipaDokumenta) {
        this.idTipaDokumenta = idTipaDokumenta;
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
        hash += (idDokumenta != null ? idDokumenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dokument)) {
            return false;
        }
        Dokument other = (Dokument) object;
        if ((this.idDokumenta == null && other.idDokumenta != null) || (this.idDokumenta != null && !this.idDokumenta.equals(other.idDokumenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nst.model.Dokument[ idDokumenta=" + idDokumenta + " ]";
    }
    
}
