/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Dao.DoacaoDao;
import Model.Doacao;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author android
 */
public class DoacaoControl {
    
    private Doacao doacao;
    private DoacaoDao bd;
    private ArrayList<Doacao> listaDoacao;

    public DoacaoControl() {
        this.doacao = new Doacao();
        this.bd = new DoacaoDao();
    }

    public Doacao getDoacao() {
        return doacao;
    }

    public ArrayList<Doacao> getListaDoacao() {
        return listaDoacao;
    }
    
    public void CadastrarDoacao (String descricao, int quantidade, String dataDoacao, int idDoador, int idItem, String desItem)throws Exception{
        this.doacao = new Doacao(descricao, quantidade, dataDoacao, idDoador, idItem, desItem);
        try{
        this.bd.Cadastrar(doacao);
        } catch (SQLException ex) {
            Logger.getLogger(DoacaoControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoacaoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    public void AlterarDoacao (int idDoacao, String descricao, int quantidade, String dataDoacao, int idDoador, int idItem)throws Exception{
        this.doacao = new Doacao(idDoacao, descricao, quantidade, dataDoacao, idDoador, idItem);
        
        this.bd.Alterar(doacao);
    }*/
    
    public void ExcluirDoacao (int idDoacao)throws Exception{
        this.bd.Excluir(idDoacao);
    }
    
    /*
    public void BuscaDoacao (int idDoador){
        this.doacao = new Doacao();
        this.doacao = this.bd.RecuperaID(idDoador);
    }*/
    
    public void TodasDoacoes (){
        
        ArrayList<Object> retorno = this.bd.RetornaTudo();
        
        this.listaDoacao = new ArrayList<Doacao>();
        
        for (Object o : retorno){
            
            Doacao d = ((Doacao)o);
            
            this.listaDoacao.add(d);
        }        
    }

    public ResultSet BuscaDoacao(int doador) {
       
       
        ResultSet rs = null;
        try {
            rs =  this.bd.RetornaDoacoes(doador);
        } catch (SQLException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoadorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
        
    
    }
    
}
