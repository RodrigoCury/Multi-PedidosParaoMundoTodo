package br.dev.rodrigocury.mudi.dtos;

import br.dev.rodrigocury.mudi.model.Pedido;

public class RequestNovoPedido {
    private String nome;
    private String  urlDoProduto;
    private String urlImagem;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlDoProduto() {
        return urlDoProduto;
    }

    public void setUrlDoProduto(String urlDoProduto) {
        this.urlDoProduto = urlDoProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido toPedido(){
        return new Pedido(nome, urlDoProduto, urlImagem, descricao);
    }
}
