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

//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//       
//        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//       
//                
//        if (hasFocus) {           
//           // comp.setBackground(new Color(9,144,247));
//           
//         //   setForeground(isSelected ? Color.white : Color.black);
//      
//            table.setSelectionBackground(new Color(9,144,247));
//        } else if (row % 2 == 0) {
//            comp.setBackground(new Color(221,241,182));
//        } else {
//            comp.setBackground(new Color(238,255,205));
//        }
//
//        return comp;		 
//    }
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Variaveis com as cores..*/
	private Color whiteColor = new Color(254, 254, 254);
	private Color alternateColor = new Color(204, 204, 204);
	private Color selectedColor = new Color(61, 128, 223);
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,boolean selecionado, boolean hasFocus, int row, int column) {
		super.getTableCellRendererComponent(table, value, selecionado, hasFocus,row, column);
		/*Cor de fundo*/
		Color bg;
		/*Quando selecionado a linha seta as cores */
		if (hasFocus) {
			bg = selectedColor;
			setBackground(bg);
			setForeground(selecionado ? Color.white : Color.black);
		}
		/*Quando não selecionado e o resultado do valor = 0, a linha seta as cores */
		else if (!selecionado){		
			bg = (row % 2 == 0 ? alternateColor : whiteColor);
		/*Quando não selecionado e o resultado do valor = 0, a linha seta as cores */
		}else{
		bg = selectedColor;
		setBackground(bg);
		setForeground(selecionado ? Color.white : Color.black);
		}
		/*
		 * if (value instanceof ImageIcon) { setIcon((ImageIcon) value);
		 * setText(""); } else setIcon(null);
		 */
		/*Retorna o objeto*/
		return this;
        }
}
