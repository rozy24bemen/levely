package levely.repository;

import levely.model.Like;
import levely.model.keys.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, LikeId> {
}
