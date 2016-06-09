package br.com.crescer.temaaula2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MeuWriterUtils {

    public MeuWriterUtils() {

    }
    static Scanner teclado;

    public static void main(String[] args) throws IOException {
        MeuWriterUtils mwu = new MeuWriterUtils();
        teclado = new Scanner(System.in);
        String arquivo = "";
        System.out.println("Informe o nome do arquivo a ser preenchido: ");
        arquivo = teclado.nextLine();
        mwu.escreveArquivo(arquivo);
    }

    public void escreveArquivo(String arquivo) throws IOException {
        if (MeuReaderUtils.eTxt(arquivo)) {
            BufferedReader bf = null;
            try {
                bf = new BufferedReader(new FileReader(arquivo));
            } catch (FileNotFoundException ex) {
                System.out.println("Arquivo não encontrado.");
                System.exit(0);
            }
            BufferedWriter bufferedWriter = null;
            bufferedWriter = new BufferedWriter(new FileWriter(arquivo, true));
            while (true) {
                System.out.println("Escreva o que quiser e digite exit(exit) para concluir: ");
                String nextLine = teclado.nextLine();
                if ("exit(exit)".equals(nextLine)) {
                    bufferedWriter.close();
                    System.exit(0);
                }
                bufferedWriter.write(nextLine);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } else {
            System.out.println("Arquivo incompatível.");
        }
    }

}
