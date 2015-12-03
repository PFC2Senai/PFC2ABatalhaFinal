package telas;

import atributos.Produto;
import static funcoes.Conexao.getConnection;
import funcoes.ModeloTabela;
import funcoes.ProdutoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author graciele
 * http://www.informaticon.com.br/j/index.php/java-se-i-estoque.html
 */
public class ExibeProduto extends javax.swing.JFrame {
    
    Statement stmt ;
    Produto produto = new Produto();
    private static int indice;

    /**
     * Creates new form ExibeProduto
     */
    public ExibeProduto() {
        initComponents();
        TabelaProduto("SELECT * FROM vw_produtos;");
    }
    
    public static int GetIndice() {         
        return indice;
    }
    
    public void TabelaProduto(String Sql){
        
        try {
            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();               
            String [] Colunas = {"Código", "Produto", "Fornecedor", "Fabricante",
                                 "Modelo", "Preço Entrada", "Preço Saída"};
               
            ResultSet rs;
            rs = stmt.executeQuery(Sql);            
            //rs.first();
            
            while(rs.next()){
               dados.add(new Object[]{rs.getObject("id_prod"),
                                      rs.getObject("produto"),
                                      rs.getObject("fornecedor"),
                                      rs.getObject("fabricante"),
                                      rs.getObject("modelo"),
                                      rs.getObject("precoEntrada"),
                                      rs.getObject("precoSaida")});            
            }
                        
            for (int i = 0; i < 7; i++){
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarProdutos.setModel(modelo);
                jTableListarProdutos.getColumnModel().getColumn(i).setPreferredWidth(150);
                jTableListarProdutos.getColumnModel().getColumn(i).setResizable(false);
                jTableListarProdutos.getTableHeader().setReorderingAllowed(false);
                jTableListarProdutos.setAutoResizeMode(jTableListarProdutos.AUTO_RESIZE_OFF);
                jTableListarProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExibeProduto.class.getName()).log(Level.SEVERE, null, ex);
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

        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListarProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton3.setText("Novo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Editar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Excluir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Voltar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cadastro de Produtos");

        jTableListarProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableListarProdutos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton3)
                .addGap(57, 57, 57)
                .addComponent(jButton5)
                .addGap(67, 67, 67)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new CadastrarProduto().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(jTableListarProdutos.getSelectedRow() != -1){
            this.dispose();
            int linha = jTableListarProdutos.getSelectedRow();
            indice = (Integer.parseInt(jTableListarProdutos.getValueAt(linha, 0).toString()));
            new AlterarProduto().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro.");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(jTableListarProdutos.getSelectedRow() != -1) {

            int linha = jTableListarProdutos.getSelectedRow();
            produto.setIdProduto(Integer.parseInt(jTableListarProdutos.getValueAt(linha, 0).toString()));

            int cod = ProdutoDAO.idProduto(produto.getIdProduto());
            ProdutoDAO.ExcluirProduto(cod);
        } else {
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro.");
        }
        TabelaProduto("SELECT * FROM vw_produtos;");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListarProdutos;
    // End of variables declaration//GEN-END:variables
}
