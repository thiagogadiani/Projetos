/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author NoteC
 */
public class FabricaDeConexoes {
    public Connection getConexao() throws IOException, SQLException {

        try {
            /*FileInputStream fis = new FileInputStream("D:\\Projeto Albergue\\prjAlbergue\\src\\main\\java\\propriedade\\conexao.properties");*/
            FileInputStream fis = new FileInputStream("src\\main\\java\\propriedade\\conexao.properties");
            
            Properties p = new Properties();
            p.load(fis);
            String url = (String) p.get("URL");
            String username = (String) p.get("Uname");
            String password = (String) p.get("Password");

            return DriverManager.getConnection(url, username, password);
            
        } catch (IOException ex) {
            System.out.println("Não pode ler o arquivo de propriedades");
            throw ex;
        } catch (SQLException ex) {
            System.out.println("Não pode realizar a conexão");
            throw ex;
        }
    }
}
