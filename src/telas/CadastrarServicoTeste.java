package telas;


import atributos.Cliente;
import atributos.DetServicoEquipamento;
import atributos.DetServicoFuncionario;
import atributos.DetServicoProduto;
import atributos.DetServicoTipoServ;
import atributos.Equipamento;
import atributos.Funcionario;
import atributos.OrdemServico;
import atributos.Produto;
import atributos.Servico;
import atributos.TipoServico;
import atributos.Usuario;
import funcoes.ClienteDAO;
import funcoes.Conexao;
import funcoes.DetServicoEquipamentoDAO;
import funcoes.DetServicoFuncionarioDAO;
import funcoes.DetServicoProdutoDAO;
import funcoes.DetServicoTipoDAO;
import funcoes.EquipamentoDAO;
import funcoes.FuncionarioDAO;
import funcoes.FuncoesDiversas;
import funcoes.OrdemServicoDAO;
import funcoes.ProdutoDAO;
import funcoes.ServicoDAO;
import funcoes.TipoServicoDAO;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josy
 */
public class CadastrarServicoTeste extends javax.swing.JFrame {

    private PreparedStatement pst;

    Servico servico = new Servico();
    public static int teste;
    private static final long serialVersionUID = 1L;
    private int codModelo;
    private int codModeloEqui;
    private int codProduto = 0;
    private int codDetProduto;
    private int codFuncionario;
    private int codEquipamento;
    private int codDetEquipamento;
    private int codFabricante = 0;
    private int codFabricanteEqui;
    private int codCliente;
    private int codTipoServico;
    private double valorUnit;
    private double valor;
    private double totalPeca = 0;

    private String produto;
    private String modelo;
    private String modeloEqui;
    private String equipamento;
    private String funcionario;
    private String fabricante;
    private String fabricanteEqui;
    private String tipoServico;

    /**
     * Creates new form CadastrarServicoTeste
     */
    public CadastrarServicoTeste() {

        this.codCliente = 0;

        initComponents();

        combobox();
        carregarComboClientes();
        carregarComboTipoServico();
        carregarComboPeca();
        carregarComboEquipamento();
        carregarComboFuncionario();

        jBtnCadTipoServico.setVisible(false);
        jBtnCancelarCadTipoServico.setVisible(false);

        ocultaColunaTabelas();
        txtTipoServico.setVisible(false);
    }

    private void combobox() {

        //Combobox clientes
        uJComboBoxClientes.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codCliente == 0) {
                    Mensangem();
                    uJComboBoxClientes.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        uJComboBoxClientes.setAutocompletar(true);

        //Combobox tipo servico
        jComboBoxTipoServico.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codTipoServico == 0) {
                    Mensangem();
                    jComboBoxTipoServico.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        jComboBoxTipoServico.setAutocompletar(true);

        //Combobox peca
        uJComboBoxPeca.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codProduto == 0) {
                    Mensangem();
                    uJComboBoxPeca.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        uJComboBoxPeca.setAutocompletar(true);

        //Combobox equipamento
        uJComboBoxEquipamento.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codEquipamento == 0) {
                    Mensangem();
                    uJComboBoxEquipamento.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        uJComboBoxEquipamento.setAutocompletar(true);

        //Combobox Funcionarios
        uJComboBoxFuncionario.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codFuncionario == 0) {
                    Mensangem();
                    uJComboBoxFuncionario.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        uJComboBoxFuncionario.setAutocompletar(true);
    }

    
    
    private boolean VerificaCamposPecas(){
        boolean valida = true;
                
        if (txtQuantidade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }
        
        if (txtValorUnit.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }
        return valida;
    }
    
    
    private boolean VerificaCamposValor(){
        boolean valida = true;
                
        if (txtTotalPecas.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) Vazio(s)!");
            valida = false;
            return valida;
        }
        
