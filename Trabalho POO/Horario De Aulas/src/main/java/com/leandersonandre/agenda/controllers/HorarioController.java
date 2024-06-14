package com.leandersonandre.agenda.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/horario")
public class HorarioController {

    @GetMapping("/editar")
    public String editarHorario() {
        return "outrapagina";
    }

    @PostMapping("/salvar")
    public String salvarHorario(String materia, String professor, String sala) {
        System.out.println("Matéria: " + materia);
        System.out.println("Professor: " + professor);
        System.out.println("Sala: " + sala);


        return "redirect:/materias/listamateria";
    }
}