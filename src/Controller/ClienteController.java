package Controller;

import Model.ClienteModel;
import DAO.ClienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteController {
    ClienteDAO ClienteConn = new ClienteDAO();
    
    public boolean SalvarCliente(String email, String nome, String cnpj, String cpf, String endereco, String telefone1, String telefone2, String telefone3){
        boolean persisted = false;
        ClienteModel Cliente = new ClienteModel();
        
        Cliente.setEmail(email);
        Cliente.setNome(nome);
        Cliente.setCnpj(cnpj);
        Cliente.setCpf(cpf);
        Cliente.setEndereco(endereco);
        Cliente.setTelefone1(telefone1);
        Cliente.setTelefone2(telefone2);
        Cliente.setTelefone3(telefone3);
        
        try {
            ClienteConn.SalvarCliente(Cliente);
            persisted = true;
            
            return persisted;
        }catch(SQLException e) {
            return  persisted;
        }
    }
    
    public ArrayList<String[]> ListarClientes(){
        ArrayList<String[]> Clientes = new ArrayList();
        
        try {
            ArrayList<ClienteModel> Cliente = ClienteConn.ListarClientes();
            if(Cliente!=null){
                for(int i=0; i < Cliente.size(); i++){
                    String c[] = new String[9];
                    c[0] = Integer.toString(Cliente.get(i).getId());
                    c[1] = Cliente.get(i).getNome();
                    c[2] = Cliente.get(i).getEmail();
                    c[3] = Cliente.get(i).getEndereco();
                    c[4] = Cliente.get(i).getCnpj();
                    c[5] = Cliente.get(i).getCpf();
                    c[6] = Cliente.get(i).getTelefone1();
                    c[7] = Cliente.get(i).getTelefone2();
                    c[8] = Cliente.get(i).getTelefone3();
                    Clientes.add(c);
                }
            }
            /*JOptionPane.showMessageDialog(null, Clientes.)*/;
        
            return Clientes;
        } catch(SQLException e) {
            return null;
        }
    }
    
    public boolean AlterarCliente(int id, String email, String nome, String cnpj, String cpf, String endereco, String telefone1, String telefone2, String telefone3){
        boolean persisted = false;
        ClienteModel Cliente = new ClienteModel();
        JOptionPane.showMessageDialog(null, id);
        Cliente.setId(id);
        Cliente.setEmail(email);
        Cliente.setNome(nome);
        Cliente.setCnpj(cnpj);
        Cliente.setCpf(cpf);
        Cliente.setEndereco(endereco);
        Cliente.setTelefone1(telefone1);
        Cliente.setTelefone2(telefone2);
        Cliente.setTelefone3(telefone3);
        
        try {
            ClienteConn.AlterarCliente(Cliente);
            persisted = true;
            
            return persisted;
        }catch(SQLException e) {
            return  persisted;
        }
    }
    
    public boolean ExcluirCliente(int id){
        boolean persisted = false;

        try {
            ClienteConn.ExcluirCliente(id);
            persisted = true;
            
            return persisted;
        }catch(SQLException e) {
            return  persisted;
        }
    }
}