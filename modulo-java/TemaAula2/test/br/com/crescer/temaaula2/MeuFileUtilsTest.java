/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.temaaula2;

import br.com.crescer.file.MeuFileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arthur.cabral
 */
public class MeuFileUtilsTest {
    
    public MeuFileUtilsTest() {
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

    /**
     * Test of main method, of class MeuFileUtils.
     */
    @Test
    public void passarParametrosPeloMain() {
        String[] args = {"mk"};
        MeuFileUtils.main(args);
    }
    
}
