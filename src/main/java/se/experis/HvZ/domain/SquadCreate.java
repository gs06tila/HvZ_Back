package se.experis.HvZ.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name="squadCreate")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SquadCreate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long squadCreateId;

    @Column(length = 255)
    private String startTime;

    @Column(length = 255)
    private String endTime;

    @Column(precision=8, scale=6)
    private Double lat;

    @Column(precision=9, scale=6)
    private Double lng;

    // gameId (FK)
    // squadId (FK)
    // squadMemberId (FK)


    public SquadCreate() {
    }

    public SquadCreate(Double lat, Double lng) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.startTime = dtf.format(now);
        this.lat = lat;
        this.lng = lng;
    }

    public Long getSquadCreateId() {
        return squadCreateId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.endTime = dtf.format(now);
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
