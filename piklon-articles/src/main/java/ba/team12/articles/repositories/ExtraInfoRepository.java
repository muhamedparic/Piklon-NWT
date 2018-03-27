package ba.team12.articles.repositories;

import ba.team12.articles.models.ExtraInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtraInfoRepository extends PagingAndSortingRepository<ExtraInfo, Long> {

    List<ExtraInfo> findByValue(String  value);

}
