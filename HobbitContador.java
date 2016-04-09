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
}
