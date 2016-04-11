
public class Raca {
    
    protected String nome;
    protected int experiencia;
    protected Inventario inventario = null;
    
    public Raca(String nome){
        this.nome = nome;
    
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
