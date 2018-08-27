package ba.team12.articles.repositories;

import ba.team12.articles.models.Article;
import ba.team12.articles.models.Category;
import ba.team12.articles.models.Location;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

    List<Article> findByCategory(Category category);
    List<Article> findByNameContaining(String name);
    List<Article> findByCategoryAndLocation(Category category, Location location);
    List<Article>findByUserId(Long id);


}
