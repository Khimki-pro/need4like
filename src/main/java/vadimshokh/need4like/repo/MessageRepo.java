package vadimshokh.need4like.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vadimshokh.need4like.domain.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
