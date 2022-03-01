package com.produtos.produtos.Service;

import java.util.List;

import com.produtos.produtos.Model.Produto;

public interface ProdutoService {
    public List<Produto>MostrarTodos();
    public Produto PegarPorId(String id);
    public Produto Salvar(Produto m);
}
