/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import atributos.Modelo;
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
public class ModeloDAO {
    public static void CadModelo(Modelo model){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabmodelo(modelo) VALUES(?)");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setString(1, model.getModelo());
                              
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Modelo: ",ex);       
            }
    }
    
     public static ArrayList CarregaModelo(int id) {
        
        Statement stmt;
        ArrayList<Modelo> modelo = new ArrayList<Modelo>();
        
        try {            
            String Sql = "SELECT * FROM tabmodelo where idtabModelo = " + id + ";";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Modelo m = new Modelo();
                
                m.setIdModelo(rs.getInt("idtabModelo"));
                m.setModelo(rs.getString("modelo"));
                m.setIdModelo(id);
                modelo.add(m);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Modelo: ", ex);    
        }    
        return modelo;
    }
     
     public static int idModelo(int id) {
        
        Statement stmt;
        Modelo m = new Modelo();
        
        try {            
            String Sql = "SELECT  idtabModelo FROM tabmodelo WHERE idtabModelo = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){                                
                m.setIdModelo(rs.getInt("idtabModelo"));                             
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Modelo: ", ex);    
        }    
        return m.getIdModelo();
    }
     
     public static void ExcluirModelo(int id){
        
        CallableStatement stmt;
        try {   
            stmt = Conexao.getConnection().prepareCall("{call ExcluirModelo(?)}");
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Modelo: ",ex);    
        }
    }
    
    public static void UpdateModelo(Modelo model, int id){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("UPDATE tabmodelo SET modelo='" + model.getModelo()+
                    "' where idtabModelo = '" + id + "';");
            stmt = Conexao.getConnection().prepareStatement(sql);
                              
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar os dados do Modelo: ",ex);    
        }
    }
    
    public static ArrayList<Modelo> ListarUsuario(){
        Statement stmt;
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        
        try {            
            String Sql = "SELECT * FROM tabusuario";
            
            ResultSet rs;
            
            stmt = Conexao.getConnection().createStatement();
            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Modelo m = new Modelo();
                
                m.setIdModelo(rs.getInt("idtabModelo"));
                m.setModelo(rs.getString("modelo"));
                modelos.add(m);
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Listar os dados dos Modelos: ",ex);
        }
        return modelos;
    } 
    
    
}
