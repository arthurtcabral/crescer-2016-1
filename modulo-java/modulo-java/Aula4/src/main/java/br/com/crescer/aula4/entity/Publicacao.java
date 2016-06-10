package br.com.crescer.aula4.entity;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PUBLICACAO")
@NamedQueries({
    @NamedQuery(name = "Publicacao.findAll",
            query = "SELECT pb FROM Publicacao pb")
})
public class Publicacao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PUBLICACAO")
    @SequenceGenerator(name = "SQ_PUBLICACAO", sequenceName = "SQ_PUBLICACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_PUBLICACAO")
    private Long idPublicacao;
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_PUBLICACAO")
    private Calendar dataPublicacao;
    
    @Basic(optional = false)
    @Column(name = "CONTEUDO")
    private String counteudo;
    
    @ManyToOne(optional = false)
    @Basic(optional = false)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
    
}
