/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import Converter.ConverterGererico;
import entidades.Fornecedor;
import entidades.Sistema;
import facade.FornecedorFacade;
import facade.SistemaFacade;
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
public class SistemaControle {

    private Sistema sistema = new Sistema();
    @EJB
    private SistemaFacade sistemaFacade;
    @EJB
    private FornecedorFacade fornecedorFacade;
    private ConverterGererico fornecedorConverter;

    public ConverterGererico getFornecedorConverter() {
        if (fornecedorConverter == null) {
            fornecedorConverter = new ConverterGererico(fornecedorFacade);
        }
        return fornecedorConverter;
    }

    public void setFornecedorConverter(ConverterGererico fornecedorConverter) {
        this.fornecedorConverter = fornecedorConverter;
    }

    public List<Sistema> getListaSistema() {
        return sistemaFacade.listaTodos();
    }

    public void relatorioSistema() {
        HashMap parametros = new HashMap();
        relatorio.relatorio.imprimeRelatorio("/relatorio-sistema", parametros, sistemaFacade.listaTodos());
    }

    public void relatorioPrecoFornecedor(Fornecedor For) {
        HashMap parametros = new HashMap();
        relatorio.relatorio.imprimeRelatorio("/relatorio-preco-sistema", parametros, sistemaFacade.findByFornecedor(For));
    }

    public void relatorioPrecoTamanho(int qnt) {
        HashMap parametros = new HashMap();
        relatorio.relatorio.imprimeRelatorio("/relatorio-preco-tamanho", parametros, sistemaFacade.findByTamanho(qnt));
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public String salvar() {
        sistemaFacade.salvar(sistema);
        sistema = new Sistema();
        return "sistemalista";
    }

    public void excluir(Sistema sis) {
        sistemaFacade.remover(sis);
    }

    public void edita(Sistema sis) {
        sistema = sis;
    }

    public String novoSistema() {
        sistema = new Sistema();
        return "sistemaedita";
    }
}
