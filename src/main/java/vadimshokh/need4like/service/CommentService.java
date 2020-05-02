package vadimshokh.need4like.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vadimshokh.need4like.domain.Comment;
import vadimshokh.need4like.domain.User;
import vadimshokh.need4like.domain.Views;
import vadimshokh.need4like.dto.EventType;
import vadimshokh.need4like.dto.ObjectType;
import vadimshokh.need4like.repo.CommentRepo;
import vadimshokh.need4like.util.WsSender;

import java.util.function.BiConsumer;

@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    public CommentService(CommentRepo commentRepo, WsSender wsSender) {
        this.commentRepo = commentRepo;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepo.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }
}