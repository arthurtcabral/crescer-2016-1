
package br.com.crescer.aula4.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTOMATERIAL")
@NamedQueries({
    @NamedQuery(name = "ProdutoMaterial.findAll",
            query = "SELECT prodMat FROM ProdutoMaterial prodMat")
})
public class ProdutoMaterial implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTOMATERIAL")
    @SequenceGenerator(name = "SQ_PRODUTOMATERIAL", sequenceName = "SQ_PRODUTOMATERIAL", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPRODUTOMATERIAL")
    private Long idProdutoMaterial;
    
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    
    @ManyToOne(optional = false)
    @Basic(optional = false)
    @JoinColumn(name = "IDMATERIAL")
    private Material material;
    
    @ManyToOne(optional = false)
    @Basic(optional = false)
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;

    public Long getIdProdutoMaterial() {
        return idProdutoMaterial;
    }

    public void setIdProdutoMaterial(Long idProdutoMaterial) {
        this.idProdutoMaterial = idProdutoMaterial;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
