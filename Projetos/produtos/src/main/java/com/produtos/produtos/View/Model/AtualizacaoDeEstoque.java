package com.produtos.produtos.View.Model;

import com.produtos.produtos.Model.Produto;

public class AtualizacaoDeEstoque {
    
    private int estoque;
public AtualizacaoDeEstoque( int estoque) {
    
    this.estoque=estoque;
}
public int getEstoque() {
    return estoque;
}
public void setEstoque(int estoque) {
    this.estoque = estoque;
}

public static AtualizacaoDeEstoque from(Produto m){
    return new AtualizacaoDeEstoque(m.getEstoque());
}
}
