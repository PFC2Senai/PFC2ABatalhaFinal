package funcoes;


import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author Josy
 */
public class Agendamentos {

    private static int count = 0;

//    public static void main(String[] args) {
//        Agendamentos a = new Agendamentos();
//       // a.primeiraTarefa();
//       // a.segundaTarefa();
//        a.terceiraTarefa();
//    }

    private void primeiraTarefa() {
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Counting " + (++count) +
                        " Time: " + new Date()
                );
                new Execucoes().tabuada(count);
                if (count == 5) {
                    t.cancel();
                }
            }

        }, 5000, 3000);
    }
    
    private void segundaTarefa() {
        Calendar data = Calendar.getInstance();
         //2011 - ano
         //4 - mês (janeiro equivale a 0, fevereiro a 1, ..., dezembro a 11)
         //30 - dia
        data.set(2011, 4, 30);

        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Counting " + (++count) +
                        " Time: " + new Date()
                );
                new Execucoes().tabuada(count);
                t.cancel();
            }

        }, data.getTime() );
    }
    
    public void terceiraTarefa(Calendar data) {
        
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 22);
        c.set(Calendar.MINUTE, 31);
        c.set(Calendar.SECOND, 0);

        Date time = c.getTime();

        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Counting " + (++count) +
                        " Time: " + new Date()
                );
                new Execucoes().tabuada(count);
                t.cancel();
            }

        }, time );
    }
}
