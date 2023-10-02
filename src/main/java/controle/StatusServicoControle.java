/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import Converter.ConverterGererico;
import entidades.StatusServico;
import facade.StatusServicoFacade;
import facade.VendaFacade;
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
public class StatusServicoControle {

    private StatusServico statusServico = new StatusServico();
    @EJB
    private StatusServicoFacade statusServicoFacade;
    @EJB
    private VendaFacade vendaFacade;
    private ConverterGererico vendaConverter;

    public ConverterGererico getVendaConverter() {
        if (vendaConverter == null) {
            vendaConverter = new ConverterGererico(vendaFacade);
        }
        return vendaConverter;
    }

    public void setVendaConverter(ConverterGererico vendaConverter) {
        this.vendaConverter = vendaConverter;
    }

    public List<StatusServico> getListaStatusServico() {
        return statusServicoFacade.listaTodos();
    }

    public void relatorioStatusServico() {
        HashMap parametros = new HashMap();
        relatorio.relatorio.imprimeRelatorio("/relatorio-statusservico", parametros, statusServicoFacade.listaTodos());
    }

    public void clienteDevedores() {
        HashMap parametros = new HashMap();
        relatorio.relatorio.imprimeRelatorio("/relatorio-clientes-devedores", parametros, statusServicoFacade.clientesDevedores());
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
        return "statusservicolista";
    }

    public void excluir(StatusServico ss) {
        statusServicoFacade.remover(ss);
    }

    public void edita(StatusServico ss) {
        statusServico = ss;
    }

    public String novoStatusServico() {
        statusServico = new StatusServico();
        return "statusservicoedita";
    }
}
