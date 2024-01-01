package com.ico.controller;

import com.ico.model.Vacante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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

    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        List<String> empleos = new LinkedList<>();
        empleos.add("Ingeniero de sistemas");
        empleos.add("Auxiliar de contabilidad");
        empleos.add("Vendedor");
        empleos.add("Arquitecto");

        model.addAttribute("empleos", empleos);

        return "listado";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {
        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero de comunicaciones");
        vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
        vacante.setFecha(new Date());
        vacante.setSalario(9700.00);
        model.addAttribute("vacante", vacante);
        return "detalle";
    }
}
