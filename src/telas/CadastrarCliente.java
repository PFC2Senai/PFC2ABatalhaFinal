package telas;

import atributos.Cliente;
import atributos.Endereco;
import atributos.PessoaContato;
import atributos.Setor;
import atributos.Telefone;
import static atributos.Usuario.idUsuario;
import funcoes.AuditoriaDAO;
import funcoes.CarregaCEP;
import funcoes.ClienteDAO;
import funcoes.Conexao;
import funcoes.ContatosDAO;
import funcoes.LimitarDigitos;
import funcoes.PessoaContatoDAO;
import funcoes.SetorDAO;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CadastrarCliente extends javax.swing.JFrame {

    private PreparedStatement pst;
    private String descricaoAudit;
    private int codSetor;
    private Menu telaMenu;
    private CadastrarCliente telaCliente;
    private ExibeCliente telaExibeCliente;

    public CadastrarCliente() {
        initComponents();
    }

    public CadastrarCliente(Menu menu) {
        telaMenu = menu;
        initComponents();
        telaCliente = this;
        carregarComboSegmento();
        txtSetor.setVisible(false);
        jBtnSalvarSetor.setVisible(false);
        jBtnCancelarSetor.setVisible(false);
        combobox();

//        txtEmpresa.setDocument(new LimitarDigitos(45));
//        txtSetor.setDocument(new LimitarDigitos(50));
//        txtPais.setDocument(new LimitarDigitos(45));
        txtEstado.setDocument(new LimitarDigitos(4));
        txtNumero.setDocument(new LimitarDigitos(6));
        txtTelCel.setDocument(new LimitarDigitos(12));
    }

    public CadastrarCliente(ExibeCliente exibeCliente) {
        telaExibeCliente = exibeCliente;
        initComponents();
        telaCliente = this;
        carregarComboSegmento();
        txtSetor.setVisible(false);
        jBtnSalvarSetor.setVisible(false);
        jBtnCancelarSetor.setVisible(false);
        combobox();
//        txtEmpresa.setDocument(new LimitarDigitos(45));
//        txtSetor.setDocument(new LimitarDigitos(50));
//        txtPais.setDocument(new LimitarDigitos(45));
        txtEstado.setDocument(new LimitarDigitos(4));
//        txtBairro.setDocument(new LimitarDigitos(45));
//        txtCidade.setDocument(new LimitarDigitos(45));
//        txtRua.setDocument(new LimitarDigitos(45));
        //txtNumero.setDocument(new LimitarDigitos(10).insertInt(HEIGHT, descricaoAudit,  10));
//
//        txtContato.setDocument(new LimitarDigitos(45));
//        txtEmail.setDocument(new LimitarDigitos(45));
        txtNumero.setDocument(new LimitarDigitos(6));
        txtTelCel.setDocument(new LimitarDigitos(20));
    }

    private boolean VerificaCampos() {

        boolean valida = true;

        if (txtEmpresa.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo EMPRESA!");
            txtEmpresa.requestFocus();
            valida = false;
            return valida;
        }

        if (jComboBoxSetores.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Preencha o campo SEGMENTO!");
            jComboBoxSetores.requestFocus();
            valida = false;
            return valida;
        }

        if (txtCnpj.getText().trim().length() != 18) {
            JOptionPane.showMessageDialog(null, "Preencha o campo CNPJ!");
            txtCnpj.requestFocus();
            valida = false;
            return valida;
        }

        if (txtPais.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo PAÍS!");
            txtPais.requestFocus();
            valida = false;
            return valida;
        }

        if (txtCidade.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo CIDADE!");
            txtCidade.requestFocus();
            valida = false;
            return valida;
        }

        if (txtRua.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo RUA!");
            txtRua.requestFocus();
            valida = false;
            return valida;
        }

        if (txtCep.getText().trim().equals("-")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo CEP!");
            txtCep.requestFocus();
            valida = false;
            return valida;
        }

        if (txtEstado.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo ESTADO!");
            txtEstado.requestFocus();
            valida = false;
            return valida;
        }

        if (txtBairro.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo BAIRRO!");
            txtBairro.requestFocus();
            valida = false;
            return valida;
        }

        if (txtNumero.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo NÚMERO!");
            txtNumero.requestFocus();
            valida = false;
            return valida;
        }

        if (jComboBoxSetores.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Preencha o campo SETOR!");
            jComboBoxSetores.requestFocus();
            valida = false;
            return valida;
        }

        if (jTableContatos.getRowCount() < 1) {
            JOptionPane.showMessageDialog(null, "Tabela de CONTATOS vazia!");
            valida = false;
            return valida;
        }
        return valida;
    }

    private void combobox() {

        jComboBoxSetores.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codSetor == 0 && jComboBoxSetores.getSelectedIndex() != 0) {
                    JOptionPane.showMessageDialog(null, "Esse registro não encontra-se cadastrado na base de dados.");
                    jComboBoxSetores.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        jComboBoxSetores.setAutocompletar(true);
    }

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
        btnLimpar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtContato = new javax.swing.JTextField();
        jBtnOutroContato = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTel01 = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTelCel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContatos = new javax.swing.JTable();
        jBtnRemoverContato = new javax.swing.JButton();
        jLabelEmail = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxSetorContato = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jBtnCarregaCep = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxSetores = new componentes.UJComboBox();
        txtSetor = new javax.swing.JTextField();
        jBtnNovoSetor = new javax.swing.JButton();
        jBtnSalvarSetor = new javax.swing.JButton();
        jBtnCancelarSetor = new javax.swing.JButton();
        btnCadCliente = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRAR CLIENTES");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CADASTRAR CLIENTE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/stop2.png"))); // NOI18N
        btnLimpar.setText("Cancelar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, -1, 30));

        jPanel2.setBackground(new java.awt.Color(223, 237, 253));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contatos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/funcionario.png"))); // NOI18N
        jLabel5.setText("Contato:");

        jBtnOutroContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jBtnOutroContato.setText("Adicionar contato");
        jBtnOutroContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOutroContatoActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/telephone.png"))); // NOI18N
        jLabel7.setText("Telefone:");

        try {
            txtTel01.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/phone.png"))); // NOI18N
        jLabel13.setText("Celular:");

        txtTelCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelCelKeyTyped(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/email.png"))); // NOI18N
        jLabel9.setText("Email:");

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

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

        jBtnRemoverContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jBtnRemoverContato.setText("Remover contato");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableContatos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnRemoverContato, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnRemoverContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverContatoActionPerformed(evt);
            }
        });

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(255, 0, 0));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/setor.png"))); // NOI18N
        jLabel16.setText("Setor:");

        jComboBoxSetorContato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Setor", "Manutenção", "Compras", "Suprimentos", "Projetos", "Engenharia", "Compras/Suprimentos", "Projetos/Engenharia" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel9)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel16))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtTel01, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBoxSetorContato, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jBtnRemoverContato)
                                    .addComponent(jBtnOutroContato))))
                        .addGap(21, 21, 21))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtTel01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxSetorContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnOutroContato)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnRemoverContato)
                .addGap(29, 29, 29))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 730, 280));

        jPanel3.setBackground(new java.awt.Color(223, 237, 253));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jLabel10.setText("País:");

        txtPais.setText("Brasil");

        jLabel2.setText("CEP:");

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCepActionPerformed(evt);
            }
        });

        jLabel11.setText("Rua:");

        jLabel12.setText("Nº");

        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroKeyTyped(evt);
            }
        });

        jLabel8.setText("Bairro:");

        jLabel14.setText("Cidade:");

        txtCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCidadeKeyTyped(evt);
            }
        });

        jLabel15.setText("Estado:");

        txtEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEstadoKeyTyped(evt);
            }
        });

        jBtnCarregaCep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.gif"))); // NOI18N
        jBtnCarregaCep.setText("Buscar");
        jBtnCarregaCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCarregaCepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCidade, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(txtRua))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCarregaCep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCarregaCep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 730, -1));

        jPanel4.setBackground(new java.awt.Color(223, 237, 253));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Empresa", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jLabel3.setText("Empresa:");

        txtEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmpresaKeyTyped(evt);
            }
        });

        jLabel4.setText("CNPJ:");

        try {
            txtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Segmento:");

        jComboBoxSetores.setEditable(true);
        jComboBoxSetores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSetoresActionPerformed(evt);
            }
        });

        jBtnNovoSetor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jBtnNovoSetor.setText("Novo Segmento");
        jBtnNovoSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoSetorActionPerformed(evt);
            }
        });

        jBtnSalvarSetor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jBtnSalvarSetor.setText("Salvar");
        jBtnSalvarSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarSetorActionPerformed(evt);
            }
        });

        jBtnCancelarSetor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelarSetor.setText("Cancelar");
        jBtnCancelarSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarSetorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(15, 15, 15)
                        .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxSetores, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jBtnNovoSetor)
                        .addGap(11, 11, 11)
                        .addComponent(jBtnCancelarSetor)
                        .addGap(5, 5, 5)
                        .addComponent(jBtnSalvarSetor))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSetores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnNovoSetor)
                    .addComponent(jBtnCancelarSetor)
                    .addComponent(jBtnSalvarSetor)))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 730, 100));

        btnCadCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        btnCadCliente.setText("Cadastrar");
        btnCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 700, -1, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 900));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCancelarSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarSetorActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Cancelar novo segmento?", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
            jBtnSalvarSetor.setVisible(false);
            jBtnCancelarSetor.setVisible(false);
            jBtnNovoSetor.setVisible(true);
            txtSetor.setVisible(false);
            txtSetor.setText("");
            jComboBoxSetores.setVisible(true);
        }
    }//GEN-LAST:event_jBtnCancelarSetorActionPerformed

    private void jBtnSalvarSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarSetorActionPerformed

        if (txtSetor.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo vazio!");

        } else {

            Setor setor = new Setor();

            setor.setSetor(txtSetor.getText());
            SetorDAO.CadSetor(setor);
            jBtnSalvarSetor.setVisible(false);
            jBtnCancelarSetor.setVisible(false);
            jBtnNovoSetor.setVisible(true);
            txtSetor.setVisible(false);
            txtSetor.setText("");
            jComboBoxSetores.setVisible(true);
            jComboBoxSetores.removeAllItems();

            carregarComboSegmento();
            jComboBoxSetores.setSelectedItem(setor.getSetor());
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }
    }//GEN-LAST:event_jBtnSalvarSetorActionPerformed

    private void jBtnNovoSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoSetorActionPerformed
        txtSetor.setText("");
        txtSetor.requestFocus();
        txtSetor.setVisible(true);
        jComboBoxSetores.setVisible(false);
        jBtnSalvarSetor.setVisible(true);
        jBtnCancelarSetor.setVisible(true);
        jBtnNovoSetor.setVisible(false);
    }//GEN-LAST:event_jBtnNovoSetorActionPerformed

    private void txtEmpresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaKeyTyped

        String carac = "ç,.!?@:;/^~´`#$%¨&*()-_='+{[]}";
        if (carac.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEmpresaKeyTyped

    private void jBtnCarregaCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCarregaCepActionPerformed
        if (txtCep.getText().trim().equals("-")) {
            JOptionPane.showMessageDialog(null, "Primeiro preencha o campo CEP!");
        } else {
            CarregaCep();
        }
    }//GEN-LAST:event_jBtnCarregaCepActionPerformed

    private void txtEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstadoKeyTyped

        String caracteres = "0987654321";

        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEstadoKeyTyped

    private void txtCidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCidadeKeyTyped

        String caracteres = "0987654321";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCidadeKeyTyped

    private void txtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyTyped

        String caracteres = "0987654321snSN/";
        String car = txtNumero.getText().toUpperCase();
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroKeyTyped

    private void txtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCepActionPerformed
        CarregaCep();
    }//GEN-LAST:event_txtCepActionPerformed

    private void jBtnRemoverContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoverContatoActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION) == 0) {
            DefaultTableModel dtm = (DefaultTableModel) jTableContatos.getModel();
            int linha = jTableContatos.getSelectedRow();

            if (linha != -1) {
                dtm.removeRow(linha);
            }
        }
    }//GEN-LAST:event_jBtnRemoverContatoActionPerformed

    private void txtTelCelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelCelKeyTyped

        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelCelKeyTyped

    private void jBtnOutroContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOutroContatoActionPerformed
        if (VerificaCamposContato()) {
            TabelaContatos();
        } else {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
        }
    }//GEN-LAST:event_jBtnOutroContatoActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair? Os dados não serão salvos.", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
            verificaPagina();
            this.dispose();
        }
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadClienteActionPerformed

        if (VerificaCampos() == true) {

  //          if (ClienteDAO.VerificarNome(txtEmpresa.getText()) == true) {
//                JOptionPane.showMessageDialog(this, "Ja existe uma empresa com este nome registrada, tente outra !");
            
            
            if (ClienteDAO.VerificarCliente(txtCnpj.getText()) == false) {

                Cliente cli = new Cliente();
                Telefone tel = new Telefone();
                PessoaContato pContato = new PessoaContato();
                String email;
                Endereco endereco = new Endereco();

                cli.setCodUser(idUsuario());
                cli.setEmpresa(txtEmpresa.getText());
                cli.setCnpj(txtCnpj.getText());
                cli.setCodSetor(codSetor);

                int i = ContatosDAO.CadContato();

                cli.setIdContato(i);

                int codCli = ClienteDAO.CadCliente(cli);

                endereco.setPais(txtPais.getText());
                endereco.setCep(txtCep.getText());
                endereco.setRua(txtRua.getText());
                endereco.setNumero(txtNumero.getText());
                endereco.setBairro(txtBairro.getText());
                endereco.setCidade(txtCidade.getText());
                endereco.setEstado(txtEstado.getText());
                endereco.setIdContato(i);

                ContatosDAO.CadEndereco(endereco);

                for (int j = 0; j < jTableContatos.getRowCount(); j++) {

                    pContato.setNomeContato(jTableContatos.getValueAt(j, 0).toString());
                    tel.setTel(jTableContatos.getValueAt(j, 1).toString());
                    tel.setCel(jTableContatos.getValueAt(j, 2).toString());
                    email = jTableContatos.getValueAt(j, 3).toString();
                    pContato.setSetorContato(jTableContatos.getValueAt(j, 4).toString());

                    int codContato = ContatosDAO.CadContato();

                    ContatosDAO.CadTel(codContato, tel);
                    ContatosDAO.CadEmail(codContato, email);
                    pContato.setCodTabEstrangeira(codCli);
                    pContato.setCodContato(codContato);

                    PessoaContatoDAO.CadPessoaContato(pContato);

                }

                descricaoAudit = "Empresa " + cli.getEmpresa() + " /CNPJ: " + cli.getCnpj() + " foi cadastrada.";
                AuditoriaDAO.CadDetAuditoria(descricaoAudit);
                limparCampos();

                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

                if (JOptionPane.showConfirmDialog(null, "Deseja continuar cadastrando?", "Confirmar Cadastro", JOptionPane.YES_NO_OPTION) == 1) {
                    verificaPagina();
                    if (telaExibeCliente != null) {
                        this.telaExibeCliente.TabelaCliente("select  * from vw_cliente;");
                    }
                    this.dispose();
                } else {
                    txtEmpresa.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cliente ja cadastrado !");
            }
        }
    //    }//
    }//GEN-LAST:event_btnCadClienteActionPerformed

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        ValidaEmail();
    }//GEN-LAST:event_txtEmailFocusLost

    private void jComboBoxSetoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSetoresActionPerformed
        idSetorComboBox();
    }//GEN-LAST:event_jComboBoxSetoresActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void carregarComboSegmento() {

        // uJComboBoxPeca.clear();
        ArrayList<Setor> setores = new ArrayList<Setor>();
        setores = SetorDAO.ListarSetor();
        jComboBoxSetores.addItem("Selecione o segmento da empresa");
        for (Setor setor : setores) {
            jComboBoxSetores.addItem(setor.getSetor(), setor);
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

    private void idSetorComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabSetor where setor = '" + jComboBoxSetores.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codSetor = (rs.getInt("idtabSetor"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void limparCampos() {
        txtEmpresa.setText("");
        txtCnpj.setText("");
        txtContato.setText("");
        jComboBoxSetores.setSelectedIndex(0);
        txtTel01.setText(null);
        txtTelCel.setText(null);
        txtEmail.setText("");
        txtCidade.setText("");
        txtCep.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtEstado.setText("");
        txtRua.setText("");
        ((DefaultTableModel) jTableContatos.getModel()).setNumRows(0);
        jTableContatos.updateUI();
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

    public void CarregaCep() {

        TelaEspera telaTeste = new TelaEspera();
        this.setEnabled(false);
        final Thread t1 = new Thread(new Runnable() {//cria uma thread pra gravar o seu arquivo

            @Override
            public void run() {

                try {

                    telaTeste.setVisible(true);
                    CarregaCEP cep = new CarregaCEP();

                    String ceptxt = txtCep.getText();
                    txtCidade.setText(cep.getCidade(ceptxt));
                    txtBairro.setText(cep.getBairro(ceptxt));
                    txtRua.setText(cep.getEndereco(ceptxt));
                    txtEstado.setText(cep.getUF(ceptxt));

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
                    t1.join();//fica esperando a primeira thread acabar
                    telaCliente.setEnabled(true);  // quando acabar fecha a janela de espera
                    telaTeste.dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    private void verificaPagina() {

        if ((this.telaMenu != null)) {
            this.telaMenu.setVisible(true);
            // this.telaMenu.toFront();
        } else if ((this.telaExibeCliente != null)) {
            this.telaExibeCliente.setVisible(true);
            // this.telaExibeCliente.toFront();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadCliente;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton jBtnCancelarSetor;
    private javax.swing.JButton jBtnCarregaCep;
    private javax.swing.JButton jBtnNovoSetor;
    private javax.swing.JButton jBtnOutroContato;
    private javax.swing.JButton jBtnRemoverContato;
    private javax.swing.JButton jBtnSalvarSetor;
    private javax.swing.JComboBox jComboBoxSetorContato;
    private componentes.UJComboBox jComboBoxSetores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContatos;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtCnpj;
    private javax.swing.JTextField txtContato;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtSetor;
    private javax.swing.JFormattedTextField txtTel01;
    private javax.swing.JTextField txtTelCel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
