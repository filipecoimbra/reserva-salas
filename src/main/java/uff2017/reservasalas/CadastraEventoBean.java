/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import uff2017.reservasalas.dao.EventoDAO;
import uff2017.reservasalas.model.Evento;

/**
 *
 * @author fabri
 */
@Named
@RequestScoped
public class CadastraEventoBean {
    
    private Evento evento = new Evento();
    private EventoDAO eventoDAO = new EventoDAO();
         
    public void cadastraEvento(){
        this.evento.setIsAprovado(true);
        
        //TODO JPA Insert
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public EventoDAO getEventoDAO() {
        return eventoDAO;
    }

    public void setEventoDAO(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
    }
    
}
