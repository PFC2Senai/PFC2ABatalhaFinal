package funcoes;

import atributos.Fabricante;
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
public class FabricanteDAO {
    
    public static void CadFabricante(Fabricante fab){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabfabricante(fabricante) VALUES(?)");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setString(1, fab.getFabricante());
                              
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(FabricanteDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Fabricante: ",ex);       
            }
    }
    
     public static ArrayList CarregaFabricante(int id) {
        
        Statement stmt;
        ArrayList<Fabricante> fabricante = new ArrayList<Fabricante>();
        
        try {            
            String Sql = "SELECT * FROM tabfabricante where idtabFabricante = " + id + ";";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Fabricante f = new Fabricante();
                
                f.setIdFabricante(rs.getInt("idtabFabricante"));
                f.setFabricante(rs.getString("fabricante"));
                f.setIdFabricante(id);
                fabricante.add(f);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(FabricanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Fabricante: ", ex);    
        }    
        return fabricante;
    }
     
     public static int idFabricante(int id) {
        
        Statement stmt;
        Fabricante f = new Fabricante();
        
        try {            
            String Sql = "SELECT  idtabFabricante FROM tabfabricante WHERE idtabFabricante = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){                                
                f.setIdFabricante(rs.getInt("idtabFabricante"));                             
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(FabricanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Fabricante: ", ex);    
        }    
        return f.getIdFabricante();
    }
     
     public static void ExcluirFabricante(int id){
        
        CallableStatement stmt;
        try {   
            stmt = Conexao.getConnection().prepareCall("{call ExcluirFabricante(?)}");
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(FabricanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Fabricante: ",ex);    
        }
    }
    
    public static void UpdateFabricante(Fabricante fab, int id){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("UPDATE tabfabricante SET fabricante='" + fab.getFabricante()+
                    "' where idtabFabricante = '" + id + "';");
            stmt = Conexao.getConnection().prepareStatement(sql);
                              
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(FabricanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar os dados do Fabricante: ",ex);    
        }
    }
    
    public static ArrayList<Fabricante> ListarFabricante(int codProduto, int codModelo){
        Statement stmt;
        ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>();
        
        try {
            
            String Sql = "SELECT fabricante FROM vw_combofabricanteproduto "
                + " WHERE id_prod = " + codProduto
                + " AND tabmodelo_idtabModelo = " + codModelo + " group by fabricante;";
            
            ResultSet rs;
            
            stmt = Conexao.getConnection().createStatement();
            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Fabricante f = new Fabricante();
                f.setFabricante(rs.getString("fabricante"));
                fabricantes.add(f);                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FabricanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Listar os dados dos Fabricantes: ",ex);
        }
        return fabricantes;
    }     
}
