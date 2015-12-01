package funcoes;

import atributos.Equipamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EquipamentoDAO {
    
    public static void CadEquipamento(Equipamento equi){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabequipamento(tabUsuario_id_usuario, equipamento) VALUES(?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setInt(1, 1);
                stmt.setString(2, equi.getEquipamento());
                              
                stmt.executeUpdate();
                stmt.close();  

        } catch (SQLException ex) {      
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Cadastrar equipamento: ",ex);       
        }
    }
    
    
    public static ArrayList CarregaEquipamento(int id) {
        
        Statement stmt;
        ArrayList<Equipamento> equipamento = new ArrayList<Equipamento>();
        
        try {            
            String Sql = "SELECT * FROM tabequipamento "
                       + "WHERE idEquipamento = '" + id + "';";
                       
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                
                Equipamento e = new Equipamento();
                
                e.setIdEquipamento(rs.getInt("idEquipamento"));
                e.setEquipamento((rs.getString("equipamento")));                
                equipamento.add(e);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Carregar os dados do equipamento: ",ex);   
        }    
        return equipamento;
    }        
    
    public static void ExcluirEquipamento(int id){
        
        PreparedStatement stmt;
        try {
            
            String sql = ("DELETE FROM tabequipamento WHERE idEquipamento = ?; ");
            
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir o equipamento: ",ex);    
        }
    }
    
    public static void UpdateEquipamento(Equipamento equi, int id) {
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("UPDATE tabequipamento SET equipamento = '" + equi.getEquipamento() +
                                                "' WHERE idEquipamento = " + id + ";");
            
            stmt = Conexao.getConnection().prepareStatement(sql);                             
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao alterar o equipamento: ",ex);     
        }
    }
    
    public static ArrayList<Equipamento> ListarEquipamentos(){
        
        Statement stmt;
        ArrayList<Equipamento> equipamento = new ArrayList<Equipamento>();
        
        try {            
            String Sql = "SELECT * FROM tabequipamento;";
                       
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                
                Equipamento e = new Equipamento();
                
                e.setIdEquipamento(rs.getInt("idEquipamento"));
                e.setEquipamento((rs.getString("equipamento")));                
                equipamento.add(e);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao listar os dados do equipamento: ",ex);   
        }    
        return equipamento;                    
    }  
}
