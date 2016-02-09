/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import atributos.Cliente;
import atributos.DetServicoProduto;
import atributos.DetServicoTipoServ;
import atributos.OrdemServico;
import atributos.Produto;
import atributos.Usuario;
import atributos.Vendas;
import funcoes.ClienteDAO;
import funcoes.Conexao;
import static funcoes.Conexao.getConnection;
import funcoes.DetServicoProdutoDAO;
import funcoes.FuncoesDiversas;
import static funcoes.FuncoesDiversas.FormataData;
import funcoes.ModeloTabela;
import funcoes.OrdemServicoDAO;
import funcoes.ProdutoDAO;
import funcoes.ServicoDAO;
import funcoes.VendasDAO;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WilhamJr
 */
public class CadastrarVenda extends javax.swing.JFrame {

    private PreparedStatement pst;
    private int codOrdemServ;
    private int codProduto;
    private int codModelo;
    private int codDetProduto;
    private int codFabricante;
    private int codCliente;

    private String produto;
    private String fabricante;
    private String modelo;
    private String cliente;
    Statement stmt;

    private double totalPeca = 0;
    private double valor;
    private double valorUnit;

    /**
     * Creates new form CadastrarVenda
     */
    public CadastrarVenda() {
        initComponents();
        //TabelaVendas("select * from tabvendas;");
        populaComboBoxProdutos();
        jTextTotal.setEditable(false);
        carregarComboClientes();
        combobox();
    }

    private void combobox() {

        //Combobox clientes
        uJComboBoxCliente.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codCliente == 0) {
                    Mensangem();
                    uJComboBoxCliente.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        uJComboBoxCliente.setAutocompletar(true);
    }

    private void Mensangem() {
        JOptionPane.showMessageDialog(null, "Esse registro não encontra-se cadastrado na base de dados.");
    }

    private void limparCampos() {

        jTextHora.setText("");
        JDataVenda.setDate(null);
        jComboBoxProdutos.setSelectedItem("Selecione");
        jComboFabricante.setSelectedItem("Selecione");
        jComboModelo.setSelectedItem("Selecione");
        jTextValorUnit.setText("");
        jTextTotal.setText("");
        jTextQuantidadeProduto.setText("");
        ((DefaultTableModel) jTableProduto.getModel()).setNumRows(0);
        jTableProduto.updateUI();
    }

