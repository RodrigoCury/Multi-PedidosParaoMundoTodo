package br.dev.rodrigocury.mudi.dtos;

import br.dev.rodrigocury.mudi.model.Oferta;
import br.dev.rodrigocury.mudi.model.Pedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RequisisaoNovaOferta {

  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  private Integer pedidoId;
  
  @NotNull
  @Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
  private String valor;

  @NotNull
  @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
  private String dataEntrega;

  private String comentario;

  public Integer getPedidoId() {
    return pedidoId;
  }

  public void setPedidoId(Integer pedidoId) {
    this.pedidoId = pedidoId;
  }

  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public String getDataEntrega() {
    return dataEntrega;
  }

  public void setDataEntrega(String dataEntrega) {
    this.dataEntrega = dataEntrega;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public Oferta toOferta(Pedido pedido) throws IllegalArgumentException{
    LocalDate dataEntrega = LocalDate.parse(this.dataEntrega, formatter);
    BigDecimal valor = new BigDecimal(this.valor);

    return new Oferta(valor, dataEntrega, this.getComentario(), pedido);
  }
}
