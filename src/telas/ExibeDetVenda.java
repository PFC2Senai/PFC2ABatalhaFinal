/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import atributos.Cliente;
import atributos.Vendas;
import funcoes.AuditoriaDAO;
import funcoes.ClienteDAO;
import funcoes.Conexao;
import static funcoes.Conexao.getConnection;
import funcoes.ModeloTabela;
import funcoes.ProdutoDAO;
import funcoes.TabelaZebrada;
import funcoes.VendasDAO;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import static telas.ExibeVenda.GetIndice;

/**
 *
 * @author WilhamJr
 */
public class ExibeDetVenda extends javax.swing.JFrame {

    private PreparedStatement pst;
    Statement stmt;
    int idContato;
    int idDetVenda;
    Vendas vendas = new Vendas();
    private final int codVenda;
    private static int indice;
    private ExibeDetVenda telaDetalVenda;
    private ExibeVenda telaExibeVenda;

    private int codOrdemServ;
    private int codProduto;
    private int codModelo;
    private int codDetProduto;
    private int codFabricante;
    private int codCliente;
   // private int idVenda;

    private String produto;
    private String fabricante;
    private String modelo;
    private String cliente;
    private double total;

    private double totalPeca = 0;
    private double valor;
    private double valorUnit;
    
    private int codDetVendaProduto;

    /**
     * Creates new form ExibeDetVenda
     */
    public ExibeDetVenda() {
        initComponents();
        //this.idContato = VendasDAO.idDetVenda(GetIndice());
        this.codVenda = GetIndice();
        telaDetalVenda = this;
        TabelaVendas();
        CarregaVenda();
        desabilitarCampos();
        carregarComboClientes();
        combobox();
        idClienteComboBox();
    }
    
    public ExibeDetVenda(ExibeVenda exibeVenda) {
        telaExibeVenda = exibeVenda;
        initComponents();
        //this.idContato = VendasDAO.idDetVenda(GetIndice());
        this.codVenda = GetIndice();
        telaDetalVenda = this;
        TabelaVendas();
        CarregaVenda();
        desabilitarCampos();
        carregarComboClientes();
        combobox();
        idClienteComboBox();
    }
    
    private void combobox() {

        //Combobox clientes
        uJComboBoxCliente.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codCliente == 0) {
                    Mensangem();
                    uJComboBoxCliente.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        uJComboBoxCliente.setAutocompletar(true);
    }

    private void Mensangem() {
        JOptionPane.showMessageDialog(null, "Esse registro não encontra-se cadastrado na base de dados.");
    }
    
    private void carregarComboClientes() {

        uJComboBoxCliente.clear();

        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente = ClienteDAO.ComboCliente();

        for (Cliente cli : cliente) {
            uJComboBoxCliente.addItem(cli.getEmpresa(), cli);
        }
    }

    
   public void CarregaVenda() {
        
        OcultaBotoes();
        desabilitarVendas();
        
        ArrayList<Vendas> venda = new ArrayList<Vendas>();
        venda = VendasDAO.CarregaVendas(codVenda);
        
        for (Vendas v : venda) {
            jTextCodVenda.setText(String.valueOf(v.getIdtabVendas()));
            jTextCodUsuario.setText(String.valueOf(v.getTabusuarioIdUsuario()));
            jTextCodCliente.setText(String.valueOf(v.getClienteIdcliente()));
            jTextDataVenda.setText(String.valueOf(v.getDataVenda()));
            jTextHoraVenda.setText(String.valueOf(v.getHora()));
            jTextTotalVenda.setText(String.valueOf(v.getTotal()));
            //idContato = cli.getIdContato();
        }
    }
    
    
    
