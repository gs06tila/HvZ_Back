package se.experis.HvZ.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="mission")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long missionId;

    @Column(length=255)
    private String name;

    @Column()
    private boolean humanVisible;

    @Column()
    private boolean zombieVisible;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(precision=9, scale=6)
    private Double longX;

    @Column(precision=8, scale=6)
    private Double latX;

    @Column()
    private boolean completed = false;

    //----------RELATIONS------------//

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="gameId")
    private Game game;


    public Mission() {
    }

    public Mission(String name, boolean humanVisible, boolean zombieVisible, String description, Date endDate, Double longX, Double latX, Game game) {
        this.name = name;
        this.humanVisible = humanVisible;
        this.zombieVisible = zombieVisible;
        this.description = description;
        this.endDate = endDate;
        this.longX = longX;
        this.latX = latX;
        this.game = game;
    }

    public Long getMissionId() {
        return missionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHumanVisible() {
        return humanVisible;
    }

    public void setHumanVisible(boolean humanVisible) {
        this.humanVisible = humanVisible;
    }

    public boolean isZombieVisible() {
        return zombieVisible;
    }

    public void setZombieVisible(boolean zombieVisible) {
        this.zombieVisible = zombieVisible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getLongX() {
        return longX;
    }

    public void setLongX(Double longX) {
        this.longX = longX;
    }

    public Double getLatX() {
        return latX;
    }

    public void setLatX(Double latX) {
        this.latX = latX;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
