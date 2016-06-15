package br.com.crescer.arthur.web;

public class Pessoa {
    
    private String nome;
    private String cidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.cidade;
    }
    
}
