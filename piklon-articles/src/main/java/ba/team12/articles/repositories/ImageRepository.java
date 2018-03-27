package ba.team12.articles.repositories;

import ba.team12.articles.models.Image;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {

    List<Image> findBydata(byte[] data);
    List<Image> findByIdi(Long id);

}
