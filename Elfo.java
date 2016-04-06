
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
  
    public Elfo(String nome, int flechas)
    {
        this.nome = nome;
        this.flechas = flechas;
    }
    
    public void atirarFlecha(Dwarf dwarf){
        this.experiencia++;
        this.flechas--;
        dwarf.perdeVida();
    }
    
    public void atirarFlechaRefactory(int flechas, int experiencia){
    if(acertar){
       experiencia++;
    }
    flechas--;
}

}