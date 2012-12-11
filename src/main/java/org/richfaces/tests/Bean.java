package org.richfaces.tests;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.solder.logging.Logger;

@Named
@SessionScoped
public class Bean implements Serializable {
	private static final long serialVersionUID = -5595424783844894530L;

	@Inject Logger log;
	
    @Inject private ClubEntityManager clubManager;
    
    private ClubEntity clubAlpha;
    private ClubEntity clubBeta;
    
    public void save() {
    	//log.info("Saving selected members");
    }

    public ClubEntity getAlphaClub() {
    	//log.info("Getting club Alpha");
    	
    	if (clubAlpha == null) {
    		clubAlpha = clubManager.getAlphaClub();
    	}
    	
    	return clubAlpha;
    }
    
    public ClubEntity getBetaClub() {
    	//log.info("Getting club Beta");
    	
    	if (clubBeta == null) {
    		clubBeta = clubManager.getBetaClub();
    	}
    	
    	return clubBeta;
    }
    
    public List<MemberEntity> getAllMembers() {
        return clubManager.getAllMembers();
    }

    public ClubEntityManager getClubManager() {
        return clubManager;
    }

    public void setClubManager(ClubEntityManager clubManager) {
        this.clubManager = clubManager;
    }
}
