package ba.team12.piklonusers.controllers;


import ba.team12.piklonusers.models.Login;
import ba.team12.piklonusers.models.Token;
import ba.team12.piklonusers.models.User;
import ba.team12.piklonusers.repositories.TokenRepository;
import ba.team12.piklonusers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.FileSystemNotFoundException;
import java.security.SecureRandom;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenRepository tokenRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<User> getAll(){
        return (List<User>) userRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/insert")
    public String createUser(@Valid @RequestBody final User user) {
            if (userRepository.findByUsername(user.getUsername()) == null) {
                user.setPassword_hash(Integer.toString(user.getPassword_hash().hashCode()));
                user.setIsAdmin("false");
                userRepository.save(user);
                return "{\"status\": \"" + "User is registered" + "\"}";
            }
            else return "{\"status\": \"" + "Invalid username" + "\"}";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/insertAdmin")
    public String createAdmin(@Valid @RequestBody final User user) {
        if (userRepository.findByUsername(user.getUsername()) == null) {
            user.setPassword_hash(Integer.toString(user.getPassword_hash().hashCode()));
            user.setIsAdmin("true");
            userRepository.save(user);
            return "{\"status\": \"" + "Admin is registered" + "\"}";
        }
        else return "{\"status\": \"" + "Invalid username" + "\"}";
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable(name = "id") Long id) throws ChangeSetPersister.NotFoundException{
        return userRepository.findById(id).orElseThrow(() -> new FileSystemNotFoundException("User not found"));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNote(@RequestHeader Token  tokenadminov,@PathVariable(value = "id") Long id) throws ChangeSetPersister.NotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new FileSystemNotFoundException("User not found"));
       if(tokenadminov.getUser_token().contains("admin")) {
           Token tokenuserov = tokenRepository.findByUserId(id);
           userRepository.delete(user);
           tokenRepository.delete(tokenuserov);
           return "User is deleted";
       }
       return "failed";
    }

    /*@PostMapping("/login")
    public String login(@Valid @RequestBody String login) {
        List<String> logindata= Arrays.asList(login.split(","));
        User user = (User) userRepository.findByUsername(logindata.get(0));
        if (user == null) return "Username not found";
        String token = randomString(30);
        if (user.getPassword_hash().equals(Integer.toString(logindata.get(1).hashCode()))) {
            Token t = new Token();
            t.setUser_id(user.getId());
            t.setUser_token(token);
            t.setExpiration_date(getExpirationDate());
            Token t_past = tokenRepository.findByUserId(user.getId());
            if (t_past != null) tokenRepository.delete(t_past);
            tokenRepository.save(t);
            return token;
        }
        else return "false";
       // return logindata.get(0);
    }*/
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public String Login(@Valid @RequestBody Login login) {
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
            tokenRepository.save(t);
            return "{\"token\": \"" + token + "\"}";
        }
        else return "{\"token\": \"" + "null" + "\"}";
        // return logindata.get(0);
    }

    @PostMapping("/checkAuthorization")
    public String checkAuthorize(@Valid @RequestBody Long id) {

        Token token = tokenRepository.findByUserId(id);

        if (checkAuthorization(token)) return "Authorized";
        else return "Not authorized";
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
