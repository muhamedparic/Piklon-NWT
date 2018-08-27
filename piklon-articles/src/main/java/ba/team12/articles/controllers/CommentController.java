package ba.team12.articles.controllers;

import ba.team12.articles.models.Article;
import ba.team12.articles.models.Comment;
import ba.team12.articles.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/all")
    public ResponseEntity findById() {
        List<Comment> commentList = commentService.getAllComments();

        if (commentList != null)
            return ResponseEntity.ok(commentList);
        else
            return ResponseEntity.ok("null");
    }

    @PostMapping(value="comments/addComment")
    public String createComment(@Valid @RequestBody final Comment comment) {
        return commentService.addCommnet(comment);
    }

    @DeleteMapping("/comments/delete/{id}")
    public String deleteNote(@PathVariable(value = "id") Long id) throws ChangeSetPersister.NotFoundException {
        return commentService.deleteComment(id);
    }

    @GetMapping("/comments/article/{id}")
    public ResponseEntity findById(@PathVariable(value = "id") Long id) {
        List<Comment> commentList = commentService.getCommentsByArticleId(id);

        if (commentList != null)
            return ResponseEntity.ok(commentList);
        else
            return ResponseEntity.ok("null");
    }

}
