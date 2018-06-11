package ba.team12.piklonusers.models;

import javax.persistence.Column;
import javax.persistence.Entity;

public class Login {
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
