package ba.team12.articles.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenDecrypter {
    String id;
    String userId;
    String userToken;
    String expiration_date;
    public TokenDecrypter(String id, String userId, String userToken, String expiration_date) {
        this.id = id;
        this.userId = userId;
        this.userToken = userToken;
        this.expiration_date = expiration_date;
    }


    public TokenDecrypter() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }



}
