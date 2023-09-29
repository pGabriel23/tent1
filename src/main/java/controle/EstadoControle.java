/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidades.Estado;
import facade.EstadoFacade;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author paulo
 */
@ManagedBean
@SessionScoped
public class EstadoControle {

    private Estado estado = new Estado();
    @EJB
    private EstadoFacade estadoFacade;

    public List<Estado> getListaEstado() {
        return estadoFacade.listaTodos();
    }

    public void relatorioEstado() {
        HashMap parametros = new HashMap();
        relatorio.relatorio.imprimeRelatorio("/relatorio-estado", parametros, estadoFacade.listaTodos());
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String salvar() {
        estadoFacade.salvar(estado);
        estado = new Estado();
        return "estadolista";
    }

    public void excluir(Estado est) {
        estadoFacade.remover(est);
    }

    public void edita(Estado est) {
        estado = est;
    }

    public String novoEstado() {
        estado = new Estado();
        return "estadoedita";
    }
}
