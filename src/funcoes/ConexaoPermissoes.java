/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ConexaoPermissoes {
    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/pfc1";
    private String usuario = "root";
    private String senha = "";
    public Connection conn;
    
    
    public void conexao(){
        try {
                Class.forName(driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
            System.out.println("Conectado!");
        } catch (SQLException ex) {
             System.out.println("Não Conectado!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoPermissoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void desconecta(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoPermissoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void executaSQL(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("erro do ExecutaSQL!");
        }
    }
}
