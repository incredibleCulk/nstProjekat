/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.controller;


import com.nst.model.Podsistem;
import com.nst.model.Proces;
import com.nst.service.IPodsistemService;
import com.nst.service.IProcesService;
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
public class ProcesController {
    @Autowired
    private IProcesService procesService;
    
    @Autowired
    private IPodsistemService podsistemService;
  
    
    @RequestMapping(value = "/action/svi_procesi")
    public ModelAndView findAll(){

        List<Proces> listaProcesa = procesService.getListProces();
        return new ModelAndView("/WEB-INF/svi_procesi.jsp","listaProcesa",listaProcesa);
    } 
    
     
    @RequestMapping(value = "/action/obrisi_proces")
    public ModelAndView obrisi(Integer id){
        procesService.obrisi(id);
        List<Proces> listaProcesa = procesService.getListProces();
        return new ModelAndView("/WEB-INF/svi_procesi.jsp","listaProcesa",listaProcesa);
    }
    
    @RequestMapping(value = "/action/izmeni_proces")
    public ModelAndView izmeni(Integer id){
        Proces p=procesService.getOneProces(id);       
        List<Proces> listaProcesa = procesService.getListProces();
        List<Podsistem>listaPodsistema=podsistemService.getListPodsistem();
        List<Podsistem> filtrirana = listaPodsistema.stream().filter(pod -> pod.getId()!=1)
                .collect(Collectors.toList());
        ModelAndView model=new ModelAndView();
        model.setViewName("/WEB-INF/unos_novog_procesa.jsp");
        model.addObject("listaPodsistema",filtrirana);
        model.addObject("proces",p);
        model.addObject("listaProcesa",listaProcesa);
        

        return model;
    }
    
    @RequestMapping(value = "/action/sacuvaj_proces", method = RequestMethod.POST)
    public ModelAndView sacuvaj(Integer id, Integer idPodsistema, Integer idNadprocesa, String naziv, String oznaka,String opis, Integer nivo) {
      
        Proces p = new Proces();
        p.setNaziv(naziv);
        p.setOpis(opis);
        p.setOznaka(oznaka);
        p.setNivo(nivo);
        p.setIdProcesa(id);
       
       
        if (idPodsistema != null) {
            Podsistem nadsistem = podsistemService.getOnePodsistem(idPodsistema);
            p.setIdPodsistema(nadsistem);
        }
        Proces nadProces=null;
        if(idNadprocesa != null){
            nadProces=procesService.getOneProces(idNadprocesa);
        }
        p.setIdNadprocesa(nadProces);
        p.setUserId(nadProces.getUserId());
        procesService.sacuvaj(p);
	return new ModelAndView("/WEB-INF/pocetna.jsp");
        
    }
}
