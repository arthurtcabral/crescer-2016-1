import java.util.*;

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
    
    public void ordenarItens(){
    int i = 0;
    int j = 0;
    Item itemAux;
        
    for(i = 0; i < this.listaItens.size(); i++){
        for(j = 0; j < this.listaItens.size() - 1; j++){
            if(this.listaItens.get(j).getQuantidade() >= this.listaItens.get(j + 1).getQuantidade()){
               itemAux = this.listaItens.get(j);
               this.listaItens.set(j, this.listaItens.get(j + 1));
               this.listaItens.set(j + 1, itemAux); 
            }
        }
    }
    
    /* Alternativa implementada pelo JAVA 
     * 
     * Collections.sort(this.listaItens, new Comparator<Item>(){
     * public int compare(Item item1, Item item2){
     *     return Integer.compare(item1.getQuantidade(), item2.getQuantidade());   
     *    }
     *  
    });
     * 
     */
    
    }
    
}
