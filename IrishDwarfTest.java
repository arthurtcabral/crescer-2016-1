import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    
    @Test
    public void sorteIrishDwarf(){
        IrishDwarf id = new IrishDwarf("Gloen", new DataTerceiraEra(1, 1, 2004));
        id.setInventario();
        id.getInventario().adicionarItem(new Item(3, "Chapéu"));
        id.getInventario().adicionarItem(new Item(2, "Picareta"));
        id.setVida(90);
        id.tentarSorte();
        assertTrue(id.getInventario().getListaItens().get(0).getQuantidade() == 6003);
        assertTrue(id.getInventario().getListaItens().get(1).getQuantidade() == 3002);
    }
}
