/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.ypaat.sampleapp.other;

import gov.ypaat.neklib.other.AbstractDao;
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nekta
 */
@Stateless
public class Dao extends AbstractDao {

    @PersistenceContext(unitName = "as4adminPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()  {
        return em;
    }

    @Override
    public HashMap<String, EntityManager> getEmSet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
