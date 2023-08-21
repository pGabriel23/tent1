/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidades.StatusServico;
import facade.StatusServicoFacade;
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
public class StatusServicoControle {
           
    private StatusServico statusServico = new StatusServico();
    @EJB
    private StatusServicoFacade statusServicoFacade;

    public List<StatusServico> getListaStatusServico() {
        return statusServicoFacade.listaTodos();
    }

    public StatusServico getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(StatusServico statusServico) {
        this.statusServico = statusServico;
    }

    public String salvar() {
        statusServicoFacade.salvar(statusServico);
        statusServico = new StatusServico();
        return "statusServicolista";
    }

    public void excluir(StatusServico ss) {
        statusServicoFacade.remover(ss);
    }
}
