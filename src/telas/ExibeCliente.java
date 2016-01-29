package telas;

import atributos.Cliente;
import funcoes.ClienteDAO;
import funcoes.Conexao;
import static funcoes.Conexao.getConnection;
import funcoes.ModeloTabela;
import funcoes.TabelaZebrada;
import java.awt.Color;
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
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author S015365 pfc2senai@gmail.com
 *
 */
public final class ExibeCliente extends javax.swing.JFrame {

    Statement stmt;
    Cliente cliente = new Cliente();
    private static int indice;
    private static int idCntato;
    private PreparedStatement pst;
    private int codSetor;
    private int linhaTabela;
    String opcaoPesquisa = "empresa";
    private Menu telaMenu;

    /**
     * Creates new form CadastroDeFuncionarios
     */
    public ExibeCliente() {
        initComponents();
        populaComboBox();
        botoes();
        TabelaCliente("select  * from vw_cliente;");
    }
    
    public ExibeCliente(Menu menu) {
        this.telaMenu = menu;
        initComponents();
        populaComboBox();
        botoes();
        TabelaCliente("select  * from vw_cliente;");
    }

    public static int GetIndice() {
        return indice;
    }
    
    private void botoes() {
        
        jBtnLembrete.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnLembrete.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnRotinaContato.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnRotinaContato.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnEditar.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnCadastrarNovoCliente.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnCadastrarNovoCliente.setHorizontalTextPosition(SwingConstants.CENTER);
    }

    public boolean CodigoCliente() {

        boolean valida = false;

        if (jTableListarClientes.getSelectedRow() != -1) {
            valida = true;
            //this.dispose();
            int linha = jTableListarClientes.getSelectedRow();
            indice = (Integer.parseInt(jTableListarClientes.getValueAt(linha, 0).toString()));
        } else {
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro.");
        }
        return valida;
    }

