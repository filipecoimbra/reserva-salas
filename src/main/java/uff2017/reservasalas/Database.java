/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author fabri
 */
public class Database {

    public void executePersist(EntityManager em, Object entity){
        
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
        
    }
    
    public void executeDelete(EntityManager em, Object entity){
        
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(entity);
        transaction.commit();
        
    }

    public void executeUpdate(EntityManager em, Object entity){
        
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(entity);
        transaction.commit();
        
    }
    
}
