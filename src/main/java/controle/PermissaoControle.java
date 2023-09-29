/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidades.Permissao;
import facade.PermissaoFacade;
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
public class PermissaoControle {

    private Permissao permissao = new Permissao();
    @EJB
    private PermissaoFacade permissaoFacade;

    public List<Permissao> getListaPermissao() {
        return permissaoFacade.listaTodos();
    }

    public void relatorioPermissao() {
        HashMap parametros = new HashMap();
        relatorio.relatorio.imprimeRelatorio("/relatorio-permissao", parametros, permissaoFacade.listaTodos());
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public String salvar() {
        permissaoFacade.salvar(permissao);
        permissao = new Permissao();
        return "permissaolista";
    }

    public void excluir(Permissao perm) {
        permissaoFacade.remover(perm);
    }

    public void edita(Permissao perm) {
        permissao = perm;
    }

    public String novaPermissao() {
        permissao = new Permissao();
        return "permissaoedita";
    }
}
