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

@RequestMapping("API/produto")
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
   @PutMapping("/{id}")
   public Produto AtualizarEstoque(@PathVariable String id,@RequestBody AtualizacaoDeEstoque Atualizacao){
        Produto l =servico.PegarPorId(id);
        l.setEstoque(Atualizacao.getEstoque());
       return l;

   }

}
