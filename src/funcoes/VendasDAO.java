/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import atributos.Vendas;
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
 * @author WilhamJr
 */
public class VendasDAO {
    public static int CadVenda(Vendas venda){
        
        PreparedStatement stmt;
        int id = 0;
        
        try {   
            String sql = ("INSERT INTO tabvendas(cliente_idcliente, tabusuario_id_usuario,"
                    + "dataVenda, hora, tabordemserv_idtabOrdemServ, totalVenda) VALUES(?,?,?,?,?,?)");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setInt(1, venda.getClienteIdcliente());
                stmt.setInt(2, venda.getTabusuarioIdUsuario());
                stmt.setObject(3, venda.getDataVenda());
                stmt.setTime(4, venda.getHora());
                stmt.setInt(5, venda.getIdOrdemServico());
                stmt.setDouble(6, venda.getTotal());
                              
                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Venda: ",ex);       
            }
        return id;
    }
    
    
    public static int CadDetVenda(Vendas venda){
        
        PreparedStatement stmt;
        int id = 0;
        
        try { 
            
            String sql = ("INSERT INTO tabdetvendas(quantidade, tabVendas_idtabVendas,"
                    + "tabdetproduto_idDetProduto) VALUES(?,?,?)");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setDouble(1, venda.getQuantidade());
                stmt.setInt(2, venda.getIdtabVendas());
                stmt.setObject(3, venda.getIdProduto());
                              
                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Venda: ",ex);       
            }
        return id;
    }
    
    
    
    
    public static ArrayList CarregaVendas(int id) {
        
        Statement stmt;
        ArrayList<Vendas> venda = new ArrayList<Vendas>();
        
        try {            
            String Sql = "SELECT * FROM tabvendas where idtabVendas = " + id + ";";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Vendas v = new Vendas();
                
                v.setIdtabVendas(rs.getInt("idtabVendas"));
                v.setClienteIdcliente(rs.getInt("cliente_idcliente"));
                v.setTabusuarioIdUsuario(rs.getInt("tabusuario_id_usuario"));
                v.setDataVenda(rs.getDate("dataVenda"));
                v.setHora(rs.getTime("hora"));
                v.setIdOrdemServico(rs.getInt("tabordemserv_idtabOrdemServ"));
                v.setTotal(rs.getInt("totalVenda"));
                
                venda.add(v);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao exibir os dados do usuario: ", ex);    
        }    
        return venda;
    }
    
    
    
    public static ArrayList CarregaDetVendas(int id) {
        
        Statement stmt;
        ArrayList<Vendas> venda = new ArrayList<Vendas>();
        
        try {            
            String Sql = "SELECT * FROM tabdetvendas where idtabDetVendas = " + id + ";";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Vendas v = new Vendas();
                
                v.setIdDetVendas(rs.getInt("idtabDetVendas"));
                v.setQuantidade(rs.getDouble("quantidade"));
                v.setIdtabVendas(rs.getInt("tabVendas_idtabVendas"));
                v.setIdProduto(rs.getInt("tabdetproduto_idDetProduto"));
                
                venda.add(v);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao exibir os dados do usuario: ", ex);    
        }    
        return venda;
    }
    
    
    
    
    public static int idVenda(int id) {
        
        Statement stmt;
        Vendas v = new Vendas();
        
        try {            
            String Sql = "SELECT  idtabVendas FROM tabvendas WHERE idtabVendas = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){                                
                v.setIdtabVendas(rs.getInt("idtabVendas"));                             
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Usuário: ", ex);    
        }    
        return v.getIdtabVendas();
    }
    
    
    
    
    public static int idDetVenda(int id) {
        
        Statement stmt;
        Vendas v = new Vendas();
        
        try {            
            String Sql = "SELECT  idtabDetVendas FROM tabdetvendas WHERE idtabDetVendas = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){                                
                v.setIdtabVendas(rs.getInt("idtabDetVendas"));                             
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Usuário: ", ex);    
        }    
        return v.getIdtabVendas();
    }
    
    
   /* public static void ExcluirUsuario(int id){
        
        CallableStatement stmt;
        try {   
            stmt = Conexao.getConnection().prepareCall("{call ExcluirUsuario(?)}");
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Usuário: ",ex);    
        }
    }*/
    
    public static void UpdateVenda(Vendas venda, int id){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("UPDATE tabvendas SET cliente_idcliente='" + venda.getClienteIdcliente() +
                                                               "', dataVenda='" + venda.getDataVenda() + 
                                                               "', hora='" + venda.getHora() + 
                                                               "', tabordemserv_idtabOrdemServ='" + venda.getIdOrdemServico() +
                                                               "', tabordemserv_idtabOrdemServ='" + venda.getTotal() +
                                                               "' where idtabVendas = '" + id + "';");
            
            stmt = Conexao.getConnection().prepareStatement(sql);                              
                                         
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar os dados do Venda: ",ex);    
        }
    }
    
    public static ArrayList<Vendas> ListarVenda(){
        Statement stmt;
        ArrayList<Vendas> vendas = new ArrayList<Vendas>();
        
        try {            
            String Sql = "SELECT * FROM tabvendas";
            
            ResultSet rs;
            
            stmt = Conexao.getConnection().createStatement();
            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Vendas v = new Vendas();
                
                v.setIdtabVendas(rs.getInt("idtabVendas"));
                v.setClienteIdcliente(rs.getInt("cliente_idcliente"));
                v.setTabusuarioIdUsuario(rs.getInt("tabusuario_id_usuario"));
                v.setDataVenda(rs.getDate("dataVenda"));
                v.setHora(rs.getTime("hora"));
                v.setIdOrdemServico(rs.getInt("tabordemserv_idtabOrdemServ"));
                v.setTotal(rs.getDouble("totalVenda"));
                vendas.add(v);
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Listar os dados dos Venda: ",ex);
        }
        return vendas;
    } 
}
