package funcoes;

import atributos.DetServicoProduto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josy
 */
public class DetServicoProdutoDAO {
    
    public static void CadDetServProduto(DetServicoProduto servProduto){
        
        PreparedStatement stmt;
        
        try {
            
            String sql = ("INSERT INTO tabdetservico_produto(tabdetproduto_idDetProduto,quantidadeComprada,tabservico_idservico) VALUES (?,?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
                  
                stmt.setInt(1, servProduto.getCodDetProduto());
                stmt.setInt(2, servProduto.getQuantidade());
                stmt.setInt(3, servProduto.getCodServico());
                
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(DetServicoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Setor: ",ex);       
            }
    }
    
    public static void ExcluirDetServProduto(int id) {
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("DELETE FROM tabdetservico_produto WHERE iddetServico_produto = "+ id + ";");
            stmt = Conexao.getConnection().prepareStatement(sql);            
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir o detalhe servico produto: ",ex);    
        }
    }
    
}
