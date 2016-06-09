package br.com.crescer.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MeuReaderUtils {

    public MeuReaderUtils() {

    }

    public static void main(String[] args) throws IOException {
        MeuReaderUtils mru = new MeuReaderUtils();
        Scanner teclado = new Scanner(System.in);
        String arquivo = "";
        System.out.println("Informe o nome do arquivo a ser exibido: ");
        arquivo = teclado.nextLine();
        mru.exibeArquivo(arquivo);
    }

    public void exibeArquivo(String arquivo) throws IOException {
        if (eTxt(arquivo)) {
            BufferedReader bf = null;
            try {
                bf = new BufferedReader(new FileReader(arquivo));
            } catch (FileNotFoundException ex) {
                System.out.println("Arquivo não encontrado.");
                System.exit(0);
            }
            while (true) {
                String readLine = bf.readLine();
                if (readLine != null && !readLine.isEmpty()) {
                    System.out.println(readLine);
                }else{
                    System.exit(0);
                }
            }
        } else {
            System.out.println("Arquivo incompatível.");
        }
    }

    public static boolean eTxt(String arquivo) {
        return arquivo.contains(".txt");
    }

}
