package funcoes;

import atributos.Aluguel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josy
 */
public class AluguelDAO {
    
    public static void CadAluguel(Aluguel al){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tablocacao(tabusuario_id_usuario, tabcliente_idcliente, tabDetLocacaocol) VALUES (?,?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setInt(1, 1);
                stmt.setInt(2, al.getTabclienteIdcliente());
                stmt.setString(3, al.getTabDetLocacaocol());
                              
                stmt.executeUpdate();
                stmt.close();  

        } catch (SQLException ex) {      
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Cadastrar aluguel: ",ex);       
        }
    }
    
    public static void CadDetAluguel(Aluguel detAluguel) {
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("INSERT INTO tabdetlocacao( dataLocacao," +
                                                    " hora, " +
                                                    " valorHora," +
                                                    " dataDevolucao, " +
                                                    " tabEquipamento_idEquipamento, " +
                                                    " tabLocacao_idtabDetLocacao," +
                                                    " tabordemserv_idtabOrdemServ) VALUES (?,?,?,?,?,?,?);");
            stmt = Conexao.getConnection().prepareStatement(sql);      
           
                stmt.setObject(1, detAluguel.getDataAluguel());
                stmt.setTime(2, detAluguel.getHora());
                stmt.setFloat(3, detAluguel.getValorHora());
                stmt.setObject(4, detAluguel.getDataDevolucao());
                stmt.setInt(5, detAluguel.getCodEquipamento());
                stmt.setInt(6, detAluguel.getCodAluguel());
                stmt.setInt(7, detAluguel.getCodOrdemServico());
                              
                stmt.executeUpdate();
                stmt.close();  

        } catch (SQLException ex) {      
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Cadastrar Detalhe do aluguel: ",ex);       
        }
    }
    
    
    public static ArrayList CarregaAluguel(int id) {
        
        Statement stmt;
        ArrayList<Aluguel> aluguel = new ArrayList<Aluguel>();
        
        try {            
            String Sql = "SELECT * FROM tablocacao INNER JOIN tabdetlocacao "
                      +  "ON idLocacao = tabLocacao_idtabDetLocacao "
                       + "WHERE idLocacao = '" + id + "';";
                       
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                
                Aluguel a = new Aluguel();
                
                a.setCodAluguel(rs.getInt("idLocacao"));
                a.setDataAluguel((rs.getDate("equipamento")));                
                aluguel.add(a);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Carregar os dados do equipamento: ",ex);   
        }    
        return aluguel;
    }        
    
    public static void ExcluirEquipamento(int id){
        
        PreparedStatement stmt;
        try {
            
            String sql = ("DELETE FROM tabequipamento WHERE idEquipamento = ?; ");
            
            stmt = Conexao.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir o equipamento: ",ex);    
        }
    }
    
//    public static void UpdateEquipamento(Equipamento equi, int id) {
//        
//        PreparedStatement stmt;
//        
//        try {   
//            String sql = ("UPDATE tabequipamento SET equipamento = '" + equi.getEquipamento() +
//                                                "' WHERE idEquipamento = " + id + ";");
//            
//            stmt = Conexao.getConnection().prepareStatement(sql);                             
//            stmt.executeUpdate();
//            stmt.close();
//
//        } catch (SQLException ex) {      
//            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("Erro ao alterar o equipamento: ",ex);     
//        }
//    }
//    
//    public static ArrayList<Equipamento> ListarEquipamentos(){
//        
//        Statement stmt;
//        ArrayList<Equipamento> equipamento = new ArrayList<Equipamento>();
//        
//        try {            
//            String Sql = "SELECT * FROM tabequipamento;";
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
//                e.setIdEquipamento(rs.getInt("idEquipamento"));
//                e.setEquipamento((rs.getString("equipamento")));                
//                equipamento.add(e);                
//            }            
//            rs.close();
//            stmt.close();
//            
//        } catch (SQLException ex) {      
//            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("Erro ao listar os dados do equipamento: ",ex);   
//        }    
//        return equipamento;                    
//    } 
}
