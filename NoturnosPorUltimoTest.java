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
        exercito.alistarElfoNoExercito(new ElfosVerdes("Elfo Verde 1"));
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 1"));
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 2"));
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 3"));
        
        Estrategias estrategia = new NoturnosPorUltimo();
        ArrayList<Elfo> elfosQueAtacaram = estrategia.atacar(listaDwarves, exercito);
        assertTrue(elfosQueAtacaram.get(0).getNome().equals("Elfo Verde 1"));
        assertTrue(elfosQueAtacaram.get(3).getNome().contains("Elfo Noturno"));
    }
    
    @Test
    public void checarListagemSoComElfosVerdes(){
        ArrayList<Dwarf> listaDwarves = new ArrayList<Dwarf>();
        listaDwarves.add(new Dwarf("Hach"));
        listaDwarves.add(new Dwarf("Hech"));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfoNoExercito(new ElfosVerdes("Elfo Verde 1"));
        exercito.alistarElfoNoExercito(new ElfosVerdes("Elfo Verde 2"));
        exercito.alistarElfoNoExercito(new ElfosVerdes("Elfo Verde 3"));
        
        Estrategias estrategia = new NoturnosPorUltimo();
        ArrayList<Elfo> elfosQueAtacaram = estrategia.atacar(listaDwarves, exercito);
        assertTrue(elfosQueAtacaram.get(0).getNome().equals("Elfo Verde 1"));
        assertTrue(elfosQueAtacaram.get(1).getNome().equals("Elfo Verde 2"));
        assertTrue(elfosQueAtacaram.get(2).getNome().equals("Elfo Verde 3"));
    }
    
    @Test
    public void checarListagemSoComElfosNoturnos(){
        ArrayList<Dwarf> listaDwarves = new ArrayList<Dwarf>();
        listaDwarves.add(new Dwarf("Hach"));
        listaDwarves.add(new Dwarf("Hech"));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 1"));
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 2"));
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 3"));
        
        Estrategias estrategia = new NoturnosPorUltimo();
        ArrayList<Elfo> elfosQueAtacaram = estrategia.atacar(listaDwarves, exercito);
        assertTrue(elfosQueAtacaram.get(0).getNome().contains("Noturno"));
        assertTrue(elfosQueAtacaram.get(1).getNome().contains("Noturno"));
        assertTrue(elfosQueAtacaram.get(2).getNome().contains("Noturno"));
    }
}
