package telas;


import atributos.Cliente;
import atributos.Endereco;
import atributos.Lembrete;
import atributos.Telefone;
import funcoes.ClienteDAO;
import funcoes.Conexao;
import static funcoes.Conexao.getConnection;
import funcoes.ContatosDAO;
import static funcoes.ContatosDAO.CodTel;
import funcoes.LembreteDAO;
import funcoes.ModeloTabela;
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
import javax.swing.table.DefaultTableModel;
import static telas.ExibeCliente.GetIndice;


public class DetalharCliente extends javax.swing.JFrame {

    int idContato = ClienteDAO.idContato(GetIndice()); //variavel vai receber a chave estrangeira 'tabContato_id_contato' do cliente que vai ter os dados alterados    
    public static int codLembrete;
    int codTel;
    int codCel;
    private int codSetor;
    private PreparedStatement pst;
    Statement stmt ;
    
    /**
     * Creates new form CadastrarCliente
     */
    public DetalharCliente() {
        
        initComponents();
        CarregaCliente();
        populaComboBox();
        TabelaLembrete2(GetIndice()); 
        TabelaContatos("SELECT * FROM vw_contatos where id_contato = " + idContato + ";");
    }
    
    private void CarregaCliente() {
 
        OcultaBotoes();
        desabilitarEndereco();
        desabilitarContato();
        desabilitarDadosPessoais();
        
        ArrayList<Endereco> endereco = new ArrayList<Endereco>();
        endereco = ContatosDAO.CarregaEndereco(idContato);

        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente = ClienteDAO.CarregaCliente(GetIndice());
        
        ArrayList<Telefone> telefone = new ArrayList<Telefone>();
        telefone = ContatosDAO.CarregaTelefones(idContato);            
               
        for (Cliente cli : cliente) {
            lblCodigo.setText(String.valueOf(cli.getId()));
            txtEmpresa.setText(cli.getEmpresa());
            txtCnpj.setText(cli.getCnpj());
            txtSetor.setText(cli.getSetor());
            txtEmail.setText(cli.getEmail());
            idContato = cli.getIdContato();
        }
        
        for (Telefone tel : telefone) {
            txtTel.setText(tel.getTel());
            txtTelCel.setText(tel.getCel());
        }
        
        for (Endereco end : endereco) {
            txtEndRua.setText(end.getRua());
            txtEndBairro.setText(end.getBairro());
            txtEndEstado.setText(end.getEstado());
            txtEndCep.setText(end.getCep());
            txtEndNum.setText(end.getNumero());
            txtEndCidade.setText(end.getCidade());
            txtEndPais.setText(end.getPais());
        }
    }
    
    private void OcultaBotoes() {
        
       jBtbCancelContato.setVisible(false);
       jBtbCancelDadosP.setVisible(false);
       jBtbCancelEndereco.setVisible(false);
       jBtnAltContato.setVisible(false);
       jBtnAltDadosP.setVisible(false);
       jBtnAltEndereco.setVisible(false);
       jComboBoxSetores.setVisible(false);
    }
    
    private void desabilitarDadosPessoais() {
        //desabilita campos dados pessoais
        lblCodigo.setEnabled(false);
        txtEmpresa.setEditable(false);        
        txtCnpj.setEnabled(false);
        txtContato.setEnabled(false);
        txtSetor.setEnabled(false);
        jComboBoxSetores.setVisible(false);
      // customiza o textfild
        txtEmpresa.setOpaque(false);
        txtEmpresa.setBackground(new Color(0,0,0,0));
        txtEmpresa.setBorder(null);
        txtCnpj.setOpaque(false);
        txtCnpj.setBackground(new Color(0,0,0,0));
        txtContato.setOpaque(false);
        txtContato.setBackground(new Color(0,0,0,0));
        txtSetor.setOpaque(false);
        txtSetor.setBackground(new Color(0,0,0,0));
      //oculta botoes  
        jBtbCancelDadosP.setVisible(false);
        jBtnAltDadosP.setVisible(false);
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
        
        jBtbCancelContato.setVisible(false);
        jBtnAltContato.setVisible(false);
    }
    
