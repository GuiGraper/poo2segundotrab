package com.leandersonandre.agenda.controllers;

import com.leandersonandre.agenda.core.entity.HorarioAula;
import com.leandersonandre.agenda.core.service.ColaboradorService;
import com.leandersonandre.agenda.core.service.DisciplinaService;
import com.leandersonandre.agenda.core.service.HorarioAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/horarios")
public class HorarioAulaController {

    @Autowired //faz a injeção via “Setter”
    private HorarioAulaService horarioAulaService;  //  serviço de horário das aulas

    @Autowired
    private DisciplinaService disciplinaService; // ele injeta o serviço de dsciplina

   // @Autowired
   // private ColaboradorService colaboradorSer; //

    @Autowired
    private ColaboradorService colaboradorService; // Injeta o serviço de Colaborador

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("horarioAula", new HorarioAula());// adiciona um objeto HorarioAula  -->
        model.addAttribute("disciplinas", disciplinaService.listarDisciplinas());// wadiciona a lista de disciplinas
        model.addAttribute("colaboradores", colaboradorService.listarColaboradores());//  lista de colaboradores no modelo
        return "home/form-horario";// vai retornar a tela    form-horario.html

    }

    @PostMapping("/salvar") //requisições e mapear solicitações
    public String salvarHorarioAula(@ModelAttribute HorarioAula horarioAula) {
        horarioAulaService.salvarHorarioAula(horarioAula); // Salva o horário de aula
        return "redirect:/"; // volta para o index na pagina inuicial //página inicial
    }

    @GetMapping("/listar") //define uma rota que responde a requisições
    public String listarHorarios(Model model) {
        model.addAttribute("horarios", horarioAulaService.listarHorariosAula());
        return "home/listar-horarios";
    }
}
