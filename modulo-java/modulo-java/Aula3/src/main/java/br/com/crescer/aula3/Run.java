package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Run {

    public static void main(String[] args) {

        try (Connection connection = ConnectionUtils.getConnection()) {
            String query = "INSERT INTO PESSOA (ID_PESSOA, NOME_PESSOA)"
                    + "VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)";
            PreparedStatement ps =  connection.prepareStatement(query);
            
            ps.setString(1, "ARTHUR TC");
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
