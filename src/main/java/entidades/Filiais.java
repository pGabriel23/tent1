/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author paulo
 */
@Entity
@Table(name = "filiais")
@NamedQueries({
    @NamedQuery(name = "Filiais.findAll", query = "SELECT f FROM Filiais f"),
    @NamedQuery(name = "Filiais.findById", query = "SELECT f FROM Filiais f WHERE f.id = :id"),
    @NamedQuery(name = "Filiais.findByGerente", query = "SELECT f FROM Filiais f WHERE f.gerente = :gerente")})
public class Filiais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "gerente")
    private String gerente;
    @JoinColumn(name = "cidade", referencedColumnName = "nome")
    @ManyToOne(optional = false)
    private Cidade cidade;
    @JoinColumn(name = "estado", referencedColumnName = "uf")
    @ManyToOne(optional = false)
    private Estado estado;

    public Filiais() {
    }

    public Filiais(Integer id) {
        this.id = id;
    }

    public Filiais(Integer id, String gerente) {
        this.id = id;
        this.gerente = gerente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filiais)) {
            return false;
        }
        Filiais other = (Filiais) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Filiais[ id=" + id + " ]";
    }
    
}
