package org.richfaces.tests;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity(name = "Member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "ClubMembers", 
    joinColumns = { @JoinColumn(name = "memberId") }, 
    inverseJoinColumns = { @JoinColumn(name = "clubId") })
    private ClubEntity club;

    public MemberEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClubEntity getClub() {
        return club;
    }

    public void setClub(ClubEntity club) {
        this.club = club;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }
    
    @Override
    public String toString() {
        return name + " " + club;
    }
}
