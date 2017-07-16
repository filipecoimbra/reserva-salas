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
import uff2017.reservasalas.model.PerfilUsuario;

/**
 *
 * @author fabri
 */
public class PerfilUsuarioDAO {

    private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("PerfilUsuario");
    private EntityManager em = factory.createEntityManager();

    public PerfilUsuario getPerfilUsuario(int id) {

        try {
            PerfilUsuario perfilusuario = (PerfilUsuario) em
                    .createQuery(
                            "SELECT u from PerfilUsuario u where u.idPerfilUsuario = :id")
                    .setParameter("id", id).getSingleResult();

            return perfilusuario;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void cadastrarPerfilUsuario(PerfilUsuario perfilusuario) {
        Database db = new Database();
        db.executePersist(em, perfilusuario);

    }

    public void updatePerfilUsuario(PerfilUsuario perfilusuario) {
        Database db = new Database();
        db.executeUpdate(em, perfilusuario);
    }

    public void deletarPerfilUsuario(PerfilUsuario perfilusuario) {
        Database db = new Database();
        db.executeDelete(em, perfilusuario);
    }

}