        if (txtMaoObra.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) Vazio(s)!");
            valida = false;
            return valida;
        }
        
        if (txtTotalGeral.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) Vazio(s)!");
            valida = false;
            return valida;
        }
        return valida;
    }
    
    
    private boolean VerificaCamposServico(){
        boolean valida = true;
                
        if (txtDataCadProduto.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Campo(s) Vazio(s)!");
            valida = false;
            return valida;
        }
        
        if (txtDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) Vazio(s)!");
            valida = false;
            return valida;
        }
        
        if (jComboBoxTipoServico.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Selecione um item!");
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel6 = new javax.swing.JPanel();
        jTabbedPaneServico = new javax.swing.JTabbedPane();
        jPanelPecas = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jBtbIncluirPeca = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jComboBoxModelo = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePecas = new javax.swing.JTable();
        jBtnRemoverPeca = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jComboBoxFabricante = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        txtValorUnit = new javax.swing.JTextField();
        uJComboBoxPeca = new componentes.UJComboBox();
        jBtnVoltarPainelServico = new javax.swing.JButton();
        jBtnAvancarPainelEquipamento = new javax.swing.JButton();
        jPanelEquipamento = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBtnRemoveEquipamento = new javax.swing.JButton();
        jBtbIncluirEquipamento = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEquipamento = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        jComboBoxModeloEquip = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        jComboBoxFabricanteEquip = new javax.swing.JComboBox();
        uJComboBoxEquipamento = new componentes.UJComboBox();
        jBtnAvancarPainelFuncionario = new javax.swing.JButton();
        jBtnVoltarPainelPecas = new javax.swing.JButton();
        jPanelFuncionario = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableFuncionario = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jBtnRemoverFunc = new javax.swing.JButton();
        jBtbIncluirFunc = new javax.swing.JButton();
        uJComboBoxFuncionario = new componentes.UJComboBox();
        jBtnVoltarPainelEquipamento = new javax.swing.JButton();
        jBtnAvancarPainelValorTotal = new javax.swing.JButton();
        jPanelValorTotalServico = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTotalPecas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaoObra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotalGeral = new javax.swing.JTextField();
        jBtnCalcularTotalServico = new javax.swing.JButton();
        jBtnCadastrarServico3 = new javax.swing.JButton();
        jBtnVoltarPainelFuncionario = new javax.swing.JButton();
        jPanelServico = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTipoServico = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDataCadProduto = new com.toedter.calendar.JDateChooser();
        jBtbNovoTipoServico = new javax.swing.JButton();
        jBtnCadTipoServico = new javax.swing.JButton();
        jBtnCancelarCadTipoServico = new javax.swing.JButton();
        jBtnAdicionarTipo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableTipodeServico = new javax.swing.JTable();
        jBtnRemoverTipo = new javax.swing.JButton();
        uJComboBoxClientes = new componentes.UJComboBox();
        jComboBoxTipoServico = new componentes.UJComboBox();
        jBtnAvancarPainelPecas = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPaneServico.setBackground(new java.awt.Color(249, 238, 238));
        jTabbedPaneServico.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPaneServico.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTabbedPaneServicoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setText("Peça:");
        jPanel14.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 69, -1, -1));

        jBtbIncluirPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jBtbIncluirPeca.setText("Incluir Peça");
        jBtbIncluirPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbIncluirPecaActionPerformed(evt);
            }
        });
        jPanel14.add(jBtbIncluirPeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 159, -1, -1));

        jLabel34.setText("Quantidade:");
        jPanel14.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 110, -1, -1));

        txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeActionPerformed(evt);
            }
        });
        jPanel14.add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 107, 107, -1));

        jComboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Modelo" }));
        jComboBoxModelo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxModeloItemStateChanged(evt);
            }
        });
        jPanel14.add(jComboBoxModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 107, 261, -1));

        jLabel35.setText("Modelo:");
        jPanel14.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jTablePecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Peca", "CódigoModelo", "cod fabricante", "Peça", "Modelo", "Fabricante", "Quantidade", "Valor Unit.", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePecas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTablePecas);

        jPanel14.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 202, 682, 162));

        jBtnRemoverPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jBtnRemoverPeca.setText("Remover");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTablePecas, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnRemoverPeca, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnRemoverPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverPecaActionPerformed(evt);
            }
        });
        jPanel14.add(jBtnRemoverPeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 382, -1, -1));

        jLabel36.setText("Fabricante:");
        jPanel14.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 69, -1, -1));

        jComboBoxFabricante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Fabricante" }));
        jComboBoxFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFabricanteActionPerformed(evt);
            }
        });
        jPanel14.add(jComboBoxFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 66, 282, -1));

        jLabel39.setText("Valor Unit.");
        jPanel14.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 110, -1, -1));
        jPanel14.add(txtValorUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 107, 108, -1));

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
        jPanel14.add(uJComboBoxPeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 66, 258, -1));

        jBtnVoltarPainelServico.setText("Voltar");
        jBtnVoltarPainelServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarPainelServicoActionPerformed(evt);
            }
        });

        jBtnAvancarPainelEquipamento.setText("Avançar");
        jBtnAvancarPainelEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAvancarPainelEquipamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPecasLayout = new javax.swing.GroupLayout(jPanelPecas);
        jPanelPecas.setLayout(jPanelPecasLayout);
        jPanelPecasLayout.setHorizontalGroup(
            jPanelPecasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPecasLayout.createSequentialGroup()
                .addGroup(jPanelPecasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPecasLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jBtnVoltarPainelServico)
                        .addGap(588, 588, 588)
                        .addComponent(jBtnAvancarPainelEquipamento))
                    .addGroup(jPanelPecasLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanelPecasLayout.setVerticalGroup(
            jPanelPecasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPecasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPecasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnVoltarPainelServico)
                    .addComponent(jBtnAvancarPainelEquipamento))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPaneServico.addTab("Peças", new javax.swing.ImageIcon(getClass().getResource("/imagens/prod.png")), jPanelPecas); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Equipamento:");

        jBtnRemoveEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jBtnRemoveEquipamento.setText("Remover");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableEquipamento, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnRemoveEquipamento, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnRemoveEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoveEquipamentoActionPerformed(evt);
            }
        });

        jBtbIncluirEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jBtbIncluirEquipamento.setText("IncluirEquipamento");
        jBtbIncluirEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbIncluirEquipamentoActionPerformed(evt);
            }
        });

        jTableEquipamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Id modelo", "Id fabricante", "Equipamento", "Modelo", "Fabricante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEquipamento.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableEquipamento);

        jLabel37.setText("Modelo:");

        jComboBoxModeloEquip.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Modelo" }));
        jComboBoxModeloEquip.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxModeloEquipItemStateChanged(evt);
            }
        });
        jComboBoxModeloEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeloEquipActionPerformed(evt);
            }
        });

        jLabel38.setText("Fabricante:");

        jComboBoxFabricanteEquip.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Fabricante" }));
        jComboBoxFabricanteEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFabricanteEquipActionPerformed(evt);
            }
        });

        uJComboBoxEquipamento.setEditable(true);
        uJComboBoxEquipamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                uJComboBoxEquipamentoItemStateChanged(evt);
            }
        });
        uJComboBoxEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uJComboBoxEquipamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxFabricanteEquip, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel37))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jComboBoxModeloEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(uJComboBoxEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnRemoveEquipamento)
                    .addComponent(jBtbIncluirEquipamento)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(uJComboBoxEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jComboBoxModeloEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jComboBoxFabricanteEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jBtbIncluirEquipamento)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnRemoveEquipamento)
                .addGap(58, 58, 58))
        );

        jBtnAvancarPainelFuncionario.setText("Avançar");
        jBtnAvancarPainelFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAvancarPainelFuncionarioActionPerformed(evt);
            }
        });

        jBtnVoltarPainelPecas.setText("Voltar");
        jBtnVoltarPainelPecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarPainelPecasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEquipamentoLayout = new javax.swing.GroupLayout(jPanelEquipamento);
        jPanelEquipamento.setLayout(jPanelEquipamentoLayout);
        jPanelEquipamentoLayout.setHorizontalGroup(
            jPanelEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEquipamentoLayout.createSequentialGroup()
                .addGroup(jPanelEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEquipamentoLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jBtnVoltarPainelPecas)
                        .addGap(618, 618, 618)
                        .addComponent(jBtnAvancarPainelFuncionario))
                    .addGroup(jPanelEquipamentoLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanelEquipamentoLayout.setVerticalGroup(
            jPanelEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEquipamentoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnVoltarPainelPecas)
                    .addComponent(jBtnAvancarPainelFuncionario))
                .addGap(30, 30, 30))
        );

        jTabbedPaneServico.addTab("Equipamento", new javax.swing.ImageIcon(getClass().getResource("/imagens/equipamento.png")), jPanelEquipamento); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTableFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Funcionário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFuncionario.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableFuncionario);

        jLabel7.setText("Funcionário:");

        jBtnRemoverFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jBtnRemoverFunc.setText("Remover");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableFuncionario, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnRemoverFunc, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnRemoverFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverFuncActionPerformed(evt);
            }
        });

        jBtbIncluirFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jBtbIncluirFunc.setText("Incluir Funcionário");
        jBtbIncluirFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbIncluirFuncActionPerformed(evt);
            }
        });

        uJComboBoxFuncionario.setEditable(true);
        uJComboBoxFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uJComboBoxFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtbIncluirFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnRemoverFunc, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(uJComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uJComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jBtbIncluirFunc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jBtnRemoverFunc)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jBtnVoltarPainelEquipamento.setText("Voltar");
        jBtnVoltarPainelEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarPainelEquipamentoActionPerformed(evt);
            }
        });

        jBtnAvancarPainelValorTotal.setText("Avançar");
        jBtnAvancarPainelValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAvancarPainelValorTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFuncionarioLayout = new javax.swing.GroupLayout(jPanelFuncionario);
        jPanelFuncionario.setLayout(jPanelFuncionarioLayout);
        jPanelFuncionarioLayout.setHorizontalGroup(
            jPanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFuncionarioLayout.createSequentialGroup()
                .addGroup(jPanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFuncionarioLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jBtnVoltarPainelEquipamento)
                        .addGap(608, 608, 608)
                        .addComponent(jBtnAvancarPainelValorTotal))
                    .addGroup(jPanelFuncionarioLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanelFuncionarioLayout.setVerticalGroup(
            jPanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnVoltarPainelEquipamento)
                    .addComponent(jBtnAvancarPainelValorTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneServico.addTab("Funcionário", new javax.swing.ImageIcon(getClass().getResource("/imagens/funcionario.png")), jPanelFuncionario); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Valor total de peças:");

        txtTotalPecas.setEditable(false);

        jLabel3.setText("Mão de obra:");

        jLabel4.setText("Total serviço:");

        jBtnCalcularTotalServico.setText("Calcular Total");
        jBtnCalcularTotalServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCalcularTotalServicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotalPecas)
                    .addComponent(txtMaoObra)
                    .addComponent(txtTotalGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBtnCalcularTotalServico)
                .addContainerGap(260, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTotalPecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaoObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCalcularTotalServico))
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotalGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jBtnCadastrarServico3.setText("Finalizar Serviço");
        jBtnCadastrarServico3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarServico3ActionPerformed(evt);
            }
        });

        jBtnVoltarPainelFuncionario.setText("Voltar");
        jBtnVoltarPainelFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarPainelFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelValorTotalServicoLayout = new javax.swing.GroupLayout(jPanelValorTotalServico);
        jPanelValorTotalServico.setLayout(jPanelValorTotalServicoLayout);
        jPanelValorTotalServicoLayout.setHorizontalGroup(
            jPanelValorTotalServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelValorTotalServicoLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jBtnVoltarPainelFuncionario)
                .addGap(551, 551, 551)
                .addComponent(jBtnCadastrarServico3)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(jPanelValorTotalServicoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelValorTotalServicoLayout.setVerticalGroup(
            jPanelValorTotalServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelValorTotalServicoLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addGroup(jPanelValorTotalServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCadastrarServico3)
                    .addComponent(jBtnVoltarPainelFuncionario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneServico.addTab("Valor", new javax.swing.ImageIcon(getClass().getResource("/imagens/dinheiro.png")), jPanelValorTotalServico); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Empresa:");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 20));
        jPanel7.add(txtTipoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 240, -1));

        jLabel10.setText("Tipo:");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel12.setText("Data:");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 30, 20));
        jPanel7.add(txtDataCadProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 120, -1));

        jBtbNovoTipoServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ferramenta.png"))); // NOI18N
        jBtbNovoTipoServico.setText("Novo");
        jBtbNovoTipoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbNovoTipoServicoActionPerformed(evt);
            }
        });
        jPanel7.add(jBtbNovoTipoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, -1, -1));

        jBtnCadTipoServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jBtnCadTipoServico.setText("Salvar");
        jBtnCadTipoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadTipoServicoActionPerformed(evt);
            }
        });
        jPanel7.add(jBtnCadTipoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 90, -1));

        jBtnCancelarCadTipoServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelarCadTipoServico.setText("Cancelar");
        jBtnCancelarCadTipoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarCadTipoServicoActionPerformed(evt);
            }
        });
        jPanel7.add(jBtnCancelarCadTipoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, -1, -1));

        jBtnAdicionarTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jBtnAdicionarTipo.setText("Inserir Tipo");
        jBtnAdicionarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionarTipoActionPerformed(evt);
            }
        });
        jPanel7.add(jBtnAdicionarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, -1, -1));

        jLabel5.setText("Descrição:");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 20));

        txtDescricao.setColumns(20);
        txtDescricao.setLineWrap(true);
        txtDescricao.setRows(5);
        jScrollPane4.setViewportView(txtDescricao);

        jPanel7.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 610, 100));

        jTableTipodeServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo Serviço"
            }
        ));
        jTableTipodeServico.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTableTipodeServico);

        jPanel7.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 610, 140));

        jBtnRemoverTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jBtnRemoverTipo.setText("Remover Tipo");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableTipodeServico, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnRemoverTipo, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnRemoverTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverTipoActionPerformed(evt);
            }
        });
        jPanel7.add(jBtnRemoverTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, -1, -1));

        uJComboBoxClientes.setEditable(true);
        uJComboBoxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uJComboBoxClientesActionPerformed(evt);
            }
        });
        jPanel7.add(uJComboBoxClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 340, -1));

        jComboBoxTipoServico.setEditable(true);
        jComboBoxTipoServico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoServicoItemStateChanged(evt);
            }
        });
        jComboBoxTipoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoServicoActionPerformed(evt);
            }
        });
        jPanel7.add(jComboBoxTipoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 260, -1));

        jBtnAvancarPainelPecas.setText("Avançar");
        jBtnAvancarPainelPecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAvancarPainelPecasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelServicoLayout = new javax.swing.GroupLayout(jPanelServico);
        jPanelServico.setLayout(jPanelServicoLayout);
        jPanelServicoLayout.setHorizontalGroup(
            jPanelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelServicoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnAvancarPainelPecas)
                .addGap(133, 133, 133))
            .addGroup(jPanelServicoLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanelServicoLayout.setVerticalGroup(
            jPanelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAvancarPainelPecas)
                .addContainerGap())
        );

        jTabbedPaneServico.addTab("Serviço", new javax.swing.ImageIcon(getClass().getResource("/imagens/servicos.png")), jPanelServico); // NOI18N

        jPanel6.add(jTabbedPaneServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 830, 580));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3.png"))); // NOI18N
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 850, 940));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        setSize(new java.awt.Dimension(866, 743));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAdicionarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionarTipoActionPerformed
if(VerificaCamposServico()== true){
        TabelaTipoServico();
}
    }//GEN-LAST:event_jBtnAdicionarTipoActionPerformed

    private void jBtnRemoverTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoverTipoActionPerformed
        
        DefaultTableModel dtm = (DefaultTableModel) jTableTipodeServico.getModel();
        int linha = jTableTipodeServico.getSelectedRow();

        if (linha != -1) {
            dtm.removeRow(linha);
        }
    }//GEN-LAST:event_jBtnRemoverTipoActionPerformed

    private void jBtnCancelarCadTipoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarCadTipoServicoActionPerformed
        
        jBtnCadTipoServico.setVisible(false);
        jBtnCancelarCadTipoServico.setVisible(false);

        jBtbNovoTipoServico.setVisible(true);
        txtTipoServico.setVisible(false);
        jComboBoxTipoServico.setVisible(true);
    }//GEN-LAST:event_jBtnCancelarCadTipoServicoActionPerformed

    private void jBtnCadTipoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadTipoServicoActionPerformed
