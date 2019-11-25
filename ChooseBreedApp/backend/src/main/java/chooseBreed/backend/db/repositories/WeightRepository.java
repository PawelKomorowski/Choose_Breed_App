package chooseBreed.backend.db.repositories;

import chooseBreed.backend.db.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightRepository extends JpaRepository<Weight, Integer> {
}
