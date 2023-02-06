package View;

import Controller.ClienteController;
import Controller.ProdutoController;
import Controller.VendasController;
import Controller.VendedorController;
import Model.ProdutoTM;
import Model.ProdutoModel;
import Model.ClienteTM;
import Model.VendedorTM;
import Model.VendaTM;
import Model.UsuarioModel;
import javax.swing.JOptionPane;

public class PrincipalView extends javax.swing.JFrame {
    UsuarioModel Usuario = new UsuarioModel();
    ClienteTM ClienteModelo;
    ProdutoTM ProdutoModelo;
    VendedorTM VendedorModelo;
    VendaTM VendaModelo;
    ProdutoModel Produto;
    ClienteController ClienteC = new ClienteController();
    ProdutoController ProdutoC = new ProdutoController();
    VendedorController VendedorC = new VendedorController();
    VendasController VendaC = new VendasController();
    String clienteModo, produtoModo, vendedorModo;
    
    public PrincipalView() {
        initComponents();
        setLocationRelativeTo(null);
        setBotoesCliente(false, false, false, true);
        setBotoesProduto(false, false, false, true);
        CarregarTabelaCliente();
        CarregarTabelaProduto();
        CarregarTabelaVendedor();
        CarregarTabelaVendas();
        BloqueiaCamposCliente();
        BloqueiaCamposProduto();
        BloqueiaCamposVendedor();
        clienteModo = "Navegar";
        produtoModo = "Navegar";
        vendedorModo = "Navegar";
    }
    
    public void onLogin(UsuarioModel usuario) {
        usuario.logaUsuario(usuario.getId_vendedor(), usuario.getEmail(), usuario.getNome_usuario(), usuario.getNome());
        label_welcome.setText("Bem vindo, " + usuario.getNome() + "!");
        int id = usuario.getId_vendedor();
        txtVendas_codVendedor.setText(Integer.toString(id));
    }
    
    public void CarregarTabelaCliente(){
        ClienteModelo = new ClienteTM(ClienteC.ListarClientes());
        tb_clientes.setModel(ClienteModelo);
    }
    
    public void CarregarTabelaProduto(){
        ProdutoModelo = new ProdutoTM(ProdutoC.ListarProdutos());
        tb_produtos.setModel(ProdutoModelo);
    }
    
    public void CarregarTabelaVendedor(){
        VendedorModelo = new VendedorTM(VendedorC.ListarVendedores());
        tb_vendedor.setModel(VendedorModelo);
    }
    
    public void CarregarTabelaVendas(){
        VendaModelo = new VendaTM(VendaC.ListarVendas());
        tb_vendas.setModel(VendaModelo);
    }
    
    public void setBotoesCliente(boolean salvarCliente, boolean editarCliente, boolean excluirCliente, boolean novoCliente) {
        btnC_adicionar.setEnabled(salvarCliente);
        btnC_editar.setEnabled(editarCliente);
        btnC_excluir.setEnabled(excluirCliente);
        btnC_novo.setEnabled(novoCliente);
    }
    
    public void setBotoesProduto(boolean salvarProduto, boolean editarProduto, boolean excluirProduto, boolean novoProduto) {
        btnP_adicionar.setEnabled(salvarProduto);
        btnP_editar.setEnabled(editarProduto);
        btnP_excluir.setEnabled(excluirProduto);
        btnP_novo.setEnabled(novoProduto);
    }
    
    public void setBotoesVendedor(boolean salvarVendedor, boolean editarVendedor, boolean excluirVendedor, boolean novoVendedor) {
        btnV_adicionar.setEnabled(salvarVendedor);
        btnV_editar.setEnabled(editarVendedor);
        btnV_excluir.setEnabled(excluirVendedor);
        btnV_novo.setEnabled(novoVendedor);
    }
    
    public void LimpaCamposCliente() {
        txtC_nome.setText("");
        txtC_email.setText("");
        txtC_endereco.setText("");
        txtC_cnpj.setText("");
        txtC_cpf.setText("");
        txtC_telefone1.setText("");
        txtC_telefone2.setText("");
        txtC_telefone3.setText("");
    }
    
    public void LimpaCamposProduto() {
        txtP_nome.setText("");
        txtP_codigo.setText("");
        txtP_custo.setText("");
        txtP_preco.setText("");
        txtP_qtd.setText("");
        txtP_qtdMinima.setText("");
    }
    
    public void LimpaCamposVendedor() {
        txtV_nome.setText("");
        txtV_codigo.setText("");
        txtV_endereco.setText("");
        txtV_nomeUsuario.setText("");
        txtV_senha.setText("");
        txtV_comissao.setText("");
        txtV_comissao.setText("");
    }
    
