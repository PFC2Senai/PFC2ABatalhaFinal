package funcoes;

import atributos.DetServicoTipoServ;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josy
 */
public class DetServicoTipoDAO {
    
    public static void CadDetServTipoServ(DetServicoTipoServ servTipo){
        
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
}
