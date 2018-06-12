package ba.team12.articles.controllers;

import ba.team12.articles.models.ExtraInfo;
import ba.team12.articles.services.ExtraInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExtraInfoController {

    @Autowired
    private ExtraInfoService extraInfoService;

    @GetMapping("/extra_infos/search/{query}")
    public ResponseEntity search(@PathVariable(value = "query") String query) {
        List < ExtraInfo > extraInfos = extraInfoService.findByValue(query);
        if (extraInfos != null)
            return ResponseEntity.ok(extraInfos);
        else
            return ResponseEntity.ok("null");
    }
}