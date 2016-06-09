
package br.com.crescer.aula3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MeuSQLUtils {

    public static String readSql(String arquivo) throws IOException {
        String instrucoes = "";
         if (eSql(arquivo)) {
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
                    instrucoes = instrucoes + readLine;
                }else{
                    break;
                }
            }
         } else {
             System.out.println("Arquivo incompatível.");
         }
         return instrucoes;
    }
 
    public static boolean eSql(String arquivo) {
        return arquivo.contains(".sql");
    }
    
}
