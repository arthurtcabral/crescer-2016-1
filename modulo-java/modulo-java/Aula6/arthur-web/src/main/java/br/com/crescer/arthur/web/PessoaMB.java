package br.com.crescer.arthur.web;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "pessoa")
@ViewScoped
public class PessoaMB implements Serializable {

    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @PostConstruct
    public void init() {
        this.pessoa = new Pessoa();
    }

}
