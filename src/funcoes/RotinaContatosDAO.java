package funcoes;

import atributos.RotinaContatos;
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
 * @author Vinicius
 */
public class RotinaContatosDAO {
    
    public static void CadRotinaContato(RotinaContatos rot){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabrotinacontato(cliente_idcliente,tabusuario_id_usuario,dataRotina,horaRotina,descricaoRotina) VALUES(?,?,?,?,?)");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setInt(1, rot.getIdCliente());
                stmt.setInt(2, rot.getIdUsuario());
                stmt.setObject(3, rot.getDataRotinaContato());
                stmt.setTime(4, rot.getHoraRotinaContato());
                stmt.setString(5, rot.getDescricaoRotina());
                              
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Rotina: ",ex);       
            }
    }
    
    public static ArrayList CarregaRotinaContatos(int id) {
        
        Statement stmt;
        ArrayList<RotinaContatos> rotinaContato = new ArrayList<RotinaContatos>();
        
        try {            
            String Sql = "SELECT * FROM tabotinacontato cli\n" +
                        "INNER JOIN tabtel tel\n" +
                        "INNER JOIN tabemail email\n" +
                        "INNER JOIN tabcontato cont\n" +
                        "ON cont.id_contato = cli.tabContato_id_contato AND\n" +
                        "cont.id_contato = tel.contato_id AND\n" +
                        "id_contato = email.contato_id_contato where cli.idcliente = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                RotinaContatos r = new RotinaContatos();
                
                r.setIdRotinaContato(rs.getInt("idRotinaContato"));
                r.setIdCliente(rs.getInt("cliente_idciente"));
                r.setIdUsuario(rs.getInt("tabusuario_id_usuario"));
                r.setDataRotinaContato(rs.getDate("dataRotina"));
                r.setHoraRotinaContato(rs.getTime("horaRotina"));
                r.setIdCliente(rs.getInt("cliente_idcliente"));
                r.setDescricaoRotina(rs.getString("descricaoRotina"));
                
                rotinaContato.add(r);
                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados da Rotina: ", ex);    
        }    
        return rotinaContato;
    }
    
   /* public static int idContato(int id) {
        
        Statement stmt;
        RotinaContatos r = new RotinaContatos();
        
        try {            
            String Sql = "SELECT  tabContato_id_contato FROM tabcliente WHERE idcliente = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){                                
                c.setIdContato(rs.getInt("tabContato_id_contato"));                             
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Cliente: ", ex);    
        }    
        return c.getIdContato();
    }
    
    public static void ExcluirCliente(int id){
        
        CallableStatement stmt;
        try {   
            stmt = Conexao.getConnection().prepareCall("{call ExcluirCliente(?)}");
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Cliente: ",ex);    
        }
    }
    
    public static void UpdateCliente(RotinaContatos r, int id){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("UPDATE tabcliente SET empresa='" + cli.getEmpresa() 
                        + "' , cnpj='"+ cli.getCnpj() +"', setor='"+cli.getSetor()
                        +"', contato='"+cli.getContato()+"' where idCliente = '" + id + "';");
            
            stmt = Conexao.getConnection().prepareStatement(sql);                             
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar os dados do Cliente: ",ex);    
        }
    }
    
    public static ArrayList<RotinaContatos> ListarCliente(){
        
        Statement stmt;
        ArrayList<RotinaContatos> clientes = new ArrayList<RotinaContatos>();
        
        try {            
            String Sql = "SELECT * FROM tabcliente cli\n" +
                        "INNER JOIN tabtel tel\n" +
                        "INNER JOIN tabemail email\n" +
                        "INNER JOIN tabcontato cont\n" +
                        "ON cont.id_contato = cli.tabContato_id_contato AND\n" +
                        "cont.id_contato = tel.contato_id AND\n" +
                        "id_contato = email.contato_id_contato;";

            ResultSet rs;
            
            stmt = Conexao.getConnection().createStatement();
            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                RotinaContatos r = new RotinaContatos();
                
                c.setId(rs.getInt("idcliente"));
                c.setEmpresa((rs.getString("empresa")));
                c.setCnpj(rs.getString("cnpj"));
                c.setContato(rs.getString("contato"));
                c.setSetor(rs.getString("setor"));                 
                c.setTel(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));               
                clientes.add(c);                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Listar os dados do Clientes: ",ex);
        }
        return clientes;
    }    */
    
}
