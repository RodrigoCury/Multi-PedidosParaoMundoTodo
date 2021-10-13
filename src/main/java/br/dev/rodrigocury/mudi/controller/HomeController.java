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

    private PedidoRepository pedidoRepository;

    @Autowired
    public void setPedidoRepository(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/")
    public String home(Model model, Principal principal){
        model.addAttribute("pedidos", pedidoRepository.findAllByStatus(StatusPedido.ENTREGUE));
        return "pedido/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onIllegalArgumentExceptions(){
        return "redirect:/";
    }

}
