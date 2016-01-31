package funcoes;

import atributos.Endereco;
import atributos.Telefone;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContatosDAO {

    public static int CadContato() {
        int id = 0;
        PreparedStatement stmt;

        try {
            String sql = ("INSERT INTO tabcontato() VALUES();");
            stmt = Conexao.getConnection().prepareStatement(sql);

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }

            stmt.close();

        } catch (SQLException u) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, u);
            throw new RuntimeException("Erro ao excluir o Contato do Cliente: ", u);
        }
        return id;
    }

    public static void CadTel(int id, Telefone tel) {

        PreparedStatement stmt;

        try {
            String sql = ("INSERT INTO tabtel(contato_id, telefone, celular) VALUES(?,?,?)");
            stmt = Conexao.getConnection().prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.setString(2, tel.getTel());
            stmt.setString(3, tel.getCel());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException u) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, u);
            throw new RuntimeException("Erro ao excluir o Contato do Cliente: ", u);
        }
    }

    public static void CadEmail(int id, String email) {

        PreparedStatement stmt;
        try {
            String sql = ("INSERT INTO tabemail(contato_id_contato,email) VALUES(?,?)");
            stmt = Conexao.getConnection().prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.setString(2, email);
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException u) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, u);
            throw new RuntimeException("Erro ao excluir o Contato do Cliente: ", u);
        }
    }

    public static void CadEndereco(Endereco endereco) {

        PreparedStatement stmt;
        try {

            String sql = ("INSERT INTO TABENDERECO(cep,rua,numero,bairro,cidade,estado,pais,cod_contato) "
                    + "VALUES (?,?,?,?,?,?,?,?);");

            stmt = Conexao.getConnection().prepareStatement(sql);

            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getNumero());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getCidade());
            stmt.setString(6, endereco.getEstado());
            stmt.setString(7, endereco.getPais());
            stmt.setInt(8, endereco.getIdContato());
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException u) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, u);
            throw new RuntimeException("Erro ao excluir o Contato do Cliente: ", u);
        }
    }

    public static void ExcluirContato(int codContato, int codPessoaCont) {

        CallableStatement stmt;
        try {
            stmt = Conexao.getConnection().prepareCall("{call ExcluirContatoCliente(?,?)}");

            stmt.setInt(1, codContato);
            stmt.setInt(2, codPessoaCont);

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do contato: ", ex);
        }
    }

    public static void ExcluirContatoFornecedor(int codContato, int codPessoaCont) {

        CallableStatement stmt;
        try {
            stmt = Conexao.getConnection().prepareCall("{call ExcluirContatoFornecedor(?,?)}");

            stmt.setInt(1, codContato);
            stmt.setInt(2, codPessoaCont);

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir o contato do fornecedor: ", ex);
        }
    }

    public static void ExcluirEmail(int id) {

        PreparedStatement stmt;
        try {
            String sql = ("DELETE FROM  tabEmail WHERE contato_id_contato = ?");
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir o Email do Cliente: ", ex);
        }
    }

    public static void ExcluirEndereco(int id) {

        PreparedStatement stmt;
        try {
            String sql = ("DELETE FROM  tabEndereco WHERE Contato_id_contato = ?");
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir o Endereço do Cliente: ", ex);
        }
    }

    public static void UpdateEndereco(int id, Endereco endereco) {

        CallableStatement stmt;
        try {
            stmt = Conexao.getConnection().prepareCall("{call UpdateEndereco(?,?,?,?,?,?,?,?)}");

            stmt.setInt(1, id);
            stmt.setString(2, endereco.getCep());
            stmt.setString(3, endereco.getRua());
            stmt.setString(4, endereco.getNumero());
            stmt.setString(5, endereco.getBairro());           
            stmt.setString(6, endereco.getCidade());
            stmt.setString(7, endereco.getEstado());
            stmt.setString(8, endereco.getPais());

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao alterar os dados do endereco: ", ex);
        }
    }

    public static ArrayList CarregaEndereco(int id) {

        Statement stmt;
        ArrayList<Endereco> endereco = new ArrayList<Endereco>();

        try {
            String Sql = "SELECT * FROM tabEndereco where cod_contato = '" + id + "';";

            ResultSet rs;
            stmt = Conexao.getConnection().createStatement();
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                Endereco e = new Endereco();
                e.setIdContato(rs.getInt("id_endereco"));
                e.setCep(rs.getString("cep"));
                e.setRua(rs.getString("rua"));
                e.setNumero(rs.getString("numero"));
                e.setBairro(rs.getString("bairro"));
                e.setCidade(rs.getString("cidade"));
                e.setEstado(rs.getString("estado"));
                e.setPais(rs.getString("pais"));
                endereco.add(e);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar endereço: ", ex);
        }
        return endereco;
    }

    public static ArrayList CarregaTelefones(int id) {

        Statement stmt;
        ArrayList<Telefone> telefones = new ArrayList<Telefone>();

        try {
            String Sql = "SELECT * FROM tabtel where Contato_id = " + id + ";";

            ResultSet rs;
            stmt = Conexao.getConnection().createStatement();
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                Telefone tel = new Telefone();

                tel.setTel(rs.getString("telefone"));
                tel.setCel(rs.getString("celular"));
                telefones.add(tel);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar telefones: ", ex);
        }
        return telefones;
    }
    
    public static String CarregaEmail(int id) {

        Statement stmt;
        String email = "";

        try {
            String Sql = "SELECT email FROM tabemail where contato_id_contato = " + id + ";";

            ResultSet rs;
            stmt = Conexao.getConnection().createStatement();
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                email = (rs.getString("email"));
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar telefones: ", ex);
        }
        return email;
    }

