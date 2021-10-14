package br.dev.rodrigocury.mudi.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Oferta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal valor;

  private LocalDate dataEntrega;

  private String comentario;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonBackReference
  private Pedido pedido;

  public Oferta(BigDecimal valor, LocalDate dataEntrega, String comentario, Pedido pedido) {
    this.valor = valor;
    this.dataEntrega = dataEntrega;
    this.comentario = comentario;
    this.pedido = pedido;
  }

  public Oferta() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public LocalDate getDataEntrega() {
    return dataEntrega;
  }

  public void setDataEntrega(LocalDate dataEntrega) {
    this.dataEntrega = dataEntrega;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }
}
