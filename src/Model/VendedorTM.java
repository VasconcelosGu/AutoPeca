package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VendedorTM extends AbstractTableModel{

    private List<String[]> linhas;
    private String[] colunas = new String[]{"ID","Nome", "Email", "Endereco", "CNPJ", "CPF", "Telefone 1", "Telefone 3", "Telefone 3"};
    
    public VendedorTM() {
        linhas = new ArrayList<String[]>();
    }
    
    public VendedorTM(List<String[]> lista) {
        linhas = new ArrayList<String[]>(lista);
    }
    
    @Override
    public int getColumnCount() {        
        return colunas.length;
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        /*
        switch(columnIndex){
            case 0:
                return Integer.class;
            default:
                return String.class;
        }
        */
        return String.class;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String c[] = linhas.get(rowIndex);

        return c[columnIndex];
    }
    
    /*@Override
    //modifica na linha e coluna especificada
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String c[] = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        return c[columnIndex];
        /*switch (columnIndex) { // Seta o valor do campo respectivo
            case 0:
                f.setMatricula(aValue.toString());
                break;
            case 1:
                f.setNome(aValue.toString());
                break;
            case 2:
                f.setCPF(aValue.toString());
                break;
            default:
                // Isto não deveria acontecer...             
        }
        fireTableCellUpdated(rowIndex, columnIndex);
     }*/
    
    //modifica na linha especificada
    /*public void setValueAt(ProdutoModel aValue, int rowIndex) {
        ClienteModel f = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado
        
        f.setMatricula(aValue.getMatricula());
        f.setNome(aValue.getNome());
        f.setCPF(aValue.getCPF());
        
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
    }*/
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public String[] getVendedor(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    
    public void addVendedor(String c[]) {
        // Adiciona o registro.
        linhas.add(c);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
     /* Remove a linha especificada. */
    public void remove(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    /* Adiciona uma lista de Cliente ao final dos registros. */
    public void addLista(List<String[]> c) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        linhas.addAll(c);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    /* Remove todos os registros. */
    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }

    /* Verifica se este table model esta vazio. */
    public boolean isEmpty() {
        return linhas.isEmpty();
    }
}
