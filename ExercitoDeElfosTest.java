import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest {
    
    @After
    public void tearDown(){
    System.gc();            
    }
    
    @Test
    public void alistarElfoVerdeEElfoNoturnoNoExercito(){
    ElfosVerdes elfoVerde = new ElfosVerdes("ElfoVerde");
    ElfosNoturnos elfoNoturno = new ElfosNoturnos("ElfoNoturno");
    ExercitoDeElfos exercito = new ExercitoDeElfos();
    exercito.alistarElfoNoExercito(elfoVerde);
    exercito.alistarElfoNoExercito(elfoNoturno);
    
    assertTrue(exercito.getExercitoDeElfos().size() == 2);
    
    }
    
    @Test
    public void alistarElfoComumDeveSerImpossivel(){
    ElfosVerdes elfoVerde = new ElfosVerdes("ElfoVerde");
    ElfosNoturnos elfoNoturno = new ElfosNoturnos("ElfoNoturno");
    ElfosNoturnos elfoNoturno2 = new ElfosNoturnos("ElfoNoturno2");
    Elfo elfo = new Elfo("Elfo comum");
    ExercitoDeElfos exercito = new ExercitoDeElfos();
    exercito.alistarElfoNoExercito(elfoVerde);
    exercito.alistarElfoNoExercito(elfoNoturno);
    exercito.alistarElfoNoExercito(elfo);
    exercito.alistarElfoNoExercito(elfoNoturno2);
    
    assertTrue(exercito.getExercitoDeElfos().size() == 3);
    
    }

    @Test
    public void agrupandoPorStatus(){
    ElfosVerdes elfoVerde = new ElfosVerdes("ElfoVerde");
    ElfosNoturnos elfoNoturno = new ElfosNoturnos("ElfoNoturno");
    ElfosNoturnos elfoNoturno2 = new ElfosNoturnos("ElfoNoturno2");
    ExercitoDeElfos exercito = new ExercitoDeElfos();
    exercito.alistarElfoNoExercito(elfoVerde);
    exercito.alistarElfoNoExercito(elfoNoturno);
    exercito.alistarElfoNoExercito(elfoNoturno2);
    exercito.agruparPorStatus();
    
    System.out.println(exercito.getAgrupadoPorStatus().keySet() == Status.VIVO);
    
    // assertTrue(exercito.getAgrupadoPorStatus().values().size() == 3);
    }
    
}   











