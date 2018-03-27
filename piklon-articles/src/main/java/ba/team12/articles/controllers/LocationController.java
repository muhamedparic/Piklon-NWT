package ba.team12.articles.controllers;

import ba.team12.articles.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations/all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(locationService.findAll());
    }

    @RequestMapping(value = "/locations/search", method = RequestMethod.POST)
    public ResponseEntity search(@RequestParam(name = "query") String query) {
        return ResponseEntity.ok(locationService.search(query));
    }
}
