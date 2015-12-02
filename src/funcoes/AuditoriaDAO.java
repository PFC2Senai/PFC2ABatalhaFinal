package funcoes;

import atributos.Auditoria;
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
public class AuditoriaDAO {
    
    public static void CadAuditoria(Auditoria audt){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabauditoria(tabusuario_id_usuario) VALUES (?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
                  
                stmt.setInt(1, audt.getCodUsuario());
                              
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(AuditoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar auditoria: ",ex);       
            }
    }
    
    public static void CadDetAuditoria(Auditoria audt){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabdetauditoria(tabAuditoria_idtabAuditoria, descricao) VALUES (?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
                  
                stmt.setInt(1, audt.getCodUsuario());
                stmt.setString(2, audt.getDescricao());
                              
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(AuditoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar detAuditoria: ",ex);       
            }
    }
    
    public static ArrayList CarregaAuditoria(int id) {
        
        Statement stmt;
        ArrayList<Auditoria> auditoria = new ArrayList<Auditoria>();
        
        try {            
            String Sql = "SELECT * FROM tabauditoria " +
                        " INNER JOIN tabdetauditoria" +
                        " ON idtabAuditoria = tabAuditoria_idtabAuditoria " +
                        " WHERE idtabAuditoria = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Auditoria a = new Auditoria();
                
                a.setIdAuditoria(rs.getInt("idtabAuditoria"));
                a.setCodUsuario((rs.getInt("tabusuario_id_usuario")));
                a.setDataAcesso(rs.getDate("dataAcesso"));
                a.setIdDetAuditoria(rs.getInt("idtabDetAuditoria"));
                a.setDataModificacao(rs.getDate("dataModificacao"));
                a.setDescricao(rs.getString("descricao"));
                a.setCodAuditoria(rs.getInt("tabAuditoria_idtabAuditoria"));
                auditoria.add(a);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(AuditoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar a auditoria: ", ex);    
        }    
        return auditoria;
    }
    
   
    public static void ExcluirAuditoria(int id){
        
        CallableStatement stmt;
        try {   
            stmt = Conexao.getConnection().prepareCall("{call ExcluirAuditoria(?)}");
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(AuditoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados da auditoria: ",ex);    
        }
    }
    
    public static ArrayList<Auditoria> ListarSetor(){
        
        Statement stmt;
        ArrayList<Auditoria> auditoria = new ArrayList<Auditoria>();
        
        try {            
            String Sql = "SELECT * FROM tabauditoria " +
                        " INNER JOIN tabdetauditoria" +
                        " ON idtabAuditoria = tabAuditoria_idtabAuditoria;";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Auditoria a = new Auditoria();
                
                a.setIdAuditoria(rs.getInt("idtabAuditoria"));
                a.setCodUsuario((rs.getInt("tabusuario_id_usuario")));
                a.setDataAcesso(rs.getDate("dataAcesso"));
                a.setIdDetAuditoria(rs.getInt("idtabDetAuditoria"));
                a.setDataModificacao(rs.getDate("dataModificacao"));
                a.setDescricao(rs.getString("descricao"));
                a.setCodAuditoria(rs.getInt("tabAuditoria_idtabAuditoria"));
                auditoria.add(a);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(AuditoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar a auditoria: ", ex);    
        }    
        return auditoria;
    }
}
