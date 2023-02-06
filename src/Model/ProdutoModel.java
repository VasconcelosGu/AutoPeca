package Model;

public class ProdutoModel {
    private int codigo, qtd, qtd_min, id;
    private String nome;
    private double preco, custo;

    public ProdutoModel() {
        
    }
    
    public ProdutoModel(int id, String nome, double preco, double custo, int codigo, int qtd, int qtd_min) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.custo = custo;
        this.codigo = codigo;
        this.qtd = qtd;
        this.qtd_min = qtd_min;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getQtd_min() {
        return qtd_min;
    }

    public void setQtd_min(int qtd_min) {
        this.qtd_min = qtd_min;
    }
}
