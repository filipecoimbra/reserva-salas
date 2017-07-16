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
import uff2017.reservasalas.model.Recurso;

/**
 *
 * @author fabri
 */
public class RecursoDAO {

    private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("Recurso");
    private EntityManager em = factory.createEntityManager();

    public Recurso getRecurso(String nomeRecurso, String senha) {

        try {
            Recurso recurso = (Recurso) em
                    .createQuery(
                            "SELECT u from Recurso u where u.nomeRecurso = :name and u.senha = :senha")
                    .setParameter("name", nomeRecurso)
                    .setParameter("senha", senha).getSingleResult();

            return recurso;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void cadastrarRecurso(Recurso recurso) {
        Database db = new Database();
        db.executePersist(em, recurso);

    }

    public void updateRecurso(Recurso recurso) {
        Database db = new Database();
        db.executeUpdate(em, recurso);
    }

    public void deletarRecurso(Recurso recurso) {
        Database db = new Database();
        db.executeDelete(em, recurso);
    }

}
