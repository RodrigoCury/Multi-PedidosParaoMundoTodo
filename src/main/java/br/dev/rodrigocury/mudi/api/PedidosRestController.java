package br.dev.rodrigocury.mudi.api;

import br.dev.rodrigocury.mudi.model.Pedido;
import br.dev.rodrigocury.mudi.model.StatusPedido;
import br.dev.rodrigocury.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
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
