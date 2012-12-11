package org.richfaces.tests;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class Bean {

    @Inject
    private ClubEntiyManager clubManager;

    private List<MemberEntity> selectedMembers;

    public List<MemberEntity> getMembers() {
        ClubEntity club = clubManager.getClub();
        List<MemberEntity> members = club.getMembers();
        System.out.println(members.getClass());
        return members;
    }

    public List<MemberEntity> getSelectedMembers() {
        return selectedMembers;
    }

    public void setSelectedMembers(List<MemberEntity> selectedMembers) {
        this.selectedMembers = selectedMembers;
    }

    public ClubEntiyManager getClubManager() {
        return clubManager;
    }

    public void setClubManager(ClubEntiyManager clubManager) {
        this.clubManager = clubManager;
    }
}
