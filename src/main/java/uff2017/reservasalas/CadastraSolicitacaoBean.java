/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import java.util.ArrayList;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import uff2017.reservasalas.dao.EventoDAO;
import uff2017.reservasalas.dao.SolicitacaoDAO;
import uff2017.reservasalas.model.Evento;
import uff2017.reservasalas.model.Solicitacao;
import uff2017.reservasalas.model.TipoUsuario;
import uff2017.reservasalas.model.Usuario;

/**
 *
 * @author fabri
 */
@Named
@RequestScoped
public class CadastraSolicitacaoBean {

    private Solicitacao solicitacao = new Solicitacao();
    private Evento evento = new Evento(); 
    private SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
    private EventoDAO eventoDAO = new EventoDAO();
    private Usuario usuario = new Usuario();
    private boolean alunograduacao;
    private boolean alunopos;
    private boolean docentes;

    public void cadastraSolicitacao() {

        evento.setIsAprovado(true);
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
                
        eventoDAO.cadastrarEvento(evento);      
        solicitacao.setUsuario(usuario);
        solicitacao.setEvento(evento);
        solicitacao.setData(new Date());
        solicitacaoDAO.cadastrarSolicitacao(solicitacao);
        
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public SolicitacaoDAO getSolicitacaoDAO() {
        return solicitacaoDAO;
    }

    public void setSolicitacaoDAO(SolicitacaoDAO solicitacaoDAO) {
        this.solicitacaoDAO = solicitacaoDAO;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
}
