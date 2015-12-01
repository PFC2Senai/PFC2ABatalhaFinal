package funcoes;


import atributos.Fornecedor;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FornecedorDAO {
    
    public static void CadFornecedor(Fornecedor fornecedor){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabfornecedor(tabusuario_id_usuario, tabContato_id_contato,fornecedor) VALUES(?,?,?)");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setInt(1, 1);
                stmt.setInt(2, fornecedor.getCodContato());
                stmt.setString(3, fornecedor.getFornecedor());
                              
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Fornecedor: ",ex);       
            }
    }
    
    public static ArrayList CarregaFornecedor(int id) {
        
        Statement stmt;
        ArrayList<Fornecedor> fornecedor = new ArrayList<Fornecedor>();
        
        try {            
            String Sql = "SELECT * FROM tabfornecedor AS forn\n" +
                        "INNER JOIN tabtel AS tel\n" +
                        "INNER JOIN tabemail AS email\n" +
                        "inner join tabendereco AS ende\n" +
                        "INNER JOIN tabcontato AS cont\n" +
                        "ON cont.id_contato = forn.tabContato_id_contato AND\n" +
                        "cont.id_contato = tel.contato_id AND\n" +
                        "id_contato = email.contato_id_contato AND\n" +
                        "cont.id_contato = cod_contato AND ende.cod_contato=cont.id_contato "
                      + "where forn.id_forn = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Fornecedor f = new Fornecedor();
                
                f.setIdForn(rs.getInt("id_forn"));
                f.setFornecedor((rs.getString("fornecedor")));
                f.setCodContato(rs.getInt("tabContato_id_contato"));
                f.setEmail(rs.getString("email"));
                fornecedor.add(f);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar os dados do fornecedor: ", ex);    
        }    
        return fornecedor;
    }
    
    public static int idContato(int id) {
        
        Statement stmt;
        Fornecedor f = new Fornecedor();
        
        try {            
            String Sql = "SELECT  tabContato_id_contato FROM tabfornecedor WHERE id_forn = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){                                
                f.setCodContato(rs.getInt("tabContato_id_contato"));                             
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);    
        }    
        return f.getCodContato();
    }
    
    public static void ExcluirFornecedor(int id) {
        
        CallableStatement stmt;
        
        try {   
            stmt = Conexao.getConnection().prepareCall("{call ExcluirFornecedor(?)}");
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do fornecedor: ",ex);    
        }
    }
    
    public static void UpdateFornecedor(Fornecedor forn, int id){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("UPDATE tabfornecedor SET fornecedor='" + forn.getFornecedor()
                        + "' where id_forn = '" + id + "';");
            
            stmt = Conexao.getConnection().prepareStatement(sql);                             
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar os dados do fornecedor: ",ex);    
        }
    }
    
    public static ArrayList<Fornecedor> ListarFornecedor(){
        
        Statement stmt;
        ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        
        try {            
            String Sql = "SELECT * FROM tabfornecedor;";

            ResultSet rs;
            
            stmt = Conexao.getConnection().createStatement();
            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Fornecedor f = new Fornecedor();
                
                f.setIdForn(rs.getInt("id_forn"));
                f.setFornecedor((rs.getString("fornecedor")));              
                fornecedores.add(f);                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Listar os dados do Clientes: ",ex);
        }
        return fornecedores;
    }
}
