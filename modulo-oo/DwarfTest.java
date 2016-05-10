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
    
    @Test
    public void testaGetNumeroSorte(){
    Dwarf anao = new Dwarf("Dengoso", new DataTerceiraEra(1, 1, 2000));
    assertTrue(anao.getNumeroSorte() == 101.0);
    
    Dwarf anao2 = new Dwarf("Dengoso", new DataTerceiraEra(1, 1, 2004));
    anao2.setVida(80);
    assertTrue(anao2.getNumeroSorte() == (101.0 * (-33)));
    
    Dwarf anao3 = new Dwarf("Seixas", new DataTerceiraEra(1, 1, 1001));
    anao3.setVida(80);
    assertTrue(anao2.getNumeroSorte() == (101.0 * (-33)));
    
    Dwarf anao4 = new Dwarf("Meireles", new DataTerceiraEra(1, 1, 1005));
    anao4.setVida(80);
    assertTrue(anao2.getNumeroSorte() == (101.0 * (-33)));
    
    }
    
    @Test
    public void testaVidaExercicio6(){
    Dwarf d1 = new Dwarf("Soneca", new DataTerceiraEra(1, 1, 2000));
    d1.perdeVida();
    assertTrue(d1.getVida() == 100);
    
    Dwarf d2 = new Dwarf("Esteves", new DataTerceiraEra(1, 1, 2004));
    d2.setVida(90);
    d2.perdeVida();
    assertTrue(d2.getExperiencia() == 2);
    
    Dwarf d3 = new Dwarf("Seixas", new DataTerceiraEra(1, 1, 1001));
    d3.perdeVida();
    assertTrue(d3.getVida() == 110);
    
    Dwarf d4 = new Dwarf("Meireles", new DataTerceiraEra(1, 1, 1005));
    d4.perdeVida();
    assertTrue(d4.getExperiencia() == 0);
    
    }
    
    @Test
    public void tentarSorte(){
    Dwarf amiguinho = new Dwarf("Amiguinho", new DataTerceiraEra(2, 2, 2004));
    amiguinho.setInventario();
    amiguinho.getInventario().adicionarItem(new Item(1, "Pote de Mel"));
    amiguinho.setVida(80);
    amiguinho.tentarSorte();
    assertTrue(amiguinho.getInventario().getListaItens().get(0).getQuantidade() == 1001);
    }
    
}
