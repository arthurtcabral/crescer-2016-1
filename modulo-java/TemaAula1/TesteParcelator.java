
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TesteParcelator {
 
     
    public static void main(String[] args) throws ParseException {
        
       Parcelator p = new Parcelator();
        
        String date = "01/06/2016";
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date resultado = df.parse(date);
        p.parcelas(1000.0, 10.0, 10, resultado);
    }
    
}
