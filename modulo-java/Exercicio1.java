package br.com.crescer;

import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Informe um número: ");
        int num = teclado.nextInt();
        
        if(num % 2 == 0){
            System.out.println("Par");
        }else{
            System.out.println("Ímpar");
        }
    }
    
}
