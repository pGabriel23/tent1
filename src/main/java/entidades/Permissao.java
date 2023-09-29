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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author paulo
 */
@Entity
@Table(name = "permissao")
@NamedQueries({
    @NamedQuery(name = "Permissao.findAll", query = "SELECT p FROM Permissao p"),
    @NamedQuery(name = "Permissao.findById", query = "SELECT p FROM Permissao p WHERE p.id = :id"),
    @NamedQuery(name = "Permissao.findByCidade", query = "SELECT p FROM Permissao p WHERE p.cidade = :cidade"),
    @NamedQuery(name = "Permissao.findByCliente", query = "SELECT p FROM Permissao p WHERE p.cliente = :cliente"),
    @NamedQuery(name = "Permissao.findByEstado", query = "SELECT p FROM Permissao p WHERE p.estado = :estado"),
    @NamedQuery(name = "Permissao.findByFiliais", query = "SELECT p FROM Permissao p WHERE p.filiais = :filiais"),
    @NamedQuery(name = "Permissao.findByFornecedor", query = "SELECT p FROM Permissao p WHERE p.fornecedor = :fornecedor"),
    @NamedQuery(name = "Permissao.findByFuncionario", query = "SELECT p FROM Permissao p WHERE p.funcionario = :funcionario"),
    @NamedQuery(name = "Permissao.findByPermissao", query = "SELECT p FROM Permissao p WHERE p.permissao = :permissao"),
    @NamedQuery(name = "Permissao.findBySistema", query = "SELECT p FROM Permissao p WHERE p.sistema = :sistema"),
    @NamedQuery(name = "Permissao.findByStatus_servico", query = "SELECT p FROM Permissao p WHERE p.status_servico = :status_servico"),
    @NamedQuery(name = "Permissao.findByUsuario", query = "SELECT p FROM Permissao p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "Permissao.findByVenda", query = "SELECT p FROM Permissao p WHERE p.venda = :venda")})
public class Permissao implements Serializable, ClassePai {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "cidade")
    private Boolean cidade;
    @Column(name = "cliente")
    private Boolean cliente;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "filiais")
    private Boolean filiais;
    @Column(name = "fornecedor")
    private Boolean fornecedor;
    @Column(name = "funcionario")
    private Boolean funcionario;
    @Column(name = "permissao")
    private Boolean permissao;
    @Column(name = "sistema")
    private Boolean sistema;
    @Column(name = "status_servico")
    private Boolean status_servico;
    @Column(name = "usuario")
    private Boolean usuario;
    @Column(name = "venda")
    private Boolean venda;
    @Column(name = "relatorio")
    private Boolean relatorio;

    public Boolean getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Boolean fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Boolean getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Boolean funcionario) {
        this.funcionario = funcionario;
    }

    public Boolean getPermissao() {
        return permissao;
    }

    public void setPermissao(Boolean permissao) {
        this.permissao = permissao;
    }

    public Boolean getSistema() {
        return sistema;
    }

    public void setSistema(Boolean sistema) {
        this.sistema = sistema;
    }

    public Boolean getStatus_servico() {
        return status_servico;
    }

    public void setStatus_servico(Boolean status_servico) {
        this.status_servico = status_servico;
    }

    public Boolean getUsuario() {
        return usuario;
    }

    public void setUsuario(Boolean usuario) {
        this.usuario = usuario;
    }

    public Boolean getVenda() {
        return venda;
    }

    public void setVenda(Boolean venda) {
        this.venda = venda;
    }

    public Boolean getFiliais() {
        return filiais;
    }

    public void setFiliais(Boolean filiais) {
        this.filiais = filiais;
    }

    public Boolean getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Boolean relatorio) {
        this.relatorio = relatorio;
    }
    
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissao")
    private List<Usuario> usuarioList;

    public Permissao() {
    }

    public Permissao(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCidade() {
        return cidade;
    }

    public void setCidade(Boolean cidade) {
        this.cidade = cidade;
    }

    public Boolean getCliente() {
        return cliente;
    }

    public void setCliente(Boolean cliente) {
        this.cliente = cliente;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        if (!(object instanceof Permissao)) {
            return false;
        }
        Permissao other = (Permissao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Permissao[ id=" + id + " ]";
    }

}
