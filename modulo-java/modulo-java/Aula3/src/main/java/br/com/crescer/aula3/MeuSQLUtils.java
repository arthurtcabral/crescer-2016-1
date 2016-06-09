
package br.com.crescer.aula3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MeuSQLUtils {

    public static List<String> readSql(String arquivo) throws IOException {
        List<String> instrucoes = new ArrayList<String>();
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
                    readLine.split(";");
                    instrucoes.add(readLine);
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
