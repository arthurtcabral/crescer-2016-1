
public class Dwarf
{
   private int vida;
   private String nome;
   
   public Dwarf(String nome){
       this.nome = nome;
       this.vida = 110;
    }
    
    public void perdeVida(){
        this.vida -= 10;     
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getVida(){
        return this.vida;
    }
    
}
