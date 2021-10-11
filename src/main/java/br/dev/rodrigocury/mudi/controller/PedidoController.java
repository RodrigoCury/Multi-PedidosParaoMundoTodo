package br.dev.rodrigocury.mudi.controller;

import br.dev.rodrigocury.mudi.model.Pedido;
import br.dev.rodrigocury.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @PostMapping("/pedidos")
    public ResponseEntity adicionaPedidos(@RequestBody Pedido pedido){
        pedidoRepository.save(pedido);
        return ResponseEntity.ok("OK");
    }
}
