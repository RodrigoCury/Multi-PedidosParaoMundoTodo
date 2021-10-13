package br.dev.rodrigocury.mudi.controller;

import br.dev.rodrigocury.mudi.model.Pedido;
import br.dev.rodrigocury.mudi.model.StatusPedido;
import br.dev.rodrigocury.mudi.model.User;
import br.dev.rodrigocury.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping
    public String home(Model model, Principal principal){
        model.addAttribute("pedidos", pedidoRepository.findAllByUser(new User(principal.getName())));
        return "pedido/home";
    }

    @GetMapping("/{status}")
    public String filtrarPorStatus(@PathVariable(value = "status", required = true) String status, Model model, Principal principal){
        List<Pedido> pedidos = pedidoRepository.findAllByUserAndStatus(new User(principal.getName()),StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("status", status.toLowerCase());
        model.addAttribute("pedidos", pedidos);
        return "pedido/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onIllegalArgumentExceptions(){
        return "redirect:/";
    }
}
