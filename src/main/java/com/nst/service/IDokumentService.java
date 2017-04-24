/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service;

import com.nst.model.Aktivnost;
import com.nst.model.Dokument;
import java.util.List;

/**
 *
 * @author milisava
 */
public interface IDokumentService {
   List<Dokument> getListDokument();

     void obrisi(Integer id);

     Dokument getOneDokument(Integer id);

     void sacuvaj(Dokument dok);
}
