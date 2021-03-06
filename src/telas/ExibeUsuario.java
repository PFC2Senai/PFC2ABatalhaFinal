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
import static telas.TelaLogin.TipoUsuario;

/**
 *
 * @author WilhamJr
 */
public class ExibeUsuario extends javax.swing.JFrame {

    Statement stmt;
    Usuario usuario = new Usuario();
    private String opcaoPesquisa = "usuario";
    private static int indice;
    public static String usu;

    /**
     * Creates new form CadastroDeFuncionarios
     */
    public ExibeUsuario() {
        initComponents();
        TabelaUsuario("select * from tabUsuario;");
        verificaUsuario();
    }

    public static int GetIndice() {
        return indice;
    }

    public void TabelaUsuario(String Sql) {

        try {

            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();
            String[] Colunas = {"Código do Usuário", "Tipo de Usuário", "Usuario"};

            ResultSet rs;
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {

                dados.add(new Object[] {
                    rs.getObject("id_usuario"),
                    rs.getObject("tipo_usuario"),
                    rs.getObject("usuario")
                });
            }

            for (int i = 0; i < 3; i++) {
                
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarUsuarios.setModel(modelo);
                jTableListarUsuarios.getColumnModel().getColumn(i).setPreferredWidth(150);
                jTableListarUsuarios.getColumnModel().getColumn(i).setResizable(false);
                jTableListarUsuarios.getTableHeader().setReorderingAllowed(false);
                jTableListarUsuarios.setAutoResizeMode(jTableListarUsuarios.AUTO_RESIZE_OFF);
                jTableListarUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExibeUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
        jTableListarUsuarios = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jBtnEditarUsuario = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jComboBoxOpcaoPesquisa = new javax.swing.JComboBox();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxTipoUser = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Raavi", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user.gif"))); // NOI18N
        jLabel1.setText("Usuários");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 130, -1));

        jTableListarUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableListarUsuarios);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 580, 250));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page.png"))); // NOI18N
        jButton3.setText("Novo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, -1));

        jBtnEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jBtnEditarUsuario.setText("Editar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarUsuarios, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnEditarUsuario, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnEditarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, -1, -1));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        jButton7.setText("Voltar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, -1, -1));

        jComboBoxOpcaoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione a opção de pesquisa", "Código", "Usuário" }));
        jComboBoxOpcaoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOpcaoPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxOpcaoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 211, -1));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 275, -1));

        jLabel2.setText("Pesquisar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jComboBoxTipoUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Administrador", "Funcionario" }));
        jComboBoxTipoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoUserActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxTipoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 211, -1));

        jLabel5.setText("Tipo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img2.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 110));

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 670, 490));

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new CadastrarUsuario().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jBtnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarUsuarioActionPerformed
        
        
        if (jTableListarUsuarios.getSelectedRow() != -1) {
            
            this.dispose();
            int linha = jTableListarUsuarios.getSelectedRow();
            indice = (Integer.parseInt(jTableListarUsuarios.getValueAt(linha, 0).toString()));
            new AlterarUsuario().setVisible(true);
            usu = jTableListarUsuarios.getValueAt(linha, 0).toString();

        } else {
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro.");
        }
    }//GEN-LAST:event_jBtnEditarUsuarioActionPerformed

    private void jComboBoxOpcaoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOpcaoPesquisaActionPerformed

        if (jComboBoxOpcaoPesquisa.getSelectedIndex() == 0) {
            TabelaUsuario("SELECT * FROM tabUsuario;");
        }

        switch (jComboBoxOpcaoPesquisa.getSelectedItem().toString()) {

            case "Código":
                opcaoPesquisa = "id_usuario";
                txtBuscar.setVisible(true);
                break;
            case "Usuário":
                opcaoPesquisa = "usuario";
                txtBuscar.setVisible(true);
                break;
        }
        
    }//GEN-LAST:event_jComboBoxOpcaoPesquisaActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        TabelaUsuario("SELECT * FROM tabusuario where " + opcaoPesquisa
                + " like '%" + txtBuscar.getText() + "%';");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jComboBoxTipoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoUserActionPerformed

        String tipoUser = "";
        
        switch (jComboBoxTipoUser.getSelectedItem().toString()) {
            
            case "Administrador":
                tipoUser = "A";
                break;
            case "Funcionário":
                tipoUser = "F";
                break;
        }
        
        if (jComboBoxTipoUser.getSelectedIndex() != 0) {

            TabelaUsuario("select  * from tabusuario where " + opcaoPesquisa
                + " like '%" + txtBuscar.getText() + "%' "
                + "and tipo_usuario = '" + tipoUser + "';");

        } else if (jComboBoxTipoUser.getSelectedIndex() == 0) {

            TabelaUsuario("select  * from tabusuario where " + opcaoPesquisa
                + " like '%" + txtBuscar.getText() + "%' ;");
        }
    }
        
        public void verificaUsuario(){
            if(TipoUsuario() == false){
            jBtnEditarUsuario.setVisible(false);
           // jButton6.setVisible(false);
        }
    }//GEN-LAST:event_jComboBoxTipoUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEditarUsuario;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBoxOpcaoPesquisa;
    private javax.swing.JComboBox jComboBoxTipoUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListarUsuarios;
    private javax.swing.JTextField txtBuscar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
