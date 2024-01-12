package com.ico.controller;

import com.ico.model.Vacante;
import com.ico.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Autowired
    private IVacanteService serviceVacantes;

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model) {
        System.out.println("Borrando vacante con id: " + idVacante);
        model.addAttribute("idVacante", idVacante);
        return "mensaje";
    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model) {
        // TODO: Buscar los detalles de la vacante en la BD, o en este caso en la listaVacantes
        Vacante vacanteBuscado = serviceVacantes.buscarPorId(idVacante);
        System.out.println(vacanteBuscado);
        model.addAttribute("vacante", vacanteBuscado);
        return "vacantes/detalle";
    }
}
