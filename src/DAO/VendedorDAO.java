package DAO;

import Model.VendedorModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendedorDAO {
    Connection con = Conexao.conectaBD();
    PreparedStatement stmt = null;
    
    public boolean SalvarVendedor(VendedorModel v) throws SQLException{
        try{
            stmt = con.prepareStatement("INSERT INTO vendedor (nome, endereco, telefone, nome_usuario, senha, comissao) VALUES (?, ?, ?, ? ,? , ?)");
            stmt.setString(1, v.getNome());
            stmt.setString(2, v.getEndereco());
            stmt.setString(3, v.getTelefone());
            stmt.setString(4, v.getNome_usuario());
            stmt.setString(5, v.getSenha());
            stmt.setDouble(6, v.getComissao());  
            stmt.executeUpdate();
            
            return true;
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            Conexao.desconecta(con);
            return false;
        }
    }
    
    public ArrayList ListarVendedores() throws SQLException{
        ArrayList<VendedorModel> Vendedores = new ArrayList();
        Connection con = Conexao.conectaBD();
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM Vendedor");
            rs = stmt.executeQuery();
            rs = stmt.getResultSet();
            
            while(rs.next()){
               VendedorModel Vendedor = new VendedorModel(
                        rs.getInt("id_vendedor"),
                        rs.getString("email"),
                        rs.getString("nome"), 
                        rs.getString("nome_usuario"),
                        rs.getDouble("comissao"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("senha"));
                Vendedores.add(Vendedor);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            Conexao.desconecta(con);
        }
        
        return Vendedores;
    }
    
    public void ExcluirVendedor(int id) throws SQLException
    {
        Connection con = Conexao.conectaBD();
        try{
            stmt = con.prepareStatement("DELETE from vendedor WHERE id_vendedor=?");
            stmt.setInt(1, id);
            stmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            Conexao.desconecta(con);
        }
    }
    
    public void AlterarVendedor(VendedorModel v) throws SQLException
    {
        Connection con = Conexao.conectaBD();
        try{
            stmt = con.prepareStatement("UPDATE vendedor SET nome=?, endereco=?, telefone=?, nome_usuario=?, senha=?, comissao=? WHERE id_cliente=?");
            stmt.setString(1, v.getNome());
            stmt.setString(2, v.getEndereco());
            stmt.setString(3, v.getTelefone());
            stmt.setString(4, v.getNome_usuario());
            stmt.setString(5, v.getSenha());
            stmt.setDouble(6, v.getComissao());
            stmt.setInt(7, v.getId());
            stmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            Conexao.desconecta(con);
        }
    }
    
}

