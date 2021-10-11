package br.dev.rodrigocury.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("nomeDoProduto", "PS5");
        model.addAttribute("valorDoProduto", "5000,00");
        model.addAttribute("dataEntregaDoProduto", "20/10/2021");
        model.addAttribute("urlDoProduto", "https://www.amazon.com.br/PlayStation-Console-PlayStation%C2%AE5/dp/B088GNRX3J/ref=sr_1_5?dchild=1&keywords=ps5&qid=1633964579&sr=8-5");
        model.addAttribute("descricaoDoProduto", "O brabo do TLOU2 e GOW RAGNAROK");
        model.addAttribute("imgDoProduto", "https://m.media-amazon.com/images/I/51VZErxKwkL._AC_SX679_.jpg");

        return "home";
    }
}
