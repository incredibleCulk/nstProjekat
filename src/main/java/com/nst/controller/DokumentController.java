/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.controller;

import com.nst.model.Aktivnost;
import com.nst.model.Dokument;
import com.nst.model.Podsistem;
import com.nst.model.TipDokumenta;
import com.nst.service.IDokumentService;
import com.nst.service.ITipDokumentaService;
import java.io.File;
import java.util.Date;
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
public class DokumentController {

    @Autowired
    private IDokumentService dokumentService;
    @Autowired
    private ITipDokumentaService tipDokumentaService;

    @RequestMapping(value = "/action/sva_dokumenta")
    public ModelAndView findAll() {

        List<Dokument> listaDokumenata = dokumentService.getListDokument();
        return new ModelAndView("/WEB-INF/sva_dokumenta.jsp", "listaDokumenata", listaDokumenata);
    }

    @RequestMapping(value = "/action/obrisi_dokument")
    public ModelAndView obrisi(Integer id) {
        dokumentService.obrisi(id);
        List<Dokument> listaDokumenata = dokumentService.getListDokument();
        return new ModelAndView("/WEB-INF/sva_dokumenta.jsp", "listaDokumenata", listaDokumenata);
    }

    @RequestMapping(value = "/action/izmeni_dokument")
    public ModelAndView izmeni(Integer id) {
        Dokument dok = dokumentService.getOneDokument(id);
        List<TipDokumenta> listaTipova = tipDokumentaService.getListTipDokumenta();

        ModelAndView model = new ModelAndView();
        model.setViewName("/WEB-INF/unos_novog_dokumenta.jsp");
        model.addObject("listaTipova", listaTipova);
        model.addObject("dok", dok);

        return model;
    }

    @RequestMapping(value = "/action/pretraga_dokumenta", method = RequestMethod.POST)
    public ModelAndView pretrazi(String dokumentName) {

        List<Dokument> list = dokumentService.getListDokument();
        List<Dokument> listaDokumenata = list.stream().filter(d -> d.getIdTipaDokumenta().getNaziv().equals(dokumentName))
                .collect(Collectors.toList());
     
        return new ModelAndView("/WEB-INF/sva_dokumenta.jsp", "listaDokumenata", listaDokumenata);

    }

    @RequestMapping(value = "/action/sacuvaj_novi_dokument", method = RequestMethod.GET)
    public ModelAndView save() {
        return new ModelAndView("/WEB-INF/unos_novog_tipa_dokumenta.jsp");
    }

    @RequestMapping(value = "/action/ponisti_filter_dokument", method = RequestMethod.GET)
    public ModelAndView removeFilter() {
        List<Dokument> listaDokumenata = dokumentService.getListDokument();
        return new ModelAndView("/WEB-INF/sva_dokumenta.jsp", "listaDokumenata", listaDokumenata);
    }

}
