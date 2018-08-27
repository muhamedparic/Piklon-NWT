package ba.team12.articles.listeners;

import ba.team12.articles.models.Comment;
import ba.team12.articles.repositories.CommentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class AddCommentListener {

    @Autowired
    CommentRepository commentRepository;

    private static final Logger log = LogManager.getLogger(AddCommentListener.class);

    public AddCommentListener(){ }

    public void receiveMessage(Map<String, String> message) {
        log.info("Received <" + message + ">");
        String c = String.valueOf(message.get("comment"));
        Long user_id = Long.valueOf(message.get("user_id"));
        Long article_id = Long.valueOf(message.get("article_id"));
        Comment comment = new Comment();
        comment.setUserId(user_id); comment.setArticleId(article_id); comment.setComment(c);
        commentRepository.save(comment);
        log.info("Comment added...");
    }
}
