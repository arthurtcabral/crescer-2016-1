package br.com.crescer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
// @ManagedBean(name = "kkkk")
@RequestScoped //Essa instância vai durar enquanto for processada a requisição
//@ViewScoped //Escopo de visualização
public class Hello implements Serializable {

    private String helloWorld = "Hello World!";
    
    @PostConstruct
    public void entradinha(){
        helloWorld = "Hello World!";
        System.out.println("Entradinha");
    }
    
    @PreDestroy
    public void saidinha(){
        System.out.println("Saidinha");
    }

    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }
    
    public void processa(){
        System.out.println("Processa");
    }

}
