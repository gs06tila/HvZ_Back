package se.experis.HvZ.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Date;

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
    private boolean isHumanVisible;

    @Column()
    private boolean isZombieVisible;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(precision=9, scale=6)
    private Double longX;

    @Column(precision=8, scale=6)
    private Double latX;

    // gameId (FK)


    public Mission() {
    }

    public Mission(String name, boolean isHumanVisible, boolean isZombieVisible, String description, Date startDate, Date endDate, Double longX, Double latX) {
        this.name = name;
        this.isHumanVisible = isHumanVisible;
        this.isZombieVisible = isZombieVisible;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.longX = longX;
        this.latX = latX;
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
        return isHumanVisible;
    }

    public void setHumanVisible(boolean humanVisible) {
        isHumanVisible = humanVisible;
    }

    public boolean isZombieVisible() {
        return isZombieVisible;
    }

    public void setZombieVisible(boolean zombieVisible) {
        isZombieVisible = zombieVisible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}