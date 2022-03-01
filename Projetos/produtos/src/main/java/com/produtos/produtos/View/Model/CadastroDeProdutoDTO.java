package com.produtos.produtos.View.Model;

import javax.validation.constraints.NotBlank;

import com.produtos.produtos.Model.Produto;

public class CadastroDeProdutoDTO {
    private String id;
    @NotBlank(message="O campo valor não pode estar em branco")
    private int valor;
    @NotBlank(message="O campo nome não pode estar em branco")
    private String nome;
    private int estoque;
   
   
    public CadastroDeProdutoDTO(String id, int valor, String nome, int estoque) {
        this.id = id;
        this.valor = valor;
        this.nome = nome;
        this.estoque = estoque;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    } 

    public static CadastroDeProdutoDTO from(Produto m){
        return new CadastroDeProdutoDTO(m.getId(),m.getValor(),m.getNome(),m.getEstoque());
    }

}
