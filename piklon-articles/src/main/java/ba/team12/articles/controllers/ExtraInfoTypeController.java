package ba.team12.articles.controllers;

import ba.team12.articles.services.ExtraInfoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExtraInfoTypeController {

    @Autowired
    private ExtraInfoTypeService extraInfoTypeService;

    @RequestMapping(value = "/extra_info_types/search", method = RequestMethod.POST)
    public ResponseEntity search(@RequestParam(value = "query") String query) {
        return ResponseEntity.ok(extraInfoTypeService.findByName(query));
    }

    @RequestMapping(value = "/extra_info_types/find_by_category", method = RequestMethod.POST)
    public ResponseEntity findByCategory(@RequestParam(value = "category") String category) {
        return ResponseEntity.ok(extraInfoTypeService.findByCategory(category));
    }
}
