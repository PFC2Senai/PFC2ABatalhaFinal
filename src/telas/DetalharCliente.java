package telas;

import atributos.Cliente;
import atributos.Endereco;
import atributos.Lembrete;
import atributos.Setor;
import funcoes.AuditoriaDAO;
import funcoes.CarregaCEP;
import funcoes.ClienteDAO;
import funcoes.Conexao;
import static funcoes.Conexao.getConnection;
import funcoes.ContatosDAO;
import funcoes.DetEquipamentoClienteDAO;
import funcoes.LembreteDAO;
import funcoes.LimitarDigitos;
import funcoes.ModeloTabela;
import funcoes.RotinaContatosDAO;
import funcoes.SetorDAO;
import funcoes.TabelaZebrada;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import static telas.ExibeCliente.GetIndice;

public class DetalharCliente extends javax.swing.JFrame {

    int idContato;
    public static int codLembrete;
    public static int codRotina;
    private int codEquipClie;
    private int codPessoaContato;
    private int codSetor;
    private PreparedStatement pst;
    Statement stmt;
    private final int codCliente;
    private int codContato;
    private DetalharCliente telaDetalCli;
    private ExibeCliente telaExibeCliente;

    public static String cnp;

    /**
     * Creates new form CadastrarCliente
     */
    public DetalharCliente() {
        initComponents();
        this.codCliente = GetIndice();
    }

    public DetalharCliente(ExibeCliente exibeCli) {
        this.telaExibeCliente = exibeCli;
        this.idContato = ClienteDAO.idContato(GetIndice());
        this.codCliente = GetIndice();
        telaDetalCli = this;
        initComponents();
        CarregaCliente();
        carregarComboSegmento();
        TabelaLembrete2(GetIndice());
        TabelaContatos();
        TabelaEquipamentosCli();
        TabelaRotina("select  * from tabrotinacontato where cliente_idcliente = " + codCliente + ";");
        TabelaLembrete2(GetIndice());
        TabelaContatos();
        combobox();
        botoes();

        //txtEmpresa.setDocument(new LimitarDigitos(45));
        //txtSetor.setDocument(new LimitarDigitos(50));
    }

    private void botoes() {

        Color minhaCor = new Color(217, 228, 241);
        this.getContentPane().setBackground(minhaCor);
        //this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);

        jBtnCadastrarRotinaContato.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnCadastrarRotinaContato.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnNovoLembrete.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnNovoLembrete.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnExcluir.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnExcluir.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnExcluirRotina.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnExcluirRotina.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnVerLembrete.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnVerLembrete.setHorizontalTextPosition(SwingConstants.CENTER);
        jBtnVerRotina.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnVerRotina.setHorizontalTextPosition(SwingConstants.CENTER);

        jBtnExcluirEquipCli.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnExcluirEquipCli.setHorizontalTextPosition(SwingConstants.CENTER);

        jBtnAdicionarEquipamento.setVerticalTextPosition(SwingConstants.BOTTOM);
        jBtnAdicionarEquipamento.setHorizontalTextPosition(SwingConstants.CENTER);

    }

