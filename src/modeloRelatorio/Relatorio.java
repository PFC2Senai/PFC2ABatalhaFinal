package modeloRelatorio;

import com.sun.glass.ui.Cursor;
import static funcoes.Conexao.getConnection;

import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRSaveContributor;
import net.sf.jasperreports.view.JRViewer;
//import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {

    JRViewer jrViewer;
    Statement stmt;
    JButton btnSalvar;
    
    
    private final String PDF = "PDF (*.pdf)";
 
    private final String RTF = "RTF (*.rtf)";
 
    private final String HTML = "HTML (*.htm, *.html)";
 
    private final String XLS = "Single sheet XLS (*.xls)";
 
    private final String CSV = "CSV (*.csv)";
 
    private final String WORD = "DOCX (*.docx)";
 
    private final List<String> ALLOWED_FILE_TYPES = Arrays.asList(PDF, WORD, XLS, RTF, HTML, CSV);

    public void Relatorios() {
        this.jrViewer = (JRViewer) ((JPanel) ((JPanel) ((JLayeredPane) ((JRootPane) jrViewer.getComponent(0)).getComponent(0)).getComponent(0)).getComponent(0)).getComponent(0);
        JPanel pnlBotoes = (JPanel) jrViewer.getComponent(0);
        btnSalvar = (JButton) pnlBotoes.getComponent(0);
        btnSalvar.setSelected(true);
        btnSalvar.getActionListeners()[0].actionPerformed(new ActionEvent(btnSalvar, 0, null));
    }
    
    private void setListAllowedFileTypes(JasperViewer viewer) {
 
        Field jrViewerField;
 
        try {
 
            jrViewerField = viewer.getClass().getDeclaredField("viewer");
            jrViewerField.setAccessible(true);
 
            JRViewer jrViewer = (JRViewer) jrViewerField.get(viewer);
 
            List<JRSaveContributor> saveOptions = Arrays.asList(jrViewer.getSaveContributors());
 
            Iterator<JRSaveContributor> it = saveOptions.iterator();
 
            while (it.hasNext()) {
 
                JRSaveContributor jsc = it.next();
 
                if (ALLOWED_FILE_TYPES.contains(jsc.getDescription())) {
 
                    continue;
 
                } else {
 
                    jrViewer.removeSaveContributor(jsc);
 
                }
 
            }
 
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
 
          // logger.error(ex.getClass().getName(), ex);
 
        }
 
    }

    public void gerarRelatorio(ArrayList<ModeloRelatProposta> lista) {

        try {
            InputStream fonte = Relatorio.class.getResourceAsStream("/relatorios/RelatorioProposta.jrxml");

            JasperReport report = JasperCompileManager.compileReport(fonte);

            Map parametros = new HashMap();
            // parametros.clear();
            ImageIcon gto = new ImageIcon(getClass().getResource("/imagens/logoDracol.png"));
            parametros.put("logoDracol", gto.getImage());

            JasperPrint print = JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource(lista));
            
            
            JasperViewer jv = new JasperViewer(print, false);
            jv.setVisible(true);
            setListAllowedFileTypes(jv);
         //   JasperViewer.viewReport(print, false);

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

            JasperPrint jpPrint = JasperFillManager.fillReport(fonte, new HashMap(), relatResul);

            JasperViewer jv = new JasperViewer(jpPrint, false);

            jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
