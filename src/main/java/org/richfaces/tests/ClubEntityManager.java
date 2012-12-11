package org.richfaces.tests;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
public class ClubEntityManager {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public ClubEntity getAlphaClub() {
    	return em.find(ClubEntity.class, 1l);
    }
    
    public ClubEntity getBetaClub() {
    	return em.find(ClubEntity.class, 2l);
    }
    
    @SuppressWarnings("unchecked")
	public List<MemberEntity> getAllMembers() {
    	return em.createQuery("SELECT m from Member m").getResultList();
    }
}
