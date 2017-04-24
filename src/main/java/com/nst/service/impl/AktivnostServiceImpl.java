/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service.impl;

import com.nst.DAO.AktivnostDAO;
import com.nst.model.Aktivnost;
import com.nst.service.IAktivnostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author milisava
 */
@Service
public class AktivnostServiceImpl implements IAktivnostService{

    @Autowired
    private AktivnostDAO aktivnostDAO;
    
    @Override
    public List<Aktivnost> getListAktivnost() {
        return aktivnostDAO.findAll();
    }

    @Override
    public void obrisi(Integer id) {
        aktivnostDAO.delete(id);
    }

    @Override
    public Aktivnost getOneAktivnost(Integer id) {
        return aktivnostDAO.findOne(id);
    }

    @Override
    public void sacuvaj(Aktivnost ak) {
        aktivnostDAO.save(ak);
    }
    
}
