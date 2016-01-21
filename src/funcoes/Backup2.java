package funcoes;

import groovy.json.StringEscapeUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.security.CodeSource;

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

            
             String semEspaco = aqui.replaceAll(" ", "\\");
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

            System.out.println("Aqui" + semEspaco);
            String nomeBkp = "BackupBancopfc1.sql";
            String dump = "cmd.exe /c mysqldump --user=root --password=2810 pfc1 >  '" + semEspaco + "/" + nomeBkp +"'";
            Runtime bkp = Runtime.getRuntime();
            System.out.println("tentando fazer backup");
            bkp.exec(dump);
            System.out.println("Backup realizado com sucesso!");
        } catch (IOException ex) {
            System.out.println("erro" + ex.getMessage());
        }

    }

    public static void main(String[] argv) throws IOException { 
        File folder = new File("C:\\Users\\Josy\\Desktop\\teste pasta com espaço"); 
        File[] listOfFiles = folder.listFiles(); 
        
        for (int i = 0; i < listOfFiles.length; i++) { 
            
            if (listOfFiles[i].isFile()) 
            { 
                File f = new File("C:\\Users\\Josy\\Desktop\\teste pasta com espaço"+listOfFiles[i].getName()); 
                f.renameTo(new File("c:\\Projects\\sample\\"+i+".txt")); 
            }
        } System.out.println("conversion is done"); 
    } 
}
