/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Item;
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
public class ItemDao{

    public void Cadastrar(Item item) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "INSERT into Item (idItem, nome) VALUES (?,?);"
        );
       
        comando.setString(1, null);
        comando.setString(2, item.getNomeItem());
       
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }

    public void Alterar(Item item) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "UPDATE Item SET nome=? WHERE idItem="+item.getIdItem()+";"
        );
        
        comando.setString(1, item.getNomeItem());
       
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }

    public void Excluir(int codigo) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "DELETE from Item WHERE idItem=" +codigo+ ";"
        );
       
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }

    public Item RecuperaID (int idItem) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT * from item WHERE idItem="+idItem+";"
        );
       
        ResultSet rs = comando.executeQuery();
        rs.next();
        Item item = new Item(rs.getInt(1),rs.getString(2));
        
        //comando.close();
        //con.close();
        
        return item;
    }
    
    public ArrayList<Item> RetornaTudo() throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        ArrayList<Item> listaItem = new ArrayList<Item>();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT * from item;"
        );
       
        ResultSet rs = comando.executeQuery();
        while (rs.next()) {
            Item item = new Item(rs.getInt(1),rs.getString(2));
            listaItem.add(item);
        }
        
        //comando.close();
        //con.close();
        
        return listaItem;
    }
    
}
