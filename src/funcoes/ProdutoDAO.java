/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public static void Cadroduto(Produto prod){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabproduto(tabusuario_id_usuario, "
                                            +   " produto, " +
                                                " tabFornecedor_id_forn1, " +
                                                " quant, " +
                                                " precoEntrada, " +
                                                " precoSaida, " +
                                                " tabModelo_idtabModelo, " +
                                                " tabFabricante_idtabFabricante) " +
                                                " VALUES(?,?,?,?,?,?,?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setInt(1, prod.getIdUsuario());
                stmt.setString(2, prod.getProduto());
                stmt.setInt(3, prod.getCodFornecedor());
                stmt.setInt(4, prod.getQuantidade());
                stmt.setDouble(5 , prod.getPrecoEntrada());
                stmt.setDouble(6, prod.getPrecoSaida());
                stmt.setInt(7, prod.getCodModelo());
                stmt.setInt(8, prod.getCodFabricante());
                              
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Produto: ",ex);       
            }
    }
    
    public static ArrayList CarregaProduto(int id) {
        
        Statement stmt;
        ArrayList<Produto> produto = new ArrayList<Produto>();
        
        try {            
            String Sql = "SELECT * FROM tabproduto WHERE id_prod = " + id + ";";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Produto p = new Produto();
                
                p.setIdProduto(rs.getInt("id_prod"));
                p.setIdUsuario(rs.getInt("tabusuario_id_usuario"));
                p.setProduto(rs.getString("produto"));
                p.setIdDetProduto(rs.getInt("id_det_produto"));
                p.setCodFornecedor(rs.getInt("tabFornecedor_id_forn1"));
                p.setQuantidade(rs.getInt("quant"));
                p.setPrecoEntrada(rs.getFloat("precoEntrada"));
                p.setPrecoSaida(rs.getFloat("precoSaida"));
                p.setCodModelo(rs.getInt("tabModelo_idtabModelo"));
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
            stmt = Conexao.getConnection().prepareCall("{call UpdateProduto(?,?,?,?,?,?,?,?)}");
            
            stmt.setInt(1, id);
            stmt.setString(2, prod.getProduto());
            stmt.setInt(3, prod.getCodFornecedor());
            stmt.setInt(4, prod.getQuantidade());
            stmt.setDouble(5 , prod.getPrecoEntrada());
            stmt.setDouble(6, prod.getPrecoSaida());
            stmt.setInt(7, prod.getCodModelo());
            stmt.setInt(8, prod.getCodFabricante());
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Produto: ",ex);    
        }
    }
    
    public static ArrayList<Produto> ListarProdutos(){
        Statement stmt;
        ArrayList<Produto> produto = new ArrayList<Produto>();
        
        try {            
            String Sql = "SELECT * FROM tabproduto;";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Produto p = new Produto();
                
                p.setIdProduto(rs.getInt("id_prod"));
                p.setIdUsuario(rs.getInt("tabusuario_id_usuario"));
                p.setProduto(rs.getString("produto"));
                p.setIdDetProduto(rs.getInt("id_det_produto"));
                p.setCodFornecedor(rs.getInt("tabFornecedor_id_forn1"));
                p.setQuantidade(rs.getInt("quant"));
                p.setPrecoEntrada(rs.getFloat("precoEntrada"));
                p.setPrecoSaida(rs.getFloat("precoSaida"));
                p.setCodModelo(rs.getInt("tabModelo_idtabModelo"));
                p.setCodFabricante(rs.getInt("tabFabricante_idtabFabricante"));
                produto.add(p);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao listar os Produto: ", ex);    
        }    
        return produto;
    } 
    
}
