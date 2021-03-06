package telas;

import atributos.Funcionario;
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
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;


public class ExibeFuncionario extends javax.swing.JFrame {

    Statement stmt;
    Funcionario funcionario = new Funcionario();
    private static int indice;
    private static int idContato;
    String opcaoPesquisa = "funcionario";
    private Menu telaMenu;

    public ExibeFuncionario() {
        initComponents();
        TabelaFuncionario("select * from tabfuncionario;");
        txtBuscar.setVisible(true);
        txtRg.setVisible(false);
        txtCpf.setVisible(false);
        botoes();
    }
    
    public ExibeFuncionario(Menu menu) {
        this.telaMenu = menu;
        initComponents();
        TabelaFuncionario("select * from tabfuncionario;");
        txtBuscar.setVisible(true);
        txtRg.setVisible(false);
        txtCpf.setVisible(false);
        botoes();
    }

    private void botoes() {
        
        jBtnNovoFuncionario.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnNovoFuncionario.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnDetalharFuncionario.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnDetalharFuncionario.setHorizontalTextPosition(SwingConstants.CENTER);        
    }
    
    public static int GetIndice() {
        return indice;
    }

    public void TabelaFuncionario(String Sql) {

        try {
            
            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();
            String[] Colunas = {"Código", "Funcionário", "RG", "CPF", "Cargo", "Data de Admissão"};

            ResultSet rs;
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                dados.add(new Object[]{
                    rs.getObject("idfuncionario"), 
                    rs.getObject("funcionario"),
                    rs.getObject("rg"), 
                    rs.getObject("cpf"), 
                    rs.getObject("cargo"),
                    rs.getObject("data_admissao")});
            }

            for (int i = 0; i < 6; i++) {
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarFuncionarios.setModel(modelo);
                TableCellRenderer renderer = new TabelaZebrada();
                jTableListarFuncionarios.setDefaultRenderer(Object.class, renderer);
                
                jTableListarFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(60);
                jTableListarFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(200);
                jTableListarFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(90);
                jTableListarFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(90);
                jTableListarFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(150);
                jTableListarFuncionarios.getColumnModel().getColumn(5).setPreferredWidth(90);
                
                jTableListarFuncionarios.getColumnModel().getColumn(i).setResizable(false);
                jTableListarFuncionarios.getTableHeader().setReorderingAllowed(false);
                jTableListarFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jBtnNovoFuncionario = new javax.swing.JButton();
        jBtnDetalharFuncionario = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListarFuncionarios = new javax.swing.JTable();
        jComboBoxOpcaoPesquisa = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtRg = new javax.swing.JFormattedTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        txtBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnNovoFuncionario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnNovoFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/funcionarioadd.fw.png"))); // NOI18N
        jBtnNovoFuncionario.setText("Novo");
        jBtnNovoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoFuncionarioActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnNovoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 120, -1));

        jBtnDetalharFuncionario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnDetalharFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/funcionarioConsulta.fw.png"))); // NOI18N
        jBtnDetalharFuncionario.setText("Detalhar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarFuncionarios, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnDetalharFuncionario, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnDetalharFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDetalharFuncionarioActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnDetalharFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, 120, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, -1, -1));

        jTableListarFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableListarFuncionarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 580, 370));

        jComboBoxOpcaoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione a opção de pesquisa", "Código", "Funcionário", "CPF", "RG" }));
        jComboBoxOpcaoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOpcaoPesquisaActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxOpcaoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel2.setText("Pesquisar:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel1.setFont(new java.awt.Font("Raavi", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/funcionario.png"))); // NOI18N
        jLabel1.setText("FUNCIONÁRIOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 30));

        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRgKeyReleased(evt);
            }
        });
        jPanel1.add(txtRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 103, -1));

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCpfKeyReleased(evt);
            }
        });
        jPanel1.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 101, -1));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 300, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 850, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnNovoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoFuncionarioActionPerformed
        this.setVisible(false);
        new CadastrarFuncionario(this).setVisible(true);
    }//GEN-LAST:event_jBtnNovoFuncionarioActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        verificaPagina();
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jBtnDetalharFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDetalharFuncionarioActionPerformed
        if (jTableListarFuncionarios.getSelectedRow() != -1) {
            int linha = jTableListarFuncionarios.getSelectedRow();
            indice = (Integer.parseInt(jTableListarFuncionarios.getValueAt(linha, 0).toString()));
            this.setVisible(false);
            new AlterarFuncionario(this).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro.");
        }
    }//GEN-LAST:event_jBtnDetalharFuncionarioActionPerformed

    private void jComboBoxOpcaoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOpcaoPesquisaActionPerformed

        switch (jComboBoxOpcaoPesquisa.getSelectedItem().toString()) {
            case "Código":
                opcaoPesquisa = "idfuncionario";
                txtBuscar.setVisible(true);
                txtRg.setVisible(false);
                txtCpf.setVisible(false);
                break;
            case "Funcionário":
                opcaoPesquisa = "funcionario";
                txtBuscar.setVisible(true);
                txtRg.setVisible(false);
                txtCpf.setVisible(false);
                break;
            case "CPF":
                txtBuscar.setVisible(false);
                txtRg.setVisible(false);
                txtCpf.setVisible(true);
                break;
            case "RG":
                txtBuscar.setVisible(false);
                txtRg.setVisible(true);
                txtCpf.setVisible(false);
                break;
            case "Selecione a opção de pesquisa":
                TabelaFuncionario("select * from tabfuncionario;");
                break;
        }
    }//GEN-LAST:event_jComboBoxOpcaoPesquisaActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        TabelaFuncionario("select  * from tabfuncionario where " + opcaoPesquisa
                + " like '%" + txtBuscar.getText().trim() + "%';");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtRgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRgKeyReleased
        if (txtRg.getText().trim().length() == 13) {
            TabelaFuncionario("select  * from tabfuncionario where rg like '%" + txtRg.getText().trim() + "%';");
        }else{
            TabelaFuncionario("select * from tabfuncionario;");
        }                
    }//GEN-LAST:event_txtRgKeyReleased

    private void txtCpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyReleased
        if (txtCpf.getText().trim().length() == 14) {
            TabelaFuncionario("select  * from tabfuncionario where cpf like '%" + txtCpf.getText().trim() + "%';");
        }else {
            TabelaFuncionario("select * from tabfuncionario;");
        }     
    }//GEN-LAST:event_txtCpfKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void verificaPagina() {
        if ((this.telaMenu != null)) {
            this.telaMenu.setVisible(true);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnDetalharFuncionario;
    private javax.swing.JButton jBtnNovoFuncionario;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBoxOpcaoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListarFuncionarios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtRg;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
