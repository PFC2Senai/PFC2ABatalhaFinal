/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import atributos.RotinaContatos;
import static funcoes.Conexao.getConnection;
import funcoes.ModeloTabela;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;

/**
 *
 * @author WilhamJr
 */
public class ExibeRotina extends javax.swing.JFrame {
    
    Statement stmt ;
RotinaContatos rotinaContatos = new RotinaContatos();
private static int indice;
private static int idContato;

    /**
     * Creates new form ExibeRotina
     */
    public ExibeRotina() {
        initComponents();
        TabelaRotina("select  * from tabrotinacontato;");
    }
    
     public static int GetIndice() {                     
        return indice;
    }
     
     public void TabelaRotina(String Sql){
        
        try { 
            
            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();               
            String [] Colunas = {"Código","Código do cliente", "Código do usuario", "Data", "Hora", "Descrição"};
               
            ResultSet rs;
            rs = stmt.executeQuery(Sql);            
            rs.first();
            
                    do{
                       dados.add(new Object[]{rs.getObject("idRotinaContato"),rs.getObject("cliente_idcliente"),
                                              rs.getObject("tabusuario_id_usuario"),rs.getObject("dataRotina"), 
                                              rs.getObject("horaRotina"),rs.getObject("descricaoRotina")});            
                    }while(rs.next());

                    for (int i = 0; i < dados.size(); i++){
                        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                        jTableListarRotinas.setModel(modelo);
                        jTableListarRotinas.getColumnModel().getColumn(i).setPreferredWidth(150);
                        jTableListarRotinas.getColumnModel().getColumn(i).setResizable(false);
                        jTableListarRotinas.getTableHeader().setReorderingAllowed(false);
                        jTableListarRotinas.setAutoResizeMode(jTableListarRotinas.AUTO_RESIZE_OFF);
                        jTableListarRotinas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    }
                    
        } catch (SQLException ex) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (Exception erro){
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, erro);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListarRotinas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -30, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Rotinas Cadastradas");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jTableListarRotinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableListarRotinas);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 568, 160));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img1.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 100));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ExibeRotina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ExibeRotina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ExibeRotina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ExibeRotina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ExibeRotina().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListarRotinas;
    // End of variables declaration//GEN-END:variables
}
