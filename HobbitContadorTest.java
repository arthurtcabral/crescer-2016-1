import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest
{
   @Test
   public void calcularDiferenca(){
    ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
    arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
    arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
    arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));
    
    HobbitContador contador = new HobbitContador();
    Integer diferenca = contador.calcularDiferenca(arrayDePares);
    
    assertTrue(diferenca == 840);
   }
   
   @Test
   public void obtencaoDoMaiorMultiploDeTresAte(){
   HobbitContador bolseiro = new HobbitContador();
   assertTrue(bolseiro.obterMaiorMultiploDeTresAte(32) == 30);
   }
   
   @Test
   public void obtencaoDosMultiplosDeTresAte(){
   HobbitContador frodo = new HobbitContador();
   assertTrue(frodo.obterMultiplosDeTresAte(12).size() == 4);
   }
}
