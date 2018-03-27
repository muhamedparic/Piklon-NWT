package ba.team12.articles.controllers;

import ba.team12.articles.models.Article;
import ba.team12.articles.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles/{id}")
    public ResponseEntity findById(@PathVariable(name = "id") Long id) {
        Article article = articleService.findById(id);

        if (article != null)
            return ResponseEntity.ok(article);
        else
            return ResponseEntity.ok("null");
    }

    @RequestMapping(value = "/articles/search", method = RequestMethod.POST)
    public ResponseEntity search(@RequestParam(name = "query") String query) {
        List<Article> articles = articleService.search(query);

        if (articles != null)
            return ResponseEntity.ok(articles);
        else
            return ResponseEntity.ok("null");
    }

    @RequestMapping(value = "/articles/all_from_category", method = RequestMethod.POST)
    public ResponseEntity findByCategory(@RequestParam(name = "category") String category) {
        List<Article> articles = articleService.findByCategory(category);

        if (articles != null)
            return ResponseEntity.ok(articles);
        else
            return ResponseEntity.ok("null");
    }

    @RequestMapping(value = "/articles/all_from_category_and_location", method = RequestMethod.POST)
    public ResponseEntity findByCategoryAndLocation(@RequestParam(name = "category") String category,
                                                    @RequestParam(name = "location") String location) {
        List<Article> articles = articleService.findByCategoryAndLocation(category, location);

        if (articles != null)
            return ResponseEntity.ok(articles);
        else
            return ResponseEntity.ok("null");
    }
}
