/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidades.Sistema;
import facade.SistemaFacade;
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

    public List<Sistema> getListaSistema() {
        return sistemaFacade.listaTodos();
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
}
