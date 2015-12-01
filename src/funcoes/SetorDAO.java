package funcoes;

import atributos.Setor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SetorDAO {
    
    public static void CadSetor(Setor setor){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabsetor(setor) VALUES (?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
                  
                stmt.setString(1, setor.getSetor());
                              
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Setor: ",ex);       
            }
    }
    
    public static ArrayList CarregaSetor(int id) {
        
        Statement stmt;
        ArrayList<Setor> setor = new ArrayList<Setor>();
        
        try {            
            String Sql = "SELECT * FROM tabsetor where idtabSetor = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Setor s = new Setor();
                
                s.setIdSetor(rs.getInt("idtabSetor"));
                s.setSetor((rs.getString("setor")));
                setor.add(s);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao carregar o setor: ", ex);    
        }    
        return setor;
    }
    
   
    public static void ExcluirSetor(int id){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("DELETE FROM tabsetor WHERE idtabSetor = ?;");
            stmt = Conexao.getConnection().prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir o setor: ",ex);    
        }
    }
    
    public static void UpdateSetor(Setor setor, int id){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("UPDATE tabsetor SET setor = '" + setor.getSetor()
                        + "' where idtabSetor = '" + id + "';");
            
            stmt = Conexao.getConnection().prepareStatement(sql);                             
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar o setor: ",ex);    
        }
    }
    
    public static ArrayList<Setor> ListarSetor(){
        
        Statement stmt;
        ArrayList<Setor> setores = new ArrayList<Setor>();
        
        try {            
            String Sql = "SELECT * FROM tabsetor;;";

            ResultSet rs;
            
            stmt = Conexao.getConnection().createStatement();
            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Setor s = new Setor();
                
                s.setIdSetor(rs.getInt("idtabSetor"));
                s.setSetor((rs.getString("setor")));              
                setores.add(s);                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Listar os setores: ",ex);
        }
        return setores;
    }
}
