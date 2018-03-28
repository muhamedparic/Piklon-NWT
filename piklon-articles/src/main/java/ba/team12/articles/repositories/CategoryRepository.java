package ba.team12.articles.repositories;

import ba.team12.articles.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    List<Category>findByNameStartsWith(String  name);
    List<Category>findAllByOrderByName();

}
