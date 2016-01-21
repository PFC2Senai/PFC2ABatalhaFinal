package funcoes;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;

/**
 *
 * @author Josy
 */
public class Backup2 {

    public static void backup() {
        try {
            File file = new File("C:/Users/Josy/Desktop/Backup");
            
            System.out.println("Criou arquivo");
            file.mkdir();
            String nomeBkp = "BackupBancopfc1.sql";
            String dump = "cmd.exe /c mysqldump --user=root --password=2810 pfc1 > Backup/" + nomeBkp;
            Runtime bkp = Runtime.getRuntime();
            System.out.println("tentando fazer backup");
            bkp.exec(dump);
            System.out.println("Backup realizado com sucesso!");
        } catch (IOException ex) {
            System.out.println("erro" + ex.getMessage());
        }
    }   
}
