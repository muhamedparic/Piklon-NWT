package ba.team12.articles.controllers;

import ba.team12.articles.models.ExtraInfo;
import ba.team12.articles.models.Location;
import ba.team12.articles.services.ExtraInfoService;
import ba.team12.articles.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class ExtraInfoController {

    @Autowired
    private ExtraInfoService extraInfoService;

    @GetMapping("/add_new_extrainfo")
    public ResponseEntity addNew() {
        extraInfoService.save(new ExtraInfo());
        return ResponseEntity.ok("Added!");
    }

    @GetMapping("/find_extrainfo")
    public ResponseEntity find() {
        List < ExtraInfo > locations = extraInfoService.findByvalue("extraInfo");

        if (locations.size() > 0)
            return ResponseEntity.ok(locations);
        else
            return ResponseEntity.ok("Not found!");
    }
}