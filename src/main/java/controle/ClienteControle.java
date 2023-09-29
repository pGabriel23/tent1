/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import Converter.ConverterGererico;
import entidades.Cliente;
import facade.CidadeFacade;
import facade.ClienteFacade;
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
public class ClienteControle {

    private Cliente cliente = new Cliente();
    @EJB
    private ClienteFacade clienteFacade;
    @EJB
    private EstadoFacade estadoFacade;
    @EJB
    private CidadeFacade cidadeFacade;
    private ConverterGererico estadoConverter;
    private ConverterGererico cidadeConverter;

    public ConverterGererico getEstadoConverter() {
        if (estadoConverter == null) {
            estadoConverter = new ConverterGererico(estadoFacade);
        }
        return estadoConverter;
    }

    public void setEstadoConverter(ConverterGererico estadoConverter) {
        this.estadoConverter = estadoConverter;
    }

    public ConverterGererico getCidadeConverter() {
        if (cidadeConverter == null) {
            cidadeConverter = new ConverterGererico(cidadeFacade);
        }
        return cidadeConverter;
    }

    public void setCidadeConverter(ConverterGererico cidadeConverter) {
        this.cidadeConverter = cidadeConverter;
    }

    public List<Cliente> getListaCliente() {
        return clienteFacade.listaTodos();
    }

    public void relatorioCliente() {
        HashMap parametros = new HashMap();
        relatorio.relatorio.imprimeRelatorio("/relatorio-cliente", parametros, clienteFacade.listaTodos());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String salvar() {
        clienteFacade.salvar(cliente);
        cliente = new Cliente();
        return "clientelista";
    }

    public void excluir(Cliente cte) {
        clienteFacade.remover(cte);
    }

    public void edita(Cliente cte) {
        cliente = cte;
    }
    
    public String novoCliente() {
        cliente = new Cliente();
        return "clienteedita";
    }
}
