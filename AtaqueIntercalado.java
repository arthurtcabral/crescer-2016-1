import java.util.*;
public class AtaqueIntercalado implements Estrategias{
    
     private boolean condicaoDeFormacao(ArrayList<Elfo> elfosVivos){
        int contadorElfosVerdes = 0; 
        int contadorElfosNoturnos = 0;
 
         for (Elfo elfoAux : elfosVivos) {
             if (elfoAux instanceof ElfoVerde) {
                 contadorElfosVerdes++;
             }else if(elfoAux instanceof ElfoNoturno) {
                 contadorElfosNoturnos++;
             }
         }
         return contadorElfosVerdes == contadorElfosNoturnos;
     }

     public ArrayList<Elfo> atacar (ArrayList<Dwarf> listaDwarves, ExercitoDeElfos exercito){
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.buscarPorStatus(Status.VIVO);
        ArrayList<Elfo> elfosQueAtacam = new ArrayList<Elfo>();
         
        if(condicaoDeFormacao(elfosVivos)){
        Elfo primeiroElfo = elfosVivos.get(0);
        elfosQueAtacam.add(primeiroElfo);
        Class classeDoUltimoElfoAdicionado = primeiroElfo.getClass(); // adiciona a classe do primeiroElfo à variável classeDoUltimoElfoAdicionado
        elfosVivos.remove(primeiroElfo);
        
        while(elfosVivos.size() > 0) {
             for (int i = 0; i < elfosVivos.size(); i++) {
                 Elfo elfoAux = elfosVivos.get(i);
                 if (elfoAux.getClass() != classeDoUltimoElfoAdicionado) { // se a classe do atual elfo da lista for difetente da classe do ultimo adicionado
                     elfosQueAtacam.add(elfoAux);                          // insere-se o elfo à lista final
                     classeDoUltimoElfoAdicionado = elfoAux.getClass();    // seta-se a classe do último elfo adicionado
                     elfosVivos.remove(elfoAux);                           // remove-se o elfo atual da lista anterior, a fim de que o while tenha serventia futuramente e que o códogo rode de uma maneira correta
                 }
             }
         }
         
         for(int j = 0; j < elfosQueAtacam.size(); j++){
             for(int a = 0; a < listaDwarves.size(); a++){
                 elfosQueAtacam.get(j).atirarFlecha(listaDwarves.get(a));
                }
            }
         
        }else{
        
            elfosQueAtacam = null;
        }
    return elfosQueAtacam;
}

}
