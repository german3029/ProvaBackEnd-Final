package com.vendas.vendas.Service;

import java.util.List;
import java.util.Optional;

import com.vendas.vendas.Model.Vendas;
import com.vendas.vendas.Repository.VendasRepository;

import org.springframework.stereotype.Service;
@Service
public class VendasServiceImpl implements VendasService {
     
    VendasRepository repositorio;
    @Override
    public List<Vendas> MostrarTodos() {
     return repositorio.findAll();   
    }

    @Override
    public Vendas PegarPorId(String id) {
       Optional<Vendas>p=repositorio.findById(id);
       
       if(p.isEmpty()){
           return null;
       }else{
        Vendas v = p.get();
        return v;
       }
    }

    @Override
    public Vendas Salvar(Vendas v) {
       return repositorio.save(v);
    }
   

}
