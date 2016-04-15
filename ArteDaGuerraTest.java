import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArteDaGuerraTest {
    
    @Test
    public void listarElfosQueAtacaram(){
        ArrayList<Dwarf> listaDwarves = new ArrayList<Dwarf>();
        listaDwarves.add(new Dwarf("Hach"));
        listaDwarves.add(new Dwarf("Hech"));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfoNoExercitoSemRestricoes(new Elfo("Elfo"));
        exercito.alistarElfoNoExercitoSemRestricoes(new ElfosNoturnos("Elfo Noturno 1"));
        exercito.alistarElfoNoExercitoSemRestricoes(new ElfosNoturnos("Elfo Noturno 2"));
        exercito.alistarElfoNoExercitoSemRestricoes(new ElfosNoturnos("Elfo Noturno 3"));
        
        Estrategias estrategia = new ArteDaGuerra();
        ArrayList<Elfo> elfosQueAtacaram = estrategia.estrategia(listaDwarves, exercito);
        assertTrue(elfosQueAtacaram.size() == 3);
    }
}
