package ba.team12.articles.services;

import ba.team12.articles.models.Category;
import ba.team12.articles.models.ExtraInfoType;
import ba.team12.articles.repositories.ExtraInfoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraInfoTypeService {

    @Autowired
    private ExtraInfoTypeRepository extraInfoTypeRepository;

    @Autowired
    private CategoryService categoryService;

    public List<ExtraInfoType> findByCategory(String categoryName) {
        List<Category> categories = categoryService.search(categoryName);
        if (categories.size() > 0)
            return extraInfoTypeRepository.findByCategory(categories.get(0));
        else
            return null;
    }

    public List<ExtraInfoType> findByName(String name) {
        return extraInfoTypeRepository.findByName(name);
    }
}
