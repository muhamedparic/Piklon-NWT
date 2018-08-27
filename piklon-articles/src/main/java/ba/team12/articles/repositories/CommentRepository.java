package ba.team12.articles.repositories;

import ba.team12.articles.models.Article;
import ba.team12.articles.models.Category;
import ba.team12.articles.models.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    List<Comment> findByArticleId(Long id);

}