    private void OcultaBotoes() {

        jBtbCancelDadosP.setVisible(false);
        jBtnAltDadosP.setVisible(false);
    }
    
    
    public void TabelaVendas() {

        try {
            String Sql = "select * from vw_venda where idtabVendas = " + codVenda + ";";

            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();
            String[] Colunas = {"Produto",  "Modelo", "Fabricante", "Quantidade" ,"Preço Unitário"};

            ResultSet rs;
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                dados.add(new Object[]{ 
                    rs.getObject("produto"),
                    rs.getObject("modelo"),
                    rs.getObject("fabricante"),                    
                    rs.getObject("quant"), 
                    rs.getObject("precoSaida")});
            }

            for (int i = 0; i < 5; i++) {
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarVendas.setModel(modelo);
                
                TableCellRenderer renderer = new TabelaZebrada();
                jTableListarVendas.setDefaultRenderer(Object.class, renderer);
                
                jTableListarVendas.getColumnModel().getColumn(0).setPreferredWidth(100);
                jTableListarVendas.getColumnModel().getColumn(1).setPreferredWidth(200);
                jTableListarVendas.getColumnModel().getColumn(2).setPreferredWidth(200);
                jTableListarVendas.getColumnModel().getColumn(3).setPreferredWidth(100);
                jTableListarVendas.getColumnModel().getColumn(4).setPreferredWidth(100);
                jTableListarVendas.getColumnModel().getColumn(i).setResizable(false);
                jTableListarVendas.getTableHeader().setReorderingAllowed(false);
                jTableListarVendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExibeVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    private void desabilitarCampos() {
        //desabilita campos dados pessoais
        jTextCodVenda.setEditable(false);
        jTextCodUsuario.setEditable(false);
        jTextCodCliente.setEditable(false);
        jTextDataVenda.setEditable(false);
        jTextHoraVenda.setEditable(false);
        jTextTotalVenda.setEditable(false);
        // customiza o textfild
        jTextCodVenda.setOpaque(false);
        jTextCodVenda.setBackground(new Color(0, 0, 0, 0));
        jTextCodVenda.setBorder(null);
        jTextCodUsuario.setOpaque(false);
        jTextCodUsuario.setBackground(new Color(0, 0, 0, 0));
        jTextCodUsuario.setBorder(null);
        jTextCodCliente.setOpaque(false);
        jTextCodCliente.setBackground(new Color(0, 0, 0, 0));
        jTextCodCliente.setBorder(null);
        jTextDataVenda.setOpaque(false);
        jTextDataVenda.setBackground(new Color(0, 0, 0, 0));
        jTextDataVenda.setBorder(null);
        jTextHoraVenda.setOpaque(false);
        jTextHoraVenda.setBackground(new Color(0, 0, 0, 0));
        jTextHoraVenda.setBorder(null);
        jTextTotalVenda.setOpaque(false);
        jTextTotalVenda.setBackground(new Color(0, 0, 0, 0));
        jTextTotalVenda.setBorder(null);
    }   
    
    private void EditarVendas() {
        // customiza o textfild
        jTextCodCliente.setOpaque(true);
        jTextCodCliente.setBackground(new Color(255, 255, 255));
        jTextCodCliente.setBorder(new LineBorder(Color.BLACK));
        //jTextCodServ.setOpaque(true);
        //jTextCodServ.setBackground(new Color(255, 255, 255));
        //jTextCodServ.setBorder(new LineBorder(Color.BLACK));   
        jTextDataVenda.setOpaque(true);
        jTextDataVenda.setBackground(new Color(255, 255, 255));
        jTextDataVenda.setBorder(new LineBorder(Color.BLACK));  
        jTextHoraVenda.setOpaque(true);
        jTextHoraVenda.setBackground(new Color(255, 255, 255));
        jTextHoraVenda.setBorder(new LineBorder(Color.BLACK));
        jTextTotalVenda.setOpaque(true);
        jTextTotalVenda.setBackground(new Color(255, 255, 255));
        jTextTotalVenda.setBorder(new LineBorder(Color.BLACK));  
    }
    
    private void desabilitarVendas() {
        //desabilita campos dados pessoais
        jTextCodCliente.setEditable(false);
        jTextCodUsuario.setEditable(false);
        jTextCodVenda.setEditable(false);
        jTextDataVenda.setEditable(false);
        jTextHoraVenda.setEditable(false);
        jTextTotalVenda.setEditable(false);
        // customiza o textfild
        jTextCodCliente.setOpaque(false);
        jTextCodCliente.setBackground(new Color(0, 0, 0, 0));
        jTextCodCliente.setBorder(null);
        jTextCodUsuario.setOpaque(false);
        jTextCodUsuario.setBackground(new Color(0, 0, 0, 0));
        jTextCodUsuario.setBorder(null);
        jTextCodVenda.setOpaque(false);
        jTextCodVenda.setBackground(new Color(0, 0, 0, 0));
        jTextCodVenda.setBorder(null);
        jTextDataVenda.setOpaque(false);
        jTextDataVenda.setBackground(new Color(0, 0, 0, 0));
        jTextDataVenda.setBorder(null);
        jTextHoraVenda.setOpaque(false);
        jTextHoraVenda.setBackground(new Color(0, 0, 0, 0));
        jTextHoraVenda.setBorder(null);
        jTextTotalVenda.setOpaque(false);
        jTextTotalVenda.setBackground(new Color(0, 0, 0, 0));
        jTextTotalVenda.setBorder(null);
        //oculta botoes  
        jBtbCancelDadosP.setVisible(false);
        jBtnAltDadosP.setVisible(false);
     //   jBtbIncluirPeca.setVisible(false);
        uJComboBoxCliente.setEnabled(false);
    }
        
    private int idServico;
    private int idCliente;
    
    
    
    private void idClienteComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select idcliente from tabcliente where empresa = '" + uJComboBoxCliente.getSelectedItem() + "';";

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
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListarVendas = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextCodVenda = new javax.swing.JTextField();
        jTextCodUsuario = new javax.swing.JTextField();
        jTextCodCliente = new javax.swing.JTextField();
        jTextCodServ = new javax.swing.JTextField();
        jTextDataVenda = new javax.swing.JTextField();
        jTextHoraVenda = new javax.swing.JTextField();
        jTextTotalVenda = new javax.swing.JTextField();
        uJComboBoxCliente = new componentes.UJComboBox();
        jButtonAr1 = new javax.swing.JButton();
        jBtbCancelDadosP = new javax.swing.JButton();
        jBtnAltDadosP = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonAddnovoProd = new javax.swing.JButton();
        jBtnRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(223, 237, 253));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Detalhe de Vendas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jTableListarVendas.setBackground(new java.awt.Color(223, 237, 253));
        jTableListarVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableListarVendas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jTableListarVendas);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 690, 220));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 140));

        jPanel2.setBackground(new java.awt.Color(223, 237, 253));

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18))); // NOI18N
        jPanel1.setName(""); // NOI18N

        jLabel5.setText("Data da Venda:");

        jLabel2.setText("Código da Venda:");

        jLabel3.setText("Código do Cliente:");

        jLabel6.setText("Hora da Venda:");

        jLabel4.setText("Código do Usuário:");

        jLabel7.setText("Código do Serviço:");

        jLabel8.setText("Total da Venda:");

        uJComboBoxCliente.setEditable(true);
        uJComboBoxCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                uJComboBoxClienteItemStateChanged(evt);
            }
        });
        uJComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uJComboBoxClienteActionPerformed(evt);
            }
        });

        jButtonAr1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jButtonAr1.setText("Editar");
        jButtonAr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr1ActionPerformed(evt);
            }
        });

        jBtbCancelDadosP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtbCancelDadosP.setText("Cancelar");
        jBtbCancelDadosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelDadosPActionPerformed(evt);
            }
        });

        jBtnAltDadosP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jBtnAltDadosP.setText("Salvar");
        jBtnAltDadosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltDadosPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68))
                            .addComponent(jTextTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextCodVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(uJComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 47, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextHoraVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCodServ, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAr1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBtbCancelDadosP, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jBtnAltDadosP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextCodVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(uJComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextCodServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAr1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jTextDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextHoraVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtbCancelDadosP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAltDadosP)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonAddnovoProd.setText("Adicionar Peças");
        jButtonAddnovoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddnovoProdActionPerformed(evt);
            }
        });

        jBtnRemover.setText("Remover Peças");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarVendas, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnRemover, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnRemover)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonAddnovoProd))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButtonAddnovoProd)
                .addGap(18, 18, 18)
                .addComponent(jBtnRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 700));

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        this.dispose();
        verificaPagina();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonAr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAr1ActionPerformed
        EditarVendas();
 //       jTextCodServ.setEditable(true);
        jTextCodCliente.setEditable(true);
        jTextDataVenda.setEditable(true);
        jTextHoraVenda.setEditable(true);
        jTextTotalVenda.setEditable(true);
        jTextCodUsuario.setVisible(true);        
        jTextCodVenda.setVisible(true);

        jButtonAr1.setVisible(false);
        jBtbCancelDadosP.setVisible(true);
        jBtnAltDadosP.setVisible(true);
       // jBtbIncluirPeca.setVisible(true);
        uJComboBoxCliente.setEnabled(true);
    }//GEN-LAST:event_jButtonAr1ActionPerformed

    private void jBtbCancelDadosPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbCancelDadosPActionPerformed

        desabilitarVendas();
        jTextCodCliente.setVisible(true);
        jBtnAltDadosP.setVisible(false);
        jBtbCancelDadosP.setVisible(false);
        jButtonAr1.setVisible(true);
        JOptionPane.showMessageDialog(null, "Canselado com sucesso!");

    }//GEN-LAST:event_jBtbCancelDadosPActionPerformed

    private void jBtnAltDadosPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltDadosPActionPerformed

        Vendas v = new Vendas();
        v.setClienteIdcliente(Integer.parseInt(jTextCodCliente.getText()));
        //v.setIdOrdemServico(Integer.parseInt(jTextCodServ.getText()));
        v.setDataVenda(Date.valueOf(jTextDataVenda.getText()));
        v.setHora(Time.valueOf(jTextHoraVenda.getText()));
        v.setTotal(Double.parseDouble(jTextTotalVenda.getText()));
        VendasDAO.UpdateVenda(v, GetIndice());        
        desabilitarVendas();
        //txtSetor.setVisible(true);
        jBtnAltDadosP.setVisible(false);
        jBtbCancelDadosP.setVisible(false);
        jButtonAr1.setVisible(true);
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        CarregaVenda();

        String descricaoAudit = "Venda: " + v.getIdtabVendas() + "teve os dados alterados.";
        AuditoriaDAO.CadDetAuditoria(descricaoAudit);
    }//GEN-LAST:event_jBtnAltDadosPActionPerformed

    private void jButtonAddnovoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddnovoProdActionPerformed
        this.setEnabled(false);
        new AdicionaDetVendaProduto(codVenda, this).setVisible(true);
        total = Double.parseDouble(jTextTotalVenda.getText());
    }//GEN-LAST:event_jButtonAddnovoProdActionPerformed

    private void uJComboBoxClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_uJComboBoxClienteItemStateChanged

    }//GEN-LAST:event_uJComboBoxClienteItemStateChanged

    private void uJComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJComboBoxClienteActionPerformed
        codCliente = 0;
        idClienteComboBox();
    }//GEN-LAST:event_uJComboBoxClienteActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void jBtnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoverActionPerformed
        int linha = jTableListarVendas.getSelectedRow();

        codDetVendaProduto = (Integer.parseInt(jTableListarVendas.getValueAt(linha, 0).toString()));

        int quant = Integer.parseInt(jTableListarVendas.getValueAt(linha, 1).toString());
        double precoUnit = Double.parseDouble(jTableListarVendas.getValueAt(linha, 2).toString());
        double totalPeca = quant * precoUnit;

        double totalGeral = Double.parseDouble(jTextTotalVenda.getText());
        double resultado = totalGeral - totalPeca;
        
        VendasDAO.UpdateTotalVenda(codVenda, resultado);
        VendasDAO.ExcluirDetVendaProduto(codVenda);
        //  txtTotal.setText(String.valueOf(resultado));
        CarregaVenda();
        TabelaVendas();
    }//GEN-LAST:event_jBtnRemoverActionPerformed

    public double Total() {
        return total;
    }
    
    private void verificaPagina() {

        if ((this.telaExibeVenda != null)) {
            this.telaExibeVenda.setVisible(true);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbCancelDadosP;
    private javax.swing.JButton jBtnAltDadosP;
    private javax.swing.JButton jBtnRemover;
    private javax.swing.JButton jButtonAddnovoProd;
    private javax.swing.JButton jButtonAr1;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListarVendas;
    private javax.swing.JTextField jTextCodCliente;
    private javax.swing.JTextField jTextCodServ;
    private javax.swing.JTextField jTextCodUsuario;
    private javax.swing.JTextField jTextCodVenda;
    private javax.swing.JTextField jTextDataVenda;
    private javax.swing.JTextField jTextHoraVenda;
    private javax.swing.JTextField jTextTotalVenda;
    private componentes.UJComboBox uJComboBoxCliente;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
