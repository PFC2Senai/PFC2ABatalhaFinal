package funcoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

    public static Connection getConnection() {
        Connection conect = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // String url = "jdbc:mysql://localhost/bancovinicris2?user=root&password=2810";

            String url = "jdbc:mysql://localhost/pfc1?user=root&password=dragonballz";
            //String url = "jdbc:mysql://localhost/pfc1?user=root&password=123456";

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
}
