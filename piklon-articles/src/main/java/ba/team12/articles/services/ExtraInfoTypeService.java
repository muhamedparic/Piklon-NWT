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

    public List<ExtraInfoType> findByCategory(Category category) {
        return extraInfoTypeRepository.findByCategory(category);
    }

    public List<ExtraInfoType> findByName(String name) {
        return extraInfoTypeRepository.findByName(name);
    }
}
