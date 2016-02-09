package telas;

import atributos.DetServicoFuncionario;
import atributos.Funcionario;
import funcoes.Conexao;
import funcoes.DetServicoFuncionarioDAO;
import funcoes.FuncionarioDAO;
import funcoes.TabelaZebrada;
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
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Josy
 */
public class AdicionarDetServFuncionario extends javax.swing.JFrame {

    private PreparedStatement pst;
    
    private int idServico;
    private DetalharServico telaDatalharServico;
    private int codFuncionario;
    private String funcionario;
    
    /**
     * Creates new form AdicionarDetServFuncionario
     */
    
    public AdicionarDetServFuncionario() {       
        initComponents();
    }
    
    public AdicionarDetServFuncionario(int idServ, DetalharServico telaDetalharServ) {        
        this.idServico = idServ;
        this.telaDatalharServico = telaDetalharServ;
        initComponents();
        carregarComboFuncionario();
        ocultaTabela();
        uJComboBoxFuncionario.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codFuncionario == 0 && uJComboBoxFuncionario.getSelectedIndex() != 0) {
                    JOptionPane.showMessageDialog(null, "Esse registro não encontra-se cadastrado na base de dados.");
                    uJComboBoxFuncionario.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        uJComboBoxFuncionario.setAutocompletar(true);       
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableFuncionario = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jBtnRemoverFunc = new javax.swing.JButton();
        jBtbIncluirFunc = new javax.swing.JButton();
        jBtnSalvarDetServFuncionario = new javax.swing.JButton();
        uJComboBoxFuncionario = new componentes.UJComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jBtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADICIONAR FUNCIONÁRIO");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(254, 254, 233));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableFuncionario.setBackground(new java.awt.Color(254, 254, 233));
        jTableFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Funcionário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFuncionario.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableFuncionario);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 600, 190));

        jLabel7.setText("Funcionário:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jBtnRemoverFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jBtnRemoverFunc.setText("Remover");
        jBtnRemoverFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverFuncActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnRemoverFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 100, -1));

        jBtbIncluirFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jBtbIncluirFunc.setText("Incluir Funcionário");
        jBtbIncluirFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbIncluirFuncActionPerformed(evt);
            }
        });
        jPanel5.add(jBtbIncluirFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));

        jBtnSalvarDetServFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jBtnSalvarDetServFuncionario.setText("Salvar");
        jBtnSalvarDetServFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarDetServFuncionarioActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnSalvarDetServFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, 90, -1));

        uJComboBoxFuncionario.setEditable(true);
        uJComboBoxFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uJComboBoxFuncionarioActionPerformed(evt);
            }
        });
        jPanel5.add(uJComboBoxFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 340, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 24)); // NOI18N
        jLabel2.setText("ADICIONAR FUNCIONÁRIO");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img2.png"))); // NOI18N
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, -1));

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnRemoverFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoverFuncActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTableFuncionario.getModel();
        int linha = jTableFuncionario.getSelectedRow();

        if(linha != -1) {
            dtm.removeRow(linha);
        }
    }//GEN-LAST:event_jBtnRemoverFuncActionPerformed

    private void jBtbIncluirFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbIncluirFuncActionPerformed
        TabelaFuncionario();
    }//GEN-LAST:event_jBtbIncluirFuncActionPerformed

    private void jBtnSalvarDetServFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarDetServFuncionarioActionPerformed

        DetServicoFuncionario dtServFunc = new DetServicoFuncionario();

        for(int j=0; j < jTableFuncionario.getRowCount(); j++) {

            dtServFunc.setCodServico(idServico);
            dtServFunc.setCodFuncionario(Integer.parseInt(jTableFuncionario.getValueAt(j, 0).toString()));

            DetServicoFuncionarioDAO.CadDetServFuncionario(dtServFunc);
        }

        telaDatalharServico.TabelaFuncionario();
        verificaPagina();
        this.dispose();
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
    }//GEN-LAST:event_jBtnSalvarDetServFuncionarioActionPerformed

    private void uJComboBoxFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJComboBoxFuncionarioActionPerformed
        codFuncionario = 0;
        idFuncionarioComboBox();
        if (uJComboBoxFuncionario.getSelectedItem() != null) {
            funcionario = uJComboBoxFuncionario.getSelectedItem().toString();
        }
    }//GEN-LAST:event_uJComboBoxFuncionarioActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
      
        verificaPagina();
          this.dispose();
         if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair? Os dados não serão salvos.", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
         }
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    public void TabelaFuncionario() {
        
        try {             
            DefaultTableModel dtm = (DefaultTableModel) jTableFuncionario.getModel();
                   
                dtm.addRow(new Object[] {codFuncionario, funcionario});
                TableCellRenderer renderer = new TabelaZebrada();
                jTableFuncionario.setDefaultRenderer(Object.class, renderer);
        } catch (Exception erro) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, erro);
        }          
    }
    
    private void carregarComboFuncionario() {

        //    uJComboBoxFuncionario.clear();
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        funcionarios = FuncionarioDAO.ListarFuncionario();

        uJComboBoxFuncionario.addItem("Selecione o funcionario");
        for (Funcionario func : funcionarios) {
            uJComboBoxFuncionario.addItem(func.getFuncionario(), func);
        }
    }
    
    private void idFuncionarioComboBox() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfuncionario where funcionario = '" + uJComboBoxFuncionario.getSelectedItem()+ "';";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                codFuncionario = (rs.getInt("idfuncionario"));
            }
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void ocultaTabela() {
        jTableFuncionario.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableFuncionario.getColumnModel().getColumn(0).setMinWidth(0);
        jTableFuncionario.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTableFuncionario.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }
    
    private void verificaPagina() {

        if ((this.telaDatalharServico != null)) {
            this.telaDatalharServico.setEnabled(true);
            this.telaDatalharServico.toFront();
            
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbIncluirFunc;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnRemoverFunc;
    private javax.swing.JButton jBtnSalvarDetServFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableFuncionario;
    private componentes.UJComboBox uJComboBoxFuncionario;
    // End of variables declaration//GEN-END:variables
}
