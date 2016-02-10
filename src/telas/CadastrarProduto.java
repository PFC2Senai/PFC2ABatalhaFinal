package telas;

import atributos.Fabricante;
import atributos.HistoricoProduto;
import atributos.Modelo;
import atributos.Produto;
import static atributos.Usuario.idUsuario;
import funcoes.Conexao;
import funcoes.FabricanteDAO;
import static funcoes.FuncoesDiversas.FormataData;
import funcoes.HistoricoProdutoDAO;
import funcoes.LimitarDigitos;
import funcoes.ModeloDAO;
import funcoes.ProdutoDAO;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author S015365
 */
public class CadastrarProduto extends javax.swing.JFrame {

    Produto prod = new Produto();
    private PreparedStatement pst;
    private int codProduto;
    private int codFornecedor;
    private int codFabricante;
    private int codModelo;
    private boolean confirmaCadNovoProduto;
    private Menu telaMenu;
    private ExibeProduto telaExibeProduto;

    /**
     * Creates new form CadastroUsuario
     */
    public CadastrarProduto() {
        initComponents();      
    }
    
    public CadastrarProduto(Menu menu) {
        this.telaMenu = menu;
        initComponents();
        populaComboBoxFornecedor();
        populaComboBoxFabricante();
        carregarComboPeca();
        ocultaCampos();
        combobox();
        LimitarCampos();       
    }
    
    public CadastrarProduto(ExibeProduto exibeProd) {
        this.telaExibeProduto = exibeProd;
        initComponents();
        populaComboBoxFornecedor();
        populaComboBoxFabricante();
        carregarComboPeca();
        ocultaCampos();
        combobox();
        LimitarCampos();       
    }

    private void combobox() {
        uJComboBoxPeca.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codProduto == 0 && uJComboBoxPeca.getSelectedIndex() != 0) {
                    JOptionPane.showMessageDialog(null, "Esse registro não encontra-se cadastrado na base de dados.");
                    uJComboBoxPeca.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        uJComboBoxPeca.setAutocompletar(true);
    }

    private void LimitarCampos() {
        txtProduto.setDocument(new LimitarDigitos(45));
        txtFabricante.setDocument(new LimitarDigitos(45));
        txtModeloNovo.setDocument(new LimitarDigitos(70));
        txtPrecoEntrada.setDocument(new LimitarDigitos(45));
        txtPrecoEntrada.setDocument(new LimitarDigitos(10));
        txtPercentual.setDocument(new LimitarDigitos(5));
        txtPrecoSaida.setDocument(new LimitarDigitos(10));
        txtQuantidade.setDocument(new LimitarDigitos(5));
        txtQuantMinima.setDocument(new LimitarDigitos(5));
    }

    private void ocultaCampos() {
        txtProduto.setVisible(false);
        jBtnCadProduto.setVisible(false);
        jBtnCancelarCadProduto.setVisible(false);

        txtFabricante.setVisible(false);
        jBtnSalvarFabricante.setVisible(false);
        jBtnCancelarFabricante.setVisible(false);

        jBtnSalvarModelo.setVisible(false);
        jBtnCancelarModelo.setVisible(false);
        jBtnNovoModelo.setVisible(false);
        jComboBoxModelo.setVisible(false);
        txtModeloNovo.setVisible(false);
    }

    private void limparCampos() {
        txtProduto.setText("");
        txtPrecoEntrada.setText("");
        txtPrecoSaida.setText("");
        txtQuantidade.setText("");
        jComboBoxFabricante.setSelectedIndex(0);
        jComboBoxFornecedor.setSelectedIndex(0);
        txtModeloFixo.setText("");
        txtPercentual.setText("");
        txtQuantMinima.setText("");
        txtDataCadProduto.setDate(null);
    }

    public void formatar() {

    }

