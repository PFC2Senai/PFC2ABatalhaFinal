package telas;


import atributos.Setor;
import funcoes.SetorDAO;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class ExibeSetor extends javax.swing.JFrame {

    Statement stmt ;
    private static int indice;
    /**
     * Creates new form ExibeSetor
     */
    public ExibeSetor() {
        initComponents();
        jBtnNovoSetor.setVisible(false);
        TabelaSetor();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @return 
     */
    
    public static int GetIndiceSetor() {         
        return indice;
    }
    
     
    public void TabelaSetor() {
        
        ((DefaultTableModel) jTableListarSetores.getModel()).setNumRows(0);
        jTableListarSetores.updateUI();
        ArrayList<Setor> setores = new ArrayList<Setor>();
        setores = SetorDAO.ListarSetor();
        
        try { 
            
            DefaultTableModel dtm = (DefaultTableModel) jTableListarSetores.getModel();
                   
            for(Setor setor : setores){
                dtm.addRow(new Object[] {String.valueOf(setor.getIdSetor()),setor.getSetor()});
            }
                             
        } catch (Exception erro){
            Logger.getLogger(ExibeSetor.class.getName()).log(Level.SEVERE, null, erro);
        }          
    }    
           
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListarSetores = new javax.swing.JTable();
        jBtnEditar = new javax.swing.JButton();
        jBtnNovo = new javax.swing.JButton();
        jBtnNovoSetor = new javax.swing.JButton();
        txtSetor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jBtnExcluirSetor = new javax.swing.JButton();
        jBtnSair = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableListarSetores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Setor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableListarSetores.getTableHeader().setReorderingAllowed(false);
        jTableListarSetores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListarSetoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListarSetores);
        if (jTableListarSetores.getColumnModel().getColumnCount() > 0) {
            jTableListarSetores.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTableListarSetores.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        jBtnEditar.setText("Alterar");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnNovo.setText("Novo");
        jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoActionPerformed(evt);
            }
        });

        jBtnNovoSetor.setText("Cadastrar");
        jBtnNovoSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoSetorActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarSetores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), txtSetor, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel3.setText("Setor:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Setores");

        jBtnExcluirSetor.setText("Excluir");
        jBtnExcluirSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirSetorActionPerformed(evt);
            }
        });

        jBtnSair.setText("Sair");
        jBtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSairActionPerformed(evt);
            }
        });

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnSair)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jBtnNovo)
                                    .addGap(18, 18, 18)
                                    .addComponent(jBtnNovoSetor)
                                    .addGap(18, 18, 18)
                                    .addComponent(jBtnCancelar)
                                    .addGap(27, 27, 27)
                                    .addComponent(jBtnEditar))
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnExcluirSetor))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtSetor))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNovo)
                    .addComponent(jBtnEditar)
                    .addComponent(jBtnNovoSetor)
                    .addComponent(jBtnExcluirSetor)
                    .addComponent(jBtnCancelar))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnSair)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSairActionPerformed

    private void jBtnNovoSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoSetorActionPerformed
        
        Setor setor = new Setor();
        setor.setSetor(txtSetor.getText());
        SetorDAO.CadSetor(setor);
        limparCampos();
        TabelaSetor();
        jBtnNovoSetor.setVisible(false);
        jBtnNovo.setVisible(true);
    }//GEN-LAST:event_jBtnNovoSetorActionPerformed

    private void jBtnExcluirSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirSetorActionPerformed

        SetorDAO.ExcluirSetor(indice);  
        TabelaSetor();
        limparCampos();
    }//GEN-LAST:event_jBtnExcluirSetorActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        
        Setor setor = new Setor();        
        setor.setSetor(txtSetor.getText());
        SetorDAO.UpdateSetor(setor, indice);
        TabelaSetor();
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jTableListarSetoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListarSetoresMouseClicked

        int linha = jTableListarSetores.getSelectedRow();
        txtSetor.setText(jTableListarSetores.getValueAt(linha, 1).toString());        
        indice = Integer.parseInt(jTableListarSetores.getValueAt(linha, 0).toString());
    }//GEN-LAST:event_jTableListarSetoresMouseClicked

    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
        txtSetor.setText("");
        jBtnNovoSetor.setVisible(true);
        jBtnNovo.setVisible(false);
    }//GEN-LAST:event_jBtnNovoActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnCancelarActionPerformed
   
    private void limparCampos() {       
        txtSetor.setText("");
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluirSetor;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JButton jBtnNovoSetor;
    private javax.swing.JButton jBtnSair;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListarSetores;
    private javax.swing.JTextField txtSetor;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
