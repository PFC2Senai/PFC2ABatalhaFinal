package telas;


import atributos.Cliente;
import atributos.Endereco;
import atributos.Lembrete;
import funcoes.AuditoriaDAO;
import funcoes.ClienteDAO;
import funcoes.Conexao;
import static funcoes.Conexao.getConnection;
import funcoes.ContatosDAO;
import funcoes.LembreteDAO;
import funcoes.LimitarDigitos;
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

    int idContato;    
    public static int codLembrete;
    private int codPessoaContato;
    private int codSetor;
    private PreparedStatement pst;
    Statement stmt ;
    private final int codCliente;
    private int codContato;
    
    /**
     * Creates new form CadastrarCliente
     */
    public DetalharCliente() {
        this.idContato = ClienteDAO.idContato(GetIndice());
        this.codCliente = GetIndice();
        
        initComponents();
        CarregaCliente();
        populaComboBox();
        TabelaLembrete2(GetIndice());         
        TabelaContatos();      
        
        //txtEmpresa.setDocument(new LimitarDigitos(45));
        //txtSetor.setDocument(new LimitarDigitos(50));
        
    }
    
    private void CarregaCliente() {
 
        jButtonEditarContato.setEnabled(false);
        OcultaBotoes();
        desabilitarEndereco();
        desabilitarDadosPessoais();
        
        ArrayList<Endereco> endereco = new ArrayList<Endereco>();
        endereco = ContatosDAO.CarregaEndereco(idContato);

        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente = ClienteDAO.CarregaCliente(codCliente);         
               
        for (Cliente cli : cliente) {
            txtEmpresa.setText(cli.getEmpresa());
            txtCnpj.setText(cli.getCnpj());
            txtSetor.setText(cli.getSetor());
            idContato = cli.getIdContato();
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
        
       jBtbCancelDadosP.setVisible(false);
       jBtbCancelEndereco.setVisible(false);
       jBtnAltDadosP.setVisible(false);
       jBtnAltEndereco.setVisible(false);
       jComboBoxSetores.setVisible(false);
    }
    
    private void desabilitarDadosPessoais() {
        //desabilita campos dados pessoais
        txtEmpresa.setEditable(false);        
        txtCnpj.setEnabled(false);
        txtSetor.setEnabled(false);
        jComboBoxSetores.setVisible(false);
      // customiza o textfild
        txtEmpresa.setOpaque(false);
        txtEmpresa.setBackground(new Color(0,0,0,0));
        txtEmpresa.setBorder(null);
        txtCnpj.setOpaque(false);
        txtCnpj.setBackground(new Color(0,0,0,0));
        txtSetor.setOpaque(false);
        txtSetor.setBackground(new Color(0,0,0,0));
      //oculta botoes  
        jBtbCancelDadosP.setVisible(false);
        jBtnAltDadosP.setVisible(false);
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
    
    public void TabelaLembrete2(int idcli) {
        
        ((DefaultTableModel) jTableLembretes.getModel()).setNumRows(0);
        jTableLembretes.updateUI();
        ArrayList<Lembrete> lembretes = new ArrayList<Lembrete>();
        lembretes = LembreteDAO.ListarLembretes(idcli);
        
        try { 
            
            DefaultTableModel dtm = (DefaultTableModel) jTableLembretes.getModel();
                   
            for(Lembrete lembrete : lembretes) {
                dtm.addRow(new Object[] {
                                        String.valueOf(lembrete.getIdLembrete()),
                                                       lembrete.getDescricao()});
            }
        
            //pog oculta coluna jtable
            jTableLembretes.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
            jTableLembretes.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
            jTableLembretes.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
            jTableLembretes.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
        } catch (Exception erro){
            Logger.getLogger(DetalharCliente.class.getName()).log(Level.SEVERE, null, erro);
        }          
    } 
    
    public void TabelaContatos() {
        
        try { 
            String Sql = "SELECT * FROM vw_contatos WHERE idcliente = " + codCliente + ";";
            
            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();               
            String [] Colunas = {"CodContato","Código","Contato", "Telefone", "Celular", "Email"};
               
            ResultSet rs;
            rs = stmt.executeQuery(Sql);            
            
                while(rs.next()){
                    dados.add(new Object[]{ rs.getObject("id_contato"),rs.getObject("idPessoaContato"),rs.getObject("contato"),
                                            rs.getObject("telefone"),rs.getObject("celular"), 
                                            rs.getObject("email")});            
                }

                    for (int i = 0; i < 6; i++){
                        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                        jTableContatos.setModel(modelo);
                        jTableContatos.getColumnModel().getColumn(i).setPreferredWidth(150);
                        jTableContatos.getColumnModel().getColumn(i).setResizable(false);
                        jTableContatos.getTableHeader().setReorderingAllowed(false);
                        jTableContatos.setAutoResizeMode(jTableContatos.AUTO_RESIZE_OFF);
                        jTableContatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    }
                    
        } catch (SQLException ex) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (Exception erro){
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtEndNum = new javax.swing.JTextField();
        txtEndRua = new javax.swing.JTextField();
        txtEndEstado = new javax.swing.JTextField();
        txtEndBairro = new javax.swing.JTextField();
        txtEndCidade = new javax.swing.JTextField();
        txtEndPais = new javax.swing.JTextField();
        jButtonAr3 = new javax.swing.JButton();
        jBtnAltEndereco = new javax.swing.JButton();
        jBtbCancelEndereco = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        jButtonAr1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jBtnAltDadosP = new javax.swing.JButton();
        jBtbCancelDadosP = new javax.swing.JButton();
        txtSetor = new javax.swing.JTextField();
        jComboBoxSetores = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JFormattedTextField();
        txtEndCep = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableContatos = new javax.swing.JTable();
        jButtonEditarContato = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jBtnNovoLembrete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLembretes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cliente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 22, -1, -1));

        jLabel11.setText("Cep:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 238, -1, -1));

        jLabel13.setText("Numero:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 300, -1, -1));

        jLabel14.setText("Bairro:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 270, -1, -1));

        jLabel16.setText("Estado:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 238, -1, -1));
        jPanel1.add(txtEndNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 301, 69, -1));
        jPanel1.add(txtEndRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 300, 262, -1));
        jPanel1.add(txtEndEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 235, 114, -1));
        jPanel1.add(txtEndBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 267, 280, -1));
        jPanel1.add(txtEndCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 267, 260, -1));
        jPanel1.add(txtEndPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 235, 260, -1));

        jButtonAr3.setText("Editar");
        jButtonAr3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAr3, new org.netbeans.lib.awtextra.AbsoluteConstraints(747, 235, -1, 20));

        jBtnAltEndereco.setText("Salvar");
        jBtnAltEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltEnderecoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnAltEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(747, 266, 70, -1));

        jBtbCancelEndereco.setText("Cancelar");
        jBtbCancelEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelEnderecoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtbCancelEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(747, 300, -1, -1));

        jPanel2.setBackground(new java.awt.Color(223, 237, 253));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da empresa"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Empresa:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        jPanel2.add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 260, -1));

        jButtonAr1.setText("Editar");
        jButtonAr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        jLabel4.setText("CNPJ:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jBtnAltDadosP.setText("Salvar");
        jBtnAltDadosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltDadosPActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnAltDadosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 70, -1));

        jBtbCancelDadosP.setText("Cancelar");
        jBtbCancelDadosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelDadosPActionPerformed(evt);
            }
        });
        jPanel2.add(jBtbCancelDadosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));
        jPanel2.add(txtSetor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 245, -1));

        jComboBoxSetores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSetoresActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxSetores, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 260, -1));

        jLabel6.setText("Setor:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        try {
            txtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(txtCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 140, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 470, 130));

        try {
            txtEndCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtEndCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 110, -1));

        jPanel3.setBackground(new java.awt.Color(223, 237, 253));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jLabel17.setText("País:");

        jLabel15.setText("Cidade:");

        jLabel12.setText("Rua:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12))
                .addContainerGap(781, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 840, 130));

        jPanel4.setBackground(new java.awt.Color(223, 237, 253));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Contatos"));

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
        jTableContatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContatosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableContatos);

        jButtonEditarContato.setText("Editar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableContatos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButtonEditarContato, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButtonEditarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarContatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEditarContato)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEditarContato)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 840, 190));

        jPanel5.setBackground(new java.awt.Color(223, 237, 253));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Lembretes"));

        jBtnNovoLembrete.setText("Novo Lembrete");
        jBtnNovoLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoLembreteActionPerformed(evt);
            }
        });

        jTableLembretes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLembretes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableLembretes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLembretesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLembretes);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnNovoLembrete)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnNovoLembrete))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 360, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarContatoActionPerformed
        if(jTableContatos.getSelectedRow() != -1) {         
            int linha = jTableContatos.getSelectedRow();        
            codContato = (Integer.parseInt(jTableContatos.getValueAt(linha, 0).toString()));
            codPessoaContato = Integer.parseInt(jTableContatos.getValueAt(linha, 1).toString());
        }
        new AlterarContato(this, codCliente, codPessoaContato, codContato).setVisible(true);        
    }//GEN-LAST:event_jButtonEditarContatoActionPerformed

    private void jBtnNovoLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoLembreteActionPerformed
        this.setEnabled(false);
        new CadastrarLembrete(GetIndice(),this).setVisible(true);
    }//GEN-LAST:event_jBtnNovoLembreteActionPerformed

    private void jBtbCancelEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbCancelEnderecoActionPerformed

        jButtonAr3.setVisible(true);
        jBtbCancelEndereco.setVisible(false);
        jBtnAltEndereco.setVisible(false);
        desabilitarEndereco();
    }//GEN-LAST:event_jBtbCancelEnderecoActionPerformed

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

    private void jBtbCancelDadosPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbCancelDadosPActionPerformed

        desabilitarDadosPessoais();
        txtSetor.setVisible(true);
        jBtnAltDadosP.setVisible(false);
        jBtbCancelDadosP.setVisible(false);
        jButtonAr1.setVisible(true);
    }//GEN-LAST:event_jBtbCancelDadosPActionPerformed

    private void jBtnAltDadosPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltDadosPActionPerformed

        Cliente cli = new Cliente();
        cli.setEmpresa(txtEmpresa.getText());
        cli.setCnpj(txtCnpj.getText());
        cli.setCodSetor(codSetor);
        cli.setIdContato(idContato);
        ClienteDAO.UpdateCliente(cli, GetIndice());
        desabilitarDadosPessoais();
        txtSetor.setVisible(true);
        jBtnAltDadosP.setVisible(false);
        jBtbCancelDadosP.setVisible(false);
        jButtonAr1.setVisible(true);
        CarregaCliente();
        
        String descricaoAudit = "Empresa "+ cli.getEmpresa() +" /CNPJ: "+ cli.getCnpj() +"teve os dados alterados.";
        AuditoriaDAO.CadDetAuditoria(descricaoAudit);
        
    }//GEN-LAST:event_jBtnAltDadosPActionPerformed

    private void jComboBoxSetoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSetoresActionPerformed

        idSetorComboBox();
    }//GEN-LAST:event_jComboBoxSetoresActionPerformed

    private void jTableLembretesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLembretesMouseClicked

        // codLembrete = Integer.parseInt(jTableLembretes.getModel().getValueAt(jTableLembretes.getSelectedRow(),0).toString());
        this.setEnabled(false);
        int linha = jTableLembretes.getSelectedRow();
        codLembrete = (Integer.parseInt(jTableLembretes.getValueAt(linha, 0).toString()));
        new DetalharLembrete(this).setVisible(true);
    }//GEN-LAST:event_jTableLembretesMouseClicked

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

    private void jButtonAr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAr1ActionPerformed

        txtEmpresa.setEditable(true);
        txtCnpj.setEnabled(true);
        txtSetor.setVisible(false);
        jComboBoxSetores.setVisible(true);

        jButtonAr1.setVisible(false);
        jBtbCancelDadosP.setVisible(true);
        jBtnAltDadosP.setVisible(true);
    }//GEN-LAST:event_jButtonAr1ActionPerformed

    private void jTableContatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContatosMouseClicked
                
    }//GEN-LAST:event_jTableContatosMouseClicked

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
    private javax.swing.JButton jBtbCancelDadosP;
    private javax.swing.JButton jBtbCancelEndereco;
    private javax.swing.JButton jBtnAltDadosP;
    private javax.swing.JButton jBtnAltEndereco;
    private javax.swing.JButton jBtnNovoLembrete;
    private javax.swing.JButton jButtonAr1;
    private javax.swing.JButton jButtonAr3;
    private javax.swing.JButton jButtonEditarContato;
    private javax.swing.JComboBox jComboBoxSetores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableContatos;
    private javax.swing.JTable jTableLembretes;
    private javax.swing.JFormattedTextField txtCnpj;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEndBairro;
    private javax.swing.JFormattedTextField txtEndCep;
    private javax.swing.JTextField txtEndCidade;
    private javax.swing.JTextField txtEndEstado;
    private javax.swing.JTextField txtEndNum;
    private javax.swing.JTextField txtEndPais;
    private javax.swing.JTextField txtEndRua;
    private javax.swing.JTextField txtSetor;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
