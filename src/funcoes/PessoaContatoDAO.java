package funcoes;

import atributos.PessoaContato;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josy
 */
public class PessoaContatoDAO {

    public static void CadPessoaContato(PessoaContato pContato) {

        PreparedStatement stmt;
        try {
            String sql = ("INSERT INTO tabpessoacontato(contato, tabcliente_idcliente, cod_contato,setor) VALUES(?,?,?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);

            stmt.setString(1, pContato.getNomeContato());
            stmt.setInt(2, pContato.getCodTabEstrangeira());
            stmt.setInt(3, pContato.getCodContato());
            stmt.setString(4, pContato.getSetorContato());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(PessoaContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Cadastrar a pessoa contato: ", ex);
        }
    }

    public static void CadPesContatoFornecedor(PessoaContato pContato) {

        PreparedStatement stmt;
        try {
            String sql = ("INSERT INTO tabpessoacontatofornecedor(contato, tabfornecedor_id_forn, tabContato_id_contato) VALUES(?,?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);

            stmt.setString(1, pContato.getNomeContato());
            stmt.setInt(2, pContato.getCodTabEstrangeira());
            stmt.setInt(3, pContato.getCodContato());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(PessoaContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Cadastrar a pessoa contato: ", ex);
        }
    }

    public static void ExcluirPessoaContato(int id) {

        PreparedStatement stmt;

        try {
            String sql = ("DELETE FROM tabpessoacontato WHERE idPessoaContato = ?;");
            stmt = Conexao.getConnection().prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(PessoaContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir a pessoa contato: ", ex);
        }
    }

    public static void UpdatePessoaContato(PessoaContato pContato, int id) {

        PreparedStatement stmt;

        try {
            String sql = ("UPDATE tabpessoacontato SET contato = '" + pContato.getNomeContato()
                    + "', setor = '" + pContato.getSetorContato()
                    + "' WHERE idPessoaContato = " + id + ";");

            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(PessoaContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar a pessoa contato: ", ex);
        }
    }

    public static void UpdatePessoaContFornecedor(PessoaContato pContato, int id) {

        PreparedStatement stmt;

        try {
            String sql = ("UPDATE tabpessoacontatofornecedor SET contato = '" + pContato.getNomeContato()
                    + "' WHERE idPessoaContatoFornecedor = " + id + ";");

            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(PessoaContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar a pessoa contato fornecedor: ", ex);
        }
    }

//    public static ArrayList ListarContatos(int id) {
//
//        Statement stmt;
//        ArrayList<PessoaContato> pessoaContato = new ArrayList<PessoaContato>();
//
//        try {
//            String Sql = "SELECT * FROM tabpessoacontato where tabcliente_idcliente = " + id + " ;";
//
//            ResultSet rs;
//            stmt = Conexao.getConnection().createStatement();
//            rs = stmt.executeQuery(Sql);
//
//            while (rs.next()) {
//
//                PessoaContato p = new PessoaContato();
//
//                p.setIdPessoaContato(rs.getInt("idPessoaContato"));
//                p.setNomeContato((rs.getString("contato")));
//                p.setCodTabEstrangeira(rs.getInt("tabcliente_idcliente"));
//                p.setCodContato(rs.getInt("cod_contato"));
//                pessoaContato.add(p);
//            }
//            rs.close();
//            stmt.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PessoaContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("Erro ao listar as pessoa contato: ", ex);
//        }
//        return pessoaContato;
//    }

//    public static ArrayList Contatos(int id) {
//
//        Statement stmt;
//
//        ArrayList<PessoaContato> pessoaContato = new ArrayList<PessoaContato>();
//
//        try {
//            String Sql = "SELECT * FROM tabpessoacontato where tabcliente_idcliente = " + id + " ;";
//
//            ResultSet rs;
//            stmt = Conexao.getConnection().createStatement();
//            rs = stmt.executeQuery(Sql);
//
//            while (rs.next()) {
//                PessoaContato p = new PessoaContato();
//
//                p.setIdPessoaContato(rs.getInt("idPessoaContato"));
//                p.setNomeContato(rs.getString("contato"));
//                pessoaContato.add(p);
//            }
//            rs.close();
//            stmt.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PessoaContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("Erro ao listar contato: ", ex);
//        }
//        return pessoaContato;
//    }
}
