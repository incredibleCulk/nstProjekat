/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service.impl;

import com.nst.DAO.TipDokumentaDAO;
import com.nst.model.TipDokumenta;
import java.util.List;
import com.nst.service.ITipDokumentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author milisava
 */
@Service
public class TipDokumentaServiceImpl implements ITipDokumentaService {

    @Autowired
    private TipDokumentaDAO tipDokumentaDAO;

    @Override
    public List<TipDokumenta> getListTipDokumenta() {
        return tipDokumentaDAO.findAll();
    }

    @Override
    public TipDokumenta getOneTipDokumenta(Integer idTipadokumenta) {
        return tipDokumentaDAO.getOne(idTipadokumenta);
    }

    @Override
    public void obrisi(Integer id) {
         tipDokumentaDAO.delete(id);
    }

    @Override
    public void sacuvaj(TipDokumenta td) {
        tipDokumentaDAO.save(td);
    }

   

}
