package ba.team12.communication.repositories;

import ba.team12.communication.models.PrivateMessage;
import ba.team12.communication.models.Rating;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends PagingAndSortingRepository<Rating, Long> {

    List<Rating> findByUserId(Long id);
    List<Rating> findBySellerId(Long id);
}
