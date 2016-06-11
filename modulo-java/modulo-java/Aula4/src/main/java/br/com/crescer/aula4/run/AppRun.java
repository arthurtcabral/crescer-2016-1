package br.com.crescer.aula4.run;

import br.com.crescer.aula4.entity.Cidade;
import br.com.crescer.aula4.hibernate.DAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppRun {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        
        DAO dao = new DAO();
        
        Cidade cidade = new Cidade();
        cidade.setIdCidade(2L);
        cidade.setNome("São Leopoldo");
        cidade.setUf("SC");
        
        dao.delete(cidade);
        
        System.exit(0);
        
        
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
