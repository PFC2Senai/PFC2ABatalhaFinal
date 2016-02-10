package funcoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/pfc1";
    private String usuario = "root";
    private String senha = "dragonballz";
    public Connection conn;
    
    public static Connection getConnection() {

        Connection conect = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();


         String url = "jdbc:mysql://localhost/pfc1?user=root&password=dragonballz";

      //   String url = "jdbc:mysql://localhost/pfc1?user=root&password=";

            
         //   String url = "jdbc:mysql://localhost/pfc1?user=root&password=";
            
            conect = DriverManager.getConnection(url);
            System.out.println("Conexão Estabelecida!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conect;
    }
    
    
    public void conexao() {
        try {
                Class.forName(driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
            System.out.println("Conectado!");
        } catch (SQLException ex) {
             System.out.println("Não Conectado!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void desconecta(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
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
