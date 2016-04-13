import java.util.*;

public class ExercitoDeElfos {    
    
    private Elfo elfo;
    private HashMap<String, Elfo> exercitoDeElfos = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> agrupadoPorStatus = new HashMap<>();
    
    public void alistarElfoNoExercito(Elfo elfo){
        if(elfo instanceof ElfosNoturnos || elfo instanceof ElfosVerdes){
            this.exercitoDeElfos.put(elfo.getNome(), elfo);
        
        }      
   }
   
   public void agruparPorStatus(){ // Criar ArrayList, pois os Status são de mesma chave(VIVO)
           ArrayList<Elfo> listaElfos = new ArrayList<>();
           for(Elfo elfoAux : this.exercitoDeElfos.values()){
           listaElfos.add(elfoAux);
           this.agrupadoPorStatus.put(elfoAux.getStatus(), listaElfos);
           }       
   }
   
   public HashMap getExercitoDeElfos(){
   return this.exercitoDeElfos;
   }
   
   public HashMap getAgrupadoPorStatus(){
   return this.agrupadoPorStatus; 
   }
   
}
