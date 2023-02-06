package Model;

public class VendedorModel {
    protected String
            nome,
            endereco,
            email,
            telefone,
            nome_usuario,
            senha;
    protected int id_vendedor;
    protected double comissao;
    
    public VendedorModel() {
        
    }
    
    public VendedorModel(int id, String email, String nome, String nome_usuario, Double comissao, String endereco, String telefone, String senha) {
        this.id_vendedor = id;
        this.nome = nome;
        this.email = email;
        this.nome_usuario = nome_usuario;
        this.comissao = comissao;
        this.endereco = endereco;
        this.telefone = telefone;
       this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    