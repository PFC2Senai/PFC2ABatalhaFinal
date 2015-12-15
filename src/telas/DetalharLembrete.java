package telas;


import atributos.Cliente;
import atributos.Lembrete;
import funcoes.ClienteDAO;
import funcoes.FuncoesDiversas;
import static funcoes.FuncoesDiversas.ConverterData;
import static funcoes.FuncoesDiversas.FormataData;
import funcoes.LembreteDAO;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import static telas.DetalharCliente.GetIdLembrete;
import static telas.ExibeCliente.GetIndice;



public class DetalharLembrete extends javax.swing.JFrame {

    private DetalharCliente detalharCliente;
    private PreparedStatement pst;
    private int codCli;
    /**
     * Creates new form DetalheLembrete
     */
    public DetalharLembrete() {
        initComponents();
        CarregaLembrete();
        DesabilitarCampos();
        DadosEmpresa();
    }
    
    public DetalharLembrete(DetalharCliente detalharCliente) {
        this();
        this.detalharCliente = detalharCliente; 
        codCli = GetIndice(); //GetIndice está no form exibecliente, retorna o id do cliente selecionado na tabela
        DadosEmpresa();
    }
    
    private void DesabilitarCampos() {
        
        jBtnAlterarLembrete.setVisible(false);
        txtDataLembrete.setVisible(false);
        txtDescricaoLembrete.setEnabled(false);
        txtHoraLembrete.setVisible(false);
        jBtnCancel.setVisible(false);
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLbDataLembrete = new javax.swing.JLabel();
        jLbHoraLembrete = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBtnEditarLembrete = new javax.swing.JButton();
        jBtnAlterarLembrete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricaoLembrete = new javax.swing.JTextArea();
        txtHoraLembrete = new javax.swing.JFormattedTextField();
        txtDataLembrete = new com.toedter.calendar.JDateChooser();
        jBtnExcluir = new javax.swing.JButton();
        jBtnCancel = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabCodigo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabEmpresa = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Lembrete:");

        jLabel2.setText("Data:");

        jLabel3.setText("Hora:");

        jLbDataLembrete.setText("Exibe Data");

        jLbHoraLembrete.setText("Exibe Hora");

        jLabel6.setText("Descrição:");

        jBtnEditarLembrete.setText("Editar");
        jBtnEditarLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarLembreteActionPerformed(evt);
            }
        });

        jBtnAlterarLembrete.setText("Salvar");
        jBtnAlterarLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarLembreteActionPerformed(evt);
            }
        });

        txtDescricaoLembrete.setColumns(20);
        txtDescricaoLembrete.setRows(5);
        jScrollPane1.setViewportView(txtDescricaoLembrete);

        try {
            txtHoraLembrete.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHoraLembrete.setText("00:00");

        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnCancel.setText("Cancelar");
        jBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelActionPerformed(evt);
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Código:");

        jLabCodigo.setText("codigo");

        jLabel5.setText("Empresa:");

        jLabEmpresa.setText("empresa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(jLabCodigo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(jLabEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(txtDataLembrete, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLbDataLembrete, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(jLbHoraLembrete, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtHoraLembrete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnEditarLembrete)
                        .addGap(6, 6, 6)
                        .addComponent(jBtnAlterarLembrete)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnCancel)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnExcluir))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabCodigo))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addComponent(jLabEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtDataLembrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLbDataLembrete, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(jLbHoraLembrete, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtHoraLembrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnEditarLembrete)
                    .addComponent(jBtnAlterarLembrete)
                    .addComponent(jBtnCancel)
                    .addComponent(jBtnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void CarregaLembrete() {

        ArrayList<Lembrete> lembretes = new ArrayList<Lembrete>();
        lembretes = LembreteDAO.CarregaLembrete(GetIdLembrete());       

            for (Lembrete lem : lembretes) {

                jLbDataLembrete.setText(String.valueOf(lem.getDataLembrete()));
                jLbHoraLembrete.setText(String.valueOf(lem.getHora()));
                txtDescricaoLembrete.setText(lem.getDescricao());
            }
    }
    
    private void DadosEmpresa() {

        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente = ClienteDAO.CarregaNomeCliente(codCli);       

            for (Cliente cli : cliente) {

                jLabCodigo.setText(String.valueOf(cli.getId()));
                jLabEmpresa.setText(cli.getEmpresa());
            }
    }
    
    private void jBtnEditarLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarLembreteActionPerformed
        
        txtHoraLembrete.setText(jLbHoraLembrete.getText());
        
        Date d = ConverterData(jLbDataLembrete.getText());
        txtDataLembrete.setDate(d);
        txtDataLembrete.setVisible(true);        
        txtHoraLembrete.setVisible(true);
        jLbDataLembrete.setVisible(false);       
        jLbHoraLembrete.setVisible(false);             
        jBtnAlterarLembrete.setVisible(true);
        jBtnEditarLembrete.setVisible(false);
        txtDescricaoLembrete.setEnabled(true);  
        jBtnCancel.setVisible(true);     
        
    }//GEN-LAST:event_jBtnEditarLembreteActionPerformed

    private void jBtnAlterarLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarLembreteActionPerformed
               
        try {
            Lembrete lembrete = new Lembrete();
            
            lembrete.setDataLembrete(FormataData(txtDataLembrete.getDate()));            
            lembrete.setHora(FuncoesDiversas.ConverterHora(txtHoraLembrete.getText()));
            lembrete.setDescricao(txtDescricaoLembrete.getText());                    
            lembrete.setCodCliente(ExibeCliente.GetIndice());
            LembreteDAO.UpdateLembrete(lembrete, GetIdLembrete());                       
            
            jLbHoraLembrete.setVisible(true);
            jLbDataLembrete.setVisible(true);
            CarregaLembrete();
            DesabilitarCampos();    
            jBtnEditarLembrete.setVisible(true);
            
            this.detalharCliente.TabelaLembrete2(codCli);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Campo data Inválido!");
        }        
    }//GEN-LAST:event_jBtnAlterarLembreteActionPerformed
                                                     

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        LembreteDAO.ExcluirLembrete(GetIdLembrete());
        this.detalharCliente.TabelaLembrete2(codCli);
        this.dispose();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelActionPerformed
        jLbHoraLembrete.setVisible(true);
        jLbDataLembrete.setVisible(true);
        CarregaLembrete();
        DesabilitarCampos();    
        jBtnEditarLembrete.setVisible(true);
    }//GEN-LAST:event_jBtnCancelActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        //habilita a tela principal
        this.detalharCliente.setEnabled(true);
        //coloca a tela principal na frente
        this.detalharCliente.toFront();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        this.detalharCliente.setEnabled(true);
        this.detalharCliente.toFront();
    }//GEN-LAST:event_formWindowClosed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterarLembrete;
    private javax.swing.JButton jBtnCancel;
    private javax.swing.JButton jBtnEditarLembrete;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabCodigo;
    private javax.swing.JLabel jLabEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLbDataLembrete;
    private javax.swing.JLabel jLbHoraLembrete;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser txtDataLembrete;
    private javax.swing.JTextArea txtDescricaoLembrete;
    private javax.swing.JFormattedTextField txtHoraLembrete;
    // End of variables declaration//GEN-END:variables
}
