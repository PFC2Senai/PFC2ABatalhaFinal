package telas;


import atributos.Endereco;
import atributos.Fornecedor;
import funcoes.ContatosDAO;
import static funcoes.ContatosDAO.CodTel;
import funcoes.FornecedorDAO;
import java.awt.Color;
import java.util.ArrayList;
import static telas.ExibeFornecedor.GetIndiceForn;


public class DetalharFornecedor extends javax.swing.JFrame {

    int idContato = FornecedorDAO.idContato(GetIndiceForn()); 
    int codTel;
    int codCel;
    /**
     * Creates new form DetalharFornecedor
     */
    public DetalharFornecedor() {
        initComponents();        
        CarregaFornecedor();
    }
    
    private void OcultaBotoes() {
        
        jBtnSalvarForn.setVisible(false);
        jBtnCancelarForn.setVisible(false);
        jBtnSalvarContato.setVisible(false);
        jBtnCancelarContato.setVisible(false);
        jBtnSalvarEnd.setVisible(false);
        jBtnCancelEnde.setVisible(false);        
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
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        txtFornecedor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jBtnEditar = new javax.swing.JButton();
        jBtnAltContato = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtEndNum = new javax.swing.JTextField();
        txtEndRua = new javax.swing.JTextField();
        txtEndEstado = new javax.swing.JTextField();
        txtEndBairro = new javax.swing.JTextField();
        txtEndCidade = new javax.swing.JTextField();
        txtEndPais = new javax.swing.JTextField();
        jBtnAltEnd = new javax.swing.JButton();
        jBtnSalvarForn = new javax.swing.JButton();
        jBtnCancelarForn = new javax.swing.JButton();
        txtCep = new javax.swing.JFormattedTextField();
        jBtnSalvarContato = new javax.swing.JButton();
        jBtnCancelarContato = new javax.swing.JButton();
        jBtnSalvarEnd = new javax.swing.JButton();
        jBtnCancelEnde = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTel = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTelCel = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Fornecedor");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel3.setText("Fornecedor:");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel9.setText("Email:");

        jLabel2.setText("DADOS PESSOAIS:");

        jLabel8.setText("CONTATO:");

        jBtnEditar.setText("Editar");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnAltContato.setText("Editar");
        jBtnAltContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltContatoActionPerformed(evt);
            }
        });

        jLabel10.setText("ENDEREÇO:");

        jLabel11.setText("Cep:");

        jLabel12.setText("Rua:");

        jLabel13.setText("Numero:");

        jLabel14.setText("Bairro:");

        jLabel15.setText("Cidade:");

        jLabel16.setText("Estado:");

        jLabel17.setText("País:");

        jBtnAltEnd.setText("Editar");
        jBtnAltEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltEndActionPerformed(evt);
            }
        });

        jBtnSalvarForn.setText("Salvar");
        jBtnSalvarForn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarFornActionPerformed(evt);
            }
        });

        jBtnCancelarForn.setText("Cancelar");
        jBtnCancelarForn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarFornActionPerformed(evt);
            }
        });

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jBtnSalvarContato.setText("Salvar");
        jBtnSalvarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarContatoActionPerformed(evt);
            }
        });

        jBtnCancelarContato.setText("Cancelar");
        jBtnCancelarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarContatoActionPerformed(evt);
            }
        });

        jBtnSalvarEnd.setText("Salvar");
        jBtnSalvarEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarEndActionPerformed(evt);
            }
        });

        jBtnCancelEnde.setText("Cancelar");
        jBtnCancelEnde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelEndeActionPerformed(evt);
            }
        });

        jLabel7.setText("Telefone:");

        try {
            txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel19.setText("Celular:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(44, 44, 44)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtEndRua)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtEndNum, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtEndBairro)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel17))
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtEndCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel16)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtEndEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtEndPais, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtCep))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtFornecedor)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(139, 139, 139)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBtnAltEnd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnSalvarEnd))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBtnAltContato)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnSalvarContato))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBtnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnSalvarForn))
                            .addComponent(jBtnCancelEnde)
                            .addComponent(jBtnCancelarContato)
                            .addComponent(jBtnCancelarForn))
                        .addGap(297, 297, 297))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEditar)
                    .addComponent(jLabel3)
                    .addComponent(jBtnSalvarForn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jBtnCancelarForn))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnAltContato)
                            .addComponent(jBtnSalvarContato)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jBtnCancelarContato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEndPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtEndCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jBtnAltEnd)
                    .addComponent(jBtnSalvarEnd))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtEndBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancelEnde))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtEndRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtEndNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnLimpar))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CarregaFornecedor() { 
        
        OcultaBotoes();
        desabilitarEndereco();
        desabilitarContato();
        desabilitarFornecedor();
        
        ArrayList<Endereco> endereco = new ArrayList<Endereco>();
        endereco = ContatosDAO.CarregaEndereco(idContato);

        ArrayList<Fornecedor> fornecedor = new ArrayList<Fornecedor>();
        fornecedor = FornecedorDAO.CarregaFornecedor(GetIndiceForn());
        
        ArrayList<String> telefone = new ArrayList<String>();
        telefone = ContatosDAO.CarregaTelefones(idContato);

        for (int i = 0; i < telefone.size(); i++) {
            
            txtTel.setText(telefone.get(0));
            txtTelCel.setText(telefone.get(1));
        }       

        for (Fornecedor forn : fornecedor) {
            lblCodigo.setText(String.valueOf(forn.getIdForn()));
            txtFornecedor.setText(forn.getFornecedor());
            idContato = forn.getCodContato();
            txtEmail.setText(forn.getEmail());
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
        this.dispose();
        new DetalharCliente().setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

        txtFornecedor.setText("");
        txtEmail.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
                
        txtFornecedor.setEnabled(true);
        
        jBtnSalvarForn.setVisible(true);
        jBtnCancelarForn.setVisible(true);
        jBtnEditar.setVisible(false);
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnAltContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltContatoActionPerformed

        codTel = CodTel(txtTel.getText().trim());
        codCel = CodTel(txtTelCel.getText());
        
        txtTel.setEnabled(true);
        txtTelCel.setEnabled(true);
        txtEmail.setEnabled(true);       
        
        jBtnSalvarContato.setVisible(true);
        jBtnCancelarContato.setVisible(true);
        jBtnAltContato.setVisible(false);
    }//GEN-LAST:event_jBtnAltContatoActionPerformed

    private void jBtnAltEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltEndActionPerformed

        txtEndBairro.setEnabled(true);
        txtCep.setEnabled(true);
        txtEndCidade.setEnabled(true);
        txtEndEstado.setEnabled(true);
        txtEndNum.setEnabled(true);
        txtEndPais.setEnabled(true);
        txtEndRua.setEnabled(true);
        
        jBtnSalvarEnd.setVisible(true);
        jBtnCancelEnde.setVisible(true);
        jBtnAltEnd.setVisible(false);
        
    }//GEN-LAST:event_jBtnAltEndActionPerformed

    private void jBtnSalvarFornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarFornActionPerformed
        
        Fornecedor forn = new Fornecedor();
        forn.setFornecedor(txtFornecedor.getText());
        FornecedorDAO.UpdateFornecedor(forn, GetIndiceForn());
        txtFornecedor.setEnabled(false);
        jBtnCancelarForn.setVisible(false);
        jBtnSalvarForn.setVisible(false);
        jBtnEditar.setVisible(true);
        
    }//GEN-LAST:event_jBtnSalvarFornActionPerformed

    private void jBtnCancelarFornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarFornActionPerformed
        
        txtFornecedor.setEnabled(false);
        jBtnCancelarForn.setVisible(false);
        jBtnSalvarForn.setVisible(false);
        jBtnEditar.setVisible(true);
    }//GEN-LAST:event_jBtnCancelarFornActionPerformed

    private void jBtnSalvarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarContatoActionPerformed
        
        ContatosDAO.UpdateTel(codTel, txtTel.getText());
        ContatosDAO.UpdateTel(codCel, txtTelCel.getText());        
        ContatosDAO.UpdateEmail(idContato, txtEmail.getText()); 
        desabilitarContato();
        jBtnAltContato.setVisible(true);
        jBtnSalvarContato.setVisible(false);
        jBtnCancelarContato.setVisible(false);
    }//GEN-LAST:event_jBtnSalvarContatoActionPerformed

    private void jBtnCancelarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarContatoActionPerformed
        desabilitarContato();
        jBtnAltContato.setVisible(true);
    }//GEN-LAST:event_jBtnCancelarContatoActionPerformed

    private void jBtnSalvarEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarEndActionPerformed
        
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
        
        jBtnSalvarEnd.setVisible(false);
        jBtnCancelEnde.setVisible(false);
        jBtnAltEnd.setVisible(true);
    }//GEN-LAST:event_jBtnSalvarEndActionPerformed

    private void jBtnCancelEndeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelEndeActionPerformed
        desabilitarEndereco();        
        jBtnSalvarEnd.setVisible(false);
        jBtnCancelEnde.setVisible(false);
        jBtnAltEnd.setVisible(true);
    }//GEN-LAST:event_jBtnCancelEndeActionPerformed

    private void desabilitarFornecedor() {    

        txtFornecedor.setEnabled(false);
        
        txtFornecedor.setOpaque(false);
        txtFornecedor.setBackground(new Color(0,0,0,0));
                
        jBtnCancelarForn.setVisible(false);
        jBtnSalvarForn.setVisible(false);
    }
    
    private void desabilitarContato() {    
        
        txtTelCel.setEnabled(false);
        txtTel.setEnabled(false);
        txtEmail.setEnabled(false);
        
        txtTel.setOpaque(false);
        txtTel.setBackground(new Color(0,0,0,0));
        txtTelCel.setOpaque(false);
        txtTelCel.setBackground(new Color(0,0,0,0));
        txtEmail.setOpaque(false);
        txtEmail.setBackground(new Color(0,0,0,0));
        
        jBtnCancelarContato.setVisible(false);
        jBtnSalvarContato.setVisible(false);
    }
    
    private void desabilitarEndereco(){  
        
        txtEndBairro.setEnabled(false);
        txtCep.setEnabled(false);
        txtEndCidade.setEnabled(false);
        txtEndEstado.setEnabled(false);
        txtEndNum.setEnabled(false);
        txtEndPais.setEnabled(false);
        txtEndRua.setEnabled(false); 
        
        txtEndBairro.setOpaque(false);
        txtEndBairro.setBackground(new Color(0,0,0,0));
        txtCep.setOpaque(false);
        txtCep.setBackground(new Color(0,0,0,0));
        txtEndCidade.setOpaque(false);
        txtEndCidade.setBackground(new Color(0,0,0,0));
        txtEndEstado.setOpaque(false);
        txtEndEstado.setBackground(new Color(0,0,0,0));
        txtEndNum.setOpaque(false);
        txtEndNum.setBackground(new Color(0,0,0,0));
        txtEndPais.setOpaque(false);
        txtEndPais.setBackground(new Color(0,0,0,0));
        txtEndRua.setOpaque(false);
        txtEndRua.setBackground(new Color(0,0,0,0));
        
        jBtnCancelEnde.setVisible(false);
        jBtnSalvarEnd.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton jBtnAltContato;
    private javax.swing.JButton jBtnAltEnd;
    private javax.swing.JButton jBtnCancelEnde;
    private javax.swing.JButton jBtnCancelarContato;
    private javax.swing.JButton jBtnCancelarForn;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnSalvarContato;
    private javax.swing.JButton jBtnSalvarEnd;
    private javax.swing.JButton jBtnSalvarForn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndBairro;
    private javax.swing.JTextField txtEndCidade;
    private javax.swing.JTextField txtEndEstado;
    private javax.swing.JTextField txtEndNum;
    private javax.swing.JTextField txtEndPais;
    private javax.swing.JTextField txtEndRua;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JFormattedTextField txtTel;
    private javax.swing.JTextField txtTelCel;
    // End of variables declaration//GEN-END:variables
}
