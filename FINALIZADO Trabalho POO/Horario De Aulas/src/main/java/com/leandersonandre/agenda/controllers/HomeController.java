package com.leandersonandre.agenda.controllers;

import com.leandersonandre.agenda.core.service.HorarioAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private HorarioAulaService horarioAulaService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("horarios", horarioAulaService.listarHorariosAula());
        return "home/index";
    }
}
