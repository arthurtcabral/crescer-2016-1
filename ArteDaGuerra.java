import java.util.*;
public class ArteDaGuerra implements Estrategias{
      
    private int intencoesDeAtaque(ArrayList<Dwarf> listaDwarves, ArrayList<Elfo> elfosVivos){
        int intencoes = elfosVivos.size() * listaDwarves.size();
        return intencoes;
    }
    
    private int elfosNoturnosQuePodemAtacar(int intencoesDeAtaque){
        double percentualElfosNoturnosQueAtacam = intencoesDeAtaque * 0.3;
        int elfosNoturnosQuePodemAtacar = (int) percentualElfosNoturnosQueAtacam;
       
        return elfosNoturnosQuePodemAtacar;
    }
    
    public ArrayList<Elfo> estrategia (ArrayList<Dwarf> listaDwarves, ExercitoDeElfos exercito){
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.buscarPorStatus(Status.VIVO);
        int intencoes = intencoesDeAtaque(listaDwarves, elfosVivos);
        int elfosNoturnosQueAtacam = elfosNoturnosQuePodemAtacar(intencoes);
        int contadorElfosNoturnos = 0;
        
        ArrayList<Elfo> elfosQueAtacam = new ArrayList<Elfo>();
        
        // Adicionar a quantidade certa de elfos noturnos que podem atacar
        for(int a = 0; a < elfosVivos.size(); a++){
            
            if(elfosVivos.get(a) instanceof ElfosNoturnos){
                elfosQueAtacam.add(elfosVivos.get(a));
                contadorElfosNoturnos++;
            }
            
            if(contadorElfosNoturnos == elfosNoturnosQueAtacam){
                break;
            }
        
        }
        
        // Adicionar demais elfos que podem atacar
        for(int b = 0; b < elfosVivos.size(); b++){
            if(!(elfosVivos.get(b) instanceof ElfosNoturnos)){
                elfosQueAtacam.add(elfosVivos.get(b));
            }
        
        }
       
        // Atacar dwarves
        for(int i = 0; i < elfosQueAtacam.size(); i++){
            for(int j = 0; j < listaDwarves.size(); j++){
                elfosQueAtacam.get(i).atirarFlecha(listaDwarves.get(j));
            }
        }
        
        return elfosQueAtacam;
    }
       
    }
 

