package Model;

public class VendasModel {
    private int codigo, qtd;
    private Double total;
    private String produto, cliente, vendedor, forma_pagamento;

    public VendasModel() {
    }
    
    public VendasModel(int codigo, int qtd, Double total, String produto, String cliente, String vendedor, String forma_pagamento) {
        this.codigo = codigo;
        this.qtd = qtd;
        this.total = total;
        this.produto = produto;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.forma_pagamento = forma_pagamento;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }
}