    private void combobox() {

        //Combobox clientes
        jComboBoxSetores.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (codSetor == 0) {
                    JOptionPane.showMessageDialog(null, "Esse registro não encontra-se cadastrado na base de dados.");
                    jComboBoxSetores.getEditor().getEditorComponent().requestFocus();
                }
            }
        });
        jComboBoxSetores.setAutocompletar(true);
    }

    private void CarregaCliente() {

        jButtonEditarContato.setEnabled(false);
        OcultaBotoes();
        desabilitarEndereco();
        desabilitarDadosPessoais();

        ArrayList<Endereco> endereco = new ArrayList<Endereco>();
        endereco = ContatosDAO.CarregaEndereco(idContato);

        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente = ClienteDAO.CarregaCliente(codCliente);

        for (Cliente cli : cliente) {
            txtEmpresa.setText(cli.getEmpresa());
            txtCnpj.setText(cli.getCnpj());
            txtSetor.setText(cli.getSetor());
            idContato = cli.getIdContato();
        }

        for (Endereco end : endereco) {
            txtEndRua.setText(end.getRua());
            txtEndBairro.setText(end.getBairro());
            txtEndEstado.setText(end.getEstado());
            txtCep.setText(end.getCep());
            txtEndNum.setText(end.getNumero());
            txtEndCidade.setText(end.getCidade());
            txtEndPais.setText(end.getPais());
        }
    }

    private void OcultaBotoes() {

        jBtbCancelDadosP.setVisible(false);
        jBtbCancelEndereco.setVisible(false);
        jBtnAltDadosP.setVisible(false);
        jBtnAltEndereco.setVisible(false);
        jComboBoxSetores.setVisible(false);
    }

    private void desabilitarDadosPessoais() {
        //desabilita campos dados pessoais
        txtEmpresa.setEditable(false);
        txtCnpj.setEditable(false);
        txtSetor.setEditable(false);
        jComboBoxSetores.setVisible(false);
        // customiza o textfild
        txtEmpresa.setOpaque(false);
        txtEmpresa.setBackground(new Color(0, 0, 0, 0));
        txtEmpresa.setBorder(null);
        txtCnpj.setOpaque(false);
        txtCnpj.setBackground(new Color(0, 0, 0, 0));
        txtCnpj.setBorder(null);
        txtSetor.setOpaque(false);
        txtSetor.setBackground(new Color(0, 0, 0, 0));
        txtSetor.setBorder(null);
        //oculta botoes  
        jBtbCancelDadosP.setVisible(false);
        jBtnAltDadosP.setVisible(false);
    }

    private void EditarDadosPessoais() {
        // customiza o textfild
        txtEmpresa.setOpaque(true);
        txtEmpresa.setBackground(new Color(255, 255, 255));
        txtEmpresa.setBorder(new LineBorder(Color.BLACK));
        txtCnpj.setOpaque(true);
        txtCnpj.setBackground(new Color(255, 255, 255));
        txtCnpj.setBorder(new LineBorder(Color.BLACK));
    }

    private void desabilitarEndereco() {

        txtEndBairro.setOpaque(false);
        txtEndBairro.setBackground(new Color(0, 0, 0, 0));
        txtEndBairro.setBorder(null);
        txtEndBairro.setEditable(false);
        txtCep.setOpaque(false);
        txtCep.setBackground(new Color(0, 0, 0, 0));
        txtCep.setEditable(false);
        txtCep.setBorder(null);
        txtEndCidade.setOpaque(false);
        txtEndCidade.setBackground(new Color(0, 0, 0, 0));
        txtEndCidade.setBorder(null);
        txtEndCidade.setEditable(false);
        txtEndEstado.setOpaque(false);
        txtEndEstado.setBackground(new Color(0, 0, 0, 0));
        txtEndEstado.setBorder(null);
        txtEndEstado.setEditable(false);
        txtEndNum.setOpaque(false);
        txtEndNum.setBackground(new Color(0, 0, 0, 0));
        txtEndNum.setBorder(null);
        txtEndNum.setEditable(false);
        txtEndPais.setOpaque(false);
        txtEndPais.setBackground(new Color(0, 0, 0, 0));
        txtEndPais.setBorder(null);
        txtEndPais.setEditable(false);
        txtEndRua.setOpaque(false);
        txtEndRua.setBackground(new Color(0, 0, 0, 0));
        txtEndRua.setBorder(null);
        txtEndRua.setEditable(false);

        jBtnCarregaCep.setVisible(false);
        jBtbCancelEndereco.setVisible(false);
        jBtnAltEndereco.setVisible(false);
    }

    private void EditarEndereco() {

        txtEndBairro.setOpaque(true);
        txtEndBairro.setBackground(new Color(255, 255, 255));
        txtEndBairro.setBorder(new LineBorder(Color.BLACK));
        txtCep.setOpaque(true);
        txtCep.setBackground(new Color(255, 255, 255));
        txtCep.setBorder(new LineBorder(Color.BLACK));
        txtEndCidade.setOpaque(true);
        txtEndCidade.setBackground(new Color(255, 255, 255));
        txtEndCidade.setBorder(new LineBorder(Color.BLACK));
        txtEndEstado.setOpaque(true);
        txtEndEstado.setBackground(new Color(255, 255, 255));
        txtEndEstado.setBorder(new LineBorder(Color.BLACK));
        txtEndNum.setOpaque(true);
        txtEndNum.setBackground(new Color(255, 255, 255));
        txtEndNum.setBorder(new LineBorder(Color.BLACK));
        txtEndPais.setOpaque(true);
        txtEndPais.setBackground(new Color(255, 255, 255));
        txtEndPais.setBorder(new LineBorder(Color.BLACK));
        txtEndRua.setOpaque(true);
        txtEndRua.setBackground(new Color(255, 255, 255));
        txtEndRua.setBorder(new LineBorder(Color.BLACK));

        jBtbCancelEndereco.setVisible(false);
        jBtnAltEndereco.setVisible(false);
    }

    public void TabelaLembrete2(int idcli) {

        ((DefaultTableModel) jTableLembretes.getModel()).setNumRows(0);
        jTableLembretes.updateUI();

        ArrayList<Lembrete> lembretes = new ArrayList<Lembrete>();
        lembretes = LembreteDAO.ListarLembretes(idcli);

        try {

            DefaultTableModel dtm = (DefaultTableModel) jTableLembretes.getModel();

            for (Lembrete lembrete : lembretes) {
                dtm.addRow(new Object[]{
                    String.valueOf(lembrete.getIdLembrete()),
                    lembrete.getDescricao()});
            }

            TableCellRenderer renderer = new TabelaZebrada();
            jTableLembretes.setDefaultRenderer(Object.class, renderer);
            //oculta coluna jtable

            jTableLembretes.getColumnModel().getColumn(0).setMaxWidth(0);
            jTableLembretes.getColumnModel().getColumn(0).setMinWidth(0);
            jTableLembretes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            jTableLembretes.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        } catch (Exception erro) {
            Logger.getLogger(DetalharCliente.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    public void TabelaContatos() {

        try {
            String Sql = "SELECT * FROM vw_contatos WHERE idcliente = " + codCliente + ";";

            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();
            String[] Colunas = {"CodContato", "Código", "Contato", "Telefone", "Celular", "Email", "Setor"};

            ResultSet rs;
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                dados.add(new Object[]{
                    rs.getObject("id_contato"),
                    rs.getObject("idPessoaContato"),
                    rs.getObject("contato"),
                    rs.getObject("telefone"),
                    rs.getObject("celular"),
                    rs.getObject("email"),
                    rs.getObject("setor")
                });
            }

            for (int i = 0; i < 7; i++) {

                ModeloTabela modelo = new ModeloTabela(dados, Colunas);

                jTableContatos.setModel(modelo);
                TableCellRenderer renderer = new TabelaZebrada();
                jTableContatos.setDefaultRenderer(Object.class, renderer);
                jTableContatos.getColumnModel().getColumn(i).setResizable(false);
                jTableContatos.getTableHeader().setReorderingAllowed(false);

                jTableContatos.getColumnModel().getColumn(0).setMaxWidth(0);
                jTableContatos.getColumnModel().getColumn(0).setMinWidth(0);
                jTableContatos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                jTableContatos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

                jTableContatos.getColumnModel().getColumn(1).setMaxWidth(0);
                jTableContatos.getColumnModel().getColumn(1).setMinWidth(0);
                jTableContatos.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
                jTableContatos.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);

                jTableContatos.getColumnModel().getColumn(2).setPreferredWidth(200);
                jTableContatos.getColumnModel().getColumn(3).setPreferredWidth(90);
                jTableContatos.getColumnModel().getColumn(4).setPreferredWidth(90);
                jTableContatos.getColumnModel().getColumn(5).setPreferredWidth(200);
                jTableContatos.getColumnModel().getColumn(6).setPreferredWidth(200);

                jTableContatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }

            jTableContatos.setAutoscrolls(true);
        } catch (SQLException ex) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception erro) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    public void TabelaEquipamentosCli() {

        try {
            String Sql = "SELECT * FROM vw_equipamentocliente WHERE idcliente = " + codCliente + ";";

            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();
            String[] Colunas = {"CodEquipCli", "Equipamento", "Fabricante", "Modelo"};

            ResultSet rs;
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                dados.add(new Object[]{
                    rs.getObject("iddetclienteequipamento"),
                    rs.getObject("equipamento"),
                    rs.getObject("fabricante"),
                    rs.getObject("modelo")});
            }

            for (int i = 0; i < 4; i++) {
                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableEquipCliente.setModel(modelo);
                TableCellRenderer renderer = new TabelaZebrada();
                jTableEquipCliente.setDefaultRenderer(Object.class, renderer);
                jTableEquipCliente.getColumnModel().getColumn(0).setMaxWidth(0);
                jTableEquipCliente.getColumnModel().getColumn(0).setMinWidth(0);
                jTableEquipCliente.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                jTableEquipCliente.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

                jTableEquipCliente.getColumnModel().getColumn(1).setPreferredWidth(150);
                jTableEquipCliente.getColumnModel().getColumn(2).setPreferredWidth(150);
                jTableEquipCliente.getColumnModel().getColumn(3).setPreferredWidth(150);

                jTableEquipCliente.getColumnModel().getColumn(i).setResizable(false);
                jTableEquipCliente.getTableHeader().setReorderingAllowed(false);
                jTableEquipCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception erro) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    public void TabelaRotina(String Sql) {

        try {

            stmt = getConnection().createStatement();
            ArrayList dados = new ArrayList();
            String[] Colunas = {"Código", "Data", "Hora", "Descrição"};

            ResultSet rs;
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {

                dados.add(new Object[]{
                    rs.getObject("idRotinaContato"),
                    rs.getObject("dataRotina"),
                    rs.getObject("horaRotina"),
                    rs.getObject("descricaoRotina")});
            }

            for (int i = 0; i < 4; i++) {

                ModeloTabela modelo = new ModeloTabela(dados, Colunas);
                jTableListarRotinas.setModel(modelo);
                TableCellRenderer renderer = new TabelaZebrada();
                jTableListarRotinas.setDefaultRenderer(Object.class, renderer);
                jTableListarRotinas.getColumnModel().getColumn(0).setMaxWidth(0);
                jTableListarRotinas.getColumnModel().getColumn(0).setMinWidth(0);
                jTableListarRotinas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                jTableListarRotinas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

                jTableListarRotinas.getColumnModel().getColumn(1).setPreferredWidth(60);
                jTableListarRotinas.getColumnModel().getColumn(2).setPreferredWidth(60);
                jTableListarRotinas.getColumnModel().getColumn(3).setPreferredWidth(300);
                jTableListarRotinas.getColumnModel().getColumn(i).setResizable(false);
                jTableListarRotinas.getTableHeader().setReorderingAllowed(false);
                jTableListarRotinas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExibeCliente.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception erro) {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelDadosCliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        jButtonAr1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jBtbCancelDadosP = new javax.swing.JButton();
        txtSetor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JFormattedTextField();
        jBtnAltDadosP = new javax.swing.JButton();
        jComboBoxSetores = new componentes.UJComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEndPais = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtEndBairro = new javax.swing.JTextField();
        txtEndRua = new javax.swing.JTextField();
        txtEndCidade = new javax.swing.JTextField();
        txtEndEstado = new javax.swing.JTextField();
        txtEndNum = new javax.swing.JTextField();
        txtCep = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonAr3 = new javax.swing.JButton();
        jBtnAltEndereco = new javax.swing.JButton();
        jBtbCancelEndereco = new javax.swing.JButton();
        jBtnCarregaCep = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableContatos = new javax.swing.JTable();
        jButtonEditarContato = new javax.swing.JButton();
        jBtnNovoContato = new javax.swing.JButton();
        jBtnExcluirContato = new javax.swing.JButton();
        jBtnIrParaEquipamento = new javax.swing.JButton();
        jPanelEquipamento = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEquipCliente = new javax.swing.JTable();
        jBtnExcluirEquipCli = new javax.swing.JButton();
        jBtnAdicionarEquipamento = new javax.swing.JButton();
        jBtnIrParaLembrete = new javax.swing.JButton();
        jBtnVoltarParaDadosCli = new javax.swing.JButton();
        jPanelLembrete = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLembretes = new javax.swing.JTable();
        jBtnNovoLembrete = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnVerLembrete = new javax.swing.JButton();
        jBtnVoltarParaEquipamento = new javax.swing.JButton();
        jBtnIrParaRotina = new javax.swing.JButton();
        jPanelRotinaContato = new javax.swing.JPanel();
        jBtnCadastrarRotinaContato = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableListarRotinas = new javax.swing.JTable();
        jBtnExcluirRotina = new javax.swing.JButton();
        jBtnVerRotina = new javax.swing.JButton();
        jBtnVoltarParaLembrete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Cliente");
        setBackground(new java.awt.Color(255, 255, 255));
        setExtendedState(6);
        setName("j"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(223, 237, 253));

        jPanelDadosCliente.setBackground(new java.awt.Color(223, 237, 253));
        jPanelDadosCliente.setName("jFrame"); // NOI18N
        jPanelDadosCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cliente");
        jPanelDadosCliente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 22, -1, -1));

        jPanel2.setBackground(new java.awt.Color(223, 237, 253));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Empresa:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        txtEmpresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmpresaKeyTyped(evt);
            }
        });
        jPanel2.add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 260, -1));

        jButtonAr1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jButtonAr1.setText("Editar");
        jButtonAr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("CNPJ:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        jBtbCancelDadosP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtbCancelDadosP.setText("Cancelar");
        jBtbCancelDadosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelDadosPActionPerformed(evt);
            }
        });
        jPanel2.add(jBtbCancelDadosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, -1, -1));

        txtSetor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtSetor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 260, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Setor:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        try {
            txtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCnpj.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 140, -1));

        jBtnAltDadosP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jBtnAltDadosP.setText("Salvar");
        jBtnAltDadosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltDadosPActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnAltDadosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 94, -1));

        jComboBoxSetores.setEditable(true);
        jComboBoxSetores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSetoresItemStateChanged(evt);
            }
        });
        jComboBoxSetores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSetoresActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxSetores, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 260, 20));

        jPanelDadosCliente.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 840, 110));

        jPanel3.setBackground(new java.awt.Color(223, 237, 253));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N
        jPanel3.setNextFocusableComponent(txtEmpresa);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Bairro:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Estado:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Cep:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, 20));

        txtEndPais.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(txtEndPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 260, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Numero:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, 20));

        txtEndBairro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(txtEndBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 270, -1));

        txtEndRua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(txtEndRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 260, -1));

        txtEndCidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(txtEndCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 260, -1));

        txtEndEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtEndEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEndEstadoKeyTyped(evt);
            }
        });
        jPanel3.add(txtEndEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 50, -1));

        txtEndNum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtEndNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEndNumKeyTyped(evt);
            }
        });
        jPanel3.add(txtEndNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 69, -1));

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCepActionPerformed(evt);
            }
        });
        jPanel3.add(txtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 110, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("País:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Cidade:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Rua:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 20));

        jButtonAr3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jButtonAr3.setText("Editar");
        jButtonAr3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAr3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonAr3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, -1));

        jBtnAltEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jBtnAltEndereco.setText("Salvar");
        jBtnAltEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAltEnderecoActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnAltEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, 94, -1));

        jBtbCancelEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtbCancelEndereco.setText("Cancelar");
        jBtbCancelEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbCancelEnderecoActionPerformed(evt);
            }
        });
        jPanel3.add(jBtbCancelEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, -1, -1));

        jBtnCarregaCep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.gif"))); // NOI18N
        jBtnCarregaCep.setText("Buscar");
        jBtnCarregaCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCarregaCepActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnCarregaCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        jPanelDadosCliente.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 840, 130));

        jPanel4.setBackground(new java.awt.Color(223, 237, 253));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contatos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jTableContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodContato", "codPessoa", "Contato", "Telefone", "Celular", "Email", "Setor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContatos.getTableHeader().setReorderingAllowed(false);
        jTableContatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContatosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableContatos);

        jButtonEditarContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page_edit.png"))); // NOI18N
        jButtonEditarContato.setText("Editar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableContatos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButtonEditarContato, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButtonEditarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarContatoActionPerformed(evt);
            }
        });

        jBtnNovoContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page_add.png"))); // NOI18N
        jBtnNovoContato.setText("Novo");
        jBtnNovoContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoContatoActionPerformed(evt);
            }
        });

        jBtnExcluirContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page_delete.png"))); // NOI18N
        jBtnExcluirContato.setText("Remover");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableContatos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnExcluirContato, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnExcluirContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirContatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnExcluirContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnNovoContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEditarContato, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonEditarContato)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnNovoContato)
                        .addGap(21, 21, 21)
                        .addComponent(jBtnExcluirContato))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanelDadosCliente.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 840, 190));

        jBtnIrParaEquipamento.setText("Próximo");
        jBtnIrParaEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIrParaEquipamentoActionPerformed(evt);
            }
        });
        jPanelDadosCliente.add(jBtnIrParaEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, -1, -1));

        jTabbedPane1.addTab("Dados do Cliente", new javax.swing.ImageIcon(getClass().getResource("/imagens/cliente3.png")), jPanelDadosCliente); // NOI18N

        jPanelEquipamento.setBackground(new java.awt.Color(223, 237, 253));

        jPanel8.setBackground(new java.awt.Color(223, 237, 253));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Equipamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jTableEquipCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableEquipCliente.getTableHeader().setReorderingAllowed(false);
        jTableEquipCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEquipClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableEquipCliente);

        jBtnExcluirEquipCli.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnExcluirEquipCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/maquina07remove.fw.png"))); // NOI18N
        jBtnExcluirEquipCli.setText("Excluir Equipamento");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableEquipCliente, org.jdesktop.beansbinding.ELProperty.create("${selectedElement  != null}"), jBtnExcluirEquipCli, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnExcluirEquipCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirEquipCliActionPerformed(evt);
            }
        });

        jBtnAdicionarEquipamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnAdicionarEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/maquinaAdiciona.fw.png"))); // NOI18N
        jBtnAdicionarEquipamento.setText("Equipamento");
        jBtnAdicionarEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionarEquipamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAdicionarEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExcluirEquipCli, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jBtnAdicionarEquipamento)
                        .addGap(45, 45, 45)
                        .addComponent(jBtnExcluirEquipCli)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jBtnIrParaLembrete.setText("Próximo");
        jBtnIrParaLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIrParaLembreteActionPerformed(evt);
            }
        });

        jBtnVoltarParaDadosCli.setText("Voltar");
        jBtnVoltarParaDadosCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarParaDadosCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEquipamentoLayout = new javax.swing.GroupLayout(jPanelEquipamento);
        jPanelEquipamento.setLayout(jPanelEquipamentoLayout);
        jPanelEquipamentoLayout.setHorizontalGroup(
            jPanelEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEquipamentoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEquipamentoLayout.createSequentialGroup()
                        .addComponent(jBtnVoltarParaDadosCli)
                        .addGap(579, 579, 579)
                        .addComponent(jBtnIrParaLembrete))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelEquipamentoLayout.setVerticalGroup(
            jPanelEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEquipamentoLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnIrParaLembrete)
                    .addComponent(jBtnVoltarParaDadosCli))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Equipamentos do Cliente", new javax.swing.ImageIcon(getClass().getResource("/imagens/maquina02.png")), jPanelEquipamento); // NOI18N

        jPanelLembrete.setBackground(new java.awt.Color(223, 237, 253));

        jPanel10.setBackground(new java.awt.Color(223, 237, 253));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lembretes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jTableLembretes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLembretes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableLembretes.getTableHeader().setReorderingAllowed(false);
        jTableLembretes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLembretesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLembretes);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtnNovoLembrete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnNovoLembrete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CadastrarLembrete.png"))); // NOI18N
        jBtnNovoLembrete.setText("Novo Lembrete");
        jBtnNovoLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoLembreteActionPerformed(evt);
            }
        });

        jBtnExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluiLemb.fw.png"))); // NOI18N
        jBtnExcluir.setText("Excluir Lembrete");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableLembretes, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnExcluir, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnVerLembrete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnVerLembrete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/verLembrete.fw.png"))); // NOI18N
        jBtnVerLembrete.setText("Ver Lembrete");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableLembretes, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnVerLembrete, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnVerLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVerLembreteActionPerformed(evt);
            }
        });

        jBtnVoltarParaEquipamento.setText("Voltar");
        jBtnVoltarParaEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarParaEquipamentoActionPerformed(evt);
            }
        });

        jBtnIrParaRotina.setText("Próximo");
        jBtnIrParaRotina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIrParaRotinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLembreteLayout = new javax.swing.GroupLayout(jPanelLembrete);
        jPanelLembrete.setLayout(jPanelLembreteLayout);
        jPanelLembreteLayout.setHorizontalGroup(
            jPanelLembreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLembreteLayout.createSequentialGroup()
                .addGroup(jPanelLembreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLembreteLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLembreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnVerLembrete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnNovoLembrete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelLembreteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnVoltarParaEquipamento)
                        .addGap(581, 581, 581)
                        .addComponent(jBtnIrParaRotina)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLembreteLayout.setVerticalGroup(
            jPanelLembreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLembreteLayout.createSequentialGroup()
                .addGroup(jPanelLembreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLembreteLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jBtnNovoLembrete)
                        .addGap(45, 45, 45)
                        .addComponent(jBtnVerLembrete)
                        .addGap(45, 45, 45)
                        .addComponent(jBtnExcluir)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLembreteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanelLembreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnVoltarParaEquipamento)
                    .addComponent(jBtnIrParaRotina))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lembrete", new javax.swing.ImageIcon(getClass().getResource("/imagens/lembrete1.png")), jPanelLembrete); // NOI18N

        jPanelRotinaContato.setBackground(new java.awt.Color(223, 237, 253));

        jBtnCadastrarRotinaContato.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnCadastrarRotinaContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1452414361_kontact_1.png"))); // NOI18N
        jBtnCadastrarRotinaContato.setText("Rotina de Conatato");
        jBtnCadastrarRotinaContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarRotinaContatoActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(223, 237, 253));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rotina de Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N

        jTableListarRotinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableListarRotinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListarRotinasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableListarRotinas);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jBtnExcluirRotina.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnExcluirRotina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluirRotina.fw.png"))); // NOI18N
        jBtnExcluirRotina.setText("Excluir Rotina");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarRotinas, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnExcluirRotina, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnExcluirRotina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirRotinaActionPerformed(evt);
            }
        });

        jBtnVerRotina.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnVerRotina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/verRotina.fw.png"))); // NOI18N
        jBtnVerRotina.setText("Ver Rotina");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableListarRotinas, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jBtnVerRotina, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jBtnVerRotina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVerRotinaActionPerformed(evt);
            }
        });

        jBtnVoltarParaLembrete.setText("Voltar");
        jBtnVoltarParaLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarParaLembreteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRotinaContatoLayout = new javax.swing.GroupLayout(jPanelRotinaContato);
        jPanelRotinaContato.setLayout(jPanelRotinaContatoLayout);
        jPanelRotinaContatoLayout.setHorizontalGroup(
            jPanelRotinaContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRotinaContatoLayout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addGroup(jPanelRotinaContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRotinaContatoLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelRotinaContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtnExcluirRotina, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnVerRotina, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnCadastrarRotinaContato, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelRotinaContatoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jBtnVoltarParaLembrete)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
        );
        jPanelRotinaContatoLayout.setVerticalGroup(
            jPanelRotinaContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRotinaContatoLayout.createSequentialGroup()
                .addGroup(jPanelRotinaContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRotinaContatoLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jBtnCadastrarRotinaContato)
                        .addGap(45, 45, 45)
                        .addComponent(jBtnVerRotina)
                        .addGap(45, 45, 45)
                        .addComponent(jBtnExcluirRotina))
                    .addGroup(jPanelRotinaContatoLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnVoltarParaLembrete)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Rotina de Contato", new javax.swing.ImageIcon(getClass().getResource("/imagens/rotinacont.png")), jPanelRotinaContato); // NOI18N

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 840, 540));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leiaute/img3.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 860, 140));

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarContatoActionPerformed
        if (jTableContatos.getSelectedRow() != -1) {
            int linha = jTableContatos.getSelectedRow();
            codContato = (Integer.parseInt(jTableContatos.getValueAt(linha, 0).toString()));
            codPessoaContato = Integer.parseInt(jTableContatos.getValueAt(linha, 1).toString());
            this.setEnabled(false);
            new AlterarContato(this, codCliente, codPessoaContato, codContato).setVisible(true);
        }
    }//GEN-LAST:event_jButtonEditarContatoActionPerformed

    private void jBtnNovoLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoLembreteActionPerformed
        this.setEnabled(false);
        new CadastrarLembrete(GetIndice(), this).setVisible(true);
    }//GEN-LAST:event_jBtnNovoLembreteActionPerformed

    private void jBtbCancelEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbCancelEnderecoActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Cancelar alteração?", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 1) {

        } else {
            jButtonAr3.setVisible(true);
            jBtbCancelEndereco.setVisible(false);
            jBtnAltEndereco.setVisible(false);
            jBtnCarregaCep.setVisible(false);
            CarregaCliente();
            desabilitarEndereco();
        }
    }//GEN-LAST:event_jBtbCancelEnderecoActionPerformed

    private void jBtnAltEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltEnderecoActionPerformed
        if (VerificaCamposEndereco() == true) {
            Endereco endereco = new Endereco();

            endereco.setPais(txtEndPais.getText());
            endereco.setCep(txtCep.getText());
            endereco.setRua(txtEndRua.getText());
            endereco.setNumero(txtEndNum.getText());
            endereco.setBairro(txtEndBairro.getText());
            endereco.setCidade(txtEndCidade.getText());
            endereco.setEstado(txtEndEstado.getText());
            endereco.setIdContato(idContato);

            ContatosDAO.UpdateEndereco(idContato, endereco);
            jButtonAr3.setVisible(true);
            jBtbCancelEndereco.setVisible(false);
            jBtnAltEndereco.setVisible(false);
            jBtnCarregaCep.setVisible(false);
            desabilitarEndereco();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            String descricaoAudit = "Empresa " + txtEmpresa.getText() + " /CNPJ: " + txtCnpj.getText() + "teve o endereço alterado.";
            AuditoriaDAO.CadDetAuditoria(descricaoAudit);
        }
    }//GEN-LAST:event_jBtnAltEnderecoActionPerformed

    private void jBtbCancelDadosPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbCancelDadosPActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Cancelar alteração?", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION) == 1) {

        } else {
            CarregaCliente();
            desabilitarDadosPessoais();
            txtSetor.setVisible(true);
            jBtnAltDadosP.setVisible(false);
            jBtbCancelDadosP.setVisible(false);
            jButtonAr1.setVisible(true);
        }
    }//GEN-LAST:event_jBtbCancelDadosPActionPerformed

    private void jBtnAltDadosPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAltDadosPActionPerformed

        if (VerificaCamposEmpresa() == true) {

//            if (txtCnpj.getText() == cnp) {
//                JOptionPane.showMessageDialog(null, "Este CNPJ ja está cadastrado !");
//            }
            if (ClienteDAO.VerificarCliente(txtCnpj.getText()) == false) {

                Cliente cli = new Cliente();
                cli.setEmpresa(txtEmpresa.getText());
                cli.setCnpj(txtCnpj.getText());
                cli.setCodSetor(codSetor);
                cli.setIdContato(idContato);
                ClienteDAO.UpdateCliente(cli, GetIndice());
                desabilitarDadosPessoais();
                txtSetor.setVisible(true);
                jBtnAltDadosP.setVisible(false);
                jBtbCancelDadosP.setVisible(false);
                jButtonAr1.setVisible(true);
                CarregaCliente();
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
                String descricaoAudit = "Empresa " + cli.getEmpresa() + " /CNPJ: " + cli.getCnpj() + "teve os dados alterados.";
                AuditoriaDAO.CadDetAuditoria(descricaoAudit);
                
            } 
            else if (txtCnpj.getText() == null ? cnp == null : txtCnpj.getText().equals(cnp)) {
                
                Cliente cli = new Cliente();
                cli.setEmpresa(txtEmpresa.getText());
                cli.setCnpj(txtCnpj.getText());
                cli.setCodSetor(codSetor);
                cli.setIdContato(idContato);
                ClienteDAO.UpdateCliente(cli, GetIndice());
                desabilitarDadosPessoais();
                txtSetor.setVisible(true);
                jBtnAltDadosP.setVisible(false);
                jBtbCancelDadosP.setVisible(false);
                jButtonAr1.setVisible(true);
                CarregaCliente();
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
                String descricaoAudit = "Empresa " + cli.getEmpresa() + " /CNPJ: " + cli.getCnpj() + "teve os dados alterados.";
                AuditoriaDAO.CadDetAuditoria(descricaoAudit);

            } else {
                JOptionPane.showMessageDialog(null, "Este CNPJ ja está cadastrado !");

            }

        }

    }//GEN-LAST:event_jBtnAltDadosPActionPerformed

    private void jTableLembretesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLembretesMouseClicked
        int linha = jTableLembretes.getSelectedRow();
        codLembrete = (Integer.parseInt(jTableLembretes.getValueAt(linha, 0).toString()));
    }//GEN-LAST:event_jTableLembretesMouseClicked

    private void jButtonAr3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAr3ActionPerformed

        EditarEndereco();
        txtEndBairro.setEditable(true);
        txtCep.setEditable(true);
        txtEndCidade.setEditable(true);
        txtEndEstado.setEditable(true);
        txtEndNum.setEditable(true);
        txtEndPais.setEditable(true);
        txtEndRua.setEditable(true);

        jButtonAr3.setVisible(false);
        jBtnAltEndereco.setVisible(true);
        jBtbCancelEndereco.setVisible(true);
        jBtnCarregaCep.setVisible(true);
    }//GEN-LAST:event_jButtonAr3ActionPerformed

    private void jButtonAr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAr1ActionPerformed
        EditarDadosPessoais();
        txtEmpresa.setEditable(true);
        txtCnpj.setEditable(true);
        txtSetor.setVisible(false);
        jComboBoxSetores.setVisible(true);

        jButtonAr1.setVisible(false);
        jBtbCancelDadosP.setVisible(true);
        jBtnAltDadosP.setVisible(true);

        jComboBoxSetores.setSelectedItem(txtSetor.getText());
        cnp = txtCnpj.getText();

    }//GEN-LAST:event_jButtonAr1ActionPerformed

    private void jTableContatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContatosMouseClicked

    }//GEN-LAST:event_jTableContatosMouseClicked

    private void jBtnCarregaCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCarregaCepActionPerformed
        if (txtCep.getText().trim().equals("-")) {
            JOptionPane.showMessageDialog(null, "Primeiro preencha o campo CEP!");
        } else {
            BuscarEndereco();
        }
    }//GEN-LAST:event_jBtnCarregaCepActionPerformed

    private void jBtnAdicionarEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionarEquipamentoActionPerformed
        this.setEnabled(false);
        new CadastrarEquipCliente(codCliente, this).setVisible(true);
    }//GEN-LAST:event_jBtnAdicionarEquipamentoActionPerformed

    private void jBtnCadastrarRotinaContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastrarRotinaContatoActionPerformed
        this.setEnabled(false);
        new CadastrarRotinaContato(GetIndice(), this).setVisible(true);
    }//GEN-LAST:event_jBtnCadastrarRotinaContatoActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION) == 1) {

        } else {
            LembreteDAO.ExcluirLembrete(codLembrete);
            TabelaLembrete2(codCliente);
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnExcluirRotinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirRotinaActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION) == 1) {
        } else {
            RotinaContatosDAO.ExcluirRotina(codRotina);
            TabelaRotina("select  * from tabrotinacontato where cliente_idcliente = " + codCliente + ";");
        }
    }//GEN-LAST:event_jBtnExcluirRotinaActionPerformed

    private void jBtnVerLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVerLembreteActionPerformed
        this.setEnabled(false);
        new DetalharLembrete(this).setVisible(true);
    }//GEN-LAST:event_jBtnVerLembreteActionPerformed

    private void jTableListarRotinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListarRotinasMouseClicked
        int linha = jTableListarRotinas.getSelectedRow();
        codRotina = (Integer.parseInt(jTableListarRotinas.getValueAt(linha, 0).toString()));
    }//GEN-LAST:event_jTableListarRotinasMouseClicked

    private void jBtnVerRotinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVerRotinaActionPerformed
        this.setEnabled(false);
        new DetalharRotina(this).setVisible(true);
    }//GEN-LAST:event_jBtnVerRotinaActionPerformed

    private void txtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCepActionPerformed
        BuscarEndereco();
    }//GEN-LAST:event_txtCepActionPerformed

    private void jBtnExcluirEquipCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirEquipCliActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION) == 1) {

        } else {
            DetEquipamentoClienteDAO.ExcluirEquipCliente(codEquipClie);
            TabelaEquipamentosCli();
        }

    }//GEN-LAST:event_jBtnExcluirEquipCliActionPerformed

    private void jTableEquipClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEquipClienteMouseClicked
        int linha = jTableEquipCliente.getSelectedRow();
        codEquipClie = (Integer.parseInt(jTableEquipCliente.getValueAt(linha, 0).toString()));
    }//GEN-LAST:event_jTableEquipClienteMouseClicked

    private void jBtnNovoContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoContatoActionPerformed
        this.setEnabled(false);
        new AdicionarContato(this, codCliente).setVisible(true);
    }//GEN-LAST:event_jBtnNovoContatoActionPerformed

    private void jBtnExcluirContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirContatoActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION) == 1) {

        } else if (jTableContatos.getSelectedRow() != -1) {
            int linha = jTableContatos.getSelectedRow();
            codContato = (Integer.parseInt(jTableContatos.getValueAt(linha, 0).toString()));
            codPessoaContato = Integer.parseInt(jTableContatos.getValueAt(linha, 1).toString());
            ContatosDAO.ExcluirContato(codContato, codPessoaContato);
            TabelaContatos();
        }

    }//GEN-LAST:event_jBtnExcluirContatoActionPerformed

    private void jComboBoxSetoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSetoresItemStateChanged

    }//GEN-LAST:event_jComboBoxSetoresItemStateChanged

    private void jComboBoxSetoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSetoresActionPerformed
        idSetorComboBox();
    }//GEN-LAST:event_jComboBoxSetoresActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        verificaPagina();
    }//GEN-LAST:event_formWindowClosed

    private void jBtnIrParaEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIrParaEquipamentoActionPerformed
        jTabbedPane1.setSelectedComponent(this.jPanelEquipamento);
    }//GEN-LAST:event_jBtnIrParaEquipamentoActionPerformed

    private void jBtnIrParaLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIrParaLembreteActionPerformed
        jTabbedPane1.setSelectedComponent(this.jPanelLembrete);
    }//GEN-LAST:event_jBtnIrParaLembreteActionPerformed

    private void jBtnVoltarParaDadosCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarParaDadosCliActionPerformed
        jTabbedPane1.setSelectedComponent(this.jPanelDadosCliente);
    }//GEN-LAST:event_jBtnVoltarParaDadosCliActionPerformed

    private void jBtnVoltarParaLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarParaLembreteActionPerformed
        jTabbedPane1.setSelectedComponent(this.jPanelLembrete);
    }//GEN-LAST:event_jBtnVoltarParaLembreteActionPerformed

    private void jBtnVoltarParaEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarParaEquipamentoActionPerformed
        jTabbedPane1.setSelectedComponent(this.jPanelEquipamento);
    }//GEN-LAST:event_jBtnVoltarParaEquipamentoActionPerformed

    private void jBtnIrParaRotinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIrParaRotinaActionPerformed
        jTabbedPane1.setSelectedComponent(this.jPanelRotinaContato);
    }//GEN-LAST:event_jBtnIrParaRotinaActionPerformed

    private void txtEndNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEndNumKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321snSN";
        String car = txtEndNum.getText().toUpperCase();
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEndNumKeyTyped

    private void txtEndEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEndEstadoKeyTyped
        // TODO add your handling code here:

        String caracteres = "0987654321";

        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEndEstadoKeyTyped

    private void txtEmpresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaKeyTyped
        // TODO add your handling code here:

        String carac = "ç,.!?@:;/^~´`#$%¨&*()-_='+{[]}";
        if (carac.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEmpresaKeyTyped

    private void carregarComboSegmento() {

        ArrayList<Setor> setores = new ArrayList<Setor>();
        setores = SetorDAO.ListarSetor();

        jComboBoxSetores.addItem("Selecione o segmento");
        for (Setor setor : setores) {
            jComboBoxSetores.addItem(setor.getSetor(), setor);
        }
    }

    private void idSetorComboBox() {

        Connection conexao = Conexao.getConnection();
        ResultSet rs;
        String sql = "select * from tabSetor where setor = '" + jComboBoxSetores.getSelectedItem() + "';";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codSetor = (rs.getInt("idtabSetor"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static int GetIdLembrete() {
        return codLembrete;
    }

    public static int GetIdRotina() {
        return codRotina;
    }

    public void BuscarEndereco() {
        TelaEspera telaTeste = new TelaEspera();
        this.setEnabled(false);
        final Thread t1 = new Thread(new Runnable() {//cria uma thread pra gravar o seu arquivo

            @Override
            public void run() {

                try {

                    telaTeste.setVisible(true);
                    CarregaCEP cep = new CarregaCEP();

                    String ceptxt = txtCep.getText();
                    txtEndCidade.setText(cep.getCidade(ceptxt));
                    txtEndBairro.setText(cep.getBairro(ceptxt));
                    txtEndRua.setText(cep.getEndereco(ceptxt));
                    txtEndEstado.setText(cep.getUF(ceptxt));

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        t1.start();
        new Thread(new Runnable() {//cria outra thread pra sua tela de espera
            @Override
            public void run() {
                try {
                    //cria a tela de espera e mostra ela
                    t1.join();//fica esperando a primeira thread acabar
                    telaDetalCli.setEnabled(true);  // quando acabar fecha a janela de espera, podes fazer outras coisas aqui
                    telaTeste.dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    private boolean VerificaCamposEmpresa() {

        boolean valida = true;

        if (txtEmpresa.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (jComboBoxSetores.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtCnpj.getText().trim().length() != 18) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }
        return valida;
    }

    private boolean VerificaCamposEndereco() {

        boolean valida = true;

        if (txtEndPais.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtEndCidade.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtEndRua.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtCep.getText().trim().equals("-")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtEndEstado.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtEndBairro.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }

        if (txtEndNum.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!");
            valida = false;
            return valida;
        }
        return valida;
    }

    private void verificaPagina() {

        if ((this.telaExibeCliente != null)) {
            this.telaExibeCliente.setVisible(true);
            //   this.telaExibeCliente.toFront();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbCancelDadosP;
    private javax.swing.JButton jBtbCancelEndereco;
    private javax.swing.JButton jBtnAdicionarEquipamento;
    private javax.swing.JButton jBtnAltDadosP;
    private javax.swing.JButton jBtnAltEndereco;
    private javax.swing.JButton jBtnCadastrarRotinaContato;
    private javax.swing.JButton jBtnCarregaCep;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnExcluirContato;
    private javax.swing.JButton jBtnExcluirEquipCli;
    private javax.swing.JButton jBtnExcluirRotina;
    private javax.swing.JButton jBtnIrParaEquipamento;
    private javax.swing.JButton jBtnIrParaLembrete;
    private javax.swing.JButton jBtnIrParaRotina;
    private javax.swing.JButton jBtnNovoContato;
    private javax.swing.JButton jBtnNovoLembrete;
    private javax.swing.JButton jBtnVerLembrete;
    private javax.swing.JButton jBtnVerRotina;
    private javax.swing.JButton jBtnVoltarParaDadosCli;
    private javax.swing.JButton jBtnVoltarParaEquipamento;
    private javax.swing.JButton jBtnVoltarParaLembrete;
    private javax.swing.JButton jButtonAr1;
    private javax.swing.JButton jButtonAr3;
    private javax.swing.JButton jButtonEditarContato;
    private componentes.UJComboBox jComboBoxSetores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelDadosCliente;
    private javax.swing.JPanel jPanelEquipamento;
    private javax.swing.JPanel jPanelLembrete;
    private javax.swing.JPanel jPanelRotinaContato;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableContatos;
    private javax.swing.JTable jTableEquipCliente;
    private javax.swing.JTable jTableLembretes;
    private javax.swing.JTable jTableListarRotinas;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JFormattedTextField txtCnpj;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEndBairro;
    private javax.swing.JTextField txtEndCidade;
    private javax.swing.JTextField txtEndEstado;
    private javax.swing.JTextField txtEndNum;
    private javax.swing.JTextField txtEndPais;
    private javax.swing.JTextField txtEndRua;
    private javax.swing.JTextField txtSetor;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
