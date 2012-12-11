package org.richfaces.tests;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
public class ClubEntiyManager {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public ClubEntity getClub() {
        return em.getReference(ClubEntity.class, 1l);
    }
}
