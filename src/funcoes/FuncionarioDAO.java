package funcoes;

import atributos.Funcionario;
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
 * @author WilhamJr
 */
public class FuncionarioDAO {

    public static void CadFuncionario(Funcionario func) {

        PreparedStatement stmt;
        try {
            String sql = ("INSERT INTO tabfuncionario(funcionario, rg, cpf, cargo, salario, tabContato_id_contato, tabUsuario_id_Usuario, data_admissao, ctps, serie, numeroCtps, uf) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt = Conexao.getConnection().prepareStatement(sql);

            stmt.setString(1, func.getFuncionario());
            stmt.setString(2, func.getRg());
            stmt.setString(3, func.getCpf());
            stmt.setString(4, func.getCargo());
            stmt.setDouble(5, func.getSalario());
            stmt.setInt(6, func.getIdContato());
            stmt.setInt(7, func.getIdUsuario());
            stmt.setObject(8, func.getDataAdmicao());
            stmt.setString(9, func.getCtps());
            stmt.setString(10, func.getSerieCtps());
            stmt.setString(11, func.getNumCtps());
            stmt.setString(12, func.getUfCtps());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Cadastrar Cliente: ", ex);
        }
    }

    public static int idContato(int id) {

        Statement stmt;
        Funcionario f = new Funcionario();

        try {
            String Sql = "SELECT tabContato_id_contato FROM tabfuncionario WHERE idfuncionario = '" + id + "';";

            ResultSet rs;
            stmt = Conexao.getConnection().createStatement();
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                f.setIdContato(rs.getInt("tabContato_id_contato"));
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Cliente: ", ex);
        }
        return f.getIdContato();
    }

    public static ArrayList CarregaFuncionario(int id) {

        Statement stmt;
        ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();

        try {
            String Sql = "SELECT * FROM tabfuncionario where idfuncionario = " + id + ";";

            ResultSet rs;
            stmt = Conexao.getConnection().createStatement();
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                Funcionario f = new Funcionario();

                f.setId(rs.getInt("idfuncionario"));
                f.setFuncionario((rs.getString("funcionario")));
                f.setRg(rs.getString("rg"));
                f.setCpf(rs.getString("cpf"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getDouble("salario"));
                f.setIdContato(rs.getInt("tabContato_id_contato"));
                f.setIdUsuario(rs.getInt("tabUsuario_id_usuario"));
                f.setDataAdmicao(rs.getDate("data_admissao"));
                f.setCtps(rs.getString("ctps"));
                f.setSerieCtps(rs.getString("serie"));
                f.setNumCtps(rs.getString("numeroCtps"));
                f.setUfCtps(rs.getString("uf"));
                f.setId(id);
                funcionario.add(f);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do funcionario: ", ex);
        }
        return funcionario;
    }

    public static void ExcluirFuncionario(int id) {

        CallableStatement stmt;
        try {
            stmt = Conexao.getConnection().prepareCall("{call ExcluirFuncionario(?)}");

            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Funcionario: ", ex);
        }
    }

    public static void UpdateFuncionario(Funcionario func, int id) {

        CallableStatement stmt;
        
        try {
            stmt = Conexao.getConnection().prepareCall("{call UpdateFuncionario(?,?,?,?,?,?,?)}");

            stmt.setInt(1, id);
            stmt.setString(2, func.getFuncionario());
            stmt.setObject(3, func.getDataAdmicao());
            stmt.setString(4, func.getCargo());
            stmt.setString(5, func.getCpf());
            stmt.setString(6, func.getRg());
            stmt.setDouble(7, func.getSalario());

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar os dados do Fucionario: ", ex);
        }
    }

    public static void UpdateCarteiraFuncionario(Funcionario func, int id) {

        PreparedStatement stmt;

        try {
            String sql = ("UPDATE tabfuncionario SET ctps = '" + func.getCtps()
                    + "', serie = '" + func.getSerieCtps()
                    + "', numeroCtps = '" + func.getNumCtps()
                    + "', uf= '" + func.getUfCtps()
                    + "' where idfuncionario = '" + id + "';");
            
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.executeUpdate();
            
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar os dados do Fucionario: ", ex);
        }
    }

    public static ArrayList<Funcionario> ListarFuncionario() {

        Statement stmt;
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        try {
            String Sql = "SELECT funcionario FROM tabfuncionario";

            ResultSet rs;

            stmt = Conexao.getConnection().createStatement();

            rs = stmt.executeQuery(Sql);

            while (rs.next()) {

                Funcionario f = new Funcionario();
                f.setFuncionario(rs.getString("funcionario"));

                funcionarios.add(f);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Listar os dados do Funcionario: ", ex);
        }
        return funcionarios;
    }

    public static boolean VerificarFuncionario(String funcionario) {

        Statement stmt;
        boolean achou = true;
        int fu = 0;

        String Sql = "SELECT COUNT(0), rg, cpf  FROM tabfuncionario WHERE cpf = '" + funcionario + "';";

        try {

            ResultSet rs;
            stmt = Conexao.getConnection().createStatement();
            rs = stmt.executeQuery(Sql);

            rs.first();
            do {
                fu = rs.getInt("COUNT(0)");
            } while (rs.next());

            if (fu == 0) {
                achou = false;
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {

            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Carregar os dados do funcionario: ", ex);
        }
        return achou;
    }
}
