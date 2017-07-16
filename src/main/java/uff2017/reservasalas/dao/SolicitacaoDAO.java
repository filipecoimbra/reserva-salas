/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas.dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import uff2017.reservasalas.Database;
import uff2017.reservasalas.model.Solicitacao;
import uff2017.reservasalas.model.Usuario;

/**
 *
 * @author fabri
 */
public class SolicitacaoDAO {

    private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("Solicitacao");
    private EntityManager em = factory.createEntityManager();

    public Solicitacao getSolicitacao(String nomeSolicitacao, String senha) {

        try {
            Solicitacao solicitacao = (Solicitacao) em
                    .createQuery(
                            "SELECT u from Solicitacao u where u.nomeSolicitacao = :name and u.senha = :senha")
                    .setParameter("name", nomeSolicitacao)
                    .setParameter("senha", senha).getSingleResult();

            return solicitacao;
        } catch (NoResultException e) {
            return null;
        }
    }

    public ArrayList<Solicitacao> listaSolicitacoesAtivas() {

        try {
            ArrayList<Solicitacao> solicitacoes = (ArrayList<Solicitacao>) em.createQuery(
                    "SELECT s from Solicitacao s "
                    + " inner join s.evento as eve "
                    + " inner join s.usuario as usu "
                    + " where eve.isAprovado = 0 and eve.ativo = 1").getResultList();
            return solicitacoes;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void cadastrarSolicitacao(Solicitacao solicitacao) {
        Database db = new Database();
        db.executePersist(em, solicitacao);

    }

    public void updateSolicitacao(Solicitacao solicitacao) {
        Database db = new Database();
        db.executeUpdate(em, solicitacao);
    }

    public void deletarSolicitacao(Solicitacao solicitacao) {
        Database db = new Database();
        db.executeDelete(em, solicitacao);
    }
}
