package telas;


import atributos.Fabricante;
import static funcoes.Conexao.getConnection;
import funcoes.FabricanteDAO;
import funcoes.ModeloTabela;
import funcoes.TabelaZebrada;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author graciele
 */
public class ExibeFabricante extends javax.swing.JFrame {
    
    Statement stmt ;
    Fabricante fab = new Fabricante();
    private static int indice;
    private Menu telaMenu;

    /**
     * Creates new form ExibeFabricante
     */
    public ExibeFabricante() {
        initComponents();
        TabelaFabricante("select * from tabfabricante;");
        ocultaCampos();
    }
    
    public ExibeFabricante(Menu menu) {
        this.telaMenu = menu;
        initComponents();
        TabelaFabricante("select * from tabfabricante;");
        ocultaCampos();
    }
    
    public static int GetIndice() {         
        return indice;
    }
    
    private void ocultaCampos() {
        jBtnCadastrarFabricante.setVisible(false);
        jBtnAlterarFabricante.setVisible(false);
        jBtnCancelarCadFabricante.setVisible(false);
        jBtnCancelarAlterarFabricante.setVisible(false);
        txtFabricante.setEnabled(false);
    }
    
    public void TabelaFabricante(String Sql) {
        
        try {
            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();               
            String [] Colunas = {"Código do Fabricante","Fabricante"};
               
            ResultSet rs;
            rs = stmt.executeQuery(Sql);            
          //  rs.first();
            
            while(rs.next()){
               dados.add(new Object[]{rs.getObject("idtabFabricante"),rs.getObject("fabricante")});            
            }
                        
            for (int i = 0; i < 2; i++) {
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarFabricantes.setModel(modelo);
                
                TableCellRenderer renderer = new TabelaZebrada();
                jTableListarFabricantes.setDefaultRenderer(Object.class, renderer);
            
                jTableListarFabricantes.getColumnModel().getColumn(0).setMaxWidth(0);
                jTableListarFabricantes.getColumnModel().getColumn(0).setMinWidth(0);
                jTableListarFabricantes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                jTableListarFabricantes.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
                
                jTableListarFabricantes.getColumnModel().getColumn(1).setPreferredWidth(200);
                
                jTableListarFabricantes.getColumnModel().getColumn(i).setResizable(false);
                jTableListarFabricantes.getTableHeader().setReorderingAllowed(false);
                jTableListarFabricantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExibeFabricante.class.getName()).log(Level.SEVERE, null, ex);
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
        jTableListarFabricantes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jBtnNovoFabricante = new javax.swing.JButton();
        jBtnEditarFabricante = new javax.swing.JButton();
        jBtnCadastrarFabricante = new javax.swing.JButton();
        jBtnCancelarCadFabricante = new javax.swing.JButton();
        txtFabricante = new javax.swing.JTextField();
        jBtnCancelarAlterarFabricante = new javax.swing.JButton();
        jBtnAlterarFabricante = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Raavi", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fabricante.png"))); // NOI18N
        jLabel1.setText("Fabricantes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 30));

        jTableListarFabricantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableListarFabricantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListarFabricantesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableListarFabricantes);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 610, 270));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.gif"))); // NOI18N
        jLabel2.setText("Pesquisar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 280, 20));

        jPanel2.setBackground(new java.awt.Color(223, 237, 253));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Fabiricante:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, 20));

        jBtnNovoFabricante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnNovoFabricante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fabricaAdiciona.fw.png"))); // NOI18N
        jBtnNovoFabricante.setText("Novo");
        jBtnNovoFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoFabricanteActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnNovoFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jBtnEditarFabricante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnEditarFabricante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fabricaEdita.fw.png"))); // NOI18N
        jBtnEditarFabricante.setText("Editar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarFabricantes, org.jdesktop.beansbinding.ELProperty.create("${selectedElement  !=null}"), jBtnEditarFabricante, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnEditarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarFabricanteActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnEditarFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, -1, -1));

        jBtnCadastrarFabricante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jBtnCadastrarFabricante.setText("Salvar");
        jBtnCadastrarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarFabricanteActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnCadastrarFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, -1, -1));

        jBtnCancelarCadFabricante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelarCadFabricante.setText("Cancelar");
        jBtnCancelarCadFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarCadFabricanteActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnCancelarCadFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, -1, -1));
        jPanel2.add(txtFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 300, -1));

        jBtnCancelarAlterarFabricante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelarAlterarFabricante.setText("Cancelar");
        jBtnCancelarAlterarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarAlterarFabricanteActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnCancelarAlterarFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, -1, -1));

        jBtnAlterarFabricante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jBtnAlterarFabricante.setText("Salvar");
        jBtnAlterarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarFabricanteActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnAlterarFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, -1, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        jButton8.setText("Voltar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img2.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 110));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 620));

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
        verificaPagina();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        TabelaFabricante("select  * from tabfabricante where fabricante "
            + "like '%" + txtBuscar.getText().trim() + "%';");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jBtnNovoFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoFabricanteActionPerformed
        jTableListarFabricantes.getSelectionModel().clearSelection();
        txtFabricante.setText("");
        txtFabricante.setEnabled(true);
        jBtnCadastrarFabricante.setVisible(true);
        jBtnCancelarCadFabricante.setVisible(true);
        jBtnNovoFabricante.setVisible(false);
        
        jBtnEditarFabricante.setEnabled(false);
        jTableListarFabricantes.setEnabled(false);
    }//GEN-LAST:event_jBtnNovoFabricanteActionPerformed

    private void jBtnCancelarCadFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarCadFabricanteActionPerformed

        txtFabricante.setBackground(Color.white);
        txtFabricante.setText("");
        txtFabricante.setEnabled(false);
        limparCampos();
        jBtnCancelarCadFabricante.setVisible(false);
        jBtnCadastrarFabricante.setVisible(false);
        jBtnNovoFabricante.setVisible(true);
       // jBtnEditarFabricante.setEnabled(true);
        jTableListarFabricantes.setEnabled(true);
          if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja canselar? Os dados não serão salvos.", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
           
          
        
          }
    }//GEN-LAST:event_jBtnCancelarCadFabricanteActionPerformed

    private void jBtnCadastrarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastrarFabricanteActionPerformed

        if (txtFabricante.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o FABRICANTE!");
            txtFabricante.requestFocus();
            txtFabricante.setBackground(Color.yellow);
        }
        else
        
        if (FabricanteDAO.VerificarFabricante(txtFabricante.getText()) == false) {

            Fabricante fab = new Fabricante();
            fab.setFabricante(txtFabricante.getText());

            FabricanteDAO.CadFabricante(fab);
            limparCampos();

            TabelaFabricante("select * from tabfabricante;");
            jBtnCadastrarFabricante.setVisible(false);
            jBtnCancelarCadFabricante.setVisible(false);
            jBtnNovoFabricante.setVisible(true);
           // jBtnEditarFabricante.setEnabled(true);
            jTableListarFabricantes.setEnabled(true);
            txtFabricante.setText("");
            txtFabricante.setEnabled(false);
             JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Fabricante ja cadastrado");
        }
    }//GEN-LAST:event_jBtnCadastrarFabricanteActionPerformed

    private void jBtnAlterarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarFabricanteActionPerformed
        Fabricante fab = new Fabricante();
        fab.setFabricante(txtFabricante.getText());
        FabricanteDAO.UpdateFabricante(fab, GetIndice());
        jBtnAlterarFabricante.setVisible(false);
        jBtnCancelarAlterarFabricante.setVisible(false);
        jBtnEditarFabricante.setVisible(true);
        jBtnNovoFabricante.setEnabled(true);
        txtFabricante.setText("");
        txtFabricante.setEnabled(false);
        TabelaFabricante("select * from tabfabricante;");
    }//GEN-LAST:event_jBtnAlterarFabricanteActionPerformed

    private void jBtnCancelarAlterarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarAlterarFabricanteActionPerformed
        txtFabricante.setText("");
        txtFabricante.setEnabled(false);
        jTableListarFabricantes.getSelectionModel().clearSelection();
        limparCampos();
        jBtnAlterarFabricante.setVisible(false);
        jBtnCancelarAlterarFabricante.setVisible(false);
        jBtnEditarFabricante.setVisible(true);
        jBtnNovoFabricante.setEnabled(true);        
    }//GEN-LAST:event_jBtnCancelarAlterarFabricanteActionPerformed

    private void jTableListarFabricantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListarFabricantesMouseClicked
        int linha = jTableListarFabricantes.getSelectedRow();
        if (linha != -1) {    
            txtFabricante.setText(jTableListarFabricantes.getValueAt(linha, 1).toString());        
            indice = Integer.parseInt(jTableListarFabricantes.getValueAt(linha, 0).toString());
        }
    }//GEN-LAST:event_jTableListarFabricantesMouseClicked

    private void jBtnEditarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarFabricanteActionPerformed
        txtFabricante.setEnabled(true);
        jBtnEditarFabricante.setVisible(false);
        jBtnCancelarAlterarFabricante.setVisible(true);
        jBtnAlterarFabricante.setVisible(true);
        jBtnNovoFabricante.setEnabled(false);
       
    }//GEN-LAST:event_jBtnEditarFabricanteActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void limparCampos() {
        txtFabricante.setText("");
    }
    
    
    private void verificaPagina() {

        if ((this.telaMenu != null)) {
            this.telaMenu.setVisible(true);
            // this.telaMenu.toFront();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterarFabricante;
    private javax.swing.JButton jBtnCadastrarFabricante;
    private javax.swing.JButton jBtnCancelarAlterarFabricante;
    private javax.swing.JButton jBtnCancelarCadFabricante;
    private javax.swing.JButton jBtnEditarFabricante;
    private javax.swing.JButton jBtnNovoFabricante;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListarFabricantes;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtFabricante;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
