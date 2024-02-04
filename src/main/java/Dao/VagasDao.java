/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Model.Vagas;
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
public class VagasDao{


    public void Alterar(Vagas vagas) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        PreparedStatement comando = con.prepareStatement(
                "UPDATE Vagas SET quantidadeDeCamas=? ;"
        );
        
        comando.setInt(1, vagas.getQuantidadeVagas());
       
        comando.executeUpdate();
       
        comando.close();
        con.close();
    }
    
    public int RetornaQtdd () throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        int resultadoV;
        
        PreparedStatement comando = con.prepareStatement(
                "SELECT quantidadeDeCamas FROM vagas;"
        );
       
        ResultSet rs = comando.executeQuery();
        rs.next();
        resultadoV = rs.getInt("quantidadeDeCamas");
        
        comando.close();
        con.close();
        
        return resultadoV;
    }

}