    private void desabilitarEndereco() {  
        
        txtEndBairro.setEnabled(false);
        txtEndCep.setEnabled(false);
        txtEndCidade.setEnabled(false);
        txtEndEstado.setEnabled(false);
        txtEndNum.setEnabled(false);
        txtEndPais.setEnabled(false);
        txtEndRua.setEnabled(false); 
        
        txtEndBairro.setOpaque(false);
        txtEndBairro.setBackground(new Color(0,0,0,0));
        txtEndCep.setOpaque(false);
        txtEndCep.setBackground(new Color(0,0,0,0));
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
        
        jBtbCancelEndereco.setVisible(false);
        jBtnAltEndereco.setVisible(false);
    }
    
    public void TabelaLembrete2(int idcli){
        
        ((DefaultTableModel) jTableLembretes.getModel()).setNumRows(0);
        jTableLembretes.updateUI();
        ArrayList<Lembrete> lembretes = new ArrayList<Lembrete>();
        lembretes = LembreteDAO.ListarLembretes(idcli);
        
        try { 
            
            DefaultTableModel dtm = (DefaultTableModel) jTableLembretes.getModel();
                   
            for(Lembrete lembrete : lembretes){
                dtm.addRow(new Object[] {
                                        String.valueOf(lembrete.getIdLembrete()),
                                                       lembrete.getDescricao()});
        }
                             
        } catch (Exception erro){
            Logger.getLogger(DetalharCliente.class.getName()).log(Level.SEVERE, null, erro);
        }          
    } 
    
