package funcoes;

import atributos.Produto;
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
 * @author graciele
 */
public class ProdutoDAO {
    
    public static int Cadroduto(Produto prod){
        
        int id = 0;
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabproduto(tabusuario_id_usuario, "
                                            +   " produto) " +                                                
                                                " VALUES(?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setInt(1, prod.getIdUsuario());
                stmt.setString(2, prod.getProduto());
                              
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                    if (rs.next()) {
                        id = rs.getInt(1);
                    } 
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Produto: ",ex);       
            }
        return id;
    }
    
    public static int CadDetProduto(Produto prod){
        
        PreparedStatement stmt;
        int id = 0;
        try {   
            String sql = ("INSERT INTO tabdetproduto(tabproduto_id_prod, " +
                                                " quantidade, " +
                                                " precoEntrada, " +
                                                " precoSaida, " +
                                                " quantidadeMinima, " +
                                                " tabModelo_idtabModelo, " +
                                                " dataCadastro, " +
                                                " tabFabricante_idtabFabricante) " +
                                                " VALUES(?,?,?,?,?,?,?,?);");
            
            stmt = Conexao.getConnection().prepareStatement(sql);      
                  
                stmt.setInt(1, prod.getCodProduto());
                stmt.setInt(2, prod.getQuantidade());
                stmt.setDouble(3 , prod.getPrecoEntrada());
                stmt.setDouble(4, prod.getPrecoSaida());
                stmt.setInt(5, prod.getQuantidadeMinima());
                stmt.setInt(6, prod.getCodModelo());
                stmt.setObject(7, prod.getDataCadProduto());
                stmt.setInt(8, prod.getCodFabricante());
                              
                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                    if (rs.next()) {
                        id = rs.getInt(1);
                    } 
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar detalhe do Produto: ",ex);       
            }
        return id;
    }
    
    public static ArrayList CarregaProduto(int id) {
        
        Statement stmt;
        ArrayList<Produto> produto = new ArrayList<Produto>();
        
        try {            
            String Sql = "SELECT * FROM tabproduto "
                      + " INNER JOIN tabdetproduto ON "
                      + " tabproduto_id_prod = id_prod "
                      + " WHERE id_prod = " + id + ";";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Produto p = new Produto();
                
                p.setIdProduto(rs.getInt("id_prod"));
                p.setIdUsuario(rs.getInt("tabusuario_id_usuario"));
                p.setProduto(rs.getString("produto"));
                p.setCodProduto(rs.getInt("tabproduto_id_prod"));
                p.setIdDetProduto(rs.getInt("idDetProduto"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setPrecoEntrada(rs.getDouble("precoEntrada"));
                p.setPrecoSaida(rs.getDouble("precoSaida"));
                p.setQuantidadeMinima(rs.getInt("quantidadeMinima"));
                p.setCodModelo(rs.getInt("tabModelo_idtabModelo"));
                p.setDataCadProduto(rs.getDate("dataCadastro"));
                p.setCodFabricante(rs.getInt("tabFabricante_idtabFabricante"));
                p.setIdProduto(id);
                produto.add(p);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar os dados do Produto: ", ex);    
        }    
        return produto;
    }
     
     public static int idProduto(int id) {
        
        Statement stmt;
        Produto p = new Produto();
        
        try {            
            String Sql = "SELECT  id_prod FROM tabproduto WHERE id_prod = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){                                
                p.setIdProduto(rs.getInt("id_prod"));                             
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao pegar id do Produto: ", ex);    
        }    
        return p.getIdProduto();
    }
     
    public static void ExcluirProduto(int id){
        
        CallableStatement stmt;
        try {   
            stmt = Conexao.getConnection().prepareCall("{call ExcluirProduto(?)}");
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Produto: ",ex);    
        }
    }
    
    public static void UpdateProduto(Produto prod, int id){
                
        CallableStatement stmt;
        
        try {   
            stmt = Conexao.getConnection().prepareCall("{call UpdateProduto(?,?,?,?,?,?,?)}");
            
            stmt.setInt(1, id);
            stmt.setString(2, prod.getProduto());
            stmt.setInt(3, prod.getQuantidade());
            stmt.setDouble(4 , prod.getPrecoEntrada());
            stmt.setDouble(5, prod.getPrecoSaida());
            stmt.setInt(6, prod.getCodModelo());
            stmt.setInt(7, prod.getCodFabricante());
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Produto: ",ex);    
        }
    }
    
    public static void AlterarEstoque(Produto prod, int id) {
                
        CallableStatement stmt;
        
        try {   
            stmt = Conexao.getConnection().prepareCall("{call AdicionaEstoque(?,?,?,?,?)}");
            
            stmt.setInt(1, id);
            stmt.setInt(2, prod.getQuantidade());
            stmt.setDouble(3 , prod.getPrecoEntrada());
            stmt.setDouble(4, prod.getPrecoSaida());
            stmt.setObject(5, prod.getDataCadProduto());
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao adicionar produto no estoque: ",ex);    
        }
    }
    
    public static void BaixaEstoque(int quant, int id) {
                
        PreparedStatement stmt;

        try {
            String sql = ("UPDATE tabdetproduto SET quantidade = '" + quant
                        + "' where idDetProduto = '" + id + "';"); 

            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao dar baixa no estoque: ", ex);
        }
    }
    
    public static ArrayList<Produto> ListarProdutos(){
        Statement stmt;
        ArrayList<Produto> produto = new ArrayList<Produto>();
        
        try {            
            String Sql = "SELECT * FROM tabproduto "
                      + " INNER JOIN tabdetproduto ON "
                      + " tabproduto_id_prod = id_prod; ";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Produto p = new Produto();
                
                p.setIdProduto(rs.getInt("id_prod"));
                p.setIdUsuario(rs.getInt("tabusuario_id_usuario"));
                p.setProduto(rs.getString("produto"));
                p.setCodProduto(rs.getInt("tabproduto_id_prod"));
                p.setIdDetProduto(rs.getInt("idDetProduto"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setPrecoEntrada(rs.getDouble("precoEntrada"));
                p.setPrecoSaida(rs.getDouble("precoSaida"));
                p.setQuantidadeMinima(rs.getInt("quantidadeMinima"));
                p.setCodModelo(rs.getInt("tabModelo_idtabModelo"));
                p.setCodFabricante(rs.getInt("tabFabricante_idtabFabricante"));
                produto.add(p);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar os dados do Produto: ", ex);    
        }    
        return produto;
    }    
}
