package buscar;

import funcoes.Conexao;
import static funcoes.Graficos.graficoFPag;
import static funcoes.Graficos.graficoMarca;
import static funcoes.Graficos.graficoMeses;
import funcoes.ModeloTabela;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;


public class FrameBusca extends javax.swing.JFrame {

public static int contSelecao = 0;
String contBotao = "";
Statement st;
String qualbuscar;
    /**
     * Creates new form FrameBusca
     */
    public FrameBusca() {
        
    try {
        this.st = Conexao.getConnection().createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(FrameBusca.class.getName()).log(Level.SEVERE, null, ex);
    }
        initComponents();
        setLocationRelativeTo(null);
        totais();
        
    }
    
    private void totais(){    
        try {
            st = Conexao.getConnection().createStatement();

                String q = "";
                    q += "select * from total";
                    ResultSet rs;
                    rs = st.executeQuery(q);
                    rs.first();
                        totalCliente.setText(rs.getString("count(c.id)"));
                        quantMaq.setText(rs.getString("count(m.idMaquina)"));
                        orcamento.setText(rs.getString("count(ds.id_dtServ)"));
                        os.setText(rs.getString("count(os.idOS)"));
        } catch (SQLException ex) {
            Logger.getLogger(FrameBusca.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton3 = new javax.swing.JRadioButton();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jckCpf = new javax.swing.JCheckBox();
        jckId = new javax.swing.JCheckBox();
        jckNome = new javax.swing.JCheckBox();
        jckTel = new javax.swing.JCheckBox();
        jCheckBoxMaquina = new javax.swing.JCheckBox();
        jCheckBoxFormPag = new javax.swing.JCheckBox();
        jCheckBoxMarca = new javax.swing.JCheckBox();
        jCheckBoxReparo = new javax.swing.JCheckBox();
        jCheckBoxSO = new javax.swing.JCheckBox();
        valorValorRep = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox();
        letra = new javax.swing.JTextField();
        dataMaquina = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        data1 = new com.toedter.calendar.JDateChooser();
        data2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jButtonMeses = new javax.swing.JButton();
        jBtnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButtonMinerar = new javax.swing.JButton();
        jButtonFormPag = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        campoVar = new javax.swing.JLabel();
        totalCliente = new javax.swing.JLabel();
        Maquina = new javax.swing.JLabel();
        quantMaq = new javax.swing.JLabel();
        os = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        orcamento = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jRadioButton3.setText("jRadioButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(223, 237, 253));

        jckCpf.setText("CPF");

        jckId.setText("Código");

        jckNome.setText("Nome");

        jckTel.setText("Telefone");

        jCheckBoxMaquina.setText("Maquina");

        jCheckBoxFormPag.setText("Forma de Pagamento");

        jCheckBoxMarca.setText("Marca");

        jCheckBoxReparo.setText("Reparo");

        jCheckBoxSO.setText("Sistema Operacional");

        valorValorRep.setText("Valor do reparo");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buscar nome por letra", "Inicia com letra", "Termina com letra", "Contém a letra" }));

        dataMaquina.setText("Bucar por Data de cadastro de máquina");

        jLabel2.setText("Selecione a data inicial:");

        jLabel4.setText("Selecione a data final:");

        jButtonMeses.setText("Estatística mensal de serviços");
        jButtonMeses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMesesActionPerformed(evt);
            }
        });

        jBtnBuscar.setText("Minerar");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        jLabel17.setText("Estatísticas:");

        jButtonMinerar.setText("Marca mais defeituosa");
        jButtonMinerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinerarActionPerformed(evt);
            }
        });

        jButtonFormPag.setText("Forma de pagamento mais usada");
        jButtonFormPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFormPagActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        campoVar.setText("jLabel2");

        totalCliente.setText("cliente");

        Maquina.setText("Total de Serviços realizados:");

        quantMaq.setText("maquina");

        os.setText("os");

        jLabel3.setText("Total de Maquinas cadastradas:");

        orcamento.setText("orcamento");

        jLabel5.setText("Toatal de Clientes cadastrados:");

        jLabel8.setText("Total de Orçamentos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoVar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(Maquina)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantMaq)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(orcamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(os, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoVar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(totalCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantMaq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(orcamento))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(os)
                    .addComponent(Maquina))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataMaquina)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(letra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(data1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(22, 22, 22)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(data2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)))
                                .addComponent(jBtnBuscar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxMaquina)
                                    .addComponent(jckTel)
                                    .addComponent(jckId)
                                    .addComponent(jckCpf)
                                    .addComponent(jckNome))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxFormPag)
                                    .addComponent(jCheckBoxSO)
                                    .addComponent(valorValorRep)
                                    .addComponent(jCheckBoxMarca)
                                    .addComponent(jCheckBoxReparo)))
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonMeses)
                            .addComponent(jButtonMinerar)
                            .addComponent(jButtonFormPag))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jCheckBoxFormPag)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(letra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxMarca)
                                    .addComponent(jckId))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jCheckBoxReparo)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jCheckBoxSO)
                                                .addGap(3, 3, 3)
                                                .addComponent(valorValorRep))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(jckCpf)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jckTel)
                                                .addGap(3, 3, 3)
                                                .addComponent(jCheckBoxMaquina))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jckNome)))))
                        .addGap(27, 27, 27)
                        .addComponent(dataMaquina)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(data1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(data2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(jBtnBuscar)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel17)
                        .addGap(28, 28, 28)
                        .addComponent(jButtonMeses)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonMinerar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonFormPag))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
