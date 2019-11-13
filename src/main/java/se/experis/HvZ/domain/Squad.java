package se.experis.HvZ.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "squad")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long squadId;

    @Column(length=255)
    private String name;

    @Column(name="is_human")
    private boolean isHuman = true;

    //-----------------------Relations-----------------------------------//

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gameId")
    private Game game;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "squad")
    @JsonIgnore
    private SquadCreate squadCreate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "squad")
    @JsonIgnore
    private List<Chat> chats;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "squad")
    @JsonIgnore
    private List<SquadMember> squadMembers;

    //-----------------------Constructors-----------------------------------//

    public Squad() {
    }

    public Squad(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    //-----------------------Getters and Setters-----------------------------------//

    public Long getSquadId() {
        return squadId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public SquadCreate getSquadCreate() {
        return squadCreate;
    }

    public void setSquadCreate(SquadCreate squadCreate) {
        this.squadCreate = squadCreate;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

    public List<SquadMember> getSquadMembers() {
        return squadMembers;
    }

    public void setSquadMembers(List<SquadMember> squadMembers) {
        this.squadMembers = squadMembers;
    }
}
