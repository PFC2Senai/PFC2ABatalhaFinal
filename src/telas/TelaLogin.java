package telas;

import atributos.Auditoria;
import atributos.Usuario;
import funcoes.AuditoriaDAO;
import funcoes.Conexao;
import static funcoes.Conexao.getConnection;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Josy
 */
public class TelaLogin extends javax.swing.JFrame {

    Conexao conexao = new Conexao();

    private static int codAuditoria;
    private static boolean valida = true;

    /**
     * Creates new form Acesso
     */
    public TelaLogin() {
        initComponents();
        conexao.conexao();
        //setSize(590,397);
        Color minhaCor = new Color(134, 234, 174);
        this.getContentPane().setBackground(minhaCor);
    }

    public static boolean TipoUsuario() {
        return valida;
    }
    public void TipoUser() {
        //valida = true;

        try {
            conexao.executaSQL("select * from tabusuario where usuario = '" + login.getText() + "'");
            conexao.rs.first();

            if (conexao.rs.getString("tipo_usuario").equals("F")) {
            //jMenu14.setVisible(false);   

                valida = false;
                //return valida;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

        // return valida;
    }

    
//    public void TipoUser() {
//        //valida = true;
//        ResultSet rs; 
//        String tipoUser;
//        try {
//            String sql = "select * from tabusuario where usuario = '"+login.getText()+"';";
//            Statement s = getConnection().createStatement();
//            s.executeQuery (sql);
//            rs = s.getResultSet();
//
//            while (rs.next ()){
//                tipoUser = rs.getString("tipo_usuario");
//                
//                if (tipoUser.equalsIgnoreCase("F")) {
//                //jMenu14.setVisible(false);   
//
//                    valida = false;
//                    break;
//                    //return valida;
//                }
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        // return valida;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        jComBTipoUser = new javax.swing.JComboBox();
        jButtonAcesso = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LOGIN");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.gif"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setSelected(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, -1));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        login.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        login.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 204, 153), null, null));
        login.setSelectionColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 160, 20));

        txtSenha.setToolTipText("");
        txtSenha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 204, 153), null, null));
        txtSenha.setSelectionColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 160, -1));

        jComBTipoUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComBTipoUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Administrador", "Funcionário" }));
        jComBTipoUser.setToolTipText("");
        getContentPane().add(jComBTipoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 90, 20));

        jButtonAcesso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jButtonAcesso.setText("Ok");
        jButtonAcesso.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 153)));
        jButtonAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcessoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 60, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("LOGIN");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 90, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adm.png"))); // NOI18N
        jLabel2.setText("Usuário:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/key (2).png"))); // NOI18N
        jLabel3.setText("Senha:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Login.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcessoActionPerformed

        Usuario user = new Usuario();

        user.setNome(login.getText());
        user.setSenha(txtSenha.getText());
        String comboTipo = jComBTipoUser.getSelectedItem().toString();
        String tipo = null;

        switch (comboTipo) {
            case "Administrador":
                tipo = "A";
                break;
            case "Funcionário":
                tipo = "F";
                break;
        }
        user.setTipo((tipo));

        if (user.validaSenha(user)) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    TipoUser();
                    registraAuditoria();
                    new Menu(login.getText()).setVisible(true);
                }
            });
            TelaLogin.this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou Senha inválidos!");
        }
    }//GEN-LAST:event_jButtonAcessoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void registraAuditoria() {

        Auditoria audt = new Auditoria();
        audt.setCodUsuario(Usuario.idUsuario());
        codAuditoria = AuditoriaDAO.CadAuditoria(audt);
    }

    public static int idAuditoria() {
        return codAuditoria = 1;
    }

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new TelaLogin().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAcesso;
    private javax.swing.JComboBox jComBTipoUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField login;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
