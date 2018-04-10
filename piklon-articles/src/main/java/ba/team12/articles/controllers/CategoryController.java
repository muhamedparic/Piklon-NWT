package ba.team12.articles.controllers;
import ba.team12.articles.models.Category;
import ba.team12.articles.models.Location;
import ba.team12.articles.services.CategoryService;
import ba.team12.articles.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/categories/all")
    public ResponseEntity findAll() {
        final String uri = "http://localhost:8080/locations/all";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<String> response=null;
        try{
            response=restTemplate.exchange(uri,
                    HttpMethod.GET, getHeaders(),String.class);
        }
        catch (Exception ex)
        {
            return ResponseEntity.ok("not ok");
        }
        System.out.println(response.getBody());
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/categories/search/{query}")
    public ResponseEntity search(@PathVariable(name = "query") String query) {
        List<Category>categories = categoryService.search(query);
        if (categories != null)
            return ResponseEntity.ok(categories);
        else
            return ResponseEntity.ok("null");
    }

    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }

}