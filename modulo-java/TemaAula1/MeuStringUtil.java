package br.com.crescer.temaaula1;

import java.util.Random;

public class MeuStringUtil {

    public boolean isEmpty(String string) {
        return string.trim().length() == 0;
    }

    public int contaVogais(String string) {
        int numeroVogais = 0;
        string = string.toLowerCase();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'a'
                    || string.charAt(i) == 'e'
                    || string.charAt(i) == 'i'
                    || string.charAt(i) == 'o'
                    || string.charAt(i) == 'u') {
                numeroVogais++;
            }
        }
        return numeroVogais;
    }

    public String inventaString() {
        int tamanhoString = (int) Math.random();
        String caracteres = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Integer tam = caracteres.length();
        char[] aux = new char[tamanhoString];
        String stringRetorno = "";
        Random random = new Random();

        for (int i = 0; i < aux.length; i++) {
            aux[i] = caracteres.charAt(random.nextInt(tam));
        }

        for (int i = 0; i < aux.length; i++) {
            stringRetorno = stringRetorno + aux[i];
        }

        return stringRetorno;
    }

    public boolean ePalindromo(String string) {
        char[] charString = string.toCharArray();
        int i = 0;
        int j = charString.length - 1;
        while (j > i) {
            if (charString[i] != charString[j]) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

}
