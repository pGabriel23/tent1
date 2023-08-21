/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidades.Cliente;
import facade.ClienteFacade;
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
public class ClienteControle {
    
    private Cliente cliente = new Cliente();
    @EJB
    private ClienteFacade clienteFacade;

    public List<Cliente> getListaCliente() {
        return clienteFacade.listaTodos();
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String salvar() {
        clienteFacade.salvar(cliente);
        cliente = new Cliente();
        return "clientelista";
    }
    
    public void excluir(Cliente cte) {
        clienteFacade.remover(cte);
    }

}
