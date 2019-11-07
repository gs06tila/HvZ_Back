package se.experis.HvZ.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="chat")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long chatId;

    @Column(columnDefinition = "TEXT")
    private String message;

    @Column()
    private boolean isHumanGlobal;

    @Column()
    private boolean isZombieGlobal;

    @Column()
    private boolean isSquad;

    @Column(length = 255)
    private String time;

    //-----------------------Relations-----------------------------------//

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gameId")
    private Game game;

    // playerId (FK)
    // SquadId (FK)

    //-----------------------Constructors-----------------------------------//

    public Chat() {
    }

    public Chat(String message, boolean isHumanGlobal, boolean isZombieGlobal, boolean isSquad, Game game) {
        this.message = message;
        this.isHumanGlobal = isHumanGlobal;
        this.isZombieGlobal = isZombieGlobal;
        this.isSquad = isSquad;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.time = dtf.format(now);
        this.game = game;
    }

    //-----------------------Getters and Setters-----------------------------------//

    public Long getChatId() {
        return chatId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isHumanGlobal() {
        return isHumanGlobal;
    }

    public void setHumanGlobal(boolean humanGlobal) {
        isHumanGlobal = humanGlobal;
    }

    public boolean isZombieGlobal() {
        return isZombieGlobal;
    }

    public void setZombieGlobal(boolean zombieGlobal) {
        isZombieGlobal = zombieGlobal;
    }

    public boolean isSquad() {
        return isSquad;
    }

    public void setSquad(boolean squad) {
        isSquad = squad;
    }

    public String getTime() {
        return time;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
