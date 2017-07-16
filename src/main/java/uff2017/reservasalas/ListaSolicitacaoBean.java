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
import uff2017.reservasalas.dao.EventoDAO;
import uff2017.reservasalas.dao.SolicitacaoDAO;
import uff2017.reservasalas.model.Evento;
import uff2017.reservasalas.model.Solicitacao;

/**
 *
 * @author fabri
 */
@Named
@SessionScoped
public class ListaSolicitacaoBean implements Serializable {

    private ArrayList<Solicitacao> listaSolicitacoes = new ArrayList<Solicitacao>();
    private SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
    private EventoDAO eventoDAO = new EventoDAO();

    public void onload() {
        listaSolicitacao();
    }

    public void listaSolicitacao() {
        listaSolicitacoes = solicitacaoDAO.listaSolicitacoesAtivas();
    }

    public ArrayList<Solicitacao> getListaSolicitacoes() {
        return listaSolicitacoes;
    }

    public void setListaSolicitacoes(ArrayList<Solicitacao> listaSolicitacoes) {
        this.listaSolicitacoes = listaSolicitacoes;
    }

    public SolicitacaoDAO getSolicitacaoDAO() {
        return solicitacaoDAO;
    }

    public void setSolicitacaoDAO(SolicitacaoDAO solicitacaoDAO) {
        this.solicitacaoDAO = solicitacaoDAO;
    }

    public void aprovar(Solicitacao solic) {

        solic.getEvento().setIsAprovado(true);
        solic.getEvento().setAtivo(true);
        eventoDAO.updateEvento(solic.getEvento());
        listaSolicitacao();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Solicitacao aprovada com sucesso."));
    }

    public void reprovar(Solicitacao solic) {
        solic.getEvento().setIsAprovado(false);
        solic.getEvento().setAtivo(false);
        eventoDAO.deletarEvento(solic.getEvento());
        listaSolicitacao();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Solicitacao reprovada com sucesso."));
    }
}
