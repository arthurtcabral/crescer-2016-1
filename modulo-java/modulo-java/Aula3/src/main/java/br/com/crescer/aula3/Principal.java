package br.com.crescer.aula3;

import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException {
        MeuSQLUtils msu = new MeuSQLUtils();
//        PessoaDAO pessoaDAO = new PessoaDAO();
//        pessoaDAO.runExternalSql("instrucoes.sql");
        
        msu.columnDataAndLineNames("SELECT ID_PESSOA FROM PESSOA");
        

    }
}
