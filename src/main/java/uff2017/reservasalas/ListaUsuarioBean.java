/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import uff2017.reservasalas.dao.UsuarioDAO;
import uff2017.reservasalas.model.Espaco;
import uff2017.reservasalas.model.PerfilUsuario;
import uff2017.reservasalas.model.TipoUsuario;
import uff2017.reservasalas.model.Usuario;

/**
 *
 * @author fabri
 */
@Named
@SessionScoped
public class ListaUsuarioBean implements Serializable {

    private Usuario usuario = new Usuario();
    private Usuario usuarioBeforeEdit = null;
    private UsuarioDAO usuariodao = new UsuarioDAO();
    private ArrayList<Usuario> listaUsuarios;
    private boolean edit;
    private int idPerfil;
    private int idTipo;

    public void onload() {
        listaUsuario();
    }

    public void edit(Usuario item) {
        usuarioBeforeEdit = item.clone();
        this.usuario = item;
        edit = true;
    }

    public void cancelEdit() {
        this.usuario.restore(usuarioBeforeEdit);
        this.usuario = new Usuario();
        edit = false;
    }

    public void saveEdit() {            
        usuariodao.updateUsuario(usuario);        
        edit = false;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario editado com sucesso."));
    }

    public void delete(Usuario usuario) {
        usuariodao.deletarUsuario(usuario);
        listaUsuario();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario apagado com sucesso."));
    }

    public void listaUsuario() {
        listaUsuarios = usuariodao.listaUsuariosAtivos();
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public Usuario getUsuarioBeforeEdit() {
        return usuarioBeforeEdit;
    }

    public void setUsuarioBeforeEdit(Usuario usuarioBeforeEdit) {
        this.usuarioBeforeEdit = usuarioBeforeEdit;
    }

    public UsuarioDAO getUsuariodao() {
        return usuariodao;
    }

    public void setUsuariodao(UsuarioDAO usuariodao) {
        this.usuariodao = usuariodao;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
    

}
