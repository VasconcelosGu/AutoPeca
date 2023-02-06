package DAO;

import Model.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ProdutoDAO {
    Connection con = Conexao.conectaBD();
    PreparedStatement stmt = null;
    
    public boolean SalvarProduto(ProdutoModel p) throws SQLException{
        try{
            stmt = con.prepareStatement("INSERT INTO produto (nome, preco, codigo, qtd, custo, qtd_min) VALUES (?, ?, ?, ? ,?, ?)");
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getCodigo());
            stmt.setInt(4, p.getQtd());
            stmt.setDouble(5, p.getCusto());
            stmt.setInt(6, p.getQtd_min());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastro realizado!");
            return true;
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            Conexao.desconecta(con);
            return false;
        }
    }
    
    public ArrayList ListarProdutos() throws SQLException{
        ArrayList<ProdutoModel> Produtos = new ArrayList();
        Connection con = Conexao.conectaBD();
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();
            rs = stmt.getResultSet();
            
            while(rs.next()) {
               ProdutoModel Produto = new ProdutoModel(
                        rs.getInt("id_produto"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getDouble("custo"),
                        rs.getInt("codigo"),
                        rs.getInt("qtd"),
                        rs.getInt("qtd_min"));
                        
                    Produtos.add(Produto);
            }
            
        } catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao entrar: " + ex);
                Conexao.desconecta(con);
        } 
        
        return Produtos;
    }
    
    public ProdutoModel BuscarProduto(int id) throws SQLException{
        Connection con = Conexao.conectaBD();
        ResultSet rs = null;
        ProdutoModel Produto = null;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM produto WHERE id_produto = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs = stmt.getResultSet();
            
            while(rs.next()) {
               Produto = new ProdutoModel(
                        rs.getInt("id_produto"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getDouble("custo"),
                        rs.getInt("codigo"),
                        rs.getInt("qtd"),
                        rs.getInt("qtd_min"));
            }
            
        } catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + ex);
                Conexao.desconecta(con);
        } 
        
        return Produto;
    }
    
    public void ExcluirProduto(int id) throws SQLException
    {
        Connection con = Conexao.conectaBD();
        try{
            stmt = con.prepareStatement("DELETE from produto WHERE id_produto=?");
            stmt.setInt(1, id);
            stmt.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao entrar: " + ex);
            Conexao.desconecta(con);
        }
    }
    
    public void AlterarProduto(ProdutoModel p) throws SQLException
    {
        Connection con = Conexao.conectaBD();
        try{
            stmt = con.prepareStatement("UPDATE produto SET nome=?, preco=?, codigo=?, qtd=?, custo=?, qtd_min=? WHERE id_produto=?");
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getCodigo());
            stmt.setInt(4, p.getQtd());
            stmt.setDouble(5, p.getCusto());
            stmt.setInt(6, p.getQtd_min());
            stmt.setInt(7, p.getId());
            stmt.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao entrar: " + ex);
            Conexao.desconecta(con);
        }
    }
}
