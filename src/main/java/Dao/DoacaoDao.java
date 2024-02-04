/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Doacao;
import java.util.ArrayList;
import Dao.ItemDao;
import Model.Item;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author android
 */
public class DoacaoDao {

       public void Cadastrar(Doacao doacao) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "INSERT into Doacao(idDoacao, descricao,data,quantidade,idDoador,idItem,desItem)"
                + " values (?,?,?,?,?,?,?);");
       
        comando.setString(1, null);
        comando.setString(2, doacao.getDescricao());
        comando.setString(3, doacao.getDataDoacao());
        comando.setInt(4, doacao.getQuantidade());
        comando.setInt(5, doacao.getIdDoador());
        comando.setInt(6, doacao.getIdItem());
        comando.setString(7, doacao.getDesItem());
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }

    
    public void Alterar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public void Excluir(int codigo) throws SQLException, IOException {
        
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "DELETE from Doacao"
                + " WHERE idDoacao="
                +codigo+ ";");
       
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }

    public Doacao RecuperaID (int idDoacao){
        return null;
    }
    
    
    public ArrayList<Object> RetornaTudo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ResultSet RetornaDoacoes(int doador) throws SQLException, IOException {
     
        String argument =" idDoador ="+doador;
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT idDoacao,descricao,data,quantidade,desItem FROM doacao where"+argument);
        
        ResultSet rs = comando.executeQuery();
        
        //comando.close();
        //con.close();
        
        return rs;
    }
    
}
