/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service;

import com.nst.model.Proces;
import java.util.List;

/**
 *
 * @author milisava
 */
public interface IProcesService {

    List<Proces> getListProces();

    void obrisi(Integer id);

    Proces getOneProces(Integer id);

     void sacuvaj(Proces p);
}
