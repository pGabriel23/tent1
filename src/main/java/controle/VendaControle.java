/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidades.Venda;
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
        return "funcionariolista";
    }

    public void excluir(Venda vnd) {
        vendaFacade.remover(vnd);
    }
}
