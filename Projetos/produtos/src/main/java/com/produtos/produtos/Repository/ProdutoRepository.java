package com.produtos.produtos.Repository;

import com.produtos.produtos.Model.Produto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdutoRepository extends MongoRepository<Produto,String>{

 
    
}
