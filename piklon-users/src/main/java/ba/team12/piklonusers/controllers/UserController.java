package ba.team12.piklonusers.controllers;


import ba.team12.piklonusers.models.Login;
import ba.team12.piklonusers.models.Token;
import ba.team12.piklonusers.models.User;
import ba.team12.piklonusers.repositories.TokenRepository;
import ba.team12.piklonusers.repositories.UserRepository;
import ba.team12.piklonusers.services.TokenService;
import ba.team12.piklonusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.FileSystemNotFoundException;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping(value="/insert")
    public String createUser(@Valid @RequestBody final User user) {
            return userService.createUser(user);
    }

    @PostMapping(value="/insertAdmin")
    public String createAdmin(@Valid @RequestBody final User user) {
        return userService.createAdmin(user);
    }

    @GetMapping(value="/getIdByUsername")
    public Long getIdByUsername(@RequestParam String username) {
        return userRepository.findByUsername(username).getId();
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable(name = "id") Long id) throws ChangeSetPersister.NotFoundException{
        return userRepository.findById(id).orElseThrow(() -> new FileSystemNotFoundException("User not found"));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNote(@RequestHeader("token") String token,@PathVariable(value = "id") Long id) throws ChangeSetPersister.NotFoundException {
        return userService.deleteUser(id, token);
    }

    @PostMapping("/login")
    public String Login(@Valid @RequestBody Login login) {
        return userService.loginUser(login);
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



}
