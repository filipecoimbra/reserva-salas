/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import uff2017.reservasalas.Database;
import uff2017.reservasalas.model.Evento;

/**
 *
 * @author fabri
 */
public class EventoDAO {

    private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("Evento");
    private EntityManager em = factory.createEntityManager();

    public Evento getEvento(String nomeEvento, String senha) {

        try {
            Evento evento = (Evento) em
                    .createQuery(
                            "SELECT u from Evento u where u.nomeEvento = :name and u.senha = :senha")
                    .setParameter("name", nomeEvento)
                    .setParameter("senha", senha).getSingleResult();

            return evento;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void cadastrarEvento(Evento evento) {
        Database db = new Database();
        db.executePersist(em, evento);

    }

    public void updateEvento(Evento evento) {
        Database db = new Database();
        db.executeUpdate(em, evento);
    }

    public void deletarEvento(Evento evento) {
        Database db = new Database();
        db.executeDelete(em, evento);
    }

}
