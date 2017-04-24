/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service.impl;

import com.nst.DAO.PodsistemDAO;
import com.nst.model.Podsistem;
import com.nst.model.User;
import com.nst.service.IPodsistemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author milisava
 */
@Service
public class PodsistemServiceImpl implements IPodsistemService {

    @Autowired
    private PodsistemDAO podsistemDAO;

    @Override
    public List<Podsistem> getListPodsistem() {
        return podsistemDAO.findAll();
    }

    @Override
    public void obrisi(Integer id) {
        podsistemDAO.delete(id);
    }

    @Override
    public void izmeni(Integer id) {
       
    }

    @Override
    public Podsistem getOnePodsistem(Integer id) {
        return podsistemDAO.findOne(id);
    }

    @Override
    public void sacuvaj(Podsistem p) {
        podsistemDAO.save(p);
    }

    

}
