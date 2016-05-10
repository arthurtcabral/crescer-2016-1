import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    
    @After
    public void tearDown(){
    System.gc();            //Limpar objetos a cada teste
    }
    
   @Test
   public void testaConstrutor1(){
       Elfo e1 = new Elfo("Dobby");
       int esperado = 42;
       int obtido = e1.getFlechas();
       assertEquals(esperado, obtido);
       
    }
    
   @Test
   public void testaConstrutor2(){
       Elfo e2 = new Elfo("Monstro", 50);
       int esperado = 50;
       int obtido = e2.getExperiencia();
       assertEquals(esperado, obtido);
       
    }
    
   @Test
   public void testaAtirarFlecha(){
       Elfo e3 = new Elfo("Légolas", 100);
       Dwarf d1 = new Dwarf("Dunga");
       
       e3.atirarFlecha(d1);
       
       int experienciaEsperada = 101;
       int experienciaObtida = e3.getExperiencia();
       assertTrue(e3.getExperiencia() == 101);
       
       int flechasEsperadas = 41;
       int flechasObtidas = e3.getFlechas();
       assertTrue(e3.getFlechas() == 41);
       
       assertTrue(d1.getVida() == 100.0);
    }
    
   @Test
   public void testaConstrutorDwarf(){
       Dwarf d1 = new Dwarf("Mestre");
       double esperado = 110;
       double obtido = d1.getVida();
       assertTrue(d1.getVida() == 110);
       
    }
    
    @Test
    public void contador(){
    Elfo e10 = new Elfo("Goiás");
    assertEquals(1, Elfo.cont);
    
    }
   
}
