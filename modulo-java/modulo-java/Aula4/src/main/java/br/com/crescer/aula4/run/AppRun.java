package br.com.crescer.aula4.run;

import br.com.crescer.aula4.entity.Cidade;
import br.com.crescer.aula4.entity.Material;
import br.com.crescer.aula4.entity.Pedido;
import br.com.crescer.aula4.entity.PedidoItem;
import br.com.crescer.aula4.entity.Produto;
import br.com.crescer.aula4.entity.ProdutoMaterial;
import br.com.crescer.aula4.hibernate.DAO;
import br.com.crescer.aula4.hibernate.DAOHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppRun {

    static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager EM = EMF.createEntityManager();

    public static void main(String[] args) {
        
        DAO dao = new DAO();
        
        Cidade cidade = new Cidade();
        cidade.setIdCidade(2L);
        cidade.setNome("São Leopoldo");
        cidade.setUf("SC");
        
        Material material = new Material();
        material.setDescricao("Madeira da carvalho");
        material.setPesoLiquido(20.0);
        material.setPrecoCusto(10.5);
        material.setIdMaterial(1L);
        
        Produto produto = new Produto();
        produto.setNome("Mesa de carvalho");
        produto.setPrecoCusto(5.5);
        produto.setPrecoVenda(30.5);
        produto.setSituacao('A');
        produto.setDataCadastro(Calendar.getInstance().getTime());
        produto.setIdProduto(1L);
        
        ProdutoMaterial produtoMaterial = new ProdutoMaterial();
        produtoMaterial.setMaterial(material);
        produtoMaterial.setProduto(produto);
        produtoMaterial.setQuantidade(50);
        
        List<Pedido> pedidos = new ArrayList<Pedido>();
        pedidos = (List<Pedido>) dao.listAll(Pedido.class);
        Pedido pedido = pedidos.get(0);
        
        PedidoItem pedidoItem = new PedidoItem();
        pedidoItem.setPedido(pedido);
        pedidoItem.setPrecoUnitario(2.5);
        pedidoItem.setProduto(produto);
        pedidoItem.setQuantidade(45);
        pedidoItem.setSituacao('T');
        
        DAOHelper daoHelper = new DAOHelper();
        try {
            daoHelper.exportToCsv(Cidade.class);
        } catch (IOException ex) {
            Logger.getLogger(AppRun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        dao.save(pedidoItem);
        
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
