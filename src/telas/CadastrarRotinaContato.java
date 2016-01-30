package telas;

import atributos.Cliente;
import atributos.RotinaContatos;
import atributos.Usuario;
import funcoes.ClienteDAO;
import funcoes.Conexao;
import funcoes.FuncoesDiversas;
import static funcoes.FuncoesDiversas.FormataData;
import funcoes.RotinaContatosDAO;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CadastrarRotinaContato extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private int codCliCombo;
    private int codCli;
    private DetalharCliente detalharCliente;
    private ExibeCliente telaExibeCliente;

    public CadastrarRotinaContato() {
        initComponents();
        this.carregarComboClientes();
        combobox();
        jLabCodigo.setVisible(false);
        jLabEmpresa.setVisible(false);
        jLabNCodigo.setVisible(false);
    }

    public CadastrarRotinaContato(int codCliente, ExibeCliente exibeCli) {
        initComponents();
        this.codCli = codCliente;
        this.telaExibeCliente = exibeCli;
        uJComboBoxClientes.setVisible(false);
        DadosEmpresa();
    }

    public CadastrarRotinaContato(int codCliente, DetalharCliente detalharCliente) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextDescricao = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JDataRotinaContato = new com.toedter.calendar.JDateChooser();
        jLabCodigo = new javax.swing.JLabel();
        jLabNCodigo = new javax.swing.JLabel();
        jLabEmpresa = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextHora = new javax.swing.JFormattedTextField();
        uJComboBoxClientes = new componentes.UJComboBox();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Rotina de Contato");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        jToggleButton2.setText("Salvar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, -1, -1));

        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/stop2.png"))); // NOI18N
        jToggleButton3.setText("Cancelar");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        jLabel1.setText("Data:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jTextDescricao.setColumns(20);
        jTextDescricao.setRows(5);
        jScrollPane1.setViewportView(jTextDescricao);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 340, 160));

        jLabel2.setText("Descrição do contato:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel3.setText("Hora:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));
        jPanel1.add(JDataRotinaContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 121, -1));

        jLabCodigo.setText("codigo");
        jPanel1.add(jLabCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 140, 20));

        jLabNCodigo.setText("Código:");
        jPanel1.add(jLabNCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 20));

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

        uJComboBoxClientes.setEditable(true);
        uJComboBoxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uJComboBoxClientesActionPerformed(evt);
            }
        });
        jPanel1.add(uJComboBoxClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 280, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair? Os dados não serão salvos.", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
            verificaPagina();
            this.dispose();
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        if (VerificaCampos() == true) {

            if (codCliCombo != 0) {
                codCli = codCliCombo;
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
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void uJComboBoxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJComboBoxClientesActionPerformed
        codCliCombo = 0;
        idClienteComboBox();
    }//GEN-LAST:event_uJComboBoxClientesActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private boolean VerificaCampos() {

        boolean valida = true;

        if (uJComboBoxClientes.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (JDataRotinaContato.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (jTextHora.getText().trim().equals(":")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }
        
        if (jTextDescricao.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        return valida;
    }

    private void verificaPagina() {
        if ((this.detalharCliente != null)) {
            this.detalharCliente.setEnabled(true);
           // this.detalharCliente.toFront();
            this.detalharCliente.TabelaRotina("select  * from tabrotinacontato where cliente_idcliente = " + codCli + ";");
        }else if ((this.telaExibeCliente != null)) {
            this.telaExibeCliente.setEnabled(true);
          //  this.telaExibeCliente.toFront();
        }
    }

    private void carregarComboClientes() {

        uJComboBoxClientes.clear();

        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente = ClienteDAO.ComboCliente();
        
        uJComboBoxClientes.addItem("Selecione o cliente");
        for (Cliente cli : cliente) {
            uJComboBoxClientes.addItem(cli.getEmpresa(), cli);
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
                codCliCombo = (rs.getInt("idcliente"));
            }

        } catch (SQLException ex) {
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
    private com.toedter.calendar.JDateChooser JDataRotinaContato;
    private com.toedter.calendar.JCalendar jCalendar1;
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
    private componentes.UJComboBox uJComboBoxClientes;
    // End of variables declaration//GEN-END:variables
}
