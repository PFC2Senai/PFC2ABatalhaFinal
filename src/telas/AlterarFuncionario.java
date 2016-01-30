package telas;

import atributos.Endereco;
import atributos.Funcionario;
import atributos.Telefone;
import funcoes.CarregaCEP;
import funcoes.ContatosDAO;
import funcoes.FuncionarioDAO;
import funcoes.FuncoesDiversas;
import static funcoes.FuncoesDiversas.ConverterData;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static telas.ExibeFuncionario.GetIndice;



public class AlterarFuncionario extends javax.swing.JFrame {
    
    private int idContato;
    private AlterarFuncionario telaFunc;
    private int idFuncionario;

    /**
     * Creates new form AlterarFuncionario
     */
    public AlterarFuncionario() {
        telaFunc = this;
        this.idFuncionario = GetIndice();       
        this.idContato = FuncionarioDAO.idContato(idFuncionario);
        
        initComponents();
        CarregaFuncionario();
    }

    private void CarregaFuncionario() {
        
        OcultaBotoes();
        desabilitarEndereco();
        desabilitarContato();
        desabilitarDadosPessoais();
        
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
    }
    
     private void OcultaBotoes() {
        
       jBtbCancelContato.setVisible(false);
       jBtbCancelEndereco.setVisible(false);
       jBtnAltContato.setVisible(false);
       jBtnAltEndereco.setVisible(false);
    }
    
