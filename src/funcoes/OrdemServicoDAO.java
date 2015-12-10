package funcoes;

import atributos.OrdemServico;
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
public class OrdemServicoDAO {
    
    public static int CadOrdemServico(OrdemServico os) {
        
        PreparedStatement stmt;
        int id = 0;
        try {   
            String sql = ("INSERT INTO tabordemserv(tipoServico) VALUES (?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
                  
                stmt.setString(1, os.getTipo());
                              
                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(OrdemServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar ordem de servico: ",ex);       
            }
        return id;
    }
        
    public static ArrayList CarregaOrdemServico(int id) {
        
        Statement stmt;
        ArrayList<OrdemServico> ordemServico = new ArrayList<OrdemServico>();
        
        try {            
            String Sql = " SELECT * FROM tabordemserv " +
                         " WHERE idtabOrdemServ = '" + id + "';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                OrdemServico os = new OrdemServico();
                
                os.setIdOrdemServico(rs.getInt("idtabOrdemServ"));
                os.setTipo((rs.getString("tipoServico")));
                ordemServico.add(os);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(AuditoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar a auditoria: ", ex);    
        }    
        return ordemServico;
    }
    
   
    public static void ExcluirOrdemServico(int id){ //ver
        
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
    
    public static ArrayList<OrdemServico> ListarSetor(){
        
        Statement stmt;
        ArrayList<OrdemServico> ordemServico = new ArrayList<OrdemServico>();
        
        try {            
            String Sql = " SELECT * FROM tabordemserv; " ;
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                OrdemServico os = new OrdemServico();
                
                os.setIdOrdemServico(rs.getInt("idtabOrdemServ"));
                os.setTipo((rs.getString("tipoServico")));
                ordemServico.add(os);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(AuditoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar a auditoria: ", ex);    
        }    
        return ordemServico;
    }
}
