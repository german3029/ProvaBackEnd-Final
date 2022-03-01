package com.vendas.vendas.View.Controller;

import java.util.List;

import javax.validation.Valid;

import com.vendas.vendas.Model.Vendas;

import com.vendas.vendas.Service.VendasServiceImpl;
import com.vendas.vendas.View.Model.CadastroDeVendasDTO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class VendasController {
    
    private VendasServiceImpl servico;
    private ProdutoFeignClient feign;
   
    @GetMapping()
    public List<Vendas> MostrarTodos(){
        return servico.MostrarTodos();
    }

    @PostMapping()
    public ResponseEntity<CadastroDeVendasDTO> CadastrarVenda(@RequestBody @Valid CadastroDeVendasDTO m){
       
        Vendas n=Vendas.from(m);
        
        
        List<String>listadeids=n.getProdutos();

        for(String id:listadeids){
            if(feign.BuscarProdutoPorId(id)==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
     

        }
       
        servico.Salvar(n);
        CadastroDeVendasDTO o=CadastroDeVendasDTO.from(n);
       
       
        return new ResponseEntity<>(o,HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public Vendas MostrarPorId(@PathVariable String id){
        return  servico.PegarPorId(id);
    }
    
}
