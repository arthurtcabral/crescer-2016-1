import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SindarinParaPortuguesTest
{
   
    @Test
    public void traduzirNaurParaPortugues(){
    TradutorSindarin tradutorPortugues = new SindarinParaPortugues(); // Interface não é classe. Faça POLIMORFISMO 
    assertEquals("fogo", tradutorPortugues.traduzir("naur"));
    }
}
