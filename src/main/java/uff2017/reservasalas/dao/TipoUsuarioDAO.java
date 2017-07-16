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
import uff2017.reservasalas.model.TipoUsuario;

/**
 *
 * @author fabri
 */
public class TipoUsuarioDAO {

    private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("TipoUsuario");
    private EntityManager em = factory.createEntityManager();

    public TipoUsuario getTipoUsuario(int id) {

        try {
            TipoUsuario tipoUsuario = (TipoUsuario) em
                    .createQuery(
                            "SELECT u from TipoUsuario u where u.idTipoUsuario = :id")
                    .setParameter("id", id).getSingleResult();

            return tipoUsuario;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void cadastrarTipoUsuario(TipoUsuario tipoUsuario) {
        Database db = new Database();
        db.executePersist(em, tipoUsuario);

    }

    public void updateTipoUsuario(TipoUsuario tipoUsuario) {
        Database db = new Database();
        db.executeUpdate(em, tipoUsuario);
    }

    public void deletarTipoUsuario(TipoUsuario tipoUsuario) {
        Database db = new Database();
        db.executeDelete(em, tipoUsuario);
    }

}
