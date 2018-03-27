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
    public void save(Category category) {
        categoryRepository.save(category);
    }
}