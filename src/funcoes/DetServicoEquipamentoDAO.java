package funcoes;


import atributos.DetServicoEquipamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josy
 */
public class DetServicoEquipamentoDAO {
    
    public static void CadDetServEquipamento(DetServicoEquipamento servEqui) {
        
        PreparedStatement stmt;
        
        try {
            
            String sql = ("INSERT INTO tabdetservico_equipamento(tabdetequipamento_idDetEquipamento,tabservico_idservico) VALUES (?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
                  
                stmt.setInt(1, servEqui.getCodDetEquipamento());
                stmt.setInt(2, servEqui.getCodServico());
                
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(DetServicoEquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Setor: ",ex);       
            }
    }
    
    public static void ExcluirDetServEquipamento(int id) {
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("DELETE FROM tabdetservico_equipamento WHERE iddetServico_Equipamento = "+ id + ";");
            stmt = Conexao.getConnection().prepareStatement(sql);            
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir o detalhe servico equipamento: ",ex);    
        }
    }
}
