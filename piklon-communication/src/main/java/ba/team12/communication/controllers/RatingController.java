package ba.team12.communication.controllers;

import ba.team12.communication.models.Rating;
import ba.team12.communication.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @RequestMapping(value = "/ratings/new_rating", method = RequestMethod.POST)
    public ResponseEntity newRating(@RequestParam(name = "userId", required = true) Long userId,
                                    @RequestParam(name = "sellerId", required = true) Long sellerId,
                                    @RequestParam(name = "rating", required = true) int rating,
                                    @RequestParam(name = "ratingDesc", required = false) String ratingDesc) {

        ratingService.createNewRating(userId, sellerId, rating, ratingDesc);
        return ResponseEntity.ok("WE RATED IT REDDIT");
    }

    @GetMapping("/posted_ratings")
    public ResponseEntity getAllPostedRatings(@RequestParam(name = "userId", required = true) Long userId) {

        List<Rating> ratings = ratingService.getAllSentRatings(userId);
        if (ratings.size() > 0)
            return ResponseEntity.ok(ratings);
        else
            return ResponseEntity.ok("not found");
    }

    @GetMapping("/received_ratings")
    public ResponseEntity getAllReceivedRatings(@RequestParam(name = "sellerId", required = true) Long sellerId) {

        List<Rating> ratings = ratingService.getAllReceivedRatings(sellerId);
        if (ratings.size() > 0)
            return ResponseEntity.ok(ratings);
        else
            return ResponseEntity.ok("not found");
    }
}
