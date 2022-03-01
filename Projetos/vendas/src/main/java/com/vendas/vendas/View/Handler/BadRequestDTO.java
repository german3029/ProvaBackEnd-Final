package com.vendas.vendas.View.Handler;

import java.util.List;

public class BadRequestDTO {
     private List<String> falhas;
   
  public BadRequestDTO(List<String> falhas){
       this.falhas = falhas;
  }

public List<String> getErros() {
     return falhas;
}

public void setErros(List<String> falhas) {
     this.falhas = falhas;
}


}
