
public class Raca extends Inventario{
    
    protected String nome;
    protected int experiencia = 0;
    protected Inventario inventario = null;
    protected Status status;
    
    public Raca(String nome){
        this.nome = nome;
        this.status = Status.VIVO;
    
    }
    
    public Raca(String nome, int experiencia){
        this.nome = nome;
        this.experiencia = experiencia;
    }
    
    public void setInventario(){
        if(this.inventario == null){
            this.inventario = new Inventario();
        }
    }
    
    public Inventario getInventario(){
        return this.inventario;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
}
