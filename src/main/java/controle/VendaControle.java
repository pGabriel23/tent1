/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import Converter.ConverterGererico;
import entidades.Venda;
import facade.ClienteFacade;
import facade.SistemaFacade;
import facade.VendaFacade;
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
public class VendaControle {

    private Venda venda = new Venda();
    @EJB
    private VendaFacade vendaFacade;
    @EJB
    private SistemaFacade sistemaFacade;
    @EJB
    private ClienteFacade clienteFacade;
    private ConverterGererico sistemaConverter;
    private ConverterGererico clienteConverter;

    public ConverterGererico getSistemaConverter() {
        if (sistemaConverter == null) {
            sistemaConverter = new ConverterGererico(sistemaFacade);
        }
        return sistemaConverter;
    }

    public void setSistemaConverter(ConverterGererico sistemaConverter) {
        this.sistemaConverter = sistemaConverter;
    }

    public ConverterGererico getClienteConverter() {
        if (clienteConverter == null) {
            clienteConverter = new ConverterGererico(clienteFacade);
        }
        return clienteConverter;
    }

    public void setClienteConverter(ConverterGererico clienteConverter) {
        this.clienteConverter = clienteConverter;
    }

    public List<Venda> getListaVenda() {
        return vendaFacade.listaTodos();
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String salvar() {
        vendaFacade.salvar(venda);
        venda = new Venda();
        return "vendalista";
    }

    public void excluir(Venda vnd) {
        vendaFacade.remover(vnd);
    }
}
