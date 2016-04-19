import java.util.*;
public class ArteDaGuerra implements Estrategias{
      
    private int intencoesDeAtaque(ArrayList<Dwarf> listaDwarves, ArrayList<Elfo> elfosVivos){
        int intencoes = elfosVivos.size() * listaDwarves.size();
        return intencoes;
    }
    
    private int ataquesDeNoturnos(int intencoesDeAtaque){
        return (int)(intencoesDeAtaque * 0.3);
    }
    
    public ArrayList<Elfo> atacar (ArrayList<Dwarf> listaDwarves, ExercitoDeElfos exercito){
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.buscarPorStatus(Status.VIVO);
        int intencoes = intencoesDeAtaque(listaDwarves, elfosVivos);
        int elfosNoturnosQueAtacam = ataquesDeNoturnos(intencoes);
        int contadorAtaquesElfosNoturnos = 0;
        
        // Retorno do método
        ArrayList<Elfo> elfosQueAtacam = new ArrayList<Elfo>();
       
        // Atacar dwarves
        for(int i = 0; i < elfosVivos.size(); i++){
            int dwarvesAtacadosPeloMesmoElfo = 0;
            for(int j = 0; j < listaDwarves.size(); j++){
            if(elfosVivos.get(i) instanceof ElfosNoturnos){
                if(contadorAtaquesElfosNoturnos != elfosNoturnosQueAtacam){
                elfosVivos.get(i).atirarFlecha(listaDwarves.get(j));
                contadorAtaquesElfosNoturnos++;
                    if(dwarvesAtacadosPeloMesmoElfo == 0){
                        elfosQueAtacam.add(elfosVivos.get(i));
                        dwarvesAtacadosPeloMesmoElfo++;
                    }
            }else{
            continue;
            }  
            }else if(!(elfosVivos.get(i) instanceof ElfosNoturnos)){
                elfosVivos.get(i).atirarFlecha(listaDwarves.get(j));
                if(dwarvesAtacadosPeloMesmoElfo == 0){
                        elfosQueAtacam.add(elfosVivos.get(i));
                        dwarvesAtacadosPeloMesmoElfo++;
                }
            }
        }
    }
        return elfosQueAtacam;
    }
       
}
 

