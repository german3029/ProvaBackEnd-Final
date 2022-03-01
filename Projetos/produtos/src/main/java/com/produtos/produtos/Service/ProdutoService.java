package com.produtos.produtos.Service;

import java.util.List;

import com.produtos.produtos.Model.Produto;
import com.produtos.produtos.View.Model.AtualizacaoDeEstoque;

public interface ProdutoService {
    public List<Produto>MostrarTodos();
    public Produto PegarPorId(String id);
    public Produto Salvar(Produto m);
    public Produto AtualizarEstoque(String id, int v);
}
