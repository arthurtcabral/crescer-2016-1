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
    
    public String getDescricoesItens(){
    String itens = "";
    for(int i = 0; i < this.listaItens.size(); i++){
        itens =  itens + this.listaItens.get(i).getDescricao() + ", ";
    }
    String itensRetorno = itens.substring(0, itens.length() - 2);
    return itensRetorno;
    }
  
}
