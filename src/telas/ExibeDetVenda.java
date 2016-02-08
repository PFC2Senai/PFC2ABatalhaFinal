/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import atributos.Vendas;
import funcoes.AuditoriaDAO;
import funcoes.Conexao;
import static funcoes.Conexao.getConnection;
import funcoes.ModeloTabela;
import funcoes.ProdutoDAO;
import funcoes.VendasDAO;
import java.awt.Color;
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

    private int codOrdemServ;
    private int codProduto;
    private int codModelo;
    private int codDetProduto;
    private int codFabricante;
    private int codCliente;

    private String produto;
    private String fabricante;
    private String modelo;
    private String cliente;

    private double totalPeca = 0;
    private double valor;
    private double valorUnit;

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
        populaComboBoxProdutos();
        desabilitarCampos();
    }

    
    private void CarregaVenda() {
        
        OcultaBotoes();
        desabilitarVendas();
        
        ArrayList<Vendas> venda = new ArrayList<Vendas>();
        venda = VendasDAO.CarregaVendas(codVenda);
        
        for (Vendas v : venda) {
            jTextCodVenda.setText(String.valueOf(v.getIdtabVendas()));
            jTextCodUsuario.setText(String.valueOf(v.getTabusuarioIdUsuario()));
            jTextCodCliente.setText(String.valueOf(v.getClienteIdcliente()));
            jTextCodServ.setText(String.valueOf(v.getIdOrdemServico()));
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
            String[] Colunas = {"Código do Detalhe da Venda", "Quantidade", "Código do Detalhe do Produto",
            "Código do Produto", "Produto", "Modelo", "Fabricante"};

            ResultSet rs;
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                dados.add(new Object[]{ 
                    rs.getObject("idtabVendas"), 
                    rs.getObject("quant"), 
                    rs.getObject("tabdetproduto_idDetProduto"),
                    rs.getObject("id_prod"),
                    rs.getObject("produto"),
                    rs.getObject("modelo"),
                    rs.getObject("fabricante")});
            }

            for (int i = 0; i < 7; i++) {
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarVendas.setModel(modelo);
                jTableListarVendas.getColumnModel().getColumn(0).setPreferredWidth(200);
                jTableListarVendas.getColumnModel().getColumn(1).setPreferredWidth(200);
                jTableListarVendas.getColumnModel().getColumn(2).setPreferredWidth(200);
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
        jTextCodServ.setEditable(false);
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
        jTextCodServ.setOpaque(false);
        jTextCodServ.setBackground(new Color(0, 0, 0, 0));
        jTextCodServ.setBorder(null);
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
        jTextCodServ.setEditable(false);
        jTextCodUsuario.setEditable(false);
        jTextCodVenda.setEditable(false);
        jTextDataVenda.setEditable(false);
        jTextHoraVenda.setEditable(false);
        jTextTotalVenda.setEditable(false);
        // customiza o textfild
        jTextCodCliente.setOpaque(false);
        jTextCodCliente.setBackground(new Color(0, 0, 0, 0));
        jTextCodCliente.setBorder(null);
        jTextCodServ.setOpaque(false);
        jTextCodServ.setBackground(new Color(0, 0, 0, 0));
        jTextCodServ.setBorder(null);
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
        jBtbIncluirPeca.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jComboBoxProdutos.setVisible(false);
        jComboModelo.setVisible(false);
        jComboFabricante.setVisible(false);
    }
    
    
    private void populaComboBoxProdutos() {
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabproduto";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                jComboBoxProdutos.addItem(rs.getString("produto"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idProdutoComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabproduto inner join tabdetproduto on tabproduto_id_prod = id_prod"
                + " where produto = '" + jComboBoxProdutos.getSelectedItem() + "';";

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
                jComboModelo.addItem(rs.getString("modelo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idModeloComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabmodelo where modelo = '" + jComboModelo.getSelectedItem() + "';";

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
                jComboFabricante.addItem(rs.getString("fabricante"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idFabricanteComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfabricante where fabricante = '" + jComboFabricante.getSelectedItem() + "';";

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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAr1 = new javax.swing.JButton();
        jBtbIncluirPeca = new javax.swing.JButton();
        jBtnAltDadosP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jBtnEditarVenda = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListarVendas = new javax.swing.JTable();
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
        jLabel12 = new javax.swing.JLabel();
        jComboBoxProdutos = new javax.swing.JComboBox();
        jComboModelo = new javax.swing.JComboBox();
        jComboFabricante = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jBtbCancelDadosP = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAr1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jButtonAr1.setText("Editar");
        jButtonAr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, -1));

        jBtbIncluirPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jBtbIncluirPeca.setText("Incluir Peça");
        getContentPane().add(jBtbIncluirPeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 110, -1));

        jBtnAltDadosP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jBtnAltDadosP.setText("Salvar");
        jBtnAltDadosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltDadosPActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAltDadosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 94, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Detalhe de Vendas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jButton3.setText("Novo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 620, -1, -1));

        jBtnEditarVenda.setText("Editar");
        jBtnEditarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarVendaActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnEditarVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 620, -1, -1));

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 620, -1, -1));

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 820, 200));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18))); // NOI18N
        jPanel1.setName(""); // NOI18N

        jLabel5.setText("Data da Venda:");

        jLabel2.setText("Código da Venda:");

        jLabel3.setText("Código do Cliente:");

        jLabel6.setText("Hora da Venda:");

        jLabel4.setText("Código do Usuário:");

        jLabel7.setText("Código do Serviço:");

        jLabel8.setText("Total da Venda:");

        jLabel12.setText("Fabricante:");

        jComboBoxProdutos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboBoxProdutos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxProdutosItemStateChanged(evt);
            }
        });
        jComboBoxProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProdutosActionPerformed(evt);
            }
        });

        jComboModelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboModelo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboModeloItemStateChanged(evt);
            }
        });
        jComboModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboModeloActionPerformed(evt);
            }
        });

        jComboFabricante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboFabricanteActionPerformed(evt);
            }
        });

        jLabel11.setText("Modelo:");

        jLabel10.setText("Produto:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTextDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(jTextCodServ, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextCodVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextHoraVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jTextTotalVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                        .addGap(189, 189, 189))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(48, 48, 48)
                                .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(52, 52, 52)
                                .addComponent(jComboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(45, 45, 45)
                                .addComponent(jComboFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jTextCodVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTextCodServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel11))
                            .addComponent(jComboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel12))
                            .addComponent(jComboFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jTextDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextHoraVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 820, 180));

        jBtbCancelDadosP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtbCancelDadosP.setText("Cancelar");
        jBtbCancelDadosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelDadosPActionPerformed(evt);
            }
        });
        getContentPane().add(jBtbCancelDadosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new CadastrarVenda().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBtnEditarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarVendaActionPerformed
        if (jTableListarVendas.getSelectedRow() != -1) {
            this.dispose();
            int linha = jTableListarVendas.getSelectedRow();
            indice = (Integer.parseInt(jTableListarVendas.getValueAt(linha, 0).toString()));
            new AlterarUsuario().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro.");
        }
    }//GEN-LAST:event_jBtnEditarVendaActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        this.dispose();
        new ExibeVenda().setVisible(true);
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
        jBtbIncluirPeca.setVisible(true);
        jLabel10.setVisible(true);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
        jComboBoxProdutos.setVisible(true);
        jComboModelo.setVisible(true);
        jComboFabricante.setVisible(true);
    }//GEN-LAST:event_jButtonAr1ActionPerformed

    private void jBtbCancelDadosPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbCancelDadosPActionPerformed

        desabilitarVendas();
        jTextCodCliente.setVisible(true);
        jBtnAltDadosP.setVisible(false);
        jBtbCancelDadosP.setVisible(false);
        jButtonAr1.setVisible(true);

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
        CarregaVenda();

        String descricaoAudit = "Venda: " + v.getIdtabVendas() + "teve os dados alterados.";
        AuditoriaDAO.CadDetAuditoria(descricaoAudit);
    }//GEN-LAST:event_jBtnAltDadosPActionPerformed

    private void jComboBoxProdutosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxProdutosItemStateChanged
        jComboModelo.removeAllItems();
        jComboFabricante.removeAllItems();
        codProduto = 0;
        codModelo = 0;
        modelo = null;
        codFabricante = 0;
        fabricante = null;
        valorUnit = 0;
        valor = 0;
        idProdutoComboBox();
        populaComboBoxModelo();
        produto = jComboBoxProdutos.getSelectedItem().toString();
    }//GEN-LAST:event_jComboBoxProdutosItemStateChanged

    private void jComboBoxProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProdutosActionPerformed
        idProdutoComboBox();
        if (jComboBoxProdutos.getSelectedItem() != null) {
            produto = jComboBoxProdutos.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboBoxProdutosActionPerformed

    private void jComboModeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboModeloItemStateChanged
        jComboFabricante.removeAllItems();
        idModeloComboBox();
        populaComboBoxFabricante();
        if (jComboModelo.getSelectedItem() != null) {
            modelo = jComboModelo.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboModeloItemStateChanged

    private void jComboModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboModeloActionPerformed
        idModeloComboBox();
        if (jComboModelo.getSelectedItem() != null) {
            modelo = jComboModelo.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboModeloActionPerformed

    private void jComboFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboFabricanteActionPerformed
        idFabricanteComboBox();
        //jTextValorUnit.setText("");
        if (jComboFabricante.getSelectedItem() != null) {
            fabricante = jComboFabricante.getSelectedItem().toString();

//            CarregaValorUnit();
        }
    }//GEN-LAST:event_jComboFabricanteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbCancelDadosP;
    private javax.swing.JButton jBtbIncluirPeca;
    private javax.swing.JButton jBtnAltDadosP;
    private javax.swing.JButton jBtnEditarVenda;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAr1;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox jComboBoxProdutos;
    private javax.swing.JComboBox jComboFabricante;
    private javax.swing.JComboBox jComboModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListarVendas;
    private javax.swing.JTextField jTextCodCliente;
    private javax.swing.JTextField jTextCodServ;
    private javax.swing.JTextField jTextCodUsuario;
    private javax.swing.JTextField jTextCodVenda;
    private javax.swing.JTextField jTextDataVenda;
    private javax.swing.JTextField jTextHoraVenda;
    private javax.swing.JTextField jTextTotalVenda;
    // End of variables declaration//GEN-END:variables
}
