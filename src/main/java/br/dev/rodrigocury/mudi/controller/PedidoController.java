package br.dev.rodrigocury.mudi.controller;

import br.dev.rodrigocury.mudi.dtos.RequestNovoPedido;
import br.dev.rodrigocury.mudi.model.Pedido;
import br.dev.rodrigocury.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("/formulario")
    public String formularioCadastro(){
        return "pedido/formulario-pedido";
    }

    @PostMapping("/formulario")
    public String cadastraProduto(RequestNovoPedido novoPedido){
        Pedido pedido = novoPedido.toPedido();
        pedidoRepository.save(pedido);
        return "pedido/home";
    }
}
