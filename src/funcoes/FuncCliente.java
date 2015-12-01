package funcoes;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FuncCliente {
    
    public static int id;
    
    public static void CadCliente(String n, String cpf, String tel){
        
        try {   
            String sql = ("INSERT INTO cliente(Nome,cpf) VALUES(?,?)");
            PreparedStatement stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setString(1, n);
                stmt.setString(2, cpf);
                
                stmt.executeUpdate();  
                
            ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()) { 
                    id = rs.getInt(1);
                    sql = "INSERT INTO telefone(Cliente_id, tel_cli) VALUES(?,?)";
                    stmt = Conexao.getConnection().prepareStatement(sql);
                    stmt.setInt(1, id);
                    stmt.setString(2, tel);
                    stmt.executeUpdate();    
                }
                stmt.close();  

            } catch (SQLException u) {      
                throw new RuntimeException(u);      
            }
    }
    public static int codigo(){
        int cod = id;
        return cod;
    }
       
}