    private void populaComboBoxProdutos() {
        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabproduto";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                jComboBoxProdutos.addItem(rs.getString("produto"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idProdutoComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabproduto inner join tabdetproduto on tabproduto_id_prod = id_prod"
                + " where produto = '" + jComboBoxProdutos.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codProduto = (rs.getInt("id_prod"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void CarregaValorUnit() {

        valor = ProdutoDAO.ExisteProduto(codProduto, codModelo, codFabricante);

        if (valor != 0) {
            jTextValorUnit.setText(String.valueOf(valor));
        }
    }

    public void TabelaProduto() {

        //CarregaValorUnit();  
        codDetProduto = ProdutoDAO.codDetProduto();
        int quantidade = Integer.parseInt(jTextQuantidadeProduto.getText());
        valorUnit = Double.parseDouble(jTextValorUnit.getText());
        double total = valorUnit * quantidade;

        try {

            DefaultTableModel dtm = (DefaultTableModel) jTableProduto.getModel();

            dtm.addRow(new Object[]{codDetProduto, produto, modelo, fabricante, quantidade,
                valorUnit,
                total});

            totalPeca += total;
            jTextTotal.setEditable(false);
            jTextTotal.setText(String.valueOf(totalPeca));

            jTextQuantidadeProduto.setText("");

        } catch (Exception erro) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    private void populaComboBoxModelo() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select modelo "
                + " from tabdetproduto inner join "
                + " tabproduto inner join "
                + " tabmodelo on tabmodelo_idtabModelo = idtabModelo and "
                + " tabproduto_id_prod = id_prod"
                + " where id_prod = " + codProduto + " group by modelo;";
        System.out.println(codProduto);

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                jComboModelo.addItem(rs.getString("modelo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idModeloComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabmodelo where modelo = '" + jComboModelo.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codModelo = (rs.getInt("idtabModelo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void populaComboBoxFabricante() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "SELECT * FROM vw_combofabricanteproduto "
                + " WHERE id_prod = " + codProduto
                + " AND tabmodelo_idtabModelo = " + codModelo + " group by fabricante;";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                jComboFabricante.addItem(rs.getString("fabricante"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void idFabricanteComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabfabricante where fabricante = '" + jComboFabricante.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codFabricante = (rs.getInt("idtabFabricante"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private boolean ValidaHora() {
                boolean valide = true;
		String hora = jTextHora.getText();
		String[] hm = hora.split(":"); 
		int horas = Integer.parseInt( hm[0]);
		int minutos = Integer.parseInt( hm[1]);
		if( horas > 24 || minutos > 59 ){
                valide = false;
                return valide;
		}
                return valide;
	}
    
    private boolean VerificaCampos() {
        boolean valida = true;

        if (jComboBoxProdutos.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Selecione a PEÇA!");
            jComboBoxProdutos.requestFocus();
            jComboBoxProdutos.setBackground(Color.yellow);
            valida = false;
            return valida;
        }

        if (jComboModelo.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Selecione o MODELO!");
            jComboModelo.requestFocus();
            jComboModelo.setBackground(Color.yellow);
            valida = false;
            return valida;
        }

        if (jComboFabricante.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Selecione o FABRICANTE!");
            jComboFabricante.requestFocus();
            jComboFabricante.setBackground(Color.yellow);
            valida = false;
            return valida;
        }

        if (JDataVenda.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Preencha o campo DATA!");
            JDataVenda.requestFocus();
            JDataVenda.setBackground(Color.yellow);
            valida = false;
            return valida;
        }
        
        if (jTextHora.getText() == null || jTextHora.getText().trim().equals( ":" ) || ValidaHora() == false) {
            JOptionPane.showMessageDialog(null, "Preencha o campo HORA!");
            jTextHora.requestFocus();
            jTextHora.setBackground(Color.yellow);
            valida = false;
            return valida;
        }

        if (jTextValorUnit.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo VALOR!");
            jTextValorUnit.requestFocus();
            jTextValorUnit.setBackground(Color.yellow);
            valida = false;
            return valida;
        }

        if (jTextQuantidadeProduto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo QUANTIDADE!");
            valida = false;
            return valida;
        }

        if (jTextTotal.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo TOTAL!");
            valida = false;
            return valida;
        }
        return valida;
    }

    private void idClienteComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select idcliente from tabcliente where empresa = '" + uJComboBoxCliente.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codCliente = (rs.getInt("idcliente"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void carregarComboClientes() {

        uJComboBoxCliente.clear();

        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente = ClienteDAO.ComboCliente();

        for (Cliente cli : cliente) {
            uJComboBoxCliente.addItem(cli.getEmpresa(), cli);
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
        jTextHora = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        uJComboBoxCliente = new componentes.UJComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxProdutos = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jComboModelo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jComboFabricante = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        JDataVenda = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();
        jTextValorUnit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextQuantidadeProduto = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextTotal = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRAR VENDA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(223, 237, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        try {
            jTextHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jTextHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 90, -1));

        jLabel6.setText("Hora:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        uJComboBoxCliente.setEditable(true);
        uJComboBoxCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                uJComboBoxClienteItemStateChanged(evt);
            }
        });
        uJComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uJComboBoxClienteActionPerformed(evt);
            }
        });
        jPanel1.add(uJComboBoxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        jLabel2.setText("Cliente:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 20));

        jLabel4.setText("Produto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jComboBoxProdutos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboBoxProdutos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxProdutosItemStateChanged(evt);
            }
        });
        jComboBoxProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProdutosActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 260, -1));

        jLabel7.setText("Modelo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jComboModelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboModelo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboModeloItemStateChanged(evt);
            }
        });
        jComboModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboModeloActionPerformed(evt);
            }
        });
        jPanel1.add(jComboModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 260, -1));

        jLabel8.setText("Fabricante:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jComboFabricante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboFabricanteActionPerformed(evt);
            }
        });
        jPanel1.add(jComboFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 260, -1));

        jLabel5.setText("Data da Venda:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 20));
        jPanel1.add(JDataVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 121, -1));

        jLabel12.setText("Valor Unitário:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/stop2.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, -1, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        jButton4.setText("Cadastrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, -1, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/limpar.png"))); // NOI18N
        jButton3.setText("Limpar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        jTableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Modelo", "Fabricante", "Quatidade", "Valor Unit", "Total"
            }
        ));
        jTableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProduto);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 620, 110));

        jTextValorUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextValorUnitKeyTyped(evt);
            }
        });
        jPanel1.add(jTextValorUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 110, -1));

        jLabel10.setText("Quantidade:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 70, 20));

        jTextQuantidadeProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextQuantidadeProdutoKeyTyped(evt);
            }
        });
        jPanel1.add(jTextQuantidadeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 110, -1));

        jButton6.setText("Calcular");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 110, 30));

        jLabel11.setText("Total:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, 20));

        jTextTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTotalKeyTyped(evt);
            }
        });
        jPanel1.add(jTextTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 110, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButton2.setText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        jButton5.setText("Remover");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 370, 100, -1));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas1.gif"))); // NOI18N
        jLabel1.setText("CADASTRAR VENDA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Yu Mincho Light", 0, 11)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img2.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 680, 110));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair? Os dados não serão salvos.", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTableProduto.getRowCount() > 0) {
            OrdemServico oS = new OrdemServico();
            //  Produto p = new Produto();

            oS.setTipo("Vendas");
            int codOrdemS = OrdemServicoDAO.CadOrdemServico(oS);

            //  p.setIdProduto(codProduto);
            // int codProd = ProdutoDAO.CadDetProduto(p);
            Vendas vendas = new Vendas();
            Vendas v = new Vendas();

            vendas.setClienteIdcliente(codCliente);
            vendas.setTabusuarioIdUsuario(Usuario.idUsuario());
            vendas.setIdOrdemServico(codOrdemS);
            vendas.setDataVenda(FormataData(JDataVenda.getDate()));
            vendas.setHora(FuncoesDiversas.ConverterHora(jTextHora.getText()));
            //vendas.setProduto((String) jComboBoxProdutos.getSelectedItem());
            vendas.setTotal(Double.parseDouble(jTextTotal.getText()));

            int codVenda = VendasDAO.CadVenda(vendas);

            for (int j = 0; j < jTableProduto.getRowCount(); j++) {

                v.setIdtabVendas(codVenda);
                v.setQuantidade(Double.parseDouble(jTableProduto.getValueAt(j, 4).toString()));
                v.setIdProduto(Integer.parseInt(jTableProduto.getValueAt(j, 0).toString()));

                //dtServ.setCodDetProduto(Integer.parseInt(jTableProduto.getValueAt(j,0).toString()));
                //dtServ.setQuantidade(Integer.parseInt(jTableProduto.getValueAt(j, 4).toString()));
                VendasDAO.CadDetVenda(v);

            }
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "É necessário inserir um registro na tabela!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBoxProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProdutosActionPerformed
        idProdutoComboBox();
        if (jComboBoxProdutos.getSelectedItem() != null) {
            produto = jComboBoxProdutos.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboBoxProdutosActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
         if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION) == 0) {
         if (jTableProduto.getRowCount() < 1) {
        DefaultTableModel dtm = (DefaultTableModel) jTableProduto.getModel();
        int linha = jTableProduto.getSelectedRow();

        double totalParcial = Double.parseDouble(jTableProduto.getValueAt(linha, 6).toString());

        totalPeca -= totalParcial;

        jTextTotal.setText(String.valueOf(totalPeca));

        if (linha != -1) {
            dtm.removeRow(linha);
        }
       }
      }  
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (VerificaCampos()) {
            TabelaProduto();
        }

        CarregaValorUnit();

