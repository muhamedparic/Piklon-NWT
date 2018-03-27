package ba.team12.articles.controllers;

import ba.team12.articles.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles/{id}")
    public ResponseEntity findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(articleService.findById(id));
    }

    @RequestMapping(value = "/articles/search", method = RequestMethod.POST)
    public ResponseEntity search(@RequestParam(name = "query") String query) {
        return ResponseEntity.ok(articleService.search(query));
    }

    @RequestMapping(value = "/articles/all_from_category", method = RequestMethod.POST)
    public ResponseEntity findByCategory(@RequestParam(name = "category") String category) {
        return ResponseEntity.ok(articleService.findByCategory(category));
    }

    @RequestMapping(value = "/articles/all_from_category_and_location", method = RequestMethod.POST)
    public ResponseEntity findByCategoryAndLocation(@RequestParam(name = "category") String category,
                                                    @RequestParam(name = "location") String location) {
        return ResponseEntity.ok(articleService.findByCategoryAndLocation(category, location));
    }
}
