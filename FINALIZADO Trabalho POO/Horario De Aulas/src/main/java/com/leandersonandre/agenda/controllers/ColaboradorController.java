package com.leandersonandre.agenda.controllers;

import com.leandersonandre.agenda.core.entity.Colaborador;
import com.leandersonandre.agenda.core.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping("/form")
    public String mostrarForm(Model model) {
        model.addAttribute("colaborador", new Colaborador());
        return "home/form-colaborador";
    }

    @PostMapping("/salvar")
    public String salvarColaborador(@ModelAttribute Colaborador colaborador) {
        colaboradorService.salvarColaborador(colaborador);
        return "redirect:/colaboradores/listar";
    }

    @GetMapping("/listar")
    public String listarColaboradores(Model model) {
        model.addAttribute("colaboradores", colaboradorService.listarColaboradores());
        return "home/listar-colaboradores";
    }
}
