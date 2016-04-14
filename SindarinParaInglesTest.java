import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SindarinParaInglesTest
{
   
    @Test
    public void traduzirNaurParaIngles(){
    TradutorSindarin tradutorIngles = new SindarinParaIngles(); // Interface não é classe. Faça POLIMORFISMO 
    assertEquals("fire", tradutorIngles.traduzir("naur"));
    }
}
