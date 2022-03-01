package com.vendas.vendas.View.Controller;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="produtos")
public interface ProdutoFeignClient {
   @PutMapping("{id}")
   public ResponseEntity <Object> BuscarProdutoPorId(@PathVariable String id);
}
