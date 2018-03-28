package ba.team12.articles.controllers;


import ba.team12.articles.models.ExtraInfo;
import ba.team12.articles.models.Image;
import ba.team12.articles.services.ExtraInfoService;
import ba.team12.articles.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/images/all")
    public ResponseEntity findAll() {
        if(imageService.findAll().size()==0)return null;
        return ResponseEntity.ok(imageService.findAll());
    }


}