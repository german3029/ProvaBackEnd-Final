package com.vendas.vendas.Model;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import com.vendas.vendas.View.Model.CadastroDeVendasDTO;

public class Vendas {
    private String ReceberData; 
    private Date DevolverData;
    private int quantidade;
    private float valorUnitario;
    private float valordavenda;
    private List<String> produtos;
    

    public Vendas(String ReceberData, int quantidade, float valorUnitario, float valordavenda, List<String>produtos) {
        setReceberData(ReceberData);
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valordavenda = valordavenda;
        this.produtos=produtos;
    }
    public Date getDevolverData() {
        return DevolverData;
    }
    public void setDevolverData(Date devolverData) {
        this.DevolverData = devolverData;
    }
    public String getReceberData() {
        return ReceberData;
    }
    public void setReceberData(String receberData) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
       Date date=null;
       try {
         date = formatter.parse(receberData);
         setDevolverData(date);
        } catch (ParseException e) {
        
        e.printStackTrace();
         }
         
    }
    public float getValordavenda() {
        return valordavenda;
    }
    public void setValordavenda(float valordavenda) {
        this.valordavenda = valordavenda;
    }
    public float getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public static Vendas from(CadastroDeVendasDTO v){
        return new Vendas(v.getReceberData(),v.getQuantidade(),v.getValorUnitario(),v.getValordavenda(),v.getProdutos());
    }
    public List<String> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<String> produtos) {
        this.produtos = produtos;
    }
}
