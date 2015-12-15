package funcoes;

import atributos.DetServicoTipoServ;
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
public class DetServicoTipoDAO {
    
    public static void CadDetServTipoServ(DetServicoTipoServ servTipo) {
        
        PreparedStatement stmt;
        
        try {
            
            String sql = ("INSERT INTO tabdetservico_tiposerv(tabtipo_serv_idtabTipo_serv,tabservico_idservico) VALUES (?,?);");
            
            stmt = Conexao.getConnection().prepareStatement(sql);      
                  
            stmt.setInt(1, servTipo.getCodTipo());
            stmt.setInt(2, servTipo.getCodServico());
                
            stmt.executeUpdate();
            stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(DetServicoTipoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Setor: ",ex);       
            }
    }
    
    public static ArrayList CarregaDetServicoTipoServico(int id) {
        
        Statement stmt;
        ArrayList<TipoServico> tServico = new ArrayList<TipoServico>();
        
        try {            
            String Sql = "SELECT * FROM vw_detservtiposervico WHERE idservico = " + id + ";";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()) {
                TipoServico t = new TipoServico();
                
                t.setIdTipoServico(rs.getInt("iddetServico_TipoServ"));
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
    
    public static void ExcluirDetServTipoServico(int id) {
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("DELETE FROM tabdetservico_tiposerv WHERE iddetServico_TipoServ = "+ id + ";");
            stmt = Conexao.getConnection().prepareStatement(sql);            
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir o detalhe servico equipamento: ",ex);    
        }
    }
}
