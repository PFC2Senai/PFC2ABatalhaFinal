package funcoes;

import atributos.DetServicoFuncionario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josy
 */
public class DetServicoFuncionarioDAO {
    
    public static void CadDetServFuncionario(DetServicoFuncionario servFunc){
        
        PreparedStatement stmt;
        
        try {
            
            String sql = ("INSERT INTO tabdetservico_funcionario(tabfuncionario_idfuncionario,tabservico_idservico) VALUES (?,?);");
            
            stmt = Conexao.getConnection().prepareStatement(sql);      
                  
            stmt.setInt(1, servFunc.getCodFuncionario());
            stmt.setInt(2, servFunc.getCodServico());
                
            stmt.executeUpdate();
            stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(DetServicoFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Setor: ",ex);       
            }
    }
}
