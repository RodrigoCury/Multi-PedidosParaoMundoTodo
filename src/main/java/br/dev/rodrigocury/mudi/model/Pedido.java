package br.dev.rodrigocury.mudi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private BigDecimal valor;
    private LocalDate dataEntrega;
    @Column(length = 1000)
    private String urlDoProduto;
    private String descricao;
    private String urlImagem;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Oferta> ofertaList;

    public Pedido() {
    }

    public Pedido(String nome, BigDecimal valor, LocalDate dataEntrega, String urlDoProduto, String descricao, String urlImagem) {
        this.nome = nome;
        this.valor = valor;
        this.dataEntrega = dataEntrega;
        this.urlDoProduto = urlDoProduto;
        this.descricao = descricao;
        this.urlImagem = urlImagem;
    }

    public Pedido(String nome, String urlDoProduto, String urlImagem, String descricao, StatusPedido status, User user) {
        this.nome = nome;
        this.urlDoProduto = urlDoProduto;
        this.descricao = descricao;
        this.urlImagem = urlImagem;
        this.status = status;
        this.user = user;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getUrlDoProduto() {
        return urlDoProduto;
    }

    public void setUrlDoProduto(String urlDoProduto) {
        this.urlDoProduto = urlDoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Oferta> getOfertaList() {
        return ofertaList;
    }
}
