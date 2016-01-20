package funcoes;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author FelipeW7
 */
public class LimitarDigitos extends PlainDocument {

    private int tamanhoMax;

    public LimitarDigitos(int maxLen) {

        super();
        if (maxLen <= 0) {
            throw new IllegalArgumentException("Especifique a quantidade");
        }
        tamanhoMax = maxLen;

    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {

        if (str == null || getLength() == tamanhoMax) {
            return;
        }
        int totalquant = (getLength() + str.length());
        if (totalquant <= tamanhoMax) {

            super.insertString(offset, str.replaceAll("[^a-z],[^A-Z]", ""), attr);
            return;
        }

        String nova = str.substring(0, getLength() - tamanhoMax);
        super.insertString(offset, nova, attr);

    }

    ///
    public void insertInt(int offset, String str, AttributeSet attr)
            throws BadLocationException {

        if (str == null || getLength() == tamanhoMax) {
            return;
        }
        int totalquant = (getLength() + str.length());
        if (totalquant <= tamanhoMax) {

            super.insertString(offset, str.replaceAll("[^0-9]", ""), attr);
            return;
        }

        String nova = str.substring(0, getLength() - tamanhoMax);
        super.insertString(offset, nova, attr);

    }

}
