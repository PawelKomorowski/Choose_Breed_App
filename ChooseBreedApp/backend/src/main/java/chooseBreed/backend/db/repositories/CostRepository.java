package chooseBreed.backend.db.repositories;

import chooseBreed.backend.db.model.Cost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostRepository extends JpaRepository<Cost, String> {
}
