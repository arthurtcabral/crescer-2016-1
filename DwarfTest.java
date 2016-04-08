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
    dwarf2.perdeVida();
    assertEquals(0, dwarf2.getVida());
    }
    
    @Test
    public void testaConstrutorEInventario(){
       
        //Testando se a data default foi adicionada
        Dwarf dwarf3 = new Dwarf("Joel");
        assertTrue(dwarf3.getDataNascimento().getDia() == 1 && dwarf3.getDataNascimento().getMes() == 1 && dwarf3.getDataNascimento().getAno() == 1);
        
        //Testando construtor que recebe um objeto do tipo DataTerceiraEra
        DataTerceiraEra dataNascimento = new DataTerceiraEra(9, 9, 1952);
        Dwarf dwarf4 = new Dwarf("Maria", dataNascimento);
        assertTrue(dwarf4.getDataNascimento().getDia() == 9 && dwarf4.getDataNascimento().getMes() == 9 && dwarf4.getDataNascimento().getAno() == 1952);
   
        //Testando se o inventario foi criado para o dwarf5 e se é possível adicionar e remover itens
        Dwarf dwarf5 = new Dwarf("Cléia");
        Item item1 = new Item(2, "Garrafa de Conhaque");
        Item item2 = new Item(1, "Machado");
        dwarf5.setInventario();
        dwarf5.getInventario().adicionarItem(item1);
        dwarf5.getInventario().adicionarItem(item2);
        assertTrue(dwarf5.getInventario().getListaItens().get(0) == item1);
        assertTrue(dwarf5.getInventario().getListaItens().size() == 2);
        
       dwarf5.getInventario().removerItem(item2);
       assertTrue(dwarf5.getInventario().getListaItens().size() == 1);
        
        //Testando se o código mudou o status inicial da variável inventario
        assertTrue(dwarf5.getInventario() != null);
        
        
    
    }
    
}
