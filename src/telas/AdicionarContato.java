package telas;

import atributos.PessoaContato;
import atributos.Telefone;
import funcoes.ContatosDAO;
import funcoes.PessoaContatoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josy
 */
public class AdicionarContato extends javax.swing.JFrame {

    private DetalharCliente telaDetCliente;
    private int codCliente;

    private DetalharFornecedor telaDetFornecedor;
    private int codFornecedor;

    public AdicionarContato() {
        initComponents();
    }

    public AdicionarContato(DetalharCliente detCli, int codCli) {
        this.telaDetCliente = detCli;
        this.codCliente = codCli;
        initComponents();
    }

    public AdicionarContato(DetalharFornecedor detForn, int codForn) {
        this.telaDetFornecedor = detForn;
        this.codFornecedor = codForn;
        initComponents();
        jTableContatos.getColumnModel().getColumn(4).setMaxWidth(0);
        jTableContatos.getColumnModel().getColumn(4).setMinWidth(0);
        jTableContatos.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        jTableContatos.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        txtContato = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jBtnRemoverContato = new javax.swing.JButton();
        jComboBoxSetorContato = new javax.swing.JComboBox();
        txtTelCel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContatos = new javax.swing.JTable();
        txtTel01 = new javax.swing.JFormattedTextField();
        jBtnOutroContato = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBtnCadastrarContato = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADCIONAR CONTATO");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(254, 254, 233));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(254, 254, 233));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/phone.png"))); // NOI18N
        jLabel13.setText("Celular:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/funcionario.png"))); // NOI18N
        jLabel5.setText("Contato:");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/telephone.png"))); // NOI18N
        jLabel7.setText("Telefone:");

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(255, 0, 0));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/setor.png"))); // NOI18N
        jLabel16.setText("Setor:");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/email.png"))); // NOI18N
        jLabel9.setText("Email:");

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        jBtnRemoverContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jBtnRemoverContato.setText("Remover contato");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableContatos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnRemoverContato, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnRemoverContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverContatoActionPerformed(evt);
            }
        });

        jComboBoxSetorContato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o setor", "Manutenção", "Compras", "Suprimentos", "Projetos", "Engenharia", "Compras/Suprimentos", "Projetos/Engenharia" }));

        txtTelCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelCelKeyTyped(evt);
            }
        });

        jTableContatos.setBackground(new java.awt.Color(254, 254, 233));
        jTableContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Contato", "Telefone", "Celular", "Email", "Setor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableContatos);

        try {
            txtTel01.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jBtnOutroContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jBtnOutroContato.setText("Adicionar contato");
        jBtnOutroContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOutroContatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnRemoverContato))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtTel01, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBoxSetorContato, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnOutroContato)))))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtTel01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxSetorContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtnOutroContato)
                        .addGap(11, 11, 11)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jBtnRemoverContato)
                .addContainerGap())
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 790, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Adicionar Contato");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jBtnCadastrarContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        jBtnCadastrarContato.setText("Cadastrar");
        jBtnCadastrarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarContatoActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnCadastrarContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, -1, -1));

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/stop2.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 850, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnOutroContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOutroContatoActionPerformed
        if (VerificaCamposContato()) {
            TabelaContatos();
        } else {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
        }
    }//GEN-LAST:event_jBtnOutroContatoActionPerformed

    private void txtTelCelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelCelKeyTyped

        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelCelKeyTyped

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        ValidaEmail();
    }//GEN-LAST:event_txtEmailFocusLost

    private void jBtnRemoverContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoverContatoActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION) == 1) {

        } else {
            DefaultTableModel dtm = (DefaultTableModel) jTableContatos.getModel();
            int linha = jTableContatos.getSelectedRow();

            if (linha != -1) {
                dtm.removeRow(linha);
            }
        }
    }//GEN-LAST:event_jBtnRemoverContatoActionPerformed

    private void jBtnCadastrarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastrarContatoActionPerformed
        if (jTableContatos.getRowCount() < 1) {
            JOptionPane.showMessageDialog(null, "Adicione um contato na Tabela!");
        }else {
            CadastrarContato();
            ((DefaultTableModel) jTableContatos.getModel()).setNumRows(0);
            jTableContatos.updateUI();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }
    }//GEN-LAST:event_jBtnCadastrarContatoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair? Os dados não serão salvos.", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 1 ) {           
        }else {
            verificaPagina();
            this.dispose();
        }
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private boolean VerificaCamposContato() {

        boolean valida = true;

        if (txtContato.getText().trim().equals("")) {
            valida = false;
            return valida;
        }

        if (txtTelCel.getText().trim().equals("")) {
            valida = false;
            return valida;
        }

        if (txtTel01.getText().trim().length() != 13) {
            valida = false;
            return valida;
        }

        if (ValidaEmail()) {
            valida = false;
            return valida;
        }

        if (jComboBoxSetorContato.getSelectedIndex() == 0) {
            valida = false;
            return valida;
        }

        return valida;
    }

    private void CadastrarContato() {

        if ((this.telaDetCliente != null)) {
            Telefone tel = new Telefone();
            PessoaContato pContato = new PessoaContato();
            String email;

            for (int j = 0; j < jTableContatos.getRowCount(); j++) {

                pContato.setNomeContato(jTableContatos.getValueAt(j, 0).toString());
                tel.setTel(jTableContatos.getValueAt(j, 1).toString());
                tel.setCel(jTableContatos.getValueAt(j, 2).toString());
                email = jTableContatos.getValueAt(j, 3).toString();
                pContato.setSetorContato(jTableContatos.getValueAt(j, 4).toString());

                int codContato = ContatosDAO.CadContato();

                ContatosDAO.CadTel(codContato, tel);
                ContatosDAO.CadEmail(codContato, email);
                pContato.setCodTabEstrangeira(codCliente);
                pContato.setCodContato(codContato);

                PessoaContatoDAO.CadPessoaContato(pContato);
            }

        } else if (this.telaDetFornecedor != null) {

            Telefone tel = new Telefone();
            PessoaContato pContato = new PessoaContato();
            String email;

            for (int j = 0; j < jTableContatos.getRowCount(); j++) {

                pContato.setNomeContato(jTableContatos.getValueAt(j, 0).toString());
                tel.setTel(jTableContatos.getValueAt(j, 1).toString());
                tel.setCel(jTableContatos.getValueAt(j, 2).toString());
                email = jTableContatos.getValueAt(j, 3).toString();

                int codContato = ContatosDAO.CadContato();

                ContatosDAO.CadTel(codContato, tel);
                ContatosDAO.CadEmail(codContato, email);
                pContato.setCodTabEstrangeira(codFornecedor);
                pContato.setCodContato(codContato);

                PessoaContatoDAO.CadPesContatoFornecedor(pContato);
            }
        } 
        this.dispose();
    }

    private void verificaPagina() {

        if ((this.telaDetCliente != null)) {
            this.telaDetCliente.setEnabled(true);
            this.telaDetCliente.toFront();
            this.telaDetCliente.TabelaContatos();

        } else if (this.telaDetFornecedor != null) {
            this.telaDetFornecedor.setEnabled(true);
            this.telaDetFornecedor.toFront();
            this.telaDetFornecedor.TabelaContatos();
        }
    }

    public void TabelaContatos() {

        try {

            DefaultTableModel dtm = (DefaultTableModel) jTableContatos.getModel();

            dtm.addRow(new Object[]{
                txtContato.getText(),
                txtTel01.getText(),
                txtTelCel.getText(),
                txtEmail.getText(),
                jComboBoxSetorContato.getSelectedItem()});

            txtContato.setText("");
            txtTel01.setText(null);
            txtTelCel.setText(null);
            txtEmail.setText("");
            jComboBoxSetorContato.setSelectedIndex(0);
            txtContato.requestFocus();

        } catch (Exception erro) {
            Logger.getLogger(CadastrarCliente.class
                    .getName()).log(Level.SEVERE, null, erro);
        }
    }

    public boolean ValidaEmail() {

        boolean valida = false;

        if ((txtEmail.getText().contains("@"))
                && (txtEmail.getText().contains("."))
                && (!txtEmail.getText().contains(" "))) {

            String usuario = new String(txtEmail.getText().substring(0,
                    txtEmail.getText().lastIndexOf('@')));

            String dominio = new String(txtEmail.getText().substring(txtEmail.getText().lastIndexOf('@') + 1, txtEmail.getText().length()));

            if ((usuario.length() >= 1) && (!usuario.contains("@"))
                    && (dominio.contains(".")) && (!dominio.contains("@")) && (dominio.indexOf(".")
                    >= 1) && (dominio.lastIndexOf(".") < dominio.length() - 1)) {

                jLabelEmail.setText("");

            } else {

                jLabelEmail.setText("E-mail Inválido");
                valida = true;
            }

        } else {

            jLabelEmail.setText("E-mail Inválido");
            valida = true;
        }
        return valida;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCadastrarContato;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnOutroContato;
    private javax.swing.JButton jBtnRemoverContato;
    private javax.swing.JComboBox jComboBoxSetorContato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContatos;
    private javax.swing.JTextField txtContato;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtTel01;
    private javax.swing.JTextField txtTelCel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
