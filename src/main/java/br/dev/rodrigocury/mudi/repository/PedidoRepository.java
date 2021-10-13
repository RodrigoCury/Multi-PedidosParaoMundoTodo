package br.dev.rodrigocury.mudi.repository;

import br.dev.rodrigocury.mudi.model.Pedido;
import br.dev.rodrigocury.mudi.model.StatusPedido;
import br.dev.rodrigocury.mudi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
    List<Pedido> findAllByUser(User user);
    List<Pedido> findAllByUserAndStatus(User user, StatusPedido statusPedido);
    List<Pedido> findAllByStatus(StatusPedido valueOf);
}
