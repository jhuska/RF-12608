package org.richfaces.tests;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "Club")
public class ClubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clubId;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ClubMembers", 
    	joinColumns = { @JoinColumn(name = "clubId", referencedColumnName="clubId") }, 
    	inverseJoinColumns = { @JoinColumn(name = "memberId", referencedColumnName="memberId") })
    private List<MemberEntity> members;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberEntity> getMembers() {
        return members;
    }

    public void setMembers(List<MemberEntity> members) {
        this.members = members;
    }

    public long getClubId() {
        return clubId;
    }

    public void setClubId(long clubId) {
        this.clubId = clubId;
    }

    @Override
    public String toString() {
        return name;
    }
}
