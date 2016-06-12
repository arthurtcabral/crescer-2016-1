
package br.com.crescer.aula4.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

@Entity
@Table(name = "MATERIAL")
@NamedQueries({
    @NamedQuery(name = "Material.findAll",
            query = "SELECT mat FROM Material mat")
})
public class Material implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MATERIAL")
    @SequenceGenerator(name = "SQ_MATERIAL", sequenceName = "SQ_MATERIAL", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDMATERIAL")
    private Long idMaterial;
    
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @Basic(optional = false)
    @Column(name = "PESOLIQUIDO")
    private Double pesoLiquido;
    
    @Basic(optional = false)
    @Column(name = "PRECOCUSTO")
    private Double precoCusto;
    
    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
    private List<ProdutoMaterial> produtoMateriais;

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(Double pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public void setProdutoMateriais(List<ProdutoMaterial> produtoMateriais) {
        this.produtoMateriais = produtoMateriais;
    }

    public List<ProdutoMaterial> getProdutoMateriais() {
        return produtoMateriais;
    }
    
}
