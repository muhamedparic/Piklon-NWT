package ba.team12.piklonusers.models;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "user_id")
    Long user_id;

    @Column(name = "user_token")
    String userToken;

    @Column(name = "expiration_date")
    Date expiration_date;

    public Token(Long idToken, Long idUser, String token, Date datum) {
        id = idToken;
        user_id = idUser;
        userToken = token;
        expiration_date = datum;
    }

    public Token(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_token() {
        return userToken;
    }

    public void setUser_token(String user_token) {
        this.userToken = user_token;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }
}
