/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import funcoes.Conexao;
import funcoes.FuncAparelho;
import static funcoes.FuncAparelho.stmt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josy
 */
public class TipoServico {
    public static PreparedStatement stmt;
    public static int idTipoSv;
    
    public static void tipoServ(String tipo, float valor){
        
        try {
        int idTipoServ = 0;
        String sql = ("INSERT INTO TipoServ(reparo, valorServ) VALUES(?,?)");
         
        
            stmt = Conexao.getConnection().prepareStatement(sql);
                    stmt.setString(1, tipo);
                    stmt.setFloat(2, valor);
                    stmt.executeUpdate(); 
            ResultSet rs = stmt.getGeneratedKeys();
        
                if(rs.next()) {
                idTipoSv = rs.getInt(1); 
                System.out.println(idTipoSv + "idTipoServ");
                stmt.close(); 
                }
                    
    
        } catch (SQLException ex) {
            Logger.getLogger(TipoServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static int idTipoServ(){
//        ResultSet rs;
//        int idSv = 0;
//        
//        try {
//            rs = stmt.getGeneratedKeys();
//        
//                if(rs.next()) {
//                idSv = rs.getInt(1); 
//                System.out.println(idSv + "idTipoServ");
//                stmt.close(); 
//                }
//            } catch (SQLException ex) {
//            Logger.getLogger(FuncAparelho.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return idSv;
//    }
}
