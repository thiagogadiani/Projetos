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
public class Doador {
    
    private int idDoador;
    private String nomeDoador;
    private String telefone;
    private String cpf;
    private String genero;
    private ArrayList<Doacao> doacao;
    
    public Doador() {
        doacao = new ArrayList<Doacao>();
    }

    public Doador(String nomeDoador, String telefone, String cpf, String genero) {
        this.nomeDoador = nomeDoador;
        this.telefone = telefone;
        this.cpf = cpf;
        this.genero = genero;
    }
    
    public Doador(int idDoador, String nomeDoador, String telefone, String cpf, String genero) {
        this.idDoador = idDoador;
        this.nomeDoador = nomeDoador;
        this.telefone = telefone;
        this.cpf = cpf;
        this.genero = genero;
    }

    public int getIdDoador() {
        return idDoador;
    }

    public void setIdDoador(int idDoador) {
        this.idDoador = idDoador;
    }

    public String getNomeDoador() {
        return nomeDoador;
    }

    public void setNomeDoador(String nomeDoador) {
        this.nomeDoador = nomeDoador;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<Doacao> getDoacao() {
        return doacao;
    }

    public void setDoacao(ArrayList<Doacao> doacao) {
        this.doacao = doacao;
    }
    
}
