package modeloRelatorio;

import static funcoes.Conexao.getConnection;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class Relatorio {
    
     Statement stmt ;
    
    public void gerarRelatorio(ArrayList<ModeloRelatProposta> lista) {
       
        try {
            InputStream fonte = Relatorio.class.getResourceAsStream("/relatorios/RelatorioProposta.jrxml");
            
            JasperReport report = JasperCompileManager.compileReport(fonte);
            
            JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
            
            JasperViewer.viewReport(print, false);
            
        } catch (JRException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gerarRelatorioSQL() {
       
        try {
            
            String Sql = "SELECT * FROM tabsetor;";
            
            stmt = getConnection().createStatement();
            
            ResultSet rs;
            rs = stmt.executeQuery(Sql);//"G:/Arquivos/cOPIA SEGURANÇA 2/PFCTelas/src/relatoriosBanco/RelatorioSetor.jasper"
            
            JRResultSetDataSource relatResul = new JRResultSetDataSource(rs);
            
            InputStream fonte = Relatorio.class.getResourceAsStream("/relatoriosBanco/RelatorioSetor.jasper");
            
            JasperPrint jpPrint = JasperFillManager.fillReport(fonte , new HashMap() , relatResul);
            
            JasperViewer jv = new JasperViewer(jpPrint, false);
            
            jv.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
             Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
