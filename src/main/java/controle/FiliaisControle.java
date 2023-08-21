/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidades.Filiais;
import facade.FiliaisFacade;
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

    public List<Filiais> getListaFiliais() {
        return filiaisFacade.listaTodos();
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

}
