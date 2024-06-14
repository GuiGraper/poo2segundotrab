package com.leandersonandre.agenda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String index(){
        return "home/index.html";
    }

    @GetMapping("/outrapagina")
    public String outraPagina(){
        return "home/outrapagina.html";
    }
    @GetMapping("/outrapagina2")
    public String outraPagina2(){
        return "home/outrapagina2.html";
    }
    @GetMapping("/index1")
    public String index2(){
        return "/professor/index.html";
    }
    @GetMapping("index")
    public String index3(){
        return "index.html";
    }

    @GetMapping("materiascriar")
    public String materiascriar(){
        return "materiascriar.html";
    }

}
