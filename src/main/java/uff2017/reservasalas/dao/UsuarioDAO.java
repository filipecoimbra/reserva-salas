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
import uff2017.reservasalas.model.Espaco;
import uff2017.reservasalas.model.Usuario;

/**
 *
 * @author fabri
 */
public class UsuarioDAO {
    private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("Usuario");
    private EntityManager em = factory.createEntityManager();

    public Usuario getUsuario(int id) {

        try {
            Usuario usuario = (Usuario) em
                    .createQuery(
                            "SELECT u from Usuario u "
                                    + " inner join u.perfilUsuario as perf "
                                    + " inner join u.tipoUsuario as tipo "
                                    + " where u.ativo = 1 and u.idUsuario = :id")
                    .setParameter("id", id).getSingleResult();
                    
            return usuario;
        } catch (NoResultException e) {
            return null;
        }
    }

    public ArrayList<Usuario> listaUsuariosAtivos() {

        try {
            ArrayList<Usuario> usuarios = (ArrayList<Usuario>) em.createQuery(
                            "SELECT u from Usuario u "
                                    + " inner join u.perfilUsuario as perf "
                                    + " inner join u.tipoUsuario as tipo "
                                    + " where u.ativo = 1").getResultList();
            return usuarios;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public void cadastrarUsuario(Usuario usuario) {
        usuario.setAtivo(true);
        Database db = new Database();
        db.executePersist(em, usuario);

    }

    public void updateUsuario(Usuario usuario) {
        Database db = new Database();
        db.executeUpdate(em, usuario);
    }

    public void deletarUsuario(Usuario usuario) {
        usuario.setAtivo(false);
        Database db = new Database();
        db.executeUpdate(em, usuario);
    }
}
