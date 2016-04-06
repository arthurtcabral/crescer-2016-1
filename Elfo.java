
public class Elfo
{
    
    private String nome;
    private int experiencia;
    private int flechas;
    private boolean acertar = true;
    private Dwarf dwarf;
    
    public Elfo(String nome)
    {
        this.nome = nome;
        this.flechas = 42;
    }
    
    public Elfo(String nome, int experiencia)
    {
        this.nome = nome;
        this.flechas = 42;
        this.experiencia = experiencia;
    }
    
    public Elfo(String nome, int experiencia, int flechas){
        this.nome = nome;
        this.flechas = flechas;
        this.experiencia = experiencia;
    }
      
    public void atirarFlecha(Dwarf dwarf){
        this.experiencia++;
        this.flechas--;
        dwarf.perdeVida();
    }
  
    public int getFlechas(){
    return this.flechas;
    }
    
    public int getExperiencia(){
    return this.experiencia;
    }
    
    public String toString(){
    return this.nome + " possui " + this.flechas + " flechas e " + this.experiencia + " níveis de experiência.";
    }
    
    
}