/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

            super.insertString(offset, str.replaceAll("[^a-z]", ""), attr);
            return;
        }

        String nova = str.substring(0, getLength() - tamanhoMax);
        super.insertString(offset, nova, attr);

    }

}
