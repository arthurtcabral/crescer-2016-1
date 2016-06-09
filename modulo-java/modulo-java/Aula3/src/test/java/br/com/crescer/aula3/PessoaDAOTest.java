package br.com.crescer.aula3;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PessoaDAOTest {
    
    public PessoaDAOTest() {
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

//    @Test
//    public void inserirPessoaDeNomeTeste() {
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNome("TESTE");
//        PessoaDAO instance = new PessoaDAO();
//        instance.insert(pessoa);
//        List<Pessoa> pessoas = new ArrayList<Pessoa>();
//        pessoas = instance.findNome("TESTE");
//        assertEquals(pessoas.get(0).getNome(), "TESTE");
//    }
    
//    @Test
//    public void atualizarPessoaDeNomeTeste() {
//        Pessoa pessoa = new Pessoa();
//        pessoa.setId(3L);
//        pessoa.setNome("TESTEATUALIZADO");
//        PessoaDAO instance = new PessoaDAO();
//        instance.update(pessoa);
//        List<Pessoa> pessoas = new ArrayList<Pessoa>();
//        pessoas = instance.findNome("TESTEATUALIZADO");
//        assertEquals(pessoas.get(0).getNome(), "TESTEATUALIZADO");
//    }
    
    @Test
    public void buscarTodos() {
        Pessoa pessoa = new Pessoa();
        PessoaDAO instance = new PessoaDAO();
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas = instance.listAll();
        assertEquals(pessoas.get(0).getNome(), "ARTHUR TC");
        assertEquals(pessoas.get(1).getNome(), "TESTEATUALIZADO");
        assertEquals(pessoas.get(2).getNome(), "TESTE");
        assertEquals(pessoas.get(3).getNome(), "ARTHUR");
    }
    
}