if (txtTipoServico.getText().equals("")){
    JOptionPane.showMessageDialog(null, "Campo vazio!");
}else{
        TipoServico tServ = new TipoServico();

        tServ.setTipo(txtTipoServico.getText());

        codTipoServico = TipoServicoDAO.CadTipoServico(tServ);

        txtTipoServico.setVisible(false);
        jComboBoxTipoServico.setVisible(true);

        jBtnCadTipoServico.setVisible(false);
        jBtnCancelarCadTipoServico.setVisible(false);
        jBtbNovoTipoServico.setVisible(true);

        jComboBoxTipoServico.removeAllItems();
        
        carregarComboTipoServico();
        
        jComboBoxTipoServico.setSelectedItem(tServ.getTipo());
}
    }//GEN-LAST:event_jBtnCadTipoServicoActionPerformed

    private void jBtbNovoTipoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbNovoTipoServicoActionPerformed

        txtTipoServico.setVisible(true);
        jComboBoxTipoServico.setVisible(false);
        jBtbNovoTipoServico.setVisible(false);
        jBtnCadTipoServico.setVisible(true);
        jBtnCancelarCadTipoServico.setVisible(true);
        jBtbIncluirPeca.setVisible(false);
        txtTipoServico.setEnabled(true);
    }//GEN-LAST:event_jBtbNovoTipoServicoActionPerformed

    private void jBtbIncluirPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbIncluirPecaActionPerformed
