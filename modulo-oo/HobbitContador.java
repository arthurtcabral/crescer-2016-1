import java.util.*;

public class HobbitContador
{
   
   public Integer calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares){
       
       ArrayList<Integer> vetorProdutos = new ArrayList<Integer>();
       ArrayList<Integer> vetorMmc = new ArrayList<Integer>();
       ArrayList<Integer> diferenca = new ArrayList<Integer>();
       int j = 0;
       int soma = 0;
       
       //Cálculo dos produtos
       for(int i = 0; i < arrayDePares.size(); i++){
           vetorProdutos.add(arrayDePares.get(i).get(0) * arrayDePares.get(i).get(1));
        }
       
       //Cálculo dos mmcs
       for(int i = 0; i < arrayDePares.size(); i++){
           Integer mmc = arrayDePares.get(i).get(0);
           while(((mmc % arrayDePares.get(i).get(0)) + (mmc % arrayDePares.get(i).get(1))) != 0){
             mmc++;   
            }
            vetorMmc.add(mmc);
        }
        
        //Cálculo da diferença    
       for(int i = 0; i < arrayDePares.size(); i++){
            diferenca.add(vetorProdutos.get(i) - vetorMmc.get(i));
        }
        
       //Cálculo da soma da diferença
       while(j != diferenca.size()){
           soma += diferenca.get(j);
           j++;
       }
       
       return soma;
    }
    
  /*  public int obterMaiorMultiploDeTresAte(int numero) {
  ArrayList<Integer> multiplos = new ArrayList<>(Arrays.asList(0)); // Não tem porque fazer um ArrayList se o objetivo é retornar apenas um valor

  for (int i = 1; i <= limite; i++) {
      if (i % 3 == 0) {
          multiplos.add(i);
          continue; 
        }
    }

    return multiplos;
} */
    
    public int obterMaiorMultiploDeTresAte(int numero){
        int maiorMultiplo = 1;
        if(numero == 0){
            maiorMultiplo = 0;
        }else{
        for(int i = numero; i >= 1; i--){
            if(i % 3 == 0){
                maiorMultiplo = i;
                break;
        }
    }
}
    return maiorMultiplo;
}

    public ArrayList<Integer> obterMultiplosDeTresAte(int numero) {
        ArrayList<Integer> multiplos = new ArrayList<Integer>(); // Não declarou <Integer> depois do sinal de atribuição
       for (int i = 1; i <= numero; i++) { // A variável limite até então era inexistente, já que o nome do parâmetro é numero
            if(i % 3 == 0){ 
               // Não tinha porque ter um break no código, afinal, não há porque interromper o andamento dele.
          multiplos.add(i);
       }
  }
  return multiplos;
}

}
