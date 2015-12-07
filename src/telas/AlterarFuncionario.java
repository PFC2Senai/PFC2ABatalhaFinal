package telas;

import atributos.Endereco;
import atributos.Funcionario;
import atributos.Lembrete;
import atributos.Telefone;
import funcoes.ContatosDAO;
import static funcoes.ContatosDAO.CodTel;
import funcoes.FuncionarioDAO;
import funcoes.LembreteDAO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static telas.ExibeFuncionario.GetIndice;

/**
 *
 * @author WilhamJr
 */
public class AlterarFuncionario extends javax.swing.JFrame {
    int idContato;
    int codTel;
    int codCel;

    /**
     * Creates new form AlterarFuncionario
     */
    public AlterarFuncionario() {
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
        
        for (Funcionario func : funcionario){
            id.setText(String.valueOf(func.getId()));
            jTextNome.setText(func.getFuncionario());
            jTextRg.setText(func.getRg());
            jTextCpf.setText(func.getCpf());
            jTextCargo.setText(func.getCargo());
            jTextSalario.setText(String.valueOf(func.getSalario()));
            jTextCodContato.setText(String.valueOf(func.getIdContato()));
            jTextCodUsuario.setText(String.valueOf(func.getIdUsuario()));
            jTextDataAdmicao.setText(func.getDataAdmicao());
            jTextCtps.setText(String.valueOf(func.getCtps()));
            jTextNumCtps.setText(String.valueOf(func.getNumCtps()));
            jTextSerieCtps.setText(func.getSerieCtps());
            jComboUf.setSelectedItem(func.getUfCtps());
            
            idContato = func.getId();
            id.setText(String.valueOf(func.getId()));
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
        jTextCtps.setEnabled(false);
        jTextNumCtps.setEnabled(false);
        jTextSerieCtps.setEnabled(false);
        jComboUf.setEnabled(false);
        jTextCodContato.setEnabled(false);
        jTextCodUsuario.setEnabled(false);
        jTextDataAdmicao.setEnabled(false);
        jTextCtps.setEnabled(false);
        jTextNumCtps.setEnabled(false);
        jTextCtps.setEnabled(false);
        jComboUf.setEnabled(false);
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
    
    /*public void TabelaLembrete2(int idcli){
        
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
    } */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextDataAdmicao = new javax.swing.JTextField();
        jTextNome = new javax.swing.JTextField();
        jTextRg = new javax.swing.JTextField();
        jTextCpf = new javax.swing.JTextField();
        jTextCargo = new javax.swing.JTextField();
        jTextSalario = new javax.swing.JTextField();
        jTextCodUsuario = new javax.swing.JTextField();
        jTextCodContato = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txtTel = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonAr2 = new javax.swing.JButton();
        jBtnAltContato = new javax.swing.JButton();
        txtTelCel = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jBtbCancelContato = new javax.swing.JButton();
        jButtonAr3 = new javax.swing.JButton();
        txtEndCep = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtEndPais = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtEndCidade = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtEndEstado = new javax.swing.JTextField();
        jBtnAltEndereco = new javax.swing.JButton();
        jBtbCancelEndereco = new javax.swing.JButton();
        txtEndBairro = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtEndRua = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtEndNum = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextDataAdmicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDataAdmicaoActionPerformed(evt);
            }
        });

        jTextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeActionPerformed(evt);
            }
        });

        jTextRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextRgActionPerformed(evt);
            }
        });

        jTextCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCpfActionPerformed(evt);
            }
        });

        jTextCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCargoActionPerformed(evt);
            }
        });

        jTextSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSalarioActionPerformed(evt);
            }
        });

        jTextCodUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCodUsuarioActionPerformed(evt);
            }
        });

        jTextCodContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCodContatoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("RG:");

        jLabel3.setText("Cpf:");

        jLabel4.setText("Cargo:");

        jLabel5.setText("Salário:");

        jLabel6.setText("Cód Contato:");

        jLabel7.setText("Cod Usuario:");

        jLabel8.setText("Data de admição:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Editar Funcionário");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Salvar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        id.setText("jLabel10");

        jButton4.setText("Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        try {
            txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel10.setText("CONTATO:");

        jLabel11.setText("Telefone:");

        jButtonAr2.setText("Editar");
        jButtonAr2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr2ActionPerformed(evt);
            }
        });

        jBtnAltContato.setText("Salvar");
        jBtnAltContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltContatoActionPerformed(evt);
            }
        });

        jLabel19.setText("Celular:");

        jLabel12.setText("Email:");

        jBtbCancelContato.setText("Cancelar");
        jBtbCancelContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelContatoActionPerformed(evt);
            }
        });

        jButtonAr3.setText("Editar");
        jButtonAr3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr3ActionPerformed(evt);
            }
        });

        jLabel13.setText("Cep:");

        jLabel14.setText("ENDEREÇO:");

        jLabel17.setText("País:");

        jLabel15.setText("Cidade:");

        jLabel16.setText("Estado:");

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

        jLabel18.setText("Bairro:");

        jLabel20.setText("Rua:");

        jLabel21.setText("Numero:");

        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Carteira de Trabalho", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

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
                .addContainerGap(15, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jTextNumCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextSerieCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jComboUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextCodContato, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4))))
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(22, 22, 22)
                                .addComponent(jTextDataAdmicao, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(75, 75, 75)
                                        .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(88, 88, 88)
                                        .addComponent(jTextRg, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(85, 85, 85)
                                        .addComponent(jTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(73, 73, 73)
                                        .addComponent(jTextCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(70, 70, 70)
                                        .addComponent(jTextSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(id))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(37, 37, 37)
                                .addComponent(txtEndPais, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel13)
                                .addGap(7, 7, 7)
                                .addComponent(txtEndCep, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jButtonAr3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(14, 14, 14)
                                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(jButtonAr2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(23, 23, 23)
                                        .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBtnAltContato, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(32, 32, 32)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(jBtbCancelContato))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel20))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtEndRua, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel21)
                                        .addGap(9, 9, 9)
                                        .addComponent(txtEndNum, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtEndCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabel16)
                                                .addGap(13, 13, 13)
                                                .addComponent(txtEndEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtEndBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jBtnAltEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jBtbCancelEndereco))))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel1))
                            .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2))
                            .addComponent(jTextRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(jTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel4))
                            .addComponent(jTextCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel5))
                            .addComponent(jTextSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextCodContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel8))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextDataAdmicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAr2))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(txtTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAltContato))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtbCancelContato))
                .addGap(27, 27, 27)
                .addComponent(jLabel14)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEndPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel13)
                            .addComponent(jButtonAr3))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel16))
                            .addComponent(txtEndEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(txtEndBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnAltEndereco)
                                .addGap(7, 7, 7)
                                .addComponent(jBtbCancelEndereco)))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(txtEndRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txtEndNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextDataAdmicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDataAdmicaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDataAdmicaoActionPerformed

    private void jTextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeActionPerformed

    private void jTextRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextRgActionPerformed

    private void jTextCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCpfActionPerformed

    private void jTextCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCargoActionPerformed

    private void jTextSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSalarioActionPerformed

    private void jTextCodUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCodUsuarioActionPerformed

    private void jTextCodContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodContatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCodContatoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextNome.setText("");
        jTextRg.setText("");
        jTextCpf.setText("");
        jTextCargo.setText("");
        jTextSalario.setText("");
        jTextCodContato.setText("");
        jTextCodUsuario.setText("");
        jTextDataAdmicao.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Funcionario func = new Funcionario();
        func.setFuncionario(jTextNome.getText());
        func.setRg(jTextRg.getText());
        func.setCpf(jTextCpf.getText());
        func.setCargo(jTextCargo.getText());
        func.setSalario(Double.parseDouble(jTextSalario.getText()));
        func.setIdContato(Integer.parseInt(jTextCodContato.getText()));
        func.setIdUsuario(Integer.parseInt(jTextCodUsuario.getText()));
        func.setDataAdmicao(jTextDataAdmicao.getText());
        FuncionarioDAO.UpdateFuncionario(func, GetIndice());
        this.dispose();
        new ExibeFuncionario().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton4.setVisible(true);
        jButton3.setVisible(false);
        jButton1.setVisible(false);
        desabilitarDadosPessoais();
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void jBtnAltContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltContatoActionPerformed

        Telefone tel = new Telefone();
        tel.setTel(txtTel.getText());
        tel.setCel(txtTelCel.getText());
        ContatosDAO.UpdateTel(codTel, tel);       
        ContatosDAO.UpdateEmail(idContato, txtEmail.getText()); 
        desabilitarContato();
        jButtonAr2.setVisible(true);
        
        /*ContatosDAO.UpdateTel(codTel, txtTel.getText());
        ContatosDAO.UpdateTel(codCel, txtTelCel.getText());
        ContatosDAO.UpdateEmail(idContato, txtEmail.getText());
        desabilitarContato();
        jButtonAr2.setVisible(true);*/
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
        //codTel = CodTel(txtTel.getText().trim());
       // codCel = CodTel(txtTelCel.getText());

        jTextNome.setEnabled(true);
        jTextRg.setEnabled(true);
        jTextCpf.setEnabled(true);
        jTextCargo.setEnabled(true);
        jTextSalario.setEnabled(true);
        jTextCodContato.setEnabled(true);
        jTextCodUsuario.setEnabled(true);
        jTextDataAdmicao.setEnabled(true);
        jTextCtps.setEnabled(true);
        jTextNumCtps.setEnabled(true);
        jTextSerieCtps.setEnabled(true);
        jComboUf.setEnabled(true);

        jButton4.setVisible(false);
        jButton1.setVisible(true);
        jButton3.setVisible(true);        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel id;
    private javax.swing.JButton jBtbCancelContato;
    private javax.swing.JButton jBtbCancelEndereco;
    private javax.swing.JButton jBtnAltContato;
    private javax.swing.JButton jBtnAltEndereco;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonAr2;
    private javax.swing.JButton jButtonAr3;
    private javax.swing.JComboBox jComboUf;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextCargo;
    private javax.swing.JTextField jTextCodContato;
    private javax.swing.JTextField jTextCodUsuario;
    private javax.swing.JTextField jTextCpf;
    private javax.swing.JFormattedTextField jTextCtps;
    private javax.swing.JTextField jTextDataAdmicao;
    private javax.swing.JTextField jTextNome;
    private javax.swing.JTextField jTextNumCtps;
    private javax.swing.JTextField jTextRg;
    private javax.swing.JTextField jTextSalario;
    private javax.swing.JTextField jTextSerieCtps;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndBairro;
    private javax.swing.JTextField txtEndCep;
    private javax.swing.JTextField txtEndCidade;
    private javax.swing.JTextField txtEndEstado;
    private javax.swing.JTextField txtEndNum;
    private javax.swing.JTextField txtEndPais;
    private javax.swing.JTextField txtEndRua;
    private javax.swing.JFormattedTextField txtTel;
    private javax.swing.JTextField txtTelCel;
    // End of variables declaration//GEN-END:variables
}
