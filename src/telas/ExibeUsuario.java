/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import static funcoes.Conexao.getConnection;
import funcoes.ModeloTabela;
import atributos.Usuario;
import funcoes.UsuarioDAO;
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
 * @author WilhamJr
 */
public class ExibeUsuario extends javax.swing.JFrame {
        
Statement stmt ;
Usuario usuario = new Usuario();
private static int indice;
    /**
     * Creates new form CadastroDeFuncionarios
     */
    public ExibeUsuario() {        
        initComponents();
        TabelaUsuario("select * from tabUsuario;");      
    }
    
    public static int GetIndice() {         
        return indice;
    }
    
    public void TabelaUsuario(String Sql){
        
        try {
            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();               
            String [] Colunas = {"Código do Usuário","Tipo de Usuário", "Usuario", "Senha"};
               
            ResultSet rs;
            rs = stmt.executeQuery(Sql);            
            rs.first();
            
            do{
               dados.add(new Object[]{rs.getObject("id_usuario"),rs.getObject("tipo_usuario"),rs.getObject("usuario"),rs.getObject("senha")});            
            }while(rs.next());
                        
            for (int i = 0; i < 4; i++){
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarUsuarios.setModel(modelo);
                jTableListarUsuarios.getColumnModel().getColumn(i).setPreferredWidth(150);
                jTableListarUsuarios.getColumnModel().getColumn(i).setResizable(false);
                jTableListarUsuarios.getTableHeader().setReorderingAllowed(false);
                jTableListarUsuarios.setAutoResizeMode(jTableListarUsuarios.AUTO_RESIZE_OFF);
                jTableListarUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, ex);
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
        jTableListarUsuarios = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jBtnEditarUsuario = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cadastro de Usuários");

        jTableListarUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableListarUsuarios);

        jButton3.setText("Novo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jBtnEditarUsuario.setText("Editar");
        jBtnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarUsuarioActionPerformed(evt);
            }
        });

        jButton6.setText("Excluir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Voltar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton3)
                .addGap(57, 57, 57)
                .addComponent(jBtnEditarUsuario)
                .addGap(67, 67, 67)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jBtnEditarUsuario)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new CadastrarUsuario().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(jTableListarUsuarios.getSelectedRow() != -1) {
            
            int linha = jTableListarUsuarios.getSelectedRow();
            usuario.setIdUser(Integer.parseInt(jTableListarUsuarios.getValueAt(linha, 0).toString()));
            
            int cod = UsuarioDAO.idUsuario(usuario.getIdUser());
            UsuarioDAO.ExcluirUsuario(cod);
//            ContatosDAO.ExcluirEndereco(codContato);
//            ContatosDAO.ExcluirTel(codContato);
//            ContatosDAO.ExcluirEmail(codContato);           
        } else { 
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro.");
        }    
        TabelaUsuario("select  * from tabusuario;");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jBtnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarUsuarioActionPerformed
        if(jTableListarUsuarios.getSelectedRow() != -1){
            this.dispose();
            int linha = jTableListarUsuarios.getSelectedRow();        
            indice = (Integer.parseInt(jTableListarUsuarios.getValueAt(linha, 0).toString()));
            new AlterarUsuario().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro.");
        }  
    }//GEN-LAST:event_jBtnEditarUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEditarUsuario;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListarUsuarios;
    // End of variables declaration//GEN-END:variables
}
