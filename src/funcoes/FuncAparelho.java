package funcoes;

import static funcoes.FuncCliente.id;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FuncAparelho {
    
    public static ArrayList<Integer> cods3 = new ArrayList<Integer>();
    public static ArrayList<String> aparelhos = new ArrayList<String>();
    public static ArrayList<String> marcas = new ArrayList<String>();
    public static ArrayList<String> SOs = new ArrayList<String>();
    public static ArrayList<String> queixas = new ArrayList<String>();
    public static PreparedStatement stmt;
    public static int idMaq;
    public static void CadApar(String ap, String marca, String so, String q, int codCli){
            
        try {   
            String sql = ("INSERT INTO maquina(maquina,marca,so,queixa,cliente_id) VALUES(?,?,?,?,?)");
            stmt = Conexao.getConnection().prepareStatement(sql);      

                
                stmt.setString(1, ap);
                stmt.setString(2, marca);
                stmt.setString(3, so);
                stmt.setString(4, q);
                stmt.setInt(5, codCli);
                
                stmt.executeUpdate(); 
            ResultSet rs = stmt.getGeneratedKeys();
        
            if(rs.next()) {
                idMaq = rs.getInt(1); 
                System.out.print(idMaq + "idMaquina");
                    stmt.close(); 
            }
            } catch (SQLException u) {      
                throw new RuntimeException(u);      
            }
        
    }
//    public static int codigoMaq(){
//        ResultSet rs;
//        int idMaq = 0;
//        try {
//            
//            rs = stmt.getGeneratedKeys();
//        
//            if(rs.next()) {
//            idMaq = rs.getInt(1); 
//            System.out.print(idMaq + "idMaquina");
//            ///stmt.close(); 
//                }
//            } catch (SQLException ex) {
//            Logger.getLogger(FuncAparelho.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return idMaq;
//    }
}
