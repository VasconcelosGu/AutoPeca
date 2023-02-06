package DAO;

import Model.VendasModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendasDAO {
    Connection con = Conexao.conectaBD();
    PreparedStatement stmt = null;
    
    public boolean CriarVenda(int id_cliente, int id_vendedor, int id_produto, String forma_pagamento, int qtd) throws SQLException{
        try{
            stmt = con.prepareStatement("INSERT INTO venda (id_cliente, id_vendedor, forma_pagamento) VALUES ( ?, ?, ? )", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id_cliente);
            stmt.setInt(2, id_vendedor);
            stmt.setString(3, forma_pagamento);
            int generatedId = stmt.executeUpdate();
            ResultSet genKeys = stmt.getGeneratedKeys();
           
            if (genKeys.next()) {
                 int id = genKeys.getInt(1);
                stmt = con.prepareStatement("INSERT INTO vendaxproduto (id_produto, id_venda, quantidade) VALUES ( ?, ?, ? )");
                stmt.setInt(1, id_produto);
                stmt.setInt(2, id);
                stmt.setInt(3, qtd);
                stmt.executeUpdate();
            }
            
            return true;
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao realizar venda: " + ex);
            Conexao.desconecta(con);
            return false;
        } 
    }
    
    public ArrayList ListarVendas() throws SQLException{
        ArrayList<VendasModel> Vendas = new ArrayList();
        Connection con = Conexao.conectaBD();
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement("SELECT \n" +
                    "venda.id_venda, \n" +
                    "venda.forma_pagamento, \n" +
                    "vp.quantidade, \n" + 
                    "prd.nome AS produto, \n" + 
                    "vendedor.nome AS vendedor, \n" + 
                    "cliente.nome AS cliente,\n" + 
                    "vp.quantidade * prd.preco AS total\n" +
                    "FROM venda venda \n" + 
                    "LEFT JOIN cliente cliente ON venda.id_cliente = cliente.id_cliente\n" +
                    "LEFT JOIN vendedor vendedor ON venda.id_vendedor = vendedor.id_vendedor\n" +
                    "LEFT JOIN vendaxproduto vp ON venda.id_venda = vp.id_venda\n" +
                    "LEFT JOIN produto prd ON vp.id_produto = prd.id_produto;"
            );
            
            rs = stmt.executeQuery();
            rs = stmt.getResultSet();
            
            while(rs.next()){
               VendasModel Venda = new VendasModel(
                        rs.getInt("id_venda"), 
                        rs.getInt("quantidade"),  
                        rs.getDouble("total"), 
                        rs.getString("produto"), 
                        rs.getString("cliente"), 
                        rs.getString("vendedor"), 
                        rs.getString("forma_pagamento")
               );
               
                Vendas.add(Venda);
            }
            
        } catch(SQLException ex){
            Conexao.desconecta(con);
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Vendas;
    }
}
