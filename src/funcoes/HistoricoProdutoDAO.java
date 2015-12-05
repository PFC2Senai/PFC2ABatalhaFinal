package funcoes;

import atributos.HistoricoProduto;
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
public class HistoricoProdutoDAO {
    
    public static void CadHistoricoProd(HistoricoProduto hProd) {
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabhistoricodeproduto(valor,"
                                                         + " dataCadastro,"
                                                         + " quantidade,"
                                                         + " tabDetProduto_idDetProduto) "
                                                         + " VALUES(?,?,?,?);");
            
            stmt = Conexao.getConnection().prepareStatement(sql);      
                  
                stmt.setDouble(1, hProd.getValor());
                stmt.setObject(2, hProd.getDataCadProduto());
                stmt.setInt(3, hProd.getQuantidade());
                stmt.setInt(5, hProd.getCodDetProduto());
                              
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(HistoricoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar historico do produto: ", ex);       
            }
    }
    
    public static ArrayList CarregaHistProduto(int id) {
        
        Statement stmt;
        ArrayList<HistoricoProduto> historicoProd = new ArrayList<HistoricoProduto>();
        
        try {            
            String Sql = "SELECT * FROM tabhistoricodeproduto WHERE idVariacaoDePreco = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                HistoricoProduto h = new HistoricoProduto();
                
                h.setIdHistProduto(rs.getInt("idVariacaoDePreco"));;
                h.setValor((rs.getDouble("valor")));
                h.setDataCadProduto(rs.getDate("dataCadastro"));
                h.setQuantidade(rs.getInt("quantidade"));
                h.setCodDetProduto(rs.getInt("tabDetProduto_idDetProduto"));
                historicoProd.add(h);                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(HistoricoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar o historico do produto: ", ex);    
        }    
        return historicoProd;
    }
    
   
    public static void ExcluirHistoricoProduto(int id){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("DELETE FROM tabhistoricodeproduto WHERE idVariacaoDePreco = ?;");
            stmt = Conexao.getConnection().prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(HistoricoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir o historico de produto: ",ex);    
        }
    }
    
    public static void UpdateHistProduto(HistoricoProduto hProd, int id){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("UPDATE tabhistoricodeproduto SET valor = " + hProd.getValor() 
                        + ", quantidade = " + hProd.getQuantidade() 
                        + " WHERE idVariacaoDePreco = " + id + ";");
            
            stmt = Conexao.getConnection().prepareStatement(sql);                             
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(HistoricoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar o historico do produto: ",ex);    
        }
    }
    
    public static ArrayList<HistoricoProduto> ListarHistProduto(){
        
        Statement stmt;
        ArrayList<HistoricoProduto> historicoProd = new ArrayList<HistoricoProduto>();
        
        try {            
            String Sql = "SELECT * FROM tabhistoricodeproduto ;";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                HistoricoProduto h = new HistoricoProduto();
                
                h.setIdHistProduto(rs.getInt("idVariacaoDePreco"));;
                h.setValor((rs.getDouble("valor")));
                h.setDataCadProduto(rs.getDate("dataCadastro"));
                h.setQuantidade(rs.getInt("quantidade"));
                h.setCodDetProduto(rs.getInt("tabDetProduto_idDetProduto"));
                historicoProd.add(h);                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(HistoricoProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao listar os historicos do produto: ", ex);    
        }    
        return historicoProd;
    }
}
