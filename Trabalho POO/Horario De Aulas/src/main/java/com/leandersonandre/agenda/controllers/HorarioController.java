package com.leandersonandre.agenda.controllers;
import com.leandersonandre.agenda.core.entity.Horario;
import com.leandersonandre.agenda.core.service.HorarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/horario")
public class HorarioController {

    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }


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

    @PostMapping("/horario/salvar")
    public String salvarHorario(@ModelAttribute Horario horario) {
        horarioService.save(horario);
        return "redirect:/";
    }
}
