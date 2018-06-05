package ba.team12.articles.controllers;

import ba.team12.articles.models.Article;
import ba.team12.articles.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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
            return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/articles/search", method = RequestMethod.POST)
    public ResponseEntity search(@RequestParam(name = "query") String query) {
        List<Article> articles = articleService.search(query);

        if (articles != null)
            return ResponseEntity.ok(articles);
        else
            return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/articles/all_from_category", method = RequestMethod.POST)
    public ResponseEntity findByCategory(@RequestParam(name = "category") String category) {
        List<Article> articles = articleService.findByCategory(category);

        if (articles != null)
            return ResponseEntity.ok(articles);
        else
            return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/articles/all_from_category_and_location", method = RequestMethod.POST)
    public ResponseEntity findByCategoryAndLocation(@RequestParam(name = "category") String category,
                                                    @RequestParam(name = "location") String location) {
        List<Article> articles = articleService.findByCategoryAndLocation(category, location);

        if (articles != null)
            return ResponseEntity.ok(articles);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/userofday")
    public ResponseEntity<String> Userofday() {
        final String uri="http://localhost:8082/users/get/1";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<String> response=null;
        try{
            response=restTemplate.exchange(uri,
                    HttpMethod.GET, getHeaders(),String.class);
            System.out.println(response.getBody());
        }
        catch (Exception ex)
        {
            return ResponseEntity.ok("not ok");
        }


        return  ResponseEntity.ok("String");
    }

    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }


}
