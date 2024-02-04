/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Doador;
import Model.Item;
import Model.Pessoa;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author android
 */
public class PessoaDao {
    
    public void Cadastrar(Pessoa pessoa)throws SQLException, IOException{
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "INSERT into Pessoa(idPessoa,nomePessoa,cidade,cpfPessoa,observacao,genero)"
                + " values (?,?,?,?,?,?);");
       
        comando.setString(1, null);
        comando.setString(2, pessoa.getNomePessoa());
        comando.setString(3, pessoa.getCidade());
        comando.setString(4, pessoa.getCpfPessoa());
        comando.setString(5, pessoa.getObservacao());
        comando.setString(6, pessoa.getGenero());
       
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }

    public Item RecuperaID (int idPessoa) throws SQLException, IOException {
        return null;
    }
    
    public ResultSet RetornaTudo() throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT idPessoa,nomePessoa,cpfPessoa,cidade,observacao,genero FROM pessoa");
        
        ResultSet rs = comando.executeQuery();
        
        //comando.close();
        //con.close();
        
        return rs;
    }
    
      public ResultSet RetornaPorNome(String nome) throws SQLException, IOException {
          String argument =" nomePessoa"+" "+"like '%"+nome+"%'";
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT idPessoa,nomePessoa,cpfPessoa,cidade,observacao,genero FROM pessoa where"+argument);
        
        ResultSet rs = comando.executeQuery();
        
        //comando.close();
        //con.close();
        
        return rs;
    }
      
      public void Alterar(Pessoa pessoa) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "UPDATE Pessoa SET nomePessoa=?,cidade=?, cpfPessoa=?,observacao=?, genero=? WHERE idPessoa="+pessoa.getIdPessoa()+";"
        );
        
        comando.setString(1, pessoa.getNomePessoa());
        comando.setString(2, pessoa.getCidade());
        comando.setString(3, pessoa.getCpfPessoa());
        comando.setString(4, pessoa.getObservacao());
        comando.setString(5, pessoa.getGenero());
       
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }
      
      public void Excluir(int codigo) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "DELETE from Pessoa"
                + " WHERE idPessoa="
                +codigo+ ";");
       
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }
    
    public String RecuperaCPF (String cpf) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT cpfPessoa from Pessoa WHERE cpfPessoa='"+cpf+"';"
        );
        
        ResultSet rs = comando.executeQuery();
        rs.next();
        String pessoa = null;
        pessoa = rs.getString(1);
        
        comando.close();
        con.close();
        
        return pessoa;
    }
}
