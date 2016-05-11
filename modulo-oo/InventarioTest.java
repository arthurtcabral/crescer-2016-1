import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
   
    @Test
    public void listaItensEmUmaString(){
    Item item = new Item(1, "Adaga");
    Item item2 = new Item(1, "Escudo");
    Item item3 = new Item(1, "Bracelete");
    Inventario i1 = new Inventario();
    i1.adicionarItem(item);
    i1.adicionarItem(item2);
    i1.adicionarItem(item3);
    assertTrue(i1.getDescricoesItens().equals("Adaga, Escudo, Bracelete"));
    }
    
    @Test
    public void itemPopular(){
    Item i1 = new Item(1, "Maçã");
    Item i2 = new Item(5, "Caqui");
    Inventario inventario = new Inventario();
    inventario.adicionarItem(i1);
    inventario.adicionarItem(i2);
    assertTrue(inventario.itemMaiorQuantidade() == i2);
     }
}
