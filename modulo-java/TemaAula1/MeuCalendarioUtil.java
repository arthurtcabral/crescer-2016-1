

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MeuCalendarioUtil {

    private static final String[] dias = {"Domingo", "Segunda", "Terça", "Quarta",
        "Quinta", "Sexta", "Sábado"};

    public String diaDaSemana(Date dataDeNascimento) {
        Calendar c = Calendar.getInstance();
        c.setTime(dataDeNascimento);
        int dia = c.get(Calendar.DAY_OF_WEEK);
        return (dias[dia - 1]);
    }

    public String tempoDecorrido(Date data) {
        int dias = 0;
        int meses = 0;
        int anos = 0;
        
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(data);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(new Date());

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        int diffDay = diffMonth * 30 + endCalendar.get(Calendar.DAY_OF_MONTH) - startCalendar.get(Calendar.DAY_OF_MONTH);
        
        for(int i = 1; i <= diffDay; i++){
            dias++;
            if(dias == 30){
                dias = 0;
                meses++;
                if(meses == 12){
                    meses = 0;
                    anos++;
                }
            }
        }
        
        return anos + " ano(s), " + meses + " mes(es) + " + dias + " dia(s)"; 
    }

}
