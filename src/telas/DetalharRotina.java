/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import atributos.Cliente;
import atributos.RotinaContatos;
import funcoes.ClienteDAO;
import funcoes.RotinaContatosDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static telas.DetalharCliente.GetIdRotina;
import static telas.ExibeCliente.GetIndice;

/**
 *
 * @author Josy
 */
public class DetalharRotina extends javax.swing.JFrame {

    private DetalharCliente detalharCliente;
    private int codCli;
    /**
     * Creates new form DetalharRotina
     */
    public DetalharRotina() {
        initComponents();
        CarregaRotina();
        DadosEmpresa();
    }
    
    public DetalharRotina(DetalharCliente detalharCliente) {
        this();
        this.detalharCliente = detalharCliente; 
        codCli = GetIndice();
        DadosEmpresa();
        
      //  verificaPagina();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabCodigo = new javax.swing.JLabel();
        jLabEmpresa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricaoLembrete = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLbDataLembrete = new javax.swing.JLabel();
        jBtnExcluirRotinaContato = new javax.swing.JButton();
        jBtnSairDetRotina = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLbHoraLembrete = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Código:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Rotina de Contato");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabCodigo.setText("codigo");
        jPanel1.add(jLabCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, 20));

        jLabEmpresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabEmpresa.setText("empresa");
        jPanel1.add(jLabEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 176, 20));

        txtDescricaoLembrete.setEditable(false);
        txtDescricaoLembrete.setColumns(20);
        txtDescricaoLembrete.setRows(5);
        jScrollPane1.setViewportView(txtDescricaoLembrete);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 342, 195));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Descrição:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLbDataLembrete.setText("Exibe Data");
        jPanel1.add(jLbDataLembrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 130, 23));

        jBtnExcluirRotinaContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jBtnExcluirRotinaContato.setText("Excluir");
        jBtnExcluirRotinaContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirRotinaContatoActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnExcluirRotinaContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jBtnSairDetRotina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.gif"))); // NOI18N
        jBtnSairDetRotina.setText("Sair");
        jBtnSairDetRotina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSairDetRotinaActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnSairDetRotina, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 83, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Empresa:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Data:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Hora:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, 20));

        jLbHoraLembrete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLbHoraLembrete.setText("Exibe Hora");
        jPanel1.add(jLbHoraLembrete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 95, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img2.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnExcluirRotinaContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirRotinaContatoActionPerformed
       if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION) == 0) {
            RotinaContatosDAO.ExcluirRotina(GetIdRotina());
            this.detalharCliente.TabelaRotina("select  * from tabrotinacontato where cliente_idcliente = " + codCli + ";");
            this.dispose();
       }
    }//GEN-LAST:event_jBtnExcluirRotinaContatoActionPerformed

    private void jBtnSairDetRotinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSairDetRotinaActionPerformed
        this.dispose();
        //habilita a tela principal
        this.detalharCliente.setEnabled(true);
        //coloca a tela principal na frente
        this.detalharCliente.toFront();
    }//GEN-LAST:event_jBtnSairDetRotinaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void DadosEmpresa() {

        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente = ClienteDAO.CarregaNomeCliente(codCli);       

            for (Cliente cli : cliente) {

                jLabCodigo.setText(String.valueOf(cli.getId()));
                jLabEmpresa.setText(cli.getEmpresa());
            }
    }

    private void CarregaRotina() {

        ArrayList<RotinaContatos> rotinasrotinas = new ArrayList<RotinaContatos>();
        rotinasrotinas = RotinaContatosDAO.CarregaRotina(GetIdRotina());       

            for (RotinaContatos r : rotinasrotinas) {

                jLbDataLembrete.setText(String.valueOf(r.getDataRotinaContato()));
                jLbHoraLembrete.setText(String.valueOf(r.getHoraRotinaContato()));
                txtDescricaoLembrete.setText(r.getDescricaoRotina());
            }
    }
    
    private void verificaPagina() {
        if ((this.detalharCliente != null)) {
            this.detalharCliente.setEnabled(true);
            this.detalharCliente.toFront();            
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnExcluirRotinaContato;
    private javax.swing.JButton jBtnSairDetRotina;
    private javax.swing.JLabel jLabCodigo;
    private javax.swing.JLabel jLabEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLbDataLembrete;
    private javax.swing.JLabel jLbHoraLembrete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescricaoLembrete;
    // End of variables declaration//GEN-END:variables
}
