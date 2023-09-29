/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import Converter.ConverterGererico;
import entidades.Usuario;
import facade.FuncionarioFacade;
import facade.PermissaoFacade;
import facade.UsuarioFacade;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
    @EJB
    private PermissaoFacade permissaoFacade;
    @EJB
    private FuncionarioFacade funcionarioFacade;
    private ConverterGererico funcionarioConverter;
    private ConverterGererico permissaoConverter;

    public ConverterGererico getFuncionarioConverter() {
        if (funcionarioConverter == null) {
            funcionarioConverter = new ConverterGererico(funcionarioFacade);
        }
        return funcionarioConverter;
    }

    public void setFuncionarioConverter(ConverterGererico funcionarioConverter) {
        this.funcionarioConverter = funcionarioConverter;
    }

    public ConverterGererico getPermissaoConverter() {
        if (permissaoConverter == null) {
            permissaoConverter = new ConverterGererico(permissaoFacade);
        }
        return permissaoConverter;
    }

    public void setPermissaoConverter(ConverterGererico permissaoConverter) {
        this.permissaoConverter = permissaoConverter;
    }

    public List<Usuario> getListaUsuario() {
        return usuarioFacade.listaTodos();
    }

    public void relatorioUsuario() {
        HashMap parametros = new HashMap();
        relatorio.relatorio.imprimeRelatorio("/relatorio-usuario", parametros, usuarioFacade.listaTodos());
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String salvar() {
        if (usuarioFacade.buscaPorNome(usuario.getNome()).isEmpty()) {
            usuarioFacade.salvar(usuario);
            usuario = new Usuario();
            return "usuariolista";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario com esse nome já existe", ""));
        return null;
    }

    public void excluir(Usuario usr) {
        usuarioFacade.remover(usr);
    }

    public void edita(Usuario usr) {
        usuario = usr;
    }

    public String novoUsuario() {
        usuario = new Usuario();
        return "usuarioedita";
    }
}
