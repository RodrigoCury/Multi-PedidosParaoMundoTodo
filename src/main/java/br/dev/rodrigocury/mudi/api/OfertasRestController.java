package br.dev.rodrigocury.mudi.api;

import br.dev.rodrigocury.mudi.dtos.RequisisaoNovaOferta;
import br.dev.rodrigocury.mudi.model.Oferta;
import br.dev.rodrigocury.mudi.model.Pedido;
import br.dev.rodrigocury.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRestController {

  private final PedidoRepository pedidoRepository;

  @Autowired
  public OfertasRestController(PedidoRepository pedidoRepository){
    this.pedidoRepository = pedidoRepository;
  }

  @PostMapping
  public Oferta criaOferta(
    @Valid @RequestBody 
    RequisisaoNovaOferta requisisaoNovaOferta
    ){

    Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisisaoNovaOferta.getPedidoId());

    if(pedidoBuscado.isEmpty()){
      return null;
    }
    Pedido pedido = pedidoBuscado.get();
    Oferta oferta = requisisaoNovaOferta.toOferta(pedido);

    List<Oferta> ofertasDoPedido = pedido.getOfertaList();
    ofertasDoPedido.add(oferta);

    pedidoRepository.save(pedido);

    return oferta;
  }
}
