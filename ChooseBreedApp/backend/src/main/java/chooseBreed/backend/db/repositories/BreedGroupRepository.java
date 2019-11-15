package chooseBreed.backend.db.repositories;

import chooseBreed.backend.db.model.BreedGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedGroupRepository extends JpaRepository<BreedGroup, Integer> {
}
