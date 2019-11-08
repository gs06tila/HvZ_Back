package se.experis.HvZ.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

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

    //------------------Constructors-------------------------------//

    public Player() {
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
}
