package funcoes;

import atributos.DetServicoFuncionario;
import atributos.Funcionario;
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
    
    public static ArrayList CarregaDetServFuncionario(int id) {
        
        Statement stmt;
        ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();
        
        try {
            
            String Sql = "SELECT * FROM vw_detservfuncionario where idservico = " + id + ";";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()) {
                
                Funcionario f = new Funcionario();
                
                f.setId(rs.getInt("idDetServico_funcionario"));
                f.setFuncionario((rs.getString("funcionario")));
                f.setCpf(rs.getString("cpf"));
                f.setCargo(rs.getString("cargo"));
                funcionario.add(f);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Cliente: ", ex);    
        }    
        return funcionario;
    }
}
