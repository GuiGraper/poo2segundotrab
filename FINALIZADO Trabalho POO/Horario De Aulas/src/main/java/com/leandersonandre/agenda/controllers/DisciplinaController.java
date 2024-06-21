package com.leandersonandre.agenda.controllers;

import com.leandersonandre.agenda.core.entity.Disciplina;
import com.leandersonandre.agenda.core.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping("/form")
    public String mostrarFormDisciplina(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        return "home/form-disciplina";
    }

    @PostMapping("/salvar")
    public String salvarDisciplina(Disciplina disciplina) {
        disciplinaService.salvarDisciplina(disciplina);
        return "redirect:/disciplinas/listar";
    }

    @GetMapping("/listar")
    public String listarDisciplinas(Model model) {
        model.addAttribute("disciplinas", disciplinaService.listarDisciplinas());
        return "home/listar-disciplinas";
    }
}
