
public class Item
{
   private int quantidade;
   private String descricao;
   
   public Item(){
    }
   
   public Item(int quantidade, String descricao){
       this.quantidade = quantidade;
       this.descricao = descricao;
    }
    
    public void soma1000(){
        this.quantidade = quantidade + 1000;
    }
    
    public int getQuantidade(){
    return this.quantidade;
    }
    
    public String getDescricao(){
    return this.descricao;
    }
}
