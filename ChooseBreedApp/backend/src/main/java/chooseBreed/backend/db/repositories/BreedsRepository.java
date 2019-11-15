package chooseBreed.backend.db.repositories;

import chooseBreed.backend.db.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedsRepository extends JpaRepository<Breed, String> {
}
