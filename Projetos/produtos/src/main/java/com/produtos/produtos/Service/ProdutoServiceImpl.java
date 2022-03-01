package com.produtos.produtos.Service;

import java.util.List;
import java.util.Optional;

import com.produtos.produtos.Model.Produto;
import com.produtos.produtos.Repository.ProdutoRepository;

import org.springframework.stereotype.Service;
@Service
public class ProdutoServiceImpl implements ProdutoService {
      
   private ProdutoRepository repositorio;
    @Override
    public List<Produto> MostrarTodos() {
        return repositorio.findAll();
    }

    @Override
    public Produto PegarPorId(String id) {
       Optional<Produto> p=repositorio.findById(id);
       if(p.isEmpty()){
           return null;
       } else{
         Produto m=p.get();
         return m;
       }
       
    }

    @Override
    public Produto Salvar(Produto m) {
        return repositorio.save(m);
    }
    
}
