package chooseBreed.backend.db.repositories;

import chooseBreed.backend.db.model.Breed;
import chooseBreed.backend.db.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    List<Photo> findByBreed(Breed breed);
}
