/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import uff2017.reservasalas.dao.SolicitacaoDAO;
import uff2017.reservasalas.model.Solicitacao;

/**
 *
 * @author fabri
 */
@Named
@RequestScoped
public class CadastraSolicitacaoBean {

    private Solicitacao solicitacao = new Solicitacao();
    private SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
    
    
    public void cadastraSolicitacao() {

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

    
    
}
