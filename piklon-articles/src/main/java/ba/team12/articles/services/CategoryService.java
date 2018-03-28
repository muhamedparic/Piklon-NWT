package ba.team12.articles.services;

import ba.team12.articles.models.Category;
import ba.team12.articles.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;



    public List < Category > search(String name) {
        return categoryRepository.findByNameStartsWith(name);
    }


    public List < Category > findAll() {
        return categoryRepository.findAllByOrderByName();
    }

    public Category findByName(String name) {
        List<Category> categories = categoryRepository.findByNameStartsWith(name);

        if (categories.size() > 0)
            return categories.get(0);
        else
            return null;
    }


    public void save(Category category) {
        categoryRepository.save(category);
    }
}