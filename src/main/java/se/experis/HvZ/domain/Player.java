package se.experis.HvZ.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="player")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long playerId;

    @Column()
    private boolean isHuman;

    @Column()
    private boolean isPatientZero;

    @Column(length=255)
    private String biteCode;

    //-----------------------Relations-----------------------------------//

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonIgnore
    private GameUser gameUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gameId")
    private Game game;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
    @JsonIgnore
    private List<Chat> chats;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "killer")
    @JsonIgnore
    private List<Death> killers;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "victim")
    @JsonIgnore
    private Death victim;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "player")
    private SquadMember squadMember;


    //------------------Constructors-------------------------------//

    public Player() {
    }

    public Player(String biteCode, GameUser gameUser) {
        this.isHuman = true;
        this.isPatientZero = false;
        this.biteCode = biteCode;
        this.gameUser = gameUser;
    }

    public Player(String biteCode, GameUser gameUser, Game game) {
        this.isHuman = true;
        this.isPatientZero = false;
        this.biteCode = biteCode;
        this.gameUser = gameUser;
        this.game = game;
    }


    //-----------------GETTERS AND SETTERS------------------------------//


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameUser getGameUser() {
        return gameUser;
    }

    public void setGameUser(GameUser gameUser) {
        this.gameUser = gameUser;
    }


    public Long getPlayerId() {
        return playerId;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }

    public boolean isPatientZero() {
        return isPatientZero;
    }

    public void setPatientZero(boolean patientZero) {
        isPatientZero = patientZero;
    }

    public String getBiteCode() {
        return biteCode;
    }

    public void setBiteCode(String biteCode) {
        this.biteCode = biteCode;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

    public List<Death> getKillers() {
        return killers;
    }

    public void setKillers(List<Death> killers) {
        this.killers = killers;
    }

    public Death getVictim() {
        return victim;
    }

    public void setVictim(Death victim) {
        this.victim = victim;
    }

    public SquadMember getSquadMember() {
        return squadMember;
    }

    public void setSquadMember(SquadMember squadMember) {
        this.squadMember = squadMember;
    }
}
