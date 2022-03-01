package com.produtos.produtos.View.Model;


import javax.validation.constraints.NotBlank;

import com.produtos.produtos.Model.Produto;

public class CadastroDeProdutoDTO {
    
    
    private int valor;
    @NotBlank(message="O campo nome não pode estar em branco")
    private String nome;
    private int estoque;
   
   
    public CadastroDeProdutoDTO( int valor, String nome, int estoque) {
        
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
        return new CadastroDeProdutoDTO(m.getValor(),m.getNome(),m.getEstoque());
    }

}
