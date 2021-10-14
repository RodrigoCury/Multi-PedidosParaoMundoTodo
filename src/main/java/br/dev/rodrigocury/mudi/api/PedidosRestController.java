package br.dev.rodrigocury.mudi.api;

import br.dev.rodrigocury.mudi.model.Pedido;
import br.dev.rodrigocury.mudi.model.StatusPedido;
import br.dev.rodrigocury.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/api/pedidos")
public class PedidosRestController {

    PedidoRepository pedidoRepository;

    @Autowired
    public PedidosRestController(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/aguardando")
    public ResponseEntity<List<Pedido>> encontrarPedidos(){
        return ResponseEntity.ok(pedidoRepository.findAllByStatus(StatusPedido.AGUARDANDO));
    }



}
