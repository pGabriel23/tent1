/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import Converter.ConverterGererico;
import entidades.Filiais;
import facade.CidadeFacade;
import facade.EstadoFacade;
import facade.FiliaisFacade;
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
public class FiliaisControle {

    private Filiais filiais = new Filiais();
    @EJB
    private FiliaisFacade filiaisFacade;
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

    public List<Filiais> getListaFiliais() {
        return filiaisFacade.listaTodos();
    }

    public void relatorioFiliais() {
        HashMap parametros = new HashMap();
        relatorio.relatorio.imprimeRelatorio("/relatorio-filiais", parametros, filiaisFacade.listaTodos());
    }

    public Filiais getFiliais() {
        return filiais;
    }

    public void setFiliais(Filiais filiais) {
        this.filiais = filiais;
    }

    public String salvar() {
        filiaisFacade.salvar(filiais);
        filiais = new Filiais();
        return "filiaislista";
    }

    public void excluir(Filiais fil) {
        filiaisFacade.remover(fil);
    }

    public void edita(Filiais fil) {
        filiais = fil;
    }

    public String novaFilial() {
        filiais = new Filiais();
        return "filiaisedita";
    }
}
