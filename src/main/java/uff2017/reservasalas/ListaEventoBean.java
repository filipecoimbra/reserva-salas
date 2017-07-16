/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import uff2017.reservasalas.dao.EventoDAO;
import uff2017.reservasalas.model.Evento;

/**
 *
 * @author fabri
 */
@Named
@SessionScoped
public class ListaEventoBean implements Serializable{

    private ArrayList<Evento> listaEventos = new ArrayList<Evento>();
    private EventoDAO eventoDAO = new EventoDAO();
    private Evento evento = new Evento();
    private Evento eventoBeforeEdit = null;
    private boolean edit;
    
    
    public void onload() {
        listarEventos();
    }

    public void listarEventos() {
        listaEventos = eventoDAO.listarEventosAprovados();
    }
    
    public void delete(Evento evento){
        eventoDAO.deletarEvento(evento);
        listarEventos();
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
