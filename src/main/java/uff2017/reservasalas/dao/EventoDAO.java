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
import uff2017.reservasalas.model.Evento;

/**
 *
 * @author fabri
 */
public class EventoDAO {

    public Evento getEvento(int id) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("Evento");
        EntityManager em = factory.createEntityManager();
        try {
            Evento evento = (Evento) em
                    .createQuery(
                            "SELECT u from Evento u where idEvento = :id")
                    .setParameter("id", id).getSingleResult();

            return evento;
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw e;
        } finally {
            factory.close();
        }
    }

    public void cadastrarEvento(Evento evento) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("Evento");
        EntityManager em = factory.createEntityManager();
        try {

            Database db = new Database();
            db.executePersist(em, evento);
        } catch (Exception e) {
            throw e;
        } finally {
            factory.close();
        }

    }

    public void updateEvento(Evento evento) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("Evento");
        try {
            EntityManager em = factory.createEntityManager();
            Database db = new Database();
            db.executeUpdate(em, evento);
        } catch (Exception e) {
            throw e;
        } finally {
            factory.close();
        }

    }

    public void deletarEvento(Evento evento) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("Evento");
        EntityManager em = factory.createEntityManager();
        try {
            evento.setAtivo(false);
            Database db = new Database();
            db.executeUpdate(em, evento);
        } catch (Exception e) {
            throw e;
        } finally {
            factory.close();
        }
    }

    public ArrayList<Evento> listarEventosAprovados() {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("Evento");
        EntityManager em = factory.createEntityManager();
        try {
            ArrayList<Evento> eventos = (ArrayList<Evento>) em.createQuery("SELECT e from Evento e where ativo=1 and isaprovado=1").getResultList();
//                    .setParameter("name", nomeEspaco)
//                    .setParameter("senha", senha).getSingleResult();            
            return eventos;
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw e;
        } finally {
            factory.close();
        }
    }

}
