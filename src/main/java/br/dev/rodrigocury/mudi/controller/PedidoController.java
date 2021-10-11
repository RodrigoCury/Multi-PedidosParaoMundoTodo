package br.dev.rodrigocury.mudi.controller;

import br.dev.rodrigocury.mudi.dtos.RequestNovoPedido;
import br.dev.rodrigocury.mudi.model.Pedido;
import br.dev.rodrigocury.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("/formulario")
    public String formularioCadastro(RequestNovoPedido novoPedido){
        return "pedido/formulario-pedido";
    }

    @PostMapping("/formulario")
    public String cadastraProduto(@Valid RequestNovoPedido novoPedido, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "pedido/formulario-pedido";
        Pedido pedido = novoPedido.toPedido();
        pedidoRepository.save(pedido);
        return "pedido/home";
    }
}
