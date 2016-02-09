package telas;

import atributos.DetServicoTipoServ;
import atributos.TipoServico;
import componentes.UJComboBox;
import funcoes.Conexao;
import funcoes.DetServicoTipoDAO;
import funcoes.TabelaZebrada;
import funcoes.TipoServicoDAO;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Josy
 */
public class AdicionarDetServTipoServico extends javax.swing.JFrame {

    private PreparedStatement pst;

    private int idServico;
    private DetalharServico telaDatalharServico;

    private int codTipoServico;
    private String tipoServico;

    /**
     * Creates new form AdicionarDetServTipoServico
     */
    public AdicionarDetServTipoServico() {
        initComponents();
    }

    public AdicionarDetServTipoServico(int idServ, DetalharServico telaDetalharServ) {
        this.idServico = idServ;
        this.telaDatalharServico = telaDetalharServ;
        initComponents();
        ocultaTabela();
        carregarComboTipoServico();
        jComboBoxTipoServico1.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codTipoServico == 0 && jComboBoxTipoServico1.getSelectedIndex() != 0) {
                    JOptionPane.showMessageDialog(null, "Esse registro não encontra-se cadastrado na base de dados.");
                    jComboBoxTipoServico1.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        jComboBoxTipoServico1.setAutocompletar(true);
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

        jPanel1 = new javax.swing.JPanel();
        jBtnAdicionarTipo = new javax.swing.JButton();
        jBtnSalvarDetServTipoServico = new javax.swing.JButton();
        jBtbNovoTipoServico = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableTipodeServico = new javax.swing.JTable();
        jBtnRemoverTipo = new javax.swing.JButton();
        jBtnCadTipoServico = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jBtnCancelarCadTipoServico = new javax.swing.JButton();
        txtTipoServico = new javax.swing.JTextField();
        jComboBoxTipoServico1 = new componentes.UJComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jBtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADCIONAR SERVIÇO");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(254, 254, 233));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnAdicionarTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jBtnAdicionarTipo.setText("Adicionar Tipo");
        jBtnAdicionarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionarTipoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnAdicionarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 130, -1));

        jBtnSalvarDetServTipoServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jBtnSalvarDetServTipoServico.setText("Salvar");
        jBtnSalvarDetServTipoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarDetServTipoServicoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnSalvarDetServTipoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 90, -1));

        jBtbNovoTipoServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page.png"))); // NOI18N
        jBtbNovoTipoServico.setText("Novo");
        jBtbNovoTipoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbNovoTipoServicoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtbNovoTipoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        jTableTipodeServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo Serviço"
            }
        ));
        jTableTipodeServico.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTableTipodeServico);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 600, 130));

        jBtnRemoverTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jBtnRemoverTipo.setText("Remover Tipo");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableTipodeServico, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnRemoverTipo, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnRemoverTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverTipoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnRemoverTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, -1, -1));

        jBtnCadTipoServico.setText("Salvar");
        jBtnCadTipoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadTipoServicoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnCadTipoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 70, -1));

        jLabel10.setText("Tipo:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jBtnCancelarCadTipoServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelarCadTipoServico.setText("Cancelar");
        jBtnCancelarCadTipoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarCadTipoServicoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnCancelarCadTipoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, -1, -1));
        jPanel1.add(txtTipoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 240, -1));

        jComboBoxTipoServico1.setEditable(true);
        jComboBoxTipoServico1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoServico1ItemStateChanged(evt);
            }
        });
        jComboBoxTipoServico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoServico1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxTipoServico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 260, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        jLabel2.setText("ADCIONAR SERVIÇO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, -1));

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtbNovoTipoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbNovoTipoServicoActionPerformed

        txtTipoServico.setVisible(true);
        jComboBoxTipoServico1.setVisible(false);
        jBtbNovoTipoServico.setVisible(false);
        jBtnCadTipoServico.setVisible(true);
        jBtnCancelarCadTipoServico.setVisible(true);
        txtTipoServico.setEnabled(true);
    }//GEN-LAST:event_jBtbNovoTipoServicoActionPerformed

    private void jBtnCadTipoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadTipoServicoActionPerformed

        TipoServico tServ = new TipoServico();

        tServ.setTipo(txtTipoServico.getText());

        codTipoServico = TipoServicoDAO.CadTipoServico(tServ);

        txtTipoServico.setVisible(false);
        jComboBoxTipoServico1.setVisible(true);

        jBtnCadTipoServico.setVisible(false);
        jBtnCancelarCadTipoServico.setVisible(false);
        jBtbNovoTipoServico.setVisible(true);

        jComboBoxTipoServico1.removeAllItems();
        carregarComboTipoServico();
        jComboBoxTipoServico1.setSelectedItem(tServ.getTipo());
    }//GEN-LAST:event_jBtnCadTipoServicoActionPerformed

    private void jBtnCancelarCadTipoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarCadTipoServicoActionPerformed
        jBtnCadTipoServico.setVisible(false);
        jBtnCancelarCadTipoServico.setVisible(false);

        jBtbNovoTipoServico.setVisible(true);
        txtTipoServico.setVisible(false);
        jComboBoxTipoServico1.setVisible(true);
    }//GEN-LAST:event_jBtnCancelarCadTipoServicoActionPerformed

    private void jBtnAdicionarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionarTipoActionPerformed
        TabelaTipoServico();
    }//GEN-LAST:event_jBtnAdicionarTipoActionPerformed

    private void jBtnRemoverTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoverTipoActionPerformed

        DefaultTableModel dtm = (DefaultTableModel) jTableTipodeServico.getModel();
        int linha = jTableTipodeServico.getSelectedRow();

        if (linha != -1) {
            dtm.removeRow(linha);
        }
    }//GEN-LAST:event_jBtnRemoverTipoActionPerformed

    private void jBtnSalvarDetServTipoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarDetServTipoServicoActionPerformed

        DetServicoTipoServ ServTipo = new DetServicoTipoServ();
        for (int j = 0; j < jTableTipodeServico.getRowCount(); j++) {

            ServTipo.setCodServico(idServico);
            ServTipo.setCodTipo(Integer.parseInt(jTableTipodeServico.getValueAt(j, 0).toString()));

            DetServicoTipoDAO.CadDetServTipoServ(ServTipo);
        }
        telaDatalharServico.TabelaTipoServico();
        verificaPagina();
        this.dispose();    
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
    }//GEN-LAST:event_jBtnSalvarDetServTipoServicoActionPerformed

    private void jComboBoxTipoServico1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoServico1ItemStateChanged
        codTipoServico = 0;
        idTipoServicoComboBox();
        if (jComboBoxTipoServico1.getSelectedItem() != null) {
            tipoServico = jComboBoxTipoServico1.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboBoxTipoServico1ItemStateChanged

    private void jComboBoxTipoServico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoServico1ActionPerformed

    }//GEN-LAST:event_jComboBoxTipoServico1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        this.dispose();
        verificaPagina();
         if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair? Os dados não serão salvos.", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
         }
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    public void TabelaTipoServico() {

        try {

            DefaultTableModel dtm = (DefaultTableModel) jTableTipodeServico.getModel();

            dtm.addRow(new Object[]{codTipoServico, tipoServico});

            TableCellRenderer renderer = new TabelaZebrada();
            jTableTipodeServico.setDefaultRenderer(Object.class, renderer);

        } catch (Exception erro) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    private void carregarComboTipoServico() {

        // jComboBoxTipoServico.clear();
        ArrayList<TipoServico> tipoServico = new ArrayList<TipoServico>();
        tipoServico = TipoServicoDAO.ListarTipoServico();

        jComboBoxTipoServico1.addItem("Selecione um tipo");
        for (TipoServico tServ : tipoServico) {
            jComboBoxTipoServico1.addItem(tServ.getTipo(), tServ);
        }
    }

    private void idTipoServicoComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabtipo_serv where Tipo_serv = '" + jComboBoxTipoServico1.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codTipoServico = (rs.getInt("idtabTipo_serv"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void ocultaTabela() {
        jTableTipodeServico.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableTipodeServico.getColumnModel().getColumn(0).setMinWidth(0);
        jTableTipodeServico.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTableTipodeServico.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }
    
    private void verificaPagina() {

        if ((this.telaDatalharServico != null)) {
            this.telaDatalharServico.setEnabled(true);
            this.telaDatalharServico.toFront();
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbNovoTipoServico;
    private javax.swing.JButton jBtnAdicionarTipo;
    private javax.swing.JButton jBtnCadTipoServico;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnCancelarCadTipoServico;
    private javax.swing.JButton jBtnRemoverTipo;
    private javax.swing.JButton jBtnSalvarDetServTipoServico;
    private componentes.UJComboBox jComboBoxTipoServico1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTableTipodeServico;
    private javax.swing.JTextField txtTipoServico;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
