package se.experis.HvZ.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="game")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameId;

    @Column(length = 255)
    private String name;

    @Column(length = 255)
    private StateType state = StateType.REGISTER;

    @Column(columnDefinition = "TEXT")
    private String longDescription;

    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    @Column(precision=9, scale=6)
    private Double lng;

    @Column(precision=8, scale=6)
    private Double lat;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    public enum StateType {
        REGISTER,
        IN_PROGRESS,
        COMPLETED
    }

    //-----------------Relations------------------------------//

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    @JsonIgnore
    private List<Death> deaths;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    @JsonIgnore
    private List<Player> players;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    @JsonIgnore
    private List<Chat> chats;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    @JsonIgnore
    private List<Mission> missions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    @JsonIgnore
    private List<Squad> squads;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    @JsonIgnore
    private List<SquadCreate> squadCreate;


    //-----------------Constructors------------------------------//

    public Game() {
    }

    public Game(String name, String longDescription, String shortDescription, Double lng, Double lat, Date startDate, Date endDate) {
        super();
        this.name = name;
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
        this.lng = lng;
        this.lat = lat;
        this.startDate = startDate;
        this.endDate = endDate;
    }



    //-----------------GETTERS AND SETTERS------------------------------//

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StateType getState() {
        return state;
    }

    public void setState(StateType state) {
        this.state = state;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Double getLongX() {
        return lng;
    }

    public void setLongX(Double lng) {
        this.lng = lng;
    }

    public Double getLatX() {
        return lat;
    }

    public void setLatX(Double lat) {
        this.lat = lat;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Death> getDeaths() {
        return deaths;
    }

    public void setDeaths(List<Death> deaths) {
        this.deaths = deaths;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;

    }

    public List<Squad> getSquads() {
        return squads;
    }

    public void setSquads(List<Squad> squads) {
        this.squads = squads;
    }

    public List<SquadCreate> getSquadCreate() {
        return squadCreate;
    }

    public void setSquadCreate(List<SquadCreate> squadCreate) {
        this.squadCreate = squadCreate;

    }
}
