
public class CestoDeLembas
{
   private int numLembas;
   
   public CestoDeLembas(int numLembas){
       this.numLembas = numLembas;
    }
   
    public boolean podeDividirEmPares(){
        return numLembas > 2 && numLembas <= 100 && numLembas % 2 == 0;
        // return podeDividir;
        // return podeDividir ? true : false; // Terneiro - Caso verdadeiro, retorne o que está antes do :, em caso falso, retorne o que está após o :.
    }
}
