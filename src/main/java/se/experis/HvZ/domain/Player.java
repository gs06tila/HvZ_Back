package se.experis.HvZ.domain;

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

    //userId (FK)

    // gameId (FK)


    public Player() {
    }

    public Player(String biteCode) {
        this.isHuman = true;
        this.isPatientZero = false;
        this.biteCode = biteCode;
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
