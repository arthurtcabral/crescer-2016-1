package br.com.crescer.aula3;

import java.io.IOException;

public class Run {

    public static void main(String[] args) throws IOException {        
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        pessoaDAO.runExternalSql("instrucoes.sql");
        
    }
}
