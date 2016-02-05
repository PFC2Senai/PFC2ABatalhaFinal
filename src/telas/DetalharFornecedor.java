package telas;

import atributos.Endereco;
import atributos.Fornecedor;
import funcoes.AuditoriaDAO;
import funcoes.CarregaCEP;
import static funcoes.Conexao.getConnection;
import funcoes.ContatosDAO;
import funcoes.FornecedorDAO;
import funcoes.ModeloTabela;
import funcoes.TabelaZebrada;
import java.awt.Color;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import static telas.ExibeFornecedor.GetIndiceForn;

public class DetalharFornecedor extends javax.swing.JFrame {

    Statement stmt;
    int idContato;
    private int codPessoaContato;
    private int codContato;
    private final int codFornecedor;
    private DetalharFornecedor telaDetFornec;
    private ExibeFornecedor telaExibeForn;

    /**
     * Creates new form DetalharFornecedor
     */
    public DetalharFornecedor() {
        this.codFornecedor = GetIndiceForn();
        this.idContato = FornecedorDAO.idContato(GetIndiceForn());
        telaDetFornec = this;
        initComponents();
        CarregaFornecedor();
        TabelaContatos();
    }
    
    public DetalharFornecedor(ExibeFornecedor exibeForn) {
        this.telaExibeForn = exibeForn;
        this.codFornecedor = GetIndiceForn();
        this.idContato = FornecedorDAO.idContato(GetIndiceForn());
        telaDetFornec = this;
        initComponents();
        CarregaFornecedor();
        TabelaContatos();
    }

