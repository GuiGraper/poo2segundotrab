package com.leandersonandre.agenda.controllers;

import com.leandersonandre.agenda.core.entity.Professor;
import com.leandersonandre.agenda.core.service.ProfessorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorServico professorServico;

    @GetMapping("/todos")
    @ResponseBody
    public List<Professor> todosProfessores() {
        return professorServico.obterTodos();
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("professor/index.html");
        view.addObject("objeto","olá thymeleaf");
        view.addObject("professores",professorServico.obterTodos());
        return view;
    }

    @GetMapping("/{id}")
    public ModelAndView visualizar(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("professor/visualizar.html");
        var opt = professorServico.obterPeloId(id);
        opt.ifPresent(entidade -> view.addObject("entidade", entidade));
        return view;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("professor/editar.html");
        var opt = professorServico.obterPeloId(id);
        opt.ifPresent(entidade -> view.addObject("entidade", entidade));
        return view;
    }



    @GetMapping("/criar")
    public ModelAndView criarNovoProfessor(){
        ModelAndView view = new ModelAndView("professor/criar.html");
        view.addObject("entidade", new Professor());
        return view;
    }

    @PostMapping("/atualizar")
    public ModelAndView salvar(@ModelAttribute("entidade")Professor professor){
        try {
            professorServico.salvar(professor);
            return new ModelAndView("redirect:/professor/"+professor.getId());
        }catch (Exception e){
            ModelAndView model = new ModelAndView("professor/editar.html");
            model.addObject("erro",e.getMessage());
            model.addObject("entidade", professor);
            return model;
        }
    }


    @PostMapping("/criar")
    public ModelAndView criar(@ModelAttribute("entidade")Professor professor){
        try {
            System.out.println(professor);
            professor.setId(0);
            professorServico.salvar(professor);
            return new ModelAndView("redirect:/professor/"+professor.getId());
        }catch (Exception e){
            ModelAndView model = new ModelAndView("professor/criar.html");
            model.addObject("erro",e.getMessage());
            model.addObject("entidade", professor);
            return model;
        }
    }

}
