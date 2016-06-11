
package br.com.crescer.aula4.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PRODUTO")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll",
            query = "SELECT prod FROM Produto prod")
})
public class Produto implements Serializable {
       
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(name = "SQ_PRODUTO", sequenceName = "SQ_PRODUTO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPRODUTO")
    private Long idProduto;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "DATACADASTRO")
    private Calendar dataCadastro;
    
    @Basic(optional = false)
    @Column(name = "PRECOCUSTO")
    private double precoCusto;
    
    @Column(name = "PRECOVENDA")
    private double precoVenda;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;
    
    @OneToMany(mappedBy = "produto")
    private List<ProdutoMaterial> produtoMateriais;

    @OneToMany(mappedBy = "produto")
    private List<PedidoItem> pedidoItens;
    
    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public List<ProdutoMaterial> getProdutoMateriais() {
        return produtoMateriais;
    }

    public void setProdutoMateriais(List<ProdutoMaterial> produtoMateriais) {
        this.produtoMateriais = produtoMateriais;
    }

    public List<PedidoItem> getPedidoItens() {
        return pedidoItens;
    }

    public void setPedidoItens(List<PedidoItem> pedidoItens) {
        this.pedidoItens = pedidoItens;
    }
    
}
