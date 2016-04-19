import java.util.*;
public class NoturnosPorUltimo implements Estrategias {
    
    public ArrayList<Elfo> atacar (ArrayList<Dwarf> listaDwarves, ExercitoDeElfos exercito){
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.buscarPorStatus(Status.VIVO);
        
        int i = 0;
        int j = 0;
        Elfo elfoAux;
 
        for(i = 0; i < elfosVivos.size(); i++){
        for(j = 0; j < elfosVivos.size() - 1; j++){
            if(elfosVivos.get(j) instanceof ElfosNoturnos && elfosVivos.get(j + 1) instanceof ElfosVerdes){
               elfoAux = elfosVivos.get(j);
               elfosVivos.set(j, elfosVivos.get(j + 1));
               elfosVivos.set((j + 1), elfoAux); 
            }
        }
    }   
        return elfosVivos;
    }
    
}
