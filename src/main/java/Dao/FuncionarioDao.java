/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Funcionario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thiago
 */
public class FuncionarioDao {

    public void Cadastrar(Funcionario funcionario) throws SQLException, IOException {
        try (Connection con = new FabricaDeConexoes().getConexao(); PreparedStatement comando = con.prepareStatement(
                "INSERT into funcionario(idFuncionario, nomeFuncionario,telefone,cpfFuncionario,email,endereco,usuario,senha)"
                        + " values (?,?,?,?,?,?,?,?);")) {
            
            comando.setString(1, null);
            comando.setString(2, funcionario.getNomeFuncionario());
            comando.setString(3, funcionario.getTelefone());
            comando.setString(4, funcionario.getCpfFuncionario());
            comando.setString(5, funcionario.getEmail());
            comando.setString(6, funcionario.getEndereco());
            comando.setString(7, funcionario.getUsuario());
            comando.setString(8, funcionario.getSenha());
            
            comando.executeUpdate();
            
            comando.close();
            con.close();
            
        }
    }
    
    public String RecuperaCPF (String cpf) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT cpfFuncionario from Funcionario WHERE cpfFuncionario='"+cpf+"';"
        );
        
        ResultSet rs = comando.executeQuery();
        rs.next();
        String funcionario = null;
        funcionario = rs.getString(1);
        
        comando.close();
        con.close();
        
        return funcionario;
    }
}
