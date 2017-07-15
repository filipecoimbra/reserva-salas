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
import uff2017.reservasalas.model.Usuario;

/**
 *
 * @author fabri
 */
public class UsuarioDAO {
    private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("Usuario");
    private EntityManager em = factory.createEntityManager();

    public Usuario getUsuario(String nomeUsuario, String senha) {

        try {
            Usuario usuario = (Usuario) em
                    .createQuery(
                            "SELECT u from Usuario u where u.nomeUsuario = :name and u.senha = :senha")
                    .setParameter("name", nomeUsuario)
                    .setParameter("senha", senha).getSingleResult();

            return usuario;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void cadastrarUsuario(Usuario usuario) {
        Database db = new Database();
        db.executePersist(em, usuario);

    }

    public void updateUsuario(Usuario usuario) {
        Database db = new Database();
        db.executeUpdate(em, usuario);
    }

    public void deletarUsuario(Usuario usuario) {
        Database db = new Database();
        db.executeDelete(em, usuario);
    }
}