//        jTextValorUnit.setText(String.valueOf(total));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboModeloActionPerformed
        idModeloComboBox();
        if (jComboModelo.getSelectedItem() != null) {
            modelo = jComboModelo.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboModeloActionPerformed

    private void jComboFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboFabricanteActionPerformed
        idFabricanteComboBox();
        jTextValorUnit.setText("");
        if (jComboFabricante.getSelectedItem() != null) {
            fabricante = jComboFabricante.getSelectedItem().toString();

            CarregaValorUnit();
        }
    }//GEN-LAST:event_jComboFabricanteActionPerformed

    private void jComboBoxProdutosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxProdutosItemStateChanged
        jComboModelo.removeAllItems();
        jComboFabricante.removeAllItems();
        codProduto = 0;
        codModelo = 0;
        modelo = null;
        codFabricante = 0;
        fabricante = null;
        valorUnit = 0;
        valor = 0;
        idProdutoComboBox();
        populaComboBoxModelo();
        produto = jComboBoxProdutos.getSelectedItem().toString();

    }//GEN-LAST:event_jComboBoxProdutosItemStateChanged

    private void jComboModeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboModeloItemStateChanged
        jComboFabricante.removeAllItems();
        idModeloComboBox();
        populaComboBoxFabricante();
        if (jComboModelo.getSelectedItem() != null) {
            modelo = jComboModelo.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboModeloItemStateChanged

    private void jTextValorUnitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextValorUnitKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextValorUnitKeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      if(jTextQuantidadeProduto.getText().trim().equals("")){
          JOptionPane.showMessageDialog(null, "Preencha a QUANTIDADE!");
            jTextQuantidadeProduto.requestFocus();
            jTextQuantidadeProduto.setBackground(Color.yellow);
        } else {
        double total = totalPeca + Double.parseDouble(jTextQuantidadeProduto.getText());
        jTextTotal.setText(String.valueOf(total));
    }//GEN-LAST:event_jButton6ActionPerformed
}
    private void uJComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uJComboBoxClienteActionPerformed
        codCliente = 0;
        idClienteComboBox();
    }//GEN-LAST:event_uJComboBoxClienteActionPerformed

    private void uJComboBoxClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_uJComboBoxClienteItemStateChanged

    }//GEN-LAST:event_uJComboBoxClienteItemStateChanged

    private void jTextQuantidadeProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextQuantidadeProdutoKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextQuantidadeProdutoKeyTyped

    private void jTextTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTotalKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextTotalKeyTyped

    private void jTableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableProdutoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDataVenda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBoxProdutos;
    private javax.swing.JComboBox jComboFabricante;
    private javax.swing.JComboBox jComboModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduto;
    private javax.swing.JFormattedTextField jTextHora;
    private javax.swing.JTextField jTextQuantidadeProduto;
    private javax.swing.JTextField jTextTotal;
    private javax.swing.JTextField jTextValorUnit;
    private componentes.UJComboBox uJComboBoxCliente;
    // End of variables declaration//GEN-END:variables
}
