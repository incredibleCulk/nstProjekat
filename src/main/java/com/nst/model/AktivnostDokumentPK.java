/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author milisava
 */
@Embeddable
public class AktivnostDokumentPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_aktivnosti")
    private int idAktivnosti;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipa_dokumenta")
    private int idTipaDokumenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tip_veze")
    private int tipVeze;

    public AktivnostDokumentPK() {
    }

    public AktivnostDokumentPK(int idAktivnosti, int idTipaDokumenta, int tipVeze) {
        this.idAktivnosti = idAktivnosti;
        this.idTipaDokumenta = idTipaDokumenta;
        this.tipVeze = tipVeze;
    }

    public int getIdAktivnosti() {
        return idAktivnosti;
    }

    public void setIdAktivnosti(int idAktivnosti) {
        this.idAktivnosti = idAktivnosti;
    }

    public int getIdTipaDokumenta() {
        return idTipaDokumenta;
    }

    public void setIdTipaDokumenta(int idTipaDokumenta) {
        this.idTipaDokumenta = idTipaDokumenta;
    }

    public int getTipVeze() {
        return tipVeze;
    }

    public void setTipVeze(int tipVeze) {
        this.tipVeze = tipVeze;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAktivnosti;
        hash += (int) idTipaDokumenta;
        hash += (int) tipVeze;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AktivnostDokumentPK)) {
            return false;
        }
        AktivnostDokumentPK other = (AktivnostDokumentPK) object;
        if (this.idAktivnosti != other.idAktivnosti) {
            return false;
        }
        if (this.idTipaDokumenta != other.idTipaDokumenta) {
            return false;
        }
        if (this.tipVeze != other.tipVeze) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nst.model.AktivnostDokumentPK[ idAktivnosti=" + idAktivnosti + ", idTipaDokumenta=" + idTipaDokumenta + ", tipVeze=" + tipVeze + " ]";
    }
    
}
