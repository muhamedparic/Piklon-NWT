package ba.team12.articles.controllers;
import ba.team12.articles.models.Category;
import ba.team12.articles.models.Location;
import ba.team12.articles.services.CategoryService;
import ba.team12.articles.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class CategoryController
{

    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/add_new_category/{name}")
    public ResponseEntity addNew(@RequestParam(name="name")String name) {
        categoryService.save(new Category(name));
        return ResponseEntity.ok("Added!");
    }

    @RequestMapping("/find_category/{name}")
    public ResponseEntity find(@PathVariable(name="name")String name) {
     if(categoryService.findByName(name).size()<1)return ResponseEntity.ok("Not found!");
        return ResponseEntity.ok(categoryService.findByName(name));
    }
}
