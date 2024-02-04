/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Doador;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NoteC
 */
public class DoadorDao{

    public void Cadastrar(Doador doador) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "INSERT into Doador(idDoador, nomeDoador, telefone, cpf, genero)"
                + " values (?,?,?,?,?);");
       
        comando.setString(1, null);
        comando.setString(2, doador.getNomeDoador());
        comando.setString(3, doador.getTelefone());
        comando.setString(4, doador.getCpf());
        comando.setString(5, doador.getGenero());
       
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }

    public void Alterar(Doador doador) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "UPDATE Doador SET nomeDoador=?, telefone=?, cpf=?, genero=? WHERE idDoador="+doador.getIdDoador()+";"
        );
        
        comando.setString(1, doador.getNomeDoador());
        comando.setString(2, doador.getTelefone());
        comando.setString(3, doador.getCpf());
        comando.setString(4, doador.getGenero());
       
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }

    public void Excluir(int codigo) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "DELETE from Doador"
                + " WHERE idDoador="
                +codigo+ ";");
       
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }
    
    public Doador RecuperaID (int idDoador) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT * from Doador WHERE idItem="+idDoador+";"
        );
       
        ResultSet rs = comando.executeQuery();
        Doador doador = new Doador(rs.getInt(1),
                rs.getString(2),rs.getString(3),
                rs.getString(4),rs.getString(5));
        
        comando.close();
        con.close();
        
        return doador;
    }
    
    public String RecuperaCPF (String cpf) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT cpf from Doador WHERE cpf='"+cpf+"';"
        );
        
        ResultSet rs = comando.executeQuery();
        rs.next();
        
        String doador = rs.getString(1);
        //System.out.println(doador);
        
        comando.close();
        con.close();
        
        return doador;
    }
    
    public ResultSet RetornaTodosDoadores() throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT idDoador,nomeDoador,telefone,cpf,genero FROM doador");
        
        ResultSet rs = comando.executeQuery();
        
        //comando.close();
        //con.close();
        
        return rs;
    }

   public ResultSet RetornaPorNome(String nome) throws SQLException, IOException {
        String argument =" nomeDoador"+" "+"like '%"+nome+"%'";
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT idDoador,nomeDoador,telefone,cpf,genero FROM doador where"+argument);
        
        ResultSet rs = comando.executeQuery();
        
        //comando.close();
        //con.close();
        
        return rs;
    }
    
}
