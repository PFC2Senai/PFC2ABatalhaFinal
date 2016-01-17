
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Main extends JPanel implements FocusListener {

    public Main() {
        
        JTextField textField = new JTextField("A TextField");
        textField.addFocusListener(this);
        
        JLabel label = new JLabel("A Label");
        label.addFocusListener(this);
        
        add(label);
        
        String comboPrefix = "ComboBox Item #";
        final int numItems = 15;
        Vector vector = new Vector(numItems);
        
        for (int i = 0; i < numItems; i++) {
            vector.addElement(comboPrefix + i);
        }
        
        JComboBox comboBox = new JComboBox(vector);
        
        comboBox.addFocusListener(this);
        add(comboBox);
        
        
        JButton button = new JButton("A Button");
        button.addFocusListener(this);
        add(button);
        String listPrefix = "List Item #";
        Vector listVector = new Vector(numItems);
        
        for (int i = 0; i < numItems; i++) {
            listVector.addElement(listPrefix + i);
        }
        
        JList list = new JList(listVector);
        list.setSelectedIndex(1);
        list.addFocusListener(this);
        JScrollPane listScrollPane = new JScrollPane(list);
        
        listScrollPane.getVerticalScrollBar().setFocusable(false);
        listScrollPane.getHorizontalScrollBar().setFocusable(false);
        
        add(listScrollPane);
        setPreferredSize(new Dimension(450, 450));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    void displayMessage(String prefix, FocusEvent e) {
        System.out.println(prefix + (e.isTemporary() ? " (temporary):" : ":") + e.getComponent().getClass().getName() + "; Opposite component: " + (e.getOppositeComponent() != null ? e.getOppositeComponent().getClass().getName() : "null"));
    }

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("FocusEventDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JComponent newContentPane = new Main();
        
        newContentPane.setOpaque(true); // content panes must be opaque 
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent e) {
        displayMessage("Focus gained", e);
    }

    @Override
    public void focusLost(FocusEvent e) {
        displayMessage("Focus lost", e);
    }
}
