import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfosVerdesTest {
    
    @Test
    public void elfoComDobroDeExperiencia(){
    ElfosVerdes ev1 = new ElfosVerdes("Guji");
    ev1.atirarFlecha(new Dwarf("Marquinhos"));
    assertTrue(ev1.getExperiencia() == 2);
    
    ev1.adicionarItem(new Item(3, "Espada de aço valiriano"));
    ev1.adicionarItem(new Item(2, "Arco e Flecha de Vidro"));
    assertTrue(ev1.getInventario().getListaItens().size() == 2);
    
    }
}
