package telas;

import funcoes.Conexao;
import static funcoes.Conexao.getConnection;
import funcoes.EquipamentoDAO;
import funcoes.ModeloTabela;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * @author Josy
 */
public class ExibeEquipamento extends javax.swing.JFrame {

    Statement stmt;
    private PreparedStatement pst;
    private static int indice;

    /**
     * Creates new form ExibeEquipamento
     */
    public ExibeEquipamento() {
        initComponents();
        TabelaEquipamento("SELECT * FROM vw_equipamentos; ");
        populaComboBoxModelo();
        populaComboBoxFabricante();
        populaComboBoxFornecedor();
        jBtnEditar.setEnabled(false);
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
        jBtnNovo = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnExcluirEquipamento = new javax.swing.JButton();
        jBtnSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxFornecedor = new javax.swing.JComboBox();
        jComboBoxFabricante = new javax.swing.JComboBox();
        jComboBoxModelo = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListarEquipamento = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Raavi", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/equipamento.png"))); // NOI18N
        jLabel1.setText("Equipamentos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jBtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jBtnNovo.setText("Novo");
        jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, -1, -1));

        jBtnEditar.setText("Detalhar Equipamento");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarEquipamento, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnEditar, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 620, -1, -1));

        jBtnExcluirEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jBtnExcluirEquipamento.setText("Excluir");
        jBtnExcluirEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirEquipamentoActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnExcluirEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 620, -1, -1));

        jBtnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/stop2.png"))); // NOI18N
        jBtnSair.setText("Sair");
        jBtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSairActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 620, -1, -1));

        jLabel2.setText("Pesquisar Equipamento:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 210, -1));

        jLabel3.setText("Filtrar:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jComboBoxFornecedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o fornecedor" }));
        jComboBoxFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFornecedorActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 210, -1));

        jComboBoxFabricante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o fabricante" }));
        jComboBoxFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFabricanteActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 200, -1));

        jComboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o modelo" }));
        jComboBoxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeloActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 200, -1));

        jTableListarEquipamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableListarEquipamento.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableListarEquipamento);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 730, 356));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3-5.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 660));

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void TabelaEquipamento(String Sql) {

        try {

            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();
            String[] Colunas = {"Código", "Equipamento", "Fornecedor", "Fabricante", "Modelo"};

            ResultSet rs;
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                dados.add(new Object[]{
                    rs.getObject("idDetEquipamento"), 
                    rs.getObject("equipamento"),
                    rs.getObject("fornecedor"), 
                    rs.getObject("fabricante"),
                    rs.getObject("modelo")});
            }

            for (int i = 0; i < 5; i++) {
                
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarEquipamento.setModel(modelo);
                jTableListarEquipamento.getColumnModel().getColumn(0).setMaxWidth(0);
                jTableListarEquipamento.getColumnModel().getColumn(0).setMinWidth(0);
                jTableListarEquipamento.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                jTableListarEquipamento.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
                
                jTableListarEquipamento.getColumnModel().getColumn(1).setPreferredWidth(200);
                jTableListarEquipamento.getColumnModel().getColumn(2).setPreferredWidth(150);
                jTableListarEquipamento.getColumnModel().getColumn(3).setPreferredWidth(150);
                jTableListarEquipamento.getColumnModel().getColumn(4).setPreferredWidth(150);
                jTableListarEquipamento.getColumnModel().getColumn(i).setResizable(false);
                jTableListarEquipamento.getTableHeader().setReorderingAllowed(false);
               // jTableListarEquipamento.setAutoResizeMode(jTableListarEquipamento.AUTO_RESIZE_OFF);
                jTableListarEquipamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception erro) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, erro);
        }
    }


    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
        new CadastrarEquipamento().setVisible(true);
    }//GEN-LAST:event_jBtnNovoActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        
        int linha = jTableListarEquipamento.getSelectedRow();
        indice = (Integer.parseInt(jTableListarEquipamento.getValueAt(linha, 0).toString()));
        new DetalharEquipamento(indice, this).setVisible(true);
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnExcluirEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirEquipamentoActionPerformed

        EquipamentoDAO.ExcluirEquipamento(indice);
        TabelaEquipamento("SELECT * FROM vw_equipamentos; ");
    }//GEN-LAST:event_jBtnExcluirEquipamentoActionPerformed

    private void jBtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSairActionPerformed

    private void jComboBoxFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFornecedorActionPerformed
        if (jComboBoxFabricante.getSelectedIndex() != 0 && jComboBoxModelo.getSelectedIndex() != 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fornecedor = '" + jComboBoxFornecedor.getSelectedItem().toString() + "'"
                    + "and fabricante = '" + jComboBoxFabricante.getSelectedItem().toString() + "'"
                    + "and modelo = '" + jComboBoxModelo.getSelectedItem().toString() + "';");
        
        } else if (jComboBoxFabricante.getSelectedIndex() != 0 && jComboBoxModelo.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fornecedor = '" + jComboBoxFornecedor.getSelectedItem().toString() + "'"
                    + "and fabricante = '" + jComboBoxFabricante.getSelectedItem().toString() + "' ;");
            
        } else if (jComboBoxModelo.getSelectedIndex() != 0 && jComboBoxFabricante.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fornecedor = '" + jComboBoxFornecedor.getSelectedItem().toString() + "'"
                    + "and modelo = '" + jComboBoxModelo.getSelectedItem().toString() + "';");
            
        } else if (jComboBoxFabricante.getSelectedIndex() == 0 && jComboBoxModelo.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fornecedor = '" + jComboBoxFornecedor.getSelectedItem().toString() + "';");
        }
        //
        if (jComboBoxFabricante.getSelectedIndex() != 0 && jComboBoxModelo.getSelectedIndex() != 0 && jComboBoxFornecedor.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fabricante = '" + jComboBoxFabricante.getSelectedItem().toString() + "'"
                    + "and modelo = '" + jComboBoxModelo.getSelectedItem().toString() + "';");
        
        } else if (jComboBoxFabricante.getSelectedIndex() != 0 && jComboBoxModelo.getSelectedIndex() == 0 && jComboBoxFornecedor.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fabricante = '" + jComboBoxFabricante.getSelectedItem().toString() + "' ;");
            
        } else if (jComboBoxModelo.getSelectedIndex() != 0 && jComboBoxFabricante.getSelectedIndex() == 0 && jComboBoxFornecedor.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and modelo = '" + jComboBoxModelo.getSelectedItem().toString() + "';");
            
        } else if (jComboBoxFabricante.getSelectedIndex() == 0 && jComboBoxModelo.getSelectedIndex() == 0 && jComboBoxFornecedor.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%';");
        }
    }//GEN-LAST:event_jComboBoxFornecedorActionPerformed

    private void jComboBoxFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFabricanteActionPerformed
        if (jComboBoxFornecedor.getSelectedIndex() != 0 && jComboBoxModelo.getSelectedIndex() != 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fornecedor = '" + jComboBoxFornecedor.getSelectedItem().toString() + "'"
                    + "and fabricante = '" + jComboBoxFabricante.getSelectedItem().toString() + "'"
                    + "and modelo = '" + jComboBoxModelo.getSelectedItem().toString() + "';");
        
        } else if (jComboBoxFornecedor.getSelectedIndex() != 0 && jComboBoxModelo.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fornecedor = '" + jComboBoxFornecedor.getSelectedItem().toString() + "'"
                    + "and fabricante = '" + jComboBoxFabricante.getSelectedItem().toString() + "';");
        
        } else if (jComboBoxModelo.getSelectedIndex() != 0 && jComboBoxFornecedor.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fabricante = '" + jComboBoxFabricante.getSelectedItem().toString() + "'"
                    + "and modelo = '" + jComboBoxModelo.getSelectedItem().toString() + "';");
        
        } else if (jComboBoxFornecedor.getSelectedIndex() == 0 && jComboBoxModelo.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fabricante = '" + jComboBoxFabricante.getSelectedItem().toString() + "';");
        }
        
        //
        
        if (jComboBoxFornecedor.getSelectedIndex() != 0 && jComboBoxModelo.getSelectedIndex() != 0 && jComboBoxFabricante.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fornecedor = '" + jComboBoxFornecedor.getSelectedItem().toString() + "'"
                    + "and modelo = '" + jComboBoxModelo.getSelectedItem().toString() + "';");
        
        } else if (jComboBoxFornecedor.getSelectedIndex() != 0 && jComboBoxModelo.getSelectedIndex() == 0 && jComboBoxFabricante.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fornecedor = '" + jComboBoxFornecedor.getSelectedItem().toString() + "';");
        
        } else if (jComboBoxModelo.getSelectedIndex() != 0 && jComboBoxFornecedor.getSelectedIndex() == 0 && jComboBoxFabricante.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and modelo = '" + jComboBoxModelo.getSelectedItem().toString() + "';");
        
        } else if (jComboBoxFornecedor.getSelectedIndex() == 0 && jComboBoxModelo.getSelectedIndex() == 0 && jComboBoxFabricante.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%';");
        }
    }//GEN-LAST:event_jComboBoxFabricanteActionPerformed

    private void jComboBoxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloActionPerformed
        if (jComboBoxFornecedor.getSelectedIndex() != 0 && jComboBoxFabricante.getSelectedIndex() != 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fornecedor = '" + jComboBoxFornecedor.getSelectedItem().toString() + "'"
                    + "and fabricante = '" + jComboBoxFabricante.getSelectedItem().toString() + "'"
                    + "and modelo = '" + jComboBoxModelo.getSelectedItem().toString() + "';");
        
        } else if (jComboBoxFornecedor.getSelectedIndex() != 0 && jComboBoxFabricante.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fornecedor = '" + jComboBoxFornecedor.getSelectedItem().toString() + "'"
                    + "and modelo = '" + jComboBoxModelo.getSelectedItem().toString() + "';");
        
        } else if (jComboBoxFabricante.getSelectedIndex() != 0 && jComboBoxFornecedor.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fabricante = '" + jComboBoxFabricante.getSelectedItem().toString() + "'"
                    + "and modelo = '" + jComboBoxModelo.getSelectedItem().toString() + "';");
        
        } else if (jComboBoxFabricante.getSelectedIndex() == 0 && jComboBoxFornecedor.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and modelo = '" + jComboBoxModelo.getSelectedItem().toString() + "';");
        }
        
        //
        
        if (jComboBoxFornecedor.getSelectedIndex() != 0 && jComboBoxFabricante.getSelectedIndex() != 0 && jComboBoxModelo.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fornecedor = '" + jComboBoxFornecedor.getSelectedItem().toString() + "'"
                    + "and fabricante = '" + jComboBoxFabricante.getSelectedItem().toString() + "';");
        
        } else if (jComboBoxFornecedor.getSelectedIndex() != 0 && jComboBoxFabricante.getSelectedIndex() == 0 && jComboBoxModelo.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fornecedor = '" + jComboBoxFornecedor.getSelectedItem().toString() + "';");
        
        } else if (jComboBoxFabricante.getSelectedIndex() != 0 && jComboBoxFornecedor.getSelectedIndex() == 0 && jComboBoxModelo.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%' "
                    + "and fabricante = '" + jComboBoxFabricante.getSelectedItem().toString() + "';");
        
        } else if (jComboBoxFabricante.getSelectedIndex() == 0 && jComboBoxFornecedor.getSelectedIndex() == 0 && jComboBoxModelo.getSelectedIndex() == 0) {
            
            TabelaEquipamento("select  * from vw_equipamentos where equipamento "
                    + "like '%" + txtBuscar.getText() + "%';");
        }
    }//GEN-LAST:event_jComboBoxModeloActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        
        TabelaEquipamento("select * from vw_equipamentos where equipamento "
                + "like '%" + txtBuscar.getText() + "%';");
    }//GEN-LAST:event_txtBuscarKeyReleased

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluirEquipamento;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JButton jBtnSair;
    private javax.swing.JComboBox jComboBoxFabricante;
    private javax.swing.JComboBox jComboBoxFornecedor;
    private javax.swing.JComboBox jComboBoxModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListarEquipamento;
    private javax.swing.JTextField txtBuscar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
