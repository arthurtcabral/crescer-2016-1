import java.util.*;
public class NoturnosPorUltimo implements Estrategias {
    
    public ArrayList<Elfo> atacar (ArrayList<Dwarf> listaDwarves, ExercitoDeElfos exercito){
        ArrayList<Elfo> elfosVivos;
        if(exercito.getExercitoDeElfos().size() != 0){
        exercito.agruparPorStatus();
        elfosVivos = exercito.buscarPorStatus(Status.VIVO);
        
        int i = 0;
        int j = 0;
        Elfo elfoAux;
 
        for(i = 0; i < elfosVivos.size(); i++){
        for(j = 0; j < elfosVivos.size() - 1; j++){
            if(elfosVivos.get(j) instanceof ElfoNoturno && elfosVivos.get(j + 1) instanceof ElfoVerde){
               elfoAux = elfosVivos.get(j);
               elfosVivos.set(j, elfosVivos.get(j + 1));
               elfosVivos.set((j + 1), elfoAux); 
            }
        }
    }   
    
   }else{
       elfosVivos = null;
   }
     return elfosVivos;
   }
    
}
