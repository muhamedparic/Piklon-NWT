package ba.team12.articles.services;

import ba.team12.articles.Application;
import ba.team12.articles.models.Comment;
import ba.team12.articles.repositories.CommentRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public CommentService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void addCommentAsync(Comment comment) {
        Map<String, String> actionmap = new HashMap<>();
        actionmap.put("comment", comment.getComment());
        actionmap.put("user_id", Long.toString(comment.getUserId()));
        actionmap.put("article_id", Long.toString(comment.getArticleId()));
        rabbitTemplate.convertAndSend(Application.SFG_MESSAGE_QUEUE, actionmap);
    }

    public List<Comment> getAllComments() {
        return (List<Comment>) commentRepository.findAll();
    }

    public List<Comment> getCommentsByArticleId(Long id) {
        return (List<Comment>) commentRepository.findByArticleId(id);
    }

    public String addCommnet(Comment comment) {
            addCommentAsync(comment);
            return "{\"status\": \"" + "Comment is added" + "\"}";
    }

    public String deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new FileSystemNotFoundException("Comment not found"));
        commentRepository.delete(comment);
        return "Commend is deleted";
    }


}
