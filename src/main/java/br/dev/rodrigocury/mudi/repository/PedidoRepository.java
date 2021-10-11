package br.dev.rodrigocury.mudi.repository;

import br.dev.rodrigocury.mudi.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
}
