package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectRun {

    public static void main(String[] args) {
        // Oracle Thin 
// jdbc:oracle:thin:@<HOST>:<PORT>:<SID>
// oracle.jdbc.driver.OracleDriver

        final String ddl = "CREATE TABLE PESSOA ("
                + "ID_PESSOA NUMBER(19,0) NOT NULL, "
                + "NOME_PESSOA VARCHAR2(50) NOT NULL,"
                + "PRIMARY KEY (ID_PESSOA)"
                + ")";

        final String dml = "INSERT INTO PESSOA (ID_PESSOA, NOME_PESSOA)"
                + "VALUES (1, 'ARTHUR')";

        final String query = "SELECT NOME_PESSOA FROM PESSOA WHERE ID_PESSOA = 1";

        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                try (final ResultSet resultSet = statement.executeQuery(query)) {
                    //statement.executeQuery(query);
                    while(resultSet.next()){
                        System.out.println(resultSet.getString("NOME_PESSOA"));
                    }
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

}
