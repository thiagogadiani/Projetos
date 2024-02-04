/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Dao.FuncionarioDao;
import Model.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NoteC
 */
public class FuncionarioControl {
    
    private Funcionario funcionario;
    private FuncionarioDao bd;
    private ArrayList<Funcionario> listaFuncionario;

    public FuncionarioControl() {
       this.funcionario = new Funcionario();
        this.bd = new FuncionarioDao();
    }
    public Funcionario getFuncionario(){
        return funcionario;
    }
    public ArrayList<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }
    
    public void CadastraFuncionario(String nome, String cpf, String senha, String telefone, String email, String endereco, String usuario){
        this.funcionario = new Funcionario(nome,cpf,senha,telefone,email,endereco,usuario);
        
        try{
        this.bd.Cadastrar(funcionario);
        } catch (SQLException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
