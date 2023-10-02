/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author paulo
 */
@Entity
@Table(name = "sistema")
@NamedQueries({
    @NamedQuery(name = "Sistema.findAll", query = "SELECT s FROM Sistema s"),
    @NamedQuery(name = "Sistema.findById", query = "SELECT s FROM Sistema s WHERE s.id = :id"),
    @NamedQuery(name = "Sistema.findByPreco", query = "SELECT s FROM Sistema s WHERE s.preco = :preco"),
    @NamedQuery(name = "Sistema.findByInversor", query = "SELECT s FROM Sistema s WHERE s.inversor = :inversor"),
    @NamedQuery(name = "Sistema.findByInversor1", query = "SELECT s FROM Sistema s WHERE s.inversor1 = :inversor1"),
    @NamedQuery(name = "Sistema.findByModulo", query = "SELECT s FROM Sistema s WHERE s.modulo = :modulo"),
    @NamedQuery(name = "Sistema.findByFornecedor", query = "SELECT s FROM Sistema s WHERE s.fornecedor = :fornecedor"),
    @NamedQuery(name = "Sistema.findByModulo1", query = "SELECT s FROM Sistema s WHERE s.modulo1 = :modulo1"),
    @NamedQuery(name = "Sistema.findByCodigo", query = "SELECT s FROM Sistema s WHERE s.codigo = :codigo")})
public class Sistema implements Serializable, ClassePai {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preco")
    private double preco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "inversor")
    private String inversor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qnt_inversor")
    private int inversor1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "modulo")
    private String modulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qnt_modulo")
    private int modulo1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigo")
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sistema")
    private List<Venda> vendaList;
    @JoinColumn(name = "fornecedor", referencedColumnName = "nome")
    @ManyToOne(optional = false)
    private Fornecedor fornecedor;

    public Sistema() {
    }

    public Sistema(Long id) {
        this.id = id;
    }

    public Sistema(Long id, double preco, String inversor, int inversor1, String modulo, int modulo1, String codigo) {
        this.id = id;
        this.preco = preco;
        this.inversor = inversor;
        this.inversor1 = inversor1;
        this.modulo = modulo;
        this.modulo1 = modulo1;
        this.codigo = codigo;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getInversor() {
        return inversor;
    }

    public void setInversor(String inversor) {
        this.inversor = inversor;
    }

    public int getInversor1() {
        return inversor1;
    }

    public void setInversor1(int inversor1) {
        this.inversor1 = inversor1;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public int getModulo1() {
        return modulo1;
    }

    public void setModulo1(int modulo1) {
        this.modulo1 = modulo1;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
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
        if (!(object instanceof Sistema)) {
            return false;
        }
        Sistema other = (Sistema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Sistema[ id=" + id + " ]";
    }

}
