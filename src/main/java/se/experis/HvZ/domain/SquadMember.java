package se.experis.HvZ.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SquadId")
    private Squad squad;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="playerId")
    @JsonIgnore
    private Player player;

    //--------------- Constructors ----------------//


    public SquadMember() {
    }

    public SquadMember(String rank, Squad squad, Player player) {
        this.rank = rank;
        this.squad = squad;
        this.player = player;
    }

    //--------------- Get And Set ----------------------//


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

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