    private boolean VerificaCampos() {

        boolean valida = true;

        if (uJComboBoxPeca.getSelectedIndex() == 0 && txtProduto.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione uma Peça!");
            valida = false;
            return valida;
        }
        
        if (jComboBoxModelo.getSelectedIndex() == 0 && txtModeloFixo.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um Modelo!");
            valida = false;
            return valida;
        }
        
        if (jComboBoxFabricante.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um Fabricante!");
            valida = false;
            return valida;
        }

        if (jComboBoxFornecedor.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um Fornecedor!");
            valida = false;
            return valida;
        }

        if (txtPrecoEntrada.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Valor de Entrada!");
            valida = false;
            return valida;
        }
        
        if (txtPercentual.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Percentual!");
            valida = false;
            return valida;
        }
        
        if (txtPrecoSaida.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Valor de Saída!");
            valida = false;
            return valida;
        }
              
        if (txtQuantidade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Quantidade!");
            valida = false;
            return valida;
        }

        if (txtQuantMinima.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Quantidade Mínima!");
            valida = false;
            return valida;
        }

         if (txtDataCadProduto.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Data!");
            valida = false;
            return valida;
        }

        return valida;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jBtnCadastrarProduto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtPrecoEntrada = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPercentual = new javax.swing.JTextField();
        jBtnCalcularPercentual = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtPrecoSaida = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        txtQuantMinima = new javax.swing.JTextField();
        txtDataCadProduto = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxFornecedor = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jBtnNovoFornecedor = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jBtnNovoFabricante = new javax.swing.JButton();
        jBtnSalvarFabricante = new javax.swing.JButton();
        jBtnCancelarFabricante = new javax.swing.JButton();
        jBtnNovoModelo = new javax.swing.JButton();
        jBtnSalvarModelo = new javax.swing.JButton();
        jBtnCancelarModelo = new javax.swing.JButton();
        uJComboBoxPeca = new componentes.UJComboBox();
        txtModeloNovo = new javax.swing.JTextField();
        txtFabricante = new javax.swing.JTextField();
        jComboBoxFabricante = new javax.swing.JComboBox();
        txtProduto = new javax.swing.JTextField();
        jBtbNovoProduto = new javax.swing.JButton();
        jBtnCadProduto = new javax.swing.JButton();
        jBtnCancelarCadProduto = new javax.swing.JButton();
        txtModeloFixo = new javax.swing.JTextField();
        jComboBoxModelo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Raavi", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/stop2.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        jBtnCadastrarProduto.setFont(new java.awt.Font("Raavi", 0, 14)); // NOI18N
        jBtnCadastrarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        jBtnCadastrarProduto.setText("Cadastrar");
        jBtnCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnCadastrarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 490, -1, -1));

        jLabel1.setFont(new java.awt.Font("Raavi", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/prod.png"))); // NOI18N
        jLabel1.setText("Cadastrar Peça");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jPanel3.setBackground(new java.awt.Color(223, 237, 253));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtPrecoEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecoEntradaKeyTyped(evt);
            }
        });

        jLabel7.setText("Valor de Entrada:");

        txtPercentual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPercentualKeyTyped(evt);
            }
        });

        jBtnCalcularPercentual.setText("Calcular");
        jBtnCalcularPercentual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCalcularPercentualActionPerformed(evt);
            }
        });

        jLabel8.setText("Valor de Saída:");

        txtPrecoSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecoSaidaKeyTyped(evt);
            }
        });

        jLabel9.setText("Percentual:");

        jLabel3.setText("Quantidade:");

        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyTyped(evt);
            }
        });

        txtQuantMinima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantMinimaKeyTyped(evt);
            }
        });

        jLabel2.setText("Fornecedor:");

        jComboBoxFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFornecedorActionPerformed(evt);
            }
        });

        jLabel12.setText("Data:");

        jLabel11.setText("Quantidade Mínima:");

        jBtnNovoFornecedor.setText("Novo Fornecedor");
        jBtnNovoFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoFornecedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(txtPrecoEntrada))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnCalcularPercentual))
                            .addComponent(txtQuantMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jComboBoxFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnNovoFornecedor)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(49, 49, 49)
                        .addComponent(txtDataCadProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(58, 58, 58))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnNovoFornecedor))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCalcularPercentual)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQuantMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12))
                    .addComponent(txtDataCadProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 800, 170));

        jPanel2.setBackground(new java.awt.Color(223, 237, 253));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Fabricante:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel5.setText("Modelo:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel10.setText("Peça:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 23, -1, -1));

        jBtnNovoFabricante.setText("Novo Fabricante");
        jBtnNovoFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoFabricanteActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnNovoFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        jBtnSalvarFabricante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jBtnSalvarFabricante.setText("Salvar");
        jBtnSalvarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarFabricanteActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnSalvarFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, -1, -1));

        jBtnCancelarFabricante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelarFabricante.setText("Cancelar");
        jBtnCancelarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarFabricanteActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnCancelarFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        jBtnNovoModelo.setText("Novo Modelo");
        jBtnNovoModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoModeloActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnNovoModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        jBtnSalvarModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jBtnSalvarModelo.setText("Salvar");
        jBtnSalvarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarModeloActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnSalvarModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, -1, -1));

        jBtnCancelarModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelarModelo.setText("Cancelar");
        jBtnCancelarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarModeloActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnCancelarModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));

        uJComboBoxPeca.setEditable(true);
        uJComboBoxPeca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                uJComboBoxPecaItemStateChanged(evt);
            }
        });
        uJComboBoxPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uJComboBoxPecaActionPerformed(evt);
            }
        });
        jPanel2.add(uJComboBoxPeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 19, 390, -1));
        jPanel2.add(txtModeloNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 390, -1));
        jPanel2.add(txtFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 390, -1));

        jComboBoxFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFabricanteActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 390, -1));
        jPanel2.add(txtProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 385, -1));

        jBtbNovoProduto.setText("Nova Peça");
        jBtbNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbNovoProdutoActionPerformed(evt);
            }
        });
        jPanel2.add(jBtbNovoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        jBtnCadProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jBtnCadProduto.setText("Salvar");
        jBtnCadProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadProdutoActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnCadProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 19, -1, -1));

        jBtnCancelarCadProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelarCadProduto.setText("Cancelar");
        jBtnCancelarCadProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarCadProdutoActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnCancelarCadProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 19, -1, -1));

        txtModeloFixo.setEditable(false);
        jPanel2.add(txtModeloFixo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 390, -1));

        jComboBoxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeloActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 390, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 800, 140));

        jLabel13.setBackground(new java.awt.Color(223, 237, 253));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 860, 210));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnNovoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoFornecedorActionPerformed
        new CadastrarFornecedor(this).setVisible(true);
    }//GEN-LAST:event_jBtnNovoFornecedorActionPerformed

    private void jComboBoxFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFornecedorActionPerformed
        idFornecedorComboBox();
    }//GEN-LAST:event_jComboBoxFornecedorActionPerformed

    private void txtQuantMinimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantMinimaKeyTyped
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantMinimaKeyTyped

    private void txtQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyTyped
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantidadeKeyTyped

    private void txtPrecoSaidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoSaidaKeyTyped
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecoSaidaKeyTyped

    private void jBtnCalcularPercentualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCalcularPercentualActionPerformed
        if (txtPrecoEntrada.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Preencha o VALOR DE ENTRADA!");
                txtPrecoEntrada.requestFocus();
                txtPrecoEntrada.setBackground(Color.yellow);
            } else {
                txtPrecoEntrada.setBackground(Color.white);         
            }

            if (txtPercentual.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Preencha o PERCENTUAL!");
                txtPercentual.requestFocus();
                txtPercentual.setBackground(Color.yellow);
            } else {
                txtPercentual.setBackground(Color.white);                
            }
        if (txtPrecoEntrada.getText().trim().equals("") || txtPercentual.getText().trim().equals("")) {         
        }else {
            float percentual = Float.parseFloat(txtPercentual.getText());
            double precoEntrada = Double.parseDouble(txtPrecoEntrada.getText());
            double resultado = (precoEntrada * percentual) / 100;
            txtPrecoSaida.setText(String.valueOf(precoEntrada + resultado));
        }
    }//GEN-LAST:event_jBtnCalcularPercentualActionPerformed

    private void txtPercentualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPercentualKeyTyped
        String caracteres = "0987654321,.%";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPercentualKeyTyped

    private void txtPrecoEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoEntradaKeyTyped
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecoEntradaKeyTyped

    private void jBtnCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastrarProdutoActionPerformed

        if (VerificaCampos() == true) {

            if (confirmaCadNovoProduto == true) {
                prod.setIdUsuario(idUsuario());
                prod.setProduto(txtProduto.getText());
                codProduto = ProdutoDAO.Cadroduto(prod);
            }
            HistoricoProduto histProduto = new HistoricoProduto();
            prod.setCodModelo(codModelo);
            prod.setCodFabricante(codFabricante);
            prod.setDataCadProduto(FormataData(txtDataCadProduto.getDate()));
            prod.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
            prod.setPrecoEntrada(Double.parseDouble(txtPrecoEntrada.getText()));
            prod.setPrecoSaida(Double.parseDouble(txtPrecoSaida.getText()));
            prod.setCodProduto(codProduto);
            prod.setQuantidadeMinima(Integer.parseInt(txtQuantMinima.getText()));

            int codDet = ProdutoDAO.CadDetProduto(prod);

            histProduto.setCodDetProduto(codDet);
            histProduto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
            histProduto.setValor(Double.parseDouble(txtPrecoEntrada.getText()));
            histProduto.setDataCadProduto(FormataData(txtDataCadProduto.getDate()));
            histProduto.setCodFornecedor(codFornecedor);
            HistoricoProdutoDAO.CadHistoricoProd(histProduto);

            txtProduto.setVisible(false);
            uJComboBoxPeca.setVisible(true);

            limparCampos();
            uJComboBoxPeca.removeAllItems();
            carregarComboPeca();
            jBtbNovoProduto.setVisible(true);
            txtProduto.setEditable(true);
            txtModeloFixo.setVisible(true);
            jComboBoxModelo.setVisible(false);
            verificaPagina();
        }
    }//GEN-LAST:event_jBtnCadastrarProdutoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        verificaPagina();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBtnCancelarCadProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarCadProdutoActionPerformed
        confirmaCadNovoProduto = false;
        jBtnCadProduto.setVisible(false);
        confirmaCadNovoProduto = false;
        jBtnCancelarCadProduto.setVisible(false);
        jBtbNovoProduto.setVisible(true);
        txtProduto.setVisible(false);
        txtProduto.setText("");
        uJComboBoxPeca.setVisible(true);
        jComboBoxModelo.setVisible(false);
        txtModeloFixo.setVisible(true);
        jBtnNovoModelo.setVisible(false);
    }//GEN-LAST:event_jBtnCancelarCadProdutoActionPerformed

    private void jBtbNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbNovoProdutoActionPerformed
        jBtnNovoModelo.setVisible(true);
        confirmaCadNovoProduto = true;
        txtModeloFixo.setVisible(false);
        txtProduto.setVisible(true);
        uJComboBoxPeca.setVisible(false);
        jBtnCadProduto.setVisible(true);
        jBtnCancelarCadProduto.setVisible(true);
        jBtbNovoProduto.setVisible(false);
        txtProduto.setEnabled(true);

        jComboBoxModelo.setVisible(true);
        populaComboBoxModelo();
    }//GEN-LAST:event_jBtbNovoProdutoActionPerformed

    private void jComboBoxFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFabricanteActionPerformed
        idFabricanteComboBox();
    }//GEN-LAST:event_jComboBoxFabricanteActionPerformed

    private void uJComboBoxPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJComboBoxPecaActionPerformed
        idProdutoComboBox();
    }//GEN-LAST:event_uJComboBoxPecaActionPerformed

    private void uJComboBoxPecaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_uJComboBoxPecaItemStateChanged

        txtModeloFixo.setText("");
        jComboBoxFabricante.removeAllItems();
        codProduto = 0;
        codModelo = 0;
        codFabricante = 0;
        idProdutoComboBox();
        populaTextFildModelo();
        jComboBoxFabricante.removeAllItems();
        idModeloTextFild();
        populaComboBoxFabricante();
    }//GEN-LAST:event_uJComboBoxPecaItemStateChanged

    private void jBtnCancelarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarFabricanteActionPerformed
        jBtnSalvarFabricante.setVisible(false);
        jBtnCancelarFabricante.setVisible(false);
        jBtnNovoFabricante.setVisible(true);
        txtFabricante.setVisible(false);
        txtFabricante.setText("");
        jComboBoxFabricante.setVisible(true);
    }//GEN-LAST:event_jBtnCancelarFabricanteActionPerformed

    private void jBtnNovoFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoFabricanteActionPerformed
        txtFabricante.setVisible(true);
        jComboBoxFabricante.setVisible(false);
        jBtnSalvarFabricante.setVisible(true);
        jBtnCancelarFabricante.setVisible(true);
        jBtnNovoFabricante.setVisible(false);
    }//GEN-LAST:event_jBtnNovoFabricanteActionPerformed

    private void jBtnCancelarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarModeloActionPerformed
        jBtnSalvarModelo.setVisible(false);
        jBtnCancelarModelo.setVisible(false);
        jBtnNovoModelo.setVisible(true);
        txtModeloNovo.setVisible(false);
        txtModeloNovo.setText("");
        jComboBoxModelo.setVisible(true);
    }//GEN-LAST:event_jBtnCancelarModeloActionPerformed

    private void jBtnNovoModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoModeloActionPerformed
        txtModeloNovo.setVisible(true);
        jComboBoxModelo.setVisible(false);
        jBtnSalvarModelo.setVisible(true);
        jBtnCancelarModelo.setVisible(true);
        jBtnNovoModelo.setVisible(false);
    }//GEN-LAST:event_jBtnNovoModeloActionPerformed

    private void jBtnSalvarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarFabricanteActionPerformed
        Fabricante fabri = new Fabricante();
        fabri.setFabricante(txtFabricante.getText());
        codFabricante = FabricanteDAO.CadFabricante(fabri);
        jBtnSalvarFabricante.setVisible(false);
        jBtnCancelarFabricante.setVisible(false);
        jBtnNovoFabricante.setVisible(true);
        txtFabricante.setVisible(false);
        txtFabricante.setText("");
        jComboBoxFabricante.setVisible(true);
        jComboBoxFabricante.removeAllItems();

        populaComboBoxFabricante();
        jComboBoxFabricante.setSelectedItem(fabri.getFabricante());
    }//GEN-LAST:event_jBtnSalvarFabricanteActionPerformed

    private void jBtnSalvarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarModeloActionPerformed
        Modelo modelo = new Modelo();

        modelo.setModelo(txtModeloNovo.getText());
        ModeloDAO.CadModelo(modelo);
        jBtnSalvarModelo.setVisible(false);
        jBtnCancelarModelo.setVisible(false);
        jBtnNovoModelo.setVisible(true);
        txtModeloNovo.setVisible(false);
        txtModeloNovo.setText("");
        jComboBoxModelo.setVisible(true);
        txtModeloNovo.setText("");

        //   populaTextFildModelo();
        populaComboBoxModelo();
        jComboBoxModelo.setSelectedItem(modelo.getModelo());
    }//GEN-LAST:event_jBtnSalvarModeloActionPerformed

    private void jBtnCadProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadProdutoActionPerformed
        if (txtProduto.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Peça!");
            txtProduto.requestFocus();
        }else {        
            confirmaCadNovoProduto = true;
            populaTextFildModelo();
            jBtnCadProduto.setVisible(false);
            jBtnCancelarCadProduto.setVisible(false);

            carregarComboPeca();
            jBtnNovoModelo.setVisible(false);
            txtProduto.setEditable(false);
        }
    }//GEN-LAST:event_jBtnCadProdutoActionPerformed

    private void jComboBoxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloActionPerformed
        idModeloComboBox();
    }//GEN-LAST:event_jComboBoxModeloActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void carregarComboPeca() {

        // uJComboBoxPeca.clear();
        ArrayList<Produto> pecas = new ArrayList<Produto>();
        pecas = ProdutoDAO.ListarProdutos();

        uJComboBoxPeca.addItem("Selecione a Peça");
        for (Produto prod : pecas) {
            uJComboBoxPeca.addItem(prod.getProduto(), prod);
        }
    }

    private void idProdutoComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabproduto where produto = '" + uJComboBoxPeca.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codProduto = (rs.getInt("id_prod"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void populaComboBoxFornecedor() {

        jComboBoxFornecedor.removeAllItems();
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfornecedor";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            jComboBoxFornecedor.addItem("Selecione o fornecedor");
            while (rs.next()) {
                jComboBoxFornecedor.addItem(rs.getString("fornecedor"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idFornecedorComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfornecedor where fornecedor = '" + jComboBoxFornecedor.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codFornecedor = (rs.getInt("id_forn"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void populaComboBoxFabricante() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfabricante";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            jComboBoxFabricante.addItem("Selecione o fabricante");
            while (rs.next()) {
                jComboBoxFabricante.addItem(rs.getString("fabricante"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idFabricanteComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfabricante where fabricante = '" + jComboBoxFabricante.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codFabricante = (rs.getInt("idtabFabricante"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void populaTextFildModelo() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select modelo "
                + " from tabdetproduto inner join "
                + " tabproduto inner join "
                + " tabmodelo on tabmodelo_idtabModelo = idtabModelo and "
                + " tabproduto_id_prod = id_prod"
                + " where id_prod = " + codProduto + " group by modelo;";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                txtModeloFixo.setText(rs.getString("modelo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idModeloTextFild() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabmodelo where modelo = '" + txtModeloFixo.getText() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codModelo = (rs.getInt("idtabModelo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void populaComboBoxModelo() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabmodelo";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            jComboBoxModelo.addItem("Selecione o modelo");
            while (rs.next()) {
                jComboBoxModelo.addItem(rs.getString("modelo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idModeloComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabmodelo where modelo = '" + jComboBoxModelo.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codModelo = (rs.getInt("idtabModelo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    
    private void verificaPagina() {
        
        if ((this.telaMenu != null)) {
            this.telaMenu.setVisible(true);
            // this.telaMenu.toFront();
        }else if (this.telaExibeProduto != null) {
            this.telaExibeProduto.setVisible(true);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbNovoProduto;
    private javax.swing.JButton jBtnCadProduto;
    private javax.swing.JButton jBtnCadastrarProduto;
    private javax.swing.JButton jBtnCalcularPercentual;
    private javax.swing.JButton jBtnCancelarCadProduto;
    private javax.swing.JButton jBtnCancelarFabricante;
    private javax.swing.JButton jBtnCancelarModelo;
    private javax.swing.JButton jBtnNovoFabricante;
    private javax.swing.JButton jBtnNovoFornecedor;
    private javax.swing.JButton jBtnNovoModelo;
    private javax.swing.JButton jBtnSalvarFabricante;
    private javax.swing.JButton jBtnSalvarModelo;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBoxFabricante;
    private javax.swing.JComboBox jComboBoxFornecedor;
    private javax.swing.JComboBox jComboBoxModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JDateChooser txtDataCadProduto;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtModeloFixo;
    private javax.swing.JTextField txtModeloNovo;
    private javax.swing.JTextField txtPercentual;
    private javax.swing.JTextField txtPrecoEntrada;
    private javax.swing.JTextField txtPrecoSaida;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQuantMinima;
    private javax.swing.JTextField txtQuantidade;
    private componentes.UJComboBox uJComboBoxPeca;
    // End of variables declaration//GEN-END:variables
}
