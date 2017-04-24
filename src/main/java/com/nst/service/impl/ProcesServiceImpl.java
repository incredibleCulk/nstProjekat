/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service.impl;

import com.nst.DAO.ProcesDAO;
import com.nst.model.Proces;
import com.nst.service.IProcesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author milisava
 */
@Service
public class ProcesServiceImpl implements IProcesService{

    @Autowired
    private ProcesDAO procesDAO;
    
    @Override
    public List<Proces> getListProces() {
        return procesDAO.findAll();
    }

    @Override
    public void obrisi(Integer id) {
        procesDAO.delete(id);
    }

    @Override
    public Proces getOneProces(Integer id) {
        return procesDAO.findOne(id);
    }

    @Override
    public void sacuvaj(Proces p) {
        procesDAO.save(p);
    }
    
}
