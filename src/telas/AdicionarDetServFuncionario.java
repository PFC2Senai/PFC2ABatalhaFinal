package telas;

import atributos.DetServicoFuncionario;
import funcoes.Conexao;
import funcoes.DetServicoFuncionarioDAO;
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
public class AdicionarDetServFuncionario extends javax.swing.JFrame {

    private PreparedStatement pst;
    
    private int idServico;
    private DetalharServico telaDatalharServico;
    private int codFuncionario;
    private String funcionario;
    
    /**
     * Creates new form AdicionarDetServFuncionario
     */
    
    public AdicionarDetServFuncionario() {       
        initComponents();
    }
    
    public AdicionarDetServFuncionario(int idServ, DetalharServico telaDetalharServ) {        
        this.idServico = idServ;
        this.telaDatalharServico = telaDetalharServ;
        initComponents();
        populaComboBoxFuncionario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableFuncionario = new javax.swing.JTable();
        jComboBoxFuncionarios = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jBtnRemoverFunc = new javax.swing.JButton();
        jBtbIncluirFunc = new javax.swing.JButton();
        jBtnSalvarDetServFuncionario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 514, 190));

        jComboBoxFuncionarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Funcionário" }));
        jComboBoxFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFuncionariosActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBoxFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 274, -1));

        jLabel7.setText("Funcionário:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jBtnRemoverFunc.setText("Remover");
        jBtnRemoverFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverFuncActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnRemoverFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        jBtbIncluirFunc.setText("Incluir Funcionário");
        jBtbIncluirFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbIncluirFuncActionPerformed(evt);
            }
        });
        jPanel5.add(jBtbIncluirFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jBtnSalvarDetServFuncionario.setText("Salvar");
        jBtnSalvarDetServFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarDetServFuncionarioActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnSalvarDetServFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img2.png"))); // NOI18N
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 670, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFuncionariosActionPerformed

        idFuncionarioComboBox();
        if (jComboBoxFuncionarios.getSelectedItem() != null) {
            funcionario = jComboBoxFuncionarios.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboBoxFuncionariosActionPerformed

    private void jBtnRemoverFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoverFuncActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTableFuncionario.getModel();
        int linha = jTableFuncionario.getSelectedRow();

        if(linha != -1) {
            dtm.removeRow(linha);
        }
    }//GEN-LAST:event_jBtnRemoverFuncActionPerformed

    private void jBtbIncluirFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbIncluirFuncActionPerformed
        TabelaFuncionario();
    }//GEN-LAST:event_jBtbIncluirFuncActionPerformed

    private void jBtnSalvarDetServFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarDetServFuncionarioActionPerformed

        DetServicoFuncionario dtServFunc = new DetServicoFuncionario();

        for(int j=0; j < jTableFuncionario.getRowCount(); j++) {

            dtServFunc.setCodServico(idServico);
            dtServFunc.setCodFuncionario(Integer.parseInt(jTableFuncionario.getValueAt(j, 0).toString()));

            DetServicoFuncionarioDAO.CadDetServFuncionario(dtServFunc);
        }

        telaDatalharServico.TabelaFuncionario();
    }//GEN-LAST:event_jBtnSalvarDetServFuncionarioActionPerformed

    public void TabelaFuncionario() {
        
        try { 
            
            DefaultTableModel dtm = (DefaultTableModel) jTableFuncionario.getModel();
                   
                dtm.addRow(new Object[] {codFuncionario, funcionario});
                
        } catch (Exception erro) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, erro);
        }          
    }
    
    private void populaComboBoxFuncionario() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfuncionario";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                jComboBoxFuncionarios.addItem(rs.getString("funcionario"));
            }
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void idFuncionarioComboBox() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfuncionario where funcionario = '" + jComboBoxFuncionarios.getSelectedItem()+ "';";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                codFuncionario = (rs.getInt("idfuncionario"));
            }
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbIncluirFunc;
    private javax.swing.JButton jBtnRemoverFunc;
    private javax.swing.JButton jBtnSalvarDetServFuncionario;
    private javax.swing.JComboBox jComboBoxFuncionarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableFuncionario;
    // End of variables declaration//GEN-END:variables
}
