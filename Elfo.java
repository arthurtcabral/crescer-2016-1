    public class Elfo extends Raca { 
      
     protected int flechas = 42; 
     private boolean acertar = true; 
     private Dwarf dwarf; 
     protected double vida = 100.0;
     protected static int cont = 0;
      
     public Elfo(String nome) { 
         super(nome);
         cont++;
     } 
      
     public Elfo(String nome, int experiencia) 
     { 
         super(nome, experiencia); 
         cont++;
        } 
      
     public Elfo(String nome, int experiencia, int flechas){ 
         super(nome, experiencia); 
         this.flechas = flechas; 
         cont++;
        } 
        
     protected void finalize() throws Throwable {
         Elfo.cont--;
         super.finalize();
        }
        
     public void atirarFlecha(Dwarf dwarf){ 
         this.experiencia++; 
         this.flechas--; 
         dwarf.perdeVida(); 
     } 
    
     public int getFlechas(){ 
     return this.flechas; 
    } 
         
     public void setVida(double vida){ 
         this.vida = vida; 
     } 
      
     public double getVida(){ 
         return this.vida; 
     } 
      
     public String toString(){ 
     return this.nome + " possui " + this.flechas + " flechas e " + this.experiencia + " níveis de experiência."; 
    } 
      
      
 } 
