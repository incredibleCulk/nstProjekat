/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.controller;

import com.nst.model.User;
import com.nst.service.IUserService;
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
public class HomeController {
     @Autowired
    private IUserService userService;

    @RequestMapping("/")
    public ModelAndView login() {
        return new ModelAndView("login.jsp");
    }

    @RequestMapping(value = "/action/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, String korisnickoIme, String korisnickaSifra) {
        User user = userService.login(korisnickoIme, korisnickaSifra);
        if (user != null) {
            request.getSession().setAttribute("ulogovan_korisnik", user);
            return new ModelAndView("/WEB-INF/pocetna.jsp");
        }
        return new ModelAndView("/login.jsp");
    }

    @RequestMapping(value = "/action/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
        request.getSession().removeAttribute("ulogovan_korisnik");
        return new ModelAndView("/login.jsp");
    }
}
