/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import entidades.Usuario;
import facade.UsuarioFacade;
import java.io.Serializable;
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
@ManagedBean(name="loginControle")
@SessionScoped
public class LoginControle implements Serializable {

    private List<Usuario> buscaUsuario;
    private String nome;
    private String senha;
    @EJB
    private UsuarioFacade usuarioFacade;
    public Boolean isLogged = false;
    private Usuario usuarioAtual;

    public String logar() {
        buscaUsuario = usuarioFacade.buscaPorNome(nome);
        if (buscaUsuario.isEmpty()) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario não existe", ""));
            return null;
        }

        if (nome.equals(buscaUsuario.get(0).getNome()) && senha.equals(buscaUsuario.get(0).getSenha())) {
            usuarioAtual = buscaUsuario.get(0);
            System.out.println("Usuario Atual: " + usuarioAtual);
            isLogged = true;
            return "index";
        }

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario e/ou senha incorretos", ""));
        return null;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        buscaUsuario = null;
        usuarioAtual = null;
        isLogged = false;
        return "login";
    }

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public void setUsuarioAtual(Usuario usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(Boolean isLogged) {
        this.isLogged = isLogged;
    }

}
