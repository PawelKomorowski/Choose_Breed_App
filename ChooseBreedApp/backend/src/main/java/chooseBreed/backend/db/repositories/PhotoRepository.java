package chooseBreed.backend.db.repositories;

import chooseBreed.backend.db.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
}
