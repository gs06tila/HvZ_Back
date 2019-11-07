package se.experis.HvZ.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="death")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Death {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deathId;

    @Column(length = 255)
    private String timeOfDeath;

    @Column(precision=8, scale=6)
    private Double lat;

    @Column(precision=9, scale=6)
    private Double lng;

    //-----------------------Relations-----------------------------------//

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gameId")
    private Game game;

    // killerId (FK)
    // victimId (FK)


    public Death() {
    }

    public Death(Double lat, Double lng, Game game) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.timeOfDeath = timeOfDeath;
        this.lat = lat;
        this.lng = lng;
        this.game = game;
    }

//-----------------GETTERS AND SETTERS------------------------------//

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Long getDeathId() {
        return deathId;
    }

    public String getTimeOfDeath() {
        return timeOfDeath;
    }

    public void setTimeOfDeath(String timeOfDeath) {
        this.timeOfDeath = timeOfDeath;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
