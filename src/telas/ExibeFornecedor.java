package telas;

import static funcoes.Conexao.getConnection;
import funcoes.ModeloTabela;
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

public class ExibeFornecedor extends javax.swing.JFrame {

    private static int indice;
    Statement stmt;
    private String opcaoPesquisa = "fornecedor";
    private Menu telaMenu;

    public ExibeFornecedor() {
        initComponents();
        TabelaFornecedor("select  * from vw_fornecedores;");
    }

    public ExibeFornecedor(Menu menu) {
        this.telaMenu = menu;
        initComponents();
        TabelaFornecedor("select  * from vw_fornecedores;");
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
        jLabel1 = new javax.swing.JLabel();
        jComboUf = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListarFornecedores = new javax.swing.JTable();
        jComboBoxOpcaoPesquisa = new javax.swing.JComboBox();
        txtBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jBtnNovoFornecedor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jBtnVoltar = new javax.swing.JButton();
        jBtnDetalhar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Raavi", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fornecedor.png"))); // NOI18N
        jLabel1.setText("Fornecedores");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 30));

        jComboUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o estado", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jComboUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboUfActionPerformed(evt);
            }
        });
        jPanel1.add(jComboUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 270, -1));

        jTableListarFornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableListarFornecedores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 660, 400));

        jComboBoxOpcaoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione a opção de pesquisa", "Código", "Fornecedor", "CEP" }));
        jComboBoxOpcaoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOpcaoPesquisaActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxOpcaoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 270, -1));

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
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 255, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/find.png"))); // NOI18N
        jLabel3.setText("Filtrar:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 20));

        jBtnNovoFornecedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnNovoFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fornecedoradd2.fw.png"))); // NOI18N
        jBtnNovoFornecedor.setText("Novo");
        jBtnNovoFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoFornecedorActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnNovoFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, 133, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.gif"))); // NOI18N
        jLabel2.setText("Pesquisar por:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        jBtnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        jBtnVoltar.setText("Voltar");
        jBtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, -1));

        jBtnDetalhar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnDetalhar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fornecedorConsulta.fw.png"))); // NOI18N
        jBtnDetalhar.setText("Detalhar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarFornecedores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnDetalhar, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnDetalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDetalharActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnDetalhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 860, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static int GetIndiceForn() {
        return indice;
    }

    public void CodigoFornecedor() {
        if (jTableListarFornecedores.getSelectedRow() != -1) {
            int linha = jTableListarFornecedores.getSelectedRow();
            indice = (Integer.parseInt(jTableListarFornecedores.getValueAt(linha, 0).toString()));
        } else {
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro.");
        }
    }

    public void TabelaFornecedor(String Sql) {

        try {

            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();
            String[] Colunas = {"Código", "Fornecedor", "CEP", "Estado"};

            ResultSet rs;
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                dados.add(new Object[]{
                    rs.getObject("id_forn"),
                    rs.getObject("fornecedor"),
                    rs.getObject("cep"),
                    rs.getObject("estado")});
            }

            for (int i = 0; i < 4; i++) {

                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarFornecedores.setModel(modelo);
                TableCellRenderer renderer = new TabelaZebrada();
                jTableListarFornecedores.setDefaultRenderer(Object.class, renderer);

                jTableListarFornecedores.getColumnModel().getColumn(0).setPreferredWidth(50);
                jTableListarFornecedores.getColumnModel().getColumn(1).setPreferredWidth(200);
                jTableListarFornecedores.getColumnModel().getColumn(2).setPreferredWidth(80);
                jTableListarFornecedores.getColumnModel().getColumn(3).setPreferredWidth(15);
                jTableListarFornecedores.getColumnModel().getColumn(i).setResizable(false);
                jTableListarFornecedores.getTableHeader().setReorderingAllowed(false);
                jTableListarFornecedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception erro) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    private void jBtnNovoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoFornecedorActionPerformed
        this.setVisible(false);
        new CadastrarFornecedor(this).setVisible(true);
    }//GEN-LAST:event_jBtnNovoFornecedorActionPerformed

    private void jBtnDetalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDetalharActionPerformed
        CodigoFornecedor();
        this.setVisible(false);
        new DetalharFornecedor(this).setVisible(true);
    }//GEN-LAST:event_jBtnDetalharActionPerformed

    private void jComboBoxOpcaoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOpcaoPesquisaActionPerformed
        switch (jComboBoxOpcaoPesquisa.getSelectedItem().toString()) {
            case "Código":
                opcaoPesquisa = "id_forn";
                break;
            case "Fornecedor":
                opcaoPesquisa = "fornecedor";
                break;
            case "CEP":
                opcaoPesquisa = "cep";
                break;
            case "Selecione a opção de pesquisa":
                TabelaFornecedor("select  * from vw_fornecedores;");
                break;
        }
    }//GEN-LAST:event_jComboBoxOpcaoPesquisaActionPerformed

    private void jComboUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboUfActionPerformed

        if (jComboUf.getSelectedIndex() == 0) {

            TabelaFornecedor("select  * from vw_fornecedores where " + opcaoPesquisa
                    + " like '%" + txtBuscar.getText().trim() + "%';");
        } else {
            TabelaFornecedor("select  * from vw_fornecedores where " + opcaoPesquisa
                    + " like '%" + txtBuscar.getText().trim() + "%' "
                    + "and estado = '" + jComboUf.getSelectedItem().toString() + "';");
        }
    }//GEN-LAST:event_jComboUfActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        TabelaFornecedor("select  * from vw_fornecedores where " + opcaoPesquisa
                + " like '%" + txtBuscar.getText().trim() + "%';");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void jBtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarActionPerformed
        verificaPagina();
        this.dispose();
    }//GEN-LAST:event_jBtnVoltarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void verificaPagina() {

        if ((this.telaMenu != null)) {
            this.telaMenu.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnDetalhar;
    private javax.swing.JButton jBtnNovoFornecedor;
    private javax.swing.JButton jBtnVoltar;
    private javax.swing.JComboBox jComboBoxOpcaoPesquisa;
    private javax.swing.JComboBox jComboUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListarFornecedores;
    private javax.swing.JTextField txtBuscar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
