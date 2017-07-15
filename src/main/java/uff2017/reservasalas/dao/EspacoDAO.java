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
import uff2017.reservasalas.model.Espaco;

/**
 *
 * @author fabri
 */
public class EspacoDAO {

    private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("Espaco");
    private EntityManager em = factory.createEntityManager();

    public Espaco getEspaco(String nomeEspaco, String senha) {

        try {
            Espaco espaco = (Espaco) em
                    .createQuery(
                            "SELECT u from Espaco u where u.nomeEspaco = :name and u.senha = :senha")
                    .setParameter("name", nomeEspaco)
                    .setParameter("senha", senha).getSingleResult();

            return espaco;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean cadastrarEspaco(Espaco espaco) {
        try {
            em.persist(espaco);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletarEspaco(Espaco espaco) {
        try {
            em.remove(espaco);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
