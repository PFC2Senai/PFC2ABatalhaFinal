/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import atributos.Produto;
import atributos.Vendas;
import funcoes.Conexao;
import funcoes.LimitarDigitos;
import funcoes.ProdutoDAO;
import funcoes.TabelaZebrada;
import funcoes.VendasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author VINICIOS
 */
public class AdicionaDetVendaProduto extends javax.swing.JFrame {

    private PreparedStatement pst;
    Statement stmt;
    private int codModelo;
    private int codProduto;
    private int codDetProduto;
    private int codFabricante;
    private double valorUnit;
    private double valor;
    private double totalPeca = 0;

    private String produto;
    private String modelo;
    private String fabricante;

    private int idVenda;
    private ExibeDetVenda telaExibeDetVenda;

    /**
     * Creates new form AlteraServicoProduto
     */
    public AdicionaDetVendaProduto() {
        initComponents();
        txtQuantidade.setDocument(new LimitarDigitos(5));
    }

    public AdicionaDetVendaProduto(int idVenda, ExibeDetVenda exibeVenda) {
        this.idVenda = idVenda;
        this.telaExibeDetVenda = exibeVenda;
        initComponents();
        txtQuantidade.setDocument(new LimitarDigitos(5));
        carregarComboPeca();
        ocultaTabela();
    }


