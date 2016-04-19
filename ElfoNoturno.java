
public class ElfoNoturno extends Elfo {
    
    public ElfoNoturno(String nome){
        super(nome);
    
    }
    
    public void atirarFlecha(Dwarf dwarf){
        double novaVida = this.getVida() - (this.getVida() * 0.05);
        this.setVida(novaVida);
        this.experiencia = experiencia + 3;
        this.flechas--;
        dwarf.perdeVida();
        if( ((int) this.getVida()) == 0){
        this.status = Status.MORTO;
        }
    }
   
}
