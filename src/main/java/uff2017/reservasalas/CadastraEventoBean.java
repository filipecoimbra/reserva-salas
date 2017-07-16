/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import uff2017.reservasalas.dao.EventoDAO;
import uff2017.reservasalas.dao.TipoUsuarioDAO;
import uff2017.reservasalas.model.Evento;
import uff2017.reservasalas.model.TipoUsuario;

/**
 *
 * @author fabri
 */
@Named
@RequestScoped
public class CadastraEventoBean {

    private Evento evento = new Evento();
    private EventoDAO eventoDAO = new EventoDAO();
    private TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
    private boolean alunograduacao;
    private boolean alunopos;
    private boolean docentes;

    public void cadastraEvento() {
        this.evento.setIsAprovado(true);
        evento.setAtivo(true);
        evento.setTiposUsuarioPermitidos(new ArrayList<TipoUsuario>());

        if (alunograduacao) {
            TipoUsuario alunoGrad = new TipoUsuario();
            alunoGrad.setIdTipoUsuario(1);
            evento.getTiposUsuarioPermitidos().add(alunoGrad);
        }
        if (alunopos) {
            TipoUsuario alunoPos = new TipoUsuario();
            alunoPos.setIdTipoUsuario(2);
            evento.getTiposUsuarioPermitidos().add(alunoPos);
        }
        if (docentes) {
            TipoUsuario docente = new TipoUsuario();
            docente.setIdTipoUsuario(3);
            evento.getTiposUsuarioPermitidos().add(docente);
        }

        //TODO JPA Insert
        if (Util.validaHora(evento.getHoraInicio()) && Util.validaHora(evento.getHoraFim())
                && !Util.hora1MaiorQue2(evento.getHoraInicio(), evento.getHoraFim())) {
            eventoDAO.cadastrarEvento(evento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados invalidos."));
        }

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

    public boolean isAlunograduacao() {
        return alunograduacao;
    }

    public void setAlunograduacao(boolean alunograduacao) {
        this.alunograduacao = alunograduacao;
    }

    public boolean isAlunopos() {
        return alunopos;
    }

    public void setAlunopos(boolean alunopos) {
        this.alunopos = alunopos;
    }

    public boolean isDocentes() {
        return docentes;
    }

    public void setDocentes(boolean docentes) {
        this.docentes = docentes;
    }

}