    public void TabelaProduto() {

        codDetProduto = ProdutoDAO.codDetProduto();
        int quantidade = Integer.parseInt(txtQuantidade.getText());
        valorUnit = Double.parseDouble(txtValorUnit.getText());
        double total = valorUnit * quantidade;
        try {

            DefaultTableModel dtm = (DefaultTableModel) jTablePecas.getModel();

            TableCellRenderer renderer = new TabelaZebrada();
            jTablePecas.setDefaultRenderer(Object.class, renderer);

            dtm.addRow(new Object[]{codDetProduto, codModelo,
                codFabricante, produto,
                modelo, fabricante,
                valorUnit,
                quantidade,
                total});

            totalPeca += total;
            txtTotalPecas.setEditable(false);
            txtTotalPecas.setText(String.valueOf(totalPeca));

            txtQuantidade.setText("");

        } catch (Exception erro) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    public void CarregaValorUnit() {

        valor = ProdutoDAO.ExisteProduto(codProduto, codModelo, codFabricante);

        if (valor != 0) {
            txtValorUnit.setText(String.valueOf(valor));
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

    private void carregarComboPeca() {

        // uJComboBoxPeca.clear();
        ArrayList<Produto> pecas = new ArrayList<Produto>();
        pecas = ProdutoDAO.ListarProdutos();

        for (Produto prod : pecas) {
            uJComboBoxPeca.addItem(prod.getProduto(), prod);
        }
    }

//    private void populaComboBoxProduto() {
//        
//       Connection conexao = Conexao.getConnection();
//        ResultSet rs;
//        String sql = "select * from tabproduto;";
//        
//        try{
//            pst = conexao.prepareStatement(sql);
//            rs = pst.executeQuery();
//            
//            while(rs.next()) {
//                uJComboBoxPeca.addItem(rs.getString("produto"));
//            }
//            
//        }catch(SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//    }
    private void idProdutoComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabproduto inner join tabdetproduto on tabproduto_id_prod = id_prod"
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

    private void ocultaTabela() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jComboBoxModelo = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jComboBoxFabricante = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtValorUnit = new javax.swing.JTextField();
        jBtbIncluirPeca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePecas = new javax.swing.JTable();
        jBtnRemoverPeca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTotalPecas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBtnInserirPeca = new javax.swing.JButton();
        uJComboBoxPeca = new componentes.UJComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADICIONAR PEÇA");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setText("Modelo:");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        jComboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Modelo" }));
        jComboBoxModelo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxModeloItemStateChanged(evt);
            }
        });
        jComboBoxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeloActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 310, -1));

        jLabel33.setText("Peça:");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel36.setText("Fab.:");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jComboBoxFabricante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Fabricante" }));
        jComboBoxFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFabricanteActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 280, -1));

        jLabel34.setText("Quant.:");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));
        jPanel1.add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 100, -1));

        jLabel39.setText("Valor Unit.");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 50, 20));
        jPanel1.add(txtValorUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 120, -1));

        jBtbIncluirPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jBtbIncluirPeca.setText("Incluir Peça");
        jBtbIncluirPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbIncluirPecaActionPerformed(evt);
            }
        });
        jPanel1.add(jBtbIncluirPeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 110, -1));

        jTablePecas.setBackground(new java.awt.Color(254, 254, 233));
        jTablePecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Peca", "CódigoModelo", "cod fabricante", "Peça", "Modelo", "Fabricante", "Valor Unit.", "Quantidade", "Total"
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 780, 130));

        jBtnRemoverPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jBtnRemoverPeca.setText("Remover");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTablePecas, org.jdesktop.beansbinding.ELProperty.create("${selectedElement  != null}"), jBtnRemoverPeca, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnRemoverPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverPecaActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnRemoverPeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, 100, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/money.png"))); // NOI18N
        jLabel2.setText("Valor total de peças:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));
        jPanel1.add(txtTotalPecas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 172, -1));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        jLabel1.setText("VENDA DE PEÇAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jBtnInserirPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        jBtnInserirPeca.setText("Salvar");
        jBtnInserirPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInserirPecaActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnInserirPeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 450, -1, 30));

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
        jPanel1.add(uJComboBoxPeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 280, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 850, 120));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxModeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxModeloItemStateChanged

        jComboBoxFabricante.removeAllItems();
        idModeloComboBox();
        populaComboBoxFabricante();
        txtValorUnit.setText("");
        if (jComboBoxModelo.getSelectedItem() != null) {
            modelo = jComboBoxModelo.getSelectedItem().toString();
            CarregaValorUnit();
        }
    }//GEN-LAST:event_jComboBoxModeloItemStateChanged

    private void jComboBoxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloActionPerformed

    }//GEN-LAST:event_jComboBoxModeloActionPerformed

    private void jComboBoxFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFabricanteActionPerformed
        idFabricanteComboBox();
        if (jComboBoxFabricante.getSelectedItem() != null) {
            fabricante = jComboBoxFabricante.getSelectedItem().toString();
            CarregaValorUnit();
        }
    }//GEN-LAST:event_jComboBoxFabricanteActionPerformed

    private void jBtbIncluirPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbIncluirPecaActionPerformed
        TabelaProduto();
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

    private void jBtnInserirPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInserirPecaActionPerformed

        Vendas v = new Vendas();

        for (int j = 0; j < jTablePecas.getRowCount(); j++) {

            v.setIdtabVendas(idVenda);
            v.setIdProduto(Integer.parseInt(jTablePecas.getValueAt(j, 0).toString()));
            v.setQuantidade(Integer.parseInt(jTablePecas.getValueAt(j, 7).toString()));
            VendasDAO.CadDetVenda(v);
            //VendasDAO.CadVenda(v);
        }

        double totalGeral = telaExibeDetVenda.Total();
        double resultado = totalGeral + totalPeca;
        VendasDAO.UpdateTotalVenda(idVenda, resultado);
        
        telaExibeDetVenda.TabelaVendas();
        telaExibeDetVenda.CarregaVenda();
        this.dispose();
    }//GEN-LAST:event_jBtnInserirPecaActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        verificaPagina();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void verificaPagina() {

        if ((this.telaExibeDetVenda != null)) {
            this.telaExibeDetVenda.setVisible(true);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbIncluirPeca;
    private javax.swing.JButton jBtnInserirPeca;
    private javax.swing.JButton jBtnRemoverPeca;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxFabricante;
    private javax.swing.JComboBox jComboBoxModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePecas;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTotalPecas;
    private javax.swing.JTextField txtValorUnit;
    private componentes.UJComboBox uJComboBoxPeca;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
