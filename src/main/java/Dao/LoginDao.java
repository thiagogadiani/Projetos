package Dao;

import Model.Login;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
public class LoginDao {
    
    public ResultSet autenticaLogin(Login objlogin) throws SQLException, IOException {
        Connection con = new FabricaDeConexoes().getConexao();
        
        try{
            String sql = "select * from funcionario where usuario = ? and senha = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, objlogin.getUsuario());
            pstm.setString(2, objlogin.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        }catch (SQLException erro){
                JOptionPane.showMessageDialog(null,"LoginDao: " + erro);
                return null;
        }
        
    }
}
