package Controller;

import Model.VendasModel;
import DAO.VendasDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendasController {
    VendasDAO VendasConn = new VendasDAO();
    
    public boolean CriarVenda(int id_cliente, int id_vendedor, int id_produto, String forma_pagamento, int qtd){
        boolean persisted = false;
        
        try {
            VendasConn.CriarVenda(id_cliente, id_vendedor, id_produto, forma_pagamento, qtd);
            persisted = true;
            
            return persisted;
        }catch(SQLException e) {
            return  persisted;
        }
    }
    
    public ArrayList<String[]> ListarVendas(){
        ArrayList<String[]> Vendas = new ArrayList();
        
        try {
            ArrayList<VendasModel> Venda = VendasConn.ListarVendas();
            
            if(Venda!=null){
                for(int i=0; i < Venda.size(); i++){
                    String v[] = new String[7];
                    v[0] = Integer.toString(Venda.get(i).getCodigo());
                    v[1] = Venda.get(i).getProduto();
                    v[2] = Venda.get(i).getVendedor();
                    v[3] = Venda.get(i).getCliente();
                    v[4] = Venda.get(i).getForma_pagamento();
                    v[5] = Integer.toString(Venda.get(i).getQtd());
                    v[6] = Double.toString(Venda.get(i).getTotal());
                    Vendas.add(v);
                }
            }
        
            return Vendas;
        } catch(SQLException e) {
            return null;
        }
    }
}