package ba.team12.articles.controllers;
import ba.team12.articles.models.Category;
import ba.team12.articles.models.Location;
import ba.team12.articles.services.CategoryService;
import ba.team12.articles.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/categories/all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(categoryService.findAll());

    }


    @GetMapping("/categories/search/{query}")
    public ResponseEntity search(@PathVariable(name = "query") String query) {
        return ResponseEntity.ok(categoryService.search(query));
    }


}