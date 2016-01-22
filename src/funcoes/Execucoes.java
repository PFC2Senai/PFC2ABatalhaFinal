package funcoes;

import java.io.File;

/**
 *
 * @author Josy
 */
public class Execucoes {

    public void tabuada(int valor) {
        for (int i = 1; i < 11; i++) {
            System.out.println(i + " * " + valor + " = " + (i * valor));
        }
    }

    public void BackupAutomatico() {
        
        File file = new File("C:/Users/Josy/Desktop/Backup");
        file.mkdir();
        String caminho = file.getAbsolutePath();
        ControleBackup app = new ControleBackup(caminho);
    }
}
