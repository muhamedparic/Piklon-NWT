package ba.team12.articles.services;

import ba.team12.articles.models.Article;
import ba.team12.articles.models.Category;
import ba.team12.articles.models.Location;
import ba.team12.articles.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LocationService locationService;

    public Article findById(Long id) {
        Optional<Article> article = articleRepository.findById(id);

        if (article.isPresent())
            return article.get();
        else
            return null;
    }

    public List<Article> search(String query) {
        return articleRepository.findByNameContaining(query);
    }

    public List<Article> findByCategory(String category) {
        List<Category> categories = categoryService.search(category);

        if (categories.size() == 1)
            return articleRepository.findByCategory(categories.get(0));
        else
            return null;
    }

    public List<Article> findByCategoryAndLocation(String category, String locationName) {
        List<Category> categories = categoryService.search(category);
        Location location = locationService.findByExactName(locationName);

        if (categories.size() == 1 && location != null)
            return articleRepository.findByCategoryAndLocation(categories.get(0), location);
        else
            return null;
    }

    public List<Article>findByUserid(Long id){
        return articleRepository.findByUserId(id);
    }

    public  void saveArticle(Article article){
        articleRepository.save(article);
    }

    public  void deleteByID(Long l) {
        articleRepository.deleteById(l);
    }

}
