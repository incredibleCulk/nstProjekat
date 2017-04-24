/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service.impl;

import com.nst.DAO.DokumentDAO;
import com.nst.model.Dokument;
import com.nst.service.IDokumentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author milisava
 */
@Service
public class DokumentServiceImpl implements IDokumentService{

    @Autowired
    private DokumentDAO dokumentDAO;
    
    @Override
    public List<Dokument> getListDokument() {
        return dokumentDAO.findAll();
    }

    @Override
    public void obrisi(Integer id) {
        dokumentDAO.delete(id);
    }

    @Override
    public Dokument getOneDokument(Integer id) {
        return  dokumentDAO.findOne(id);
    }

    @Override
    public void sacuvaj(Dokument dok) {
        dokumentDAO.save(dok);
    }
    
}
