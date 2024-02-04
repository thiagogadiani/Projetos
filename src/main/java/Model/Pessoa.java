/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author android
 */
public class Pessoa {
    
    private int idPessoa;
    private String nomePessoa;
    private String cpfPessoa;
    private String cidade;
    private String genero;
    private String observacao;

    public Pessoa() {
    }

    

    public Pessoa(String nomePessoa, String cpfPessoa) {
        this.nomePessoa = nomePessoa;
        this.cpfPessoa = cpfPessoa;
    }

    public Pessoa(String nomePessoa,String cidade, String cpfPessoa,String observacao, String genero) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.cpfPessoa = cpfPessoa;
        this.cidade = cidade;
        this.observacao = observacao;
        this.genero = genero;
    }

    public Pessoa(int idPessoa, String nomePessoa, String cpfPessoa, String cidade, String genero, String observacao) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.cpfPessoa = cpfPessoa;
        this.cidade = cidade;
        this.genero = genero;
        this.observacao = observacao;
    }
    
    
    

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    


    
}
