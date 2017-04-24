/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author milisava
 */
@Entity
@Table(name = "aktivnost_dokument")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AktivnostDokument.findAll", query = "SELECT a FROM AktivnostDokument a")
    , @NamedQuery(name = "AktivnostDokument.findByIdAktivnosti", query = "SELECT a FROM AktivnostDokument a WHERE a.aktivnostDokumentPK.idAktivnosti = :idAktivnosti")
    , @NamedQuery(name = "AktivnostDokument.findByIdTipaDokumenta", query = "SELECT a FROM AktivnostDokument a WHERE a.aktivnostDokumentPK.idTipaDokumenta = :idTipaDokumenta")
    , @NamedQuery(name = "AktivnostDokument.findByTipVeze", query = "SELECT a FROM AktivnostDokument a WHERE a.aktivnostDokumentPK.tipVeze = :tipVeze")
    , @NamedQuery(name = "AktivnostDokument.findByTipOperacije", query = "SELECT a FROM AktivnostDokument a WHERE a.tipOperacije = :tipOperacije")})
public class AktivnostDokument implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AktivnostDokumentPK aktivnostDokumentPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "tip_operacije")
    private String tipOperacije;
    @JoinColumn(name = "id_aktivnosti", referencedColumnName = "id_aktivnosti", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aktivnost aktivnost;
    @JoinColumn(name = "id_tipa_dokumenta", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipDokumenta tipDokumenta;

    public AktivnostDokument() {
    }

    public AktivnostDokument(AktivnostDokumentPK aktivnostDokumentPK) {
        this.aktivnostDokumentPK = aktivnostDokumentPK;
    }

    public AktivnostDokument(AktivnostDokumentPK aktivnostDokumentPK, String tipOperacije) {
        this.aktivnostDokumentPK = aktivnostDokumentPK;
        this.tipOperacije = tipOperacije;
    }

    public AktivnostDokument(int idAktivnosti, int idTipaDokumenta, int tipVeze) {
        this.aktivnostDokumentPK = new AktivnostDokumentPK(idAktivnosti, idTipaDokumenta, tipVeze);
    }

    public AktivnostDokumentPK getAktivnostDokumentPK() {
        return aktivnostDokumentPK;
    }

    public void setAktivnostDokumentPK(AktivnostDokumentPK aktivnostDokumentPK) {
        this.aktivnostDokumentPK = aktivnostDokumentPK;
    }

    public String getTipOperacije() {
        return tipOperacije;
    }

    public void setTipOperacije(String tipOperacije) {
        this.tipOperacije = tipOperacije;
    }

    public Aktivnost getAktivnost() {
        return aktivnost;
    }

    public void setAktivnost(Aktivnost aktivnost) {
        this.aktivnost = aktivnost;
    }

    public TipDokumenta getTipDokumenta() {
        return tipDokumenta;
    }

    public void setTipDokumenta(TipDokumenta tipDokumenta) {
        this.tipDokumenta = tipDokumenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aktivnostDokumentPK != null ? aktivnostDokumentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AktivnostDokument)) {
            return false;
        }
        AktivnostDokument other = (AktivnostDokument) object;
        if ((this.aktivnostDokumentPK == null && other.aktivnostDokumentPK != null) || (this.aktivnostDokumentPK != null && !this.aktivnostDokumentPK.equals(other.aktivnostDokumentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nst.model.AktivnostDokument[ aktivnostDokumentPK=" + aktivnostDokumentPK + " ]";
    }
    
}