//        try {        
            contSelect(); 
            
            if (jComboBox1.getSelectedItem().equals("Buscar nome por letra") && (!dataMaquina.isSelected())){
                System.out.print(data1.getDate());
                
                if (valorValorRep.isSelected() || jCheckBoxReparo.isSelected()||jCheckBoxFormPag.isSelected()){
                    preencheTabela("select * from vw_reparo;");

                }else if (jCheckBoxMaquina.isSelected()||jCheckBoxMarca.isSelected()||jCheckBoxSO.isSelected()){
                    preencheTabela("select * from vw_maquina;");

                }else{
                    preencheTabela("select * from vw_cliente;");
                    
                } 
            }else if(dataMaquina.isSelected() && !jComboBox1.getSelectedItem().equals("Buscar nome por letra") ){
                qualItemEdata();
            }else
                if(!dataMaquina.isSelected()){
                qualItem();  
            }else{
                qualData();
            }
            
            contSelecao = 0;
            limpar();
            jLabel1.removeAll();
            jLabel1.revalidate();
            jLabel1.repaint();
//        } catch (Exception ex) {
//          System.out.println("erro de Botao");
//        }   
            
    }//GEN-LAST:event_jBtnBuscarActionPerformed
    
    private void limpar(){
        
        jckId.setSelected(false);
        jckNome.setSelected(false);
        jckCpf.setSelected(false);
        jckTel.setSelected(false);
        jCheckBoxMaquina.setSelected(false);
        jCheckBoxMarca.setSelected(false);
        jCheckBoxSO.setSelected(false);
        jCheckBoxReparo.setSelected(false);
        valorValorRep.setSelected(false);  
        jCheckBoxFormPag.setSelected(false);
        letra.setText(null);
        dataMaquina.setSelected(false);
        data1.setDate(null);
        data2.setDate(null);
    }
       
    public String opcoes() {
    
        String texto = ""; 
        if(jckId.isSelected())
            texto += "id;";            

        if(jckNome.isSelected())
            texto += "nome;";

        if(jckCpf.isSelected())
                texto += "cpf;";
        
        if(jckTel.isSelected())
            texto += "tel_cli;";
        
        if(jCheckBoxMaquina.isSelected())
            texto += "maquina;";
        
        if(jCheckBoxMarca.isSelected())
            texto += "marca;";
        
        if(jCheckBoxSO.isSelected())
            texto += "so;";
        
        if(jCheckBoxReparo.isSelected())
            texto += "reparo;";
        
        if(valorValorRep.isSelected())
            texto += "valorServ;";
        
        if(jCheckBoxFormPag.isSelected())
            texto += "forma_pag;";
        
        if(dataMaquina.isSelected())
            texto += "dataMaq;";
       
        return texto;       
    }
    
    public String NomesColunas() {    
        String texto = ""; 
        if(jckId.isSelected())
            texto += "Codigo;";
        
        if(jckNome.isSelected())
            texto += "Cliente;";
        
        if(jckCpf.isSelected())
            texto += "CPF;";
        
        if(jckTel.isSelected())
         texto += "Telefone;";
        
        if(jCheckBoxMaquina.isSelected())
            texto += "Maquina;";
        
        if(jCheckBoxMarca.isSelected())
            texto += "Marca;";
        
        if(jCheckBoxSO.isSelected())
            texto += "Sistema Op;";
        
        if(jCheckBoxReparo.isSelected())
            texto += "Reparo;";

        if(valorValorRep.isSelected())
            texto += "Valor Reparo;";
        
        if(jCheckBoxFormPag.isSelected())
            texto += "Forma de Pagamento;";
        
        if(dataMaquina.isSelected())
            texto += "Data de cad Maquina;";
         
        return texto;
    }

    public void contSelect() {

        int cont = 0; 
        if(jckId.isSelected())
            cont++;            
        if(jckNome.isSelected())
            cont++;
        if(jckCpf.isSelected())
            cont++;
        if(jckTel.isSelected())
            cont++;
        if(jCheckBoxMaquina.isSelected())
            cont++;
        if(jCheckBoxMarca.isSelected())
            cont++;
        if(jCheckBoxReparo.isSelected())
            cont++;
        if(jCheckBoxSO.isSelected())
            cont++;
        if(valorValorRep.isSelected())
            cont++;
        if(jCheckBoxFormPag.isSelected())
            cont++;
        if(dataMaquina.isSelected())    
            cont++;
        contSelecao = cont;         
    }

    public void preencheTabela(String Sql){
        try {            
            ArrayList dados = new ArrayList();
            String[] partes = new String[contSelecao];
            String[] partes2 = new String[contSelecao];
            String [] Colunas = new String[contSelecao];
            String [] NomesCol = new String[contSelecao];

                for (int i = 0; i < contSelecao; i++){
                    partes = opcoes().split(";",100);
                    partes2 = NomesColunas().split(";",100);
                    Colunas[i] = partes[i];
                    NomesCol[i] = partes2[i];
                }

            ResultSet rs = st.executeQuery(Sql);
            rs.first();

                if (contSelecao == 1){
                    do{
                        dados.add(new Object[]{rs.getObject(Colunas[0])});
                    }while(rs.next());

                }else if (contSelecao == 2){
                    do{
                        dados.add(new Object[]{rs.getObject(Colunas[0]),rs.getObject(Colunas[1])});
                    }while(rs.next());

                }else if (contSelecao == 3){
                    do{
                        dados.add(new Object[]{rs.getObject(Colunas[0]),rs.getObject(Colunas[1]),rs.getObject(Colunas[2])});
                    }while(rs.next());
                }
                else if (contSelecao == 4){
                    do{
                        dados.add(new Object[]{rs.getObject(Colunas[0]),rs.getObject(Colunas[1]),rs.getObject(Colunas[2]),rs.getObject(Colunas[3])});
                    }while(rs.next());
                }
                else if (contSelecao == 5){
                    do{
                        dados.add(new Object[]{rs.getObject(Colunas[0]),rs.getObject(Colunas[1]),rs.getObject(Colunas[2]),    
                        rs.getObject(Colunas[3]),rs.getObject(Colunas[4])});
                        
                    }while(rs.next());
                }
                else if (contSelecao == 6){
                    do{
                        dados.add(new Object[]{rs.getObject(Colunas[0]),rs.getObject(Colunas[1]),rs.getObject(Colunas[2]),
                            rs.getObject(Colunas[3]),rs.getObject(Colunas[4]),rs.getObject(Colunas[5])});
                    }while(rs.next());
                }
                else if (contSelecao == 7){
                    do{
                        dados.add(new Object[]{rs.getObject(Colunas[0]),rs.getObject(Colunas[1]),rs.getObject(Colunas[2]),
                            rs.getObject(Colunas[3]),rs.getObject(Colunas[4]),rs.getObject(Colunas[5]),rs.getObject(Colunas[6])});
                    }while(rs.next());
                } 
                else if (contSelecao == 8){
                    do{
                        dados.add(new Object[]{rs.getObject(Colunas[0]),rs.getObject(Colunas[1]),rs.getObject(Colunas[2]),
                            rs.getObject(Colunas[3]),rs.getObject(Colunas[4]),rs.getObject(Colunas[5]),rs.getObject(Colunas[6]),rs.getObject(Colunas[7])});
                    }while(rs.next());
                }
                else if (contSelecao == 9){
                    do{
                        dados.add(new Object[]{rs.getObject(Colunas[0]),rs.getObject(Colunas[1]),rs.getObject(Colunas[2]),
                            rs.getObject(Colunas[3]),rs.getObject(Colunas[4]),rs.getObject(Colunas[5]),rs.getObject(Colunas[6]),
                            rs.getObject(Colunas[7]),rs.getObject(Colunas[8])});
                    }while(rs.next());
                }
                else if (contSelecao == 10){
                    do{
                        dados.add(new Object[]{rs.getObject(Colunas[0]),rs.getObject(Colunas[1]),rs.getObject(Colunas[2]),
                            rs.getObject(Colunas[3]),rs.getObject(Colunas[4]),rs.getObject(Colunas[5]),rs.getObject(Colunas[6]),
                            rs.getObject(Colunas[7]),rs.getObject(Colunas[8]),rs.getObject(Colunas[9])});
                    }while(rs.next());
                }else if (contSelecao == 11){
                    do{
                        dados.add(new Object[]{rs.getObject(Colunas[0]),rs.getObject(Colunas[1]),rs.getObject(Colunas[2]),
                            rs.getObject(Colunas[3]),rs.getObject(Colunas[4]),rs.getObject(Colunas[5]),rs.getObject(Colunas[6]),
                            rs.getObject(Colunas[7]),rs.getObject(Colunas[8]),rs.getObject(Colunas[9]),rs.getObject(Colunas[10])});
                    }while(rs.next());
                }
                
                    for (int i = 0; i < contSelecao; i++){
                        ModeloTabela modelo = new ModeloTabela(dados, NomesCol);
                        jTable1.setModel(modelo);
                        jTable1.getColumnModel().getColumn(i).setPreferredWidth(150);
                        jTable1.getColumnModel().getColumn(i).setResizable(false);
                        jTable1.getTableHeader().setReorderingAllowed(false);
                        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
                        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não existe cadastro com "+letra.getText());
                jTable1.removeAll();
                jTable1.revalidate();
                jTable1.repaint();
                System.out.println("erro ao preencher o arraylist");
            }    
    }
    
    private void jButtonMinerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinerarActionPerformed

        try { 
            contBotao = "2";    
            String Sql = "select marca, count(marca) 'Quant' from maquina group by marca order by count(marca) desc;";
            ArrayList ranking = new ArrayList();
            int lugar = 1;
            String NomeCol[] = {"Ranking","Marca", "Quantidade"};
            ResultSet rs;

            rs = st.executeQuery(Sql);
            rs.first();

                do{
                    ranking.add(new Object[]{lugar +"º lugar",rs.getString("marca"),rs.getString("Quant")});
                    lugar++;
                }while(rs.next());

                    for (int i = 0; i < 3; i++){
                        ModeloTabela modelo = new ModeloTabela(ranking, NomeCol);
                        jTable1.setModel(modelo);
                        jTable1.getColumnModel().getColumn(i).setPreferredWidth(200);
                        jTable1.getColumnModel().getColumn(i).setResizable(false);
                        jTable1.getTableHeader().setReorderingAllowed(false);
                        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
                        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    }
                  
            graficoMarca();
            criaGrafico("Marca com mais defeitos");

        } catch (SQLException ex) {
            Logger.getLogger(FrameBusca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonMinerarActionPerformed

    private void jButtonFormPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFormPagActionPerformed
        try {
            contBotao = "1";
            String Sql = "select forma_pag , count(forma_pag) , sum(ROUND (total, 2)) 'total' from det_serv inner join os\n" +
                         "where (id_dtServ = os_idOS)\n" +
                         "group by forma_pag order by count(forma_pag) desc";
            ArrayList ranking = new ArrayList();
            int lugar = 1;
            String NomeCol[] = {"Ranking","Forma de Pagamento", "Quantidade", "Total Venda"};
            ResultSet rs;
    
            rs = st.executeQuery(Sql);
            rs.first();
            
                do{
                    ranking.add(new Object[]{lugar +"º lugar",rs.getString("forma_pag"),rs.getString("count(forma_pag)"),rs.getString("total")});
                    lugar++;
                }while(rs.next());
                    
                    for (int i = 0; i < 4; i++){
                        ModeloTabela modelo = new ModeloTabela(ranking, NomeCol);
                        jTable1.setModel(modelo);
                        jTable1.getColumnModel().getColumn(i).setPreferredWidth(150);
                        jTable1.getColumnModel().getColumn(i).setResizable(false);
                        jTable1.getTableHeader().setReorderingAllowed(false);
                        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);                      
                    } 
                    
            graficoFPag();
            criaGrafico("Forma de pagamento mais usada");
            
        } catch (SQLException ex) {
            Logger.getLogger(FrameBusca.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_jButtonFormPagActionPerformed

    private void jButtonMesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMesesActionPerformed
        contBotao = "3";
        graficoMeses();
        criaGrafico("Meses");
    }//GEN-LAST:event_jButtonMesesActionPerformed
   
    private void qualItem(){
        
        contSelect();
        String l = letra.getText();
   
        if(jComboBox1.getSelectedItem().equals("Inicia com letra")){
                
            if (valorValorRep.isSelected() || jCheckBoxReparo.isSelected()||jCheckBoxFormPag.isSelected()){
                preencheTabela("select * from vw_reparo where nome like '" +l+ "%';");
                System.out.println(qualbuscar);

            }else if (jCheckBoxMaquina.isSelected()||jCheckBoxMarca.isSelected()||jCheckBoxSO.isSelected()){
                preencheTabela("select * from vw_maquina  where nome like '" +l+ "%';");

            }else{
                preencheTabela("select * from vw_cliente  where nome like '" +l+ "%';");
            }
            
        }else if(jComboBox1.getSelectedItem().equals("Termina com letra")){
                if (valorValorRep.isSelected() || jCheckBoxReparo.isSelected()||jCheckBoxFormPag.isSelected()){
                    preencheTabela("select * from vw_reparo where nome like '%" +l+ "';");

                }else if (jCheckBoxMaquina.isSelected()||jCheckBoxMarca.isSelected()||jCheckBoxSO.isSelected()){
                    preencheTabela("select * from vw_maquina where nome like '%" +l+ "';");

                }else{
                    preencheTabela("select * from vw_cliente where nome like '%" +l+ "';");

                }
                
        }else if(jComboBox1.getSelectedItem().equals("Contém a letra")){
            
            if (valorValorRep.isSelected() || jCheckBoxReparo.isSelected()||jCheckBoxFormPag.isSelected()){
                preencheTabela("select * from vw_reparo where nome like '%" +l+ "%';");

            }else if (jCheckBoxMaquina.isSelected()||jCheckBoxMarca.isSelected()||jCheckBoxSO.isSelected()){
                preencheTabela("select * from vw_maquina where nome like '%" +l+ "%';");

            }else{
                preencheTabela("select * from vw_cliente where nome like '%" +l+ "%';");

            }
        }
            limpar();
            jComboBox1.setSelectedIndex(0); 
            contSelecao = 0;
            jLabel1.removeAll();
            jLabel1.revalidate();
            jLabel1.repaint();
    }
    private void qualItemEdata(){
       try{
        SimpleDateFormat formatador = new SimpleDateFormat("ddMMyyyy");
            String dt1 = formatador.format(data1.getDate());
            String dt2 = formatador.format(data2.getDate());
            System.out.println(dt1);
            System.out.println(dt2);
        contSelect();
        String l = letra.getText();
   
        if(jComboBox1.getSelectedItem().equals("Inicia com letra")){
                
            if (valorValorRep.isSelected() || jCheckBoxReparo.isSelected()||jCheckBoxFormPag.isSelected()){
                preencheTabela("select * from vw_reparo where nome like '" +l+ "%' and dataMaq between '" +dt1+ "' and '" +dt2+ "';");
                System.out.println(qualbuscar);

            }else if (jCheckBoxMaquina.isSelected()||jCheckBoxMarca.isSelected()||jCheckBoxSO.isSelected()){
                preencheTabela("select * from vw_maquina  where nome like '" +l+ "%' and dataMaq between '" +dt1+ "' and '" +dt2+ "';");

            }else{
                preencheTabela("select * from vw_cliente  where nome like '" +l+ "%' and dataMaq between '" +dt1+ "' and '" +dt2+ "';");
            }
            
        }else if(jComboBox1.getSelectedItem().equals("Termina com letra")){
                if (valorValorRep.isSelected() || jCheckBoxReparo.isSelected()||jCheckBoxFormPag.isSelected()){
                    preencheTabela("select * from vw_reparo where nome like '%" +l+ "' and dataMaq between '" +dt1+ "' and '" +dt2+ "';");

                }else if (jCheckBoxMaquina.isSelected()||jCheckBoxMarca.isSelected()||jCheckBoxSO.isSelected()){
                    preencheTabela("select * from vw_maquina where nome like '%" +l+ "' and dataMaq between '" +dt1+ "' and '" +dt2+ "';");

                }else{
                    preencheTabela("select * from vw_cliente where nome like '%" +l+ "' and dataMaq between '" +dt1+ "' and '" +dt2+ "';");

                }
                
        }else if(jComboBox1.getSelectedItem().equals("Contém a letra")){
            
            if (valorValorRep.isSelected() || jCheckBoxReparo.isSelected()||jCheckBoxFormPag.isSelected()){
                preencheTabela("select * from vw_reparo where nome like '%" +l+ "%'; and dataMaq between '" +dt1+ "' and '" +dt2+ "';");

            }else if (jCheckBoxMaquina.isSelected()||jCheckBoxMarca.isSelected()||jCheckBoxSO.isSelected()){
                preencheTabela("select * from vw_maquina where nome like '%" +l+ "%' and dataMaq between '" +dt1+ "' and '" +dt2+ "';");

            }else{
                preencheTabela("select * from vw_cliente where nome like '%" +l+ "%' and dataMaq between '" +dt1+ "' and '" +dt2+ "';");

            }
        }
            limpar();
            jComboBox1.setSelectedIndex(0); 
            contSelecao = 0;
            jLabel1.removeAll();
            jLabel1.revalidate();
            jLabel1.repaint();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Campo data Inválido!");
        }
    }
    private void qualData(){
        try{
            SimpleDateFormat formatador = new SimpleDateFormat("ddMMyyyy");
            String dt1 = formatador.format(data1.getDate());
            String dt2 = formatador.format(data2.getDate());
            System.out.println(dt1);
            System.out.println(dt2);
        
        if(dataMaquina.isSelected()){
            
            if (valorValorRep.isSelected() || jCheckBoxReparo.isSelected()||jCheckBoxFormPag.isSelected()){
                    preencheTabela("select * from vw_reparo where dataMaq between '" +dt1+ "' and '" +dt2+ "';");

                }else if (jCheckBoxMaquina.isSelected()||jCheckBoxMarca.isSelected()||jCheckBoxSO.isSelected()){
                    preencheTabela("select * from vw_maquina where dataMaq between '" +dt1+ "' and '" +dt2+ "';");

                }else{
                    preencheTabela("select * from vw_cliente where dataMaq between '" +dt1+ "' and '" +dt2+ "';");

                } 
        }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Campo data Inválido!");
        }
            
            limpar();
            jComboBox1.setSelectedIndex(0);
            jLabel1.removeAll();
            jLabel1.revalidate();
            jLabel1.repaint();
    }
    
    public void criaGrafico(String a) {
        
        CategoryDataset cds = null;
            if( "1".equals(contBotao)){
                cds = graficoFPag();

            }if("2".equals(contBotao)){
                cds = graficoMarca();
            }
            if("3".equals(contBotao)){
                cds = graficoMeses();
            }
        
        String titulo = a;
        String eixoy = "Valores em porcentagem";
        String txt_legenda = "Legenda:";
        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;
        JFreeChart graf = ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setSize(jLabel1.getWidth(),jLabel1.getHeight());
        myChartPanel.setVisible(true);
        jLabel1.removeAll();
        jLabel1.add(myChartPanel);
        jLabel1.revalidate();
        jLabel1.repaint();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Maquina;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel campoVar;
    private com.toedter.calendar.JDateChooser data1;
    private com.toedter.calendar.JDateChooser data2;
    private javax.swing.JRadioButton dataMaquina;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jButtonFormPag;
    private javax.swing.JButton jButtonMeses;
    private javax.swing.JButton jButtonMinerar;
    private javax.swing.JCheckBox jCheckBoxFormPag;
    private javax.swing.JCheckBox jCheckBoxMaquina;
    private javax.swing.JCheckBox jCheckBoxMarca;
    private javax.swing.JCheckBox jCheckBoxReparo;
    private javax.swing.JCheckBox jCheckBoxSO;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JCheckBox jckCpf;
    private javax.swing.JCheckBox jckId;
    private javax.swing.JCheckBox jckNome;
    private javax.swing.JCheckBox jckTel;
    private javax.swing.JTextField letra;
    private javax.swing.JLabel orcamento;
    private javax.swing.JLabel os;
    private javax.swing.JLabel quantMaq;
    private javax.swing.JLabel totalCliente;
    private javax.swing.JCheckBox valorValorRep;
    // End of variables declaration//GEN-END:variables
}
