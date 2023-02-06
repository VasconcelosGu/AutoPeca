package Controller;

import Model.ProdutoModel;
import DAO.ProdutoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoController {
    ProdutoDAO ProdutoConn = new ProdutoDAO();
    
    public boolean SalvarProduto(String nome, Double preco, Double custo, int qtd, int qtd_min, int codigo){
        boolean persisted = false;
        ProdutoModel Produto = new ProdutoModel();
        
        Produto.setNome(nome);
        Produto.setPreco(preco);
        Produto.setCusto(custo);
        Produto.setCodigo(codigo);
        Produto.setQtd(qtd);
        Produto.setQtd_min(qtd_min);
        
        try {
            ProdutoConn.SalvarProduto(Produto);
            persisted = true;
            
            return persisted;
        }catch(SQLException e) {
            return  persisted;
        }
    }
    
    public ArrayList<String[]> ListarProdutos(){
        ArrayList<String[]> Produtos = new ArrayList();
        
        try {
            ArrayList<ProdutoModel> Produto = ProdutoConn.ListarProdutos();
            if(Produto!=null){
                for(int i=0; i < Produto.size(); i++){
                    String p[] = new String[6];
                    p[0] = Integer.toString(Produto.get(i).getId());
                    p[1] = Produto.get(i).getNome();
                    p[2] = Double.toString(Produto.get(i).getPreco());
                    p[3] = Double.toString(Produto.get(i).getCusto());
                    p[4] = Integer.toString(Produto.get(i).getQtd());
                    p[5] = Integer.toString(Produto.get(i).getQtd_min());
                    Produtos.add(p);
                }
            }
        
            return Produtos;
        } catch(SQLException e) {
            return null;
        }
    }
    
    public ProdutoModel BuscarProduto(int id){
        try {
            ProdutoModel Produto = ProdutoConn.BuscarProduto(id);
            return Produto;
        } catch(SQLException e) {
            return null;
        }
    }
    
    public boolean AlterarProduto(int id, String nome, Double preco, Double custo, int qtd, int qtd_min, int codigo){
        boolean persisted = false;
        ProdutoModel Produto = new ProdutoModel();
        
        Produto.setId(id);
        Produto.setNome(nome);
        Produto.setPreco(preco);
        Produto.setCusto(custo);
        Produto.setCodigo(codigo);
        Produto.setQtd(qtd);
        Produto.setQtd_min(qtd_min);
        
        try {
            ProdutoConn.AlterarProduto(Produto);
            persisted = true;
            
            return persisted;
        }catch(SQLException e) {
            return  persisted;
        }
    }
    
    public boolean ExcluirProduto(int id){
        boolean persisted = false;

        try {
            ProdutoConn.ExcluirProduto(id);
            persisted = true;
            
            return persisted;
        }catch(SQLException e) {
            return  persisted;
        }
    }
}