    private void desabilitarDadosPessoais() {
        //desabilita campos dados pessoais
        id.setEnabled(false);
        jTextNome.setEnabled(false);        
        jTextRg.setEnabled(false);
        jTextCpf.setEnabled(false);
        jTextCargo.setEnabled(false);
        jTextSalario.setEnabled(false);
//        jTextCtps.setEnabled(false);
//        jTextNumCtps.setEnabled(false);
//        jTextSerieCtps.setEnabled(false);
//        jComboUf.setEnabled(false);
        txtDataAdmissao.setEnabled(false);       
      // customiza o textfild
        jTextNome.setOpaque(false);
        jTextNome.setBackground(new Color(0,0,0,0));
        jTextNome.setBorder(null);
        jTextRg.setOpaque(false);
        jTextRg.setBackground(new Color(0,0,0,0));
        jTextCpf.setOpaque(false);
        jTextCpf.setBackground(new Color(0,0,0,0));
        jTextCargo.setOpaque(false);
        jTextCargo.setBackground(new Color(0,0,0,0));
        jTextCtps.setBackground(new Color(0,0,0,0));
      //oculta botoes  
        jButton1.setVisible(false);
        jButton3.setVisible(false);
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jTextCtps = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextNumCtps = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextSerieCtps = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jComboUf = new javax.swing.JComboBox();
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
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTel = new javax.swing.JFormattedTextField();
        jButtonAr2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtTelCel = new javax.swing.JTextField();
        jBtnAltContato = new javax.swing.JButton();
        jBtbCancelContato = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtEndNum = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jBtnAltEndereco = new javax.swing.JButton();
        txtEndCidade = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtEndRua = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jButtonAr3 = new javax.swing.JButton();
        txtEndBairro = new javax.swing.JTextField();
        jBtbCancelEndereco = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtEndPais = new javax.swing.JTextField();
        txtEndEstado = new javax.swing.JTextField();
        txtEndCep = new javax.swing.JFormattedTextField();
        jBtnCarregaCep = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("EDITAR FUNCIONÁRIO");

        id.setText("jLabel10");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/stop2.png"))); // NOI18N
        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carteira de Trabalho", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jLabel22.setText("CTPS:");

        try {
            jTextCtps.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.#####.##-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel23.setText("Nº:");

        jLabel24.setText("Série:");

        jLabel25.setText("UF:");

        jComboUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextCtps)
                    .addComponent(jTextNumCtps)
                    .addComponent(jTextSerieCtps)
                    .addComponent(jComboUf, 0, 159, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel22))
                    .addComponent(jTextCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jTextNumCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextSerieCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jComboUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

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

        try {
            jTextCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLbDataAdmissao.setText("data Admissão");

        jButton4.setText("Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Salvar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLbDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addGap(51, 51, 51)
                        .addComponent(jTextSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(jTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(jTextRg, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLbDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4))
                    .addComponent(txtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jTextCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel5))
                            .addComponent(jTextSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/email.png"))); // NOI18N
        jLabel12.setText("Email:");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/telephone.png"))); // NOI18N
        jLabel11.setText("Telefone:");

        try {
            txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButtonAr2.setText("Editar");
        jButtonAr2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr2ActionPerformed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/phone.png"))); // NOI18N
        jLabel19.setText("Celular:");

        jBtnAltContato.setText("Salvar");
        jBtnAltContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltContatoActionPerformed(evt);
            }
        });

        jBtbCancelContato.setText("Cancelar");
        jBtbCancelContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelContatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(4, 4, 4)
                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel19)
                .addGap(10, 10, 10)
                .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonAr2))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel12)
                .addGap(22, 22, 22)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jBtnAltContato, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(398, 398, 398)
                .addComponent(jBtbCancelContato))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel19))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonAr2))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnAltContato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtbCancelContato)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jLabel21.setText("Numero:");

        jBtnAltEndereco.setText("Salvar");
        jBtnAltEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltEnderecoActionPerformed(evt);
            }
        });

        jLabel16.setText("Estado:");

        jLabel13.setText("Cep:");

        jLabel18.setText("Bairro:");

        jButtonAr3.setText("Editar");
        jButtonAr3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr3ActionPerformed(evt);
            }
        });

        jBtbCancelEndereco.setText("Cancelar");
        jBtbCancelEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelEnderecoActionPerformed(evt);
            }
        });

        jLabel20.setText("Rua:");

        jLabel17.setText("País:");

        jLabel15.setText("Cidade:");

        try {
            txtEndCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtEndPais, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addGap(27, 27, 27)
                        .addComponent(txtEndCep, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCarregaCep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEndRua, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(txtEndCidade)))
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(txtEndBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(9, 9, 9)
                                .addComponent(txtEndNum, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jButtonAr3))
                    .addComponent(jBtbCancelEndereco)
                    .addComponent(jBtnAltEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEndPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtEndCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jBtnCarregaCep)
                            .addComponent(jLabel16)
                            .addComponent(txtEndEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEndCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18)
                            .addComponent(txtEndBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(txtEndRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(txtEndNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonAr3)
                        .addGap(7, 7, 7)
                        .addComponent(jBtnAltEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jBtbCancelEndereco)
                        .addGap(28, 28, 28))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(608, 608, 608)
                                .addComponent(id)
                                .addGap(0, 50, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(jButton5)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Funcionario func = new Funcionario();
        func.setFuncionario(jTextNome.getText());
        func.setRg(jTextRg.getText());
        func.setCpf(jTextCpf.getText());
        func.setCargo(jTextCargo.getText());
        func.setSalario(Double.parseDouble(jTextSalario.getText()));
        func.setDataAdmicao(FuncoesDiversas.FormataData(txtDataAdmissao.getDate()));
        FuncionarioDAO.UpdateFuncionario(func, idFuncionario);
       // this.dispose();
        //new ExibeFuncionario().setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton4.setVisible(true);
        jButton3.setVisible(false);
        jButton1.setVisible(false);
        desabilitarDadosPessoais();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonAr2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAr2ActionPerformed
        txtTel.setEnabled(true);
        txtTelCel.setEnabled(true);
        txtEmail.setEnabled(true);

        jButtonAr2.setVisible(false);
        jBtbCancelContato.setVisible(true);
        jBtnAltContato.setVisible(true);
    }//GEN-LAST:event_jButtonAr2ActionPerformed

    private void jBtnAltContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltContatoActionPerformed

        Telefone tel = new Telefone();
        tel.setTel(txtTel.getText());
        tel.setCel(txtTelCel.getText());
        ContatosDAO.UpdateTel2(idContato, tel);       
        ContatosDAO.UpdateEmail2(idContato, txtEmail.getText()); 
        desabilitarContato();
        jButtonAr2.setVisible(true);
    }//GEN-LAST:event_jBtnAltContatoActionPerformed

    private void jBtbCancelContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbCancelContatoActionPerformed
        desabilitarContato();
        jButtonAr2.setVisible(true);
    }//GEN-LAST:event_jBtbCancelContatoActionPerformed

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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Date d = ConverterData(jLbDataAdmissao.getText());
        txtDataAdmissao.setDate(d);
        jTextNome.setEnabled(true);
        jTextRg.setEnabled(true);
        jTextCpf.setEnabled(true);
        jTextCargo.setEnabled(true);
        jTextSalario.setEnabled(true);
        txtDataAdmissao.setEnabled(true);
        
//        jTextCtps.setEnabled(true);
//        jTextNumCtps.setEnabled(true);
//        jTextSerieCtps.setEnabled(true);
//        jComboUf.setEnabled(true);

        jButton4.setVisible(false);
        jButton1.setVisible(true);
        jButton3.setVisible(true);        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jBtnCarregaCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCarregaCepActionPerformed
        if (txtEndCep.getText().trim().equals("-")) {
            JOptionPane.showMessageDialog(null, "Primeiro preencha o campo CEP!");
        } else {
            CarregaCep();
        }
    }//GEN-LAST:event_jBtnCarregaCepActionPerformed

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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel id;
    private javax.swing.JButton jBtbCancelContato;
    private javax.swing.JButton jBtbCancelEndereco;
    private javax.swing.JButton jBtnAltContato;
    private javax.swing.JButton jBtnAltEndereco;
    private javax.swing.JButton jBtnCarregaCep;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonAr2;
    private javax.swing.JButton jButtonAr3;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLbDataAdmissao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
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
