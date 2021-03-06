package telas;

import funcoes.Conexao;
import funcoes.ControleBackup;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import static telas.TelaLogin.TipoUsuario;

/**
 *
 * @author 015365
 */
public class Menu extends javax.swing.JFrame {

    Conexao conexao = new Conexao();
    
    private String caminho;
    private Menu telaMenu;
    

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public Menu(String user) {
        initComponents();
        conexao.conexao();
        verificaUsuario();
        jLabelUsuario.setText(user);
        telaMenu = this;
        jBtnRotinaContato.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnRotinaContato.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnCadastrarLembrete.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnCadastrarLembrete.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnProposta.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnProposta.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnFazerBackup.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnFazerBackup.setHorizontalTextPosition(SwingConstants.CENTER);
        
//    try {
//            conexao.executaSQL("select * from tabusuario where usuario = '"+jLabelUsuario.getText()+"'");
//            conexao.rs.first();
//            
//            if(conexao.rs.getString("tipo_usuario").equals("F")){
//            //jMenu14.setVisible(false);   
//            
//            }
//            
//            else{}
//        } catch (SQLException ex) {
//            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
//        }
    
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnRotinaContato = new javax.swing.JButton();
        jBtnCadastrarLembrete = new javax.swing.JButton();
        jBtnProposta = new javax.swing.JButton();
        jBtnFazerBackup = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jBtnLogout = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItemCadastrarServico = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImages(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnRotinaContato.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnRotinaContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1452414361_kontact_1.png"))); // NOI18N
        jBtnRotinaContato.setText("Rotina de Contato");
        jBtnRotinaContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRotinaContatoActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnRotinaContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, -1));

