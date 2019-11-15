package se.experis.HvZ.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long tokenId;

    @Column(name="confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    //-------------------------Relations-------------------//

    @OneToOne(targetEntity = GameUser.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "userId")
    private GameUser user;

    //------------------------Constructor-----------------------//


    public ConfirmationToken() {
    }

    public ConfirmationToken(GameUser user) {
        this.user = user;
        this.createdDate = new Date();
        this.confirmationToken = UUID.randomUUID().toString();
    }

    //--------------------------------Get/Set-------------------------//

    public long getTokenId() {
        return tokenId;
    }

    public void setTokenId(long tokenId) {
        this.tokenId = tokenId;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public GameUser getUser() {
        return user;
    }

    public void setUser(GameUser user) {
        this.user = user;
    }
}
