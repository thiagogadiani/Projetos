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
public class Funcionario {
    
    private int idFuncionario;
    private String nomeFuncionario;
    private String cpfFuncionario;
    private String senha;
    private String telefone;
    private String email;
    private String endereco;
    private String usuario;

    public Funcionario() {
        
    }
     public Funcionario(String nomeFuncionario, String cpfFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.cpfFuncionario = cpfFuncionario;
    }
    
    public Funcionario(String nomeFuncionario, String cpfFuncionario, String senha, String telefone, String email, String endereco, String usuario){
        this.nomeFuncionario=nomeFuncionario;
        this.cpfFuncionario=cpfFuncionario;
        this.senha=senha;
        this.telefone=telefone;
        this.email=email;
        this.endereco=endereco;
        this.usuario=usuario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nome) {
        this.nomeFuncionario = nome;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpf) {
        this.cpfFuncionario = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;    
}
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
}
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
}
}



