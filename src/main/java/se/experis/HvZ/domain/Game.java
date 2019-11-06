package se.experis.HvZ.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="game")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gameId;

    @Column(length = 255)
    private String name;

    @Column(length = 255)
    private String state;

    @Column(columnDefinition = "TEXT")
    private String longDescription;

    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    @Column(precision=9, scale=6)
    private Double longX;

    @Column(precision=9, scale=6)
    private Double longY;

    @Column(precision=8, scale=6)
    private Double latX;

    @Column(precision=8, scale=6)
    private Double latY;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    public Game() {
    }

    public Game(String name, String state, String longDescription, String shortDescription, Double longX, Double longY, Double latX, Double latY, Date startDate, Date endDate) {
        super();
        this.name = name;
        this.state = state;
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
        this.longX = longX;
        this.longY = longY;
        this.latX = latX;
        this.latY = latY;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
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
        return longX;
    }

    public void setLongX(Double longX) {
        this.longX = longX;
    }

    public Double getLongY() {
        return longY;
    }

    public void setLongY(Double longY) {
        this.longY = longY;
    }

    public Double getLatX() {
        return latX;
    }

    public void setLatX(Double latX) {
        this.latX = latX;
    }

    public Double getLatY() {
        return latY;
    }

    public void setLatY(Double latY) {
        this.latY = latY;
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
}
