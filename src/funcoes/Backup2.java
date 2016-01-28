package funcoes;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Josy
 */
public class Backup2 {



    public static void backup(String caminhoPasta) {
        
        try {

            File file = new File(caminhoPasta);

//            File file = new File("C:/Users/Josy/Desktop/Backup pasta");    // Arquivo ou diretório com novo nome
            file.mkdir();

            String aqui = file.getAbsolutePath();

            
            // String semEspaco = aqui.replaceAll(" ", "");
//
//            System.out.println("Pasta sem espaço " + semEspaco);
//            boolean success;
//            File file2 = new File(semEspaco);    // Renomeando arquivo ou diretório   
//
//            success = file.renameTo(file2);
//
//            if (!success) {
//                System.out.println("Erro ao renomear a pasta.");
//            }
//
//            System.out.println("Criou arquivo");
//
//            String caminho = file2.getPath();

          //  System.out.println("Aqui" + semEspaco);
            String nomeBkp = "BackupBancopfc1.sql";
            String dump = "cmd.exe /c mysqldump --user=root --password=2810 pfc1 >  " + aqui + "/" + nomeBkp +"";
            Runtime bkp = Runtime.getRuntime();
            System.out.println("tentando fazer backup");
            bkp.exec(dump);
            System.out.println("Backup realizado com sucesso!");
        } catch (IOException ex) {
            System.out.println("erro" + ex.getMessage());
        }

    }
}
