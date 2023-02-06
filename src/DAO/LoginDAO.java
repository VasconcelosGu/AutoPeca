package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.UsuarioModel;

public class LoginDAO {
    Connection con = Conexao.conectaBD();
    PreparedStatement stmt = null;
    
    public UsuarioModel onLogin(String email, String password) throws SQLException{
        ResultSet rs = null;
        UsuarioModel Usuario = null;
        try{
            stmt = con.prepareStatement("SELECT * FROM  vendedor  WHERE email = ? AND senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            rs = stmt.getResultSet();
            
            if(rs != null && rs.next()){
                Usuario  = new UsuarioModel();
                Usuario.logaUsuario(rs.getInt("id_vendedor"), rs.getString("email"), rs.getString("nome_usuario"), rs.getString("nome"));
            }
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao fazer login: " + ex);
             Conexao.desconecta(con);
        }
        
         return Usuario;
    }
}
