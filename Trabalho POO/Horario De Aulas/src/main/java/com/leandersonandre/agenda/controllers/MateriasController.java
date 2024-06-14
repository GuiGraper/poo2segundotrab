package com.leandersonandre.agenda.controllers;

import com.leandersonandre.agenda.core.entity.Materias;
import com.leandersonandre.agenda.core.service.MateriasServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
@RequestMapping("/listamaterias")
public class MateriasController {

    @Autowired
    MateriasServico materiasServico;

    @GetMapping
    public ModelAndView listamaterias(){
        ModelAndView view = new ModelAndView("materias/listamaterias.html");
        view.addObject("objeto","olá teste");
        view.addObject("materias",materiasServico.obterTodos());
        return view;
    }

    @GetMapping("/{id}")
    public ModelAndView visualizar(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("materias/materiasvizualizar.html");
        var opt = materiasServico.obterPeloId(id);
        opt.ifPresent(entidade -> view.addObject("entidade", entidade));
        return view;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("materias/materiaseditar.html");
        var opt = materiasServico.obterPeloId(id);
        opt.ifPresent(entidade -> view.addObject("entidade", entidade));
        return view;
    }



    @GetMapping("/criar")
    public ModelAndView criarNovoMateria(){
        ModelAndView view = new ModelAndView("materias/materiascriar.html");
        view.addObject("entidade", new Materias());
        return view;
    }

    @PostMapping("/atualizar")
    public ModelAndView salvar(@ModelAttribute("entidade")Materias materias){
        try {
            materiasServico.salvar(materias);
            return new ModelAndView("redirect:/materias/"+materias.getId());
        }catch (Exception e){
            ModelAndView model = new ModelAndView("materias/materiaseditar.html");
            model.addObject("erro",e.getMessage());
            model.addObject("entidade", materias);
            return model;
        }
    }


    @PostMapping("/criar")
    public ModelAndView criar(@ModelAttribute("entidade")Materias materias){
        try {
            System.out.println(materias);
            materias.setId(0);
            materiasServico.salvar(materias);
            return new ModelAndView("redirect:/materias/"+materias.getId());
        }catch (Exception e){
            ModelAndView model = new ModelAndView("materias/materiascriar.html");
            model.addObject("erro",e.getMessage());
            model.addObject("entidade", materias);
            return model;
        }
    }

}