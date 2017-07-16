/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import uff2017.reservasalas.dao.PerfilUsuarioDAO;
import uff2017.reservasalas.dao.UsuarioDAO;
import uff2017.reservasalas.model.PerfilUsuario;
import uff2017.reservasalas.model.TipoUsuario;
import uff2017.reservasalas.model.Usuario;

/**
 *
 * @author fabri
 */
@Named
@RequestScoped
public class CadastraUsuarioBean {

    private Usuario usuario = new Usuario();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private int idPerfil;
    private int idTipo;   

    public void cadastraUsuario() {
        usuario.setPerfilUsuario(new PerfilUsuario());
        usuario.setTipoUsuario(new TipoUsuario());
        usuario.getTipoUsuario().setIdTipoUsuario(idTipo);
        usuario.getPerfilUsuario().setIdPerfilUsuario(idPerfil);
        usuarioDAO.cadastrarUsuario(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso."));
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

}
