package funcoes;

import buscar.FrameBusca;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class Graficos {

    public static CategoryDataset graficoFPag(){
        Statement st;
        DefaultCategoryDataset formPaga = new DefaultCategoryDataset();
        try {
            st = Conexao.getConnection().createStatement();
            String Sql = "select forma_pag , count(forma_pag) ,  count(os.idOS), sum(ROUND (total, 2)) 'total' from det_serv inner join os\n" +
                         "where (id_dtServ = os_idOS)\n" +
                         "group by (forma_pag) order by count(forma_pag)/count(os.idOS) desc";
            
            String Sql2 = "select count(os.idOS) from det_serv inner join os\n" +
                         "where (id_dtServ = os_idOS)";
            
            int os = 0;
            ResultSet rs;
            rs = st.executeQuery(Sql2);   
            rs.first();
                    do{
                        os = rs.getInt("count(os.idOS)");
                    }while(rs.next());
            rs = st.executeQuery(Sql);   
            rs.first();
                    do{
                        formPaga.addValue(((rs.getInt("count(forma_pag)")*100)/os),rs.getString("forma_pag"),"Total "+rs.getString("total"));
                    }while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(FrameBusca.class.getName()).log(Level.SEVERE, null, ex);
        }
    return formPaga;
}

    public static CategoryDataset graficoMeses(){
        Statement st;
        DefaultCategoryDataset formPaga = new DefaultCategoryDataset();
        try {
            st = Conexao.getConnection().createStatement();
            String Sql = "select count(dataOs),Month(dataOs),count( Month(dataOs)),MONTHNAME(dataOs),dataOs,DATE_FORMAT(dataOs, '%d/%m/%Y') from os inner join det_serv \n" +
                         "on (id_dtServ = os_idOS) \n" +
                         "group by Month(dataOs) ;";
            
            String Sql2 = "select count(idOS),Month(dataOs) from os;";
            String a[] = new String[12];
            int os = 0;
            int i =0 ;
            ResultSet rs;
            rs = st.executeQuery(Sql2);   
            rs.first();
                    do{
                        os = rs.getInt("count(idOS)");
                    }while(rs.next());    
                              
            rs = st.executeQuery(Sql);   
            rs.first();
                    do{                  
                        formPaga.addValue(((rs.getInt("count(dataOs)")*100)/os), rs.getString("MONTHNAME(dataOs)"),rs.getString("DATE_FORMAT(dataOs, '%d/%m/%y')"));
                        i++;
                    }while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(FrameBusca.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formPaga;
    }
    
        public static CategoryDataset graficoMarca(){
            Statement st;
            DefaultCategoryDataset marcas = new DefaultCategoryDataset();
        try {
            ResultSet rs;
            st = Conexao.getConnection().createStatement(); 
            String Sql = "select marca, count(marca) 'Quant' from maquina group by marca order by count(marca) desc;";

            String Sql2 = "select count(maquina) from maquina;";
            int lugar = 1;
            int os = 0;
            
            rs = st.executeQuery(Sql2);   
            rs.first();
                    do{
                        os = rs.getInt("count(maquina)");
                    }while(rs.next());
              
            rs = st.executeQuery(Sql);    
            rs.first();
            
                do{
                    marcas.addValue(((rs.getInt("Quant")*100)/os),rs.getString("marca"),"Marca");
                   
                }while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(FrameBusca.class.getName()).log(Level.SEVERE, null, ex);
        }
            return marcas;
    }
        
}
