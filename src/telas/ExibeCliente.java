package telas;


import atributos.Cliente;
import funcoes.ClienteDAO;
import static funcoes.Conexao.getConnection;
import funcoes.ModeloTabela;
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
 * @author S015365
 * pfc2senai@gmail.com
 * 
 */
public final class ExibeCliente extends javax.swing.JFrame {
    
Statement stmt ;
Cliente cliente = new Cliente();
private static int indice;
private static int idCntato;
    /**
     * Creates new form CadastroDeFuncionarios
     */
    public ExibeCliente() {        
        initComponents();
        TabelaCliente("select  * from vw_cliente;");       
    }
    
    public static int GetIndice() {         
        return indice;
    }
    
    public boolean CodigoCliente() {
        boolean valida = false;
        
        if(jTableListarClientes.getSelectedRow() != -1){
            valida = true;
            this.dispose();
            int linha = jTableListarClientes.getSelectedRow();        
            indice = (Integer.parseInt(jTableListarClientes.getValueAt(linha, 0).toString()));
        }else{
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro.");
        }  
    return valida;
    }
    
    public void TabelaCliente(String Sql) {
        
        try { 
            
            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();               
            String [] Colunas = {"Código","Empresa", "CNPJ", "Setor", "Estado","Telefone","Email"};
               
            ResultSet rs;
            rs = stmt.executeQuery(Sql);            
            //rs.first();
            
                while(rs.next()){
                    dados.add(new Object[]{ rs.getObject("idCliente"),rs.getObject("empresa"),
                                            rs.getObject("cnpj"),rs.getObject("setor"), 
                                            rs.getObject("estado"),rs.getObject("telefone"),rs.getObject("email")});            
                }

                    for (int i = 0; i < 7; i++){
                        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                        jTableListarClientes.setModel(modelo);
                        jTableListarClientes.getColumnModel().getColumn(i).setPreferredWidth(150);
                        jTableListarClientes.getColumnModel().getColumn(i).setResizable(false);
                        jTableListarClientes.getTableHeader().setReorderingAllowed(false);
                        jTableListarClientes.setAutoResizeMode(jTableListarClientes.AUTO_RESIZE_OFF);
                        jTableListarClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    }
                    
        } catch (SQLException ex) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (Exception erro){
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, erro);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListarClientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtExcluirCliente = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jBtLembrete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cadastro de Clientes");

        jTableListarClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableListarClientes);

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBtnEditar.setText("Detalhar");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtExcluirCliente.setText("Excluir");
        jBtExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirClienteActionPerformed(evt);
            }
        });

        jButton4.setText("Voltar");

        jBtLembrete.setText("Lembrete");
        jBtLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLembreteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(77, 77, 77)
                        .addComponent(jBtnEditar)
                        .addGap(76, 76, 76)
                        .addComponent(jBtExcluirCliente)
                        .addGap(77, 77, 77)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(jBtLembrete)
                        .addGap(79, 79, 79))))
            .addGroup(layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jBtnEditar)
                    .addComponent(jBtExcluirCliente)
                    .addComponent(jButton4)
                    .addComponent(jBtLembrete))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirClienteActionPerformed

        if (CodigoCliente()){
            int codContato = ClienteDAO.idContato(indice);
            ClienteDAO.ExcluirCliente(codContato);                   
            TabelaCliente("select  * from vw_cliente;");
        }
    }//GEN-LAST:event_jBtExcluirClienteActionPerformed

    
    
    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        
        if (CodigoCliente()){
            new DetalharCliente().setVisible(true); 
        }
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLembreteActionPerformed
       
        if (CodigoCliente()){
            new CadastrarLembrete(indice).setVisible(true); 
        }        
    }//GEN-LAST:event_jBtLembreteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtExcluirCliente;
    private javax.swing.JButton jBtLembrete;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListarClientes;
    // End of variables declaration//GEN-END:variables
}
