package telas;

import atributos.Fabricante;
import static funcoes.Conexao.getConnection;
import funcoes.FabricanteDAO;
import funcoes.ModeloTabela;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author graciele
 */
public class ExibeFabricante extends javax.swing.JFrame {
    Statement stmt ;
    Fabricante fab = new Fabricante();
    private static int indice;

    /**
     * Creates new form ExibeFabricante
     */
    public ExibeFabricante() {
        initComponents();
        TabelaFabricante("select * from tabfabricante;");
    }
    
    public static int GetIndice() {         
        return indice;
    }
    
    public void TabelaFabricante(String Sql){
        
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
                jTableListarFabricantes.getColumnModel().getColumn(0).setMaxWidth(0);
                jTableListarFabricantes.getColumnModel().getColumn(0).setMinWidth(0);
                jTableListarFabricantes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                jTableListarFabricantes.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
                
                jTableListarFabricantes.getColumnModel().getColumn(1).setPreferredWidth(200);
                
                jTableListarFabricantes.getColumnModel().getColumn(i).setResizable(false);
                jTableListarFabricantes.getTableHeader().setReorderingAllowed(false);
               // jTableListarFabricantes.setAutoResizeMode(jTableListarFabricantes.AUTO_RESIZE_OFF);
                jTableListarFabricantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExibeModelo.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListarFabricantes = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Fabricantes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

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
        jScrollPane2.setViewportView(jTableListarFabricantes);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 151, 495, 320));

        jButton5.setText("Novo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 489, -1, -1));

        jButton6.setText("Editar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 489, -1, -1));

        jButton7.setText("Excluir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 489, -1, -1));

        jButton8.setText("Cancelar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 489, -1, -1));

        jLabel2.setText("Pesquisar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 280, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img2.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 670, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new CadastrarFabricante().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(jTableListarFabricantes.getSelectedRow() != -1){
            this.dispose();
            int linha = jTableListarFabricantes.getSelectedRow();
            indice = (Integer.parseInt(jTableListarFabricantes.getValueAt(linha, 0).toString()));
            new AlterarFabricante().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro.");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(jTableListarFabricantes.getSelectedRow() != -1) {

            int linha = jTableListarFabricantes.getSelectedRow();
            fab.setIdFabricante(Integer.parseInt(jTableListarFabricantes.getValueAt(linha, 0).toString()));

            int cod = FabricanteDAO.idFabricante(fab.getIdFabricante());
            FabricanteDAO.ExcluirFabricante(cod);
            //            ContatosDAO.ExcluirEndereco(codContato);
            //            ContatosDAO.ExcluirTel(codContato);
            //            ContatosDAO.ExcluirEmail(codContato);
        } else {
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro.");
        }
        TabelaFabricante("select  * from tabfabricante;");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        TabelaFabricante("select  * from tabfabricante where fabricante "
            + "like '%" + txtBuscar.getText() + "%';");
    }//GEN-LAST:event_txtBuscarKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListarFabricantes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
