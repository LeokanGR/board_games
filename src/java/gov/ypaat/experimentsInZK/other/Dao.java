/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.ypaat.experimentsInZK.other;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class Dao {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    

    public static EntityManager getEm() {
        emf = Persistence.createEntityManagerFactory("boardGamesPU");
        em = emf.createEntityManager();
        return em;
    }
    
    public static void closeAllConnections(){
        emf.close();
        em.close();
    }
}
