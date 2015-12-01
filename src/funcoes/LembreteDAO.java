package funcoes;


import atributos.Lembrete;
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
 * @author S015365
 */
public class LembreteDAO {
    
    public static void CadLembrete(Lembrete lembrete){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("INSERT INTO tablembrete (tabusuario_id_usuario,dataContato,hora,descricao,tabCliente_idcliente) VALUES(?,?,?,?,?)");
            stmt = Conexao.getConnection().prepareStatement(sql);      
                  
                stmt.setInt(1, 1);
                stmt.setObject(2, lembrete.getDataLembrete());
                stmt.setTime(3, lembrete.getHora());
                stmt.setString(4, lembrete.getDescricao());
                stmt.setInt(5, lembrete.getCodCliente());
                              
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(LembreteDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Lembrete: ",ex);       
            }
    }
    
    public static ArrayList CarregaLembrete(int id) {
        
        Statement stmt;
        ArrayList<Lembrete> lembretes = new ArrayList<Lembrete>();
        
        try {            
            String Sql = "select idLembrete, dataContato, hora, descricao, tabCliente_idcliente, empresa, idcliente "
                    + "from tablembrete inner join tabcliente on idcliente = tabCliente_idcliente "
                    + "where idLembrete = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Lembrete l = new Lembrete();
                
                l.setIdLembrete(rs.getInt("idLembrete"));
                l.setDataLembrete((rs.getDate("dataContato")));
                l.setHora(rs.getTime("hora"));
                l.setDescricao(rs.getString("descricao"));
                l.setCodCliente(rs.getInt("tabCliente_idcliente"));
                l.setNomeCliente(rs.getString("empresa"));
                lembretes.add(l);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(LembreteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Cliente: ", ex);    
        }    
        return lembretes;
    }
    
    public static void ExcluirLembrete(int id){ //se tiver mais de um lembrete ver
        
        PreparedStatement stmt;
        try {
            
            String sql = ("DELETE FROM tablembrete WHERE idLembrete = ?; ");
            
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(LembreteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Cliente: ",ex);    
        }
    }
    
    public static void UpdateLembrete(Lembrete lembrete, int id) {
        
        CallableStatement stmt;
        try { 
            
            stmt = Conexao.getConnection().prepareCall("{call UpdateLembrete(?,?,?,?)}");        
            stmt.setObject(1, lembrete.getDataLembrete());
            stmt.setTime(2, lembrete.getHora());
            stmt.setString(3, lembrete.getDescricao());
            stmt.setInt(4, id);                        
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(LembreteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Cliente: ",ex);    
        }
    }
    
    public static ArrayList<Lembrete> ListarLembretes(int cod){
        
        Statement stmt;
        ArrayList<Lembrete> lembretes = new ArrayList<Lembrete>();
        
        try {            
            String Sql = "select idLembrete, dataContato, hora, descricao, tabCliente_idcliente "
                        + "from tablembrete inner join tabcliente on idcliente = tabCliente_idcliente "
                        + "where idcliente = '"+ cod +"';";

            ResultSet rs;
            
            stmt = Conexao.getConnection().createStatement();
            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                
                Lembrete lembrete = new Lembrete();
                
                lembrete.setIdLembrete(rs.getInt("idLembrete"));
                lembrete.setDataLembrete(rs.getDate("dataContato"));
                lembrete.setHora((rs.getTime("hora")));     
                lembrete.setDescricao((rs.getString("descricao")));                
                lembretes.add(lembrete);                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(LembreteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Listar os lembretes: ",ex);
        }
        return lembretes;
    }
}
