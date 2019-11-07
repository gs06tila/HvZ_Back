package se.experis.HvZ.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="squadMember")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SquadMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long SquadMemberId;

    @Column(length=255)
    private String rank;

    //squadId (FK)
    //playerId (FK)
}
