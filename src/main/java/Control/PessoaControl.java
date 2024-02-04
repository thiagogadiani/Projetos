/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.DoacaoDao;
import Dao.PessoaDao;
import Model.Doacao;
import Model.Doador;
import Model.Pessoa;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author android
 */
public class PessoaControl {
    private Pessoa pessoa;
    private PessoaDao bd;
    private ArrayList<Pessoa> listaPessoa;
    
   
    public PessoaControl(){
        this.pessoa = new Pessoa();
        this.bd = new PessoaDao();
    }
    
    public Pessoa getPessoa(){
        return pessoa;
    }
    
    public ArrayList<Pessoa> getListaPessoa(){
        return listaPessoa;
    }
    
    public void CadastraPessoa(String nome, String cidade, String cpf, String observacao, String genero){
        this.pessoa = new Pessoa(nome,cidade,cpf,observacao,genero);
        
        try{
        this.bd.Cadastrar(pessoa);
        } catch (SQLException ex) {
            Logger.getLogger(DoacaoControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoacaoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AlterarPessoa (int idPessoa, String nomePessoa, String cpf,String cidade,String observacao, String genero){
        this.pessoa = new Pessoa (idPessoa, nomePessoa, cpf,cidade,observacao, genero);
        
        try {
            this.bd.Alterar(pessoa);
        } catch (SQLException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ExcluirPessoa (int idPessoa)throws Exception{
        try {
            this.bd.Excluir(idPessoa);
        } catch (SQLException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void BuscaPessoa(){
        
    }
    
    public ResultSet TodasPessoas() throws SQLException, IOException{
        ResultSet rs =  this.bd.RetornaTudo();
        
        return rs;
        
    }
    
    public ResultSet PessoaPorNome(String nome) throws SQLException, IOException{
        ResultSet rs =  this.bd.RetornaPorNome(nome);
        
        return rs;
        
    }
}
