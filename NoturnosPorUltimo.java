import java.util.*;
public class NoturnosPorUltimo implements Estrategias {
    
    public ArrayList<Elfo> estrategia (ArrayList<Dwarf> listaDwarves, ExercitoDeElfos exercito){
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.buscarPorStatus(Status.VIVO);
        
        // Retorno do método
        ArrayList<Elfo> elfosQueAtacam = new ArrayList<Elfo>();
        
        // Adicionar elfos verdes primeiro
        for(Elfo elfoAux : elfosVivos){
            if(elfoAux instanceof ElfosVerdes){
                elfosQueAtacam.add(elfoAux);
            }
        }
        
        // Adicionar elfo comum
        for(Elfo elfoAux : elfosVivos){
            if(!(elfoAux instanceof ElfosVerdes || elfoAux instanceof ElfosNoturnos)){
                elfosQueAtacam.add(elfoAux);
            }
        }
        
        // Adicionar elfos noturnos
        for(Elfo elfoAux : elfosVivos){
            if(elfoAux instanceof ElfosNoturnos){
                elfosQueAtacam.add(elfoAux);
            }
        }
        
         for(int i = 0; i < elfosQueAtacam.size(); i++){
            for(int j = 0; j < listaDwarves.size(); j++){
                elfosQueAtacam.get(i).atirarFlecha(listaDwarves.get(j));
            }
        }
        
        return elfosQueAtacam;
    }
    
}
