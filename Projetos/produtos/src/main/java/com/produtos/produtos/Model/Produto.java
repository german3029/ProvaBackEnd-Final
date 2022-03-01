package com.produtos.produtos.Model;



import com.produtos.produtos.View.Model.CadastroDeProdutoDTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("produtos")
public class Produto {
    @Id
    private String id;
    private int valor;
    private String nome;
    private int estoque;
    
    
    public Produto(int valor, String nome, int estoque) {
        
        this.valor = valor;
        this.nome = nome;
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
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
   
    public static Produto from(CadastroDeProdutoDTO m){
        return new Produto(m.getValor(),m.getNome(),m.getEstoque());
        
    }
}
