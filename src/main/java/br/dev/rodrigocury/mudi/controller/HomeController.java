package br.dev.rodrigocury.mudi.controller;

import br.dev.rodrigocury.mudi.model.StatusPedido;
import br.dev.rodrigocury.mudi.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeController {

    private PedidoRepository pedidoRepository;

    @Autowired
    public void setPedidoRepository(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/")
    public String home(Model model, Principal principal, @RequestParam(required = false, name = "page") Integer page){
        PageRequest pageRequest = PageRequest.of(page != null? page : 0, 2, Sort.by("dataEntrega"));
        model.addAttribute("pedidos", pedidoRepository.findAllByStatus(StatusPedido.ENTREGUE, pageRequest));
        return "pedido/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onIllegalArgumentExceptions(){
        return "redirect:/";
    }

}
