package com.ico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class HomeController {
    @GetMapping("/")
    public String mostrarHome(Model model) {
        model.addAttribute("mensaje", "Bienvenidos a empleos App");
        model.addAttribute("fecha", new Date());

        String puesto = "Auxiliar de contabilidad";
        Date fechaPub = new Date();
        double salario = 9000;
        boolean vigente = true;

        model.addAttribute("puesto", puesto);
        model.addAttribute("fecha", fechaPub);
        model.addAttribute("salario", salario);
        model.addAttribute("vigente", vigente);
        return "home";
    }
}
