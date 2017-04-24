/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.controller;

import com.nst.model.Dokument;
import com.nst.model.Podsistem;
import com.nst.model.Proces;
import com.nst.model.TipDokumenta;
import com.nst.service.ITipDokumentaService;
import java.util.List;
import java.util.stream.Collectors;
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
public class TipDokumentaController {

    @Autowired
    private ITipDokumentaService tipDokumentaService;

    @RequestMapping(value = "/action/svi_tipovi_dokumenata")
    public ModelAndView findAll() {

        List<TipDokumenta> listaTipova = tipDokumentaService.getListTipDokumenta();
        return new ModelAndView("/WEB-INF/svi_tipovi_dokumenata.jsp", "listaTipova", listaTipova);
    }

    @RequestMapping(value = "/action/obrisi_tip")
    public ModelAndView obrisi(Integer id) {
        tipDokumentaService.obrisi(id);
        List<TipDokumenta> listaTipova = tipDokumentaService.getListTipDokumenta();
        return new ModelAndView("/WEB-INF/svi_tipovi_dokumenata.jsp", "listaTipova", listaTipova);
    }

    @RequestMapping(value = "/action/izmeni_tip")
    public ModelAndView izmeni(Integer id) {
        TipDokumenta td = tipDokumentaService.getOneTipDokumenta(id);

        ModelAndView model = new ModelAndView();
        model.setViewName("/WEB-INF/unos_novog_tipa_dokumenta.jsp");

        model.addObject("tipDokumenta", td);

        return model;
    }

    @RequestMapping(value = "/action/sacuvaj_tip_dokumenta", method = RequestMethod.POST)
    public ModelAndView sacuvaj(Integer id, String naziv, String opis, String lokacijaModela_text) {

        TipDokumenta td = new TipDokumenta();
        td.setNaziv(naziv);
        td.setOpis(opis);
        td.setId(id);
        td.setLokacijaModela(lokacijaModela_text);

        tipDokumentaService.sacuvaj(td);
        return new ModelAndView("/WEB-INF/pocetna.jsp");

    }

    @RequestMapping(value = "/action/pretraga_tipova", method = RequestMethod.POST)
    public ModelAndView pretrazi(String dokumentName) {// ovo mora sa ajaxom

        List<TipDokumenta> list = tipDokumentaService.getListTipDokumenta();
        List<TipDokumenta> listaTipova = list.stream().filter(t -> t.getNaziv().equalsIgnoreCase(dokumentName))
                .collect(Collectors.toList());
     
        return new ModelAndView("/WEB-INF/svi_tipovi_dokumenata.jsp", "listaTipova", listaTipova);

    }

    @RequestMapping(value = "/action/sacuvaj_novi_tip", method = RequestMethod.GET)
    public ModelAndView save() {
        return new ModelAndView("/WEB-INF/unos_novog_tipa_dokumenta.jsp");
    }

    @RequestMapping(value = "/action/ponisti_filter_tipa", method = RequestMethod.GET)
    public ModelAndView removeFilter() {// ovo mora sa ajaxom
        List<TipDokumenta> listaTipova = tipDokumentaService.getListTipDokumenta();
        return new ModelAndView("/WEB-INF/svi_tipovi_dokumenata.jsp", "listaTipova", listaTipova);
    }

}
