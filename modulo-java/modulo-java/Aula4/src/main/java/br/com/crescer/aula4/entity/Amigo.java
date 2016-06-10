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
@Table(name = "AMIGO")
@NamedQueries({
    @NamedQuery(name = "Amigo.findAll",
            query = "SELECT amigo FROM Amigo amigo")
})
public class Amigo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AMIGO")
    @SequenceGenerator(name = "SQ_AMIGO", sequenceName = "SQ_AMIGO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_AMIGO")
    private Long idAmigo;
    
    @ManyToOne(optional = false)
    @Basic(optional = false)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
    
    @ManyToOne(optional = false)
    @Basic(optional = false)
    @JoinColumn(name = "ID_USUARIO_AMIGO")
    private Usuario usuarioAmigo;

    public Long getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(Long idAmigo) {
        this.idAmigo = idAmigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioAmigo() {
        return usuarioAmigo;
    }

    public void setUsuarioAmigo(Usuario usuarioAmigo) {
        this.usuarioAmigo = usuarioAmigo;
    }
    
}
