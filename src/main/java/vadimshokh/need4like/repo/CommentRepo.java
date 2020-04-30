package vadimshokh.need4like.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vadimshokh.need4like.domain.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
