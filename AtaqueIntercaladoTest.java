import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtaqueIntercaladoTest {
   
    @After
    public void tearDown(){
    System.gc();            
    }
    
    @Test
    public void listarIntercaladamenteOsElfos(){
        ArrayList<Dwarf> listaDwarves = new ArrayList<Dwarf>();
        listaDwarves.add(new Dwarf("Hach"));
        listaDwarves.add(new Dwarf("Hech"));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfoNoExercito(new ElfosVerdes("Elfo Verde 1"));
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 1"));
        exercito.alistarElfoNoExercito(new ElfosVerdes("Elfo Verde 2"));
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 2"));
        
        Estrategias estrategia = new AtaqueIntercalado();
        ArrayList<Elfo> elfosQueAtacaram = estrategia.estrategia(listaDwarves, exercito);
        assertTrue(elfosQueAtacaram.get(0).getNome().contains("Verde"));
        assertTrue(elfosQueAtacaram.get(1).getNome().contains("Noturno"));
        assertTrue(elfosQueAtacaram.get(2).getNome().contains("Verde"));
        assertTrue(elfosQueAtacaram.get(3).getNome().contains("Noturno"));
    }
    
}
