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
import uff2017.reservasalas.model.Evento;

/**
 *
 * @author fabri
 */
public class EspacoDAO {

    private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("Espaco");
    private EntityManager em = factory.createEntityManager();

    public Espaco getEspaco(int id) {

        try {
            Espaco espaco = (Espaco) em
                    .createQuery(
                            "SELECT u from Espaco u where espaco_id = :id")
                    .setParameter("id", id).getSingleResult();

            return espaco;
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw e;
        } finally {
            factory.close();
        }
    }

    public ArrayList<Espaco> listaEspacos() {

        try {
            ArrayList<Espaco> espaco = (ArrayList<Espaco>) em.createQuery("SELECT e from Espaco e where ativo=1").getResultList();
//                    .setParameter("name", nomeEspaco)
//                    .setParameter("senha", senha).getSingleResult();            
            return espaco;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void cadastrarEspaco(Espaco espaco) {
        espaco.setAtivo(true);
        Database db = new Database();
        db.executePersist(em, espaco);

    }

    public void updateEspaco(Espaco espaco) {
        espaco.setAtivo(true);
        Database db = new Database();
        db.executeUpdate(em, espaco);
    }

    public void deletarEspaco(Espaco espaco) {
        Database db = new Database();
        //db.executeDelete(em, espaco);
        espaco.setAtivo(false);
        db.executeUpdate(em, espaco);
    }

}
