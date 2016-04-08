import java.util.ArrayList;

public class Inventario
{
    private ArrayList<Item> listaItens = new ArrayList<Item>();
    private Item item;
    // private Item item;
    
    public Inventario(){
    }
    
    public ArrayList<Item> getListaItens(){
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
  
    public Item itemMaiorQuantidade(){
    Item itemPop = null;
    int i = 0;
    if(this.listaItens != null){
    itemPop = this.listaItens.get(0);
    do{
        if(this.listaItens.get(i).getQuantidade() > itemPop.getQuantidade()){
            itemPop = this.listaItens.get(i);
        }
        i++;
    }while(this.listaItens.size() != i);
    }
    return itemPop;
    }
    
}
