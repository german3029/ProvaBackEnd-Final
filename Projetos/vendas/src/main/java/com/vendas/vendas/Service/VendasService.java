package com.vendas.vendas.Service;

import java.util.List;

import com.vendas.vendas.Model.Vendas;

public interface VendasService {
     public List<Vendas> MostrarTodos();
     public Vendas PegarPorId(String id);
     public Vendas Salvar(Vendas v);
     
}