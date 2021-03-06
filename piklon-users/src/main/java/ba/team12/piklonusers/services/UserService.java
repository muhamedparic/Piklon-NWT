package ba.team12.piklonusers.services;

import ba.team12.piklonusers.models.Login;
import ba.team12.piklonusers.models.Token;
import ba.team12.piklonusers.models.User;
import ba.team12.piklonusers.repositories.TokenRepository;
import ba.team12.piklonusers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.nio.file.FileSystemNotFoundException;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    TokenService tokenService;

    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public String createUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) == null) {
            user.setPassword_hash(Integer.toString(user.getPassword_hash().hashCode()));
            user.setIsAdmin("false");
            userRepository.save(user);
            return "{\"status\": \"" + "User is registered" + "\"}";
        }
        else return "{\"status\": \"" + "Invalid username" + "\"}";
    }

    public String createAdmin(User user) {
        if (userRepository.findByUsername(user.getUsername()) == null) {
            user.setPassword_hash(Integer.toString(user.getPassword_hash().hashCode()));
            user.setIsAdmin("true");
            userRepository.save(user);
            return "{\"status\": \"" + "Admin is registered" + "\"}";
        }
        else return "{\"status\": \"" + "Invalid username" + "\"}";
    }

    public String deleteUser(Long id, String token) {
        User user = userRepository.findById(id).orElseThrow(() -> new FileSystemNotFoundException("User not found"));
        Token tokenadminov = tokenRepository.findByUserToken(token);
        if(token!=null) {
            if ((tokenadminov.getUser_token().contains("admin")) && (checkAuthorization(tokenadminov))) {
                Token tokenuserov = tokenRepository.findByUserId(id);
                userRepository.delete(user);
                tokenRepository.delete(tokenuserov);
                return "User is deleted";
            }
        }
        return "failed";
    }

    public String loginUser(Login login) {
        User user = (User) userRepository.findByUsername(login.getUsername());
        if (user == null) return "{\"token\": \"" + "Username not found" + "\"}";
        String token = "";
        if (user.getIsAdmin().equals("true")) {
            token = "admin" + randomString(25);
        }
        else {token = randomString(30);}
        if (user.getPassword_hash().equals(Integer.toString(login.getPassword().hashCode()))) {
            Token t = new Token();
            t.setUser_id(user.getId());
            t.setUser_token(token);
            t.setExpiration_date(getExpirationDate());
            Token t_past = tokenRepository.findByUserId(user.getId());
            if (t_past != null) tokenRepository.delete(t_past);
            //tokenRepository.save(t);
            //tokenService.saveTokenAsync(Long.toString(t.getId()), Long.toString(t.getUser_id()), t.getUser_token(), t.getExpiration_date().toString());
            tokenService.saveTokenAsync(t);
            return "{\"token\": \"" + token + "\"}";
        }
        else return "{\"token\": \"" + "null" + "\"}";
    }

    private boolean checkAuthorization(Token token) {
        Date expirationDate = token.getExpiration_date();
        Date now = new Date();
        if (expirationDate.compareTo(now) < 0)
            return false;
        else return true;
    }

    private static String randomString(int length) {
        char[] characterSet = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        Random random = new SecureRandom();
        char[] result = new char[length];
        for (int i = 0; i < result.length; i++) {
            int randomCharIndex = random.nextInt(characterSet.length);
            result[i] = characterSet[randomCharIndex];
        }
        return new String(result);
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
