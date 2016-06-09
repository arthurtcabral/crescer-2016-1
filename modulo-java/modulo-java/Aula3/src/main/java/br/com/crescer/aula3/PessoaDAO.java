package br.com.crescer.aula3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDAO implements IPessoa {

    Pessoa pessoa;

    @Override
    public void insert(Pessoa pessoa) {
        String query = "INSERT INTO PESSOA (ID_PESSOA, NOME_PESSOA)"
                + "VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)";
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, pessoa.getNome());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Pessoa pessoa) {
        String query = "UPDATE PESSOA SET NOME_PESSOA = ? WHERE ID_PESSOA = ?";
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, pessoa.getNome());
            ps.setLong(2, pessoa.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Pessoa pessoa) {
        String query = "DELETE FROM PESSOA WHERE ID_PESSOA = ?";
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setLong(1, pessoa.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pessoa> listAll() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        String query = "SELECT * FROM PESSOA";
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                pessoa = new Pessoa();
                pessoa.setId(resultSet.getLong("ID_PESSOA"));
                pessoa.setNome(resultSet.getString("NOME_PESSOA"));
                pessoas.add(pessoa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pessoas;
    }

    @Override
    public List<Pessoa> findNome(String nome) {
        String query = "SELECT * FROM PESSOA WHERE NOME_PESSOA = ?";
        List<Pessoa> pessoas = new ArrayList<Pessoa>() {};
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nome);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                pessoa = new Pessoa();
                pessoa.setId(resultSet.getLong("ID_PESSOA"));
                pessoa.setNome(resultSet.getString("NOME_PESSOA"));
                pessoas.add(pessoa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pessoas;
    }
    
    public void runExternalSql(String arquivo) throws IOException{
        String instrucoes = MeuSQLUtils.readSql(arquivo);
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement statement = conn.prepareStatement(instrucoes)) {
                statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
