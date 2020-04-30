package vadimshokh.need4like.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vadimshokh.need4like.domain.Comment;
import vadimshokh.need4like.domain.User;
import vadimshokh.need4like.repo.CommentRepo;

@Service
public class CommentService {

    private final CommentRepo commentRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        commentRepo.save(comment);

        return comment;

    }
}
