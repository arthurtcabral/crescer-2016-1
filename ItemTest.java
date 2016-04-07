import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
  
    @Test
    public void testaItemEInventario(){
    Item item = new Item(5, "Bandagem");
    assertTrue(item.getQuantidade() == 5);
    assertTrue(item.getDescricao() == "Bandagem");
    
    Item item2 = new Item(2, "Garrafa");
    assertTrue(item2.getQuantidade() == 2);
    assertTrue(item2.getDescricao() == "Garrafa");
    
    Inventario inventario = new Inventario();
    inventario.adicionarItem(item);
    inventario.adicionarItem(item2);
    
    inventario.removerItem(item);
    }
}
