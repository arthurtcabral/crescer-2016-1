package br.com.crescer.aula1;

public class TesteEstados {

    public static void main(String[]args){
        
        String [] arrEstados = new String[27];
        String aux = "";
        StringBuilder stringRetorno = new StringBuilder();
        
        int i = 0;
        for(Estados e : Estados.values()){
            arrEstados[i] = e.getNome();
            i++;
        }
        
        for(int j = 0; j < arrEstados.length; j++){
            for(int k = 0; k < arrEstados.length - 1; k++){
                if(arrEstados[k].compareToIgnoreCase(arrEstados[k + 1]) > 0){
                    aux = arrEstados[k];
                    arrEstados[k] = arrEstados[k + 1];
                    arrEstados[k + 1] = aux;
                }
            }
        }
        
        for(int ind = 0; ind < arrEstados.length; ind++){
            stringRetorno.insert(stringRetorno.length(), arrEstados[ind] + ", ");
        }
        stringRetorno.deleteCharAt(stringRetorno.length() - 2);
        System.out.println(stringRetorno);
        
    }
    
}
