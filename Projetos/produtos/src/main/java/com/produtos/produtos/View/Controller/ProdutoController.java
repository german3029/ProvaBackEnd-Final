package com.produtos.produtos.View.Controller;

import java.util.List;

import javax.validation.Valid;


import com.produtos.produtos.Model.Produto;
import com.produtos.produtos.Service.ProdutoServiceImpl;
import com.produtos.produtos.View.Model.AtualizacaoDeEstoque;
import com.produtos.produtos.View.Model.CadastroDeProdutoDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class ProdutoController {
   @Autowired
   private ProdutoServiceImpl servico;

   @GetMapping
   public ResponseEntity<List<Produto>> MostrarTodos(){
       return new ResponseEntity<>(servico.MostrarTodos(),HttpStatus.OK);
   }
   @PostMapping
   public ResponseEntity<CadastroDeProdutoDTO> SalvarProduto(@RequestBody @Valid CadastroDeProdutoDTO p){
         Produto m= Produto.from(p);
         servico.Salvar(m);
         CadastroDeProdutoDTO c=CadastroDeProdutoDTO.from(m);
         return new ResponseEntity<>(c,HttpStatus.CREATED);
   }
   @PutMapping("/{id}/{Quantidadenova}")
   public ResponseEntity<Produto> AtualizarEstoque(@PathVariable String id,@PathVariable int Quantidadenova){
        Produto l =servico.PegarPorId(id);
        l=servico.AtualizarEstoque(id,Quantidadenova);
        servico.Salvar(l);
        return new ResponseEntity<>(l,HttpStatus.ACCEPTED);
       

   }
   @GetMapping("/{id}")
   public ResponseEntity<Produto>BuscarProdutoPorId(@PathVariable String id){
        Produto p=servico.PegarPorId(id);
        return new ResponseEntity<>(p,HttpStatus.OK);
   }
   
}
