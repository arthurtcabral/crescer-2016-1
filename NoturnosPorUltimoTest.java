import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NoturnosPorUltimoTest {
    
    @After
    public void tearDown(){
    System.gc();            
    }
    
    @Test
    public void checarListagemDeElfosQueAtacaram(){
        ArrayList<Dwarf> listaDwarves = new ArrayList<Dwarf>();
        listaDwarves.add(new Dwarf("Hach"));
        listaDwarves.add(new Dwarf("Hech"));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfoNoExercitoSemRestricoes(new ElfosVerdes("Elfo Verde 1"));
        exercito.alistarElfoNoExercitoSemRestricoes(new ElfosNoturnos("Elfo Noturno 1"));
        exercito.alistarElfoNoExercitoSemRestricoes(new ElfosNoturnos("Elfo Noturno 2"));
        exercito.alistarElfoNoExercitoSemRestricoes(new ElfosNoturnos("Elfo Noturno 3"));
        exercito.alistarElfoNoExercitoSemRestricoes(new Elfo("Elfo Comum 1"));
        
        Estrategias estrategia = new NoturnosPorUltimo();
        ArrayList<Elfo> elfosQueAtacaram = estrategia.estrategia(listaDwarves, exercito);
        assertTrue(elfosQueAtacaram.get(0).getNome().equals("Elfo Verde 1"));
        assertTrue(elfosQueAtacaram.get(1).getNome().equals("Elfo Comum 1"));
        assertTrue(elfosQueAtacaram.get(4).getNome().contains("Elfo Noturno"));
    }
    
}
