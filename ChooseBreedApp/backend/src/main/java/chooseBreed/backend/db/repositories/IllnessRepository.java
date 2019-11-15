package chooseBreed.backend.db.repositories;

import chooseBreed.backend.db.model.Illness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IllnessRepository extends JpaRepository<Illness, Integer> {
}
