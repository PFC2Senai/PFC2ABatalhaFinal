package buscar;

import funcoes.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Josy
 */
public class GraficosMineracao {
    
    public static CategoryDataset graficoMeses(){
        Statement st;
        DefaultCategoryDataset formPaga = new DefaultCategoryDataset();
        try {
            st = Conexao.getConnection().createStatement();
            String Sql = "select count(dataServico),\n" +
                        " Month(dataServico),\n" +
                        " count(Month(dataServico)),\n" +
                        " MONTHNAME(dataServico),dataServico,\n" +
                        " DATE_FORMAT(dataServico, '%d/%m/%Y') \n" +
                        " from tabservico \n" +
                        " group by Month(dataServico);";
            
            String Sql2 = "select count(dataServico),Month(dataServico) from tabservico;";
            
            String a[] = new String[12];
            int os = 0;
            int i =0 ;
            ResultSet rs;
            rs = st.executeQuery(Sql2);   
            rs.first();
                    do{
                        os = rs.getInt("count(dataServico)");
                    }while(rs.next());    
                              
            rs = st.executeQuery(Sql);   
            rs.first();
                    do{                  
                        formPaga.addValue(((rs.getInt("count(dataServico)")*100)/os), rs.getString("MONTHNAME(dataOs)"),rs.getString("DATE_FORMAT(dataOs, '%d/%m/%y')"));
                        i++;
                    }while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(Mineracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formPaga;
    }
}
