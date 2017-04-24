/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service;

import com.nst.model.TipDokumenta;
import java.util.List;

/**
 *
 * @author milisava
 */
public interface ITipDokumentaService {

    List<TipDokumenta> getListTipDokumenta();

    TipDokumenta getOneTipDokumenta(Integer idTipadokumenta);

    void obrisi(Integer id);

    void sacuvaj(TipDokumenta td);


}
