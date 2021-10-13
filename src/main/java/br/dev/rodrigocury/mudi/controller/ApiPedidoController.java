package br.dev.rodrigocury.mudi.controller;

import br.dev.rodrigocury.mudi.model.Pedido;
import br.dev.rodrigocury.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ApiPedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @PostMapping("/pedidos")
    public ResponseEntity<String> adicionaPedidos(@RequestBody Pedido pedido){
        pedidoRepository.save(pedido);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> respondePedidos(){
        List<Pedido> pedidos = (List<Pedido>) pedidoRepository.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<String> deletaProduto(@PathVariable("id") Integer id){
        Pedido pedidoADeletar = new Pedido();
        pedidoADeletar.setId(id);
        pedidoRepository.delete(pedidoADeletar);
        return ResponseEntity.ok("OK");
    }

    @PutMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> atualizaProduto(@PathVariable("id") Integer id, @RequestBody Pedido pedido){
        Optional<Pedido> pedidoNoDB = pedidoRepository.findById(id);
        if(pedidoNoDB.isPresent()){
            pedido.setId(id);
            pedidoRepository.save(pedido);
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
