package br.com.crescer.aula3;

import java.util.List;

public interface IPessoa {

    void insert(Pessoa pessoa);
    void update (Pessoa pessoa);
    void delete (Pessoa pessoa);
    List<Pessoa> listAll();
    List<Pessoa> findNome(String nome);
    
}
