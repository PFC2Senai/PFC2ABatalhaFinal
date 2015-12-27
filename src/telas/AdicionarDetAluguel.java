package telas;

import funcoes.Conexao;
import funcoes.EquipamentoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josy
 */
public class AdicionarDetAluguel extends javax.swing.JFrame {

    
    private PreparedStatement pst;

    private int codModeloEqui;
    private int codEquipamento;
    private int codDetEquipamento;
    private int codFabricanteEqui;
    private int codCliente;

    private double valor;

    private String modeloEqui;
    private String equipamento;
    private String fabricanteEqui;
    /**
     * Creates new form AdicionarDetAluguel
     */
    public AdicionarDetAluguel() {
        initComponents();
        populaComboBoxEquipamento();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jComboBoxEquipamentos = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jBtnRemoveEquipamento = new javax.swing.JButton();
        jBtbIncluirEquipamento = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEquipamento = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        jComboBoxModeloEquip = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        jComboBoxFabricanteEquip = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtValorLocacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtQuantEqui = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jComboBoxEquipamentos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Equipamento" }));
        jComboBoxEquipamentos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEquipamentosItemStateChanged(evt);
            }
        });
        jComboBoxEquipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEquipamentosActionPerformed(evt);
            }
        });

        jLabel1.setText("Equipamento:");

        jBtnRemoveEquipamento.setText("Remover");
        jBtnRemoveEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoveEquipamentoActionPerformed(evt);
            }
        });

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
                "Codigo", "Id modelo", "Id fabricante", "Equipamento", "Modelo", "Fabricante", "Quantidade", "Vr. Locação", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true, true, true, true
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

        jLabel2.setText("Valor Locação:");

        jLabel3.setText("Quantidade:");

        jLabel4.setText("Vr. Total Locação:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jBtbIncluirEquipamento)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnRemoveEquipamento))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(33, 33, 33)
                        .addComponent(jComboBoxFabricanteEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel37))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxEquipamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxModeloEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtValorLocacao, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(txtQuantEqui)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEquipamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jComboBoxModeloEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jComboBoxFabricanteEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtValorLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantEqui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtbIncluirEquipamento)
                    .addComponent(jBtnRemoveEquipamento))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxEquipamentosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEquipamentosItemStateChanged

        jComboBoxModeloEquip.removeAllItems();
        jComboBoxFabricanteEquip.removeAllItems();
        codModeloEqui = 0;
        modeloEqui = null;
        codFabricanteEqui = 0;
        fabricanteEqui = null;
        idEquipamentoComboBox();
        populaComboBoxModeloEqui();
        equipamento = jComboBoxEquipamentos.getSelectedItem().toString();
    }//GEN-LAST:event_jComboBoxEquipamentosItemStateChanged

    private void jComboBoxEquipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEquipamentosActionPerformed

        idEquipamentoComboBox();
        if (jComboBoxEquipamentos.getSelectedItem() != null) {
            equipamento = jComboBoxEquipamentos.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboBoxEquipamentosActionPerformed

    private void jBtnRemoveEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoveEquipamentoActionPerformed

        DefaultTableModel dtm = (DefaultTableModel) jTableEquipamento.getModel();
        int linha = jTableEquipamento.getSelectedRow();

        double totalParcial = Double.parseDouble(jTableEquipamento.getValueAt(linha, 8).toString());

        valor -= totalParcial;

        txtTotal.setText(String.valueOf(valor));

        if(linha != -1) {
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

    private void jComboBoxModeloEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloEquipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxModeloEquipActionPerformed

    private void jComboBoxFabricanteEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFabricanteEquipActionPerformed
        idFabricanteEquiComboBox();
        if (jComboBoxFabricanteEquip.getSelectedItem() != null) {
            fabricanteEqui = jComboBoxFabricanteEquip.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboBoxFabricanteEquipActionPerformed


    public void TabelaEquipamento() {

        codDetEquipamento = EquipamentoDAO.CodigoDetEquipamento(codEquipamento, codModeloEqui, codFabricanteEqui);
        int quantidade = Integer.parseInt(txtQuantEqui.getText());
        double valorLocacao = Double.parseDouble(txtValorLocacao.getText());
        double total = valorLocacao * quantidade;
        
        try {

            DefaultTableModel dtm = (DefaultTableModel) jTableEquipamento.getModel();

            dtm.addRow(new Object[]{codDetEquipamento,
                codModeloEqui,
                codFabricanteEqui,
                equipamento,
                modeloEqui,
                fabricanteEqui,
                txtQuantEqui.getText(),
                txtValorLocacao.getText(),
                total
            });

            valor += total;
            txtTotal.setText(String.valueOf(valor));
            
            txtQuantEqui.setText("");
            txtValorLocacao.setText("");
            
        } catch (Exception erro) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, erro);
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

    private void populaComboBoxEquipamento() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabequipamento";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                jComboBoxEquipamentos.addItem(rs.getString("equipamento"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idEquipamentoComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabequipamento where equipamento = '" + jComboBoxEquipamentos.getSelectedItem() + "';";

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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbIncluirEquipamento;
    private javax.swing.JButton jBtnRemoveEquipamento;
    private javax.swing.JComboBox jComboBoxEquipamentos;
    private javax.swing.JComboBox jComboBoxFabricanteEquip;
    private javax.swing.JComboBox jComboBoxModeloEquip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEquipamento;
    private javax.swing.JTextField txtQuantEqui;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValorLocacao;
    // End of variables declaration//GEN-END:variables
}
