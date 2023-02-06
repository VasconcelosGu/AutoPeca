package DAO;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Conexao {
    public static Connection conectaBD () {
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/projetoleo?user=root&password=admin&useSSL=false";
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar\n" + e.getMessage());
        }
        
        return conn;
    }

 public static void desconecta(Connection con) {
        try {
            if(con != null) {
                con.close();
            }
        } catch(SQLException ex){
            Logger.getLogger(Connection.class.getName()).log(null, null, ex);
        }
    }
}