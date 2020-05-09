package vadimshokh.need4like.repo;

import vadimshokh.need4like.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
