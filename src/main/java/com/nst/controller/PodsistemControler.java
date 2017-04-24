/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.controller;

import com.nst.model.Podsistem;
import com.nst.model.User;
import com.nst.service.IPodsistemService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class PodsistemControler {
    @Autowired
    private IPodsistemService podsistemService;
  
    
    @RequestMapping(value = "/action/svi_podsistemi")
    public ModelAndView findAll(){

        List<Podsistem> listaPodsistema = podsistemService.getListPodsistem();
        return new ModelAndView("/WEB-INF/svi_podsistemi.jsp","listaPodsistema",listaPodsistema);
    }
    
    @RequestMapping(value = "/action/obrisi_podsistem")
    public ModelAndView obrisi(Integer id){
        podsistemService.obrisi(id);
        List<Podsistem> listaPodsistema = podsistemService.getListPodsistem();
        return new ModelAndView("/WEB-INF/svi_podsistemi.jsp","listaPodsistema",listaPodsistema);
    }
    
    @RequestMapping(value = "/action/izmeni_podsistem")
    public ModelAndView izmeni(Integer id){
        Podsistem p=podsistemService.getOnePodsistem(id);       
        List<Podsistem> listaPodsistema = podsistemService.getListPodsistem();
        ModelAndView model=new ModelAndView();
        model.setViewName("/WEB-INF/unos_novog_podsistema.jsp");
        model.addObject("p",p);
        model.addObject("listaPodsistema",listaPodsistema);
        

        return model;
    }
    
    @RequestMapping(value = "/action/sacuvaj_podsistem", method = RequestMethod.POST)
    public ModelAndView sacuvaj(Integer id, Integer idNadSistema, String naziv, String oznaka, String opis,Integer userId) {
      
        Podsistem p = new Podsistem();
        p.setNaziv(naziv);
        p.setOpis(opis);
        p.setOznaka(oznaka);
       idNadSistema=1;
       
       
        if (idNadSistema != null) {
            Podsistem nadsistem = podsistemService.getOnePodsistem(idNadSistema);
            p.setIdNadSistema(nadsistem);
        }
        p.setUserId(p.getIdNadSistema().getUserId());
        if(id != null)
            p.setId(id);
        
        podsistemService.sacuvaj(p);
	return new ModelAndView("/WEB-INF/pocetna.jsp");
        
    }
    
}
