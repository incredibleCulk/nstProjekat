/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.controller;

import com.nst.model.Aktivnost;
import com.nst.model.Podsistem;
import com.nst.model.Proces;
import com.nst.service.IAktivnostService;
import com.nst.service.IProcesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author milisava
 */
@Controller
public class AktivnostController {

    @Autowired
    private IAktivnostService aktivnostService;
    @Autowired
    private IProcesService procesService;

    @RequestMapping(value = "/action/sve_aktivnosti")
    public ModelAndView findAll() {

        List<Aktivnost> listaAktivnosti = aktivnostService.getListAktivnost();
        return new ModelAndView("/WEB-INF/sve_aktivnosti.jsp", "listaAktivnosti", listaAktivnosti);
    }

    @RequestMapping(value = "/action/obrisi_aktivnost")
    public ModelAndView obrisi(Integer id) {
        aktivnostService.obrisi(id);
        List<Aktivnost> listaAktivnosti = aktivnostService.getListAktivnost();
        return new ModelAndView("/WEB-INF/sve_aktivnosti.jsp", "listaAktivnosti", listaAktivnosti);
    }

    @RequestMapping(value = "/action/izmeni_aktivnost")
    public ModelAndView izmeni(Integer id) {
        Aktivnost ak = aktivnostService.getOneAktivnost(id);
        List<Proces> listaProcesa = procesService.getListProces();
       
        ModelAndView model = new ModelAndView();
        model.setViewName("/WEB-INF/unos_nove_aktivnosti.jsp");
        model.addObject("akt", ak);
        model.addObject("listaProcesa",listaProcesa);

        return model;
    }
    @RequestMapping(value = "/action/sacuvaj_aktivnost", method = RequestMethod.POST)
    public ModelAndView sacuvaj(Integer id, Integer idProcesa, String naziv, String oznaka, String opis) {
      
        Aktivnost ak = new Aktivnost();
        ak.setNaziv(naziv);
        ak.setOpis(opis);
        ak.setOznaka(oznaka);
        ak.setIdAktivnosti(id);
       
       
       
        if (idProcesa != null) {
            Proces proces = procesService.getOneProces(idProcesa);
            ak.setIdProcesa(proces);
            ak.setUserId(proces.getUserId());
        }
      
       
        
        aktivnostService.sacuvaj(ak);
	return new ModelAndView("/WEB-INF/pocetna.jsp");
        
    }

}
