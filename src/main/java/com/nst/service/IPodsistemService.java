/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service;

import com.nst.model.Podsistem;
import com.nst.model.Proces;
import com.nst.model.User;
import java.util.List;

/**
 *
 * @author milisava
 */
public interface IPodsistemService {
    List<Podsistem> getListPodsistem();
    void obrisi(Integer id);
    void izmeni(Integer id);
    Podsistem getOnePodsistem(Integer id);
    public void sacuvaj(Podsistem p);

   
}
