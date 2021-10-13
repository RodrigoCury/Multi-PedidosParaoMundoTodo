package br.dev.rodrigocury.mudi.controller;

import br.dev.rodrigocury.mudi.dtos.RequestNovoPedido;
import br.dev.rodrigocury.mudi.model.Pedido;
import br.dev.rodrigocury.mudi.model.User;
import br.dev.rodrigocury.mudi.repository.PedidoRepository;
import br.dev.rodrigocury.mudi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoRepository pedidoRepository;
    private UserRepository userRepository;

    @Autowired
    public void setInjection(UserRepository userRepository, PedidoRepository pedidoRepository){
        this.userRepository = userRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/formulario")
    public String formularioCadastro(RequestNovoPedido novoPedido){
        return "pedido/formulario-pedido";
    }

    @PostMapping("/formulario")
    public String cadastraProduto(@Valid RequestNovoPedido novoPedido, BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors())
            return "pedido/formulario-pedido";
        User user = userRepository.findByUsername(principal.getName());
        Pedido pedido = novoPedido.toPedido(user);
        pedidoRepository.save(pedido);
        return "pedido/home";
    }
}
