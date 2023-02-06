package Controller;

import Model.VendedorModel;
import DAO.VendedorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendedorController {
    VendedorDAO VendedorConn = new VendedorDAO();

    public boolean SalvarVendedor(String nome, String endereco, String telefone, String nome_usuario, String senha, Float comissao){
        boolean persisted = false;
        VendedorModel Vendedor = new VendedorModel();
        
        Vendedor.setNome(nome);
        Vendedor.setEndereco(endereco);
        Vendedor.setTelefone(telefone);
        Vendedor.setNome_usuario(nome_usuario);
        Vendedor.setSenha(senha);
        Vendedor.setComissao(comissao);
        
        try {
            VendedorConn.SalvarVendedor(Vendedor);
            persisted = true;
            
            return persisted;
        }catch(SQLException e) {
            return  persisted;
        }
    }
    
    public ArrayList<String[]> ListarVendedores(){
        ArrayList<String[]> Vendedores = new ArrayList();
        
        try {
            ArrayList<VendedorModel> Vendedor = VendedorConn.ListarVendedores();
            
            if(Vendedor!=null){
                for(int i=0; i < Vendedor.size(); i++){
                    String v[] = new String[6];
                    v[0] = Integer.toString(Vendedor.get(i).getId_vendedor());
                    v[1] = Vendedor.get(i).getNome();
                    v[2] = Vendedor.get(i).getEndereco();
                    v[3] = Vendedor.get(i).getTelefone();
                    v[4] = Vendedor.get(i).getNome_usuario();
                    v[5] = Double.toString(Vendedor.get(i).getComissao());
                    Vendedores.add(v);
                }
            }
        
            return Vendedores;
        } catch(SQLException e) {
            return null;
        }
    }
    
    public boolean AlterarVendedor(String nome, String endereco, String telefone, String nome_usuario, String senha, Float comissao){
        boolean persisted = false;
        VendedorModel Vendedor = new VendedorModel();
        
        Vendedor.setNome(nome);
        Vendedor.setEndereco(endereco);
        Vendedor.setTelefone(telefone);
        Vendedor.setNome_usuario(nome_usuario);
        Vendedor.setSenha(senha);
        Vendedor.setComissao(comissao);
        
        try {
            VendedorConn.AlterarVendedor(Vendedor);
            persisted = true;
            
            return persisted;
        }catch(SQLException e) {
            return  persisted;
        }
    }
    
    public boolean ExcluirVendedor(int id){
        boolean persisted = false;

        try {
            VendedorConn.ExcluirVendedor(id);
            persisted = true;
            
            return persisted;
        }catch(SQLException e) {
            return  persisted;
        }
    }
}
