/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import uff2017.reservasalas.dao.EventoDAO;
import uff2017.reservasalas.dao.UsuarioDAO;
import uff2017.reservasalas.model.Espaco;
import uff2017.reservasalas.model.Evento;
import uff2017.reservasalas.model.Usuario;

/**
 *
 * @author fabri
 */
@Named
@SessionScoped
public class ListaEventoBean implements Serializable {

    private ArrayList<Evento> listaEventos = new ArrayList<Evento>();
    private EventoDAO eventoDAO = new EventoDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Evento evento = new Evento();
    private Evento eventoBeforeEdit = null;
    private Usuario usuario = new Usuario();
    private boolean edit;
    private int idUsuario;

    public void onload() {
        listarEventos();
    }

    public void listarEventos() {
        listaEventos = eventoDAO.listarEventosAprovados();
    }

    public void delete(Evento evento) {
        eventoDAO.deletarEvento(evento);
        listarEventos();
    }

    public void inscrever(Evento item) {
        eventoBeforeEdit = item.clone();
        this.evento = item;
        edit = true;
    }

    public void cancelInscrever() {
        evento.restore(eventoBeforeEdit);
        this.evento = new Evento();
        edit = false;
    }

    public void saveInscrever() {
        // ADICIONAR O USUARIO AO EVENTO

        usuario = usuarioDAO.getUsuario(idUsuario);

        if (usuario == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario nao existe."));
            return;
        }

        boolean inserir = false;
        for (int i = 0; i < evento.getTiposUsuarioPermitidos().size(); i++) {
            if (usuario.getTipoUsuario().getIdTipoUsuario() == evento.getTiposUsuarioPermitidos().get(i).getIdTipoUsuario()) {
                inserir = true;
            }
        }

        if (inserir) {
            evento = eventoDAO.getEvento(evento.getIdEvento());
            if (evento.getUsuariosInscritos().size() < evento.getMaxParticipantes()) {
                evento.getUsuariosInscritos().add(usuario);                
                eventoDAO.updateEvento(evento);
                this.evento = new Evento();
                edit = false;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario inscrito com sucesso."));                
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evento lotado."));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario nao pode participar do evento, pois seu tipo nao esta habilitado para participar."));
        }

    }

    public ArrayList<Evento> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(ArrayList<Evento> listaEspacos) {
        this.listaEventos = listaEspacos;
    }

    public EventoDAO getEventoDAO() {
        return eventoDAO;
    }

    public void setEventoDAO(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Evento getEventoBeforeEdit() {
        return eventoBeforeEdit;
    }

    public void setEventoBeforeEdit(Evento eventoBeforeEdit) {
        this.eventoBeforeEdit = eventoBeforeEdit;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }   

}
