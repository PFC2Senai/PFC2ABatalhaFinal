package funcoes;

import atributos.Equipamento;
import atributos.Servico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EquipamentoDAO {
    
    public static void CadEquipamento(Equipamento equi){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabequipamento(tabUsuario_id_usuario, equipamento) VALUES(?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setInt(1, 1);
                stmt.setString(2, equi.getEquipamento());
                              
                stmt.executeUpdate();
                stmt.close();  

        } catch (SQLException ex) {      
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Cadastrar equipamento: ",ex);       
        }
    }
    
    
//    public static ArrayList CarregaEquipamento(int id) {
//        
//        Statement stmt;
//        ArrayList<Equipamento> servico = new ArrayList<Equipamento>();
//        
//        try {            
//            String Sql = "SELECT * FROM tabservico INNER JOIN det_servico ON idservico = servico_idservico "
//                       + "WHERE idservico = '" + id + "';";
//                       
//            
//            ResultSet rs;            
//            stmt = Conexao.getConnection().createStatement();            
//            rs = stmt.executeQuery(Sql); 
//            
//            while(rs.next()){
//                
//                Equipamento e = new Equipamento();
//                
//                s.setIdServico(rs.getInt("idservico"));
//                s.setCodUsuario((rs.getInt("tabUsuario_id_usuario")));
//                s.setCodCliente(rs.getInt("tabCliente_idcliente"));
//                s.setDescricaoServico(rs.getString("infoServico"));
//                s.setPreco(rs.getFloat("preco"));  
//                s.setDataServico(rs.getDate("dataServico"));
//                s.setIdDetServico(rs.getInt("id_det_servico"));
//                s.setCodServico(rs.getInt("servico_idservico"));
//                s.setCodProduto(rs.getInt("tabProduto_id_prod"));
//                s.setCodOrdemServico(rs.getInt("tabordemserv_idtabOrdemServ"));
//                s.setQuantidade(rs.getInt("quantidadeproduto"));
//                servico.add(s);                
//            }            
//            rs.close();
//            stmt.close();
//            
//        } catch (SQLException ex) {      
//            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("Erro ao Carregar os dados do servico: ",ex);   
//        }    
//        return servico;
//    }        
//    
//    public static void ExcluirServico(int id){
//        
//        CallableStatement stmt;
//        try {   
//            stmt = Conexao.getConnection().prepareCall("{call ExcluirServico(?)}");
//            
//            stmt.setInt(1, id);
//            
//            stmt.execute();
//            stmt.close();
//
//        } catch (SQLException ex) {      
//            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("Erro ao excluir o servico: ",ex);    
//        }
//    }
//    
//    public static void UpdateServico(Equipamento equi, int id) {
//        
//        PreparedStatement stmt;
//        
//        try {   
//            String sql = ("UPDATE tabservico SET tabCliente_idcliente = " + serv.getCodCliente() + 
//                                                 ", infoServico = '" + serv.getDescricaoServico() + 
//                                                 "', preco = " + serv.getPreco() + 
//                                                 " WHERE idservico = " + id + ";");
//            
//            stmt = Conexao.getConnection().prepareStatement(sql);                             
//            stmt.executeUpdate();
//            stmt.close();
//
//        } catch (SQLException ex) {      
//            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("Erro ao alterar dados servico: ",ex);     
//        }
//    }
//    
//    public static void UpdateDetServico(Equipamento equi, int id) {
//        
//        PreparedStatement stmt;
//        
//        try {   
//            String sql = ("UPDATE det_servico SET tabProduto_id_prod = " + serv.getCodProduto() + 
//                                               ", quantidadeproduto = " + serv.getQuantidade() + 
//                                                " WHERE servico_idservico = " + id + ";");
//            
//            stmt = Conexao.getConnection().prepareStatement(sql);                             
//            stmt.executeUpdate();
//            stmt.close();
//
//        } catch (SQLException ex) {      
//            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("Erro ao alterar dados Detalhe de servico: ",ex);     
//        }
//    }
//    
//    public static ArrayList<Servico> ListarServicos(){
//        
//        Statement stmt;
//        ArrayList<Servico> servicos = new ArrayList<Servico>();
//        
//        try {            
//            String Sql = "SELECT * FROM tabservico INNER JOIN det_servico ON idservico = servico_idservico;";
//
//            ResultSet rs;
//            
//            stmt = Conexao.getConnection().createStatement();
//            
//            rs = stmt.executeQuery(Sql); 
//            
//            while(rs.next()){
//                Servico s = new Servico();
//                
//                s.setIdServico(rs.getInt("idservico"));
//                s.setCodUsuario((rs.getInt("tabUsuario_id_usuario")));
//                s.setCodCliente(rs.getInt("tabCliente_idcliente"));
//                s.setDescricaoServico(rs.getString("infoServico"));
//                s.setPreco(rs.getFloat("preco"));  
//                s.setDataServico(rs.getDate("dataServico"));
//                s.setIdDetServico(rs.getInt("id_det_servico"));
//                s.setCodServico(rs.getInt("servico_idservico"));
//                s.setCodProduto(rs.getInt("tabProduto_id_prod"));
//                s.setCodOrdemServico(rs.getInt("tabordemserv_idtabOrdemServ"));
//                s.setQuantidade(rs.getInt("quantidadeproduto"));
//                servicos.add(s);
//            }
//            
//            rs.close();
//            stmt.close();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("Erro ao Listar servico: ",ex); 
//        }
//        return servicos;
//    }  
}
