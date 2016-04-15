import java.util.*;
public class AtaqueIntercalado implements Estrategias{
    
     public ArrayList<Elfo> estrategia (ArrayList<Dwarf> listaDwarves, ExercitoDeElfos exercito){
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.buscarPorStatus(Status.VIVO);
        ArrayList<Elfo> elfosVerdes = new ArrayList<Elfo>();
        ArrayList<Elfo> elfosNoturnos = new ArrayList<Elfo>();
        
        // Retorno do método
        ArrayList<Elfo> elfosQueAtacam = new ArrayList<Elfo>();
       
        for(Elfo elfoAux : elfosVivos){
            if(elfoAux instanceof ElfosVerdes){
            elfosVerdes.add(elfoAux);
        }
        }
        
        for(Elfo elfoAux : elfosVivos){
            if(elfoAux instanceof ElfosNoturnos){
            elfosNoturnos.add(elfoAux);
        }
        }   
        
        boolean condicaoDeFormacao = elfosVerdes.size() == elfosNoturnos.size();
        int ataquesParaCadaTipoDeElfo = elfosVerdes.size();
        
        if(condicaoDeFormacao){
            for(int i = 0; i < ataquesParaCadaTipoDeElfo; i++){
                for(int j = 0; j < listaDwarves.size(); j++){
                elfosVerdes.get(i).atirarFlecha(listaDwarves.get(j));
                elfosNoturnos.get(i).atirarFlecha(listaDwarves.get(j));
            }
             elfosQueAtacam.add(elfosVerdes.get(i));
             elfosQueAtacam.add(elfosNoturnos.get(i));
        }
    }
    
    return elfosQueAtacam;
}

}
