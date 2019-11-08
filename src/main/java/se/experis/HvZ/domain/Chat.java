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

    @Column(length = 255)
    private String time;

    //-----------------------Relations-----------------------------------//

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gameId")
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "squadId")
    private Squad squad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playerId")
    private Player player;

    //-----------------------Constructors-----------------------------------//

    public Chat() {
    }

    public Chat(String message, boolean isHumanGlobal, boolean isZombieGlobal, Game game, Player player) {
        this.message = message;
        this.isHumanGlobal = isHumanGlobal;
        this.isZombieGlobal = isZombieGlobal;
        this.game = game;
        this.player = player;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.time = dtf.format(now);
    }

    public Chat(String message, boolean isHumanGlobal, boolean isZombieGlobal, Game game, Squad squad, Player player) {
        this.message = message;
        this.isHumanGlobal = isHumanGlobal;
        this.isZombieGlobal = isZombieGlobal;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.time = dtf.format(now);
        this.game = game;
        this.squad = squad;
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

    public String getTime() {
        return time;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
