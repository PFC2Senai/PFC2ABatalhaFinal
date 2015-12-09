package telas;


import atributos.Cliente;
import atributos.Endereco;
import atributos.Lembrete;
import atributos.PessoaContato;
import atributos.Telefone;
import funcoes.ClienteDAO;
import funcoes.Conexao;
import funcoes.ContatosDAO;
import static funcoes.ContatosDAO.CodEmail;
import static funcoes.ContatosDAO.CodTel;
import funcoes.LembreteDAO;
import funcoes.PessoaContatoDAO;
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
import javax.swing.table.DefaultTableModel;
import static telas.ExibeCliente.GetIndice;


public class DetalharCliente extends javax.swing.JFrame {

    int idContato = ClienteDAO.idContato(GetIndice()); //variavel vai receber a chave estrangeira 'tabContato_id_contato' do cliente que vai ter os dados alterados    
    public static int codLembrete;
    private int codTel;
    private int codEmail;
    private int codPessoaContato;
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
        TabelaContatos();
        campoInvisivel();
        
    }
    
    private void CarregaCliente() {
 
        jButtonEditarContato.setEnabled(false);
        OcultaBotoes();
        desabilitarEndereco();
        desabilitarDadosPessoais();
        
        ArrayList<Endereco> endereco = new ArrayList<Endereco>();
        endereco = ContatosDAO.CarregaEndereco(idContato);

        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente = ClienteDAO.CarregaCliente(GetIndice());
        
        ArrayList<Telefone> telefone = new ArrayList<Telefone>();
        telefone = ContatosDAO.CarregaTelefones(idContato);            
               
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
        txtContato.setOpaque(false);
        txtContato.setBackground(new Color(0,0,0,0));
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
        
        ((DefaultTableModel) jTableContatos.getModel()).setNumRows(0);
        jTableContatos.updateUI();
        
        ArrayList<String> telefone = new ArrayList<String>();
        telefone = ContatosDAO.Telefones(idContato); 
        
        ArrayList<String> celular = new ArrayList<String>();
        celular = ContatosDAO.Celular(idContato); 
        
        ArrayList<String> email = new ArrayList<String>();
        email = ContatosDAO.Email(idContato); 

        ArrayList<PessoaContato> pContato = new ArrayList<PessoaContato>();
        pContato = PessoaContatoDAO.Contatos(GetIndice()); 
        
        int i = 0;
        try { 
            
            DefaultTableModel dtm = (DefaultTableModel) jTableContatos.getModel();
            if (pContato != null) {
                for(PessoaContato p : pContato) {

                    dtm.addRow(new Object[] {p.getIdPessoaContato(), p.getNomeContato(), telefone.get(i), celular.get(i), email.get(i)});
                    i++;
                }
            } 
        } catch (Exception erro) {
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
        jLabel3 = new javax.swing.JLabel();
        txtSetor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        txtCnpj = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonAr1 = new javax.swing.JButton();
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
        jBtnAltEndereco = new javax.swing.JButton();
        jBtbCancelEndereco = new javax.swing.JButton();
        jBtnNovoLembrete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableContatos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabelContato = new javax.swing.JLabel();
        txtContato = new javax.swing.JTextField();
        jLabelTelefone = new javax.swing.JLabel();
        txtTel = new javax.swing.JFormattedTextField();
        jLabelCelular = new javax.swing.JLabel();
        txtTelCel = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jBtnAltContato = new javax.swing.JButton();
        jButtonEditarContato = new javax.swing.JButton();
        jBtbCancelContato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cliente");

        jLabel3.setText("Empresa:");

        jLabel6.setText("Setor:");

        jLabel4.setText("CNPJ:");

        jLabel2.setText("DADOS PESSOAIS:");

        jButtonAr1.setText("Editar");
        jButtonAr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr1ActionPerformed(evt);
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

        jButtonAr3.setText("Editar");
        jButtonAr3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr3ActionPerformed(evt);
            }
        });

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

        jLabel18.setText("Lembretes");

        jComboBoxSetores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSetoresActionPerformed(evt);
            }
        });

        jBtnAltDadosP.setText("Salvar");
        jBtnAltDadosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltDadosPActionPerformed(evt);
            }
        });

        jBtbCancelDadosP.setText("Cancelar");
        jBtbCancelDadosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelDadosPActionPerformed(evt);
            }
        });

        jBtnAltEndereco.setText("Salvar");
        jBtnAltEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltEnderecoActionPerformed(evt);
            }
        });

        jBtbCancelEndereco.setText("Cancelar");
        jBtbCancelEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelEnderecoActionPerformed(evt);
            }
        });

        jBtnNovoLembrete.setText("Novo Lembrete");
        jBtnNovoLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoLembreteActionPerformed(evt);
            }
        });

        jTableContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Contato", "Telefone", "Celular", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableContatos);

        jLabel8.setText("CONTATOS");

        jLabelContato.setText("Contato:");

        jLabelTelefone.setText("Telefone:");

        try {
            txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelCelular.setText("Celular:");

        jLabelEmail.setText("Email:");

        jBtnAltContato.setText("Salvar");
        jBtnAltContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltContatoActionPerformed(evt);
            }
        });

        jButtonEditarContato.setText("Editar");
        jButtonEditarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarContatoActionPerformed(evt);
            }
        });

        jBtbCancelContato.setText("Cancelar");
        jBtbCancelContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelContatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(634, 634, 634)
                            .addComponent(jBtnNovoLembrete))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(25, 25, 25)
                                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(40, 40, 40)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBoxSetores, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(30, 30, 30)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonAr1)
                                .addComponent(jBtnAltDadosP, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBtbCancelDadosP))
                            .addGap(35, 35, 35)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(47, 47, 47))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(43, 43, 43)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtEndRua, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)
                                        .addGap(9, 9, 9)
                                        .addComponent(txtEndNum, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtEndPais, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel11))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtEndCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtEndCep, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEndEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtEndBairro))))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtbCancelEndereco)
                            .addComponent(jButtonAr3)
                            .addComponent(jBtnAltEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabelContato)
                                .addGap(18, 18, 18)
                                .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonEditarContato)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBtnAltContato, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBtbCancelContato))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabelTelefone)
                                            .addGap(14, 14, 14)
                                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabelCelular)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelEmail)
                                        .addGap(32, 32, 32)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAr1)))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jBtnAltDadosP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxSetores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(jBtbCancelDadosP)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnNovoLembrete)
                    .addComponent(jLabel10))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtEndPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtEndCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtEndEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAr3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtEndBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jBtnAltEndereco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtEndRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEndNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtbCancelEndereco)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelContato))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTelefone)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCelular)
                            .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEditarContato)
                            .addComponent(jBtnAltContato)
                            .addComponent(jBtbCancelContato))))
                .addGap(297, 297, 297))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarContatoActionPerformed

        codTel = CodTel(txtTel.getText().trim());
        codEmail = CodEmail(txtEmail.getText().trim());
        exibeCampo();

        jButtonEditarContato.setVisible(false);
        jBtbCancelContato.setVisible(true);
        jBtnAltContato.setVisible(true);
    }//GEN-LAST:event_jButtonEditarContatoActionPerformed

    private void jBtnAltContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltContatoActionPerformed
        Telefone tel = new Telefone();
        PessoaContato p = new PessoaContato();
        
        tel.setTel(txtTel.getText());
        tel.setCel(txtTelCel.getText());
        p.setNomeContato(txtContato.getText());
        ContatosDAO.UpdateTel(codTel, tel);
        PessoaContatoDAO.UpdatePessoaContato(p, codPessoaContato);
        ContatosDAO.UpdateEmail(codEmail, txtEmail.getText());
        System.out.println(codEmail);
        campoInvisivel();
        jButtonEditarContato.setVisible(true);
        TabelaContatos();
        jButtonEditarContato.setEnabled(false);
    }//GEN-LAST:event_jBtnAltContatoActionPerformed

    private void jBtbCancelContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbCancelContatoActionPerformed

        campoInvisivel();
        jButtonEditarContato.setVisible(true);
      //  jButtonEditarContato.setEnabled(false);
    }//GEN-LAST:event_jBtbCancelContatoActionPerformed

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
        jButtonEditarContato.setEnabled(true);
        int linha = jTableContatos.getSelectedRow();
        codPessoaContato = Integer.parseInt(jTableContatos.getValueAt(linha, 0).toString());
        txtContato.setText(jTableContatos.getValueAt(linha, 1).toString());
        txtTel.setText(jTableContatos.getValueAt(linha, 2).toString());
        txtTelCel.setText(jTableContatos.getValueAt(linha, 3).toString());
        txtEmail.setText(jTableContatos.getValueAt(linha, 4).toString());
    }//GEN-LAST:event_jTableContatosMouseClicked
   
    private void campoInvisivel() {
        
        txtContato.setVisible(false);
        txtTel.setVisible(false);
        txtTelCel.setVisible(false);
        txtEmail.setVisible(false);
        
        jLabelCelular.setVisible(false);
        jLabelContato.setVisible(false);
        jLabelTelefone.setVisible(false);
        jLabelEmail.setVisible(false);
        
        jBtbCancelContato.setVisible(false);
        jBtnAltContato.setVisible(false);
    }
    
    private void exibeCampo() {
        
        txtContato.setVisible(true);
        txtTel.setVisible(true);
        txtTelCel.setVisible(true);
        txtEmail.setVisible(true);
        
        jLabelCelular.setVisible(true);
        jLabelContato.setVisible(true);
        jLabelTelefone.setVisible(true);
        jLabelEmail.setVisible(true);
    }
    
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
    private javax.swing.JButton jBtbCancelContato;
    private javax.swing.JButton jBtbCancelDadosP;
    private javax.swing.JButton jBtbCancelEndereco;
    private javax.swing.JButton jBtnAltContato;
    private javax.swing.JButton jBtnAltDadosP;
    private javax.swing.JButton jBtnAltEndereco;
    private javax.swing.JButton jBtnNovoLembrete;
    private javax.swing.JButton jButtonAr1;
    private javax.swing.JButton jButtonAr3;
    private javax.swing.JButton jButtonEditarContato;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCelular;
    private javax.swing.JLabel jLabelContato;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableContatos;
    private javax.swing.JTable jTableLembretes;
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
