package telas;

import atributos.Endereco;
import atributos.Funcionario;
import atributos.Telefone;
import atributos.Email;
import funcoes.AuditoriaDAO;
import funcoes.CarregaCEP;
import funcoes.ContatosDAO;
import funcoes.FuncionarioDAO;
import funcoes.FuncoesDiversas;
import static funcoes.FuncoesDiversas.ConverterData;
import funcoes.LimitarDigitos;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import static telas.ExibeFuncionario.GetIndice;

public class AlterarFuncionario extends javax.swing.JFrame {

    private int idContato;
    private AlterarFuncionario telaFunc;
    private int idFuncionario;
    private ExibeFuncionario telaExibeFunc;

    public static String fun;

    /**
     * Creates new form AlterarFuncionario
     */
    private void limitarDigitos() {

        //    jTextSalario.setDocument(new LimitarDigitos(15));
        //    jTextCtps.setDocument(new LimitarDigitos(14));
        //    jTextNumCtps.setDocument(new LimitarDigitos(7));
        //    jTextSerieCtps.setDocument(new LimitarDigitos(4));
        //    txtTelCel.setDocument(new LimitarDigitos(12));
        //    txtEndNum.setDocument(new LimitarDigitos(7));
        //    txtEndEstado.setDocument(new LimitarDigitos(2));
    }

    public AlterarFuncionario() {
        telaFunc = this;
        this.idFuncionario = GetIndice();
        this.idContato = FuncionarioDAO.idContato(idFuncionario);
        initComponents();
        CarregaFuncionario();
        limitarDigitos();
    }

    public AlterarFuncionario(ExibeFuncionario exibeFunc) {
        this.telaExibeFunc = exibeFunc;
        telaFunc = this;
        this.idFuncionario = GetIndice();
        this.idContato = FuncionarioDAO.idContato(idFuncionario);

        initComponents();
        CarregaFuncionario();
        limitarDigitos();
    }

