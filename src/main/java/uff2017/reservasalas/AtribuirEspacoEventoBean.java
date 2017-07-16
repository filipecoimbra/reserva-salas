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
import uff2017.reservasalas.dao.EspacoDAO;
import uff2017.reservasalas.dao.EventoDAO;
import uff2017.reservasalas.model.Espaco;
import uff2017.reservasalas.model.Evento;

/**
 *
 * @author fabri
 */
@Named
@RequestScoped
public class AtribuirEspacoEventoBean {

    private Evento evento = new Evento();
    private Espaco espaco = new Espaco();
    private EspacoDAO espacodao = new EspacoDAO();
    private EventoDAO eventodao = new EventoDAO();
    private int espacoAssociado;
    private int eventoAssociado;

    public void atribuir() {

        try {
            evento = eventodao.getEvento(eventoAssociado);
            espaco = espacodao.getEspaco(espacoAssociado);
            evento.setEspaco(espaco);
            eventodao.updateEvento(evento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro ao cadastrar: " + e.getMessage()));
        }

    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public int getEspacoAssociado() {
        return espacoAssociado;
    }

    public void setEspacoAssociado(int espacoAssociado) {
        this.espacoAssociado = espacoAssociado;
    }

    public int getEventoAssociado() {
        return eventoAssociado;
    }

    public void setEventoAssociado(int eventoAssociado) {
        this.eventoAssociado = eventoAssociado;
    }

}
