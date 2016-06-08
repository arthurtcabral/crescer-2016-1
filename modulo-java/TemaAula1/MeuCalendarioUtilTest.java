/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Arthur
 */
public class MeuCalendarioUtilTest {
    
    public MeuCalendarioUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void diaRetornadoDeveSerQuarta() throws ParseException {
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        String date = "25/09/1996";
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date resultado = df.parse(date);
        assertEquals("Quarta", instance.diaDaSemana(resultado));
    }

    @Test
    public void tempoDecorridoDeveSerIgualADataPassadaPorParametro() throws ParseException {
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        String date = "25/09/1996";
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date resultado = df.parse(date);
        assertEquals("19 ano(s), 8 mes(es) + 13 dia(s)", instance.tempoDecorrido(resultado));
        
    }
    
}
