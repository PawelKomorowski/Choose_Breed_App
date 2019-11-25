package chooseBreed.backend.db.repositories;

import chooseBreed.backend.db.model.LivelihoodCost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivelihoodCostRepository extends JpaRepository<LivelihoodCost, Integer> {
}
