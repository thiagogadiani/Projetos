/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author android
 */
public class Doacao {
    
    private int idDoacao;
    private String descricao;
    private int quantidade;
    private String dataDoacao;
    private int idDoador;
    private int idItem;
    private Item itens;
    private String desItem;
    public Doacao() {
        
    }

    public Doacao(String descricao, int quantidade, String dataDoacao, int idDoador, int idItem, String desItem) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.dataDoacao = dataDoacao;
        this.idDoador = idDoador;
        this.idItem = idItem;
        this.desItem=desItem;
    }

    public Doacao(int idDoacao, String descricao, int quantidade, String dataDoacao, int idDoador, int idItem, String desItem) {
        this.idDoacao = idDoacao;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.dataDoacao = dataDoacao;
        this.idDoador = idDoador;
        this.desItem=desItem;
    }

    public String getDesItem() {
        return desItem;
    }

    public void setDesItem(String desItem) {
        this.desItem = desItem;
    }
    

    public int getIdDoacao() {
        return idDoacao;
    }

    public void setIdDoacao(int idDoacao) {
        this.idDoacao = idDoacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(String dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public int getIdDoador() {
        return idDoador;
    }

    public void setIdDoador(int idDoador) {
        this.idDoador = idDoador;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public Item getItens() {
        return itens;
    }

    public void setItens(Item itens) {
        this.itens = itens;
    }
    
}
