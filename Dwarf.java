
public class Dwarf
{
   private int vida;
   private String nome;
   private Status status;
   private Inventario inventario = null;
   private DataTerceiraEra dataNascimento = new DataTerceiraEra(1, 1, 1);
   
   public Dwarf(String nome){
       this.nome = nome;
       this.vida = 110;
       this.status = Status.VIVO;
    }
   
   public Dwarf(String nome, DataTerceiraEra dataNascimento){
       this.nome = nome;
       this.vida = 110;
       this.status = Status.VIVO;
       this.dataNascimento = dataNascimento;
    }
    
    public void perdeVida(){
        if(this.vida > 0){
        this.vida -= 10;
        if(this.vida == 0){
            status = Status.MORTO;
        }
    }
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setInventario(){
        if(this.inventario == null){
            this.inventario = new Inventario();
        }
    }
    
    public Inventario getInventario(){
        return this.inventario;
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
    
    public DataTerceiraEra getDataNascimento(){
    return this.dataNascimento;
    }
    
}
