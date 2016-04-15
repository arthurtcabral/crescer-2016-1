import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArteDaGuerraTest {
    
    @After
    public void tearDown(){
    System.gc();            
    }
    
    @Test
    public void listarElfosQueAtacaram(){
        ArrayList<Dwarf> listaDwarves = new ArrayList<Dwarf>();
        listaDwarves.add(new Dwarf("Hach"));
        listaDwarves.add(new Dwarf("Hech"));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfoNoExercito(new ElfosVerdes("Elfo Verde 1"));
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 1"));
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 2"));
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 3"));
        
        Estrategias estrategia = new ArteDaGuerra();
        ArrayList<Elfo> elfosQueAtacaram = estrategia.estrategia(listaDwarves, exercito);
        assertTrue(elfosQueAtacaram.size() == 2);
    }
    
    @Test
    public void ataqueSoComVerdes(){
        ArrayList<Dwarf> listaDwarves = new ArrayList<Dwarf>();
        listaDwarves.add(new Dwarf("Hach"));
        listaDwarves.add(new Dwarf("Hech"));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfoNoExercito(new ElfosVerdes("Elfo Verde 1"));
        exercito.alistarElfoNoExercito(new ElfosVerdes("Elfo Verde 2"));
        exercito.alistarElfoNoExercito(new ElfosVerdes("Elfo Verde 3"));
        exercito.alistarElfoNoExercito(new ElfosVerdes("Elfo Verde 4"));
        
        
        Estrategias estrategia = new ArteDaGuerra();
        ArrayList<Elfo> elfosQueAtacaram = estrategia.estrategia(listaDwarves, exercito);
        assertTrue(elfosQueAtacaram.size() == 4);
    }
    
    @Test
    public void ataqueSoComNoturnos(){
        ArrayList<Dwarf> listaDwarves = new ArrayList<Dwarf>();
        listaDwarves.add(new Dwarf("Hach"));
        listaDwarves.add(new Dwarf("Hech"));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 1"));
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 2"));
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 3"));
        exercito.alistarElfoNoExercito(new ElfosNoturnos("Elfo Noturno 4"));
        
        
        Estrategias estrategia = new ArteDaGuerra();
        ArrayList<Elfo> elfosQueAtacaram = estrategia.estrategia(listaDwarves, exercito);
        assertTrue(elfosQueAtacaram.size() == 1);
    }
}
