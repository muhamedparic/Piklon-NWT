package ba.team12.articles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

//    @Autowired
//    private ArticleService articleService;

    @RequestMapping("/articles/{id}")
    public ResponseEntity getArticle(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(articleService.getArticleById(id));
    }
}
