
public class Dwarf
{
   private int vida;
   private int experiencia;
   private String nome;
   private Status status;
   protected Inventario inventario = null;
   private Item item;
   private DataTerceiraEra dataNascimento;
   
   public Dwarf(String nome){
       this.nome = nome;
       this.vida = 110;
       this.status = Status.VIVO;
       this.dataNascimento = new DataTerceiraEra(1, 1, 1);
    }
   
   public Dwarf(String nome, DataTerceiraEra dataNascimento){
       this(nome);
       this.dataNascimento = dataNascimento;
    }
    
    public void perdeVida(){
        if(this.getNumeroSorte() > 100){
        if(this.vida > 0){
        this.vida -= 10;
        if(this.vida == 0){
            status = Status.MORTO;
        }
    }
    }else if(getNumeroSorte() < 0){
        this.experiencia += 2;
    }else{
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
    
    public void setVida(int vida){
        this.vida = vida;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public int getExperiencia(){
    return this.experiencia;
    }
    
    public Status getStatus(){
    return this.status;    
    }
    
    public DataTerceiraEra getDataNascimento(){
    return this.dataNascimento;
    }
    
    public void tentarSorte(){
        if(this.getNumeroSorte() == -3333.0){
            for(int i = 0; i < this.inventario.getListaItens().size(); i++){
            this.inventario.getListaItens().get(i).soma1000();        
        }
        }
    }
    
    public double getNumeroSorte(){
    if(this.dataNascimento.ehBissexto() && this.vida >= 80 && this.vida <= 90){
        return 101.0 * -33;
    } else if(!this.dataNascimento.ehBissexto() && 
        this.nome != null &&
        this.nome.equals("Seixas") || this.nome.equals("Meireles")){
        return (101.0 * 33) % 100;
    }else{
    return 101.0;
    }
}
    
}
