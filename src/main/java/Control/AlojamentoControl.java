/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Alojamento;
import Dao.AlojamentoDao;
import Dao.VagasDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CIANDT\nataliavg
 */
public class AlojamentoControl {
    
    private Alojamento alojamento;
    private AlojamentoDao bd;
    private VagasDao bd1;
    private ArrayList<Alojamento> listaAlojamento;
    
    public AlojamentoControl(){
        alojamento = new Alojamento();
        bd = new AlojamentoDao();
        bd1 = new VagasDao();
        listaAlojamento = new ArrayList<Alojamento>();
    }

    
    public void CadastrarAlojamento (int idPessoa, String data, int numeroQuarto, int numeroCama){
        this.alojamento = new Alojamento (idPessoa, data, numeroQuarto, numeroCama);
        
        try {
            this.bd.Cadastrar(alojamento);
        } catch (SQLException ex) {
            Logger.getLogger(AlojamentoControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlojamentoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AlterarAlojamento (int idPessoa, String data, int numeroQuarto, int numeroCama){
        this.alojamento = new Alojamento (idPessoa, data, numeroQuarto, numeroCama);
        
        try {
            this.bd.Alterar(alojamento);
        } catch (SQLException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ExcluirAlojamento (int idAlojamento) {
        try {
            this.bd.Excluir(idAlojamento);
        } catch (SQLException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void BuscaAlojamento (int idAlojamento){
        this.alojamento = new Alojamento();
        
        try {
            this.alojamento = this.bd.RecuperaID(idAlojamento);
        } catch (SQLException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Alojamento> TodosAlojamentoId (int idPessoa){
        
        this.listaAlojamento = new ArrayList<Alojamento>();
        
        try {
            listaAlojamento = this.bd.RetornaTudoId(idPessoa);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaAlojamento;
    }
    
    public ArrayList<Alojamento> TodosAlojamento (){
        
        ArrayList<Alojamento> retorno = new ArrayList<Alojamento>();
        
        try {
            retorno = this.bd.RetornaTudo();
        } catch (SQLException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.listaAlojamento = new ArrayList<Alojamento>();
        
        for (Alojamento o : retorno){
            
            Alojamento i = o;
            
            this.listaAlojamento.add(i);
        }     
        
        return listaAlojamento;
    }
    
    public int RetornaQuantidadeData(String data){
        int retornoD=0;
        
        try {
            retornoD=this.bd.RetornaQtddData(data);
        } catch (SQLException ex) {
            Logger.getLogger(AlojamentoControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlojamentoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retornoD;
    }
    
    public int RetornaQuantidadeVagas (){
        
        int retornoV=0;
                
         try {
             retornoV=this.bd1.RetornaQtdd();
         } catch (SQLException ex) {
             Logger.getLogger(VagasControl.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(VagasControl.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return retornoV;
        
    }
    
    public boolean RetornaPessoaData (int idPes, String data){
        ArrayList<Alojamento>listAloj = new ArrayList<Alojamento>();
        
        try {
            listAloj = bd.RetornaTudo();

            for (Alojamento a : listAloj){

                if(a.getIdPessoa()==idPes && a.getData().equalsIgnoreCase(data)){
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlojamentoControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlojamentoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public ArrayList<Alojamento> TodosAlojamentoData (String data){
        
        listaAlojamento = new ArrayList<Alojamento>();
        
        try {
            listaAlojamento = this.bd.RetornaTudoData(data);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaAlojamento;
    }
}
