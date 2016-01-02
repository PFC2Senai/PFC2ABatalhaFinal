package telas;

import atributos.Equipamento;
import static atributos.Usuario.idUsuario;
import funcoes.Conexao;
import funcoes.EquipamentoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Josy
 */
public class CadastrarEquipamento extends javax.swing.JFrame {

    Equipamento equi = new Equipamento();
    private PreparedStatement pst;
    private int codEquipamento;
    private int codFornecedor;
    private int codFabricante;
    private int codModelo;
    
    /**
     * Creates new form CadastrarEquipamento
     */
    public CadastrarEquipamento() {
        initComponents();
        populaComboBoxFornecedor();
        populaComboBoxFabricante();
        populaComboBoxModelo();
        populaComboBoxEquipamento();
        txtEquipamento.setVisible(false);
        jBtnCadEquipamento.setVisible(false);
        jBtnCancelarCadEquipamento.setVisible(false);
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
        txtEquipamento = new javax.swing.JTextField();
        jComboBoxEquipamento = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jBtnCadEquipamento = new javax.swing.JButton();
        jBtbNovoEquipamento = new javax.swing.JButton();
        jBtnCancelarCadEquipamento = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxFornecedor = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxFabricante = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxModelo = new javax.swing.JComboBox();
        jBtnSair = new javax.swing.JButton();
        jBtnCadastrarEquipamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cadastrar Equipamento");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 21, -1, 23));

        jLabel2.setText("Equipamento:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 72, -1, -1));
        getContentPane().add(txtEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 69, 240, -1));

        jComboBoxEquipamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o produto" }));
        jComboBoxEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEquipamentoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 260, -1));

        jBtnCadEquipamento.setText("Salvar");
        jBtnCadEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadEquipamentoActionPerformed(evt);
            }
        });

        jBtbNovoEquipamento.setText("Novo");
        jBtbNovoEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbNovoEquipamentoActionPerformed(evt);
            }
        });

        jBtnCancelarCadEquipamento.setText("Cancelar");
        jBtnCancelarCadEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarCadEquipamentoActionPerformed(evt);
            }
        });

        jLabel8.setText("Fornecedor:");

        jComboBoxFornecedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o fornecedor" }));
        jComboBoxFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFornecedorActionPerformed(evt);
            }
        });

        jLabel9.setText("Fabricante:");

        jComboBoxFabricante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o fabricante" }));
        jComboBoxFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFabricanteActionPerformed(evt);
            }
        });

        jLabel10.setText("Modelo:");

        jComboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o modelo" }));
        jComboBoxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeloActionPerformed(evt);
            }
        });

        jBtnSair.setText("Sair");
        jBtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSairActionPerformed(evt);
            }
        });

        jBtnCadastrarEquipamento.setText("Cadastrar");
        jBtnCadastrarEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarEquipamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8)
                        .addGap(11, 11, 11)
                        .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel9)
                        .addGap(15, 15, 15)
                        .addComponent(jComboBoxFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10)
                        .addGap(32, 32, 32)
                        .addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jBtnSair)
                        .addGap(419, 419, 419)
                        .addComponent(jBtnCadastrarEquipamento))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(jBtbNovoEquipamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnCadEquipamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCancelarCadEquipamento)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtbNovoEquipamento)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnCadEquipamento)
                        .addComponent(jBtnCancelarCadEquipamento)))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9))
                    .addComponent(jComboBoxFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jBtnSair))
                    .addComponent(jBtnCadastrarEquipamento)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSairActionPerformed

    private void jComboBoxEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEquipamentoActionPerformed
        idEquipamentoComboBox();
    }//GEN-LAST:event_jComboBoxEquipamentoActionPerformed

    private void jBtnCadEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadEquipamentoActionPerformed

        equi.setTabusuarioIdUsuario(idUsuario());
        equi.setEquipamento(txtEquipamento.getText());
        codEquipamento = EquipamentoDAO.CadEquipamento(equi);
        jBtnCadEquipamento.setVisible(false);
        jBtnCancelarCadEquipamento.setVisible(false);
        jBtbNovoEquipamento.setVisible(true);
        txtEquipamento.setVisible(false);
        jComboBoxEquipamento.setVisible(true);
        populaComboBoxEquipamento();
        jComboBoxEquipamento.setSelectedItem(txtEquipamento.getText());        
    }//GEN-LAST:event_jBtnCadEquipamentoActionPerformed

    private void jBtbNovoEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbNovoEquipamentoActionPerformed

        txtEquipamento.setVisible(true);
        jComboBoxEquipamento.setVisible(false);
        jBtnCadEquipamento.setVisible(true);
        jBtnCancelarCadEquipamento.setVisible(true);
        jBtbNovoEquipamento.setVisible(false);
        txtEquipamento.setEnabled(true);
    }//GEN-LAST:event_jBtbNovoEquipamentoActionPerformed

    private void jComboBoxFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFornecedorActionPerformed
        idFornecedorComboBox();
    }//GEN-LAST:event_jComboBoxFornecedorActionPerformed

    private void jBtnCancelarCadEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarCadEquipamentoActionPerformed
        jBtnCadEquipamento.setVisible(false);
        jBtnCancelarCadEquipamento.setVisible(false);
        jBtbNovoEquipamento.setVisible(true);
        txtEquipamento.setVisible(false);
        jComboBoxEquipamento.setVisible(true);
    }//GEN-LAST:event_jBtnCancelarCadEquipamentoActionPerformed

    private void jComboBoxFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFabricanteActionPerformed
        idFabricanteComboBox();
    }//GEN-LAST:event_jComboBoxFabricanteActionPerformed

    private void jComboBoxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloActionPerformed
        idModeloComboBox();
    }//GEN-LAST:event_jComboBoxModeloActionPerformed

    private void jBtnCadastrarEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastrarEquipamentoActionPerformed

        equi.setTabusuarioIdUsuario(idUsuario());
        equi.setCodFornecedor(codFornecedor);
        equi.setCodModelo(codModelo);
        equi.setCodFabricante(codFabricante);                
        
        equi.setCodEquipamento(codEquipamento);

        EquipamentoDAO.CadDetEquipamento(equi);

        txtEquipamento.setVisible(false);
        jComboBoxEquipamento.setVisible(true);

        limparCampos();
        jComboBoxEquipamento.removeAllItems();
        populaComboBoxEquipamento();
        jBtbNovoEquipamento.setVisible(true);
        
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
    }//GEN-LAST:event_jBtnCadastrarEquipamentoActionPerformed

    private void limparCampos() {
        jComboBoxFabricante.setSelectedIndex(0);
        jComboBoxFornecedor.setSelectedIndex(0);
        jComboBoxModelo.setSelectedIndex(0);
    }
    
    private void populaComboBoxEquipamento() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabequipamento;";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                jComboBoxEquipamento.addItem(rs.getString("equipamento"));
            }
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void idEquipamentoComboBox() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabequipamento where equipamento = '" + jComboBoxEquipamento.getSelectedItem()+ "';";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                codEquipamento = (rs.getInt("idEquipamento"));
            }
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void populaComboBoxFornecedor() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfornecedor";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                jComboBoxFornecedor.addItem(rs.getString("fornecedor"));
            }
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void idFornecedorComboBox() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfornecedor where fornecedor = '" + jComboBoxFornecedor.getSelectedItem()+ "';";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                codFornecedor = (rs.getInt("id_forn"));
            }
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
   
    private void populaComboBoxFabricante() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfabricante";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                jComboBoxFabricante.addItem(rs.getString("fabricante"));
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void idFabricanteComboBox() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfabricante where fabricante = '" + jComboBoxFabricante.getSelectedItem()+ "';";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                codFabricante = (rs.getInt("idtabFabricante"));
            }
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void populaComboBoxModelo() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabmodelo";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                jComboBoxModelo.addItem(rs.getString("modelo"));
            }
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void idModeloComboBox() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabmodelo where modelo = '" + jComboBoxModelo.getSelectedItem()+ "';";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                codModelo = (rs.getInt("idtabModelo"));
            }
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbNovoEquipamento;
    private javax.swing.JButton jBtnCadEquipamento;
    private javax.swing.JButton jBtnCadastrarEquipamento;
    private javax.swing.JButton jBtnCancelarCadEquipamento;
    private javax.swing.JButton jBtnSair;
    private javax.swing.JComboBox jComboBoxEquipamento;
    private javax.swing.JComboBox jComboBoxFabricante;
    private javax.swing.JComboBox jComboBoxFornecedor;
    private javax.swing.JComboBox jComboBoxModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEquipamento;
    // End of variables declaration//GEN-END:variables
}
