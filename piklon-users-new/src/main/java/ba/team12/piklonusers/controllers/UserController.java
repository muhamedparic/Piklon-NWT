package ba.team12.piklonusers.controllers;


import ba.team12.piklonusers.models.Login;
import ba.team12.piklonusers.models.Token;
import ba.team12.piklonusers.models.User;
import ba.team12.piklonusers.repositories.TokenRepository;
import ba.team12.piklonusers.repositories.UserRepository;
import ba.team12.piklonusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
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

    @GetMapping("/all")
    public List<User> getAll(){
        return (List<User>) userRepository.findAll();
    }

    @PostMapping(value="/insert")
    public User createUser(@Valid @RequestBody final User user){
            return userRepository.save(user);
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable(name = "id") Long id) throws ChangeSetPersister.NotFoundException{
        return userRepository.findById(id).orElseThrow(() -> new FileSystemNotFoundException("User not found"));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNote(@PathVariable(value = "id") Long id) throws ChangeSetPersister.NotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new FileSystemNotFoundException("User not found"));
        userRepository.delete(user);
        return "User is deleted";
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody String login) {
        List<String> logindata= Arrays.asList(login.split(","));
        User user = (User) userRepository.findByUsername(logindata.get(0));
        String token = randomString(30);
        if (user.getPassword_hash().equals(logindata.get(1))) {
            Token t = new Token();
            t.setUser_id(user.getId());
            t.setUser_token(token);
            t.setExpiration_date(getExpirationDate());
            //Token t_past = tokenRepository.findByUser_id(user.getId());
            //tokenRepository.delete(t_past);
            tokenRepository.save(t);
            return token;
        }
        else return "false";
       // return logindata.get(0);
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
