package ba.team12.articles.controllers;

import ba.team12.articles.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/images/all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(imageService.findAll());
    }
}