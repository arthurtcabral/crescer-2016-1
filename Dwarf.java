
public class Dwarf
{
   private int vida;
   private String nome;
   private Status status;
   
   public Dwarf(String nome){
       this.nome = nome;
       this.vida = 110;
       this.status = Status.VIVO;
    }
    
    public void perdeVida(){
        this.vida -= 10;
        if(this.vida == 0){
            status = Status.MORTO;
        }
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
    
    public Status getStatus(){
    return this.status;    
    }
    
}
