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
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "squadMember")
    private SquadCreate squadCreate;

    //playerId (FK)

    //------------Constructors---------------//


    public SquadMember() {
    }

    public SquadMember(String rank) {
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

    public SquadCreate getSquadCreate() {
        return squadCreate;
    }

    public void setSquadCreate(SquadCreate squadCreate) {
        this.squadCreate = squadCreate;
    }
}
