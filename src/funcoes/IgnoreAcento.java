//package funcoes;
//
//import java.util.*;
//import java.text.*;
///**
// *
// * @author Josy
// */
//public class IgnoreAcento {
//
//        
//        // Vamos comparar duas strings ignorando os acentos.
//        String st1 = "Gisele da Conceição Zózima Bündchen";
//        String st2 = "Gisele da Conceicao Zozima Bundchen";
//        String st3 = "GISELE DA CONCEICAO ZÓZIMA BUNDCHEN";
//        String st4 = "Gisele da Conceicao Zozimo Bundchen"; // note que esta string é diferente
//        
//        Collator collator = Collator.getInstance (new Locale ("pt", "BR"));
//        collator.setStrength(Collator.PRIMARY); // importante!
//        
//        if (collator.compare (st1, st2) == 0) {
//            System.out.println ("As duas Giseles são a mesma pessoa, só diferem pelos acentos");
//        }
//        
//        if (collator.compare (st1, st3) == 0) {
//            System.out.println ("As duas Giseles são a mesma pessoa, só diferem pelos acentos e pela diferença de caixa");
//        }
//        
//        if (collator.compare (st1, st4) != 0) {
//            System.out.println ("As duas Giseles não são a mesma pessoa");
//        }
//
//        // Agora vamos mostrar um exemplo de ordenação ignorando os acentos.
//        String[] dados = {
//            "José Aparecido",
//            "João Simões",
//            "Jó Abedenego"
//        };
//        // Não usando "collator"
//        SortedSet<String> s1 = new TreeSet<String>();
//        
//        for (String d : dados) {
//            s1.add (d);
//        }
//        // Deve imprimir [José Aparecido, João Simões, Jó Abedenego], que é 
//        // ao contrário das regras da língua portuguesa
//        System.out.println (s1);
//        // Usando "collator", segue as regras:
//        // imprime "[Jó Abedenego, João Simões, José Aparecido]"
//        final Collator coll = Collator.getInstance (new Locale ("pt", "BR"));
//        SortedSet<String> s2 = new TreeSet<String>(new Comparator<String>() {
//            public int compare (String o1, String o2) {
//                return coll.compare (o1, o2);
//         
//        for (String d : dados) {
//            s2.add (d);
//        }
//        System.out.println (s2);
//        // O código abaixo é equivalente e mais simples, 
//        // porque Collator implementa Comparator.
//        s2 = new TreeSet<String>(coll);
//        System.out.println (s2);
//    }
//}
//                }