package ba.team12.piklonusers.services;

import ba.team12.piklonusers.PiklonUsersApplication;
import ba.team12.piklonusers.models.Token;
import ba.team12.piklonusers.repositories.TokenRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TokenService {
    @Autowired
    TokenRepository tokenRepository;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public TokenService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public List<Token> getAllTokens(){
        return (List<Token>) tokenRepository.findAll();
    }

    public void saveTokenAsync(Token t) {
        Map<String, String> actionmap = new HashMap<>();
        actionmap.put("user_id", Long.toString(t.getUser_id()));
        actionmap.put("token", t.getUser_token());
        rabbitTemplate.convertAndSend(PiklonUsersApplication.SFG_MESSAGE_QUEUE, actionmap);
    }
}
