package br.dev.rodrigocury.mudi.repository;

import br.dev.rodrigocury.mudi.model.Pedido;
import br.dev.rodrigocury.mudi.model.StatusPedido;
import br.dev.rodrigocury.mudi.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer>, PagingAndSortingRepository<Pedido, Integer> {

    List<Pedido> findAllByUser(User user);

    @Query("select p from Pedido p join p.user u where u.username = :user and p.status = :status")
    List<Pedido> findAllByUserAndStatus(@Param("user")User user, @Param("status") StatusPedido statusPedido);

    @Cacheable("delivered")
    @Query("select p from Pedido p where p.status = :status")
    List<Pedido> findAllByStatus(@Param("status") StatusPedido valueOf, Pageable pageable);

    @Cacheable("delivered")
    @Query("select p from Pedido p where p.status = :status")
    List<Pedido> findAllByStatus(@Param("status") StatusPedido valueOf);
}
