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
           ArrayList<Elfo> listaElfosVivos = new ArrayList<>();
           ArrayList<Elfo> listaElfosMortos = new ArrayList<>();
           for(Elfo elfoAux : this.exercitoDeElfos.values()){
               if(elfoAux.getStatus().equals(Status.VIVO)){
                   listaElfosVivos.add(elfoAux);
                   this.agrupadoPorStatus.put(elfoAux.getStatus(), listaElfosVivos);
               }else if(elfoAux.getStatus().equals(Status.MORTO)){
                   listaElfosMortos.add(elfoAux);
                   this.agrupadoPorStatus.put(elfoAux.getStatus(), listaElfosMortos);
               }     
           }       
   }
   
   public ArrayList<Elfo> buscarPorStatus(Status status){
    ArrayList<ArrayList<Elfo>> listaDeListasDeElfos = new ArrayList<>();
    ArrayList<Elfo> listaElfosRetorno = new ArrayList<>();
     for(ArrayList<Elfo> listaElfosAux : this.agrupadoPorStatus.values()){
               listaDeListasDeElfos.add(listaElfosAux);
     }
     
     if(listaDeListasDeElfos.get(0).get(0).getStatus().equals(status)){
        for(Elfo elfoAux : listaDeListasDeElfos.get(0)){
            listaElfosRetorno.add(elfoAux);
        }
        
        }else if(listaDeListasDeElfos.get(1).get(0).getStatus().equals(status)){
            for(Elfo elfoAux : listaDeListasDeElfos.get(1)){
            listaElfosRetorno.add(elfoAux);
            }
        
        }
     
     return listaElfosRetorno;
    }
   
   public HashMap getExercitoDeElfos(){
   return this.exercitoDeElfos;
   }
   
   public HashMap getAgrupadoPorStatus(){
   return this.agrupadoPorStatus; 
   }
   
}
