/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import atributos.Produto;
import java.sql.CallableStatement;
import java.sql.Connection;
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
            String sql = ("INSERT INTO tabproduto(tabusuario_id_usuario, produto) VALUES(?,?)");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setInt(1, prod.getIdUsuario());
                stmt.setString(2, prod.getProduto());
                              
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
            String Sql = "SELECT * FROM tabproduto where id_prod = " + id + ";";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Produto p = new Produto();
                
                p.setIdProduto(rs.getInt("id_prod"));
                p.setIdUsuario(rs.getInt("tabusuario_id_usuario"));
                p.setProduto(rs.getString("produto"));
                p.setIdProduto(id);
                produto.add(p);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Produto: ", ex);    
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
            throw new RuntimeException("Erro ao excluir os dados do Produto: ", ex);    
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
    
    public static void UpdateModelo(Produto prod, int id){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("UPDATE tabproduto SET tabusuario_id_usuario='" + prod.getIdUsuario()+
                    "', produto='" + prod.getProduto() + 
                    "' where id_prod = '" + id + "';");
            stmt = Conexao.getConnection().prepareStatement(sql);
                              
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar os dados do Produto: ",ex);    
        }
    }
    
    public static ArrayList<Produto> ListarUsuario(){
        Statement stmt;
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        
        try {            
            String Sql = "SELECT * FROM tabproduto";
            
            ResultSet rs;
            
            stmt = Conexao.getConnection().createStatement();
            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Produto p = new Produto();
                
                p.setIdProduto(rs.getInt("id_prod"));
                p.setIdUsuario(rs.getInt("tabusuario_id_usuario"));
                p.setProduto(rs.getString("produto"));
                produtos.add(p);
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Listar os dados dos Produtos: ",ex);
        }
        return produtos;
    } 
    
    public ResultSet SelecionarProduto(String produto){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try{
            cn = (Connection) Conexao.getConnection().createStatement();
            pst = cn.prepareStatement("SELECT  * FROM tabproduto WHERE produto = ?");
            pst.setString(1, produto);
            rs = pst.executeQuery();            
        }catch (Exception ex){
            
        }
        return rs;
    }
    
}
