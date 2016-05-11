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
   
   public void agruparPorStatus(){
          for(Map.Entry<String, Elfo> organizadorStatus : this.exercitoDeElfos.entrySet()){ // entrySet() serve para retornar uma dupla chave-valor existente
              Elfo elfo = organizadorStatus.getValue();
              ArrayList<Elfo> elfosOrganizados = agrupadoPorStatus.get(elfo.getStatus()); // Retorna, caso haja, o status do elfo em questão, da lista
              
              if(elfosOrganizados == null){
                  elfosOrganizados = new ArrayList<Elfo>();
                  elfosOrganizados.add(elfo);
                  agrupadoPorStatus.put(elfo.getStatus(), elfosOrganizados);
                }else{
                                    
                elfosOrganizados.add(elfo);
                }
          }
   }
   
   public ArrayList<Elfo> buscarPorStatus(Status status){
       return this.agrupadoPorStatus.get(status);
    }
   
   public HashMap getExercitoDeElfos(){
   return this.exercitoDeElfos;
   }
   
   public HashMap getAgrupadoPorStatus(){
   return this.agrupadoPorStatus; 
   }
   
}
