package telas;

import atributos.Cliente;
import atributos.Funcionario;
import atributos.Servico;
import atributos.TipoServico;
import funcoes.ClienteDAO;
import static funcoes.Conexao.getConnection;
import funcoes.DetServicoFuncionarioDAO;
import funcoes.DetServicoTipoDAO;
import funcoes.FuncionarioDAO;
import funcoes.ModeloTabela;
import funcoes.ServicoDAO;
import funcoes.TipoServicoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josy
 */
public class DetalharServico extends javax.swing.JFrame {

    private int idServico;
    private int idCliente;
    Statement stmt;
    
    /**
     * Creates new form DetalharServico
     */
    public DetalharServico() {
        initComponents();
    }
    
    public DetalharServico(int codServico) {
        this.idServico = codServico;
        initComponents();
        CarregaServico();
        TabelaProduto("SELECT * FROM vw_detservicoproduto where idservico = " + idServico +";");
        TabelaEquipamento("SELECT * FROM vw_detservequipamento where idservico = " + idServico +";");
        TabelaTipoServico();
        TabelaFuncionario();
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

        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePecas = new javax.swing.JTable();
        jBtnAlterarModelo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        txtCliente = new javax.swing.JLabel();
        txtData = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEquipamento = new javax.swing.JTable();
        jBtnAlterarEquipamento = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableFuncionario = new javax.swing.JTable();
        jBtnAlterarFuncionario = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaoObra = new javax.swing.JLabel();
        jBtnAlterarMaoObra = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jBtnAlterarTipoServico = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableTipodeServico = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel13.setPreferredSize(new java.awt.Dimension(860, 800));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Serviço");

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Peças"));

        jTablePecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id det serv produto", "Peça", "Modelo", "Fabricante", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePecas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTablePecas);

        jBtnAlterarModelo.setText("Alterar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTablePecas, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnAlterarModelo, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnAlterarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarModeloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnAlterarModelo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jBtnAlterarModelo)
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Serviço"));

        jLabel6.setText("Cliente:");

        jLabel12.setText("Data:");

        jLabel5.setText("Descrição:");

        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDescricao.setRows(5);
        txtDescricao.setEnabled(false);
        jScrollPane4.setViewportView(txtDescricao);

        txtCliente.setText("cliente");

        txtData.setText("data");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(13, 13, 13)
                            .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel5)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Equipamentos"));

        jTableEquipamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id det servico equipamento", "Equipamento", "Modelo", "Fabricante"
            }
        ));
        jTableEquipamento.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableEquipamento);

        jBtnAlterarEquipamento.setText("Alterar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableEquipamento, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnAlterarEquipamento, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnAlterarEquipamento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAlterarEquipamento)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Funcionários"));

        jTableFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Funcionário"
            }
        ));
        jTableFuncionario.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableFuncionario);

        jBtnAlterarFuncionario.setText("Alterar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableFuncionario, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnAlterarFuncionario, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAlterarFuncionario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAlterarFuncionario)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Valores"));

        jLabel4.setText("Total serviço:");

        txtTotal.setText("total");

        jLabel1.setText("Mão de Obra:");

        txtMaoObra.setText("mao de obra");

        jBtnAlterarMaoObra.setText("Alterar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaoObra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnAlterarMaoObra)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaoObra, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jBtnAlterarMaoObra)
                .addGap(6, 6, 6))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tipo Serviço"));

        jBtnAlterarTipoServico.setText("Alterar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableTipodeServico, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnAlterarTipoServico, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jTableTipodeServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo Serviço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTipodeServico.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTableTipodeServico);

        jLabel10.setText("Tipo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAlterarTipoServico)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAlterarTipoServico))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel32)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(165, 165, 165))
        );

        jScrollPane5.setViewportView(jPanel13);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAlterarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnAlterarModeloActionPerformed

    public void CarregaServico() {
        
        ArrayList<Servico> servico = new ArrayList<Servico>();
        servico = ServicoDAO.CarregaServico(idServico);
        
        for (Servico serv : servico) {
            
            idCliente = serv.getCodCliente();
            txtData.setText(String.valueOf(serv.getDataServico()));
            txtTotal.setText(String.valueOf(serv.getPreco()));
            txtDescricao.setText(serv.getDescricaoServico());
            txtMaoObra.setText(String.valueOf(serv.getMaoDeObra()));
        }
               
        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente = ClienteDAO.CarregaNomeCliente(idCliente);
        
        for (Cliente cli : cliente) {
            
            txtCliente.setText(cli.getEmpresa());
        }        
    }
    
    public void TabelaProduto(String Sql) {
        
        try { 
            
            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();               
            String [] Colunas = {"Código","Peça", "Modelo", "Fabricante"};
               
            ResultSet rs;
            rs = stmt.executeQuery(Sql);
            
                while(rs.next()) {
                    dados.add(new Object[] { rs.getObject("iddetServico_produto"),rs.getObject("produto"),
                                             rs.getObject("modelo"),rs.getObject("fabricante")});            
                }

                for (int i = 0; i < 4; i++) {
                    
                    ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                    jTablePecas.setModel(modelo);
                    jTablePecas.getColumnModel().getColumn(i).setPreferredWidth(150);
                    jTablePecas.getColumnModel().getColumn(i).setResizable(false);
                    jTablePecas.getTableHeader().setReorderingAllowed(false);
                    jTablePecas.setAutoResizeMode(jTablePecas.AUTO_RESIZE_OFF);
                    jTablePecas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                }
                    
        } catch (SQLException ex) {
            Logger.getLogger(DetalharServico.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (Exception erro) {
            Logger.getLogger(DetalharServico.class.getName()).log(Level.SEVERE, null, erro);
        }        
    }
    
    
    public void TabelaEquipamento(String Sql) {
        
        try { 
            
            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();               
            String [] Colunas = {"Código","Equipamento", "Modelo", "Fabricante"};
               
            ResultSet rs;
            rs = stmt.executeQuery(Sql);
            
                while(rs.next()) {
                    dados.add(new Object[] { rs.getObject("idDetEquipamento"),rs.getObject("equipamento"),
                                             rs.getObject("modelo"),rs.getObject("fabricante")});            
                }

                for (int i = 0; i < 4; i++) {
                    
                    ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                    jTableEquipamento.setModel(modelo);
                    jTableEquipamento.getColumnModel().getColumn(i).setPreferredWidth(150);
                    jTableEquipamento.getColumnModel().getColumn(i).setResizable(false);
                    jTableEquipamento.getTableHeader().setReorderingAllowed(false);
                    jTableEquipamento.setAutoResizeMode(jTableEquipamento.AUTO_RESIZE_OFF);
                    jTableEquipamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                }
                    
        } catch (SQLException ex) {
            Logger.getLogger(DetalharServico.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (Exception erro) {
            Logger.getLogger(DetalharServico.class.getName()).log(Level.SEVERE, null, erro);
        }        
    }
    
    public void TabelaTipoServico() {
        
        ((DefaultTableModel) jTableTipodeServico.getModel()).setNumRows(0);
        jTableTipodeServico.updateUI();
        ArrayList<TipoServico> tipoServ = new ArrayList<TipoServico>();
        tipoServ = DetServicoTipoDAO.CarregaDetServicoTipoServico(idServico);
        
        try { 
            
            DefaultTableModel dtm = (DefaultTableModel) jTableTipodeServico.getModel();
                   
            for(TipoServico tServ : tipoServ) {
                dtm.addRow(new Object[] {
                                        String.valueOf(tServ.getIdTipoServico()),
                                                       tServ.getTipo()});
            }
        
            //pog oculta coluna jtable
//            jTableTipodeServico.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
//            jTableTipodeServico.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
//            jTableTipodeServico.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
//            jTableTipodeServico.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
        } catch (Exception erro) {
            Logger.getLogger(DetalharCliente.class.getName()).log(Level.SEVERE, null, erro);
        }          
    } 
    
    public void TabelaFuncionario() {
        
        ((DefaultTableModel) jTableFuncionario.getModel()).setNumRows(0);
        jTableFuncionario.updateUI();
        ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();
        funcionario = DetServicoFuncionarioDAO.CarregaDetServFuncionario(idServico);
        
        try { 
            
            DefaultTableModel dtm = (DefaultTableModel) jTableFuncionario.getModel();
                   
            for(Funcionario func : funcionario) {
                dtm.addRow(new Object[] {
                                        String.valueOf(func.getId()),
                                                       func.getFuncionario(),
                                                       func.getCpf()});
            }
        
            //pog oculta coluna jtable
//            jTableFuncionario.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
//            jTableFuncionario.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
//            jTableFuncionario.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
//            jTableFuncionario.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
        } catch (Exception erro) {
            Logger.getLogger(DetalharCliente.class.getName()).log(Level.SEVERE, null, erro);
        }          
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterarEquipamento;
    private javax.swing.JButton jBtnAlterarFuncionario;
    private javax.swing.JButton jBtnAlterarMaoObra;
    private javax.swing.JButton jBtnAlterarModelo;
    private javax.swing.JButton jBtnAlterarTipoServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTableEquipamento;
    private javax.swing.JTable jTableFuncionario;
    private javax.swing.JTable jTablePecas;
    private javax.swing.JTable jTableTipodeServico;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JLabel txtData;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JLabel txtMaoObra;
    private javax.swing.JLabel txtTotal;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
