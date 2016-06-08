
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Parcelator {
    
    public void parcelas(double valor, double juros, int numParcelas, Date vencimento){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(vencimento);
        double valorParcelado = Math.round(valor / numParcelas);
        valorParcelado = valorParcelado + ((juros / 100) * valorParcelado);
        String date = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
        System.out.println("1- " + date + " - R$" + valorParcelado);
        calendar.add(Calendar.MONTH, 1);
        for(int i = 2; i <= numParcelas; i++){
            date = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
            System.out.println(i + "- " + date + " - R$" + valorParcelado);
            calendar.add(Calendar.MONTH, 1);
        }
    }
    
}