    public void TabelaCliente(String Sql) {

        try {

            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();
            String[] Colunas = {"Código", "Empresa", "CNPJ", "Setor", "Estado"};

            ResultSet rs;
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                dados.add(new Object[]{
                    rs.getObject("idCliente"), 
                    rs.getObject("empresa"),
                    rs.getObject("cnpj"), 
                    rs.getObject("setor"),
                    rs.getObject("estado")});
            }

            for (int i = 0; i < 5; i++) {
                
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarClientes.setModel(modelo);
                
                TableCellRenderer renderer = new TabelaZebrada();
                jTableListarClientes.setDefaultRenderer(Object.class, renderer);
                
                jTableListarClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
                jTableListarClientes.getColumnModel().getColumn(1).setPreferredWidth(200);
                jTableListarClientes.getColumnModel().getColumn(2).setPreferredWidth(80);
                jTableListarClientes.getColumnModel().getColumn(3).setPreferredWidth(80);
                jTableListarClientes.getColumnModel().getColumn(4).setPreferredWidth(10); 
                jTableListarClientes.getColumnModel().getColumn(i).setResizable(false);
                jTableListarClientes.getTableHeader().setReorderingAllowed(false);
              //  jTableListarClientes.setAutoResizeMode(jTableListarClientes.AUTO_RESIZE_OFF);
                jTableListarClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception erro) {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListarClientes = new javax.swing.JTable();
        jBtnCadastrarNovoCliente = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jBtnLembrete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxSetores = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboUf = new javax.swing.JComboBox();
        jComboBoxOpcaoPesquisa = new javax.swing.JComboBox();
        jBtnBuscar = new javax.swing.JButton();
        jBtnRotinaContato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cadastro de Clientes");

        jTableListarClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableListarClientes);

        jBtnCadastrarNovoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cliente2.fw.png"))); // NOI18N
        jBtnCadastrarNovoCliente.setText("Novo");
        jBtnCadastrarNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarNovoClienteActionPerformed(evt);
            }
        });

        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cliente3.fw.png"))); // NOI18N
        jBtnEditar.setText("Detalhar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarClientes, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnEditar, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/arrow_rotate_clockwise.png"))); // NOI18N
        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jBtnLembrete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CadastrarLembrete.png"))); // NOI18N
        jBtnLembrete.setText("Lembrete");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarClientes, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnLembrete, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLembreteActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisar:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel4.setText("Filtrar:");

        jComboBoxSetores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSetoresActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado:");

        jComboUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jComboUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboUfActionPerformed(evt);
            }
        });

        jComboBoxOpcaoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione a opção de pesquisa", "Código", "Nome", "CNPJ" }));
        jComboBoxOpcaoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOpcaoPesquisaActionPerformed(evt);
            }
        });

        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.gif"))); // NOI18N
        jBtnBuscar.setText("Buscar");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        jBtnRotinaContato.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnRotinaContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1452414361_kontact_1.png"))); // NOI18N
        jBtnRotinaContato.setText("Rotina de Contato");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarClientes, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnRotinaContato, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnRotinaContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRotinaContatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBoxSetores, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxOpcaoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboUf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnBuscar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnRotinaContato, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnLembrete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnCadastrarNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOpcaoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBuscar)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSetores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnCadastrarNovoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnLembrete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnRotinaContato))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(28, 28, 28))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed

        if (CodigoCliente()) {
            new DetalharCliente().setVisible(true);
        }
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLembreteActionPerformed

        if (CodigoCliente()) {
            new CadastrarLembrete(indice).setVisible(true);
        }
    }//GEN-LAST:event_jBtnLembreteActionPerformed

    private void jBtnCadastrarNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastrarNovoClienteActionPerformed
        this.setEnabled(false);
        new CadastrarCliente(this).setVisible(true);
    }//GEN-LAST:event_jBtnCadastrarNovoClienteActionPerformed

    private void jComboBoxSetoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSetoresActionPerformed
        
        if (jComboUf.getSelectedIndex() != 0) {
            
            TabelaCliente("select  * from vw_cliente where " + opcaoPesquisa
                    + " like '%" + txtBuscar.getText() + "%' "
                    + "and setor = '" + jComboBoxSetores.getSelectedItem().toString() + "' "
                    + "and estado = '" + jComboUf.getSelectedItem().toString() + "';");
        
        }else if (jComboUf.getSelectedIndex() == 0) {
            
            TabelaCliente("select  * from vw_cliente where " + opcaoPesquisa
                    + " like '%" + txtBuscar.getText() + "%' "
                    + "and setor = '" + jComboBoxSetores.getSelectedItem().toString() + "' ;");
        
        }
        
        if (jComboUf.getSelectedIndex() != 0 && jComboBoxSetores.getSelectedIndex() == 0) {
            
            TabelaCliente("select  * from vw_cliente where " + opcaoPesquisa
                    + " like '%" + txtBuscar.getText() + "%' "
                    + "and estado = '" + jComboUf.getSelectedItem().toString() + "';");
        }
        
        if (jComboUf.getSelectedIndex() == 0 && jComboBoxSetores.getSelectedIndex() == 0) {
            
            TabelaCliente("select  * from vw_cliente where " + opcaoPesquisa
                    + " like '%" + txtBuscar.getText() + "%';");
        }

    }//GEN-LAST:event_jComboBoxSetoresActionPerformed

    private void jComboBoxOpcaoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOpcaoPesquisaActionPerformed
        switch (jComboBoxOpcaoPesquisa.getSelectedItem().toString()) {
            case "Código":
                opcaoPesquisa = "idcliente";
                linhaTabela = 0;
                break;
            case "Nome":
                opcaoPesquisa = "empresa";
                linhaTabela = 1;
                break;
            case "CNPJ":
                opcaoPesquisa = "cnpj";
                linhaTabela = 2;
                break;
        }
    }//GEN-LAST:event_jComboBoxOpcaoPesquisaActionPerformed

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed

        int posi = 0;
        boolean valida = false;

        for (int j = 0; j < jTableListarClientes.getRowCount(); j++) {

            if (jComboBoxSetores.getSelectedItem().toString().equalsIgnoreCase(jTableListarClientes.getValueAt(j, 3).toString())) {
                valida = true;
                posi = j;
                break;
            } else {
                valida = false;
            }
        }

        if (valida) {
            jTableListarClientes.getSelectionModel().setSelectionInterval(posi, posi);
            jTableListarClientes.setSelectionBackground(Color.green);
        }
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jComboUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboUfActionPerformed

        if (jComboBoxSetores.getSelectedIndex() != 0) {
            
            TabelaCliente("select  * from vw_cliente where " + opcaoPesquisa
                    + " like '%" + txtBuscar.getText() + "%' "
                    + "and setor = '" + jComboBoxSetores.getSelectedItem().toString() + "' "
                    + "and estado = '" + jComboUf.getSelectedItem().toString() + "';");
            
        } else if (jComboBoxSetores.getSelectedIndex() == 0) {
            
            TabelaCliente("select  * from vw_cliente where " + opcaoPesquisa
                    + " like '%" + txtBuscar.getText() + "%' "
                    + "and estado = '" + jComboUf.getSelectedItem().toString() + "';");
            
        }
        
        if (jComboBoxSetores.getSelectedIndex() != 0 && jComboUf.getSelectedIndex() == 0) {
            
            TabelaCliente("select  * from vw_cliente where " + opcaoPesquisa
                    + " like '%" + txtBuscar.getText() + "%' "
                    + "and setor = '" + jComboBoxSetores.getSelectedItem().toString() + "' ;");
        }
        if (jComboBoxSetores.getSelectedIndex() == 0 && jComboUf.getSelectedIndex() == 0) {
            
            TabelaCliente("select  * from vw_cliente where " + opcaoPesquisa
                    + " like '%" + txtBuscar.getText() + "%';");
        }
    }//GEN-LAST:event_jComboUfActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        TabelaCliente("select  * from vw_cliente where " + opcaoPesquisa
                + " like '%" + txtBuscar.getText() + "%';");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jBtnRotinaContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRotinaContatoActionPerformed
        if (CodigoCliente()) {
            new CadastrarRotinaContato(indice).setVisible(true);
        }             
    }//GEN-LAST:event_jBtnRotinaContatoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        verificaPagina();
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void populaComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabSetor";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            jComboBoxSetores.addItem("Selecione o Setor");
            while (rs.next()) {
                jComboBoxSetores.addItem(rs.getString("setor"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void verificaPagina() {

        if ((this.telaMenu != null)) {
            this.telaMenu.setEnabled(true);
            this.telaMenu.toFront();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnCadastrarNovoCliente;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnLembrete;
    private javax.swing.JButton jBtnRotinaContato;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBoxOpcaoPesquisa;
    private javax.swing.JComboBox jComboBoxSetores;
    private javax.swing.JComboBox jComboUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListarClientes;
    private javax.swing.JTextField txtBuscar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
