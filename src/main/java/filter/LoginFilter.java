/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import controle.LoginControle;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulo
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        LoginControle session = (LoginControle) req.getSession().getAttribute("loginControle");
        String url = req.getRequestURI();

        if (session == null || !session.isLogged) {
            if (url.contains("cidade") || url.contains("cliente")
                    || url.contains("estado") || url.contains("filiais")
                    || url.contains("fornecedor") || url.contains("funcionario")
                    || url.contains("permissao") || url.contains("sistema")
                    || url.contains("statusservico") || url.contains("usuario")
                    || url.contains("venda") || url.contains("logout")) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (url.contains("login.xhtml")) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/logout.xhtml");
            } else if (url.contains("cidade") && !session.getUsuarioAtual().getPermissao().getCidade()) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/index.xhtml");
            } else if (url.contains("cliente") && !session.getUsuarioAtual().getPermissao().getCliente()) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/index.xhtml");
            } else if (url.contains("estado") && !session.getUsuarioAtual().getPermissao().getEstado()) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/index.xhtml");
            } else if (url.contains("filiais") && !session.getUsuarioAtual().getPermissao().getFiliais()) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/index.xhtml");
            } else if (url.contains("fornecedor") && !session.getUsuarioAtual().getPermissao().getFornecedor()) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/index.xhtml");
            } else if (url.contains("funcionario") && !session.getUsuarioAtual().getPermissao().getFuncionario()) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/index.xhtml");
            } else if (url.contains("permissao") && !session.getUsuarioAtual().getPermissao().getPermissao()) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/index.xhtml");
            } else if (url.contains("sistema") && !session.getUsuarioAtual().getPermissao().getSistema()) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/index.xhtml");
            } else if (url.contains("statusservico") && !session.getUsuarioAtual().getPermissao().getStatus_servico()) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/index.xhtml");
            } else if (url.contains("usuario") && !session.getUsuarioAtual().getPermissao().getUsuario()) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/index.xhtml");
            } else if (url.contains("venda") && !session.getUsuarioAtual().getPermissao().getVenda()) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/index.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }

}
