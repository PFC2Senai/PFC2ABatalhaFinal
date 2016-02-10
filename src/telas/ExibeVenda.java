/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import atributos.Vendas;
import static funcoes.Conexao.getConnection;
import funcoes.ModeloTabela;
import funcoes.TabelaZebrada;
import funcoes.VendasDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author WilhamJr
 */
public class ExibeVenda extends javax.swing.JFrame {
    
    Statement stmt ;
    Vendas vendas = new Vendas();
    private static int indice;
    private Menu telaMenu;
    /**

    /**
     * Creates new form ExibeVenda
     */
    public ExibeVenda() {
        initComponents();
        TabelaVendas("select * from tabcliente inner join tabvendas on cliente_idcliente = idcliente;"); 
    }
    
    public ExibeVenda(Menu menu) {
        telaMenu = menu;
        initComponents();
        TabelaVendas("select * from tabcliente inner join tabvendas on cliente_idcliente = idcliente;"); 
    }
    
    public static int GetIndice() {         
        return indice;
    }
    
    public void TabelaVendas(String Sql) {
        
        try {
            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();               
            String [] Colunas = {
                "Código",
                "Empresa", 
                "Data da Venda",
                "Hora da Venda"};
               
            ResultSet rs;
            rs = stmt.executeQuery(Sql);
            
            while(rs.next()){
               dados.add(new Object[]{
                   rs.getObject("idtabVendas"),
                   rs.getObject("Empresa"),
                   rs.getObject("dataVenda"),
                   rs.getObject("hora")});            
            }
                        
            for (int i = 0; i < 4; i++) {
                
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarVendas.setModel(modelo);
                
                TableCellRenderer renderer = new TabelaZebrada();
                jTableListarVendas.setDefaultRenderer(Object.class, renderer);
                
                jTableListarVendas.getColumnModel().getColumn(0).setPreferredWidth(150);
                jTableListarVendas.getColumnModel().getColumn(1).setPreferredWidth(300);
                jTableListarVendas.getColumnModel().getColumn(2).setPreferredWidth(150);
                jTableListarVendas.getColumnModel().getColumn(3).setPreferredWidth(100);
                
                jTableListarVendas.getColumnModel().getColumn(i).setResizable(false);
                jTableListarVendas.getTableHeader().setReorderingAllowed(false);               
                jTableListarVendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExibeVenda.class.getName()).log(Level.SEVERE, null, ex);
        }             
    }
    
    
    
    public boolean CodigoVenda() {

        boolean valida = false;

        if (jTableListarVendas.getSelectedRow() != -1) {
            valida = true;
            //this.dispose();
            int linha = jTableListarVendas.getSelectedRow();
            indice = (Integer.parseInt(jTableListarVendas.getValueAt(linha, 0).toString()));
        } else {
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro.");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListarVendas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jBtnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Raavi", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas1.gif"))); // NOI18N
        jLabel1.setText("Cadastro de Vendas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jTableListarVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableListarVendas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jTableListarVendas);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 700, 440));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 140));

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Raavi", 1, 12)); // NOI18N
        jButton1.setText("Detalhar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarVendas, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButton1, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 90, 32));

        jButton3.setFont(new java.awt.Font("Raavi", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButton3.setText("Novo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 90, 30));

        jBtnVoltar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnVoltar.setText("Voltar");
        jBtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 880, 680));

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        new CadastrarVenda(this).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (CodigoVenda()) {
            this.setVisible(false);           
            new ExibeDetVenda(this).setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void jBtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarActionPerformed
        verificaPagina();
        this.dispose();
    }//GEN-LAST:event_jBtnVoltarActionPerformed

    private void verificaPagina() {
        if ((this.telaMenu != null)) {
            this.telaMenu.setVisible(true);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListarVendas;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
