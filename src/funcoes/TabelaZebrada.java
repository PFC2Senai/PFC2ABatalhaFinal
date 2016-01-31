package funcoes;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Josy
 */
public class TabelaZebrada extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       
        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
       
                
        if (isSelected) {     
            table.setSelectionBackground(new Color(9,144,247));
        } else if (row % 2 == 0) {
            comp.setBackground(new Color(238,255,205));
        } else {
            comp.setBackground(new Color(243,252,224));
        }
        return comp;		 
    }
}
