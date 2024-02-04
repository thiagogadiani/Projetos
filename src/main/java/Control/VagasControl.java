/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Vagas;
import Dao.VagasDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author CIANDT\nataliavg
 */
public class VagasControl {
    
     private Vagas vagas ;
     private VagasDao bd ;
     
    public VagasControl(){
         this.vagas = new Vagas();
         this.bd = new VagasDao();
    }
   
    
    public void AlterarVagas (int quantidade){
        this.vagas = new Vagas (quantidade);
        
        try {
            this.bd.Alterar(vagas);
        } catch (SQLException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int RetornaQuantidade (){
        
        int retorno=0;
                
         try {
             return retorno=this.bd.RetornaQtdd();
         } catch (SQLException ex) {
             Logger.getLogger(VagasControl.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(VagasControl.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return retorno;
        
    }
    
}