    private void OcultaBotoes() {
        jBtnSalvarEnd.setVisible(false);
        jBtnCancelEnde.setVisible(false);
        jBtnCarregaCep.setVisible(false);
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
        btnVoltar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtFornecedor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtEndPais = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEndCidade = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtEndEstado = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtEndBairro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEndRua = new javax.swing.JTextField();
        txtEndNum = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jBtnAltEnd = new javax.swing.JButton();
        jBtnSalvarEnd = new javax.swing.JButton();
        jBtnCancelEnde = new javax.swing.JButton();
        jBtnCarregaCep = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableContatos = new javax.swing.JTable();
        jButtonEditarContato = new javax.swing.JButton();
        jBtnNovoContato = new javax.swing.JButton();
        jBtnExcluirContato = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Raavi", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fornecedor.png"))); // NOI18N
        jLabel1.setText("Fornecedor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, -1));
        jPanel1.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 20, 102, 22));

        jPanel2.setBackground(new java.awt.Color(223, 237, 253));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"));

        txtFornecedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel3.setText("Fornecedor:");

        jLabel17.setText("País:");

        txtEndPais.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel11.setText("Cep:");

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCepActionPerformed(evt);
            }
        });

        jLabel15.setText("Cidade:");

        txtEndCidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel16.setText("Estado:");

        txtEndEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel14.setText("Bairro:");

        txtEndBairro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel12.setText("Rua:");

        txtEndRua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtEndNum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel13.setText("Numero:");

        jBtnAltEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jBtnAltEnd.setText("Editar");
        jBtnAltEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltEndActionPerformed(evt);
            }
        });

        jBtnSalvarEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jBtnSalvarEnd.setText("Salvar");
        jBtnSalvarEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarEndActionPerformed(evt);
            }
        });

        jBtnCancelEnde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelEnde.setText("Cancelar");
        jBtnCancelEnde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelEndeActionPerformed(evt);
            }
        });

        jBtnCarregaCep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.gif"))); // NOI18N
        jBtnCarregaCep.setText("Buscar");
        jBtnCarregaCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCarregaCepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel11))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnCarregaCep))
                            .addComponent(txtEndEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(txtEndRua))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel17))
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEndCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEndPais, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel12))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndNum, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEndBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBtnSalvarEnd)
                        .addComponent(jBtnAltEnd))
                    .addComponent(jBtnCancelEnde))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnCarregaCep))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(txtEndPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEndEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtEndCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtEndBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtnAltEnd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnSalvarEnd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnCancelEnde)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtEndRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtEndNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jPanel3.setBackground(new java.awt.Color(223, 237, 253));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Contatos"));

        jTableContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodContato", "codPessoa", "Contato", "Telefone", "Celular", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableContatos);

        jButtonEditarContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page_edit.png"))); // NOI18N
        jButtonEditarContato.setText("Editar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableContatos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButtonEditarContato, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButtonEditarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarContatoActionPerformed(evt);
            }
        });

        jBtnNovoContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page_add.png"))); // NOI18N
        jBtnNovoContato.setText("Novo");
        jBtnNovoContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoContatoActionPerformed(evt);
            }
        });

        jBtnExcluirContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page_delete.png"))); // NOI18N
        jBtnExcluirContato.setText("Remover");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableContatos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnExcluirContato, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnExcluirContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirContatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnExcluirContato)
                    .addComponent(jButtonEditarContato)
                    .addComponent(jBtnNovoContato))
                .addGap(21, 21, 21))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButtonEditarContato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnNovoContato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnExcluirContato)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(18, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 834, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3-5.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 890, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CarregaFornecedor() {

        OcultaBotoes();
        desabilitarEndereco();

        ArrayList<Endereco> endereco = new ArrayList<Endereco>();
        endereco = ContatosDAO.CarregaEndereco(idContato);

        ArrayList<Fornecedor> fornecedor = new ArrayList<Fornecedor>();
        fornecedor = FornecedorDAO.CarregaFornecedor(codFornecedor);
        
        for (Fornecedor forn : fornecedor) {
            lblCodigo.setText(String.valueOf(forn.getIdForn()));
            txtFornecedor.setText(forn.getFornecedor());
            idContato = forn.getCodContato();
        }

        for (Endereco end : endereco) {
            txtEndRua.setText(end.getRua());
            txtEndBairro.setText(end.getBairro());
            txtEndEstado.setText(end.getEstado());
            txtCep.setText(end.getCep());
            txtEndNum.setText(end.getNumero());
            txtEndCidade.setText(end.getCidade());
            txtEndPais.setText(end.getPais());
        }
    }

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        verificaPagina();
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void jBtnAltEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltEndActionPerformed

        EditarEndereco();
        txtEndBairro.setEditable(true);
        txtCep.setEditable(true);
        txtEndCidade.setEditable(true);
        txtEndEstado.setEditable(true);
        txtEndNum.setEditable(true);
        txtEndPais.setEditable(true);
        txtEndRua.setEditable(true);

        jBtnSalvarEnd.setVisible(true);
        jBtnCancelEnde.setVisible(true);
        jBtnAltEnd.setVisible(false);

        //nome fornecedor
        txtFornecedor.setEditable(true);
    }//GEN-LAST:event_jBtnAltEndActionPerformed

    private void jBtnSalvarEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarEndActionPerformed
       
        if (VerificaCamposFornecedor() == true) {
            Fornecedor forn = new Fornecedor();
            forn.setFornecedor(txtFornecedor.getText());
            FornecedorDAO.UpdateFornecedor(forn, GetIndiceForn());
            txtFornecedor.setEditable(false);

            Endereco endereco = new Endereco();

            endereco.setPais(txtEndPais.getText());
            endereco.setCep(txtCep.getText());
            endereco.setRua(txtEndRua.getText());
            endereco.setNumero(txtEndNum.getText());
            endereco.setBairro(txtEndBairro.getText());
            endereco.setCidade(txtEndCidade.getText());
            endereco.setEstado(txtEndEstado.getText());
            endereco.setIdContato(idContato);

            ContatosDAO.UpdateEndereco(idContato, endereco);
            desabilitarEndereco();
            CarregaFornecedor();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            String descricaoAudit = "Fornecedor " + forn.getFornecedor() + "teve os dados alterados.";
            AuditoriaDAO.CadDetAuditoria(descricaoAudit);
            jBtnSalvarEnd.setVisible(false);
            jBtnCancelEnde.setVisible(false);
            jBtnCarregaCep.setVisible(false);
            jBtnAltEnd.setVisible(true);
        }
    }//GEN-LAST:event_jBtnSalvarEndActionPerformed

    private void jBtnCancelEndeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelEndeActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Cancelar alteração?", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {            
            desabilitarEndereco();
            CarregaFornecedor();
            jBtnSalvarEnd.setVisible(false);
            jBtnCancelEnde.setVisible(false);
            jBtnAltEnd.setVisible(true);
            jBtnCarregaCep.setVisible(false);

            txtFornecedor.setEditable(false);
        }
    }//GEN-LAST:event_jBtnCancelEndeActionPerformed

    private void jButtonEditarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarContatoActionPerformed
        if (jTableContatos.getSelectedRow() != -1) {
            int linha = jTableContatos.getSelectedRow();
            codContato = (Integer.parseInt(jTableContatos.getValueAt(linha, 0).toString()));
            codPessoaContato = Integer.parseInt(jTableContatos.getValueAt(linha, 1).toString());
            this.setEnabled(false);
            new AlterarContato(this, codFornecedor, codPessoaContato, codContato).setVisible(true);
        }
    }//GEN-LAST:event_jButtonEditarContatoActionPerformed

    private void jBtnCarregaCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCarregaCepActionPerformed
        if (txtCep.getText().trim().equals("-")) {
            JOptionPane.showMessageDialog(null, "Primeiro preencha o campo CEP!");
        } else {
            CarregaCep();
        }
    }//GEN-LAST:event_jBtnCarregaCepActionPerformed

    private void txtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCepActionPerformed
        CarregaCep();
    }//GEN-LAST:event_txtCepActionPerformed

    private void jBtnNovoContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoContatoActionPerformed
        this.setEnabled(false);
        new AdicionarContato(this, codFornecedor).setVisible(true);
    }//GEN-LAST:event_jBtnNovoContatoActionPerformed

    private void jBtnExcluirContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirContatoActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION) == 0) {
            if (jTableContatos.getSelectedRow() != -1) {
                int linha = jTableContatos.getSelectedRow();
                codContato = (Integer.parseInt(jTableContatos.getValueAt(linha, 0).toString()));
                codPessoaContato = Integer.parseInt(jTableContatos.getValueAt(linha, 1).toString());
                ContatosDAO.ExcluirContatoFornecedor(codContato, codPessoaContato);
                TabelaContatos();
            }
        }
    }//GEN-LAST:event_jBtnExcluirContatoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private boolean VerificaCamposFornecedor() {

        boolean valida = true;

        if (txtFornecedor.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtEndPais.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtEndCidade.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtEndRua.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtCep.getText().trim().equals("-")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtEndEstado.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtEndBairro.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtEndNum.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        return valida;
    }

    private void desabilitarEndereco() {

        txtFornecedor.setEditable(false);
        txtFornecedor.setOpaque(false);
        txtFornecedor.setBorder(null);
        txtFornecedor.setBackground(new Color(0, 0, 0, 0));

        txtEndBairro.setEditable(false);
        txtCep.setEditable(false);
        txtEndCidade.setEditable(false);
        txtEndEstado.setEditable(false);
        txtEndNum.setEditable(false);
        txtEndPais.setEditable(false);
        txtEndRua.setEditable(false);

        txtEndBairro.setOpaque(false);
        txtEndBairro.setBackground(new Color(0, 0, 0, 0));
        txtEndBairro.setBorder(null);
        txtCep.setOpaque(false);
        txtCep.setBackground(new Color(0, 0, 0, 0));
        txtCep.setBorder(null);
        txtEndCidade.setOpaque(false);
        txtEndCidade.setBackground(new Color(0, 0, 0, 0));
        txtEndCidade.setBorder(null);
        txtEndEstado.setOpaque(false);
        txtEndEstado.setBackground(new Color(0, 0, 0, 0));
        txtEndEstado.setBorder(null);
        txtEndNum.setOpaque(false);
        txtEndNum.setBackground(new Color(0, 0, 0, 0));
        txtEndNum.setBorder(null);
        txtEndPais.setOpaque(false);
        txtEndPais.setBackground(new Color(0, 0, 0, 0));
        txtEndPais.setBorder(null);
        txtEndRua.setOpaque(false);
        txtEndRua.setBackground(new Color(0, 0, 0, 0));
        txtEndRua.setBorder(null);

        jBtnCancelEnde.setVisible(false);
        jBtnSalvarEnd.setVisible(false);
    }

    private void EditarEndereco() {

        txtEndBairro.setOpaque(true);
        txtEndBairro.setBackground(new Color(255, 255, 255));
        txtEndBairro.setBorder(new LineBorder(Color.BLACK));
        txtCep.setOpaque(true);
        txtCep.setBackground(new Color(255, 255, 255));
        txtCep.setBorder(new LineBorder(Color.BLACK));
        txtEndCidade.setOpaque(true);
        txtEndCidade.setBackground(new Color(255, 255, 255));
        txtEndCidade.setBorder(new LineBorder(Color.BLACK));
        txtEndEstado.setOpaque(true);
        txtEndEstado.setBackground(new Color(255, 255, 255));
        txtEndEstado.setBorder(new LineBorder(Color.BLACK));
        txtEndNum.setOpaque(true);
        txtEndNum.setBackground(new Color(255, 255, 255));
        txtEndNum.setBorder(new LineBorder(Color.BLACK));
        txtEndPais.setOpaque(true);
        txtEndPais.setBackground(new Color(255, 255, 255));
        txtEndPais.setBorder(new LineBorder(Color.BLACK));
        txtEndRua.setOpaque(true);
        txtEndRua.setBackground(new Color(255, 255, 255));
        txtEndRua.setBorder(new LineBorder(Color.BLACK));

        txtFornecedor.setOpaque(true);
        txtFornecedor.setBackground(new Color(255, 255, 255));
        txtFornecedor.setBorder(new LineBorder(Color.BLACK));

        jBtnCancelEnde.setVisible(false);
        jBtnAltEnd.setVisible(false);
    }

    public void TabelaContatos() {

        try {
            String Sql = "SELECT * FROM vw_contatofornecedor WHERE id_forn = " + codFornecedor + ";";
            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();
            String[] Colunas = {"CodContato", "Código", "Contato", "Telefone", "Celular", "Email"};

            ResultSet rs;
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                dados.add(new Object[]{
                    rs.getObject("id_contato"), 
                    rs.getObject("idPessoaContatoFornecedor"), 
                    rs.getObject("contato"),
                    rs.getObject("telefone"), 
                    rs.getObject("celular"),
                    rs.getObject("email")});
            }

            for (int i = 0; i < 6; i++) {
                
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableContatos.setModel(modelo);
                
                TableCellRenderer renderer = new TabelaZebrada();
                jTableContatos.setDefaultRenderer(Object.class, renderer);
                
                jTableContatos.getColumnModel().getColumn(0).setMaxWidth(0);
                jTableContatos.getColumnModel().getColumn(0).setMinWidth(0);
                jTableContatos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                jTableContatos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
                
                jTableContatos.getColumnModel().getColumn(1).setMaxWidth(0);
                jTableContatos.getColumnModel().getColumn(1).setMinWidth(0);
                jTableContatos.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
                jTableContatos.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
                
                jTableContatos.getColumnModel().getColumn(2).setPreferredWidth(200);
                jTableContatos.getColumnModel().getColumn(3).setPreferredWidth(90);
                jTableContatos.getColumnModel().getColumn(4).setPreferredWidth(90);
                jTableContatos.getColumnModel().getColumn(5).setPreferredWidth(200);
                
                jTableContatos.getColumnModel().getColumn(i).setResizable(false);
                jTableContatos.getTableHeader().setReorderingAllowed(false);
                jTableContatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception erro) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    private void CarregaCep() {

        TelaEspera telaTeste = new TelaEspera();
        this.setEnabled(false);
        final Thread t1 = new Thread(new Runnable() {//cria uma thread pra gravar o seu arquivo

            @Override
            public void run() {

                try {

                    telaTeste.setVisible(true);
                    CarregaCEP cep = new CarregaCEP();

                    String ceptxt = txtCep.getText();
                    txtEndCidade.setText(cep.getCidade(ceptxt));
                    txtEndBairro.setText(cep.getBairro(ceptxt));
                    txtEndRua.setText(cep.getEndereco(ceptxt));
                    txtEndEstado.setText(cep.getUF(ceptxt));

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "CEP não encontrado.");
                }
            }
        });
        t1.start();
        new Thread(new Runnable() {//cria outra thread pra sua tela de espera
            @Override
            public void run() {
                try {
                    //cria a tela de espera e mostra ela
                    t1.join();//fica esperando a primeira thread acabar
                    telaDetFornec.setEnabled(true);  // quando acabar fecha a janela de espera
                    telaTeste.dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    private void verificaPagina() {

        if (telaExibeForn != null) {
            telaExibeForn.setVisible(true);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton jBtnAltEnd;
    private javax.swing.JButton jBtnCancelEnde;
    private javax.swing.JButton jBtnCarregaCep;
    private javax.swing.JButton jBtnExcluirContato;
    private javax.swing.JButton jBtnNovoContato;
    private javax.swing.JButton jBtnSalvarEnd;
    private javax.swing.JButton jButtonEditarContato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableContatos;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtEndBairro;
    private javax.swing.JTextField txtEndCidade;
    private javax.swing.JTextField txtEndEstado;
    private javax.swing.JTextField txtEndNum;
    private javax.swing.JTextField txtEndPais;
    private javax.swing.JTextField txtEndRua;
    private javax.swing.JTextField txtFornecedor;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
