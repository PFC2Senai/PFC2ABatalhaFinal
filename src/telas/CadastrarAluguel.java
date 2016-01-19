package telas;

import atributos.Aluguel;
import atributos.Cliente;
import atributos.Equipamento;
import atributos.OrdemServico;
import atributos.Usuario;
import funcoes.AluguelDAO;
import funcoes.ClienteDAO;
import funcoes.Conexao;
import funcoes.EquipamentoDAO;
import funcoes.FuncoesDiversas;
import funcoes.LimitarDigitos;
import funcoes.OrdemServicoDAO;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josy
 */
public class CadastrarAluguel extends javax.swing.JFrame {

    private PreparedStatement pst;

    private int codModeloEqui;
    private int codEquipamento;
    private int codDetEquipamento;
    private int codFabricanteEqui;
    private int codCliente;

    private double valor;

    private String modeloEqui;
    private String equipamento;
    private String fabricanteEqui;

    /**
     * Creates new form CadastrarAluguel
     */
    public CadastrarAluguel() {
        initComponents();
        combobox();
        carregarComboClientes();
        carregarComboEquipamento();
        ocultaColunaTabelas();
        txtValorLocacao.setDocument(new LimitarDigitos(10));
        txtQuantEqui.setDocument(new LimitarDigitos(10));
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

        jTabbedPaneServico = new javax.swing.JTabbedPane();
        jPanelServico = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDataDevolucao = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        txtDataLocacao = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtHoraLocacao = new javax.swing.JFormattedTextField();
        uJComboBoxClientes = new componentes.UJComboBox();
        jBtnAvancar = new javax.swing.JButton();
        jPanelEquipamento = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBtnRemoveEquipamento = new javax.swing.JButton();
        jBtbIncluirEquipamento = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEquipamento = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        jComboBoxModeloEquip = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        jComboBoxFabricanteEquip = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtValorLocacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtQuantEqui = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        uJComboBoxEquipamento = new componentes.UJComboBox();
        jBtnVoltar1 = new javax.swing.JButton();
        jBtnCadastrarAluguel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPaneServico.setBackground(new java.awt.Color(249, 238, 238));
        jTabbedPaneServico.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Empresa:");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 20));

        jLabel10.setText("Data Devolução:");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, 20));

        jLabel12.setText("Data Locação:");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 20));
        jPanel7.add(txtDataDevolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 120, 20));

        jLabel5.setText("Descrição:");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 20));

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane4.setViewportView(txtDescricao);

        jPanel7.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 450, 100));
        jPanel7.add(txtDataLocacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 120, -1));

        jLabel8.setText("Hora:");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, 20));

        try {
            txtHoraLocacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel7.add(txtHoraLocacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 40, -1));

        uJComboBoxClientes.setEditable(true);
        uJComboBoxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uJComboBoxClientesActionPerformed(evt);
            }
        });
        jPanel7.add(uJComboBoxClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 390, -1));

        jBtnAvancar.setText("Avançar");
        jBtnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAvancarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelServicoLayout = new javax.swing.GroupLayout(jPanelServico);
        jPanelServico.setLayout(jPanelServicoLayout);
        jPanelServicoLayout.setHorizontalGroup(
            jPanelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelServicoLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnAvancar)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanelServicoLayout.setVerticalGroup(
            jPanelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelServicoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnAvancar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneServico.addTab("Aluguel", new javax.swing.ImageIcon(getClass().getResource("/imagens/aluguel.png")), jPanelServico); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Equipamento:");

        jBtnRemoveEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jBtnRemoveEquipamento.setText("Remover");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableEquipamento, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnRemoveEquipamento, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnRemoveEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoveEquipamentoActionPerformed(evt);
            }
        });

        jBtbIncluirEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jBtbIncluirEquipamento.setText("IncluirEquipamento");
        jBtbIncluirEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbIncluirEquipamentoActionPerformed(evt);
            }
        });

        jTableEquipamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Id modelo", "Id fabricante", "Equipamento", "Modelo", "Fabricante", "Quantidade", "Vr. Locação", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEquipamento.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableEquipamento);

        jLabel37.setText("Modelo:");

        jComboBoxModeloEquip.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Modelo" }));
        jComboBoxModeloEquip.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxModeloEquipItemStateChanged(evt);
            }
        });
        jComboBoxModeloEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeloEquipActionPerformed(evt);
            }
        });

        jLabel38.setText("Fabricante:");

        jComboBoxFabricanteEquip.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Fabricante" }));
        jComboBoxFabricanteEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFabricanteEquipActionPerformed(evt);
            }
        });

        jLabel2.setText("Valor Locação:");

        jLabel3.setText("Quantidade:");

        jLabel4.setText("Vr. Total Locação:");

        uJComboBoxEquipamento.setEditable(true);
        uJComboBoxEquipamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                uJComboBoxEquipamentoItemStateChanged(evt);
            }
        });
        uJComboBoxEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uJComboBoxEquipamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(33, 33, 33)
                        .addComponent(jComboBoxFabricanteEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel37))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxModeloEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uJComboBoxEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtValorLocacao, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(txtQuantEqui)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBtnRemoveEquipamento)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(jBtbIncluirEquipamento))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(uJComboBoxEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jComboBoxModeloEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jComboBoxFabricanteEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtValorLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantEqui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jBtbIncluirEquipamento)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnRemoveEquipamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        jBtnVoltar1.setText("Voltar");
        jBtnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltar1ActionPerformed(evt);
            }
        });

        jBtnCadastrarAluguel.setText("Finalizar Aluguel");
        jBtnCadastrarAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarAluguelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEquipamentoLayout = new javax.swing.GroupLayout(jPanelEquipamento);
        jPanelEquipamento.setLayout(jPanelEquipamentoLayout);
        jPanelEquipamentoLayout.setHorizontalGroup(
            jPanelEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEquipamentoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanelEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelEquipamentoLayout.createSequentialGroup()
                        .addComponent(jBtnVoltar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnCadastrarAluguel))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanelEquipamentoLayout.setVerticalGroup(
            jPanelEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEquipamentoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnVoltar1)
                    .addComponent(jBtnCadastrarAluguel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneServico.addTab("Equipamento", new javax.swing.ImageIcon(getClass().getResource("/imagens/equipamento.png")), jPanelEquipamento); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneServico, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneServico, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxFabricanteEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFabricanteEquipActionPerformed
        idFabricanteEquiComboBox();
        if (jComboBoxFabricanteEquip.getSelectedItem() != null) {
            fabricanteEqui = jComboBoxFabricanteEquip.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboBoxFabricanteEquipActionPerformed

    private void jComboBoxModeloEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloEquipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxModeloEquipActionPerformed

    private void jComboBoxModeloEquipItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxModeloEquipItemStateChanged
        jComboBoxFabricanteEquip.removeAllItems();
        idModeloEquiComboBox();
        populaComboBoxFabricanteEquip();
        if (jComboBoxModeloEquip.getSelectedItem() != null) {
            modeloEqui = jComboBoxModeloEquip.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboBoxModeloEquipItemStateChanged

    private void jBtbIncluirEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbIncluirEquipamentoActionPerformed
        TabelaEquipamento();
    }//GEN-LAST:event_jBtbIncluirEquipamentoActionPerformed

    private void jBtnRemoveEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoveEquipamentoActionPerformed
        
        DefaultTableModel dtm = (DefaultTableModel) jTableEquipamento.getModel();
        int linha = jTableEquipamento.getSelectedRow();

        double totalParcial = Double.parseDouble(jTableEquipamento.getValueAt(linha, 8).toString());
        
        valor -= totalParcial;
        
        txtTotal.setText(String.valueOf(valor));
        
        if(linha != -1) {
            dtm.removeRow(linha);
        }
    }//GEN-LAST:event_jBtnRemoveEquipamentoActionPerformed

    private void jBtnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAvancarActionPerformed
        jTabbedPaneServico.setSelectedComponent(this.jPanelEquipamento);
    }//GEN-LAST:event_jBtnAvancarActionPerformed

    private void jBtnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltar1ActionPerformed
        jTabbedPaneServico.setSelectedComponent(this.jPanelServico);
    }//GEN-LAST:event_jBtnVoltar1ActionPerformed

    private void jBtnCadastrarAluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastrarAluguelActionPerformed
       
        Aluguel aluguel = new Aluguel();
        OrdemServico oS = new OrdemServico();

        oS.setTipo("Aluguel");

        int codOrdemS = OrdemServicoDAO.CadOrdemServico(oS);
        
        aluguel.setTabusuarioIdUsuario(Usuario.idUsuario());
        aluguel.setTabclienteIdcliente(codCliente);
        aluguel.setDescricaotLocacao(txtDescricao.getText());
        aluguel.setDataAluguel(FuncoesDiversas.FormataData(txtDataLocacao.getDate()));  
        aluguel.setHora(FuncoesDiversas.ConverterHora(txtHoraLocacao.getText()));
        aluguel.setCodOrdemServico(codOrdemS);
        aluguel.setDataDevolucao(FuncoesDiversas.FormataData(txtDataDevolucao.getDate()));
        
        int codAluguel = AluguelDAO.CadAluguel(aluguel);

        for(int j = 0; j < jTableEquipamento.getRowCount(); j++) {
            
            aluguel.setCodAluguel(codAluguel);           
            aluguel.setCodDetEquipamento(Integer.parseInt(jTableEquipamento.getValueAt(j, 0).toString()));
            aluguel.setQuatidadeEqui(Integer.parseInt(jTableEquipamento.getValueAt(j, 6).toString()));
            aluguel.setValorLocacao(Double.parseDouble(jTableEquipamento.getValueAt(j, 7).toString()));
            
            AluguelDAO.CadDetAluguel(aluguel);
        }
        
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
        limpacampos();
    }//GEN-LAST:event_jBtnCadastrarAluguelActionPerformed

    private void uJComboBoxEquipamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_uJComboBoxEquipamentoItemStateChanged

        jComboBoxModeloEquip.removeAllItems();
        jComboBoxFabricanteEquip.removeAllItems();
        codModeloEqui = 0;
        modeloEqui = null;
        codFabricanteEqui = 0;
        fabricanteEqui = null;
        codEquipamento = 0;
        idEquipamentoComboBox();
        populaComboBoxModeloEqui();
        equipamento = uJComboBoxEquipamento.getSelectedItem().toString();
    }//GEN-LAST:event_uJComboBoxEquipamentoItemStateChanged

    private void uJComboBoxEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJComboBoxEquipamentoActionPerformed
        idEquipamentoComboBox();
        if (uJComboBoxEquipamento.getSelectedItem() != null) {
            equipamento = uJComboBoxEquipamento.getSelectedItem().toString();
        }
    }//GEN-LAST:event_uJComboBoxEquipamentoActionPerformed

    private void uJComboBoxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJComboBoxClientesActionPerformed
        codCliente = 0;
        idClienteComboBox();
    }//GEN-LAST:event_uJComboBoxClientesActionPerformed

    public void TabelaEquipamento() {

        codDetEquipamento = EquipamentoDAO.CodigoDetEquipamento(codEquipamento, codModeloEqui, codFabricanteEqui);
        int quantidade = Integer.parseInt(txtQuantEqui.getText());
        double valorLocacao = Double.parseDouble(txtValorLocacao.getText());
        double total = valorLocacao * quantidade;
        
        try {

            DefaultTableModel dtm = (DefaultTableModel) jTableEquipamento.getModel();

            dtm.addRow(new Object[] {
                
                codDetEquipamento,
                codModeloEqui,
                codFabricanteEqui,
                equipamento,
                modeloEqui,
                fabricanteEqui,
                txtQuantEqui.getText(),
                txtValorLocacao.getText(),
                total
            });

            valor += total;
            txtTotal.setText(String.valueOf(valor));
            
            txtQuantEqui.setText("");
            txtValorLocacao.setText("");
            
        } catch (Exception erro) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    private void carregarComboClientes() {

        uJComboBoxClientes.clear();

        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente = ClienteDAO.ComboCliente();

        for (Cliente cli : cliente) {
            uJComboBoxClientes.addItem(cli.getEmpresa(), cli);
        }
    }
    
    private void carregarComboEquipamento() {

        uJComboBoxEquipamento.clear();

        ArrayList<Equipamento> equipamentos = new ArrayList<Equipamento>();
        equipamentos = EquipamentoDAO.ListarEquipamentos();

        for (Equipamento equi : equipamentos) {
            uJComboBoxEquipamento.addItem(equi.getEquipamento(), equi);
        }
    }
    
    private void populaComboBoxModeloEqui() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select modelo "
                + " from tabdetequipamento inner join "
                + " tabequipamento inner join "
                + " tabmodelo on tabmodelo_idtabModelo = idtabModelo and "
                + " tabequipamento_idEquipamento = idEquipamento"
                + " where idEquipamento = " + codEquipamento + " group by modelo;";

        try {
            
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                jComboBoxModeloEquip.addItem(rs.getString("modelo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idModeloEquiComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabmodelo where modelo = '" + jComboBoxModeloEquip.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codModeloEqui = (rs.getInt("idtabModelo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void populaComboBoxFabricanteEquip() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "SELECT * FROM vw_combofabricanteequipamento "
                + " WHERE idEquipamento = " + codEquipamento
                + " AND tabmodelo_idtabModelo = " + codModeloEqui + " group by fabricante;";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                jComboBoxFabricanteEquip.addItem(rs.getString("fabricante"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idFabricanteEquiComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfabricante where fabricante = '" + jComboBoxFabricanteEquip.getSelectedItem() + "';";

        try {

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codFabricanteEqui = (rs.getInt("idtabFabricante"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idEquipamentoComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabequipamento where equipamento = '" + uJComboBoxEquipamento.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codEquipamento = (rs.getInt("idEquipamento"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idClienteComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabcliente where empresa = '" + uJComboBoxClientes.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codCliente = (rs.getInt("idcliente"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void limpacampos() {
        
        txtDataDevolucao.setDate(null);
        txtDataLocacao.setDate(null);
        txtDescricao.setText("");
        txtHoraLocacao.setText("");
        txtQuantEqui.setText("");
        txtTotal.setText("");
        txtValorLocacao.setText("");
        uJComboBoxClientes.setSelectedIndex(0);
        uJComboBoxEquipamento.setSelectedIndex(0);
        codEquipamento = 0;
        codModeloEqui = 0;
        modeloEqui = null;
        codFabricanteEqui = 0;
        fabricanteEqui = null;
        jComboBoxFabricanteEquip.removeAllItems();
        jComboBoxModeloEquip.removeAllItems();
        ((DefaultTableModel) jTableEquipamento.getModel()).setNumRows(0);
        jTableEquipamento.updateUI();
        jTabbedPaneServico.setSelectedComponent(this.jPanelServico);
    }
   
    private void combobox() {

        //Combobox clientes
        uJComboBoxClientes.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codCliente == 0) {
                    Mensangem();
                    uJComboBoxClientes.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        uJComboBoxClientes.setAutocompletar(true);
        
        //Combobox equipamento
        uJComboBoxEquipamento.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codEquipamento == 0) {
                    Mensangem();
                    uJComboBoxEquipamento.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        uJComboBoxEquipamento.setAutocompletar(true);
    }
    
    private void Mensangem() {
        JOptionPane.showMessageDialog(null, "Esse registro não encontra-se cadastrado na base de dados.");
    }
    
    private void ocultaColunaTabelas() {
       
        //oculta coluna equipamento
        jTableEquipamento.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableEquipamento.getColumnModel().getColumn(0).setMinWidth(0);
        jTableEquipamento.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTableEquipamento.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        jTableEquipamento.getColumnModel().getColumn(1).setMaxWidth(0);
        jTableEquipamento.getColumnModel().getColumn(1).setMinWidth(0);
        jTableEquipamento.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        jTableEquipamento.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);

        jTableEquipamento.getColumnModel().getColumn(2).setMaxWidth(0);
        jTableEquipamento.getColumnModel().getColumn(2).setMinWidth(0);
        jTableEquipamento.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        jTableEquipamento.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbIncluirEquipamento;
    private javax.swing.JButton jBtnAvancar;
    private javax.swing.JButton jBtnCadastrarAluguel;
    private javax.swing.JButton jBtnRemoveEquipamento;
    private javax.swing.JButton jBtnVoltar1;
    private javax.swing.JComboBox jComboBoxFabricanteEquip;
    private javax.swing.JComboBox jComboBoxModeloEquip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelEquipamento;
    private javax.swing.JPanel jPanelServico;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPaneServico;
    private javax.swing.JTable jTableEquipamento;
    private com.toedter.calendar.JDateChooser txtDataDevolucao;
    private com.toedter.calendar.JDateChooser txtDataLocacao;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JFormattedTextField txtHoraLocacao;
    private javax.swing.JTextField txtQuantEqui;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValorLocacao;
    private componentes.UJComboBox uJComboBoxClientes;
    private componentes.UJComboBox uJComboBoxEquipamento;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
