package telas;

import static funcoes.Conexao.getConnection;
import funcoes.ModeloTabela;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Josy
 */
public class ExibeAluguel2 extends javax.swing.JFrame {

    Statement stmt;
    /**
     * Creates new form ExibeAluguel2
     */
    public ExibeAluguel2() {
        initComponents();
        TabelaAluguel("SELECT * FROM vw_aluguel;");
    }

    public void TabelaAluguel(String Sql) {

        try {

            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();
            String[] Colunas = {"Código", "Cliente", "Data de Locação", "Data de Devolução"};

            ResultSet rs;
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                dados.add(new Object[]{rs.getObject("idtabDetLocacao"), rs.getObject("empresa"),
                rs.getObject("dataLocacao"), rs.getObject("dataDevolucao")});               
            }

            for (int i = 0; i < 4; i++) {
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarAluguel.setModel(modelo);
                jTableListarAluguel.getColumnModel().getColumn(i).setPreferredWidth(150);
                jTableListarAluguel.getColumnModel().getColumn(i).setResizable(false);
                jTableListarAluguel.getTableHeader().setReorderingAllowed(false);
                jTableListarAluguel.setAutoResizeMode(jTableListarAluguel.AUTO_RESIZE_OFF);
                jTableListarAluguel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExibeAluguel2.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception erro) {
            Logger.getLogger(ExibeAluguel2.class.getName()).log(Level.SEVERE, null, erro);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListarAluguel = new javax.swing.JTable();
        jBtnDetalhar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableListarAluguel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableListarAluguel);

        jBtnDetalhar.setText("Detalhar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarAluguel, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnDetalhar, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnDetalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDetalharActionPerformed(evt);
            }
        });

        jLabel1.setText("Aluguel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnDetalhar))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnDetalhar)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnDetalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDetalharActionPerformed
        int linha = jTableListarAluguel.getSelectedRow();        
        int idAluguel = (Integer.parseInt(jTableListarAluguel.getValueAt(linha, 0).toString()));
        new DetalharAluguel(idAluguel).setVisible(true);
    }//GEN-LAST:event_jBtnDetalharActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnDetalhar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListarAluguel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}