package com.produtos.produtos.View.Handler;

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
public class ControllerAdvice extends  ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ar, HttpHeaders header, HttpStatus status,WebRequest request){
            List<String> mensagens = ar.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList());

            BadRequestDTO dto = new BadRequestDTO(mensagens);
            return new ResponseEntity<>(dto,HttpStatus.BAD_REQUEST);
    }
}
