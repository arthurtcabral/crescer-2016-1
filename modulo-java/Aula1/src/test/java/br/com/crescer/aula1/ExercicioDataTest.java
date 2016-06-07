/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author arthur.cabral
 */
public class ExercicioDataTest {

    public ExercicioDataTest() {
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

    @org.junit.Test
    public void testGetDateTime() {
        ExercicioData instance = new ExercicioData();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        assertEquals(instance.getDateTime(), dateFormat.format(date));
    }

    @org.junit.Test
    public void testDiaDaSemana() throws ParseException {
        ExercicioData instance = new ExercicioData();
        String date = "25/09/1996";
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date resultado = df.parse(date);
        assertEquals(4, instance.diaDaSemana(resultado));
    }

}
