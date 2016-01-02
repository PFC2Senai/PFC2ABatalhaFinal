package funcoes;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author S015365
 */
public class FuncoesDiversas {
    
    public static Time ConverterHora(String hora){
        Date data;
        Time time = null;
        
        try {
            SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
            data = formatador.parse(hora);
            time = new Time(data.getTime());
            
        } catch (ParseException ex) {
            Logger.getLogger(FuncoesDiversas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return time;   
    }
    
    public static Date FormataData(Date data) {
        Date d = null ;
        
        try {
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            String dt1 = formatter.format(data);
            
            d = (Date)formatter.parse(dt1);
            
        } catch (ParseException ex) {
            Logger.getLogger(FuncoesDiversas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
    public static Date ConverterData(String data){
        
        Date d = null ;
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            
            d = sdf.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(FuncoesDiversas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
}
