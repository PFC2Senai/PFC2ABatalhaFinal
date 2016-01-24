package funcoes;

import atributos.DetEquipamentoCliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josy
 */
public class DetEquipamentoClienteDAO {
    
    public static void CadEquipCliente(DetEquipamentoCliente detEqCli){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabdetclienteequipamento(codDetequipamento,tabcliente_idcliente) VALUES (?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
                  
                stmt.setInt(1, detEqCli.getCodEquipamento());
                stmt.setInt(2, detEqCli.getCodCliente());
                              
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Equipamento no cliente: ",ex);       
            }
    }
    
    public static void ExcluirEquipCliente(int id) { //se tiver mais de um lembrete ver
        
        PreparedStatement stmt;
        try {
            
            String sql = ("DELETE FROM tabdetclienteequipamento WHERE iddetclienteequipamento = ?; ");
            
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(LembreteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir o equipamento do cliente ",ex);    
        }
    }
}
