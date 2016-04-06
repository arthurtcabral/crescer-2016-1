import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
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
       assertEquals(experienciaEsperada, experienciaObtida);
       
       int flechasEsperadas = 41;
       int flechasObtidas = e3.getFlechas();
       assertEquals(flechasEsperadas, flechasObtidas);
       
       
       int vidaEsperada = 100;
       int vidaObtida = d1.getVida();
       assertEquals(vidaEsperada, vidaObtida);
       
    }
    
   @Test
   public void testaConstrutorDwarf(){
       Dwarf d1 = new Dwarf("Mestre");
       int esperado = 110;
       int obtido = d1.getVida();
       assertEquals(esperado, obtido);
       
    }
   
}
