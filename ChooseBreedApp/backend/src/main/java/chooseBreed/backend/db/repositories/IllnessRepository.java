package chooseBreed.backend.db.repositories;

import chooseBreed.backend.db.model.Illness;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IllnessRepository extends JpaRepository<Illness, Integer> {
    List<Illness> findByName(String name);
}