    public void BloqueiaCamposCliente() {
        txtC_nome.setEnabled(false);
        txtC_email.setEnabled(false);
        txtC_endereco.setEnabled(false);
        txtC_cnpj.setEnabled(false);
        txtC_cpf.setEnabled(false);
        txtC_telefone1.setEnabled(false);
        txtC_telefone2.setEnabled(false);
        txtC_telefone3.setEnabled(false);
    }
    
    public void BloqueiaCamposProduto() {
        txtP_nome.setEnabled(false);
        txtP_codigo.setEnabled(false);
        txtP_custo.setEnabled(false);
        txtP_preco.setEnabled(false);
        txtP_qtd.setEnabled(false);
        txtP_qtdMinima.setEnabled(false);
    }
    
    public void BloqueiaCamposVendedor() {
        txtV_nome.setEnabled(false);
        txtV_codigo.setEnabled(false);
        txtV_endereco.setEnabled(false);
        txtV_nomeUsuario.setEnabled(false);
        txtV_senha.setEnabled(false);
        txtV_comissao.setEnabled(false);
        txtV_telefone.setEnabled(false);
    }
    
    public void LiberaCamposCliente() {
        txtC_nome.setEnabled(true);
        txtC_email.setEnabled(true);
        txtC_endereco.setEnabled(true);
        txtC_cnpj.setEnabled(true);
        txtC_cpf.setEnabled(true);
        txtC_telefone1.setEnabled(true);
        txtC_telefone2.setEnabled(true);
        txtC_telefone3.setEnabled(true);
    }
    
    public void LiberaCamposProduto() {
        txtP_nome.setEnabled(true);
        txtP_codigo.setEnabled(true);
        txtP_custo.setEnabled(true);
        txtP_preco.setEnabled(true);
        txtP_qtd.setEnabled(true);
        txtP_qtdMinima.setEnabled(true);
    }
    
