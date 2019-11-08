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

    //-----------------Relations------------------------//
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gameId")
    private Game game;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "squadId")
    private Squad squad;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SquadMemberId")
    private SquadMember squadMember;

    //-------------------Constructors-------------------//

    public SquadCreate() {
    }

    public SquadCreate(Double lat, Double lng, Game game, Squad squad) {
    public SquadCreate(Double lat, Double lng, Game game, SquadMember squadMember) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.startTime = dtf.format(now);
        this.lat = lat;
        this.lng = lng;
        this.game = game;
        this.squad = squad;
        this.squadMember = squadMember;
    }
    //------------------------GetAndSet--------------//

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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public SquadMember getSquadMember() {
        return squadMember;
    }

    public void setSquadMember(SquadMember squadMember) {
        this.squadMember = squadMember;
    }
}
