import java.util.ArrayList;

public class Inventario
{
    private ArrayList<Item> listaItens = new ArrayList<Item>();
    // private Item item;
    
    public Inventario(){
    }
    
    public ArrayList getListaItens(){
    return this.listaItens;
    }
    
    public void adicionarItem(Item item){
        this.listaItens.add(item);
        
    }
    
    public void removerItem(Item item){
        this.listaItens.remove(item);
    }
  
}