if(VerificaCamposPecas() == true){
        TabelaProduto();
}
    }//GEN-LAST:event_jBtbIncluirPecaActionPerformed

    private void jBtnRemoverPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoverPecaActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTablePecas.getModel();
        int linha = jTablePecas.getSelectedRow();

        double totalParcial = Double.parseDouble(jTablePecas.getValueAt(linha, 8).toString());

        totalPeca -= totalParcial;

        txtTotalPecas.setText(String.valueOf(totalPeca));

        if (linha != -1) {
            dtm.removeRow(linha);
        }
    }//GEN-LAST:event_jBtnRemoverPecaActionPerformed

    private void jBtnAvancarPainelPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAvancarPainelPecasActionPerformed
if (jTableTipodeServico.getRowCount() > 0){
        jTabbedPaneServico.setSelectedComponent(this.jPanelPecas);
}      else{
    JOptionPane.showMessageDialog(null, "É necessário inserir um registro na tabela!");
}
    }//GEN-LAST:event_jBtnAvancarPainelPecasActionPerformed

    private void jBtnVoltarPainelServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarPainelServicoActionPerformed
        jTabbedPaneServico.setSelectedComponent(this.jPanelServico);
    }//GEN-LAST:event_jBtnVoltarPainelServicoActionPerformed

    private void jBtnRemoveEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoveEquipamentoActionPerformed

        DefaultTableModel dtm = (DefaultTableModel) jTableEquipamento.getModel();
        int linha = jTableEquipamento.getSelectedRow();

        if (linha != -1) {
            dtm.removeRow(linha);
        }
    }//GEN-LAST:event_jBtnRemoveEquipamentoActionPerformed

    private void jBtbIncluirEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbIncluirEquipamentoActionPerformed
        TabelaEquipamento();
    }//GEN-LAST:event_jBtbIncluirEquipamentoActionPerformed

    private void jComboBoxModeloEquipItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxModeloEquipItemStateChanged

        jComboBoxFabricanteEquip.removeAllItems();
        idModeloEquiComboBox();
        populaComboBoxFabricanteEquip();
        if (jComboBoxModeloEquip.getSelectedItem() != null) {
            modeloEqui = jComboBoxModeloEquip.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboBoxModeloEquipItemStateChanged

    private void jComboBoxFabricanteEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFabricanteEquipActionPerformed

        idFabricanteEquiComboBox();
        if (jComboBoxFabricanteEquip.getSelectedItem() != null) {
            fabricanteEqui = jComboBoxFabricanteEquip.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboBoxFabricanteEquipActionPerformed

    private void jBtnRemoverFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoverFuncActionPerformed

        DefaultTableModel dtm = (DefaultTableModel) jTableFuncionario.getModel();
        int linha = jTableFuncionario.getSelectedRow();

        if (linha != -1) {
            dtm.removeRow(linha);
        }
    }//GEN-LAST:event_jBtnRemoverFuncActionPerformed

    private void jBtbIncluirFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbIncluirFuncActionPerformed
        TabelaFuncionario();
    }//GEN-LAST:event_jBtbIncluirFuncActionPerformed

    private void jBtnCalcularTotalServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCalcularTotalServicoActionPerformed
        double total = totalPeca + Double.parseDouble(txtMaoObra.getText());
        txtTotalGeral.setText(String.valueOf(total));
    }//GEN-LAST:event_jBtnCalcularTotalServicoActionPerformed

    private void jBtnCadastrarServico3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastrarServico3ActionPerformed
