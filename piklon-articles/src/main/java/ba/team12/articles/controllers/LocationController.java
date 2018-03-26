package ba.team12.articles.controllers;

import ba.team12.articles.models.Location;
import ba.team12.articles.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/add_new")
    public ResponseEntity addNew() {
        locationService.save(new Location("LocationName1"));
        return ResponseEntity.ok("Added!");
    }

    @GetMapping("/find")
    public ResponseEntity find() {
        List<Location> locations = locationService.findByName("LocationName1");

        if (locations.size() > 0)
            return ResponseEntity.ok(locations);
        else
            return ResponseEntity.ok("Not found!");
    }
}
