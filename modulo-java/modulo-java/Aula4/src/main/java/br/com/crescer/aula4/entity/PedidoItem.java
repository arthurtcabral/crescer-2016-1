
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
@Table(name = "PEDIDOITEM")
@NamedQueries({
    @NamedQuery(name = "PedidoItem.findAll",
            query = "SELECT pedItem FROM PedidoItem pedItem")
})
public class PedidoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PEDIDOITEM")
    @SequenceGenerator(name = "SQ_PEDIDOITEM", sequenceName = "SQ_PEDIDOITEM", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPEDIDOITEM")
    private Long idPedidoItem;
    
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    
    @Basic(optional = false)
    @Column(name = "PRECOUNITARIO")
    private double precoUnitario;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;
    
    @ManyToOne(optional = false)
    @Basic(optional = false)
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;
    
    @ManyToOne(optional = false)
    @Basic(optional = false)
    @JoinColumn(name = "IDPEDIDO")
    private Pedido pedido;

    public Long getIdPedidoItem() {
        return idPedidoItem;
    }

    public void setIdPedidoItem(Long idPedidoItem) {
        this.idPedidoItem = idPedidoItem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
}
