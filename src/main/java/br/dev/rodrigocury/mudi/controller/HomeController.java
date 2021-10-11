package br.dev.rodrigocury.mudi.controller;

import br.dev.rodrigocury.mudi.model.Pedido;
import br.dev.rodrigocury.mudi.model.StatusPedido;
import br.dev.rodrigocury.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("/")
    public String home(Model model, @RequestParam(name = "query", required = false) String query){
        List<Pedido> pedidos = null;

        switch (query != null ? query : ""){
            case "waiting" -> {
                pedidos = (List<Pedido>) pedidoRepository.findByStatus(StatusPedido.AGUARDANDO);
            }
            case "approved" -> {
                pedidos = (List<Pedido>) pedidoRepository.findByStatus(StatusPedido.APROVADO);
            }
            case "delivered" -> {
                pedidos = (List<Pedido>) pedidoRepository.findByStatus(StatusPedido.ENTREGUE);
            }
            default -> {
                pedidos = (List<Pedido>) pedidoRepository.findAll();
            }
        }



        model.addAttribute("pedidos", pedidos);
        return "pedido/home";
    }
}
