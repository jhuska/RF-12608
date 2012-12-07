package org.richfaces.tests;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClubEntiyManager {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public ClubEntity getClub() {
        return (ClubEntity) em.createQuery("SELECT x FROM Club x").getSingleResult();
    }
}
