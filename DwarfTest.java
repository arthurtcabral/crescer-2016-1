import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
   
    @Test
    public void dwarfNasceVivo(){
    Dwarf dwarf = new Dwarf("Balin");
    assertEquals(Status.VIVO, dwarf.getStatus());
    }
    
    @Test
    public void dwarfMorre(){
    Dwarf dwarf2 = new Dwarf("Kenny");
    dwarf2.perdeVida();
    dwarf2.perdeVida();
    dwarf2.perdeVida();
    dwarf2.perdeVida();
    dwarf2.perdeVida();
    dwarf2.perdeVida();
    dwarf2.perdeVida();
    dwarf2.perdeVida();
    dwarf2.perdeVida();
    dwarf2.perdeVida();
    dwarf2.perdeVida();
    assertEquals(Status.MORTO, dwarf2.getStatus());
    }
    
}
