package vadimshokh.need4like.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vadimshokh.need4like.domain.User;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
