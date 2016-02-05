package telas;

import static funcoes.Conexao.getConnection;
import funcoes.ModeloTabela;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Josy
 */
public class ExibeServico extends javax.swing.JFrame {

    Statement stmt;
    private int codServico;
    private int dataPesquisa;
    String opcaoPesquisa = "empresa";

    /**
     * Creates new form ExibeServico
     */
    public ExibeServico() {
        initComponents();
        TabelaServico("SELECT * FROM vw_servico;");
        txtDatapesquisa.setVisible(false);
        jBtnBuscar.setVisible(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListarServicos = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBtnDetalhar = new javax.swing.JButton();
        jBtnSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxOpcaoPesquisa = new javax.swing.JComboBox();
        txtDatapesquisa = new com.toedter.calendar.JDateChooser();
        jBtnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableListarServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableListarServicos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 752, 372));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 234, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Serviços");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jBtnDetalhar.setText("Detalhar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarServicos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnDetalhar, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnDetalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDetalharActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnDetalhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 525, -1, -1));

        jBtnSair.setText("Sair");
        jBtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSairActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 525, -1, -1));

        jLabel2.setText("Pesquisar:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jComboBoxOpcaoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione a opção de pesquisa", "Código", "Empresa", "Data Serviço" }));
        jComboBoxOpcaoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOpcaoPesquisaActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxOpcaoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 211, -1));
        jPanel1.add(txtDatapesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 120, -1));

        jBtnBuscar.setText("Buscar");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3-5.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 840, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnDetalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDetalharActionPerformed
        int linha = jTableListarServicos.getSelectedRow();
        codServico = (Integer.parseInt(jTableListarServicos.getValueAt(linha, 0).toString()));
        new DetalharServico(codServico).setVisible(true);
    }//GEN-LAST:event_jBtnDetalharActionPerformed

    private void jBtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSairActionPerformed

    private void jComboBoxOpcaoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOpcaoPesquisaActionPerformed

        
        if (jComboBoxOpcaoPesquisa.getSelectedIndex() == 0) {
            TabelaServico("SELECT * FROM vw_servico;");
        }
        
        switch (jComboBoxOpcaoPesquisa.getSelectedItem().toString()) {

            case "Código":
                opcaoPesquisa = "idservico";
                txtDatapesquisa.setVisible(false);
                jBtnBuscar.setVisible(false);
                txtBuscar.setVisible(true);
                dataPesquisa = 0;
                break;
            case "Empresa":
                opcaoPesquisa = "empresa";
                txtDatapesquisa.setVisible(false);
                jBtnBuscar.setVisible(false);
                txtBuscar.setVisible(true);
                dataPesquisa = 0;
                break;
            case "Data Serviço":
                opcaoPesquisa = "dataServico";
                dataPesquisa = 1;
                txtDatapesquisa.setVisible(true);
                jBtnBuscar.setVisible(true);
                txtBuscar.setVisible(false);
                break;               
        }       

    }//GEN-LAST:event_jComboBoxOpcaoPesquisaActionPerformed

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed

        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");

        String dt1 = formatador.format(txtDatapesquisa.getDate());

        TabelaServico("SELECT * FROM vw_servico where " + opcaoPesquisa
                + " like '%" + dt1 + "%';");
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        
        TabelaServico("SELECT * FROM vw_servico where " + opcaoPesquisa
                + " like '%" + txtBuscar.getText() + "%';");
    }//GEN-LAST:event_txtBuscarKeyReleased

    public void TabelaServico(String Sql) {

        try {

            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();
            String[] Colunas = {"Código", "Cliente", "Valor", "Data"};

            ResultSet rs;
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {

                dados.add(new Object[] {
                    rs.getObject("idservico"),
                    rs.getObject("empresa"),
                    rs.getObject("preco"),
                    rs.getObject("dataServico")
                });
            }

            for (int i = 0; i < 4; i++) {
                
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarServicos.setModel(modelo);
                jTableListarServicos.getColumnModel().getColumn(i).setPreferredWidth(150);
                jTableListarServicos.getColumnModel().getColumn(i).setResizable(false);
                jTableListarServicos.getTableHeader().setReorderingAllowed(false);
                jTableListarServicos.setAutoResizeMode(jTableListarServicos.AUTO_RESIZE_OFF);
                jTableListarServicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExibeServico.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception erro) {
            Logger.getLogger(ExibeServico.class.getName()).log(Level.SEVERE, null, erro);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnDetalhar;
    private javax.swing.JButton jBtnSair;
    private javax.swing.JComboBox jComboBoxOpcaoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListarServicos;
    private javax.swing.JTextField txtBuscar;
    private com.toedter.calendar.JDateChooser txtDatapesquisa;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
