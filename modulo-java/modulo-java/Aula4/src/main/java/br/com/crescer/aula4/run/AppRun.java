package br.com.crescer.aula4.run;

import br.com.crescer.aula4.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AppRun {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        em.isOpen();
        em.close();

        
//        Query query = em.createNamedQuery("Pessoa.findAll");
//        List<Pessoa> pessoas = query.getResultList();
//        
//        for(Pessoa p : pessoas){
//            System.out.println(p.getNomePessoa());
//        }
//        
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNomePessoa("OlaNovoNovoNovo");
//        em.remove(pessoa);
//        em.persist(pessoa);

//        em.getTransaction().commit();
//        em.close();
//        emf.close();
    }

}
