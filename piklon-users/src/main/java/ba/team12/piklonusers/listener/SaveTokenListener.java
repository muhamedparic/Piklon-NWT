package ba.team12.piklonusers.listener;

import ba.team12.piklonusers.models.Token;
import ba.team12.piklonusers.repositories.TokenRepository;
import ba.team12.piklonusers.services.TokenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Component
public class SaveTokenListener {

    @Autowired
    TokenRepository tokenRepository;

    private static final Logger log = LogManager.getLogger(SaveTokenListener.class);

    public SaveTokenListener(){ }

    public void receiveMessage(Map<String, String> message) {
        log.info("Received <" + message + ">");
        String token = String.valueOf(message.get("token"));
        Long user_id = Long.valueOf(message.get("user_id"));
        Date date = getExpirationDate();
        Token t = new Token(); t.setUser_id(user_id); t.setUser_token(token); t.setExpiration_date(date);
        tokenRepository.save(t);
        log.info("Token saved...");
    }

    private Date getExpirationDate() {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
        return dt;
    }
}
