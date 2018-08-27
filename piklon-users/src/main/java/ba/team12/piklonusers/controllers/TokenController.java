package ba.team12.piklonusers.controllers;

import ba.team12.piklonusers.models.Token;
import ba.team12.piklonusers.models.User;
import ba.team12.piklonusers.repositories.TokenRepository;
import ba.team12.piklonusers.repositories.UserRepository;
import ba.team12.piklonusers.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    TokenService tokenService;

    @GetMapping("/all")
    public List<Token> getAll(){
        return tokenService.getAllTokens();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNote(@PathVariable(value = "id") Long id) throws ChangeSetPersister.NotFoundException {
        Token token = tokenRepository.findById(id).orElseThrow(() -> new FileSystemNotFoundException("Token not found"));
        tokenRepository.delete(token);
        return "Token is deleted";
    }
}