    private void CarregaFuncionario() {

        limitarDigitos();
        OcultaBotoes();
        desabilitarEndereco();
        desabilitarContato();
        desabilitarDadosPessoais();
        desabilitarCarteira();

        ArrayList<Endereco> endereco = new ArrayList<Endereco>();
        endereco = ContatosDAO.CarregaEndereco(idContato);

        ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();
        funcionario = FuncionarioDAO.CarregaFuncionario(GetIndice());

        for (Funcionario func : funcionario) {

            id.setText(String.valueOf(func.getId()));
            jTextNome.setText(func.getFuncionario());
            jTextRg.setText(func.getRg());
            jTextCpf.setText(func.getCpf());
            jTextCargo.setText(func.getCargo());
            jTextSalario.setText(String.valueOf(func.getSalario()));
            jLbDataAdmissao.setText(String.valueOf(func.getDataAdmicao()));
            jTextCtps.setText(String.valueOf(func.getCtps()));
            jTextNumCtps.setText(String.valueOf(func.getNumCtps()));
            jTextSerieCtps.setText(func.getSerieCtps());
            jComboUf.setSelectedItem(func.getUfCtps());
            // idContato = func.getId();
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

        ArrayList<Telefone> telefones = new ArrayList<Telefone>();
        telefones = ContatosDAO.CarregaTelefones(idContato);

        String email = ContatosDAO.CarregaEmail(idContato);

        for (Telefone tel : telefones) {
            txtTel.setText(tel.getTel());
            txtTelCel.setText(tel.getCel());
        }
        txtEmail.setText(email);
    }

    private void OcultaBotoes() {

        jBtbCancelContato.setVisible(false);
        jBtbCancelEndereco.setVisible(false);
        jBtnSalvarContato.setVisible(false);
        jBtnSalvarEndereco.setVisible(false);
    }

    private void desabilitarCarteira() {

        jTextCtps.setEditable(false);
        jTextNumCtps.setEditable(false);
        jTextSerieCtps.setEditable(false);
        jComboUf.setEnabled(false);

        jTextCtps.setOpaque(false);
        jTextCtps.setBackground(new Color(0, 0, 0, 0));
        jTextCtps.setBorder(null);
        jTextNumCtps.setOpaque(false);
        jTextNumCtps.setBackground(new Color(0, 0, 0, 0));
        jTextNumCtps.setBorder(null);
        jTextSerieCtps.setOpaque(false);
        jTextSerieCtps.setBackground(new Color(0, 0, 0, 0));
        jTextSerieCtps.setBorder(null);
        jComboUf.setOpaque(false);
        jComboUf.setBackground(new Color(0, 0, 0, 0));
        jComboUf.setBorder(null);

        jBtnEditarCarteira.setVisible(true);
        jBtbCancelCarteira.setVisible(false);
        jBtnSalvarCarteira.setVisible(false);
    }

    private void EditarCarteira() {

        jTextCtps.setEditable(true);
        jTextNumCtps.setEditable(true);
        jTextSerieCtps.setEditable(true);
        jComboUf.setEnabled(true);

        jBtnEditarCarteira.setVisible(false);
        jBtbCancelCarteira.setVisible(true);
        jBtnSalvarCarteira.setVisible(true);

        jTextCtps.setOpaque(true);
        jTextCtps.setBackground(new Color(255, 255, 255));
        jTextCtps.setBorder(new LineBorder(Color.BLACK));
        jTextNumCtps.setOpaque(true);
        jTextNumCtps.setBackground(new Color(255, 255, 255));
        jTextNumCtps.setBorder(new LineBorder(Color.BLACK));
        jTextSerieCtps.setOpaque(true);
        jTextSerieCtps.setBackground(new Color(255, 255, 255));
        jTextSerieCtps.setBorder(new LineBorder(Color.BLACK));
        jComboUf.setOpaque(true);
        jComboUf.setBackground(new Color(255, 255, 255));
        jComboUf.setBorder(new LineBorder(Color.BLACK));
    }

    private void desabilitarDadosPessoais() {
        //desabilita campos dados pessoais        
        jTextNome.setEditable(false);
        jTextRg.setEditable(false);
        jTextCpf.setEditable(false);
        jTextCargo.setEditable(false);
        jTextSalario.setEditable(false);
        txtDataAdmissao.setVisible(false);
        jLbDataAdmissao.setVisible(true);
        // customiza o textfild
        jTextNome.setOpaque(false);
        jTextNome.setBackground(new Color(0, 0, 0, 0));
        jTextNome.setBorder(null);
        jTextRg.setOpaque(false);
        jTextRg.setBackground(new Color(0, 0, 0, 0));
        jTextRg.setBorder(null);
        jTextCpf.setOpaque(false);
        jTextCpf.setBackground(new Color(0, 0, 0, 0));
        jTextCpf.setBorder(null);
        jTextCargo.setOpaque(false);
        jTextCargo.setBackground(new Color(0, 0, 0, 0));
        jTextCargo.setBorder(null);
        jTextSalario.setOpaque(false);
        jTextSalario.setBackground(new Color(0, 0, 0, 0));
        jTextSalario.setBorder(null);
        //oculta botoes  
        jBtnCancelarFuncionario.setVisible(false);
        jBtnSalvarFuncionario.setVisible(false);
        jBtnEditarFuncionairo.setVisible(true);
    }

    private void EditarDadosPessoais() {
        //desabilita campos dados pessoais

        jTextNome.setEditable(true);
        jTextRg.setEditable(true);
        jTextCpf.setEditable(true);
        jTextCargo.setEditable(true);
        jTextSalario.setEditable(true);
        txtDataAdmissao.setVisible(true);
        jLbDataAdmissao.setVisible(false);

        jBtnEditarFuncionairo.setVisible(false);
        jBtnCancelarFuncionario.setVisible(true);
        jBtnSalvarFuncionario.setVisible(true);
        Date d = ConverterData(jLbDataAdmissao.getText());
        txtDataAdmissao.setDate(d);

        jTextNome.setOpaque(true);
        jTextNome.setBackground(new Color(255, 255, 255));
        jTextNome.setBorder(new LineBorder(Color.BLACK));
        jTextRg.setOpaque(true);
        jTextRg.setBackground(new Color(255, 255, 255));
        jTextRg.setBorder(new LineBorder(Color.BLACK));
        jTextCpf.setOpaque(true);
        jTextCpf.setBackground(new Color(255, 255, 255));
        jTextCpf.setBorder(new LineBorder(Color.BLACK));
        jTextCargo.setOpaque(true);
        jTextCargo.setBackground(new Color(255, 255, 255));
        jTextCargo.setBorder(new LineBorder(Color.BLACK));
        jTextSalario.setOpaque(true);
        jTextSalario.setBackground(new Color(255, 255, 255));
        jTextSalario.setBorder(new LineBorder(Color.BLACK));
    }

    private void desabilitarContato() {

        txtTelCel.setEditable(false);
        txtTel.setEditable(false);
        txtEmail.setEditable(false);

        txtTel.setOpaque(false);
        txtTel.setBackground(new Color(0, 0, 0, 0));
        txtTel.setBorder(null);
        txtTelCel.setOpaque(false);
        txtTelCel.setBackground(new Color(0, 0, 0, 0));
        txtTelCel.setBorder(null);
        txtEmail.setOpaque(false);
        txtEmail.setBackground(new Color(0, 0, 0, 0));
        txtEmail.setBorder(null);

        jBtbCancelContato.setVisible(false);
        jBtnSalvarContato.setVisible(false);
        jBtnEditarContato.setVisible(true);
    }

    private void EditarContato() {

        txtTel.setEditable(true);
        txtTelCel.setEditable(true);
        txtEmail.setEditable(true);

        jBtnEditarContato.setVisible(false);
        jBtbCancelContato.setVisible(true);
        jBtnSalvarContato.setVisible(true);

        txtTel.setOpaque(true);
        txtTel.setBackground(new Color(255, 255, 255));
        txtTel.setBorder(new LineBorder(Color.BLACK));
        txtTelCel.setOpaque(true);
        txtTelCel.setBackground(new Color(255, 255, 255));
        txtTelCel.setBorder(new LineBorder(Color.BLACK));
        txtEmail.setOpaque(true);
        txtEmail.setBackground(new Color(255, 255, 255));
        txtEmail.setBorder(new LineBorder(Color.BLACK));
    }

    private void desabilitarEndereco() {

        txtEndBairro.setOpaque(false);
        txtEndBairro.setBackground(new Color(0, 0, 0, 0));
        txtEndBairro.setBorder(null);
        txtEndBairro.setEditable(false);
        txtEndCep.setOpaque(false);
        txtEndCep.setBackground(new Color(0, 0, 0, 0));
        txtEndCep.setEditable(false);
        txtEndCep.setBorder(null);
        txtEndCidade.setOpaque(false);
        txtEndCidade.setBackground(new Color(0, 0, 0, 0));
        txtEndCidade.setBorder(null);
        txtEndCidade.setEditable(false);
        txtEndEstado.setOpaque(false);
        txtEndEstado.setBackground(new Color(0, 0, 0, 0));
        txtEndEstado.setBorder(null);
        txtEndEstado.setEditable(false);
        txtEndNum.setOpaque(false);
        txtEndNum.setBackground(new Color(0, 0, 0, 0));
        txtEndNum.setBorder(null);
        txtEndNum.setEditable(false);
        txtEndPais.setOpaque(false);
        txtEndPais.setBackground(new Color(0, 0, 0, 0));
        txtEndPais.setBorder(null);
        txtEndPais.setEditable(false);
        txtEndRua.setOpaque(false);
        txtEndRua.setBackground(new Color(0, 0, 0, 0));
        txtEndRua.setBorder(null);
        txtEndRua.setEditable(false);

        jBtnCarregaCep.setVisible(false);
        jBtbCancelEndereco.setVisible(false);
        jBtnSalvarEndereco.setVisible(false);
        jBtnEditarEndereco.setVisible(true);
    }

    private void EditarEndereco() {

        txtEndBairro.setEditable(true);
        txtEndCep.setEditable(true);
        txtEndCidade.setEditable(true);
        txtEndEstado.setEditable(true);
        txtEndNum.setEditable(true);
        txtEndPais.setEditable(true);
        txtEndRua.setEditable(true);

        txtEndBairro.setOpaque(true);
        txtEndBairro.setBackground(new Color(255, 255, 255));
        txtEndBairro.setBorder(new LineBorder(Color.BLACK));
        txtEndCep.setOpaque(true);
        txtEndCep.setBackground(new Color(255, 255, 255));
        txtEndCep.setBorder(new LineBorder(Color.BLACK));
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

        jBtbCancelEndereco.setVisible(true);
        jBtnSalvarEndereco.setVisible(true);
        jBtnEditarEndereco.setVisible(false);
        jBtnCarregaCep.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTel = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTelCel = new javax.swing.JTextField();
        jBtnEditarContato = new javax.swing.JButton();
        jBtnSalvarContato = new javax.swing.JButton();
        jBtbCancelContato = new javax.swing.JButton();
        jLabelEmail = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtEndNum = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jBtnSalvarEndereco = new javax.swing.JButton();
        txtEndCidade = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtEndRua = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jBtnEditarEndereco = new javax.swing.JButton();
        txtEndBairro = new javax.swing.JTextField();
        jBtbCancelEndereco = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtEndPais = new javax.swing.JTextField();
        txtEndEstado = new javax.swing.JTextField();
        txtEndCep = new javax.swing.JFormattedTextField();
        jBtnCarregaCep = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextNome = new javax.swing.JTextField();
        jTextSalario = new javax.swing.JTextField();
        txtDataAdmissao = new com.toedter.calendar.JDateChooser();
        jTextCargo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextRg = new javax.swing.JFormattedTextField();
        jTextCpf = new javax.swing.JFormattedTextField();
        jLbDataAdmissao = new javax.swing.JLabel();
        jBtnEditarFuncionairo = new javax.swing.JButton();
        jBtnSalvarFuncionario = new javax.swing.JButton();
        jBtnCancelarFuncionario = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jTextCtps = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextNumCtps = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextSerieCtps = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jComboUf = new javax.swing.JComboBox();
        jBtnEditarCarteira = new javax.swing.JButton();
        jBtnSalvarCarteira = new javax.swing.JButton();
        jBtbCancelCarteira = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jBtnVoltar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(235, 235, 253));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        jLabel9.setText("EDITAR FUNCIONÁRIO");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jPanel3.setBackground(new java.awt.Color(235, 235, 253));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/email.png"))); // NOI18N
        jLabel12.setText("Email:");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/telephone.png"))); // NOI18N
        jLabel11.setText("Telefone:");

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        try {
            txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/phone.png"))); // NOI18N
        jLabel19.setText("Celular:");

        txtTelCel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelCelKeyTyped(evt);
            }
        });

        jBtnEditarContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jBtnEditarContato.setText("Editar");
        jBtnEditarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarContatoActionPerformed(evt);
            }
        });

        jBtnSalvarContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jBtnSalvarContato.setText("Salvar");
        jBtnSalvarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarContatoActionPerformed(evt);
            }
        });

        jBtbCancelContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtbCancelContato.setText("Cancelar");
        jBtbCancelContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelContatoActionPerformed(evt);
            }
        });

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(4, 4, 4)
                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnEditarContato)
                            .addComponent(jBtbCancelContato)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(10, 10, 10)
                        .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jBtnSalvarContato))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnEditarContato)
                    .addComponent(jBtbCancelContato))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel19))
                    .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalvarContato))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jPanel4.setBackground(new java.awt.Color(235, 235, 253));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        txtEndNum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtEndNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEndNumKeyTyped(evt);
            }
        });

        jLabel21.setText("Nº:");

        jBtnSalvarEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jBtnSalvarEndereco.setText("Salvar");
        jBtnSalvarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarEnderecoActionPerformed(evt);
            }
        });

        txtEndCidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel16.setText("Estado:");

        jLabel13.setText("Cep:");

        txtEndRua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel18.setText("Bairro:");

        jBtnEditarEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jBtnEditarEndereco.setText("Editar");
        jBtnEditarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarEnderecoActionPerformed(evt);
            }
        });

        txtEndBairro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jBtbCancelEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtbCancelEndereco.setText("Cancelar");
        jBtbCancelEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelEnderecoActionPerformed(evt);
            }
        });

        jLabel20.setText("Rua:");

        jLabel17.setText("País:");

        jLabel15.setText("Cidade:");

        txtEndPais.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtEndEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtEndEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEndEstadoKeyTyped(evt);
            }
        });

        try {
            txtEndCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtEndCep.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jBtnCarregaCep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.gif"))); // NOI18N
        jBtnCarregaCep.setText("Buscar");
        jBtnCarregaCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCarregaCepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtEndPais, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel13)
                        .addGap(27, 27, 27)
                        .addComponent(txtEndCep, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jBtnCarregaCep)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel16)
                        .addGap(4, 4, 4)
                        .addComponent(txtEndEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtbCancelEndereco)
                            .addComponent(jBtnEditarEndereco)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(8, 8, 8)
                                .addComponent(txtEndCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jLabel18))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(22, 22, 22)
                                .addComponent(txtEndRua, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jLabel21)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndNum, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtEndBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jBtnSalvarEndereco)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel17))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtEndPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel13))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtEndCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBtnCarregaCep)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtEndEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtbCancelEndereco)
                            .addComponent(jBtnEditarEndereco))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEndCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalvarEndereco)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(txtEndRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(txtEndNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 475, 808, 140));

        jPanel2.setBackground(new java.awt.Color(235, 235, 253));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jTextNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextSalario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextSalarioKeyTyped(evt);
            }
        });

        jTextCargo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel8.setText("Data de admição:");

        jLabel1.setText("Nome:");

        jLabel5.setText("Salário:");

        jLabel3.setText("Cpf:");

        jLabel4.setText("Cargo:");

        jLabel2.setText("RG:");

        try {
            jTextRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextRg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        try {
            jTextCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextCpf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLbDataAdmissao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLbDataAdmissao.setText("Data Admissão");

        jBtnEditarFuncionairo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jBtnEditarFuncionairo.setText("Editar");
        jBtnEditarFuncionairo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarFuncionairoActionPerformed(evt);
            }
        });

        jBtnSalvarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jBtnSalvarFuncionario.setText("Salvar");
        jBtnSalvarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarFuncionarioActionPerformed(evt);
            }
        });

        jBtnCancelarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelarFuncionario.setText("Cancelar");
        jBtnCancelarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(jTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(290, 290, 290)
                        .addComponent(jTextRg))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(21, 21, 21)
                                .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel8))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLbDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnSalvarFuncionario)
                    .addComponent(jBtnCancelarFuncionario)
                    .addComponent(jBtnEditarFuncionairo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLbDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnCancelarFuncionario)
                            .addComponent(jBtnEditarFuncionairo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jBtnSalvarFuncionario)
                    .addComponent(jTextSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        id.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        id.setText("jLabel10");
        jPanel5.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 125, -1));

        jPanel1.setBackground(new java.awt.Color(235, 235, 253));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carteira de Trabalho", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jLabel22.setText("CTPS:");

        try {
            jTextCtps.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.#####.##-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextCtps.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel23.setText("Nº:");

        jTextNumCtps.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextNumCtps.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNumCtpsKeyTyped(evt);
            }
        });

        jLabel24.setText("Série:");

        jTextSerieCtps.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextSerieCtps.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextSerieCtpsKeyTyped(evt);
            }
        });

        jLabel25.setText("UF:");

        jComboUf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jBtnEditarCarteira.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jBtnEditarCarteira.setText("Editar");
        jBtnEditarCarteira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarCarteiraActionPerformed(evt);
            }
        });

        jBtnSalvarCarteira.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jBtnSalvarCarteira.setText("Salvar");
        jBtnSalvarCarteira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarCarteiraActionPerformed(evt);
            }
        });

        jBtbCancelCarteira.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtbCancelCarteira.setText("Cancelar");
        jBtbCancelCarteira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelCarteiraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(22, 22, 22)
                        .addComponent(jTextCtps, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnEditarCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtbCancelCarteira)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextNumCtps, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextSerieCtps, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jBtnSalvarCarteira))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(34, 34, 34)
                        .addComponent(jComboUf, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnEditarCarteira)
                        .addComponent(jBtbCancelCarteira))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel22)))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextNumCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnSalvarCarteira))
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jTextSerieCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jComboUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 373, 170));

        jLabel6.setText("Código do funcionário:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, -1, -1));

        jBtnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/resultset_previous.png"))); // NOI18N
        jBtnVoltar.setText("Voltar");
        jBtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3.png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSalvarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarFuncionarioActionPerformed
        
        if (VerificaCamposFunc()) {

            if (FuncionarioDAO.VerificarFuncionario(jTextCpf.getText()) == false) {

                Funcionario func = new Funcionario();
                func.setFuncionario(jTextNome.getText());
                func.setRg(jTextRg.getText());
                func.setCpf(jTextCpf.getText());
                func.setCargo(jTextCargo.getText());
                func.setSalario(Double.parseDouble(jTextSalario.getText()));
                func.setDataAdmicao(FuncoesDiversas.FormataData(txtDataAdmissao.getDate()));
                FuncionarioDAO.UpdateFuncionario(func, idFuncionario);
                CarregaFuncionario();
                desabilitarDadosPessoais();
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
                String descricaoAudit = "Funcionário(a) " + func.getFuncionario() + " /CPF: " + func.getCpf() + "teve dado(s) alterado(s).";
                AuditoriaDAO.CadDetAuditoria(descricaoAudit);
                
            } else if (jTextCpf.getText() == null ? fun == null : jTextCpf.getText().equals(fun)) {

                Funcionario func = new Funcionario();
                func.setFuncionario(jTextNome.getText());
                func.setRg(jTextRg.getText());
                func.setCpf(jTextCpf.getText());
                func.setCargo(jTextCargo.getText());
                func.setSalario(Double.parseDouble(jTextSalario.getText()));
                func.setDataAdmicao(FuncoesDiversas.FormataData(txtDataAdmissao.getDate()));
                FuncionarioDAO.UpdateFuncionario(func, idFuncionario);
                CarregaFuncionario();
                desabilitarDadosPessoais();
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
                String descricaoAudit = "Funcionário(a) " + func.getFuncionario() + " /CPF: " + func.getCpf() + "teve dado(s) alterado(s).";
                AuditoriaDAO.CadDetAuditoria(descricaoAudit);

            } else {
                JOptionPane.showMessageDialog(null, "Este Funcionario ja está cadastrado !");
            }
        }
    }//GEN-LAST:event_jBtnSalvarFuncionarioActionPerformed

    private void jBtnCancelarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarFuncionarioActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Cancelar alteração?", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
            desabilitarDadosPessoais();
            CarregaFuncionario();
        }
    }//GEN-LAST:event_jBtnCancelarFuncionarioActionPerformed

    private void jBtnEditarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarContatoActionPerformed
        EditarContato();
    }//GEN-LAST:event_jBtnEditarContatoActionPerformed

    private void jBtnSalvarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarContatoActionPerformed
        if (VerificaCamposContato()) {
            Telefone tel = new Telefone();
            tel.setTel(txtTel.getText());
            tel.setCel(txtTelCel.getText());
            ContatosDAO.UpdateTel2(idContato, tel);
            ContatosDAO.UpdateEmail2(idContato, txtEmail.getText());
            desabilitarContato();
            jBtnEditarContato.setVisible(true);
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            String descricaoAudit = "Funcionário(a) " + jTextNome.getText() + " /CPF: " + jTextCpf.getText() + "teve o contato alterado.";
            AuditoriaDAO.CadDetAuditoria(descricaoAudit);
        }
    }//GEN-LAST:event_jBtnSalvarContatoActionPerformed

    private void jBtbCancelContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbCancelContatoActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Cancelar alteração?", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
            desabilitarContato();
            CarregaFuncionario();
            jLabelEmail.setText("");
        }
    }//GEN-LAST:event_jBtbCancelContatoActionPerformed

    private void jBtnEditarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarEnderecoActionPerformed
        EditarEndereco();
    }//GEN-LAST:event_jBtnEditarEnderecoActionPerformed

    private void jBtnSalvarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarEnderecoActionPerformed
        if (VerificaCamposEndereco()) {
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
            jBtnEditarEndereco.setVisible(true);
            jBtbCancelEndereco.setVisible(false);
            jBtnSalvarEndereco.setVisible(false);
            desabilitarEndereco();
            CarregaFuncionario();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            String descricaoAudit = "Funcionário(a) " + jTextNome.getText() + " /CPF: " + jTextCpf.getText() + "teve o endereço alterado.";
            AuditoriaDAO.CadDetAuditoria(descricaoAudit);
        }
    }//GEN-LAST:event_jBtnSalvarEnderecoActionPerformed

    private void jBtbCancelEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbCancelEnderecoActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Cancelar alteração?", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
            desabilitarEndereco();
            CarregaFuncionario();
        }
    }//GEN-LAST:event_jBtbCancelEnderecoActionPerformed

    private void jBtnEditarFuncionairoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarFuncionairoActionPerformed
        EditarDadosPessoais();

        fun = jTextCpf.getText();

    }//GEN-LAST:event_jBtnEditarFuncionairoActionPerformed

    private void jBtnCarregaCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCarregaCepActionPerformed
        if (txtEndCep.getText().trim().equals("-")) {
            JOptionPane.showMessageDialog(null, "Primeiro preencha o campo CEP!");
        } else {
            CarregaCep();
        }
    }//GEN-LAST:event_jBtnCarregaCepActionPerformed

    private void jBtnEditarCarteiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarCarteiraActionPerformed
        EditarCarteira();
    }//GEN-LAST:event_jBtnEditarCarteiraActionPerformed

    private void jBtnSalvarCarteiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarCarteiraActionPerformed
        if (VerificaCamposCarteira()) {

            Funcionario func = new Funcionario();

            func.setCtps(jTextCtps.getText());
            func.setNumCtps(jTextNumCtps.getText());
            func.setSerieCtps(jTextSerieCtps.getText());
            func.setUfCtps(jComboUf.getSelectedItem().toString());

            FuncionarioDAO.UpdateCarteiraFuncionario(func, idFuncionario);

            desabilitarCarteira();
            CarregaFuncionario();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            String descricaoAudit = "Funcionário(a) " + jTextNome.getText() + " /CPF: " + jTextCpf.getText() + "teve o(s) dado(s) da carteira alterado(s).";
            AuditoriaDAO.CadDetAuditoria(descricaoAudit);
        }
    }//GEN-LAST:event_jBtnSalvarCarteiraActionPerformed

    private void jBtbCancelCarteiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbCancelCarteiraActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Cancelar alteração?", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
            desabilitarCarteira();
            CarregaFuncionario();
        }
    }//GEN-LAST:event_jBtbCancelCarteiraActionPerformed

    private void jBtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarActionPerformed
        verificaPagina();
    }//GEN-LAST:event_jBtnVoltarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void jTextSalarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextSalarioKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321rR$:.,%£¢;";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }

    }//GEN-LAST:event_jTextSalarioKeyTyped

    private void jTextNumCtpsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNumCtpsKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321.,-";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextNumCtpsKeyTyped

    private void jTextSerieCtpsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextSerieCtpsKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSerieCtpsKeyTyped

    private void txtEndNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEndNumKeyTyped
        // TODO add your handling code here:

        String caracteres = "0987654321snSN";
        String car = txtEndNum.getText().toUpperCase();
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEndNumKeyTyped

    private void txtEndEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEndEstadoKeyTyped
        // TODO add your handling code here:

        String caracteres = "0987654321";

        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEndEstadoKeyTyped

    private void txtTelCelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelCelKeyTyped
        // TODO add your handling code here:

        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelCelKeyTyped

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

                    String ceptxt = txtEndCep.getText();
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
                    t1.join();//fica esperando a primeira thread acabar
                    telaFunc.setEnabled(true);  // quando acabar fecha a janela de espera
                    telaTeste.dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(AlterarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    private boolean VerificaCamposFunc() {

        boolean valida = true;

        if (jTextNome.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (jTextCargo.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (jTextRg.getText().trim().length() != 13) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (jTextCpf.getText().trim().length() != 14) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtDataAdmissao.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (jTextSalario.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }
        return valida;
    }

    private boolean VerificaCamposContato() {

        boolean valida = true;

        if (txtTel.getText().trim().length() != 13) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtTelCel.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (ValidaEmail()) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }
        return valida;
    }

    private boolean VerificaCamposEndereco() {

        boolean valida = true;

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

        if (txtEndCep.getText().trim().equals("-")) {
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

    private boolean VerificaCamposCarteira() {

        boolean valida = true;

        if (jTextCtps.getText().trim().length() != 14) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (jTextNumCtps.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (jTextSerieCtps.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (jComboUf.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um item!");
            valida = false;
            return valida;
        }
        return valida;
    }

    private void verificaPagina() {
        if ((this.telaExibeFunc != null)) {
            this.telaExibeFunc.setVisible(true);
            telaExibeFunc.TabelaFuncionario("select * from tabfuncionario;");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel id;
    private javax.swing.JButton jBtbCancelCarteira;
    private javax.swing.JButton jBtbCancelContato;
    private javax.swing.JButton jBtbCancelEndereco;
    private javax.swing.JButton jBtnCancelarFuncionario;
    private javax.swing.JButton jBtnCarregaCep;
    private javax.swing.JButton jBtnEditarCarteira;
    private javax.swing.JButton jBtnEditarContato;
    private javax.swing.JButton jBtnEditarEndereco;
    private javax.swing.JButton jBtnEditarFuncionairo;
    private javax.swing.JButton jBtnSalvarCarteira;
    private javax.swing.JButton jBtnSalvarContato;
    private javax.swing.JButton jBtnSalvarEndereco;
    private javax.swing.JButton jBtnSalvarFuncionario;
    private javax.swing.JButton jBtnVoltar;
    private javax.swing.JComboBox jComboUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLbDataAdmissao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextCargo;
    private javax.swing.JFormattedTextField jTextCpf;
    private javax.swing.JFormattedTextField jTextCtps;
    private javax.swing.JTextField jTextNome;
    private javax.swing.JTextField jTextNumCtps;
    private javax.swing.JFormattedTextField jTextRg;
    private javax.swing.JTextField jTextSalario;
    private javax.swing.JTextField jTextSerieCtps;
    private com.toedter.calendar.JDateChooser txtDataAdmissao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndBairro;
    private javax.swing.JFormattedTextField txtEndCep;
    private javax.swing.JTextField txtEndCidade;
    private javax.swing.JTextField txtEndEstado;
    private javax.swing.JTextField txtEndNum;
    private javax.swing.JTextField txtEndPais;
    private javax.swing.JTextField txtEndRua;
    private javax.swing.JFormattedTextField txtTel;
    private javax.swing.JTextField txtTelCel;
    // End of variables declaration//GEN-END:variables
}
