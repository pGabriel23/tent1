/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author paulo
 */
@Entity
@Table(name = "status_servico")
@NamedQueries({
    @NamedQuery(name = "StatusServico.findAll", query = "SELECT s FROM StatusServico s"),
    @NamedQuery(name = "StatusServico.findById", query = "SELECT s FROM StatusServico s WHERE s.id = :id"),
    @NamedQuery(name = "StatusServico.findByEntrada", query = "SELECT s FROM StatusServico s WHERE s.entrada = :entrada"),
    @NamedQuery(name = "StatusServico.findByInstalacaoIniciada", query = "SELECT s FROM StatusServico s WHERE s.instalacaoIniciada = :instalacaoIniciada"),
    @NamedQuery(name = "StatusServico.findByInstalacaoConcluida", query = "SELECT s FROM StatusServico s WHERE s.instalacaoConcluida = :instalacaoConcluida"),
    @NamedQuery(name = "StatusServico.findBySegundaParcelaNull", query = "SELECT s FROM StatusServico s WHERE s.segundaParcela IS NULL"),
    @NamedQuery(name = "StatusServico.findByNoNull", query = "SELECT s FROM StatusServico s WHERE s.segundaParcela IS NOT NULL AND s.instalacaoConcluida IS NOT NULL"),
    @NamedQuery(name = "StatusServico.findBySegundaParcela", query = "SELECT s FROM StatusServico s WHERE s.segundaParcela = :segundaParcela")})
public class StatusServico implements Serializable, ClassePai {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "entrada")
    @Temporal(TemporalType.DATE)
    private Date entrada;
    @Column(name = "instalacao_iniciada")
    @Temporal(TemporalType.DATE)
    private Date instalacaoIniciada;
    @Column(name = "instalacao_concluida")
    @Temporal(TemporalType.DATE)
    private Date instalacaoConcluida;
    @Column(name = "segunda_parcela")
    @Temporal(TemporalType.DATE)
    private Date segundaParcela;
    @JoinColumn(name = "venda", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Venda venda;

    public StatusServico() {
    }

    public StatusServico(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getInstalacaoIniciada() {
        return instalacaoIniciada;
    }

    public void setInstalacaoIniciada(Date instalacaoIniciada) {
        this.instalacaoIniciada = instalacaoIniciada;
    }

    public Date getInstalacaoConcluida() {
        return instalacaoConcluida;
    }

    public void setInstalacaoConcluida(Date instalacaoConcluida) {
        this.instalacaoConcluida = instalacaoConcluida;
    }

    public Date getSegundaParcela() {
        return segundaParcela;
    }

    public void setSegundaParcela(Date segundaParcela) {
        this.segundaParcela = segundaParcela;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
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
        if (!(object instanceof StatusServico)) {
            return false;
        }
        StatusServico other = (StatusServico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.StatusServico[ id=" + id + " ]";
    }

}
