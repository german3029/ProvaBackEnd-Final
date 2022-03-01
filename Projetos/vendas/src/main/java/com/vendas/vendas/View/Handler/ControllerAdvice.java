package com.vendas.vendas.View.Handler;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler{

   @Override 
   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException o, HttpHeaders header, HttpStatus status,WebRequest request){
   List<String> mensagens = o.getBindingResult()
   .getFieldErrors()
   .stream()
   .map(DefaultMessageSourceResolvable::getDefaultMessage)
   .collect(Collectors.toList());

   BadRequestDTO bad = new BadRequestDTO(mensagens);

   return new ResponseEntity<>(bad,HttpStatus.BAD_REQUEST);

   } 
}
