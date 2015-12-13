package funcoes;

import atributos.Servico;
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
public class ServicoDAO {
    
    
    public static int CadServico(Servico serv){
        
        PreparedStatement stmt;
        int id = 0;
        try {   
            String sql = ("INSERT INTO tabservico(tabUsuario_id_usuario,"
                        + " tabCliente_idcliente,"
                        + " preco,dataServico,"
                        + " tabordemserv_idtabOrdemServ,"
                        + " descricao_servico) VALUES (?,?,?,?,?,?);");
            
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setInt(1, serv.getCodUsuario());
                stmt.setInt(2, serv.getCodCliente());              
                stmt.setDouble(3, serv.getPreco());
                stmt.setObject(4, serv.getDataServico());
                stmt.setDouble(5, serv.getCodOrdemServico());
                stmt.setString(6, serv.getDescricaoServico());
                              
                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                stmt.close();  

        } catch (SQLException ex) {      
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Cadastrar servico: ",ex);       
        }
        return id;
    }
    
    public static ArrayList CarregaServico(int id) {
        
        Statement stmt;
        ArrayList<Servico> servico = new ArrayList<Servico>();
        
        try {            
            String Sql = "SELECT * FROM tabservico "
                       + "WHERE idservico = '" + id + "';";
                       
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()) {
                Servico s = new Servico();
                
                s.setIdServico(rs.getInt("idservico"));
                s.setCodUsuario((rs.getInt("tabUsuario_id_usuario")));
                s.setCodCliente(rs.getInt("tabCliente_idcliente"));
                s.setDescricaoServico(rs.getString("descricao_servico"));
                s.setPreco(rs.getDouble("preco"));  
                s.setDataServico(rs.getDate("dataServico"));
                s.setCodOrdemServico(rs.getInt("tabordemserv_idtabOrdemServ"));
                servico.add(s);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Carregar os dados do servico: ",ex);   
        }    
        return servico;
    }        
    
    public static void ExcluirServico(int id) {
        
        CallableStatement stmt;
        try {   
            stmt = Conexao.getConnection().prepareCall("{call ExcluirServico(?)}");
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir o servico: ",ex);    
        }
    }
    
    public static void UpdateServico(Servico serv, int id) {
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("UPDATE tabservico SET tabCliente_idcliente = " + serv.getCodCliente() + 
                                                 ", infoServico = '" + serv.getDescricaoServico() + 
                                                 "', preco = " + serv.getPreco() + 
                                                 " WHERE idservico = " + id + ";");
            
            stmt = Conexao.getConnection().prepareStatement(sql);                             
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao alterar dados servico: ",ex);     
        }
    }
    
    public static ArrayList<Servico> ListarServicos(){
        
        Statement stmt;
        ArrayList<Servico> servicos = new ArrayList<Servico>();
        
        try {
            
            String Sql = "SELECT * FROM tabservico INNER JOIN det_servico ON idservico = servico_idservico;";

            ResultSet rs;
            
            stmt = Conexao.getConnection().createStatement();
            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Servico s = new Servico();
                
                s.setIdServico(rs.getInt("idservico"));
                s.setCodUsuario((rs.getInt("tabUsuario_id_usuario")));
                s.setCodCliente(rs.getInt("tabCliente_idcliente"));
                s.setDescricaoServico(rs.getString("infoServico"));
                s.setPreco(rs.getFloat("preco"));  
                s.setDataServico(rs.getDate("dataServico"));
                s.setCodOrdemServico(rs.getInt("tabordemserv_idtabOrdemServ"));
                servicos.add(s);
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Listar servico: ",ex); 
        }
        return servicos;
    }  
       
}
