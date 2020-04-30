package vadimshokh.need4like.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import vadimshokh.need4like.domain.Message;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {
    @EntityGraph(attributePaths = { "comments" })
    List<Message> findAll();
}
