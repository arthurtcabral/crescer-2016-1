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
        exercito.alistarElfoNoExercito(new ElfoVerde("Elfo Verde 1"));
        exercito.alistarElfoNoExercito(new ElfoNoturno("Elfo Noturno 1"));
        exercito.alistarElfoNoExercito(new ElfoVerde("Elfo Verde 2"));
        exercito.alistarElfoNoExercito(new ElfoNoturno("Elfo Noturno 2"));
        
        Estrategias estrategia = new AtaqueIntercalado();
        ArrayList<Elfo> elfosQueAtacaram = estrategia.atacar(listaDwarves, exercito);
        assertTrue(elfosQueAtacaram.get(0).getNome().contains("Verde"));
        assertTrue(elfosQueAtacaram.get(1).getNome().contains("Noturno"));
        assertTrue(elfosQueAtacaram.get(2).getNome().contains("Verde"));
        assertTrue(elfosQueAtacaram.get(3).getNome().contains("Noturno"));
    }
    
    @Test
    public void soOTipoVerdeNaoDeveAtacar(){
        ArrayList<Dwarf> listaDwarves = new ArrayList<Dwarf>();
        listaDwarves.add(new Dwarf("Hach"));
        listaDwarves.add(new Dwarf("Hech"));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfoNoExercito(new ElfoVerde("Elfo Verde 1"));
        exercito.alistarElfoNoExercito(new ElfoVerde("Elfo Verde 2"));
        
        Estrategias estrategia = new AtaqueIntercalado();
        ArrayList<Elfo> elfosQueAtacaram = estrategia.atacar(listaDwarves, exercito);
        assertTrue(elfosQueAtacaram == null);
    }
    
    @Test
    public void soOTipoNoturnoNaoDeveAtacar(){
        ArrayList<Dwarf> listaDwarves = new ArrayList<Dwarf>();
        listaDwarves.add(new Dwarf("Hach"));
        listaDwarves.add(new Dwarf("Hech"));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfoNoExercito(new ElfoNoturno("Elfo Noturno 1"));
        exercito.alistarElfoNoExercito(new ElfoNoturno("Elfo Noturno 2"));
        
        Estrategias estrategia = new AtaqueIntercalado();
        ArrayList<Elfo> elfosQueAtacaram = estrategia.atacar(listaDwarves, exercito);
        assertTrue(elfosQueAtacaram == null);
    }
    
    @Test
    public void exercitoComNumeroImparDeElfosNaoPodeAtacarVersaoCom2Noturnos(){
        ArrayList<Dwarf> listaDwarves = new ArrayList<Dwarf>();
        listaDwarves.add(new Dwarf("Hach"));
        listaDwarves.add(new Dwarf("Hech"));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfoNoExercito(new ElfoNoturno("Elfo Noturno 1"));
        exercito.alistarElfoNoExercito(new ElfoNoturno("Elfo Noturno 2"));
        exercito.alistarElfoNoExercito(new ElfoVerde ("Elfo Verde 1"));
        
        Estrategias estrategia = new AtaqueIntercalado();
        ArrayList<Elfo> elfosQueAtacaram = estrategia.atacar(listaDwarves, exercito);
        assertTrue(elfosQueAtacaram == null);
    }
    
    @Test
    public void exercitoComNumeroImparDeElfosNaoPodeAtacarVersaoCom2Verdes(){
        ArrayList<Dwarf> listaDwarves = new ArrayList<Dwarf>();
        listaDwarves.add(new Dwarf("Hach"));
        listaDwarves.add(new Dwarf("Hech"));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfoNoExercito(new ElfoVerde ("Elfo Verde 1"));
        exercito.alistarElfoNoExercito(new ElfoNoturno("Elfo Noturno 1"));
        exercito.alistarElfoNoExercito(new ElfoVerde ("Elfo Verde 2"));
        
        Estrategias estrategia = new AtaqueIntercalado();
        ArrayList<Elfo> elfosQueAtacaram = estrategia.atacar(listaDwarves, exercito);
        assertTrue(elfosQueAtacaram == null);
    }
    
}
