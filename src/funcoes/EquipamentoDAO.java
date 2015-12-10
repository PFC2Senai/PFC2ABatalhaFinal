package funcoes;

import atributos.Equipamento;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EquipamentoDAO {
    
    public static int CadEquipamento(Equipamento equi){
        
        PreparedStatement stmt;
        int id = 0;
        try {
            
            String sql = ("INSERT INTO tabequipamento(tabUsuario_id_usuario, equipamento) VALUES(?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setInt(1, equi.getTabusuarioIdUsuario());
                stmt.setString(2, equi.getEquipamento());
                              
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                stmt.close();  

        } catch (SQLException ex) {      
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Cadastrar equipamento: ",ex);       
        }
        return id;
    }
    
    public static void CadDetEquipamento(Equipamento equi) {
        
        PreparedStatement stmt;
        
        try {
            
            String sql = ("INSERT INTO tabdetequipamento( tabequipamento_idEquipamento," +
                                                        " tabmodelo_idtabModelo, " +
                                                        " tabfabricante_idtabFabricante," +
                                                        " tabfornecedor_id_forn) " +
                                                        " VALUES(?,?,?,?);");
            
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setInt(1, equi.getCodEquipamento());
                stmt.setInt(2, equi.getCodModelo());
                stmt.setInt(3, equi.getCodFabricante());
                stmt.setInt(4, equi.getCodFornecedor());
                              
                stmt.executeUpdate();
                stmt.close();  

        } catch (SQLException ex) {      
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Cadastrar detalhe equipamento: ",ex);       
        }
    }
       
    public static ArrayList CarregaEquipamento(int id) {
        
        Statement stmt;
        ArrayList<Equipamento> equipamento = new ArrayList<Equipamento>();
        
        try {
            
            String Sql = "SELECT * FROM tabequipamento INNER JOIN tabdetequipamento " +
                         "ON tabequipamento_idEquipamento = idEquipamento "
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
    
    public static void ExcluirEquipamento(int id){ //não vamos mais usar?
        
        CallableStatement stmt;
        try {   
            stmt = Conexao.getConnection().prepareCall("{call ExcluirCliente(?)}");
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do equipamento: ",ex);    
        }
    }
    
    public static void UpdateEquipamento(Equipamento equi) {
        
        CallableStatement stmt;
        try {   
            stmt = Conexao.getConnection().prepareCall("{call UpdateEquipamento(?,?,?,?,?,?)}");
                        
            stmt.setInt(1, equi.getIdDetEquipamento());
            stmt.setInt(2, equi.getIdEquipamento());
            stmt.setString(3, equi.getEquipamento());
            stmt.setInt(4, equi.getCodModelo());
            stmt.setInt(5, equi.getCodFabricante());
            stmt.setInt(6, equi.getCodFornecedor());
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao alterar os dados do equipamento: ",ex);    
        }
    }
    
    public static ArrayList<Equipamento> ListarEquipamentos() { //talvez não precise
        
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
    
    //retorna o id do equipamento comparando com a chave estrangeira da tabela detalhe equipamento
    public static int idEquipamento(int id) {
        
        Statement stmt;
        int codEquipamento = 0;
        
        try {
            
            String Sql = "SELECT idEquipamento FROM tabequipamento "
                       + "WHERE idEquipamento = '" + id + "';";
                       
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){   
                codEquipamento = (rs.getInt("idEquipamento"));              
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Carregar os dados do equipamento: ",ex);   
        }    
        return codEquipamento;
    }
}
