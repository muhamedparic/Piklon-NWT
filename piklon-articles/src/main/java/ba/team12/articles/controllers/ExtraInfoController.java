package ba.team12.articles.controllers;

import ba.team12.articles.models.ExtraInfo;
import ba.team12.articles.models.Location;
import ba.team12.articles.services.ExtraInfoService;
import ba.team12.articles.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ExtraInfoController {

    @Autowired
    private ExtraInfoService extraInfoService;

    @GetMapping("/extra_infos/search/{query}")
    public ResponseEntity search(@PathVariable(value = "query") String query) {
        return ResponseEntity.ok(extraInfoService.findByValue(query));
    }

}