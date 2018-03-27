package ba.team12.articles.repositories;

import ba.team12.articles.models.Category;
import ba.team12.articles.models.ExtraInfoType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtraInfoTypeRepository extends PagingAndSortingRepository<ExtraInfoType, Long> {

    List<ExtraInfoType> findByName(String name);
    List<ExtraInfoType> findByCategory(Category category);
}