    public void TabelaContatos(String sql) {
        
        try { 
            
            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();               
            String [] Colunas = {"Código", "Contato", "Telefone", "Celular", "Email"};
               
            ResultSet rs;
            rs = stmt.executeQuery(sql);            
            
                while(rs.next()){
                    dados.add(new Object[]{ rs.getObject("idPessoaContato"),rs.getObject("contato"),
                                            rs.getObject("telefone"),rs.getObject("celular"), 
                                            rs.getObject("email")});            
                }

                    for (int i = 0; i < 5; i++){
                        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                        jTableContatos.setModel(modelo);
                        jTableContatos.getColumnModel().getColumn(i).setPreferredWidth(150);
                        jTableContatos.getColumnModel().getColumn(i).setResizable(false);
                        jTableContatos.getTableHeader().setReorderingAllowed(false);
                        jTableContatos.setAutoResizeMode(jTableContatos.AUTO_RESIZE_OFF);
                        jTableContatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    }
                    
        } catch (SQLException ex) {
            Logger.getLogger(DetalharCliente.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (Exception erro){
            Logger.getLogger(DetalharCliente.class.getName()).log(Level.SEVERE, null, erro);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSetor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelCel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        txtCnpj = new javax.swing.JTextField();
        txtContato = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonAr1 = new javax.swing.JButton();
        jButtonAr2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtEndCep = new javax.swing.JTextField();
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
        jButtonAr3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLembretes = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxSetores = new javax.swing.JComboBox();
        jBtnAltDadosP = new javax.swing.JButton();
        jBtbCancelDadosP = new javax.swing.JButton();
        jBtnAltContato = new javax.swing.JButton();
        jBtbCancelContato = new javax.swing.JButton();
        jBtnAltEndereco = new javax.swing.JButton();
        jBtbCancelEndereco = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtTel = new javax.swing.JFormattedTextField();
        jBtnNovoLembrete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableContatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cliente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, -1, -1));

        jLabel3.setText("Empresa:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 99, -1, -1));
        jPanel1.add(txtSetor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 245, -1));

        jLabel7.setText("Telefone:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));
        jPanel1.add(txtTelCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 242, -1));

        jLabel6.setText("Setor:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 184, -1, -1));

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 620, -1, -1));

        jLabel4.setText("CNPJ:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 143, -1, -1));

        jLabel5.setText("Contato:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));
        jPanel1.add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 245, -1));
        jPanel1.add(txtCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 250, -1));
        jPanel1.add(txtContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 260, -1));

        jLabel9.setText("Email:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 240, -1));
        jPanel1.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 102, 22));

        jLabel2.setText("DADOS PESSOAIS:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 63, -1, -1));

        jLabel8.setText("CONTATO:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jButtonAr1.setText("Editar");
        jButtonAr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, -1));

        jButtonAr2.setText("Editar");
        jButtonAr2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        jLabel10.setText("ENDEREÇO:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));
        jPanel1.add(txtEndCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 172, -1));

        jLabel11.setText("Cep:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, -1, -1));

        jLabel12.setText("Rua:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, -1));

        jLabel13.setText("Numero:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, -1, -1));

        jLabel14.setText("Bairro:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        jLabel15.setText("Cidade:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        jLabel16.setText("Estado:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, -1, -1));

        jLabel17.setText("País:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));
        jPanel1.add(txtEndNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 560, 69, -1));
        jPanel1.add(txtEndRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 272, -1));
        jPanel1.add(txtEndEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 69, -1));
        jPanel1.add(txtEndBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 402, -1));
        jPanel1.add(txtEndCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 260, -1));
        jPanel1.add(txtEndPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 193, -1));

        jButtonAr3.setText("Editar");
        jButtonAr3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAr3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, -1, -1));

        jTableLembretes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ));
        jTableLembretes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableLembretes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLembretesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLembretes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 317, 110));

        jLabel18.setText("Lembretes");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        jComboBoxSetores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSetoresActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxSetores, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 260, -1));

        jBtnAltDadosP.setText("Salvar");
        jBtnAltDadosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltDadosPActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnAltDadosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 70, -1));

        jBtbCancelDadosP.setText("Cancelar");
        jBtbCancelDadosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelDadosPActionPerformed(evt);
            }
        });
        jPanel1.add(jBtbCancelDadosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        jBtnAltContato.setText("Salvar");
        jBtnAltContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltContatoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnAltContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 70, -1));

        jBtbCancelContato.setText("Cancelar");
        jBtbCancelContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelContatoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtbCancelContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, -1, -1));

        jBtnAltEndereco.setText("Salvar");
        jBtnAltEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltEnderecoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnAltEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 70, -1));

        jBtbCancelEndereco.setText("Cancelar");
        jBtbCancelEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelEnderecoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtbCancelEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 530, -1, -1));

        jLabel19.setText("Celular:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        try {
            txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 240, -1));

        jBtnNovoLembrete.setText("Novo Lembrete");
        jBtnNovoLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoLembreteActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnNovoLembrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

        jTableContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableContatos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 420, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAr2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAr2ActionPerformed
               
        codTel = CodTel(txtTel.getText().trim());
        codCel = CodTel(txtTelCel.getText());
        
        txtTel.setEnabled(true);
        txtTelCel.setEnabled(true);
        txtEmail.setEnabled(true);       
        
        jButtonAr2.setVisible(false);
        jBtbCancelContato.setVisible(true);
        jBtnAltContato.setVisible(true);
    }//GEN-LAST:event_jButtonAr2ActionPerformed

    private void jButtonAr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAr1ActionPerformed

        txtEmpresa.setEditable(true);
        txtCnpj.setEnabled(true);
        txtSetor.setVisible(false);
        txtContato.setEnabled(true);
        jComboBoxSetores.setVisible(true);
        
        jButtonAr1.setVisible(false);
        jBtbCancelDadosP.setVisible(true);
        jBtnAltDadosP.setVisible(true);        
    }//GEN-LAST:event_jButtonAr1ActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        
        txtEmpresa.setText("");
        txtCnpj.setText("");
        txtContato.setText("");
        txtSetor.setText("");
        txtTelCel.setText("");
        txtEmail.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        this.dispose();
        new DetalharCliente().setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jButtonAr3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAr3ActionPerformed
    
        txtEndBairro.setEnabled(true);
        txtEndCep.setEnabled(true);
        txtEndCidade.setEnabled(true);
        txtEndEstado.setEnabled(true);
        txtEndNum.setEnabled(true);
        txtEndPais.setEnabled(true);
        txtEndRua.setEnabled(true);     
        
        jButtonAr3.setVisible(false);
        jBtnAltEndereco.setVisible(true);
        jBtbCancelEndereco.setVisible(true);
        
    }//GEN-LAST:event_jButtonAr3ActionPerformed
   
    private void jTableLembretesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLembretesMouseClicked

        this.setEnabled(false);
        int linha = jTableLembretes.getSelectedRow();
        codLembrete = (Integer.parseInt(jTableLembretes.getValueAt(linha, 0).toString()));
        new DetalharLembrete(this).setVisible(true);        
    }//GEN-LAST:event_jTableLembretesMouseClicked

    private void jComboBoxSetoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSetoresActionPerformed
        
        idSetorComboBox();       
    }//GEN-LAST:event_jComboBoxSetoresActionPerformed

    private void jBtnAltDadosPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltDadosPActionPerformed
        
        Cliente cli = new Cliente();
        cli.setEmpresa(txtEmpresa.getText());
        cli.setCnpj(txtCnpj.getText());
        cli.setCodSetor(codSetor);
        cli.setEmail(txtEmail.getText());
        cli.setIdContato(idContato);
        ClienteDAO.UpdateCliente(cli, GetIndice());
        desabilitarDadosPessoais();
        txtSetor.setVisible(true);
        jBtnAltDadosP.setVisible(false);
        jBtbCancelDadosP.setVisible(false);
        jButtonAr1.setVisible(true);   
        CarregaCliente();
    }//GEN-LAST:event_jBtnAltDadosPActionPerformed

    private void jBtbCancelDadosPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbCancelDadosPActionPerformed
        
        desabilitarDadosPessoais();
        txtSetor.setVisible(true);
        jBtnAltDadosP.setVisible(false);
        jBtbCancelDadosP.setVisible(false);
        jButtonAr1.setVisible(true);
    }//GEN-LAST:event_jBtbCancelDadosPActionPerformed

    private void jBtnAltContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltContatoActionPerformed
        Telefone tel = new Telefone();
        tel.setTel(txtTel.getText());
        tel.setCel(txtTelCel.getText());
        ContatosDAO.UpdateTel(codTel, tel);       
        ContatosDAO.UpdateEmail(idContato, txtEmail.getText()); 
        desabilitarContato();
        jButtonAr2.setVisible(true);
    }//GEN-LAST:event_jBtnAltContatoActionPerformed

    private void jBtnAltEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltEnderecoActionPerformed
        
        Endereco endereco = new Endereco();
        
        endereco.setPais(txtEndPais.getText());
        endereco.setCep(txtEndCep.getText());
        endereco.setRua(txtEndRua.getText());
        endereco.setNumero(txtEndNum.getText());
        endereco.setBairro(txtEndBairro.getText());
        endereco.setCidade(txtEndCidade.getText());
        endereco.setEstado(txtEndEstado.getText());
        endereco.setIdContato(idContato);

        ContatosDAO.UpdateEndereco(idContato, endereco);
        jButtonAr3.setVisible(true);
        jBtbCancelEndereco.setVisible(false);
        jBtnAltEndereco.setVisible(false);
        desabilitarEndereco();
    }//GEN-LAST:event_jBtnAltEnderecoActionPerformed

    private void jBtbCancelEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbCancelEnderecoActionPerformed
        
        jButtonAr3.setVisible(true);
        jBtbCancelEndereco.setVisible(false);
        jBtnAltEndereco.setVisible(false);
        desabilitarEndereco();
    }//GEN-LAST:event_jBtbCancelEnderecoActionPerformed

    private void jBtbCancelContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbCancelContatoActionPerformed
        desabilitarContato();
        jButtonAr2.setVisible(true);
    }//GEN-LAST:event_jBtbCancelContatoActionPerformed

    private void jBtnNovoLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoLembreteActionPerformed
        this.setEnabled(false);
        new CadastrarLembrete(GetIndice(),this).setVisible(true); 
    }//GEN-LAST:event_jBtnNovoLembreteActionPerformed

    private void populaComboBox() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabSetor";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                jComboBoxSetores.addItem(rs.getString("setor"));
            }
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void idSetorComboBox() {
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabSetor where setor = '"+ jComboBoxSetores.getSelectedItem()+ "';";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                codSetor = (rs.getInt("idtabSetor"));
            }
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public static int GetIdLembrete() {         
        return codLembrete;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton jBtbCancelContato;
    private javax.swing.JButton jBtbCancelDadosP;
    private javax.swing.JButton jBtbCancelEndereco;
    private javax.swing.JButton jBtnAltContato;
    private javax.swing.JButton jBtnAltDadosP;
    private javax.swing.JButton jBtnAltEndereco;
    private javax.swing.JButton jBtnNovoLembrete;
    private javax.swing.JButton jButtonAr1;
    private javax.swing.JButton jButtonAr2;
    private javax.swing.JButton jButtonAr3;
    private javax.swing.JComboBox jComboBoxSetores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableContatos;
    private javax.swing.JTable jTableLembretes;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtContato;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEndBairro;
    private javax.swing.JTextField txtEndCep;
    private javax.swing.JTextField txtEndCidade;
    private javax.swing.JTextField txtEndEstado;
    private javax.swing.JTextField txtEndNum;
    private javax.swing.JTextField txtEndPais;
    private javax.swing.JTextField txtEndRua;
    private javax.swing.JTextField txtSetor;
    private javax.swing.JFormattedTextField txtTel;
    private javax.swing.JTextField txtTelCel;
    // End of variables declaration//GEN-END:variables
}
