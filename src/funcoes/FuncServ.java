package funcoes;


import static funcoes.FuncAparelho.idMaq;
import static funcoes.TipoServico.idTipoSv;
import static funcoes.TipoServico.tipoServ;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FuncServ {
    
    public static ArrayList<Integer> cods2 = new ArrayList<Integer>();
    public static ArrayList<String> pag = new ArrayList<String>();
    public static ArrayList<String> tipoReps = new ArrayList<String>();
    public static ArrayList<Float> valores = new ArrayList<Float>();
    public static ArrayList<Float> descs = new ArrayList<Float>();
    public static ArrayList<Float> totais = new ArrayList<Float>();
    public static ArrayList<String> status = new ArrayList<String>();
    
    public static void CadServ(int id, String tipoRep, float valor, String formPag, float desconto, float total){
        
        try {   
            
            String sql = ("INSERT INTO servico(Cliente_id) VALUES(?)");
            PreparedStatement stmt = Conexao.getConnection().prepareStatement(sql);      

                
                stmt.setInt(1, id);
                
                stmt.executeUpdate();  
            
            tipoServ(tipoRep,valor);
            
            ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()) {
                    int idServ = rs.getInt(1); 
                    
                    System.out.print(idServ + "id Servico");
                    sql = "INSERT INTO det_Serv(Servico_idServ, Maquina_idMaquina, TipoServ_idTipoServ, forma_pag,desconto,total) VALUES(?,?,?,?,?,?)";
                    stmt = Conexao.getConnection().prepareStatement(sql);
                    stmt.setInt(1, idServ);
                    stmt.setInt(2, idMaq);
                    stmt.setInt(3, idTipoSv);
                    stmt.setString(4, formPag);
                    stmt.setFloat(5, desconto);
                    stmt.setFloat(6, total);
                
                stmt.executeUpdate(); 
                } 
         
                rs = stmt.getGeneratedKeys();
                if(rs.next()) {
                    int idDetServ = rs.getInt(1); 
                    
                    System.out.print(idDetServ + "id det_serv");
                    sql = "INSERT INTO os(os_idOS) VALUES(?)";
                    stmt = Conexao.getConnection().prepareStatement(sql);
                    stmt.setInt(1, idDetServ);
                
                stmt.executeUpdate(); 
                }
                
                
                stmt.close(); 
            } catch (SQLException u) {      
                throw new RuntimeException(u);      
            }
    }
}
