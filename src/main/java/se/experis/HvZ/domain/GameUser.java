package se.experis.HvZ.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;

@Entity
@Table(name="gameUser")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GameUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long userId;

    @Column(length=255)
    private String firstName;

    @Column(length=255)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(length=255)
    private String email;

    @Column(length = 255, unique = true)
    private String userName;

    @Column(length = 255)
    private String role = "user";

    //------------RELATIONS---------------------//

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "gameUser")
    private Player player;


    public GameUser() {
    }

    public GameUser(String firstName, String lastName, String password, String email, String userName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = hash(password);
        this.email = email;
        this.userName = userName;

    }


    //-------------GETTERS AND SETTERS--------//


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hash(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() { return userName; }

    public void setUserName(String userName) {this.userName = userName; }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }
}
