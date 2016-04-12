import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfosNoturnosTest
{
   
    @Test
    public void elfoNoturnoAtiraFlecha(){
    ElfosNoturnos ef1 = new ElfosNoturnos("NightElf");
    ef1.atirarFlecha(new Dwarf("Chico Louco"));
    assertTrue(ef1.getVida() == 95.0);
    }
    
    /* Exercício 7.2
     * 
     * Atualmente, os Elfos Noturnos não podem morrer atirando flechas, porém, ficam com a vida pequena
     * Isso se deve ao fato do número ir fragmentando-se cada vez mais (diminuindo 5% da vida restante), aproximando-se do 0, porém nunca chegando em zero
     * 
     */
    
    @Test
    public void elfoNoturnoFaleceQuandoVidaForZerada(){
    ElfosNoturnos ef2 = new ElfosNoturnos("Nieme");
    ef2.setVida(1.0); // setVida() elaborado para o teste da nova funcionalidade (Morte do Elfo Noturno ao atirar flechas).
    ef2.atirarFlecha(new Dwarf("Arnoizes"));
    assertTrue(ef2.getStatus().equals(Status.MORTO));
    }
}
