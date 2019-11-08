package se.experis.HvZ.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="squadMember")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SquadMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long SquadMemberId;

    @Column(length=255)
    private String rank;

    //-----------Relations-----------------//
    //squadId (FK)
    //playerId (FK)

    //------------Constructors---------------//


    public SquadMember() {
    }

    public SquadMember(Long squadMemberId, String rank) {
        SquadMemberId = squadMemberId;
        this.rank = rank;
    }

    //--------------GetAndSet----------------------//


    public Long getSquadMemberId() {
        return SquadMemberId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
