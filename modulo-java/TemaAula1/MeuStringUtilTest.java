/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.temaaula1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arthur
 */
public class MeuStringUtilTest {
    
    public MeuStringUtilTest() {
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
    public void stringDeLengthZeroRetornaTrue() {
        String string = "";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = true;
        boolean result = instance.isEmpty(string);
        assertEquals(expResult, result);
    }
    
    @Test
    public void stringSemLetrasRetornaTrue() {
        String string = "     ";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = true;
        boolean result = instance.isEmpty(string);
        assertEquals(expResult, result);
    }
    
    @Test
    public void stringPreenchidaComLetrasRetornaFalse() {
        String string = "A  E  I  O  U";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = false;
        boolean result = instance.isEmpty(string);
        assertEquals(expResult, result);
    }

    @Test
    public void nenhumaVogalRetornaZero() {
        String string = "CRT";
        MeuStringUtil instance = new MeuStringUtil();
        int expResult = 0;
        int result = instance.contaVogais(string);
        assertEquals(expResult, result);
    }
    
    @Test
    public void comVogalNaoRetornaZero() {
        String string = "CWI";
        MeuStringUtil instance = new MeuStringUtil();
        int expResult = 1;
        int result = instance.contaVogais(string);
        assertEquals(expResult, result);
    }

    @Test
    public void imprimeString() {
        MeuStringUtil instance = new MeuStringUtil();
        String result = instance.inventaString();
        System.out.println(result);
    }
    
    @Test
    public void seEPalindromoRetornaTrue() {
        String string = "ovo";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = true;
        boolean result = instance.ePalindromo(string);
        assertEquals(expResult, result);
    }
    
    @Test
    public void seNaoEPalindromoRetornaFalse() {
        String string = "Arthur";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = false;
        boolean result = instance.ePalindromo(string);
        assertEquals(expResult, result);
    }
    
}
