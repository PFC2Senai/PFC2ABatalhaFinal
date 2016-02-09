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
    
    public static int CadModelo(Modelo model){
        
        int id = 0;
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabmodelo(modelo) VALUES(?)");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setString(1, model.getModelo());
                              
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                    if (rs.next()) {
                        id = rs.getInt(1);
                    } 
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Modelo: ",ex);       
            }
        return id;
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
    
    public static ArrayList<Modelo> ListarModelo(int codProduto){
        Statement stmt;
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        
        try {
            
            String Sql = "select modelo "
                + " from tabdetproduto inner join "
                + " tabproduto inner join "
                + " tabmodelo on tabmodelo_idtabModelo = idtabModelo and "
                + " tabproduto_id_prod = id_prod"
                + " where id_prod = " + codProduto + " group by modelo;";
            
            ResultSet rs;
            
            stmt = Conexao.getConnection().createStatement();
            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()) {
                Modelo m = new Modelo();
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
    
    public static boolean VerificarModelo(String modelo) {

        Statement stmt;
        boolean achou = true;
        int mo = 0;

        
        String Sql = "SELECT COUNT(0), modelo FROM tabmodelo WHERE modelo = '" + modelo + "';";

        try {

            ResultSet rs;
            stmt = Conexao.getConnection().createStatement();
            rs = stmt.executeQuery(Sql);

            rs.first();
            do {              
                mo = rs.getInt("COUNT(0)");                
            } while (rs.next());

            if (mo == 0) {
                achou = false;
            }
           

            rs.close();
            stmt.close();

        } catch (SQLException ex) {

            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Carregar os dados do modelo: ", ex);
        }
        return achou;
    }
   
}
