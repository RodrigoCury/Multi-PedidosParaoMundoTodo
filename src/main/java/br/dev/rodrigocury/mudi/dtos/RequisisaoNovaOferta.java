package br.dev.rodrigocury.mudi.dtos;

import br.dev.rodrigocury.mudi.model.Oferta;
import br.dev.rodrigocury.mudi.model.Pedido;
import org.springframework.format.datetime.standard.DateTimeFormatterFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequisisaoNovaOferta {

  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private Integer pedidoId;

  private String valor;

  private String dataEntrega;

  private String Comentario;

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
    return Comentario;
  }

  public void setComentario(String comentario) {
    Comentario = comentario;
  }

  public Oferta toOferta(Pedido pedido) throws IllegalArgumentException{
    LocalDate dataEntrega = LocalDate.parse(this.dataEntrega, formatter);
    BigDecimal valor = new BigDecimal(this.valor);

    return new Oferta(valor, dataEntrega, this.getComentario(), pedido);
  }
}