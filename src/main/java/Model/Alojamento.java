/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author android
 */
public class Alojamento {
    
    private int idAlojamento;
    private int idPessoa;
    private String data;
    private int quarto;
    private int cama;
    private String nome;

    public Alojamento() {
        
    }

    public Alojamento(int idPessoa, String data, int quarto, int cama) {
        this.idPessoa = idPessoa;
        this.data = data;
        this.quarto = quarto;
        this.cama = cama;
    }
    
    public Alojamento(int idAlojamento, int idPessoa, int cama, int quarto, String data) {
        this.idAlojamento = idAlojamento;
        this.idPessoa = idPessoa;
        this.cama = cama;
        this.quarto = quarto;
        this.data = data;
    }
    
    public Alojamento(String data, String nome, int quarto, int cama) {
        this.data = data;
        this.nome = nome;
        this.quarto = quarto;
        this.cama = cama;
    }

    public int getIdAlojamento() {
        return idAlojamento;
    }

    public void setIdAlojamento(int idAlojamento) {
        this.idAlojamento = idAlojamento;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public int getCama() {
        return cama;
    }

    public void setCama(int cama) {
        this.cama = cama;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
