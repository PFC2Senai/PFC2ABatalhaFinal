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
    
    public static void CadServico(Servico serv){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabservico(tabUsuario_id_usuario,tabCliente_idcliente,infoServico,preco,dataServico) VALUES (?,?,?,?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setInt(1, 1);
                stmt.setInt(2, serv.getCodCliente());
                stmt.setString(3, serv.getDescricaoServico());
                stmt.setDouble(4, serv.getPreco());
                stmt.setObject(5, serv.getDataServico());
                              
                stmt.executeUpdate();
                stmt.close();  

        } catch (SQLException ex) {      
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Cadastrar servico: ",ex);       
        }
    }
    
    public static void CadDetServico(Servico serv){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO det_servico(servico_idservico,tabProduto_id_prod,quantidadeproduto,tabordemserv) VALUES(?,?,?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setInt(1, serv.getCodServico());
                stmt.setInt(2, serv.getCodDetProduto());
                stmt.setInt(3, serv.getQuantidade());
                stmt.setInt(4, serv.getCodOrdemServico());
                              
                stmt.executeUpdate();
                stmt.close();  

        } catch (SQLException ex) {      
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Cadastrar Detalhe de servico: ",ex);       
        }
    }
    
    public static ArrayList CarregaServico(int id) {
        
        Statement stmt;
        ArrayList<Servico> servico = new ArrayList<Servico>();
        
        try {            
            String Sql = "SELECT * FROM tabservico INNER JOIN det_servico ON idservico = servico_idservico "
                       + "WHERE idservico = '" + id + "';";
                       
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Servico s = new Servico();
                
                s.setIdServico(rs.getInt("idservico"));
                s.setCodUsuario((rs.getInt("tabUsuario_id_usuario")));
                s.setCodCliente(rs.getInt("tabCliente_idcliente"));
                s.setDescricaoServico(rs.getString("infoServico"));
                s.setPreco(rs.getDouble("preco"));  
                s.setDataServico(rs.getDate("dataServico"));
                s.setIdDetServico(rs.getInt("id_det_servico"));
                s.setCodServico(rs.getInt("servico_idservico"));
                s.setCodDetProduto(rs.getInt("tabProduto_id_prod"));
                s.setCodOrdemServico(rs.getInt("tabordemserv_idtabOrdemServ"));
                s.setQuantidade(rs.getInt("quantidadeproduto"));
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
    
    public static void UpdateDetServico(Servico serv, int id) {
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("UPDATE det_servico SET tabProduto_id_prod = " + serv.getCodDetProduto() + 
                                               ", quantidadeproduto = " + serv.getQuantidade() + 
                                                " WHERE servico_idservico = " + id + ";");
            
            stmt = Conexao.getConnection().prepareStatement(sql);                             
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao alterar dados Detalhe de servico: ",ex);     
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
                s.setIdDetServico(rs.getInt("id_det_servico"));
                s.setCodServico(rs.getInt("servico_idservico"));
                s.setCodDetProduto(rs.getInt("tabProduto_id_prod"));
                s.setCodOrdemServico(rs.getInt("tabordemserv_idtabOrdemServ"));
                s.setQuantidade(rs.getInt("quantidadeproduto"));
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
