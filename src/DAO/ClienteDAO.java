package DAO;

import Model.ClienteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    Connection con = Conexao.conectaBD();
    PreparedStatement stmt = null;
    
    public boolean SalvarCliente(ClienteModel c) throws SQLException{
        try{
            stmt = con.prepareStatement("INSERT INTO cliente (nome, email, cnpj, cpf, endereco, telefone1, telefone2, telefone3) VALUES (?, ?, ?, ? ,? , ? ,? ,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getCnpj());
            stmt.setString(4, c.getCpf());
            stmt.setString(5, c.getEndereco());
            stmt.setString(6, c.getTelefone1()); 
            stmt.setString(7, c.getTelefone2()); 
            stmt.setString(8, c.getTelefone3()); 
            stmt.executeUpdate();
            
            return true;
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            Conexao.desconecta(con);
            return false;
        } 
    }
    
    public ArrayList ListarClientes() throws SQLException{
        ArrayList<ClienteModel> Clientes = new ArrayList();
        Connection con = Conexao.conectaBD();
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM Cliente");
            rs = stmt.executeQuery();
            rs = stmt.getResultSet();
            
            while(rs.next()){
               ClienteModel Cliente = new ClienteModel(
                        rs.getInt("id_cliente"), 
                        rs.getString("email"),  
                        rs.getString("nome"), 
                        rs.getString("cnpj"), 
                        rs.getString("cpf"), 
                        rs.getString("endereco"), 
                        rs.getString("telefone1"),
                        rs.getString("telefone2"),
                        rs.getString("telefone3"));
                Clientes.add(Cliente);
            }
            
        } catch(SQLException ex){
            Conexao.desconecta(con);
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Clientes;
    }
    
    public void ExcluirCliente(int id) throws SQLException
    {
        Connection con = Conexao.conectaBD();
        try{
            stmt = con.prepareStatement("DELETE from cliente WHERE id_cliente=?");
            stmt.setInt(1, id);
            stmt.execute();
            
        } catch(SQLException ex){
            Conexao.desconecta(con);
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AlterarCliente(ClienteModel c) throws SQLException
    {
        Connection con = Conexao.conectaBD();
        try{
            stmt = con.prepareStatement("UPDATE cliente SET nome=?, email=?, cnpj=?, cpf=?, endereco=?, telefone1=?, telefone2=?, telefone3=? WHERE id_cliente=?");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getCnpj());
            stmt.setString(4, c.getCpf());
            stmt.setString(5, c.getEndereco());
            stmt.setString(6, c.getTelefone1());
            stmt.setString(7, c.getTelefone2());
            stmt.setString(8, c.getTelefone3());
            stmt.setInt(9, c.getId());
            stmt.execute();
            
        } catch(SQLException ex){
            Conexao.desconecta(con);
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
