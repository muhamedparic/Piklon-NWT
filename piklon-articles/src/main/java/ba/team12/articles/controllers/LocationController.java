package ba.team12.articles.controllers;

import ba.team12.articles.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations/all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(locationService.findAll());
    }

    @GetMapping("/locations/search/{query}")
    public ResponseEntity search(@PathVariable(name = "query") String query) {
        return ResponseEntity.ok(locationService.search(query));
    }
}
