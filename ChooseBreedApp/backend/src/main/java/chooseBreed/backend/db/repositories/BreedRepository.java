package chooseBreed.backend.db.repositories;

import chooseBreed.backend.db.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreedRepository extends JpaRepository<Breed, String> {

    List<Breed> findByName(String name);

}
