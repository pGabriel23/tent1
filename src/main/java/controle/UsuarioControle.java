/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidades.Usuario;
import facade.UsuarioFacade;
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
public class UsuarioControle {

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    private Usuario usuario = new Usuario();
    @EJB
    private UsuarioFacade usuarioFacade;

    public List<Usuario> getListaUsuario() {
        return usuarioFacade.listaTodos();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String salvar() {
        usuarioFacade.salvar(usuario);
        usuario = new Usuario();
        return "usuariolista";
    }

    public void excluir(Usuario usr) {
        usuarioFacade.remover(usr);
    }

//    PADRAO DEIXAR EM FALSE
    private Boolean senhaToggle = false;

    public Boolean getSenhaToggle() {
        return senhaToggle;
    }
    
    public void senhaToggle() {
        senhaToggle = senhaToggle == false;
    }

}
