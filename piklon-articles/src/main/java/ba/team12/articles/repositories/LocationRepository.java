package ba.team12.articles.repositories;

import ba.team12.articles.models.Location;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends PagingAndSortingRepository<Location, Long> {

    List<Location> findByName(String name);
    List<Location> findAllByOrderByName();
    List<Location> findByNameStartsWith(String name);
}
