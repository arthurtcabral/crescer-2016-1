
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PEDIDO")
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll",
            query = "SELECT ped FROM Pedido ped")
})
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PEDIDO")
    @SequenceGenerator(name = "SQ_PEDIDO", sequenceName = "SQ_PEDIDO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPEDIDO")
    private Long idPedido;
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "DATAPEDIDO")
    private Calendar dataPedido;
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "DATAENTREGA")
    private Calendar dataEntrega;
    
    @Basic(optional = false)
    @Column(name = "VALORPEDIDO")
    private double valorPedido;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;
    
    @ManyToOne(optional = false)
    @Basic(optional = false)
    @JoinColumn(name = "IDCLIENTE")
    private Cliente cliente;
    
    @OneToMany(mappedBy = "pedido")
    private List<PedidoItem> pedidoItens;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Calendar getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Calendar dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Calendar getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Calendar dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<PedidoItem> getPedidoItens() {
        return pedidoItens;
    }

    public void setPedidoItens(List<PedidoItem> pedidoItens) {
        this.pedidoItens = pedidoItens;
    }
 
}
