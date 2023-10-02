/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import Converter.ConverterGererico;
import entidades.Filiais;
import entidades.Venda;
import facade.ClienteFacade;
import facade.FiliaisFacade;
import facade.SistemaFacade;
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
public class VendaControle {

    private Venda venda = new Venda();
    @EJB
    private VendaFacade vendaFacade;
    @EJB
    private SistemaFacade sistemaFacade;
    @EJB
    private ClienteFacade clienteFacade;
    @EJB
    private FiliaisFacade filiaisFacade;
    private ConverterGererico sistemaConverter;
    private ConverterGererico clienteConverter;
    private ConverterGererico filialConverter;

    public ConverterGererico getFilialConverter() {
        if (filialConverter == null) {
            filialConverter = new ConverterGererico(filiaisFacade);
        }
        return filialConverter;
    }

    public void setFilialConverter(ConverterGererico filialConverter) {
        this.filialConverter = filialConverter;
    }

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

    public void relatorioVenda() {
        HashMap parametros = new HashMap();
        relatorio.relatorio.imprimeRelatorio("/relatorio-venda", parametros, vendaFacade.listaTodos());
    }

    public void relatorioVendaVendedor(String nome) {
        HashMap parametros = new HashMap();
        relatorio.relatorio.imprimeRelatorio("/relatorio-vendas-funcionario", parametros, vendaFacade.vendaFuncionario(nome));
    }

    public void relatorioVendaFilial(Filiais ID) {
        HashMap parametros = new HashMap();
        relatorio.relatorio.imprimeRelatorio("/relatorio-venda-filial", parametros, vendaFacade.findByFiliais(ID));
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

    public void edita(Venda vnd) {
        venda = vnd;
    }

    public String novaVenda() {
        venda = new Venda();
        return "vendaedita";
    }
}