if(VerificaCamposValor() == true){
        OrdemServico oS = new OrdemServico();
        DetServicoProduto dtServ = new DetServicoProduto();
        DetServicoEquipamento dtServEqui = new DetServicoEquipamento();
        DetServicoFuncionario dtServFunc = new DetServicoFuncionario();
        DetServicoTipoServ ServTipo = new DetServicoTipoServ();

        double preco = totalPeca + Double.parseDouble(txtMaoObra.getText());

        servico.setCodUsuario(Usuario.idUsuario());
        servico.setCodCliente(codCliente);
        servico.setPreco(preco);
        servico.setDataServico(FuncoesDiversas.FormataData(txtDataCadProduto.getDate()));
        servico.setDescricaoServico(txtDescricao.getText());
        servico.setMaoDeObra(Double.parseDouble(txtMaoObra.getText()));

        oS.setTipo("Manutenção");

        int codOrdemS = OrdemServicoDAO.CadOrdemServico(oS);

        servico.setCodOrdemServico(codOrdemS);

        int codServico = ServicoDAO.CadServico(servico);

        for (int j = 0; j < jTablePecas.getRowCount(); j++) {

            dtServ.setCodServico(codServico);
            dtServ.setCodDetProduto(Integer.parseInt(jTablePecas.getValueAt(j, 0).toString()));
            dtServ.setQuantidade(Integer.parseInt(jTablePecas.getValueAt(j, 6).toString()));
            DetServicoProdutoDAO.CadDetServProduto(dtServ);
        }

        for (int j = 0; j < jTableEquipamento.getRowCount(); j++) {

            dtServEqui.setCodServico(codServico);
            dtServEqui.setCodDetEquipamento(Integer.parseInt(jTableEquipamento.getValueAt(j, 0).toString()));

            DetServicoEquipamentoDAO.CadDetServEquipamento(dtServEqui);
        }

        for (int j = 0; j < jTableFuncionario.getRowCount(); j++) {

            dtServFunc.setCodServico(codServico);
            dtServFunc.setCodFuncionario(Integer.parseInt(jTableFuncionario.getValueAt(j, 0).toString()));

            DetServicoFuncionarioDAO.CadDetServFuncionario(dtServFunc);
        }

        for (int j = 0; j < jTableTipodeServico.getRowCount(); j++) {

            ServTipo.setCodServico(codServico);
            ServTipo.setCodTipo(Integer.parseInt(jTableTipodeServico.getValueAt(j, 0).toString()));

            DetServicoTipoDAO.CadDetServTipoServ(ServTipo);
        }

        JOptionPane.showMessageDialog(null, "Serviço finalizado com sucesso!");
        limparCampos();

}
    }//GEN-LAST:event_jBtnCadastrarServico3ActionPerformed

    private void jComboBoxModeloEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloEquipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxModeloEquipActionPerformed

    private void jBtnAvancarPainelEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAvancarPainelEquipamentoActionPerformed
if (jTablePecas.getRowCount() > 0){
        jTabbedPaneServico.setSelectedComponent(this.jPanelEquipamento);
}else{
    JOptionPane.showMessageDialog(null, "É necessário inserir um registro na tabela!");
}
    }//GEN-LAST:event_jBtnAvancarPainelEquipamentoActionPerformed

    private void jBtnAvancarPainelFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAvancarPainelFuncionarioActionPerformed
        if (jTableEquipamento.getRowCount() > 0){
        jTabbedPaneServico.setSelectedComponent(this.jPanelFuncionario);
        }else{
    JOptionPane.showMessageDialog(null, "É necessário inserir um registro na tabela!");
}
    }//GEN-LAST:event_jBtnAvancarPainelFuncionarioActionPerformed

    private void jBtnVoltarPainelPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarPainelPecasActionPerformed
        jTabbedPaneServico.setSelectedComponent(this.jPanelPecas);
    }//GEN-LAST:event_jBtnVoltarPainelPecasActionPerformed

    private void jBtnVoltarPainelEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarPainelEquipamentoActionPerformed
        jTabbedPaneServico.setSelectedComponent(this.jPanelEquipamento);
    }//GEN-LAST:event_jBtnVoltarPainelEquipamentoActionPerformed

    private void jBtnAvancarPainelValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAvancarPainelValorTotalActionPerformed
