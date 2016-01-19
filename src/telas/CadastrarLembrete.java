package telas;

import atributos.Cliente;
import atributos.Lembrete;
import atributos.Usuario;
import funcoes.ClienteDAO;
import funcoes.Conexao;
import funcoes.FuncoesDiversas;
import static funcoes.FuncoesDiversas.FormataData;
import funcoes.LembreteDAO;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author S015365
 */
public class CadastrarLembrete extends javax.swing.JFrame {

    private PreparedStatement pst;
    private int codCliCombo;
    private int codCli;
    private DetalharCliente detalharCliente;
    /**
     * Creates new form CadastrarLembrete
     */
    public CadastrarLembrete() {
        initComponents();
        jLabCodigo.setVisible(false);
        jLabEmpresa.setVisible(false);
        jLabNCodigo.setVisible(false);
        carregarComboClientes();  
        combobox();
    }
    
    public CadastrarLembrete(int codCliente) {              
        initComponents();
        this.codCli = codCliente;        
        uJComboBoxClientes.setVisible(false);           
        DadosEmpresa();
    }
    
    public CadastrarLembrete(int codCliente, DetalharCliente detalharCliente) {        
        initComponents();   
        this.detalharCliente = detalharCliente;       
        this.codCli = codCliente;
        uJComboBoxClientes.setVisible(false);     
        DadosEmpresa();
    }

    private void DadosEmpresa() {

        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente = ClienteDAO.CarregaNomeCliente(codCli);       

            for (Cliente cli : cliente) {

                jLabCodigo.setText(String.valueOf(cli.getId()));
                jLabEmpresa.setText(cli.getEmpresa());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabNCodigo = new javax.swing.JLabel();
        jLabCodigo = new javax.swing.JLabel();
        jLabNomeEmpresa = new javax.swing.JLabel();
        jLabEmpresa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDataLembrete = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricaoLembrete = new javax.swing.JTextArea();
        jBtnSalvarLembrete = new javax.swing.JButton();
        jBtnSair = new javax.swing.JButton();
        txtHoraLembrete = new javax.swing.JFormattedTextField();
        uJComboBoxClientes = new componentes.UJComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Lembrete");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabNCodigo.setText("Código:");
        jPanel1.add(jLabNCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabCodigo.setText("codigo");
        jPanel1.add(jLabCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        jLabNomeEmpresa.setText("Empresa:");
        jPanel1.add(jLabNomeEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        jLabEmpresa.setText("empresa");
        jPanel1.add(jLabEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 200, 20));

        jLabel2.setText("Data:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        jPanel1.add(txtDataLembrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 130, -1));

        jLabel3.setText("Hora:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel4.setText("Descrição:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        txtDescricaoLembrete.setColumns(20);
        txtDescricaoLembrete.setRows(5);
        jScrollPane1.setViewportView(txtDescricaoLembrete);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 360, 191));

        jBtnSalvarLembrete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jBtnSalvarLembrete.setText("Salvar");
        jBtnSalvarLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarLembreteActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnSalvarLembrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, -1, -1));

        jBtnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnSair.setText("Sair");
        jBtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSairActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        try {
            txtHoraLembrete.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtHoraLembrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 40, -1));

        uJComboBoxClientes.setEditable(true);
        uJComboBoxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uJComboBoxClientesActionPerformed(evt);
            }
        });
        jPanel1.add(uJComboBoxClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 290, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSalvarLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarLembreteActionPerformed
        
        if (codCliCombo != 0) {
            codCli = codCliCombo;
        }
        
        try {
            
            Lembrete lembrete = new Lembrete();
            lembrete.setCodUsuario(Usuario.idUsuario());
            lembrete.setDataLembrete(FormataData(txtDataLembrete.getDate()));            
            lembrete.setHora(FuncoesDiversas.ConverterHora(txtHoraLembrete.getText()));
            lembrete.setDescricao(txtDescricaoLembrete.getText());                    
            lembrete.setCodCliente(codCli);
            LembreteDAO.CadLembrete(lembrete);      
            this.dispose();
            verificaPagina();
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Campo data Inválido!");
        }
        
    }//GEN-LAST:event_jBtnSalvarLembreteActionPerformed

    private void jBtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSairActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();       
    }//GEN-LAST:event_formWindowClosed

    private void uJComboBoxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJComboBoxClientesActionPerformed
        codCliCombo = 0;
        idClienteComboBox();
    }//GEN-LAST:event_uJComboBoxClientesActionPerformed

    private void verificaPagina(){
        
        if ((this.detalharCliente != null)) {
            this.detalharCliente.setEnabled(true);
            this.detalharCliente.toFront();
            this.detalharCliente.TabelaLembrete2(codCli);
        }
    }
    
//    private void limparCampos(){
//        txtDataLembrete = null;
//        txtDescricaoLembrete.setText("");
//        txtHoraLembrete.setText("");
//        jComboBoxEmpresas.setSelectedIndex(0);
//    }
    
    private void carregarComboClientes() {

        uJComboBoxClientes.clear();

        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente = ClienteDAO.ComboCliente();

        for (Cliente cli : cliente) {
            uJComboBoxClientes.addItem(cli.getEmpresa(), cli);
        }
    }
    
    private void idClienteComboBox() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabcliente where empresa = '" + uJComboBoxClientes.getSelectedItem()+ "';";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                codCliCombo = (rs.getInt("idcliente"));
            }
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void combobox() {

        //Combobox clientes
        uJComboBoxClientes.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codCliCombo == 0) {
                    JOptionPane.showMessageDialog(null, "Esse registro não encontra-se cadastrado na base de dados.");
                    uJComboBoxClientes.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        uJComboBoxClientes.setAutocompletar(true);    
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSair;
    private javax.swing.JButton jBtnSalvarLembrete;
    private javax.swing.JLabel jLabCodigo;
    private javax.swing.JLabel jLabEmpresa;
    private javax.swing.JLabel jLabNCodigo;
    private javax.swing.JLabel jLabNomeEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser txtDataLembrete;
    private javax.swing.JTextArea txtDescricaoLembrete;
    private javax.swing.JFormattedTextField txtHoraLembrete;
    private componentes.UJComboBox uJComboBoxClientes;
    // End of variables declaration//GEN-END:variables
}
