package telas;

import atributos.Produto;
import static funcoes.Conexao.getConnection;
import funcoes.ModeloTabela;
import funcoes.ProdutoDAO;
import funcoes.TabelaZebrada;
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
public class ExibeProduto extends javax.swing.JFrame {
    
    Statement stmt ;
    Produto produto = new Produto();
    private static int indice;
    private Menu telaMenu;

    /**
     * Creates new form ExibeProduto
     */
    public ExibeProduto() {
        initComponents();
        TabelaProduto("SELECT * FROM tabproduto;");
    }
    
    public ExibeProduto(Menu menu) {
        this.telaMenu = menu;
        initComponents();
        TabelaProduto("SELECT * FROM tabproduto;");
    }
    
    public static int GetIndiceProduto() {         
        return indice;
    }
    
    public void TabelaProduto(String Sql) {
        
        try {
            
            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();               
            String [] Colunas = {"Código", "Produto"};
               
            ResultSet rs;
            rs = stmt.executeQuery(Sql);            
            
            while(rs.next()) {
               dados.add(new Object[]{rs.getObject("id_prod"),
                                      rs.getObject("produto")});            
            }
                        
            for (int i = 0; i < 2; i++){
                
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarProdutos.setModel(modelo);
                
                TableCellRenderer renderer = new TabelaZebrada();
                jTableListarProdutos.setDefaultRenderer(Object.class, renderer);
                
                jTableListarProdutos.getColumnModel().getColumn(0).setPreferredWidth(100);
                jTableListarProdutos.getColumnModel().getColumn(1).setPreferredWidth(400);
                jTableListarProdutos.getColumnModel().getColumn(i).setResizable(false);
                jTableListarProdutos.getTableHeader().setReorderingAllowed(false);
                jTableListarProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExibeProduto.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jBtnDetalharProduto = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListarProdutos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Raavi", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/prod.png"))); // NOI18N
        jLabel1.setText("Produtos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 40, 120, -1));

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButton3.setText("Novo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 100, 50));

        jBtnDetalharProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/information.png"))); // NOI18N
        jBtnDetalharProduto.setText("Detalhar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarProdutos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnDetalharProduto, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnDetalharProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDetalharProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnDetalharProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 100, 50));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        jButton7.setText("Voltar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 90, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.gif"))); // NOI18N
        jLabel2.setText("Pesquisar Produto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 320, 20));

        jTableListarProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableListarProdutos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 510, 380));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img2.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 850, 130));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 630));

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        new CadastrarProduto(this).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        verificaPagina();
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jBtnDetalharProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDetalharProdutoActionPerformed
        int linha = jTableListarProdutos.getSelectedRow();
        indice = (Integer.parseInt(jTableListarProdutos.getValueAt(linha, 0).toString()));
        this.setVisible(false);
        new ExibeProdutosDetalhe(this).setVisible(true);
    }//GEN-LAST:event_jBtnDetalharProdutoActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        TabelaProduto("select * from tabproduto where produto "
            + "like '%" + txtBuscar.getText().trim() + "%';");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void verificaPagina() {       
        if ((this.telaMenu != null)) {
            this.telaMenu.setVisible(true);
            // this.telaMenu.toFront();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnDetalharProduto;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListarProdutos;
    private javax.swing.JTextField txtBuscar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
