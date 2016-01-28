/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import atributos.DetServicoProduto;
import atributos.DetServicoTipoServ;
import atributos.OrdemServico;
import atributos.Produto;
import atributos.Vendas;
import funcoes.Conexao;
import static funcoes.Conexao.getConnection;
import funcoes.DetServicoProdutoDAO;
import funcoes.FuncoesDiversas;
import static funcoes.FuncoesDiversas.FormataData;
import funcoes.ModeloTabela;
import funcoes.OrdemServicoDAO;
import funcoes.ProdutoDAO;
import funcoes.ServicoDAO;
import funcoes.VendasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WilhamJr
 */
public class CadastrarVenda extends javax.swing.JFrame {

    private PreparedStatement pst;
    private int codOrdemServ;
    private int codProduto;
    private int codModelo;
    private int codDetProduto;
    private int codFabricante;

    private String produto;
    private String fabricante;
    private String modelo;
    Statement stmt;

    private double totalPeca = 0;
    private double valor;
    private double valorUnit;

    /**
     * Creates new form CadastrarVenda
     */
    public CadastrarVenda() {
        initComponents();
        //TabelaVendas("select * from tabvendas;");
        populaComboBoxProdutos();
        jTextTotal.setEditable(false);
    }

    private void limparCampos() {
        jTextCodCli.setText("");
        jTextCodUser.setText("");
        jTextHora.setText("");
        JDataVenda.setDate(null);
        jComboBoxProdutos.setSelectedItem("Selecione");
        jComboFabricante.setSelectedItem("Selecione");
        jComboModelo.setSelectedItem("Selecione");
        jTextValorUnit.setText("");
        jTextTotal.setText("");
        jTextQuantidadeProduto.setText("");
        ((DefaultTableModel) jTableProduto.getModel()).setNumRows(0);
        jTableProduto.updateUI();
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

    public void CarregaValorUnit() {

        valor = ProdutoDAO.ExisteProduto(codProduto, codModelo, codFabricante);

        if (valor != 0) {
            jTextValorUnit.setText(String.valueOf(valor));
        }
    }

    public void TabelaProduto() {

        //CarregaValorUnit();  
        codDetProduto = ProdutoDAO.codDetProduto();
        int quantidade = Integer.parseInt(jTextQuantidadeProduto.getText());
        valorUnit = Double.parseDouble(jTextValorUnit.getText());
        double total = valorUnit * quantidade;

        try {

            DefaultTableModel dtm = (DefaultTableModel) jTableProduto.getModel();

            dtm.addRow(new Object[]{codDetProduto, produto, modelo, fabricante, quantidade,
                valorUnit,
                total});

            totalPeca += total;
            jTextTotal.setEditable(false);
            jTextTotal.setText(String.valueOf(totalPeca));

            jTextQuantidadeProduto.setText("");

        } catch (Exception erro) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, erro);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextCodCli = new javax.swing.JTextField();
        jTextCodUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JDataVenda = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jTextHora = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBoxProdutos = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboModelo = new javax.swing.JComboBox();
        jComboFabricante = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jTextQuantidadeProduto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextTotal = new javax.swing.JTextField();
        jTextValorUnit = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastrar Venda");

        jLabel2.setText("Cód Cliente");

        jLabel3.setText("Cod Usuario");

        jTextCodCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCodCliActionPerformed(evt);
            }
        });

        jLabel4.setText("Produto:");

        jLabel5.setText("Data da Venda:");

        jLabel6.setText("Hora:");

        try {
            jTextHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Limpar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Cadastrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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

        jTableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Modelo", "Fabricante", "Quatidade", "Valor Unit", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTableProduto);

        jButton2.setText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("Remover");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setText("Modelo:");

        jLabel8.setText("Fabricante:");

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

        jLabel10.setText("Quantidade:");

        jLabel11.setText("Total:");

        jTextValorUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextValorUnitKeyTyped(evt);
            }
        });

        jLabel12.setText("Valor Unitário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(60, 60, 60)
                .addComponent(jButton1)
                .addGap(73, 73, 73))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addGap(96, 96, 96)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jTextCodUser, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addGap(53, 53, 53)
                        .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7)
                        .addGap(57, 57, 57)
                        .addComponent(jComboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8)
                        .addGap(40, 40, 40)
                        .addComponent(jComboFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(JDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(114, 114, 114)
                                        .addComponent(jLabel6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(25, 25, 25)
                                        .addComponent(jTextValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextHora, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jTextQuantidadeProduto))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCodUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(jComboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(jComboFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addComponent(JDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(jTextHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel12))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jTextQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCodCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCodCliActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        OrdemServico oS = new OrdemServico();
     //  Produto p = new Produto();

        oS.setTipo("Vendas");
        int codOrdemS = OrdemServicoDAO.CadOrdemServico(oS);

     //  p.setIdProduto(codProduto);
        // int codProd = ProdutoDAO.CadDetProduto(p);
        Vendas vendas = new Vendas();
        Vendas v = new Vendas();

        vendas.setClienteIdcliente(Integer.parseInt(jTextCodCli.getText()));
        vendas.setTabusuarioIdUsuario(Integer.parseInt(jTextCodUser.getText()));
        vendas.setIdOrdemServico(codOrdemS);
        vendas.setDataVenda(FormataData(JDataVenda.getDate()));
        vendas.setHora(FuncoesDiversas.ConverterHora(jTextHora.getText()));
        //vendas.setProduto((String) jComboBoxProdutos.getSelectedItem());
        vendas.setTotal(Double.parseDouble(jTextTotal.getText()));

        int codVenda = VendasDAO.CadVenda(vendas);

        for (int j = 0; j < jTableProduto.getRowCount(); j++) {

            v.setIdtabVendas(codVenda);
            v.setQuantidade(Double.parseDouble(jTableProduto.getValueAt(j, 4).toString()));
            v.setIdProduto(Integer.parseInt(jTableProduto.getValueAt(j, 0).toString()));

        //dtServ.setCodDetProduto(Integer.parseInt(jTableProduto.getValueAt(j,0).toString()));
            //dtServ.setQuantidade(Integer.parseInt(jTableProduto.getValueAt(j, 4).toString()));
            VendasDAO.CadDetVenda(v);

        }
        limparCampos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBoxProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProdutosActionPerformed
        idProdutoComboBox();
        if (jComboBoxProdutos.getSelectedItem() != null) {
            produto = jComboBoxProdutos.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboBoxProdutosActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTableProduto.getModel();
        int linha = jTableProduto.getSelectedRow();

        double totalParcial = Double.parseDouble(jTableProduto.getValueAt(linha, 6).toString());

        totalPeca -= totalParcial;

        jTextTotal.setText(String.valueOf(totalPeca));

        if (linha != -1) {
            dtm.removeRow(linha);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TabelaProduto();

        CarregaValorUnit();

//        jTextValorUnit.setText(String.valueOf(total));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboModeloActionPerformed
        idModeloComboBox();
        if (jComboModelo.getSelectedItem() != null) {
            modelo = jComboModelo.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboModeloActionPerformed

    private void jComboFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboFabricanteActionPerformed
        idFabricanteComboBox();
        jTextValorUnit.setText("");
        if (jComboFabricante.getSelectedItem() != null) {
            fabricante = jComboFabricante.getSelectedItem().toString();

            CarregaValorUnit();
        }
    }//GEN-LAST:event_jComboFabricanteActionPerformed

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

    private void jComboModeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboModeloItemStateChanged
        jComboFabricante.removeAllItems();
        idModeloComboBox();
        populaComboBoxFabricante();
        if (jComboModelo.getSelectedItem() != null) {
            modelo = jComboModelo.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboModeloItemStateChanged

    private void jTextValorUnitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextValorUnitKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextValorUnitKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDataVenda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduto;
    private javax.swing.JTextField jTextCodCli;
    private javax.swing.JTextField jTextCodUser;
    private javax.swing.JFormattedTextField jTextHora;
    private javax.swing.JTextField jTextQuantidadeProduto;
    private javax.swing.JTextField jTextTotal;
    private javax.swing.JTextField jTextValorUnit;
    // End of variables declaration//GEN-END:variables
}
