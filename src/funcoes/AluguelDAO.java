package funcoes;

import atributos.Aluguel;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josy
 */
public class AluguelDAO {

    public static int CadAluguel(Aluguel al) {

        PreparedStatement stmt;
        int id = 0;
        try {

            String sql = ("INSERT INTO tablocacao(tabusuario_id_usuario, "
                    + " tabcliente_idcliente, "
                    + " DescricaoLocacao, "
                    + " dataLocacao, "
                    + " horaLocacao, "
                    + " dataDevolucao, "
                    + " tabordemserv_idtabOrdemServ) "
                    + " VALUES (?,?,?,?,?,?,?);");

            stmt = Conexao.getConnection().prepareStatement(sql);

            stmt.setInt(1, al.getTabusuarioIdUsuario());
            stmt.setInt(2, al.getTabclienteIdcliente());
            stmt.setString(3, al.getDescricaotLocacao());
            stmt.setObject(4, al.getDataAluguel());
            stmt.setTime(5, al.getHora());
            stmt.setObject(6, al.getDataDevolucao());
            stmt.setInt(7, al.getCodOrdemServico());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                
                id = rs.getInt(1);
            }

            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Cadastrar aluguel: ", ex);
        }
        return id;
    }

    public static void CadDetAluguel(Aluguel detAluguel) {

        PreparedStatement stmt;

        try {
            String sql = (" INSERT INTO tabdetlocacao( valorLocacao,"
                    + " tabdetequipamento_idDetEquipamento, "
                    + " tabLocacao_idtabDetLocacao,"
                    + " quantEquipamento) "
                    + " VALUES (?,?,?,?);");

            stmt = Conexao.getConnection().prepareStatement(sql);

            stmt.setDouble(1, detAluguel.getValorLocacao());
            stmt.setInt(2, detAluguel.getCodDetEquipamento());
            stmt.setInt(3, detAluguel.getCodAluguel());
            stmt.setInt(4, detAluguel.getQuatidadeEqui());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Cadastrar Detalhe do aluguel: ", ex);
        }
    }

    public static ArrayList CarregaAluguel(int id) {

        Statement stmt;
        ArrayList<Aluguel> aluguel = new ArrayList<Aluguel>();

        try {
            String Sql = "SELECT * FROM tablocacao INNER JOIN tabdetlocacao "
                    + "ON idtabDetLocacao = tabLocacao_idtabDetLocacao "
                    + "WHERE idtabDetLocacao = '" + id + "';";

            ResultSet rs;
            stmt = Conexao.getConnection().createStatement();
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {

                Aluguel a = new Aluguel();

                a.setCodAluguel(rs.getInt("idtabDetLocacao"));
                a.setTabusuarioIdUsuario(rs.getInt("tabusuario_id_usuario"));
                a.setTabclienteIdcliente(rs.getInt("tabcliente_idcliente"));
                a.setDescricaotLocacao(rs.getString("tabDetLocacaocol"));
                a.setIdDetAluguel(rs.getInt("idLocacao"));
                a.setDataAluguel((rs.getDate("dataLocacao")));
                a.setHora(rs.getTime("hora"));
                a.setValorLocacao(rs.getFloat("valorHora"));
                a.setDataDevolucao(rs.getDate("dataDevolucao"));
                a.setCodAluguel(rs.getInt("tabLocacao_idtabDetLocacao"));
                a.setCodDetEquipamento(rs.getInt("tabEquipamento_idEquipamento"));
                a.setCodOrdemServico(rs.getInt("tabordemserv_idtabOrdemServ"));
                aluguel.add(a);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Carregar os dados do aluguel: ", ex);
        }

        return aluguel;
    }

    public static void ExcluirAluguel(int id) {

        CallableStatement stmt;

        try {
            stmt = Conexao.getConnection().prepareCall("{call ExcluirAluguel(?)}");

            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do aluguel: ", ex);
        }
    }

    public static void UpdateAluguel(Aluguel al, int id) {

        CallableStatement stmt;
        try {
            stmt = Conexao.getConnection().prepareCall("{call UpdateAluguel(?,?,?,?,?,?,?,?)}");

            stmt.setInt(1, id);
            stmt.setInt(2, al.getTabclienteIdcliente());
            stmt.setString(3, al.getDescricaotLocacao());
            stmt.setObject(4, al.getDataAluguel());
            stmt.setTime(5, al.getHora());
            stmt.setDouble(6, al.getValorLocacao());
            stmt.setObject(7, al.getDataDevolucao());
            stmt.setInt(8, al.getCodDetEquipamento());

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao alterar os dados do aluguel: ", ex);
        }
    }

    public static ArrayList<Aluguel> ListarAlugueis() {

        Statement stmt;
        ArrayList<Aluguel> aluguel = new ArrayList<Aluguel>();

        try {
            String Sql = "SELECT * FROM tablocacao INNER JOIN tabdetlocacao "
                    + "ON idtabDetLocacao = tabLocacao_idtabDetLocacao;";

            ResultSet rs;
            stmt = Conexao.getConnection().createStatement();
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {

                Aluguel a = new Aluguel();

                a.setCodAluguel(rs.getInt("idtabDetLocacao"));
                a.setTabusuarioIdUsuario(rs.getInt("tabusuario_id_usuario"));
                a.setTabclienteIdcliente(rs.getInt("tabcliente_idcliente"));
                a.setDescricaotLocacao(rs.getString("tabDetLocacaocol"));
                a.setIdDetAluguel(rs.getInt("idLocacao"));
                a.setDataAluguel((rs.getDate("dataLocacao")));
                a.setHora(rs.getTime("hora"));
                a.setValorLocacao(rs.getFloat("valorHora"));
                a.setDataDevolucao(rs.getDate("dataDevolucao"));
                a.setCodAluguel(rs.getInt("tabLocacao_idtabDetLocacao"));
                a.setCodDetEquipamento(rs.getInt("tabEquipamento_idEquipamento"));
                a.setCodOrdemServico(rs.getInt("tabordemserv_idtabOrdemServ"));
                aluguel.add(a);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao listar os dados do aluguel: ", ex);
        }
        return aluguel;
    }
}