//    public static int CodTel(String tel, int codContato) {
//        
//        Statement stmt;
//        int codTel = 0;
//        
//        try {
//            
//            String Sql = "SELECT * FROM tabtel where telefone = '" + tel + "' and "
//                       + " Contato_id = " + codContato + ";";
//            
//            ResultSet rs;            
//            stmt = Conexao.getConnection().createStatement();            
//            rs = stmt.executeQuery(Sql); 
//            
//            while(rs.next()){                
//               codTel = rs.getInt("id_telefone");
//            }
//            
//            rs.close();
//            stmt.close();
//            
//        } catch (SQLException ex) {      
//            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("Erro ao carregar o codigo do telefone: ", ex);    
//        }    
//        return codTel;
//    }
//    
//    public static int CodEmail(String email, int codContato) {
//        
//        Statement stmt;
//        int codTel = 0;
//        
//        try {            
//            String Sql = "SELECT id_email FROM tabemail where email = '" + email + "' and "
//                       + " contato_id_contato = " + codContato + ";";
//            
//            ResultSet rs;            
//            stmt = Conexao.getConnection().createStatement();            
//            rs = stmt.executeQuery(Sql); 
//            
//            while(rs.next()){                
//               codTel = rs.getInt("id_email");
//            }
//            
//            rs.close();
//            stmt.close();
//            
//        } catch (SQLException ex) {      
//            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("Erro ao carregar o codigo do email: ", ex);    
//        }    
//        return codTel;
//    }

    public static ArrayList Telefones(int id) {

        Statement stmt;
        ArrayList<String> telefones = new ArrayList<String>();

        try {
            String Sql = "SELECT * FROM tabtel where Contato_id = " + id + ";";

            ResultSet rs;
            stmt = Conexao.getConnection().createStatement();
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                telefones.add(rs.getString("telefone"));
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar telefones: ", ex);
        }
        return telefones;
    }

    public static ArrayList Celular(int id) {

        Statement stmt;
        ArrayList<String> celular = new ArrayList<String>();

        try {
            String Sql = "SELECT * FROM tabtel where Contato_id = " + id + ";";

            ResultSet rs;
            stmt = Conexao.getConnection().createStatement();
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                celular.add(rs.getString("celular"));
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar telefones: ", ex);
        }
        return celular;
    }

    public static ArrayList Email(int id) {

        Statement stmt;
        ArrayList<String> email = new ArrayList<String>();

        try {
            String Sql = "SELECT * FROM tabemail where contato_id_contato = " + id + ";";

            ResultSet rs;
            stmt = Conexao.getConnection().createStatement();
            rs = stmt.executeQuery(Sql);

            while (rs.next()) {
                email.add(rs.getString("email"));
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar telefones: ", ex);
        }
        return email;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    public static void UpdateTel2(int id, Telefone tel) {

        PreparedStatement stmt;

        try {
            String sql = ("UPDATE tabTel SET telefone='" + tel.getTel()
                    + "' , celular = '" + tel.getCel()
                    + "' where Contato_id = '" + id + "';");

            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar o Tel do cliente: ", ex);
        }
    }

    public static void UpdateEmail2(int id, String email) {

        PreparedStatement stmt;

        try {
            String sql = ("UPDATE tabemail SET email = '" + email
                    + "' WHERE contato_id_contato = " + id + ";");//mesma coisa aqui

            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar o Email do cliente: ", ex);
        }
    }
}
