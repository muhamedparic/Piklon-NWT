package ba.team12.communication.services;

import ba.team12.communication.models.Rating;
import ba.team12.communication.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public void createNewRating(Long userId, Long sellerId, int rating, String ratingDesc) {
        ratingRepository.save(new Rating(userId, sellerId, rating, ratingDesc));
    }

    public List<Rating> getAllSentRatings(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    public List<Rating> getAllReceivedRatings(Long sellerId) {
        return ratingRepository.findBySellerId(sellerId);
    }
}
