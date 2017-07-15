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
import uff2017.reservasalas.model.TipoEvento;

/**
 *
 * @author fabri
 */
public class TipoEventoDAO {

    private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("TipoEvento");
    private EntityManager em = factory.createEntityManager();

    public TipoEvento getTipoEvento(String nomeTipoEvento, String senha) {

        try {
            TipoEvento tipoTipoEvento = (TipoEvento) em
                    .createQuery(
                            "SELECT u from TipoEvento u where u.nomeTipoEvento = :name and u.senha = :senha")
                    .setParameter("name", nomeTipoEvento)
                    .setParameter("senha", senha).getSingleResult();

            return tipoTipoEvento;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void cadastrarTipoEvento(TipoEvento tipoTipoEvento) {
        Database db = new Database();
        db.executePersist(em, tipoTipoEvento);

    }

    public void updateTipoEvento(TipoEvento tipoTipoEvento) {
        Database db = new Database();
        db.executeUpdate(em, tipoTipoEvento);
    }

    public void deletarTipoEvento(TipoEvento tipoTipoEvento) {
        Database db = new Database();
        db.executeDelete(em, tipoTipoEvento);
    }

}
