/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service;

import com.nst.model.Aktivnost;
import java.util.List;

/**
 *
 * @author milisava
 */
public interface IAktivnostService {
    List<Aktivnost> getListAktivnost();

     void obrisi(Integer id);

     Aktivnost getOneAktivnost(Integer id);

     void sacuvaj(Aktivnost ak);
}
