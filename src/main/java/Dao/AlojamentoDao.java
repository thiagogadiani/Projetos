/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Alojamento;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author CIANDT\nataliavg
 */
public class AlojamentoDao {

    public void Cadastrar(Alojamento aloja) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "INSERT into Alojamento(idAlojamento, idPessoa, cama, quarto, data)"
                + " values (?,?,?,?,?);");
       // Lembrar que é na mesma sequência do SQL
        comando.setString(1, null);
        comando.setInt(2, aloja.getIdPessoa());
        comando.setInt(3, aloja.getCama());
        comando.setInt(4, aloja.getQuarto());
        comando.setString(5, aloja.getData());
       
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }

    public void Alterar(Alojamento aloja) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "UPDATE Alojamento SET cama=?, quarto=? WHERE idAlojamento="
                        +aloja.getIdAlojamento()+";"
        );
        
        comando.setInt(1, aloja.getCama());
        comando.setInt(2, aloja.getQuarto());
       
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }

    public void Excluir(int codigo) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "DELETE from Alojamento"
                + " WHERE idAlojamento="
                +codigo+ ";");
       
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }

    public Alojamento RecuperaID (int idAloja) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT * from Alojamento WHERE idAlojamento="+idAloja+";"
        );
       
        ResultSet rs = comando.executeQuery();
        Alojamento aloja = new Alojamento(rs.getInt(1),
                    rs.getString(2),rs.getInt(3),
                    rs.getInt(4));
        
        comando.close();
        con.close();
        
        return aloja;
    }
    
    public ArrayList<Alojamento> RetornaTudoId(int idPessoa) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        ArrayList<Alojamento> listaAloja = new ArrayList<Alojamento>();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT * FROM alojamento WHERE idPessoa = "+idPessoa+";"
        );
       
        ResultSet rs = comando.executeQuery();
        
        while (rs.next()) {
            Alojamento aloja = new Alojamento(rs.getInt("idAlojamento"),
                    rs.getInt("idPessoa"),rs.getInt("cama"),
                    rs.getInt("quarto"), rs.getString("data"));
            listaAloja.add(aloja);
        }
        
        comando.close();
        con.close();
        
        return listaAloja;
    }
    
    public ArrayList<Alojamento> RetornaTudo() throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        ArrayList<Alojamento> listaAloja = new ArrayList<Alojamento>();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT * FROM alojamento;"
        );
       
        ResultSet rs = comando.executeQuery();
        while (rs.next()) {
            Alojamento aloja = new Alojamento(rs.getInt(1),rs.getInt(2),
                    rs.getInt(3),rs.getInt(4),
                    rs.getString(5));
            listaAloja.add(aloja);
        }
        
        comando.close();
        con.close();
        
        return listaAloja;
    }
    
    public int RetornaQtddData (String data) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        int resultadoD;
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT count(data) FROM alojamento WHERE data='"+data+"';"
        );
       
        ResultSet rs = comando.executeQuery();
        rs.next();
        resultadoD = (int)rs.getInt("count(data)");
        
        comando.close();
        con.close();
        
        return resultadoD;
    }
    
    public ArrayList<Alojamento> RetornaTudoData(String data) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        ArrayList<Alojamento> listaAloja = new ArrayList<Alojamento>();
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT alojamento.data as Data, pessoa.nomePessoa as Nome, "+
                    "alojamento.quarto as Quarto, alojamento.cama as Cama "+
                    "FROM alojamento, Pessoa WHERE alojamento.idPessoa = pessoa.idPessoa "+
                    "AND alojamento.data='"+data+"' ORDER BY alojamento.idAlojamento;"
        );
       
        ResultSet rs = comando.executeQuery();
        
        while (rs.next()) {
            Alojamento aloja = new Alojamento(rs.getString("Data"),
                    rs.getString("Nome"),rs.getInt("Quarto"),
                    rs.getInt("Cama"));
            listaAloja.add(aloja);
        }
        
        comando.close();
        con.close();
        
        return listaAloja;
    }
}