    public void LiberaCamposVendedor() {
        txtV_nome.setEnabled(true);
        txtV_codigo.setEnabled(true);
        txtV_endereco.setEnabled(true);
        txtV_nomeUsuario.setEnabled(true);
        txtV_senha.setEnabled(true);
        txtV_comissao.setEnabled(true);
        txtV_telefone.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        principal_pane = new javax.swing.JTabbedPane();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        txtVendas_codProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtVendas_codCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtVendas_codVendedor = new javax.swing.JTextField();
        txtVendas_produto = new javax.swing.JTextField();
        btnVendas_efetuarVenda = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtVendas_qtd = new javax.swing.JTextField();
        btnVendas_buscar = new javax.swing.JButton();
        txtVendas_total = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        btnVendas_calcular = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        txtC_telefone1 = new javax.swing.JTextField();
        labelC_endereco = new javax.swing.JLabel();
        txtC_email = new javax.swing.JTextField();
        btnC_adicionar = new javax.swing.JButton();
        txtC_telefone2 = new javax.swing.JTextField();
        labelC_telefone1 = new javax.swing.JLabel();
        txtC_cpf = new javax.swing.JTextField();
        labelC_nome = new javax.swing.JLabel();
        txtC_telefone3 = new javax.swing.JTextField();
        labelC_telefone2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_clientes = new javax.swing.JTable();
        labelC_email = new javax.swing.JLabel();
        labelC_telefone3 = new javax.swing.JLabel();
        btnC_excluir = new javax.swing.JButton();
        labelC_cpf = new javax.swing.JLabel();
        labelC_cnpj = new javax.swing.JLabel();
        txtC_endereco = new javax.swing.JTextField();
        txtC_cnpj = new javax.swing.JTextField();
        txtC_nome = new javax.swing.JTextField();
        btnC_editar = new javax.swing.JButton();
        btnC_novo = new javax.swing.JButton();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        labelP_preco = new javax.swing.JLabel();
        txtP_qtd = new javax.swing.JTextField();
        txtP_codigo = new javax.swing.JTextField();
        txtP_qtdMinima = new javax.swing.JTextField();
        txtP_nome = new javax.swing.JTextField();
        txtP_preco = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_produtos = new javax.swing.JTable();
        btnP_excluir = new javax.swing.JButton();
        labelP_custo = new javax.swing.JLabel();
        txtP_custo = new javax.swing.JTextField();
        btnP_editar = new javax.swing.JButton();
        labelP_qtd = new javax.swing.JLabel();
        btnP_adicionar = new javax.swing.JButton();
        labelP_qtdMinima = new javax.swing.JLabel();
        labelP_codigo = new javax.swing.JLabel();
        labelP_nome = new javax.swing.JLabel();
        btnP_novo = new javax.swing.JButton();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_vendedor = new javax.swing.JTable();
        btnV_novo = new javax.swing.JButton();
        btnV_excluir = new javax.swing.JButton();
        labelP_custo1 = new javax.swing.JLabel();
        labelP_preco1 = new javax.swing.JLabel();
        btnV_editar = new javax.swing.JButton();
        txtV_endereco = new javax.swing.JTextField();
        labelP_qtd1 = new javax.swing.JLabel();
        txtV_codigo = new javax.swing.JTextField();
        btnV_adicionar = new javax.swing.JButton();
        txtV_telefone = new javax.swing.JTextField();
        labelP_qtdMinima1 = new javax.swing.JLabel();
        txtV_nome = new javax.swing.JTextField();
        labelP_codigo1 = new javax.swing.JLabel();
        txtV_nomeUsuario = new javax.swing.JTextField();
        labelP_nome1 = new javax.swing.JLabel();
        txtV_comissao = new javax.swing.JTextField();
        labelP_qtdMinima2 = new javax.swing.JLabel();
        txtV_senha = new javax.swing.JPasswordField();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_vendas = new javax.swing.JTable();
        label_welcome = new javax.swing.JLabel();

        jTabbedPane3.addTab("tab1", jTabbedPane4);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPasswordField1.setText("jPasswordField1");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jToggleButton1.setText("jToggleButton1");

        jMenu1.setText("jMenu1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame4.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Realizar uma venda");

        jLabel3.setText("Código do produto");

        jLabel4.setText("Código do cliente");

        jLabel5.setText("Código do vendedor");

        txtVendas_codVendedor.setEnabled(false);
        txtVendas_codVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVendas_codVendedorActionPerformed(evt);
            }
        });

        txtVendas_produto.setEditable(false);

        btnVendas_efetuarVenda.setText("Efetuar venda");
        btnVendas_efetuarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendas_efetuarVendaActionPerformed(evt);
            }
        });

        jLabel2.setText("Produto");

        jLabel6.setText("Quantidade");

        txtVendas_qtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtVendas_qtdKeyPressed(evt);
            }
        });

        btnVendas_buscar.setText("Buscar");
        btnVendas_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendas_buscarActionPerformed(evt);
            }
        });

        txtVendas_total.setEditable(false);

        jLabel7.setText("Total");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "PIX", "Cartão de Crédito", "Cartão de Débito", "Dinheiro" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jLabel8.setText("Forma de pagamento");

        btnVendas_calcular.setText("Calcular");
        btnVendas_calcular.setEnabled(false);
        btnVendas_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendas_calcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame4Layout.createSequentialGroup()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVendas_efetuarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtVendas_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtVendas_codProduto))
                                .addGap(18, 18, 18)
                                .addComponent(btnVendas_buscar))
                            .addComponent(jLabel2)
                            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtVendas_qtd)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVendas_total)
                                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)
                        .addComponent(btnVendas_calcular)
                        .addGap(88, 88, 88)
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVendas_codCliente)
                            .addComponent(txtVendas_codVendedor)
                            .addComponent(jScrollPane1)
                            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8))
                                .addGap(0, 60, Short.MAX_VALUE)))))
                .addGap(34, 34, 34))
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVendas_codProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVendas_buscar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVendas_codCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVendas_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVendas_codVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVendas_qtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVendas_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVendas_calcular)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVendas_efetuarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        principal_pane.addTab("Realizar venda", jInternalFrame4);

        jInternalFrame1.setVisible(true);

        labelC_endereco.setText("Endereço:");

        txtC_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtC_emailActionPerformed(evt);
            }
        });

        btnC_adicionar.setText("Salvar");
        btnC_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC_adicionarActionPerformed(evt);
            }
        });

        labelC_telefone1.setText("Telefone 1:");

        labelC_nome.setText("Nome:");

        labelC_telefone2.setText("Telefone 2:");

        tb_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Email", "Endereco", "CNPJ", "CPF", "Telefone 1", "Telefone 3", "Telefone 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_clientesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_clientes);

        labelC_email.setText("Email:");

        labelC_telefone3.setText("Telefone 3:");

        btnC_excluir.setText("Excluir");
        btnC_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC_excluirActionPerformed(evt);
            }
        });

        labelC_cpf.setText("CPF:");

        labelC_cnpj.setText("CNPJ:");

        txtC_cnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtC_cnpjActionPerformed(evt);
            }
        });

        btnC_editar.setText("Editar");
        btnC_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC_editarActionPerformed(evt);
            }
        });

        btnC_novo.setText("Novo");
        btnC_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC_novoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelC_cnpj)
                    .addComponent(labelC_cpf)
                    .addComponent(labelC_email)
                    .addComponent(labelC_nome))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtC_email)
                    .addComponent(txtC_cpf)
                    .addComponent(txtC_cnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtC_nome))
                .addGap(47, 47, 47)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelC_endereco)
                    .addComponent(labelC_telefone1)
                    .addComponent(labelC_telefone2)
                    .addComponent(labelC_telefone3))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtC_endereco)
                    .addComponent(txtC_telefone1)
                    .addComponent(txtC_telefone2)
                    .addComponent(txtC_telefone3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnC_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnC_adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnC_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnC_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelC_nome)
                    .addComponent(txtC_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelC_endereco)
                    .addComponent(txtC_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelC_email)
                    .addComponent(txtC_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelC_telefone1)
                    .addComponent(txtC_telefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelC_cpf)
                    .addComponent(txtC_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelC_telefone2)
                    .addComponent(txtC_telefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelC_cnpj)
                    .addComponent(txtC_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelC_telefone3)
                    .addComponent(txtC_telefone3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnC_excluir)
                    .addComponent(btnC_editar)
                    .addComponent(btnC_adicionar)
                    .addComponent(btnC_novo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        principal_pane.addTab("Clientes", jInternalFrame1);

        jInternalFrame2.setVisible(true);

        labelP_preco.setText("Preço:");

        txtP_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtP_codigoActionPerformed(evt);
            }
        });

        txtP_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtP_nomeActionPerformed(evt);
            }
        });

        tb_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Preco", "Custo", "Quantidade", "Qtd Minima"
            }
        ));
        tb_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_produtosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_produtos);

        btnP_excluir.setText("Excluir");
        btnP_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP_excluirActionPerformed(evt);
            }
        });

        labelP_custo.setText("Custo");

        txtP_custo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtP_custoActionPerformed(evt);
            }
        });

        btnP_editar.setText("Editar");
        btnP_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP_editarActionPerformed(evt);
            }
        });

        labelP_qtd.setText("Quantidade:");

        btnP_adicionar.setText("Salvar");
        btnP_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP_adicionarActionPerformed(evt);
            }
        });

        labelP_qtdMinima.setText("Quantidade Mínima");

        labelP_codigo.setText("Código");

        labelP_nome.setText("Nome:");

        btnP_novo.setText("Novo");
        btnP_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP_novoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelP_custo)
                    .addComponent(labelP_preco)
                    .addComponent(labelP_nome)
                    .addComponent(labelP_codigo))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtP_nome)
                    .addComponent(txtP_preco)
                    .addComponent(txtP_custo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtP_codigo))
                .addGap(83, 83, 83)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelP_qtd)
                    .addComponent(labelP_qtdMinima))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtP_qtd, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(txtP_qtdMinima))
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnP_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnP_adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnP_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnP_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelP_codigo)
                    .addComponent(txtP_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelP_qtd)
                    .addComponent(txtP_qtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelP_nome)
                    .addComponent(txtP_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelP_qtdMinima)
                    .addComponent(txtP_qtdMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelP_preco)
                    .addComponent(txtP_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelP_custo)
                    .addComponent(txtP_custo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnP_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnP_excluir)
                        .addComponent(btnP_editar)
                        .addComponent(btnP_adicionar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        principal_pane.addTab("Produtos", jInternalFrame2);

        jInternalFrame3.setVisible(true);

        tb_vendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Nome de usuário", "Endereço", "Telefone", "Comissão"
            }
        ));
        tb_vendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_vendedorMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tb_vendedor);

        btnV_novo.setText("Novo");
        btnV_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnV_novoActionPerformed(evt);
            }
        });

        btnV_excluir.setText("Excluir");
        btnV_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnV_excluirActionPerformed(evt);
            }
        });

        labelP_custo1.setText("Senha:");

        labelP_preco1.setText("Nome de usuário:");

        btnV_editar.setText("Editar");
        btnV_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnV_editarActionPerformed(evt);
            }
        });

        labelP_qtd1.setText("Endereço:");

        btnV_adicionar.setText("Salvar");
        btnV_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnV_adicionarActionPerformed(evt);
            }
        });

        labelP_qtdMinima1.setText("Telefone:");

        txtV_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtV_nomeActionPerformed(evt);
            }
        });

        labelP_codigo1.setText("Código");

        labelP_nome1.setText("Nome:");

        labelP_qtdMinima2.setText("Comissão:");

        txtV_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtV_senhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelP_custo1)
                    .addComponent(labelP_preco1)
                    .addComponent(labelP_nome1)
                    .addComponent(labelP_codigo1))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtV_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtV_nomeUsuario)
                    .addComponent(txtV_codigo)
                    .addComponent(txtV_senha))
                .addGap(30, 30, 30)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelP_qtd1)
                    .addComponent(labelP_qtdMinima1)
                    .addComponent(labelP_qtdMinima2))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtV_endereco, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(txtV_telefone)
                    .addComponent(txtV_comissao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnV_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnV_adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnV_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnV_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelP_codigo1)
                    .addComponent(txtV_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelP_qtd1)
                    .addComponent(txtV_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelP_nome1)
                    .addComponent(txtV_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelP_qtdMinima1)
                    .addComponent(txtV_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelP_qtdMinima2)
                        .addComponent(txtV_comissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelP_preco1)
                        .addComponent(txtV_nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelP_custo1)
                    .addComponent(txtV_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnV_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnV_excluir)
                        .addComponent(btnV_editar)
                        .addComponent(btnV_adicionar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        principal_pane.addTab("Vendedor", jInternalFrame3);

        jInternalFrame5.setVisible(true);

        tb_vendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Produto", "Vendedor", "Cliente", "Forma de Pagamento", "Quantidade", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_vendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_vendasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tb_vendas);

        javax.swing.GroupLayout jInternalFrame5Layout = new javax.swing.GroupLayout(jInternalFrame5.getContentPane());
        jInternalFrame5.getContentPane().setLayout(jInternalFrame5Layout);
        jInternalFrame5Layout.setHorizontalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
            .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jInternalFrame5Layout.setVerticalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
            .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        principal_pane.addTab("Vendas", jInternalFrame5);

        label_welcome.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_welcome.setText("Bem vindo, usuário!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal_pane)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(label_welcome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(label_welcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(principal_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtV_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtV_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtV_senhaActionPerformed

    private void txtV_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtV_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtV_nomeActionPerformed

    private void btnV_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnV_adicionarActionPerformed
        int id_vendedor;
        float comissao;
        String nome,
        endereco,
        telefone,
        nome_usuario,
        senha;

        id_vendedor = Integer.parseInt(txtV_codigo.getText());
        nome = txtV_nome.getText();
        endereco = txtV_nomeUsuario.getText();
        telefone = txtV_senha.getText();
        nome_usuario = txtV_endereco.getText();
        senha = txtV_telefone.getText();
        comissao = Float.parseFloat(txtV_comissao.getText());

        if(produtoModo.equals("Novo")) {
            if(VendedorC.SalvarVendedor(nome, endereco, telefone, nome_usuario, senha, comissao)) {
                JOptionPane.showMessageDialog(null, "Vendedor salvo com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Houve um erro ao salvar vendedor.");
            }

        } else if(produtoModo.equals("Editar")) {
            int index = tb_vendedor.getSelectedRow();
            String v[] = VendedorModelo.getVendedor(index);
            id_vendedor = Integer.parseInt(v[0]);

            if(VendedorC.AlterarVendedor(nome, endereco, telefone, nome_usuario, senha, comissao)) {
                JOptionPane.showMessageDialog(null, "Vendedor alterado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Houve um erro ao alterar vendedor.");
            }
        }

        setBotoesVendedor(false, false, false, true);
        LimpaCamposVendedor();
        BloqueiaCamposVendedor();
        CarregarTabelaVendedor();
    }//GEN-LAST:event_btnV_adicionarActionPerformed

    private void btnV_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnV_editarActionPerformed
        setBotoesVendedor(true, false, false, false);
        LiberaCamposVendedor();
        vendedorModo = "Editar";
    }//GEN-LAST:event_btnV_editarActionPerformed

    private void btnV_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnV_excluirActionPerformed
        int index = tb_vendedor.getSelectedRow();
        String v[] = ProdutoModelo.getProduto(index);
        int id = Integer.parseInt(v[0]);

        if(VendedorC.ExcluirVendedor(id)) {
            JOptionPane.showMessageDialog(null, "Vendedor excluido com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Houve um erro ao excluir vendedor.");
        }

        setBotoesVendedor(false, false, false, true);
        BloqueiaCamposVendedor();
        LimpaCamposVendedor();
        CarregarTabelaVendedor();
    }//GEN-LAST:event_btnV_excluirActionPerformed

    private void btnV_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnV_novoActionPerformed
        setBotoesVendedor(true, false, false, false);
        LimpaCamposVendedor();
        LiberaCamposVendedor();
        vendedorModo = "Novo";
    }//GEN-LAST:event_btnV_novoActionPerformed

    private void tb_vendedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_vendedorMouseClicked
        setBotoesVendedor(true, true, true, true);
        BloqueiaCamposVendedor();
        int index = tb_vendedor.getSelectedRow();
        vendedorModo = "Selecao";

        if(index >= 0 && index < VendedorModelo.getRowCount()){
            String temp[] = VendedorModelo.getVendedor(index);
            txtV_codigo.setText(temp[0]);
            txtV_nome.setText(temp[1]);
            txtV_nomeUsuario.setText(temp[2]);
            txtV_senha.setText(temp[3]);
            txtV_endereco.setText(temp[4]);
            txtV_telefone.setText(temp[5]);
            txtV_comissao.setText(temp[6]);
        }
    }//GEN-LAST:event_tb_vendedorMouseClicked

    private void btnP_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP_novoActionPerformed
        setBotoesProduto(true, false, false, false);
        LimpaCamposProduto();
        LiberaCamposProduto();
        produtoModo = "Novo";
    }//GEN-LAST:event_btnP_novoActionPerformed

    private void btnP_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP_adicionarActionPerformed
        int id, qtd, qtdMin, codigo;
        double preco, custo;
        String nome;

        codigo = Integer.parseInt(txtP_codigo.getText());
        nome = txtP_nome.getText();
        preco = Double.parseDouble(txtP_preco.getText());
        custo = Double.parseDouble(txtP_custo.getText());
        qtd = Integer.parseInt(txtP_qtd.getText());
        qtdMin = Integer.parseInt(txtP_qtdMinima.getText());

        if(produtoModo.equals("Novo")) {
            if(ProdutoC.SalvarProduto(nome, preco, custo, qtd, qtdMin, codigo)) {
                JOptionPane.showMessageDialog(null, "Produto salvo com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Houve um erro ao salvar produto.");
            }

        } else if(produtoModo.equals("Editar")) {
            int index = tb_produtos.getSelectedRow();
            String p[] = ProdutoModelo.getProduto(index);
            id = Integer.parseInt(p[0]);

            if(ProdutoC.AlterarProduto(id, nome, preco, custo, qtd, qtdMin, codigo)) {
                JOptionPane.showMessageDialog(null, "Produto alterado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Houve um erro ao alterar produto.");
            }
        }

        setBotoesProduto(false, false, false, true);
        LimpaCamposProduto();
        BloqueiaCamposProduto();
        CarregarTabelaProduto();
    }//GEN-LAST:event_btnP_adicionarActionPerformed

    private void btnP_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP_editarActionPerformed
        setBotoesProduto(true, false, false, false);
        LiberaCamposProduto();
        produtoModo = "Editar";
    }//GEN-LAST:event_btnP_editarActionPerformed

    private void txtP_custoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtP_custoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtP_custoActionPerformed

    private void btnP_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP_excluirActionPerformed
        int index = tb_produtos.getSelectedRow();
        String c[] = ProdutoModelo.getProduto(index);
        int id = Integer.parseInt(c[0]);
        if(ProdutoC.ExcluirProduto(id)) {
            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Houve um erro ao excluir cliente.");
        }

        setBotoesProduto(false, false, false, true);
        BloqueiaCamposProduto();
        LimpaCamposProduto();
        CarregarTabelaProduto();
    }//GEN-LAST:event_btnP_excluirActionPerformed

    private void tb_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_produtosMouseClicked
        setBotoesProduto(true, true, true, true);
        BloqueiaCamposProduto();
        int index = tb_produtos.getSelectedRow();
        produtoModo = "Selecao";

        if(index >= 0 && index < ProdutoModelo.getRowCount()){
            String temp[] = ProdutoModelo.getProduto(index);
            txtP_codigo.setText(temp[0]);
            txtP_nome.setText(temp[1]);
            txtP_preco.setText(temp[2]);
            txtP_custo.setText(temp[3]);
            txtP_qtd.setText(temp[4]);
            txtP_qtdMinima.setText(temp[5]);
        }
    }//GEN-LAST:event_tb_produtosMouseClicked

    private void txtP_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtP_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtP_nomeActionPerformed

    private void txtP_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtP_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtP_codigoActionPerformed

    private void btnC_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC_novoActionPerformed
        setBotoesCliente(true, false, false, false);
        LimpaCamposCliente();
        LiberaCamposCliente();
        clienteModo = "Novo";
    }//GEN-LAST:event_btnC_novoActionPerformed

    private void btnC_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC_editarActionPerformed
        setBotoesCliente(true, false, false, false);
        LiberaCamposCliente();
        clienteModo = "Editar";
    }//GEN-LAST:event_btnC_editarActionPerformed

    private void txtC_cnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtC_cnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtC_cnpjActionPerformed

    private void btnC_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC_excluirActionPerformed
        int index = tb_clientes.getSelectedRow();
        String c[] = ClienteModelo.getCliente(index);
        int id = Integer.parseInt(c[0]);
        if(ClienteC.ExcluirCliente(id)) {
            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Houve um erro ao excluir cliente.");
        }

        setBotoesCliente(false, false, false, true);
        BloqueiaCamposCliente();
        LimpaCamposCliente();
        CarregarTabelaCliente();
    }//GEN-LAST:event_btnC_excluirActionPerformed

    private void tb_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_clientesMouseClicked
        setBotoesCliente(true, true, true, true);
        BloqueiaCamposCliente();
        int index = tb_clientes.getSelectedRow();
        clienteModo = "Selecao";

        if(index >= 0 && index < ClienteModelo.getRowCount()){
            String temp[] = ClienteModelo.getCliente(index);
            txtC_nome.setText(temp[1]);
            txtC_email.setText(temp[2]);
            txtC_endereco.setText(temp[3]);
            txtC_cnpj.setText(temp[4]);
            txtC_cpf.setText(temp[5]);
            txtC_telefone1.setText(temp[6]);
            txtC_telefone2.setText(temp[7]);
            txtC_telefone3.setText(temp[8]);
        }
    }//GEN-LAST:event_tb_clientesMouseClicked

    private void btnC_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC_adicionarActionPerformed
        int id;
        String nome, email, endereco, cnpj, cpf, telefone1, telefone2, telefone3;

        nome =  txtC_nome.getText();
        email = txtC_email.getText();
        endereco = txtC_endereco.getText();
        cnpj = txtC_cnpj.getText();
        cpf = txtC_cpf.getText();
        telefone1 = txtC_telefone1.getText();
        telefone2 = txtC_telefone2.getText();
        telefone3 = txtC_telefone3.getText();

        if(clienteModo.equals("Novo")) {
            if(ClienteC.SalvarCliente(email, nome, cnpj, cpf, endereco, telefone1, telefone2, telefone3)) {
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Houve um erro ao salvar cliente.");
            }

        } else if(clienteModo.equals("Editar")) {
            int index = tb_clientes.getSelectedRow();
            String c[] = ClienteModelo.getCliente(index);
            id = Integer.parseInt(c[0]);

            if(ClienteC.AlterarCliente(id, email, nome, cnpj, cpf, endereco, telefone1, telefone2, telefone3)) {
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Houve um erro ao alterar cliente.");
            }
        }

        setBotoesCliente(false, false, false, true);
        LimpaCamposCliente();
        BloqueiaCamposCliente();
        CarregarTabelaCliente();
    }//GEN-LAST:event_btnC_adicionarActionPerformed

    private void txtC_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtC_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtC_emailActionPerformed

    private void tb_vendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_vendasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_vendasMouseClicked

    private void btnVendas_efetuarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendas_efetuarVendaActionPerformed
        String id_cliente = txtVendas_codCliente.getText();
        String id_vendedor = txtVendas_codVendedor.getText();
        String id_produto = txtVendas_codProduto.getText();
        String forma_pagamento = jList1.getSelectedValue();
        String qtd = txtVendas_qtd.getText();
        
        if(id_cliente.isEmpty() || 
                id_vendedor.isEmpty() || 
                id_produto.isEmpty() || 
                forma_pagamento.isEmpty() || 
                qtd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            
        } else if (Integer.parseInt(qtd) < Produto.getQtd_min()) {
                JOptionPane.showMessageDialog(null, "A quantidade mínima para comprar " + Produto.getNome() + " é " + Produto.getQtd_min());
        } else {
            VendaC.CriarVenda(
                    Integer.parseInt(id_cliente),
                    Integer.parseInt(id_vendedor),
                    Integer.parseInt(id_produto),
                    forma_pagamento,
                    Integer.parseInt(qtd)
            );
            CarregarTabelaVendas();
        }
    }//GEN-LAST:event_btnVendas_efetuarVendaActionPerformed

    private void txtVendas_qtdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVendas_qtdKeyPressed
       
    }//GEN-LAST:event_txtVendas_qtdKeyPressed

    private void btnVendas_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendas_buscarActionPerformed
        String id = txtVendas_codProduto.getText();
        
        if(!id.isEmpty()) {
            Produto = ProdutoC.BuscarProduto(Integer.parseInt(id));
            
            if(Produto != null) {
                txtVendas_produto.setText(Produto.getNome());
                btnVendas_calcular.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado");
                btnVendas_calcular.setEnabled(false);
            }
        }
        
    }//GEN-LAST:event_btnVendas_buscarActionPerformed

    private void btnVendas_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendas_calcularActionPerformed
        Double preco = Produto.getPreco();
        
        if(!txtVendas_qtd.getText().isEmpty()) {
            int qtd = Integer.parseInt(txtVendas_qtd.getText());
            Double total = qtd * preco;
            txtVendas_total.setText(total.toString());
        }
        
    }//GEN-LAST:event_btnVendas_calcularActionPerformed

    private void txtVendas_codVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVendas_codVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVendas_codVendedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnC_adicionar;
    private javax.swing.JButton btnC_editar;
    private javax.swing.JButton btnC_excluir;
    private javax.swing.JButton btnC_novo;
    private javax.swing.JButton btnP_adicionar;
    private javax.swing.JButton btnP_editar;
    private javax.swing.JButton btnP_excluir;
    private javax.swing.JButton btnP_novo;
    private javax.swing.JButton btnV_adicionar;
    private javax.swing.JButton btnV_editar;
    private javax.swing.JButton btnV_excluir;
    private javax.swing.JButton btnV_novo;
    private javax.swing.JButton btnVendas_buscar;
    private javax.swing.JButton btnVendas_calcular;
    private javax.swing.JButton btnVendas_efetuarVenda;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelC_cnpj;
    private javax.swing.JLabel labelC_cpf;
    private javax.swing.JLabel labelC_email;
    private javax.swing.JLabel labelC_endereco;
    private javax.swing.JLabel labelC_nome;
    private javax.swing.JLabel labelC_telefone1;
    private javax.swing.JLabel labelC_telefone2;
    private javax.swing.JLabel labelC_telefone3;
    private javax.swing.JLabel labelP_codigo;
    private javax.swing.JLabel labelP_codigo1;
    private javax.swing.JLabel labelP_custo;
    private javax.swing.JLabel labelP_custo1;
    private javax.swing.JLabel labelP_nome;
    private javax.swing.JLabel labelP_nome1;
    private javax.swing.JLabel labelP_preco;
    private javax.swing.JLabel labelP_preco1;
    private javax.swing.JLabel labelP_qtd;
    private javax.swing.JLabel labelP_qtd1;
    private javax.swing.JLabel labelP_qtdMinima;
    private javax.swing.JLabel labelP_qtdMinima1;
    private javax.swing.JLabel labelP_qtdMinima2;
    private javax.swing.JLabel label_welcome;
    private javax.swing.JTabbedPane principal_pane;
    private javax.swing.JTable tb_clientes;
    private javax.swing.JTable tb_produtos;
    private javax.swing.JTable tb_vendas;
    private javax.swing.JTable tb_vendedor;
    private javax.swing.JTextField txtC_cnpj;
    private javax.swing.JTextField txtC_cpf;
    private javax.swing.JTextField txtC_email;
    private javax.swing.JTextField txtC_endereco;
    private javax.swing.JTextField txtC_nome;
    private javax.swing.JTextField txtC_telefone1;
    private javax.swing.JTextField txtC_telefone2;
    private javax.swing.JTextField txtC_telefone3;
    private javax.swing.JTextField txtP_codigo;
    private javax.swing.JTextField txtP_custo;
    private javax.swing.JTextField txtP_nome;
    private javax.swing.JTextField txtP_preco;
    private javax.swing.JTextField txtP_qtd;
    private javax.swing.JTextField txtP_qtdMinima;
    private javax.swing.JTextField txtV_codigo;
    private javax.swing.JTextField txtV_comissao;
    private javax.swing.JTextField txtV_endereco;
    private javax.swing.JTextField txtV_nome;
    private javax.swing.JTextField txtV_nomeUsuario;
    private javax.swing.JPasswordField txtV_senha;
    private javax.swing.JTextField txtV_telefone;
    private javax.swing.JTextField txtVendas_codCliente;
    private javax.swing.JTextField txtVendas_codProduto;
    private javax.swing.JTextField txtVendas_codVendedor;
    private javax.swing.JTextField txtVendas_produto;
    private javax.swing.JTextField txtVendas_qtd;
    private javax.swing.JTextField txtVendas_total;
    // End of variables declaration//GEN-END:variables
}
