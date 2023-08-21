/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidades.Cidade;
import facade.CidadeFacade;
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
public class CidadeControle {

    private Cidade cidade = new Cidade();
    @EJB
    private CidadeFacade cidadeFacade;

    public List<Cidade> getListaCidade() {
        return cidadeFacade.listaTodos();
    }

    public Cidade getCidade() {
        return cidade;
    }
    
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String salvar() {
        cidadeFacade.salvar(cidade);
        cidade = new Cidade();
        return "cidadelista";
    }
    
    public void excluir(Cidade cid) {
        cidadeFacade.remover(cid);
    }
    
}
