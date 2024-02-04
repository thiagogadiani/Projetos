/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Dao.DoadorDao;
import Model.Doador;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NoteC
 */
public class DoadorControl {
    
    private Doador doador;
    private DoadorDao bd;
    private ArrayList<Doador> listaDoador;

    public DoadorControl() {
        doador = new Doador();
        bd = new DoadorDao();
    }
    
    /*public ArrayList<Doador> getListaItem() {
        TodosDoador();
        return listaDoador;
    }*/
    
    public void CadastrarDoador (String nomeDoador, String telefone, String cpf, String genero){
        this.doador = new Doador (nomeDoador, telefone, cpf, genero);
        
        try {
            this.bd.Cadastrar(doador);
        } catch (SQLException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AlterarDoador (int idDoador, String nomeDoador, String telefone, String cpf, String genero){
        this.doador = new Doador (idDoador, nomeDoador, telefone, cpf, genero);
        
        try {
            this.bd.Alterar(doador);
        } catch (SQLException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ExcluirDoador (int idDoador){
        try {
            this.bd.Excluir(idDoador);
        } catch (SQLException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void BuscaDoador (int idDoador){
        this.doador = new Doador();
        
        try {
            this.doador = this.bd.RecuperaID(idDoador);
        } catch (SQLException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*public void TodosDoador (){
        
        ArrayList<Doador> retorno = new ArrayList<Doador>();
        
        try {
            retorno = this.bd.RetornaTudo();
        } catch (SQLException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.listaDoador = new ArrayList<Doador>();
        
        for (Object o : retorno){
            
            Doador i = ((Doador)o);
            
            this.listaDoador.add(i);
        }        
    }*/
    
    public ResultSet TodosDoadores() {
        ResultSet rs = null;
        try {
            rs = this.bd.RetornaTodosDoadores();
        } catch (SQLException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
    }
    
    public ResultSet DoadorPorNome(String nome) {
        ResultSet rs = null;
        try {
            rs =  this.bd.RetornaPorNome(nome);
        } catch (SQLException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
        
    }
    
    public boolean VerificaCpf (String cpf){
        
        try {
            if (cpf.equalsIgnoreCase(bd.RecuperaCPF(cpf))){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