        jBtnCadastrarLembrete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnCadastrarLembrete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CadastrarLembrete.png"))); // NOI18N
        jBtnCadastrarLembrete.setText("Lembrete");
        jBtnCadastrarLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarLembreteActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnCadastrarLembrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 150, -1));

        jBtnProposta.setBackground(new java.awt.Color(153, 255, 0));
        jBtnProposta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnProposta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1452415489_icon-57.fw_1.png"))); // NOI18N
        jBtnProposta.setText("Proposta");
        jBtnProposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPropostaActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnProposta, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 150, -1));

        jBtnFazerBackup.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnFazerBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/backup (2).png"))); // NOI18N
        jBtnFazerBackup.setText("Fazer Backup");
        jBtnFazerBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFazerBackupActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnFazerBackup, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 190, -1));

        jLabel2.setText("Usuário:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 40, 20));

        jLabelUsuario.setForeground(new java.awt.Color(255, 0, 0));
        jLabelUsuario.setText("jLabel3");
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 190, 20));

        jBtnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.gif"))); // NOI18N
        jBtnLogout.setText("Desconectar");
        jBtnLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jBtnLogout.setContentAreaFilled(false);
        jBtnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBtnLogout.setSelected(true);
        jBtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 540, -1, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logopronta.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 570));

        jMenuBar1.setPreferredSize(new java.awt.Dimension(106, 35));

        jMenu4.setBackground(new java.awt.Color(204, 153, 255));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menu.png"))); // NOI18N
        jMenu4.setText("Menu");
        jMenu4.setPreferredSize(new java.awt.Dimension(70, 25));
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenu4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu4KeyPressed(evt);
            }
        });

        jMenu14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jMenu14.setText("Cadastrar");
        jMenu14.setMaximumSize(new java.awt.Dimension(35767, 35767));
        jMenu14.setPreferredSize(new java.awt.Dimension(130, 35));

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cliente3.png"))); // NOI18N
        jMenuItem10.setText("Cliente");
        jMenuItem10.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem10);

        jMenuItem29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/maquina02.png"))); // NOI18N
        jMenuItem29.setText("Equipamento");
        jMenuItem29.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem29);

        jMenuItem26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fabricante.png"))); // NOI18N
        jMenuItem26.setText("Fabricante");
        jMenuItem26.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem26);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fornecedor.png"))); // NOI18N
        jMenuItem5.setText("Fornecedor");
        jMenuItem5.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem5);

        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/4.png"))); // NOI18N
        jMenuItem21.setText("Funcionário");
        jMenuItem21.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem21);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/brick.png"))); // NOI18N
        jMenuItem15.setText("Modelo");
        jMenuItem15.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem15);

        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/prod.png"))); // NOI18N
        jMenuItem17.setText("Peça");
        jMenuItem17.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem17);

        jMenuItemCadastrarServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/servicos.png"))); // NOI18N
        jMenuItemCadastrarServico.setText("Serviços");
        jMenuItemCadastrarServico.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItemCadastrarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarServicoActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItemCadastrarServico);

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/setor.png"))); // NOI18N
        jMenuItem13.setText("Segmento");
        jMenuItem13.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem13);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user.gif"))); // NOI18N
        jMenuItem8.setText("Usuário");
        jMenuItem8.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem8);

        jMenuItem31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas1.gif"))); // NOI18N
        jMenuItem31.setText("Vendas");
        jMenuItem31.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem31);

        jMenu4.add(jMenu14);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.gif"))); // NOI18N
        jMenu10.setText("Consultar");
        jMenu10.setPreferredSize(new java.awt.Dimension(130, 35));

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cliente3.png"))); // NOI18N
        jMenuItem9.setText("Cliente");
        jMenuItem9.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem9);

        jMenuItem30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/maquina02.png"))); // NOI18N
        jMenuItem30.setText("Equipamento");
        jMenuItem30.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem30);

        jMenuItem23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fabricante.png"))); // NOI18N
        jMenuItem23.setText("Fabricante");
        jMenuItem23.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem23);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fornecedor.png"))); // NOI18N
        jMenuItem6.setText("Fornecedor");
        jMenuItem6.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem6);

        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/4.png"))); // NOI18N
        jMenuItem18.setText("Funcionário");
        jMenuItem18.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem18);

        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/brick.png"))); // NOI18N
        jMenuItem16.setText("Modelo");
        jMenuItem16.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem16);

        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/prod.png"))); // NOI18N
        jMenuItem20.setText("Produto");
        jMenuItem20.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem20);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/servicos.png"))); // NOI18N
        jMenuItem1.setText("Serviços");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem1);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/setor.png"))); // NOI18N
        jMenuItem14.setText("Segmento");
        jMenuItem14.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem14);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user.gif"))); // NOI18N
        jMenuItem7.setText("Usuário");
        jMenuItem7.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem7);

        jMenuItem32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas1.gif"))); // NOI18N
        jMenuItem32.setText("Vendas");
        jMenuItem32.setPreferredSize(new java.awt.Dimension(130, 35));
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem32);

        jMenu4.add(jMenu10);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnRotinaContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRotinaContatoActionPerformed
        this.setEnabled(false);
        new CadastrarRotinaContato(this).setVisible(true);
    }//GEN-LAST:event_jBtnRotinaContatoActionPerformed

    private void jBtnCadastrarLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastrarLembreteActionPerformed
        this.setEnabled(false);
        new CadastrarLembrete(this).setVisible(true);
    }//GEN-LAST:event_jBtnCadastrarLembreteActionPerformed

    private void jBtnPropostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPropostaActionPerformed
        this.setEnabled(false);
        new Proposta(this).setVisible(true);
    }//GEN-LAST:event_jBtnPropostaActionPerformed

    private void jBtnFazerBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFazerBackupActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Selecione um diretório");
        fc.setApproveButtonText("Salvar");
        // restringe a amostra a diretorios apenas
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {

            File diretorio = fc.getSelectedFile();
            caminho = diretorio.getAbsolutePath();
            ControleBackup app = new ControleBackup(caminho);

        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum diretorio.");
        }
    }//GEN-LAST:event_jBtnFazerBackupActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        this.setVisible(false);
        new ExibeVenda(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new ExibeUsuario().setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        this.setVisible(false);
        new OperacoesSegmento(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setVisible(false);
        new ExibeServico(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        this.setVisible(false);
        new ExibeProduto(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        this.setVisible(false);
        new OperacaoModelo(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        this.setVisible(false);
        new ExibeFuncionario(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        this.setVisible(false);
        new ExibeFornecedor(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        this.setVisible(false);
        new ExibeFabricante(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        this.setVisible(false);
        new ExibeEquipamento(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        this.setVisible(false);
        new ExibeCliente(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        this.setVisible(false);
        new CadastrarVenda(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new CadastrarUsuario().setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        this.setVisible(false);
        new OperacoesSegmento(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItemCadastrarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarServicoActionPerformed
        this.setVisible(false);
        new CadastrarServicoTeste(this).setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarServicoActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        this.setVisible(false);
        new CadastrarProduto(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        this.setVisible(false);
        new OperacaoModelo(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        this.setVisible(false);
        new CadastrarFuncionario(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.setVisible(false);
        new CadastrarFornecedor(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        this.setVisible(false);
        new ExibeFabricante(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        this.setVisible(false);
        new CadastrarEquipamento(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
       new CadastrarCliente().setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu4KeyPressed
      
    }//GEN-LAST:event_jMenu4KeyPressed

    private void jBtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLogoutActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
            File file = new File("C:/Users/EdceaAraújo/Desktop");
            file.mkdir();
            String caminho = file.getAbsolutePath();
            ControleBackup app = new ControleBackup(caminho);
            this.dispose();
        }
    }//GEN-LAST:event_jBtnLogoutActionPerformed

    public void Backup() {

        TelaEspera telaTeste = new TelaEspera();
        this.setEnabled(false);
        final Thread t1 = new Thread(new Runnable() {//cria uma thread pra gravar o seu arquivo

            @Override
            public void run() {

                telaTeste.setVisible(true);
                File file = new File("C:/Users/Josy/Desktop");
                file.mkdir();
                String caminho = file.getAbsolutePath();
                ControleBackup app = new ControleBackup(caminho);
            }
        });
        t1.start();
        new Thread(new Runnable() {//cria outra thread pra sua tela de espera
            @Override
            public void run() {
                try {
                    //cria a tela de espera e mostra ela
                    t1.join();//fica esperando a primeira thread acabar
                    telaMenu.setEnabled(true);  // quando acabar fecha a janela de espera, podes fazer outras coisas aqui
                    telaTeste.dispose();
                    System.exit(0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    
    
    public void tabelaEstoque() {
    
        //
        
    }
    
    
    public void verificaUsuario(){
        if(TipoUsuario() == false){
            jMenuItem8.setVisible(false);
            
          }
    }
    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Menu().setVisible(true);
////                Agendamentos a = new Agendamentos(); 
////                a.terceiraTarefa(21);
//            }
//        });   
//    }
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCadastrarLembrete;
    private javax.swing.JButton jBtnFazerBackup;
    private javax.swing.JButton jBtnLogout;
    private javax.swing.JButton jBtnProposta;
    private javax.swing.JButton jBtnRotinaContato;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemCadastrarServico;
    // End of variables declaration//GEN-END:variables

}
