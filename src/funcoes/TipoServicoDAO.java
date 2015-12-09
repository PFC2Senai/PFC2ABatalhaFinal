package funcoes;

import atributos.TipoServico;
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
public class TipoServicoDAO {
    
    public static int CadTipoServico(TipoServico tServ) {
        
        PreparedStatement stmt;
        
        int id = 0;
        try {   
            String sql = ("INSERT INTO tabtipo_serv(Tipo_serv) VALUES (?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
                  
                stmt.setString(1, tServ.getTipo());
                              
                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(TipoServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar tipo de servico: ",ex);       
            }
        return id;
    }
    
    public static ArrayList CarregaTipoServico(int id) {
        
        Statement stmt;
        ArrayList<TipoServico> tServico = new ArrayList<TipoServico>();
        
        try {            
            String Sql = "SELECT * FROM tabtipo_serv where idtabTipo_serv = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()) {
                TipoServico t = new TipoServico();
                
                t.setIdTipoServico(rs.getInt("idtabTipo_serv"));
                t.setTipo((rs.getString("Tipo_serv")));
                tServico.add(t);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar o tipo de servico: ", ex);    
        }    
        return tServico;
    }
    
   
    public static void ExcluirTipoServico(int id){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("DELETE FROM tabtipo_serv WHERE tabtipo_serv = ?;");
            stmt = Conexao.getConnection().prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir o tipo de servico: ",ex);    
        }
    }
    
    public static void UpdateSetor(TipoServico tServ, int id){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("UPDATE tabtipo_serv SET Tipo_serv = '" + tServ.getTipo()
                        + "' where idtabTipo_serv = '" + id + "';");
            
            stmt = Conexao.getConnection().prepareStatement(sql);                             
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar o setor: ",ex);    
        }
    }
    
    public static ArrayList ListarSetor() {
        
        Statement stmt;
        ArrayList<TipoServico> tServico = new ArrayList<TipoServico>();
        
        try {            
            String Sql = "SELECT * FROM tabtipo_serv;";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()) {
                TipoServico t = new TipoServico();
                
                t.setIdTipoServico(rs.getInt("idtabTipo_serv"));
                t.setTipo((rs.getString("Tipo_serv")));
                tServico.add(t);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar o tipo de servico: ", ex);    
        }    
        return tServico;
    }
}
