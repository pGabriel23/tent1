/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidades.Fornecedor;
import facade.FornecedorFacade;
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
public class FornecedorControle {

    private Fornecedor fornecedor = new Fornecedor();
    @EJB
    private FornecedorFacade fornecedorFacade;

    public List<Fornecedor> getListaFornecedor() {
        return fornecedorFacade.listaTodos();
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String salvar() {
        fornecedorFacade.salvar(fornecedor);
        fornecedor = new Fornecedor();
        return "fornecedorlista";
    }

    public void excluir(Fornecedor fnd) {
        fornecedorFacade.remover(fnd);
    }

}