if (jTableFuncionario.getRowCount() > 0){
        jTabbedPaneServico.setSelectedComponent(this.jPanelValorTotalServico);
        }else{
    JOptionPane.showMessageDialog(null, "É necessário inserir um registro na tabela!");
}
    }//GEN-LAST:event_jBtnAvancarPainelValorTotalActionPerformed

    private void jBtnVoltarPainelFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarPainelFuncionarioActionPerformed
        jTabbedPaneServico.setSelectedComponent(this.jPanelFuncionario);
    }//GEN-LAST:event_jBtnVoltarPainelFuncionarioActionPerformed

    private void uJComboBoxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJComboBoxClientesActionPerformed
        codCliente = 0;
        idClienteComboBox();

    }//GEN-LAST:event_uJComboBoxClientesActionPerformed

    private void jComboBoxTipoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoServicoActionPerformed
        
    }//GEN-LAST:event_jComboBoxTipoServicoActionPerformed

    private void uJComboBoxPecaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_uJComboBoxPecaItemStateChanged

        jComboBoxModelo.removeAllItems();
        jComboBoxFabricante.removeAllItems();

        codProduto = 0;
        codModelo = 0;
        modelo = null;
        codFabricante = 0;
        fabricante = null;
        valorUnit = 0;
        valor = 0;
        idProdutoComboBox();
        populaComboBoxModelo();

        if (uJComboBoxPeca.getSelectedItem() != null) {
            produto = uJComboBoxPeca.getSelectedItem().toString();
        }

    }//GEN-LAST:event_uJComboBoxPecaItemStateChanged

    private void uJComboBoxPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJComboBoxPecaActionPerformed
        idProdutoComboBox();
        if (uJComboBoxPeca.getSelectedItem() != null) {
            produto = uJComboBoxPeca.getSelectedItem().toString();
        }
    }//GEN-LAST:event_uJComboBoxPecaActionPerformed

    private void jComboBoxFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFabricanteActionPerformed
        idFabricanteComboBox();
        txtValorUnit.setText("");
        if (jComboBoxFabricante.getSelectedItem() != null) {
            fabricante = jComboBoxFabricante.getSelectedItem().toString();
            CarregaValorUnit();
        }
    }//GEN-LAST:event_jComboBoxFabricanteActionPerformed

    private void jComboBoxModeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxModeloItemStateChanged
        jComboBoxFabricante.removeAllItems();
        txtValorUnit.setText("");
        idModeloComboBox();
        populaComboBoxFabricante();
        if (jComboBoxModelo.getSelectedItem() != null) {
            modelo = jComboBoxModelo.getSelectedItem().toString();
            CarregaValorUnit();
        }
    }//GEN-LAST:event_jComboBoxModeloItemStateChanged

    private void uJComboBoxEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJComboBoxEquipamentoActionPerformed
        idEquipamentoComboBox();
        if (uJComboBoxEquipamento.getSelectedItem() != null) {
            equipamento = uJComboBoxEquipamento.getSelectedItem().toString();
        }
    }//GEN-LAST:event_uJComboBoxEquipamentoActionPerformed

    private void uJComboBoxEquipamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_uJComboBoxEquipamentoItemStateChanged

        jComboBoxModeloEquip.removeAllItems();
        jComboBoxFabricanteEquip.removeAllItems();
        codModeloEqui = 0;
        modeloEqui = null;
        codFabricanteEqui = 0;
        fabricanteEqui = null;
        codEquipamento = 0;
        idEquipamentoComboBox();
        populaComboBoxModeloEqui();
        equipamento = uJComboBoxEquipamento.getSelectedItem().toString();
    }//GEN-LAST:event_uJComboBoxEquipamentoItemStateChanged

    private void uJComboBoxFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJComboBoxFuncionarioActionPerformed
        codFuncionario = 0;
        idFuncionarioComboBox();
        if (uJComboBoxFuncionario.getSelectedItem() != null) {
            funcionario = uJComboBoxFuncionario.getSelectedItem().toString();
        }
    }//GEN-LAST:event_uJComboBoxFuncionarioActionPerformed

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeActionPerformed

    private void jComboBoxTipoServicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoServicoItemStateChanged
        codTipoServico = 0;
        idTipoServicoComboBox();
        if (jComboBoxTipoServico.getSelectedItem() != null) {
            tipoServico = jComboBoxTipoServico.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboBoxTipoServicoItemStateChanged

    private void jTabbedPaneServicoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTabbedPaneServicoAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPaneServicoAncestorAdded

    private void limparCampos() {

        txtDataCadProduto.setDate(null);
        txtDescricao.setText("");
        txtMaoObra.setText("");
        txtQuantidade.setText("");
        txtTipoServico.setText("");
        txtTotalGeral.setText("");
        txtTotalPecas.setText("");

        codEquipamento = 0;
        codModeloEqui = 0;
        modeloEqui = null;
        codFabricanteEqui = 0;
        fabricanteEqui = null;

        uJComboBoxClientes.setSelectedIndex(0);
        uJComboBoxEquipamento.setSelectedIndex(0);
        uJComboBoxFuncionario.setSelectedIndex(0);
        uJComboBoxPeca.setSelectedIndex(0);
        jComboBoxTipoServico.setSelectedIndex(0);
        jComboBoxFabricante.removeAllItems();
        jComboBoxModelo.removeAllItems();
        jComboBoxFabricanteEquip.removeAllItems();
        jComboBoxModeloEquip.removeAllItems();

        ((DefaultTableModel) jTableEquipamento.getModel()).setNumRows(0);
        jTableEquipamento.updateUI();
        ((DefaultTableModel) jTableFuncionario.getModel()).setNumRows(0);
        jTableFuncionario.updateUI();
        ((DefaultTableModel) jTablePecas.getModel()).setNumRows(0);
        jTablePecas.updateUI();
        ((DefaultTableModel) jTableTipodeServico.getModel()).setNumRows(0);
        jTableTipodeServico.updateUI();

        jTabbedPaneServico.setSelectedComponent(this.jPanelServico);
    }

    public void TabelaProduto() {

        codDetProduto = ProdutoDAO.codDetProduto();
        int quantidade = Integer.parseInt(txtQuantidade.getText());
        valorUnit = Double.parseDouble(txtValorUnit.getText());
        double total = valorUnit * quantidade;

        try {

            DefaultTableModel dtm = (DefaultTableModel) jTablePecas.getModel();

            dtm.addRow(new Object[]{codDetProduto, codModelo,
                codFabricante, produto,
                modelo, fabricante,
                quantidade,
                valorUnit,
                total});
            totalPeca += total;
            txtTotalPecas.setEditable(false);
            txtTotalPecas.setText(String.valueOf(totalPeca));

            txtQuantidade.setText("");
         //   txtValorUnit.setText("");

        } catch (Exception erro) {
            Logger.getLogger(CadastrarCliente.class
                    .getName()).log(Level.SEVERE, null, erro);
        }
    }

    public void TabelaEquipamento() {

        codDetEquipamento = EquipamentoDAO.CodigoDetEquipamento(codEquipamento, codModeloEqui, codFabricanteEqui);

        try {

            DefaultTableModel dtm = (DefaultTableModel) jTableEquipamento.getModel();

            dtm.addRow(new Object[]{codDetEquipamento,
                codModeloEqui,
                codFabricanteEqui,
                equipamento,
                modeloEqui,
                fabricanteEqui});

        } catch (Exception erro) {
            Logger.getLogger(CadastrarCliente.class
                    .getName()).log(Level.SEVERE, null, erro);
        }
    }

    public void TabelaFuncionario() {

        try {

            DefaultTableModel dtm = (DefaultTableModel) jTableFuncionario.getModel();

            dtm.addRow(new Object[]{codFuncionario, funcionario});

        } catch (Exception erro) {
            Logger.getLogger(CadastrarCliente.class
                    .getName()).log(Level.SEVERE, null, erro);
        }
    }

    public void TabelaTipoServico() {

        try {

            DefaultTableModel dtm = (DefaultTableModel) jTableTipodeServico.getModel();

            dtm.addRow(new Object[]{codTipoServico, tipoServico});

        } catch (Exception erro) {
            Logger.getLogger(CadastrarCliente.class
                    .getName()).log(Level.SEVERE, null, erro);
        }
    }

    public void CarregaValorUnit() {

        valor = ProdutoDAO.ExisteProduto(codProduto, codModelo, codFabricante);

        if (valor != 0) {
            txtValorUnit.setText(String.valueOf(valor));
        }
    }

    private void carregarComboClientes() {

        uJComboBoxClientes.clear();

        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente = ClienteDAO.ComboCliente();

        for (Cliente cli : cliente) {
            uJComboBoxClientes.addItem(cli.getEmpresa(), cli);
        }
    }

    private void carregarComboTipoServico() {

       // jComboBoxTipoServico.clear();

        ArrayList<TipoServico> tipoServico = new ArrayList<TipoServico>();
        tipoServico = TipoServicoDAO.ListarTipoServico();

        jComboBoxTipoServico.addItem("Selecione um tipo");
        for (TipoServico tServ : tipoServico) {
            jComboBoxTipoServico.addItem(tServ.getTipo(), tServ);
        }
    }

    private void carregarComboPeca() {

       // uJComboBoxPeca.clear();
        ArrayList<Produto> pecas = new ArrayList<Produto>();
        pecas = ProdutoDAO.ListarProdutos();

        for (Produto prod : pecas) {
            uJComboBoxPeca.addItem(prod.getProduto(), prod);
        }
    }

    private void carregarComboEquipamento() {

     //   uJComboBoxEquipamento.clear();

        ArrayList<Equipamento> equipamentos = new ArrayList<Equipamento>();
        equipamentos = EquipamentoDAO.ListarEquipamentos();

        for (Equipamento equi : equipamentos) {
            uJComboBoxEquipamento.addItem(equi.getEquipamento(), equi);
        }
    }

    private void carregarComboFuncionario() {

    //    uJComboBoxFuncionario.clear();

        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        funcionarios = FuncionarioDAO.ListarFuncionario();

        for (Funcionario func : funcionarios) {
            uJComboBoxFuncionario.addItem(func.getFuncionario(), func);
        }
    }

    private void idProdutoComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select id_prod from tabproduto inner join tabdetproduto on tabproduto_id_prod = id_prod"
                + " where produto = '" + uJComboBoxPeca.getSelectedItem() + "';";

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

    private void idClienteComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select idcliente from tabcliente where empresa = '" + uJComboBoxClientes.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codCliente = (rs.getInt("idcliente"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idEquipamentoComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabequipamento where equipamento = '" + uJComboBoxEquipamento.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codEquipamento = (rs.getInt("idEquipamento"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idFuncionarioComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfuncionario where funcionario = '" + uJComboBoxFuncionario.getSelectedItem() + "';";

        try {

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codFuncionario = (rs.getInt("idfuncionario"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void populaComboBoxModelo() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select modelo "
                + " from tabdetproduto inner join "
                + " tabproduto inner join "
                + " tabmodelo on tabmodelo_idtabModelo = idtabModelo and "
                + " tabproduto_id_prod = id_prod"
                + " where id_prod = " + codProduto + " group by modelo;";
        System.out.println(codProduto);

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

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
        String sql = "select idtabModelo from tabmodelo where modelo = '" + jComboBoxModelo.getSelectedItem() + "';";

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

    private void idTipoServicoComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select idtabTipo_serv from tabtipo_serv where Tipo_serv = '" + jComboBoxTipoServico.getSelectedObject() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codTipoServico = (rs.getInt("idtabTipo_serv"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void populaComboBoxFabricante() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "SELECT * FROM vw_combofabricanteproduto "
                + " WHERE id_prod = " + codProduto
                + " AND tabmodelo_idtabModelo = " + codModelo + " group by fabricante;";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

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
        String sql = "select idtabFabricante from tabfabricante where fabricante = '" + jComboBoxFabricante.getSelectedItem() + "';";

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

    private void populaComboBoxModeloEqui() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select modelo "
                + " from tabdetequipamento inner join "
                + " tabequipamento inner join "
                + " tabmodelo on tabmodelo_idtabModelo = idtabModelo and "
                + " tabequipamento_idEquipamento = idEquipamento"
                + " where idEquipamento = " + codEquipamento + " group by modelo;";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                jComboBoxModeloEquip.addItem(rs.getString("modelo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idModeloEquiComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabmodelo where modelo = '" + jComboBoxModeloEquip.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codModeloEqui = (rs.getInt("idtabModelo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void populaComboBoxFabricanteEquip() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "SELECT * FROM vw_combofabricanteequipamento "
                + " WHERE idEquipamento = " + codEquipamento
                + " AND tabmodelo_idtabModelo = " + codModeloEqui + " group by fabricante;";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                jComboBoxFabricanteEquip.addItem(rs.getString("fabricante"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idFabricanteEquiComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfabricante where fabricante = '" + jComboBoxFabricanteEquip.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codFabricanteEqui = (rs.getInt("idtabFabricante"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void ocultaColunaTabelas() {
        // tabela produto
        jTablePecas.getColumnModel().getColumn(0).setMaxWidth(0);
        jTablePecas.getColumnModel().getColumn(0).setMinWidth(0);
        jTablePecas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTablePecas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        jTablePecas.getColumnModel().getColumn(1).setMaxWidth(0);
        jTablePecas.getColumnModel().getColumn(1).setMinWidth(0);
        jTablePecas.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        jTablePecas.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);

        jTablePecas.getColumnModel().getColumn(2).setMaxWidth(0);
        jTablePecas.getColumnModel().getColumn(2).setMinWidth(0);
        jTablePecas.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        jTablePecas.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
//        
        //oculta coluna equipamento
        jTableEquipamento.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableEquipamento.getColumnModel().getColumn(0).setMinWidth(0);
        jTableEquipamento.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTableEquipamento.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        jTableEquipamento.getColumnModel().getColumn(1).setMaxWidth(0);
        jTableEquipamento.getColumnModel().getColumn(1).setMinWidth(0);
        jTableEquipamento.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        jTableEquipamento.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);

        jTableEquipamento.getColumnModel().getColumn(2).setMaxWidth(0);
        jTableEquipamento.getColumnModel().getColumn(2).setMinWidth(0);
        jTableEquipamento.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        jTableEquipamento.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);

        //oculta coluna funcionario
        jTableFuncionario.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableFuncionario.getColumnModel().getColumn(0).setMinWidth(0);
        jTableFuncionario.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTableFuncionario.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        //oculta coluna tipoServico
        jTableTipodeServico.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableTipodeServico.getColumnModel().getColumn(0).setMinWidth(0);
        jTableTipodeServico.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTableTipodeServico.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }

    private void Mensangem() {
        JOptionPane.showMessageDialog(null, "Esse registro não encontra-se cadastrado na base de dados.");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbIncluirEquipamento;
    private javax.swing.JButton jBtbIncluirFunc;
    private javax.swing.JButton jBtbIncluirPeca;
    private javax.swing.JButton jBtbNovoTipoServico;
    private javax.swing.JButton jBtnAdicionarTipo;
    private javax.swing.JButton jBtnAvancarPainelEquipamento;
    private javax.swing.JButton jBtnAvancarPainelFuncionario;
    private javax.swing.JButton jBtnAvancarPainelPecas;
    private javax.swing.JButton jBtnAvancarPainelValorTotal;
    private javax.swing.JButton jBtnCadTipoServico;
    private javax.swing.JButton jBtnCadastrarServico3;
    private javax.swing.JButton jBtnCalcularTotalServico;
    private javax.swing.JButton jBtnCancelarCadTipoServico;
    private javax.swing.JButton jBtnRemoveEquipamento;
    private javax.swing.JButton jBtnRemoverFunc;
    private javax.swing.JButton jBtnRemoverPeca;
    private javax.swing.JButton jBtnRemoverTipo;
    private javax.swing.JButton jBtnVoltarPainelEquipamento;
    private javax.swing.JButton jBtnVoltarPainelFuncionario;
    private javax.swing.JButton jBtnVoltarPainelPecas;
    private javax.swing.JButton jBtnVoltarPainelServico;
    private javax.swing.JComboBox jComboBoxFabricante;
    private javax.swing.JComboBox jComboBoxFabricanteEquip;
    private javax.swing.JComboBox jComboBoxModelo;
    private javax.swing.JComboBox jComboBoxModeloEquip;
    private componentes.UJComboBox jComboBoxTipoServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelEquipamento;
    private javax.swing.JPanel jPanelFuncionario;
    private javax.swing.JPanel jPanelPecas;
    private javax.swing.JPanel jPanelServico;
    private javax.swing.JPanel jPanelValorTotalServico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPaneServico;
    private javax.swing.JTable jTableEquipamento;
    private javax.swing.JTable jTableFuncionario;
    private javax.swing.JTable jTablePecas;
    private javax.swing.JTable jTableTipodeServico;
    private com.toedter.calendar.JDateChooser txtDataCadProduto;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtMaoObra;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTipoServico;
    private javax.swing.JTextField txtTotalGeral;
    private javax.swing.JTextField txtTotalPecas;
    private javax.swing.JTextField txtValorUnit;
    private componentes.UJComboBox uJComboBoxClientes;
    private componentes.UJComboBox uJComboBoxEquipamento;
    private componentes.UJComboBox uJComboBoxFuncionario;
    private componentes.UJComboBox uJComboBoxPeca;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
