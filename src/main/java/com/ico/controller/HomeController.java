package com.ico.controller;

import com.ico.model.Vacante;
import com.ico.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private IVacanteService serviceVacantes;

    @GetMapping("/")
    public String mostrarHome(Model model) {
        List<Vacante> vacantes = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", vacantes);
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

    @GetMapping("tabla")
    public String mostrarTabla(Model model) {
        List<Vacante> vacantes = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", vacantes);
        return "tabla";
    }

}
