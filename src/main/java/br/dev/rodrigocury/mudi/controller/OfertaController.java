package br.dev.rodrigocury.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ofertas")
public class OfertaController {

    @GetMapping
    public String getFormularioParaofertas(){
        return "oferta/home";
    }
}
