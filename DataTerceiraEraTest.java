import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void testaTudo(){
   
    //Teste do construtor    
    DataTerceiraEra teste = new DataTerceiraEra(1, 1, 1004);
    int diaEsperado = 1;
    int mesEsperado = 1;
    int anoEsperado = 1004;
    int diaObtido = teste.getDia();
    int mesObtido = teste.getMes();
    int anoObtido = teste.getAno();
    assertEquals(diaEsperado, diaObtido);
    assertEquals(mesEsperado, mesObtido);
    assertEquals(anoEsperado, anoObtido);
    
    //Teste do método ehBissexto() (tendo um ano bissexto em uso)
    boolean esperado = true;
    boolean obtido = teste.ehBissexto();
    assertEquals(esperado, obtido);
    
    //Teste do método ehBissexto() (tendo um ano não bissexto em uso)
    DataTerceiraEra teste2 = new DataTerceiraEra(1, 1, 1900);
    boolean esperado2 = false;
    boolean obtido2 = teste2.ehBissexto();
    assertEquals(esperado2, obtido2);
    }
}
