package telas;

import atributos.Cliente;
import atributos.RotinaContatos;
import atributos.Usuario;
import funcoes.ClienteDAO;
import funcoes.Conexao;
import funcoes.FuncoesDiversas;
import static funcoes.FuncoesDiversas.FormataData;
import funcoes.RotinaContatosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadastrarRotinaContato extends javax.swing.JFrame {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private int codCli;
    private DetalharCliente detalharCliente;

    public CadastrarRotinaContato() {
        initComponents();
        this.populaComboBox();
        jLabCodigo.setVisible(false);
        jLabEmpresa.setVisible(false);
        jLabNCodigo.setVisible(false);
        jLabCodEmpresa.setVisible(false);
    }
    
    public CadastrarRotinaContato(int codCliente) {              
        initComponents();
        this.codCli = codCliente;        
        ComboBoxCliente.setVisible(false);
        jLabCodEmpresa.setVisible(false);            
        DadosEmpresa();
    }
    
    public CadastrarRotinaContato(int codCliente, DetalharCliente detalharCliente) {        
        initComponents();    
        this.detalharCliente = detalharCliente;       
        this.codCli = codCliente;
        ComboBoxCliente.setVisible(false);
        jLabCodEmpresa.setVisible(false);       
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
    
//    public void populaComboBox() {
//        
//        Connection conexao = Conexao.getConnection();
//        
//        String sql = "select * from tabcliente";
//        
//        try{
//            pst = conexao.prepareStatement(sql);
//            rs = pst.executeQuery();
//            
//            while(rs.next()) {
//                ComboBoxCliente.addItem(rs.getString("empresa"));
//            }
//        }catch(SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        ComboBoxCliente = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextDescricao = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JDataRotinaContato = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabCodigo = new javax.swing.JLabel();
        jLabNCodigo = new javax.swing.JLabel();
        jLabCodEmpresa = new javax.swing.JLabel();
        jLabEmpresa = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextHora = new javax.swing.JFormattedTextField();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Rotina de Contato");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jToggleButton2.setText("Salvar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, -1));

        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jToggleButton3.setText("Sair");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        jLabel1.setText("Data:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        ComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxClienteActionPerformed(evt);
            }
        });
        jPanel1.add(ComboBoxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 250, -1));

        jTextDescricao.setColumns(20);
        jTextDescricao.setRows(5);
        jScrollPane1.setViewportView(jTextDescricao);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 320, 160));

        jLabel2.setText("Descrição do contato:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel3.setText("Hora:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));
        jPanel1.add(JDataRotinaContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 121, -1));

        jButton1.setText("Exibir Rotinas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, -1, -1));

        jLabCodigo.setText("codigo");
        jPanel1.add(jLabCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 140, 20));

        jLabNCodigo.setText("Código:");
        jPanel1.add(jLabNCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 20));
        jPanel1.add(jLabCodEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 76, 20));

        jLabEmpresa.setText("empresa");
        jPanel1.add(jLabEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 260, 20));

        jLabel8.setText("Empresa:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 20));

        try {
            jTextHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jTextHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 40, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void ComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxClienteActionPerformed
        idClienteComboBox();
    }//GEN-LAST:event_ComboBoxClienteActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed

        if (!jLabCodEmpresa.getText().isEmpty()) {            
            codCli = Integer.parseInt(jLabCodEmpresa.getText());
        }
        
        RotinaContatos rot = new RotinaContatos();
        rot.setIdCliente(codCli);
        rot.setIdUsuario(Usuario.idUsuario()); 
        rot.setDataRotinaContato(FormataData(JDataRotinaContato.getDate()));
        rot.setHoraRotinaContato(FuncoesDiversas.ConverterHora(jTextHora.getText()));
        rot.setDescricaoRotina(jTextDescricao.getText());
        
        RotinaContatosDAO.CadRotinaContato(rot);
        this.dispose();
        verificaPagina();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ExibeRotina().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void verificaPagina(){
        if ((this.detalharCliente != null)) {
            this.detalharCliente.setEnabled(true);
            this.detalharCliente.toFront();
            this.detalharCliente.TabelaLembrete2(codCli);
        }
    }
    
    private void populaComboBox() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabcliente";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                ComboBoxCliente.addItem(rs.getString("empresa"));
            }
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void idClienteComboBox() {
        
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabcliente where empresa = '" + ComboBoxCliente.getSelectedItem()+ "';";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                jLabCodEmpresa.setText(String.valueOf(rs.getInt("idcliente")));
            }
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox ComboBoxCliente;
    private com.toedter.calendar.JDateChooser JDataRotinaContato;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabCodEmpresa;
    private javax.swing.JLabel jLabCodigo;
    private javax.swing.JLabel jLabEmpresa;
    private javax.swing.JLabel jLabNCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextDescricao;
    private javax.swing.JFormattedTextField jTextHora;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    // End of variables declaration//GEN-END:variables
}
