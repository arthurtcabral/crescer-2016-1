package br.com.crescer.aula3;

import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
                    instrucoes.add(readLine);
                } else {
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
                ResultSet resultSet = ps.executeQuery()) {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int numColunas = rsmd.getColumnCount();
            String nomeColuna = "";
            for (int i = 1; i <= numColunas; i++) {
                nomeColuna = rsmd.getColumnName(i);
                System.out.print(nomeColuna + "   ");
            }
            System.out.println("\n");
            while (resultSet.next()) {
                if (numColunas == 2) {
                    System.out.println(resultSet.getLong("ID_PESSOA") + "   "
                            + resultSet.getString("NOME_PESSOA"));

                } else if (nomeColuna.equals("ID_PESSOA")) {
                    System.out.println(resultSet.getLong("ID_PESSOA"));
                } else {
                    System.out.println(resultSet.getString("NOME_PESSOA"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MeuSQLUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readCsv(String arquivo) throws IOException {
        List<String> dados = new ArrayList<String>();
        if (eCsv(arquivo)) {
            BufferedReader bf = null;
            CSVReader reader = new CSVReader(new FileReader(arquivo), ',', '\'');
            try {
                bf = new BufferedReader(new FileReader(arquivo));
            } catch (FileNotFoundException ex) {
                System.out.println("Arquivo não encontrado.");
                System.exit(0);
            }
            try (Connection conn = ConnectionUtils.getConnection();
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO PESSOA"
                            + "(ID_PESSOA, NOME_PESSOA) VALUES (?, ?)")) {

                String[] readLine;
                int i = 0;
                boolean jaLeuAPrimeiraLinha = false;
                while ((readLine = reader.readNext()) != null) {
                    i++;
                    if (jaLeuAPrimeiraLinha) {
                        System.out.println(readLine[0] + " " + readLine[1]);
                        System.out.println("");
                        ps.setString(1, readLine[0]);
                        ps.setString(2, readLine[1]);
                        ps.executeUpdate();
                    } else {
                        jaLeuAPrimeiraLinha = true;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(MeuSQLUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Arquivo incompatível.");
            System.exit(0);
        }
    }

    public void exportToCsv() throws IOException {
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> pessoas = pessoaDAO.listAll();
        FileWriter writer = new FileWriter("novoArquivo.csv");
        writer.append("ID_PESSOA");
        writer.append(",");
        writer.append("NOME_PESSOA");
        writer.append("\n");
        
        for(Pessoa pessoa : pessoas){
        writer.append(pessoa.getId().toString());
        writer.append(",");
        writer.append(pessoa.getNome());
        writer.append("\n");
        }

        writer.flush();
        writer.close();
    }

    private static boolean eSql(String arquivo) {
        return arquivo.contains(".sql");
    }

    private static boolean eCsv(String arquivo) {
        return arquivo.contains(".csv");
    }

}
