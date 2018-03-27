package ba.team12.articles.controllers;

import ba.team12.articles.services.ExtraInfoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtraInfoTypeController {

    @Autowired
    private ExtraInfoTypeService extraInfoTypeService;

    @GetMapping("extra_info_types/search")
    public ResponseEntity search(@RequestParam(value = "query") String query) {
        return ResponseEntity.ok(extraInfoTypeService.findByName(query));
    }
}
