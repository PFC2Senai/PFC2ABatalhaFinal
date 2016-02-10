package telas;

import atributos.Equipamento;
import static atributos.Usuario.idUsuario;
import funcoes.Conexao;
import funcoes.EquipamentoDAO;
import funcoes.LimitarDigitos;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
    private CadastrarEquipCliente telaCadEquipCliente;
    private Menu telaMenu;

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

        txtEquipamento.setDocument(new LimitarDigitos(45));
        combobox();
    }

    public CadastrarEquipamento(Menu menu) {
        this.telaMenu = menu;
        initComponents();
        populaComboBoxFornecedor();
        populaComboBoxFabricante();
        populaComboBoxModelo();
        populaComboBoxEquipamento();
        txtEquipamento.setVisible(false);
        jBtnCadEquipamento.setVisible(false);
        jBtnCancelarCadEquipamento.setVisible(false);

        txtEquipamento.setDocument(new LimitarDigitos(45));
        combobox();
    }

    public CadastrarEquipamento(CadastrarEquipCliente telaCadEquipCli) {
        telaCadEquipCliente = telaCadEquipCli;
        initComponents();
        populaComboBoxFornecedor();
        populaComboBoxFabricante();
        populaComboBoxModelo();
        populaComboBoxEquipamento();
        txtEquipamento.setVisible(false);
        jBtnCadEquipamento.setVisible(false);
        jBtnCancelarCadEquipamento.setVisible(false);
        txtEquipamento.setDocument(new LimitarDigitos(45));
        combobox();
    }

    private void combobox() {

        //Combobox equipamento
        jComboBoxEquipamento.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codEquipamento == 0 && jComboBoxEquipamento.getSelectedIndex() != 0) {
                    JOptionPane.showMessageDialog(null, "Esse registro não encontra-se cadastrado na base de dados.");
                    jComboBoxEquipamento.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        jComboBoxEquipamento.setAutocompletar(true);

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
        jComboBoxFabricante = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jBtbNovoEquipamento = new javax.swing.JButton();
        jBtnCadEquipamento = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxEquipamento = new componentes.UJComboBox();
        txtEquipamento = new javax.swing.JTextField();
        jBtnCancelarCadEquipamento = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxFornecedor = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxModelo = new javax.swing.JComboBox();
        jBtnSair = new javax.swing.JButton();
        jBtnCadastrarEquipamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxFabricante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o fabricante" }));
        jComboBoxFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFabricanteActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 260, -1));

        jLabel1.setFont(new java.awt.Font("Raavi", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/maquina02.png"))); // NOI18N
        jLabel1.setText("Cadastrar Equipamento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 23));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img2.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 100));

        jPanel2.setBackground(new java.awt.Color(223, 237, 253));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtbNovoEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add (2).png"))); // NOI18N
        jBtbNovoEquipamento.setText("Novo");
        jBtbNovoEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbNovoEquipamentoActionPerformed(evt);
            }
        });
        jPanel2.add(jBtbNovoEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));

        jBtnCadEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jBtnCadEquipamento.setText("Salvar");
        jBtnCadEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadEquipamentoActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnCadEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 150, 90, -1));

        jLabel2.setText("Equipamento:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jComboBoxEquipamento.setEditable(true);
        jComboBoxEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEquipamentoActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 260, -1));
        jPanel2.add(txtEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 260, -1));

        jBtnCancelarCadEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelarCadEquipamento.setText("Cancelar");
        jBtnCancelarCadEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarCadEquipamentoActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnCancelarCadEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 100, -1));

        jLabel8.setText("Fornecedor:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jComboBoxFornecedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o fornecedor" }));
        jComboBoxFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFornecedorActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 200, -1));

        jLabel9.setText("Fabricante:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel10.setText("Modelo:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jComboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o modelo" }));
        jComboBoxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeloActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 200, -1));

        jBtnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/stop2.png"))); // NOI18N
        jBtnSair.setText("Cancelar");
        jBtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSairActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jBtnCadastrarEquipamento.setFont(new java.awt.Font("Raavi", 0, 12)); // NOI18N
        jBtnCadastrarEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        jBtnCadastrarEquipamento.setText("Cadastrar");
        jBtnCadastrarEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarEquipamentoActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnCadastrarEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSairActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair? Os dados não serão salvos.", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
            verificaPagina();
            this.dispose();
        }
    }//GEN-LAST:event_jBtnSairActionPerformed

    private void jBtnCadEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadEquipamentoActionPerformed
        if (txtEquipamento.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o EQUIPAMENTO!");
            txtEquipamento.requestFocus();
            txtEquipamento.setBackground(Color.yellow);
        } else {
            if (EquipamentoDAO.VerificaEquipamento(txtEquipamento.getText()) == false) {

                equi.setTabusuarioIdUsuario(idUsuario());
                equi.setEquipamento(txtEquipamento.getText());
                codEquipamento = EquipamentoDAO.CadEquipamento(equi);

            } else {
                JOptionPane.showMessageDialog(this, "Registro ja cadastrado");
            }

            jBtnCadEquipamento.setVisible(false);
            jBtnCancelarCadEquipamento.setVisible(false);
            jBtbNovoEquipamento.setVisible(true);
            txtEquipamento.setVisible(false);
            jComboBoxEquipamento.setVisible(true);
            jComboBoxEquipamento.removeAllItems();
            populaComboBoxEquipamento();
            jComboBoxEquipamento.setSelectedItem(txtEquipamento.getText());
    }//GEN-LAST:event_jBtnCadEquipamentoActionPerformed
    }
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

        if (jComboBoxFornecedor.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um Fornecedor!");
            return;
        }

        if (jComboBoxEquipamento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um Equipamento!");
            return;
        }

        if (jComboBoxFabricante.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um Fabricante!");
            return;
        }

        if (jComboBoxModelo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um Modelo!");
            return;
        }

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
        verificaPagina();
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        if (JOptionPane.showConfirmDialog(null, "Deseja continuar cadastrando?", "Confirmar Cadastro", JOptionPane.YES_NO_OPTION) == 1) {
            verificaPagina();
            this.dispose();
        } else {
            jComboBoxEquipamento.requestFocus();
        }
    }//GEN-LAST:event_jBtnCadastrarEquipamentoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void jComboBoxEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEquipamentoActionPerformed
        idEquipamentoComboBox();
    }//GEN-LAST:event_jComboBoxEquipamentoActionPerformed

    private void limparCampos() {
        jComboBoxFabricante.setSelectedIndex(0);
        jComboBoxFornecedor.setSelectedIndex(0);
        jComboBoxModelo.setSelectedIndex(0);
    }

    private void populaComboBoxEquipamento() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabequipamento;";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            jComboBoxEquipamento.addItem("Selecione o equipemento");
            while (rs.next()) { 
                jComboBoxEquipamento.addItem(rs.getString("equipamento"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idEquipamentoComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabequipamento where equipamento = '" + jComboBoxEquipamento.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codEquipamento = (rs.getInt("idEquipamento"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void populaComboBoxFornecedor() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfornecedor";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                jComboBoxFornecedor.addItem(rs.getString("fornecedor"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idFornecedorComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfornecedor where fornecedor = '" + jComboBoxFornecedor.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codFornecedor = (rs.getInt("id_forn"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void populaComboBoxFabricante() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfabricante";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                jComboBoxFabricante.addItem(rs.getString("fabricante"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idFabricanteComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfabricante where fabricante = '" + jComboBoxFabricante.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codFabricante = (rs.getInt("idtabFabricante"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void populaComboBoxModelo() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabmodelo";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                jComboBoxModelo.addItem(rs.getString("modelo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idModeloComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabmodelo where modelo = '" + jComboBoxModelo.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codModelo = (rs.getInt("idtabModelo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void verificaPagina() {

        if ((this.telaCadEquipCliente != null)) {
            this.telaCadEquipCliente.carregarComboEquipamento();
            this.telaCadEquipCliente.ComboEquipamento(jComboBoxEquipamento.getSelectedItem().toString());
            this.telaCadEquipCliente.setEnabled(true);
            this.telaCadEquipCliente.toFront();
        } else if ((this.telaMenu != null)) {
            this.telaMenu.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbNovoEquipamento;
    private javax.swing.JButton jBtnCadEquipamento;
    private javax.swing.JButton jBtnCadastrarEquipamento;
    private javax.swing.JButton jBtnCancelarCadEquipamento;
    private javax.swing.JButton jBtnSair;
    private componentes.UJComboBox jComboBoxEquipamento;
    private javax.swing.JComboBox jComboBoxFabricante;
    private javax.swing.JComboBox jComboBoxFornecedor;
    private javax.swing.JComboBox jComboBoxModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtEquipamento;
    // End of variables declaration//GEN-END:variables
}
