
package br.com.crescer.aula3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void columnDataAndLineNames(String query) {
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet resultSet = ps.executeQuery()){
                ResultSetMetaData rsmd = resultSet.getMetaData();
                int numColunas = rsmd.getColumnCount();
                String nomeColuna = "";
                for(int i = 1; i <= numColunas; i++){
                    nomeColuna = rsmd.getColumnName(i);
                    System.out.print(nomeColuna + "   ");
                }
                System.out.println("\n");
            while (resultSet.next()) {
                if(numColunas == 2){
                System.out.println(resultSet.getLong("ID_PESSOA") + "   " +
                        resultSet.getString("NOME_PESSOA"));
            
                }else{
                    if(nomeColuna.equals("ID_PESSOA")){
                        System.out.println(resultSet.getLong("ID_PESSOA"));
                    }else{
                        System.out.println(resultSet.getString("NOME_PESSOA"));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MeuSQLUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    private static boolean eSql(String arquivo) {
        return arquivo.contains(".sql");
    }
    
}
