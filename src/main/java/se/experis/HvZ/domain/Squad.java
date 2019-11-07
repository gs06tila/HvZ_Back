package se.experis.HvZ.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "squad")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long squadId;

    @Column(length=255)
    private String name;

    @Column(name="is_human")
    private boolean isHuman;

    //gameId (FK)

    public Squad() {
    }

    public Squad(String name) {
        this.name = name;
        this.isHuman = true;
    }

    public Long getSquadId() {
        return squadId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }
}
