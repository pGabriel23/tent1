/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import Converter.ConverterGererico;
import entidades.Funcionario;
import facade.CidadeFacade;
import facade.FuncionarioFacade;
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
public class FuncionarioControle {

    private Funcionario funcionario = new Funcionario();
    @EJB
    private FuncionarioFacade funcionarioFacade;
    @EJB
    private CidadeFacade cidadeFacade;
    private ConverterGererico cidadeConverter;

    public ConverterGererico getCidadeConverter() {
        if (cidadeConverter == null) {
            cidadeConverter = new ConverterGererico(cidadeFacade);
        }
        return cidadeConverter;
    }

    public void setCidadeConverter(ConverterGererico cidadeConverter) {
        this.cidadeConverter = cidadeConverter;
    }

    public List<Funcionario> getListaFuncionario() {
        return funcionarioFacade.listaTodos();
    }

    public void relatorioFuncionario() {
        HashMap parametros = new HashMap();
        relatorio.relatorio.imprimeRelatorio("/relatorio-funcionario", parametros, funcionarioFacade.listaTodos());
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String salvar() {
        funcionarioFacade.salvar(funcionario);
        funcionario = new Funcionario();
        return "funcionariolista";
    }

    public void excluir(Funcionario fun) {
        funcionarioFacade.remover(fun);
    }

}
